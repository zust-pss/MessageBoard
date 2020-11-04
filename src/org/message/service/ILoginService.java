package org.message.service;

import org.message.entity.Login;
import org.message.entity.MessageBoard;

import java.util.ArrayList;

public interface ILoginService {
    public Login checkLogin(int id,String password);
    public boolean insertUser(int id,String name,String password);
}
