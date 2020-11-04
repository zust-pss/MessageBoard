package org.message.service.impl;

import org.message.Dao.IMessageDao;
import org.message.Dao.impl.MessageDaoImpl;
import org.message.entity.MessageBoard;
import org.message.service.IMessageService;

import java.util.ArrayList;

public class MessageServiceImpl implements IMessageService {
    IMessageDao messageDao = new MessageDaoImpl();
    public boolean addMessage(MessageBoard messageBoard) {
        return messageDao.addMessage(messageBoard);
    }
    public ArrayList<MessageBoard> findAllMessage() {
        return messageDao.findAllMessage();
    }
    public int getTotalCount() {
        return messageDao.getAllMessageCount();
    }
    public ArrayList<MessageBoard> queryStudentByPage(int currentPage, int pageSize) {
        return messageDao.queryMessageByPage(currentPage, pageSize);
    }
    public void DeleteMessage(int id){
        messageDao.DeleteMessage(id);
    }

    @Override
    public ArrayList<MessageBoard> findMessagesById(int id) {
        IMessageDao messageDao = new MessageDaoImpl();
        return messageDao.findAllMyMessage(id);
    }
}
