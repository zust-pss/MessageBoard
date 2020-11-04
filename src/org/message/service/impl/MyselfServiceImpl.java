package org.message.service.impl;

import org.message.entity.MessageBoard;
import org.message.service.IMyselfService;
import org.message.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyselfServiceImpl implements IMyselfService {
    @Override
    public ArrayList<MessageBoard> findAllMyMessage(int id) {
        String sql = "select * from message where id = ?";
        ArrayList<MessageBoard> messageBoards = new ArrayList<>();
        Object[] params = {id};
        ResultSet rs = DBUtil.executeQuery(sql,params);
        MessageBoard messageBoard = new MessageBoard();
        try{
            while(rs.next()){
                messageBoard.setId(rs.getInt("id"));
                messageBoard.setName(rs.getString("name"));
                messageBoard.setTime(rs.getTimestamp("time"));
                messageBoard.setTitle(rs.getString("title"));
                messageBoard.setMessage(rs.getString("message"));
                messageBoards.add(messageBoard);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return messageBoards;
    }
}
