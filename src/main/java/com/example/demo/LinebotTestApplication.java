package com.example.demo;


import java.io.IOException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.ImageMessageContent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

@SpringBootApplication
@LineMessageHandler
public class LinebotTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(LinebotTestApplication.class, args);
    }

    @EventMapping
    public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
        System.out.println("event: " + event);
        return new TextMessage(event.getMessage().getText());
    }
    @EventMapping
    public TextMessage handleImageMessageEvent(MessageEvent<ImageMessageContent> event) throws IOException {
        System.out.println("event: " + event);
        return new TextMessage("画像応答");
    }
        
    @EventMapping
    public void handleDefaultMessageEvent(Event event) {
        System.out.println("event: " + event);
    }
}