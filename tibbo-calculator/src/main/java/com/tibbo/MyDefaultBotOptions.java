package com.tibbo;

import org.telegram.telegrambots.bots.DefaultBotOptions;

public class MyDefaultBotOptions extends DefaultBotOptions {
    private static final String BASEURL = "http://104.248.243.143:18012/";

    @Override
    public String getBaseUrl() {
        return BASEURL;
    }

}

