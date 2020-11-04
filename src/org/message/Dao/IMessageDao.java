package org.message.Dao;

import org.message.entity.MessageBoard;

import java.util.ArrayList;

public interface IMessageDao {
    public int getAllMessageCount();
    public boolean addMessage(MessageBoard messageBoard);
    public ArrayList<MessageBoard> findAllMessage();
    public ArrayList<MessageBoard> queryMessageByPage(int currentPage,int pageSize);
}
