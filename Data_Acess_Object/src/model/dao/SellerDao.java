package model.dao;

import java.util.List;

import model.entities.Department;
import model.entities.Seller;

public interface SellerDao {

	void insert(Seller odj);
	void update(Seller odj);
	void deleteById(Integer id);
	Seller findById(Integer id);
	
	List<Seller> findAll();
	List<Seller> findByDepartment(Department department);
	
}
