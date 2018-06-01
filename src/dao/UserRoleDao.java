package dao;

import Entities.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRoleDao implements DaoInterface<UserRole> {

    private DaoFactory daoFactory;

    UserRoleDao(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void create(UserRole userRole){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(
                    "INSERT INTO user_role(name) " +
                        "VALUES(?);");

            preparedStatement.setString(1, userRole.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.daoFactory.closeConnections(connexion);
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id) {

    }

    @Override
    public UserRole get(int id) {

        return null;
    }

}
