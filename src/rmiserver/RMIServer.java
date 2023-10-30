package rmiserver;
import java.rmi.*;
import java.rmi.registry.*;
public class RMIServer {
    public RMIServer() throws RemoteException{
        try{
            
            HotelServer h = new HotelServerImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://10.170.44.51:1099/HotelServer", h);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws RemoteException {
        new RMIServer();
        ClientView clientView = new ClientView();
        clientView.setVisible(true);

    }
    
}
