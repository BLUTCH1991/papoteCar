package dao;

import Entities.StepUserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StepUserRoleDao implements DaoInterface<StepUserRole> {

    private DaoFactory daoFactory;

    StepUserRoleDao(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void create(StepUserRole stepUserRole){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(
                    "INSERT INTO step_user_role(role) " +
                        "VALUES(?);");

            preparedStatement.setString(1, stepUserRole.getName());
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
    public StepUserRole get(int id) {

        return null;
    }

}
