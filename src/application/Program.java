package application;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("=== TEST 2: seller findByDepartment ===");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for(Seller s : list) {
			System.out.println(s);
		}
		
		System.out.println("=== TEST 3: seller findAll ===");
		List<Seller> list2 = sellerDao.findAll();
		for(Seller s : list2) {
			System.out.println(s);
		}
		
		System.out.println("=== TEST 4: seller insert ===");
		Seller seller1 = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, dep);
		sellerDao.insert(seller1);
		System.out.println("Inserted! New id = " + seller1.getId());
		
		System.out.println("=== TEST 5: seller update ===");
		Seller seller2 = sellerDao.findById(1);
		seller2.setName("Martha Waine");
		sellerDao.update(seller2);
		System.out.println("Update completed!");
		
		System.out.println("=== TEST 6: seller delete ===");
		System.out.print("Enter the id to delete: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}

}
