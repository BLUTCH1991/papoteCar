package dao;

import Entities.City;
import Entities.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CityDao implements DaoInterface<City> {

    private DaoFactory daoFactory;

    CityDao(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void create(City city){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(
                    "INSERT INTO city(name,zip_code) " +
                        "VALUES(?,?);");

            preparedStatement.setString(1, city.getName());
            preparedStatement.setString(2, city.getZipCode());
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
    public City get(int id) {

        return null;
    }

}
