package com.hardspyne.TelegramBot.services;

import javax.annotation.Nullable;

public interface TelegramService {
    void sendMessage(String text, @Nullable String chatId);
}
