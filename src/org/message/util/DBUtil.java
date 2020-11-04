package org.message.util;
import java.sql.*;

public class DBUtil {
    //增删改
    private static String url = "jdbc:mysql://localhost:3306/test01?serverTimezone=GMT%2B8";
    private static String user = "root";
    private static String password = "429839007";
    public static Connection conn = null;
    public static PreparedStatement ps = null;
    public static ResultSet rs = null;
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url,user,password);
    }
    public static PreparedStatement createPreparedStatement(String sql,Object[] params) throws SQLException, ClassNotFoundException {
        conn = getConnection();
        ps = conn.prepareStatement(sql);
        if(params != null) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
        }
        return ps;
    }
    public static void closeAll(Connection conn,Statement stmt,ResultSet rs){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static boolean executeAdd(String sql,Object[] params){
        try {
            ps = createPreparedStatement(sql,params);
            int count = ps.executeUpdate();
            if(count > 0)return true;
            else return false;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            closeAll(conn,ps,null);
        }
    }
    public static boolean executeUpdate(String sql,Object[] params){
        try {
            ps = createPreparedStatement(sql,params);
            int count = ps.executeUpdate();
            if(count > 0)return true;
            else return false;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            closeAll(conn,ps,null);
        }
    }
    public static boolean executeDelete(String sql,Object[] params){
        try {
            ps = createPreparedStatement(sql,params);
            int count = ps.executeUpdate();
            if(count > 0)return true;
            else return false;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            closeAll(conn,ps,null);
        }
    }
    //查
    public static ResultSet executeQuery(String sql,Object[] params){
        try {
            ps = createPreparedStatement(sql,params);
            rs = ps.executeQuery();
            return rs;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static int getTotalCount(String sql){
        int count = 0;
        try {
            ps = createPreparedStatement(sql,null);
            rs = ps.executeQuery();
            if(rs.next()){
                count = rs.getInt(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,ps,rs);
        }
        return count;
    }
}
