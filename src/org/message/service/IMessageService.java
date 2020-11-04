package org.message.service;

import org.message.entity.MessageBoard;

import java.util.ArrayList;

public interface IMessageService {
    public boolean addMessage(MessageBoard messageBoard);
    public ArrayList<MessageBoard> findAllMessage() ;
    public int getTotalCount();
    public ArrayList<MessageBoard> queryStudentByPage(int currentPage, int pageSize);
    public void DeleteMessage(int id);
    public ArrayList<MessageBoard> findMessagesById(int id);
}
