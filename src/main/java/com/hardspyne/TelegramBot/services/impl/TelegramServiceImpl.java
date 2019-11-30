package com.hardspyne.TelegramBot.services.impl;

import com.hardspyne.TelegramBot.properties.TelegramProperties;
import com.hardspyne.TelegramBot.services.TelegramService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.annotation.Nullable;

@Service
@Slf4j
public class TelegramServiceImpl extends TelegramLongPollingBot implements TelegramService {

    private final TelegramProperties telegramProperties;

    @Autowired
    public TelegramServiceImpl(DefaultBotOptions defaultBotOptions, TelegramProperties telegramProperties) {
        super(defaultBotOptions);
        this.telegramProperties = telegramProperties;
    }


    @Override
    public void sendMessage(String text, @Nullable String chatId) {
        log.info("try to send message with text {} and chatId {}", text, chatId);
        if (StringUtils.isEmpty(chatId)) {
            chatId = telegramProperties.getDefaultChatId();
        }
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setParseMode(telegramProperties.getParseMode());
        message.setText(text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String getBotUsername() {
        return telegramProperties.getBotName();
    }

    @Override
    public String getBotToken() {
        return telegramProperties.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            log.info("update received with text {} ", update.getMessage().getText());
        }
    }

}
