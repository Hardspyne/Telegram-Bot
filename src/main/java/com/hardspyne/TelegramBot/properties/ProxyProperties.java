package com.hardspyne.TelegramBot.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "proxy")
@Getter
@Setter
public class ProxyProperties {
    String host;
    String port;
}
