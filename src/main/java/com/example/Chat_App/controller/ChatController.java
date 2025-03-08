package com.example.Chat_App.controller;


import com.example.Chat_App.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")     // Maps websocket messages to the destination. here destination is /app/sendMessage
    @SendTo("/topic/messages")   // Whatever message this sendMessage function will return will go to this URL.
   public ChatMessage sendMessage(ChatMessage message){
       return message;
   }


   @GetMapping("chat")
    public String chat(){
        return "chat";   // this will be the name of our thymeleaf template.
   }

}
