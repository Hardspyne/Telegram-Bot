package com.hardspyne.TelegramBot.configuration;

import com.hardspyne.TelegramBot.properties.ProxyProperties;
import com.hardspyne.TelegramBot.properties.TelegramProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;

@Configuration
@EnableConfigurationProperties({TelegramProperties.class, ProxyProperties.class})
public class TelegramConfiguration {
    @Bean
    public DefaultBotOptions defaultBotOptions(ProxyProperties proxyProperties) {
        DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class);
        botOptions.setProxyType(DefaultBotOptions.ProxyType.SOCKS5);
        botOptions.setProxyHost(proxyProperties.getHost());
        botOptions.setProxyPort(Integer.parseInt(proxyProperties.getPort()));
        return botOptions;
    }

}
