# Telegram-Bot

Telegram bot using *telegrambots-spring-boot-starter* for sent messages to telegram channel or group
____

### installation requirements:
 - JDK 8
 - Maven


### Settings:
In application.yml specify:
 - telegram-bot token (how to create bot and get token look at https://core.telegram.org/bots#6-botfather )
 - default-chat-id (you can get your chat-id after /start command in chat, using  method getUpdates https://core.telegram.org/bots/api#getupdates)
 - Proxy settings. If you have Tor-Browser, you can use him as proxy. 
 
 ### How to use:
 - Send message to chat:
 GET /api/telegram/send-message?text={text}&chat-id={chat-id}
    - text - the text of your message
   - chat-id - chat-id of channel/group(optional, by default this param will be getting from application.yml)
