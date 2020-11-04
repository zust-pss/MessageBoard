package org.message.service;

import org.message.entity.MessageBoard;

import java.util.ArrayList;

public interface IMyselfService {
    public ArrayList<MessageBoard> findAllMyMessage(int id);
}
