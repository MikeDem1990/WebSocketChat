package com.example.MDemChatServer.Controller;


import com.example.MDemChatServer.Model.MessageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

@Component
public class WebSocketEventListener {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

    @Autowired
    private SimpMessageSendingOperations messageSendingOperations;

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event)
    {
        logger.info("Received a new websocket connection");
    }

    @EventListener
    public  void handleWebSocketDisconnectListener(SessionConnectedEvent event)
    {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String username = (String) headerAccessor.getSessionAttributes().get("username");

        if (username != null)
        {
            logger.info("User Disconnected : " + username);

            MessageModel messageModel = new MessageModel();
            messageModel.setType(MessageModel.MessageType.LEAVE);
            messageModel.setSender(username);

            messageSendingOperations.convertAndSend("/topic/public" , messageModel);
        }
    }

}
