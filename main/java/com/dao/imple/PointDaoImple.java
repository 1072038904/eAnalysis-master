package com.dao.imple;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.dao.PointDao;
import com.domain.Location;
import com.util.Value;

public class PointDaoImple implements PointDao {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/legend?&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    String username = "root";
    String password = "123456";
    public ArrayList<Location> getPoint(String videoid){
        ArrayList<Location> points = new ArrayList<Location>();
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            String sql = "select x,y from "+videoid+"";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                int x = rs.getInt(1);
                int y = rs.getInt(2);
                points.add(new Location(x,y));
            }
            stmt.close();
            conn.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return points;

    }
    public Map countX(String videoid){
        ArrayList<Location> points = new ArrayList<Location>();
        Map map = new HashMap();
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            String sql = "select x,count(*) from helloworld group by x";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                int x = rs.getInt(1);
                float y = rs.getInt(2);
                float y1 = y/650;
//                System.out.println(x+" "+y1);
                map.put(x,y1);
            }
            stmt.close();
            conn.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;

    }
    public Map countY(String videoid){
        ArrayList<Location> points = new ArrayList<Location>();
        Map map = new HashMap();
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            String sql = "select y,count(*) from helloworld group by y";
            String sql2 = "select count(*) from helloworld";
            ResultSet rs1 = stmt.executeQuery(sql2);
            int num=0;
            while(rs1.next()){
                num = rs1.getInt(1);
                //  System.out.println(x+"   "+y1);
            }
            System.out.println(num);
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int x = rs.getInt(1);
                float k = rs.getInt(2);
                float y1 = k/num;
                map.put(x,y1);
                //  System.out.println(x+"   "+y1);
            }
            stmt.close();
            conn.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;

    }

    public static void main(String[] args) {
        PointDao d  = new PointDaoImple();
        Map map = d.countX("helloworld");
        Map map1 =d.countY("helloworld");
        Value value = new Value(map,map1);
        System.out.println(value.getValue(value,1,2));
    }
}
