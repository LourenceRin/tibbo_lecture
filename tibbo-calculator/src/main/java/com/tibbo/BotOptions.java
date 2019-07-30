package com.tibbo;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

abstract class BotOptions extends TelegramLongPollingBot {
    private static final String BASEURL = "http://104.248.243.143:18012/";
    BotOptions()
    {
        super(new DefaultBotOptions()
        {
            @Override
            public String getBaseUrl() {
                return BASEURL;
            }
        });
    }

}