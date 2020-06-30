package com.alisdlyc.hotel.study;

import com.alisdlyc.hotel.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSelect {
    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();

            String sql = "SELECT * FROM `usr`";

            rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString("password"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(conn,st,rs);
        }

    }
}
