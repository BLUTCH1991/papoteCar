package dao;

import Entities.Step;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StepDao implements DaoInterface<Step> {

    private DaoFactory daoFactory;

    StepDao(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void create(Step step){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(
                    "INSERT INTO step(trip, city_start, city_end, adress_start, adress_end, date) " +
                        "VALUES(?,?,?,?,?,?);");

            preparedStatement.setInt(1, step.getTrip());
            preparedStatement.setInt(2, step.getCityStart());
            preparedStatement.setInt(3, step.getCityEnd());
            preparedStatement.setString(4, step.getAdressStart());
            preparedStatement.setString(5, step.getAdressEnd());
            preparedStatement.setString(6, step.getDate().toString());
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
    public Step get(int id) {

        return null;
    }

}
