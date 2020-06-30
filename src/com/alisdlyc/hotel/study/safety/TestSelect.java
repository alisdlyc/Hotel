package com.alisdlyc.hotel.study.safety;

import com.alisdlyc.hotel.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestSelect {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();

            // 区别
            // 用 ? 代替参数
            String sql = "select * from usr where id = ?";

            st = conn.prepareStatement(sql);

            // 手动给参数赋值
            st.setInt(1, 1);


            rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
}
