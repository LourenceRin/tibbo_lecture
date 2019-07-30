package com.tibbo;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class BotOptions extends TelegramLongPollingBot {
    private static final String USERNAME = "Lourence_bot";
    private static final String TOKEN = "914836872:AAF6sEyC4igukZ860X7bZWorhAjs0AE8VUQ";
    private static final String BASEURL = "http://104.248.243.143:18012/";

    private static int getPorts(){
        return 5555;
    }

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

     private String getMsg(String msg){
        try {
            Socket socket = new Socket();
            String result;
            String host = "localhost";
            socket.connect(new InetSocketAddress(host, getPorts()));
            DataOutputStream outStream= new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            outStream.writeUTF(msg);
            outStream.flush();
            result = inputStream.readUTF();
            return result;
        }catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public void onUpdateReceived(Update update) {
        long chat_id = update.getMessage().getChatId();

        SendMessage sendMessage = new SendMessage().setChatId(chat_id);
        String text = update.getMessage().getText();

        try {

            sendMessage.setText("Вы ввели: " + text);
            execute(sendMessage);

            sendMessage.setText("Результат: " + getMsg(text));
            execute(sendMessage);


        }catch (TelegramApiException e){
            e.printStackTrace();
        }

    }

    @Override
    public String getBotUsername() {
        return USERNAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }
}
