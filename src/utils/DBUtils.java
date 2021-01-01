package utils;

import Client.admin;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.beanutils.BeanUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;

public class DBUtils {
    public static Connection getConnection() throws SQLException {
        DataSource ds = null;
        try {
            //读取配置文件
            Properties pro = new Properties();
            InputStream in = DBUtils.class.getClassLoader().getResourceAsStream("utils/db.properties");
            pro.load(in);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            System.out.println("%%%%%%%%%%%% 获取连接错误  %%%%%%%%%%%%%%");
        }
        return ds.getConnection();
    }
    public static void close(Connection conn, Statement stm, ResultSet rs)
    {
        try {
            if(conn!=null) conn.close();
            if(stm!=null) stm.close();
            if(rs!=null) rs.close();
        } catch (Exception e) {
            System.out.println("%%%%%%%%%%%% 关闭连接错误  %%%%%%%%%%%%%%");
            e.printStackTrace();
        }
    }
   }

