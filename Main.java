import java.util.*;

/**
 * Main.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */


 public class Main {

    public static void main(String[] args){
        CCGG gateway = CCGG.getGateway();
        try {
            String ticket = gateway.submitRequest(new Proyecto());
            Double d = gateway.getAmountGranted(ticket);
        } catch (IOException | InvalidRequestException e) {
            e.printStackTrace();
        } catch (InvalidIDException e) {
            e.printStackTrace();
        }
    }
 }