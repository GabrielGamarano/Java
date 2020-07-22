package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
				
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("==== TEST 1: Seller Find by Id ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n==== TEST 2: Seller Find by Department ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller odj : list) {
			System.out.println(odj);
		}
		
		System.out.println("\n==== TEST 3: Seller Find All ====");
		list = sellerDao.findAll();
		for (Seller odj : list) {
			System.out.println(odj);
		}
		
		/*System.out.println("\n==== TEST 4: Seller Insert ====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! new id = " + newSeller.getId());*/
		
		System.out.println("\n==== TEST 5: Seller UPDATE ====");
		seller = sellerDao.findById(8);
		seller.setName("Martha Waine");
		seller.setEmail("SaveMartha@gmail.com");
		sellerDao.update(seller);
		System.out.println("UPDATE COMPLETED");
		
		list = sellerDao.findAll();
		for (Seller odj : list) {
			System.out.println(odj);
		}
		
		System.out.println("\n==== TEST 6: Seller DELETE ====");
		System.out.println("Enter a Seller id to delete: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("DELETE COMPLETED");
		
		
	}
}
