package mvc.controller;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Created by Владимир on 02.07.2017.
 */

public class CarWebSocketHandler extends TextWebSocketHandler {


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("Пришло сообщение с вэбсокета!!! ");


    }
}
