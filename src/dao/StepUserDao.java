package dao;

import Entities.StepUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StepUserDao implements DaoInterface<StepUser> {

    private DaoFactory daoFactory;

    StepUserDao(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void create(StepUser stepUser){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(
                    "INSERT INTO step_user(user_id,step_id,step_user_role_id) " +
                        "VALUES(?,?,?);");

            preparedStatement.setInt(1, stepUser.getUser());
            preparedStatement.setInt(2, stepUser.getStep());
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
    public StepUser get(int id) {

        return null;
    }

}
