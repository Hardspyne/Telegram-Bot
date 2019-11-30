package com.hardspyne.TelegramBot;

import com.hardspyne.TelegramBot.properties.TelegramProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class TelegramBotApplication {

    public static void main(String[] args) {
        ApiContextInitializer.init();

        SpringApplication.run(TelegramBotApplication.class, args);
    }

}
