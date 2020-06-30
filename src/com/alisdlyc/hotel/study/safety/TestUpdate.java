package com.alisdlyc.hotel.study.safety;

import com.alisdlyc.hotel.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestUpdate {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = JdbcUtils.getConnection();

            // 区别
            // 用 ? 代替参数
            String sql = "UPDATE usr SET `password`=? WHERE `id` = ?";

            st = conn.prepareStatement(sql);

            // 手动给参数赋值
            st.setString(1, "5252634");
            st.setInt(2, 1);

            int i = st.executeUpdate();
            if (i > 0) {
                System.out.println("更新成功");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, null);
        }
    }
}
