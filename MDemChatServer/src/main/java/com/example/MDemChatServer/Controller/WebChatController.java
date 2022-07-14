package com.example.MDemChatServer.Controller;


import com.example.MDemChatServer.Model.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebChatController {

//    @Autowired
//    private SimpMessagingTemplate simpMessagingTemplate;
//
//
//    @SendTo("/room/public")
//    @MessageMapping("/message")
//    private MessageModel publicMessage(@Payload MessageModel message)
//    {
//        return message;
//    }
//
//    @MessageMapping("/message_private")
//    public MessageModel MessageRecord(@Payload MessageModel message)
//    {
//        simpMessagingTemplate.convertAndSendToUser(message.getResiver(),"/private",message);
//        return message;
//    }

    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public MessageModel register(@Payload MessageModel messageModelm, SimpMessageHeaderAccessor headerAccessor)
    {

        headerAccessor.getSessionAttributes().put("username", messageModelm.getSender());

        return messageModelm;

    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public MessageModel sendMessage(@Payload MessageModel messageModel)
    {
        return messageModel;
    }






}
