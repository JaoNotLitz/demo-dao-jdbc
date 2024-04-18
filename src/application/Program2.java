package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;

import java.util.List;

public class Program2 {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        System.out.println("Test 1, add Department");
        Department department = new Department(null,"Parking");
        departmentDao.insert(department);
        System.out.println("completed!");

        System.out.println("Test 2, update Department");
        Department department1 = new Department(1,"Programing");
        departmentDao.update(department1);

        System.out.println("Test 3, deleteById Department");
        int idToBeDeleted=7;
        departmentDao.deleteById(idToBeDeleted);

        System.out.println("Test 4, selectById Department");
        int idSelected=1;
        Department dep = departmentDao.findById(idSelected);
        System.out.println(dep);

        System.out.println("Test 5, selectAll Departments");
        List<Department> departmentList = departmentDao.findAll();
        for (int i = 0; i < departmentList.size()-1; i++) {
            System.out.println(departmentList.get(i));
        }

    }
}
