package rmiserver;

import java.util.List;
import rmiserver.model.Room;


public interface HotelServer extends java.rmi.Remote{
    public Boolean addRoom(Room room) throws java.rmi.RemoteException;
    public List<Room> listRoom() throws java.rmi.RemoteException;
    public List<Room> searchRoom(String keyword) throws java.rmi.RemoteException;
    public Boolean isRoomExisited(Room room) throws java.rmi.RemoteException;
}
