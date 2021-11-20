package rs.ac.metropolitan.websocket;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/wsendpoint")
public class WSEndpoint {

    @OnMessage
    public String onMessage(String message) {
        String returnValue;

        if (message.equals("getDefaults")) {
            returnValue = new StringBuilder("{")
                    .append("\"firstName\":\"Generated First Name\",")
                    .append("\"lastName\":\"Generated Last Name\",")
                    .append("\"city\":\"Generated City Name\"")
                    .append("}").toString();
        } else {
            returnValue="";
        }
        return returnValue;
    }
}
