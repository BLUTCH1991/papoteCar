package dao;

import beans.User;

public class Test {

    private UserDao userDao;

    public void init(){

        DaoFactory daoFactory = DaoFactory.getInstance();
        userDao = daoFactory.getUserDao();

        User user = new User();
        user.setFirstName("Thomas");
        user.setLastName("Chabot");
        user.setEmail("thomas.chabot@hotmail.fr");
        userDao.create(user);
    }

}
