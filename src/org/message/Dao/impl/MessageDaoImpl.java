package org.message.Dao.impl;

import org.message.Dao.IMessageDao;
import org.message.entity.MessageBoard;
import org.message.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class MessageDaoImpl implements IMessageDao {
    int messageID;
    int id;
    String name;
    Date time;
    String title;
    String message;
    @Override
    public int getAllMessageCount() {
        String sql = "select count(1) from message";
        return DBUtil.getTotalCount(sql);
    }
    public boolean addMessage(MessageBoard messageBoard) {
        String sql = "insert into message(id,name,time,title,message) values(?,?,?,?,?)";
        Object[] params = {messageBoard.getId(),messageBoard.getName(),messageBoard.getTime(),messageBoard.getTitle(),messageBoard.getMessage()};
        return DBUtil.executeAdd(sql,params);
    }

    public ArrayList<MessageBoard> findAllMessage() {
        String sql = "select * from message";
        ArrayList<MessageBoard> messageBoards = new ArrayList<>();
        ResultSet rs = DBUtil.executeQuery(sql,null);

        try{
            while(rs.next()){
                messageID = rs.getInt("messageID");
                id = rs.getInt("id");
                name = rs.getString("name");
                time = rs.getTimestamp("time");
                title = rs.getString("title");
                message = rs.getString("message");
                MessageBoard messageBoard = new MessageBoard(messageID,id,name,time,title,message);
                messageBoards.add(messageBoard);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.closeAll(DBUtil.conn,DBUtil.ps,DBUtil.rs);
        }
        return messageBoards;
    }

    @Override
    public ArrayList<MessageBoard> queryMessageByPage(int currentPage, int pageSize) {
        String sql = "select * from message limit ?,?";
        Object[] params = {(currentPage - 1) * pageSize,pageSize};
        ArrayList<MessageBoard> messageBoards = new ArrayList<>();
        ResultSet rs = DBUtil.executeQuery(sql,params);
        try{
            while(rs.next()){
                messageID = rs.getInt("messageID");
                id = rs.getInt("id");
                name = rs.getString("name");
                time = rs.getTimestamp("time");
                title = rs.getString("title");
                message = rs.getString("message");
                MessageBoard messageBoard = new MessageBoard(messageID,id,name,time,title,message);
                messageBoards.add(messageBoard);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.closeAll(DBUtil.conn,DBUtil.ps,DBUtil.rs);
        }
        return messageBoards;
    }
    public ArrayList<MessageBoard> findAllMyMessage(int id) {
        String sql = "select * from message where id = ?";
        ArrayList<MessageBoard> messageBoards = new ArrayList<>();
        Object[] params = {id};
        ResultSet rs = DBUtil.executeQuery(sql,params);
        MessageBoard messageBoard = new MessageBoard();
        try{
            while(rs.next()){
                messageBoard.setMessageID(rs.getInt("messageID"));
                messageBoard.setId(rs.getInt("id"));
                messageBoard.setName(rs.getString("name"));
                messageBoard.setTime(rs.getTimestamp("time"));
                messageBoard.setTitle(rs.getString("title"));
                messageBoard.setMessage(rs.getString("message"));
                messageBoards.add(messageBoard);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.closeAll(DBUtil.conn,DBUtil.ps,DBUtil.rs);
        }
        return messageBoards;
    }

    @Override
    public void DeleteMessage(int id) {
        String sql = "delete from message where messageID = ?";
        Object[] params = {id};
        DBUtil.executeDelete(sql,params);
    }
}
