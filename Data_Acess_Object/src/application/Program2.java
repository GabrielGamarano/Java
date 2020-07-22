package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== Test 1: Department Find All =====");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}
		
		System.out.println("==== Test 2: Department find by Id =====");
		System.out.println("Enter the id: ");
		int id = sc.nextInt();
		Department dep = departmentDao.findById(id);
		System.out.println(dep);
		
		System.out.println("==== Test 3: Department Insert =====");
		System.out.println("Enter the New Department Name: ");
		String name = sc.next();
		Department newdep = new Department(null, name);
		departmentDao.insert(newdep);
		System.out.println("Inserted! New Department Id: "+ newdep.getId() + " Department Name: " + newdep.getName());
		
		System.out.println("==== Test 4: Delete Department by Id");
		System.out.println("Enter the Id:");
		int idd= sc.nextInt();
		departmentDao.deleteById(idd);
		System.out.println("Department DELETED");
		
		
	}
	
	
}
