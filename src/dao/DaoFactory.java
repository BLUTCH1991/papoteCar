package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {

    private String url;
    private String username;
    private String password;

    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DaoFactory getInstance() {
        try {
            return new DaoFactory(
                    "jdbc:mysql://localhost:3306/papotecar?useSSL=false", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public void closeConnections(Connection connexion){
        try {
            if (connexion != null) {
                connexion.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public CityDao getCityDao() {
        return new CityDao(this);
    }
    public MessageDao getMessageDao() {
        return new MessageDao(this);
    }
    public StepDao getStepDao(){
        return new StepDao(this);
    }
    public StepUserDao getStepUserDao(){
        return new StepUserDao(this);
    }
    public StepUserRoleDao getStepUserRoleDao(){
        return new StepUserRoleDao(this);
    }
    public TripDao getTripDao(){
        return new TripDao(this);
    }
    public UserDao getUserDao() {
        return new UserDao(this);
    }
    public UserRoleDao getUserRoleDao(){
        return new UserRoleDao(this);
    }

}
