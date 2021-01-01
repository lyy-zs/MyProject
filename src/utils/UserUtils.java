package utils;

import java.sql.Connection;

import java.sql.*;
import java.util.*;
import Client.user;
import utils.DBUtils;


public class UserUtils {
    //用于管理员登录
    public static boolean isExist(String name,String password) {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        String sql = "select name,password from admin where name = ? and password =?";
        System.out.println(name+password);
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(!rs.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try{
                if(ps != null)
                    ps.close();
                if(rs != null)
                    rs.close();
                if(con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
    //用于用户登录
    public static boolean isUserExist(String name,String password){
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        String sql = "select name,password from user where name = ? and password =?";
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(!rs.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try{
                if(ps != null)
                    ps.close();
                if(rs != null)
                    rs.close();
                if(con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    //用于用户查询
    public static boolean query(String name){
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        String sql = "select password from user where name = ?";
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if(!rs.next()) {
                return false;
            }
//            if(rs.getString(1).compareTo(password) != 0) {
//                return false;
//            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try{
                if(ps != null)
                    ps.close();
                if(rs != null)
                    rs.close();
                if(con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    //用于查询邮箱
    public static boolean isExistEmail(String email) {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "select password from user where email = ?";

        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if(!rs.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try{
                if(ps != null)
                    ps.close();
                if(rs != null)
                    rs.close();
                if(con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    //用于用户注册
    public static boolean regiseter(String name,String password,String time,int money,String email){
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        String sql = "insert into user(name,password,time,money,email) values(?,?,?,?,?)";
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(3,time);
            ps.setInt(4,money);
            ps.setString(5,email);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try{
                if(ps != null)
                    ps.close();
                if(rs != null)
                    rs.close();
                if(con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    //现在剩余的钱
    public static int depoe(String name){
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        String sql = "select money from user where name = ?";
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if(!rs.next()) {
                return 0;
            }
            return  rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            try{
                if(ps != null)
                    ps.close();
                if(rs != null)
                    rs.close();
                if(con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    //用户存款
    public static boolean deposite(String name,int money){
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        int m = depoe(name);
        System.out.println("剩余："+m);
        money+=m;
        System.out.println("存款后："+money);
        String sql = "Update user set money = ? where name = ?";
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, money);
            ps.setString(2, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try{
                if(ps != null)
                    ps.close();
                if(rs != null)
                    rs.close();
                if(con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;

    }

    //用户取款
    public static boolean take(String name,int money){
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        int m = depoe(name);
        System.out.println("剩余："+m);
        if(m-money<0)
        {
            try {
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }
        else {
            m-=money;
            System.out.println("取款后：" + m);
            String sql = "Update user set money = ? where name = ?";
            try {
                con = DBUtils.getConnection();
                ps = con.prepareStatement(sql);
                ps.setInt(1, m);
                ps.setString(2, name);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            } finally {
                try {
                    if (ps != null)
                        ps.close();
                    if (rs != null)
                        rs.close();
                    if (con != null)
                        con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }

    }
    //更新用户登录时间
    public static void UpdateTime(String time,String name){
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        String sql = "Update user set time = ? where name = ?";
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, time);
            ps.setString(2, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    //用于管理员删除用户
    public static void  deleteUser(String id){
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        int i = Integer.parseInt(id);
        String sql = "delete from user where id = ?";
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, i);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    //查询总记录数
    public static int findTotalCount(String name){
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        System.out.println(name);
        String sql = "select count(*) from user where 1 = 1";
        System.out.println(sql);
        try {
            con = DBUtils.getConnection();

            StringBuilder sb = new StringBuilder(sql);
            if( name!=null ){
                sb.append(" and name like ? ");
                sql = sb.toString();

                System.out.println(sql);
            }
            ps = con.prepareStatement(sql);
            if(name!=null){
                ps.setString(1,"%"+name+"%");
            }
            rs = ps.executeQuery();
            if(rs.next())
                return  rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            try{
                if(ps != null)
                    ps.close();
                if(rs != null)
                    rs.close();
                if(con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static List<user> findByPage(int start,int rows,String name){
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        System.out.println(name);
        String sql = "select * from user where 1 = 1 ";
        try {
            con = DBUtils.getConnection();

            StringBuilder sb = new StringBuilder(sql);
            if( name!=null ){
                sb.append(" and name like ? ");
            }
            sb.append("limit ?,?");
            sql = sb.toString();
            ps = con.prepareStatement(sql);
            if(name!=null){
                ps.setString(1,"%"+name+"%");
                ps.setInt(2,start);
                ps.setInt(3,rows);
            }else {
                ps.setInt(1, start);
                ps.setInt(2, rows);
            }
            rs = ps.executeQuery();
            ArrayList<user> al = new ArrayList<user>();
            while(rs.next()) {
                al.add(new user(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6)));
            }
            return al;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(ps != null)
                    ps.close();
                if(rs != null)
                    rs.close();
                if(con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
