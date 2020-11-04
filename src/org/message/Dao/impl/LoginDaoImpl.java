package org.message.Dao.impl;

import org.message.Dao.ILoginDao;
import org.message.entity.Login;
import org.message.entity.MessageBoard;
import org.message.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class LoginDaoImpl implements ILoginDao {
    public Login checkLogin(int id, String password) {
        String sql = "select * from user where id = ? and password = ?";
        Object[] params = {id,password};
        ResultSet rs = DBUtil.executeQuery(sql,params);
        Login login = new Login();
        try{
            if(rs.next()){
                login.setId(rs.getInt(1));
                login.setName(rs.getString(2));
                login.setPassword(rs.getString(3));
                return login;
            }
            return null;
        }catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            DBUtil.closeAll(DBUtil.conn,DBUtil.ps,rs);
        }
    }
    public boolean insertUser(int id,String name,String password){
        String sql = "insert into user(id,name,password) values(?,?,?)";
        Object[] params = {id,name,password};
        return DBUtil.executeUpdate(sql,params);
    }

    public String getNameById(int id) {
        String sql = "select * from user where id = ?";
        Object[] params = {id};
        ResultSet rs = DBUtil.executeQuery(sql,params);
        try{
            if(rs.next()){
                return rs.getString("name");
            }else{
                return null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
