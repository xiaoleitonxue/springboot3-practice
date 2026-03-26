package org.example;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class JDBC {
    @Test
    public void testupdate() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/web01";
        String user = "root";
        String password = "123456";
        Connection conn =DriverManager.getConnection(url,user,password);

        Statement st = conn.createStatement();

        int i = st.executeUpdate("update user set age = 21 where id = 1");

        System.out.println("更新成功" + i);

        st.close();
        conn.close();
    }

    @Test
    public void testSelect() throws Exception {
        String url = "jdbc:mysql://localhost:3306/web01";
        String user = "root";
        String password = "123456";

        Connection conn = DriverManager.getConnection(url, user, password);

        String sql = "select id,username,password,name,age from user where username = ? and password = ?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, "daqiao");
        ps.setString(2, "123456");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            User u = new User();
            u.setId(rs.getInt("id"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setName(rs.getString("name"));
            u.setAge(rs.getInt("age"));

            System.out.println(u);
        }

        rs.close();
        ps.close();
        conn.close();
    }
}
