package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		DepartmentDao dep = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById ===");
		Department depar = dep.findById(3);
		System.out.println(depar);
		
		System.out.println("=== TEST 2: department findAll ===");
		List<Department> list = dep.findAll();
		for(Department dp : list) {
			System.out.println(dp);
		}
		
		System.out.println("=== TEST 3: department insert ===");
		Department dp = new Department(null, "Motors");
		dep.insert(dp);
		System.out.println("New department inserted! Id: " + dp.getId());
		
	}

}
