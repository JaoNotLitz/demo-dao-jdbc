package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("TEST 1, FIND BY ID");
        Seller seller = sellerDao.findById(7);
        System.out.println(seller);
        System.out.println("TEST 2, FIND BY DEPARTMENT");
        Department department = new Department(2,null);
        List<Seller> list = sellerDao.findByDepapartment(department);
        for (Seller obj:list){
            System.out.println(obj);
        }


    }
}
