package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        Department obj = new Department(1,"Books");
        Seller seller = new Seller(1,"Pedro","pedro@gmail.com", new Date(),1200.0,obj);
        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println(seller);

    }
}
