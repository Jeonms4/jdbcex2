package com.green.jdbcex.dao;


import com.green.jdbcex.domain.TodoVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TodoDAO {
    private TodoVO todoVO;
    public void setTodoVO(TodoVO todoVO) {
        this.todoVO = todoVO;
    }

    public String getTime() throws Exception{
        String now = null;
//        try {
//            ConnectionUtil.INSTANCE.getConnection();
//        } catch (Exception e) {
//            throw new RuntimeException();
//        }

        // 자원을 가지고 하는 예외처리(닫아주지 않아도 됨)
//        ConnectionUtil.INSTANCE.getConnection();

//        try(Connection conn = ConnectionUtil.INSTANCE.getConnection();) {
//            PreparedStatement pstmt = conn.prepareStatement("select now()");
//            ResultSet rs = pstmt.executeQuery();
//            rs.next();
//            now = rs.getString(1);
//        } catch (Exception e) {
//            System.out.println("DB 커넥션 관련 오류 발생");
//        }
        @Cleanup
        Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup
        PreparedStatement pstmt = conn.prepareStatement("select now()");
        @Cleanup
        ResultSet rs = pstmt.executeQuery();

        rs.next();
        now = rs.getString(1);

        return now;
    }

    public void insert(TodoVO todoVO) throws Exception{
        String sql = "insert into tbl_todo(title, dueDate, finished) values (?, ?, ?) ";
        @Cleanup
        Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, todoVO.getTitle());
        stmt.setDate(2, Date.valueOf(todoVO.getDueDate()));
        stmt.setBoolean(3, todoVO.isFinished());

        stmt.executeUpdate();
    }

}
