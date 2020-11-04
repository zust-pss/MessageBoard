package org.message.service.impl;

import org.message.Dao.ILoginDao;
import org.message.Dao.impl.LoginDaoImpl;
import org.message.entity.Login;
import org.message.service.ILoginService;


public class LoginServiceImpl implements ILoginService {
    ILoginDao loginDao = new LoginDaoImpl();
    public Login checkLogin(int id,String password){
        return loginDao.checkLogin(id, password);
    }

    public boolean insertUser(int id, String name, String password) {
        return loginDao.insertUser(id,name,password);
    }


}
