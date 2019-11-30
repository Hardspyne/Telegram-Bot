package com.hardspyne.TelegramBot.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "telegram")
@Getter
@Setter
public class TelegramProperties {

    String token;
    String defaultChatId;
    String botName;
    String parseMode;
}
