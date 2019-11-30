package com.hardspyne.TelegramBot.controllers;

import com.hardspyne.TelegramBot.services.TelegramService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/telegram")
@RequiredArgsConstructor
@Slf4j
public class TelegramController {

    private final TelegramService telegramService;

    @RequestMapping(path = "/send-message", method = RequestMethod.GET)
    public void sendMessageToChat(@RequestParam String text,
                                  @RequestParam(name = "chatId", required = false) String chatId) {
        log.info("sendMessageToChat request received");
        telegramService.sendMessage(text,chatId);
    }
}
