package com;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageSender messageSender;
    private final MessageReceiver messageReceiver;

    public MessageController(MessageSender messageSender, MessageReceiver messageReceiver) {
        this.messageSender = messageSender;
        this.messageReceiver = messageReceiver;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody String message) {
        System.out.println("Received POST request with message: " + message);
        messageSender.sendMessage(message);
        return "Message sent: " + message;
    }

    @GetMapping("/receive")
    public String getMessage() {
        return messageReceiver.lastMessage != null ? messageReceiver.lastMessage : "No message received yet.";
    }
}
