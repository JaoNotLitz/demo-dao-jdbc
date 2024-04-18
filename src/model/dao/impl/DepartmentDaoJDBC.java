package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentDaoJDBC implements DepartmentDao {
    private Connection conn;
    public DepartmentDaoJDBC(Connection conn){
        this.conn = conn;
    }
    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;
        try{
            st=conn.prepareStatement(
                    "INSERT INTO department\n" +
                            "(Name)\n" +
                            "VALUES\n" +
                            "(?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
            );
            st.setString(1,obj.getName());

            st.executeUpdate();
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Department obj) {
        PreparedStatement st = null;
        try{
            st=conn.prepareStatement(
                    "UPDATE department\n" +
                            "SET Name = ?\n" +
                            "WHERE Id = ?"
            );
            st.setString(1,obj.getName());
            st.setInt(2,obj.getId());

            st.executeUpdate();
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try{
            st=conn.prepareStatement(
                    "DELETE FROM department\n" +
                            "        WHERE Id = ?"
            );

            st.setInt(1,id);
            int rows =  st.executeUpdate();
            if (rows==0){
                throw new DbException("Id not found in database");
            }
            else{
                System.out.println("Sucessfully deleted!");
            }
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }


    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT department.* FROM department WHERE Id = ?"
            );
            st.setInt(1,id);
            rs = st.executeQuery();
            if(rs.next()){
                return instantiateDepartment(rs);

            }
            return null;

        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT department.* FROM department"
            );
            rs = st.executeQuery();

            List<Department> list = new ArrayList<>();


            while (rs.next()){

                   Department dep = instantiateDepartment(rs);
                   list.add(dep);
            }
            return list;

        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("Id"));
        dep.setName(rs.getString("Name"));
        return dep;
    }
}
