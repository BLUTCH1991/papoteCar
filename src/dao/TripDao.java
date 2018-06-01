package dao;

import Entities.Trip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TripDao implements DaoInterface<Trip> {

    private DaoFactory daoFactory;

    TripDao(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void create(Trip trip){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(
                    "INSERT INTO trip(date_start,date_end,sits,state,city_start_id,city_end_id,adress_start,adress_end) " +
                        "VALUES(?,?,?,?,?,?,?,?);");

            preparedStatement.setString(1, trip.getDate_start().toString());
            preparedStatement.setString(2, trip.getDate_end().toString());
            preparedStatement.setInt(3, trip.getSits());
            preparedStatement.setBoolean(4, trip.isState());
            preparedStatement.setInt(5, trip.getCity_start_id());
            preparedStatement.setInt(6, trip.getCity_end_id());
            preparedStatement.setString(7, trip.getAdresse_start());
            preparedStatement.setString(8, trip.getAdresse_end());
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
    public Trip get(int id) {

        return null;
    }

}
