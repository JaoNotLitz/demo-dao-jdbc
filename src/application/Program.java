package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("TEST 1, FIND BY ID");
        Seller seller = sellerDao.findById(7);
        System.out.println(seller);
        System.out.println("TEST 2, FIND BY DEPARTMENT");
        Department department = new Department(2,null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj:list){
            System.out.println(obj);
        }
        System.out.println("TEST NUMBER 3, FIND ALL");
        List<Seller> sellers = sellerDao.findAll();
        for (int i = 0; i < sellers.size(); i++) {
            System.out.println(sellers.get(i));

        }
        System.out.println("TEST 3, INSERT SELLER");
        Seller newSeller = new Seller(null, "Greg","greg@gmail.com",new Date(),4000.0,department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id =" + newSeller.getId());

        System.out.println("TEST 5, SELLER UPDATE");

        seller = sellerDao.findById(1);

        seller.setName("Martha Waine");

        sellerDao.update(seller);
        System.out.println("Update Completed!");

        System.out.println("TEST 6, DELETE");

        Scanner sc = new Scanner(System.in);
        System.out.println("Type the id to be deleted from database");
        int id = sc.nextInt();
        sc.close();
        sellerDao.deleteById(id);

    }
}
