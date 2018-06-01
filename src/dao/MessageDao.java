package dao;

import Entities.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageDao implements DaoInterface<Message> {

    private DaoFactory daoFactory;

    MessageDao(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void create(Message message){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(
                    "INSERT INTO message(sender_user_id, receiver_user_id, trip_id, content, date) " +
                        "VALUES(?,?,?,?,?);");

            preparedStatement.setInt(1, message.getSenderUser().getId());
            preparedStatement.setInt(2, message.getReceiverUser().getId());
            preparedStatement.setInt(3, message.getTrip().getId());
            preparedStatement.setString(4, message.getContent());
            preparedStatement.setString(5, message.getDate().toString());

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
    public Message get(int id) {

        return null;
    }

}
