package com.tibbo;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {


    private static int port = 5555;

    private int getPorts(){
        return port;
    }

    public static void main(String[] args) {
        ApiContextInitializer.init(); // Инициализируем апи
        TelegramBotsApi botapi = new TelegramBotsApi();
        try {
            botapi.registerBot(new Bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    /**
     * Метод для приема сообщений.
     * @param update Содержит сообщение от пользователя.
     */
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

    private Bot()
    {
        super(new DefaultBotOptions()
        {
            @Override
            public String getBaseUrl() {
                return "http://104.248.243.143:18012/";
            }
        });

        //socket = new Socket();
    }


    private String getMsg(String msg){
        try {
            Socket socket = new Socket();
            Server.reset();
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

    /**
     * Метод возвращает имя бота, указанное при регистрации.
     * @return имя бота
     */
    @Override
    public String getBotUsername() {
        return "Lourence_bot";
    }

    /**
     * Метод возвращает token бота для связи с сервером Telegram
     * @return token для бота
     */
    @Override
    public String getBotToken() {
        return "914836872:AAF6sEyC4igukZ860X7bZWorhAjs0AE8VUQ";
    }

    private synchronized void setButtons(SendMessage sendMessage) { // клавиатура еще не реализована
        // Создаем клавиуатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add(new KeyboardButton("Button"));

        // Вторая строчка клавиатуры
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboardSecondRow.add(new KeyboardButton("Button"));

        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
    }


}