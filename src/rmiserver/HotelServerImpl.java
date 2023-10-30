/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import rmiserver.dao.DAO;
import rmiserver.model.Room;

/**
 *
 * @author 503
 */
public class HotelServerImpl extends java.rmi.server.UnicastRemoteObject implements HotelServer{
    private DAO dao = new DAO();
    private static final String ADD_A_ROOM = "INSERT INTO room VALUES (?, ?, ?, ?)";
    private static final String CHECK_ROOM_EXSITS = "SELECT * FROM room WHERE id = ? OR name = ?";
    private static final String GET_ALL_ROOM = "SELECT * FROM room";
    private static final String SEARCH_ROOM = "SELECT * FROM room WHERE id LIKE ?";
    public HotelServerImpl() throws java.rmi.RemoteException{
        super();
    }

    @Override
    public Boolean addRoom(Room room) throws RemoteException {
        boolean success = false;
        if(!isRoomExisited(room)){
            try{
                Connection connection = dao.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(ADD_A_ROOM);
                preparedStatement.setInt(1, room.getId());
                preparedStatement.setString(2, room.getName());
                preparedStatement.setString(3, room.getType());
                preparedStatement.setInt(4, room.getPrice());
                preparedStatement.execute();
                preparedStatement.close();
                success = true;
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return success;
    }

    @Override
    public List<Room> listRoom() throws RemoteException {
        List<Room> rooms = new ArrayList<>();
        try{
            Connection connection = dao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_ROOM);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                int price = resultSet.getInt("price");
                Room room = new Room(id, name, type, price);
                rooms.add(room);
                        
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return rooms;
    }

    @Override
    public List<Room> searchRoom(String keyword) throws RemoteException {
        List<Room> rooms = new ArrayList<>();
        try{
            Connection connection = dao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_ROOM);
            String searchstring = "%" + keyword + "%";
            preparedStatement.setString(1, searchstring);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                int price = resultSet.getInt("price");
                Room room = new Room(id, name, type, price);
                rooms.add(room);
                        
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return rooms;
    }

    @Override
    public Boolean isRoomExisited(Room room) throws RemoteException {
         boolean exisited = false;
        
        try{
            Connection connection = dao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CHECK_ROOM_EXSITS);
            preparedStatement.setInt(1, room.getId());
            preparedStatement.setString(2, room.getName());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                exisited = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return exisited;
    }
    
    
    
}
