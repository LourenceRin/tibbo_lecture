package tibbo.grep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GrepHelper
{
    public static final String GREP_EXPCETION_MESSAGE = "Значение null не подходит для поиска";

    public static Grep getInstance(Integer value, String regExpOrSubstring) throws Exception
    {
        //0 == StringGrep(regExpOrSubstring);
        //1 == RegExpGrep(regExpOrSubstring);
        //в случае если value != 0 и не равно 1 нужно выбросить исклюечение IllegalArgumentException
        //в случе если regExpOrSubstring == null нужно выбросить исключение GrepException, но выбросить его нужно не отсюда, а из конструктора класса
        if(value.equals(0))
            return new StringGrep(regExpOrSubstring);
        else if(value.equals(1))
            return new RegExpGrep(regExpOrSubstring);
        else
            throw new IllegalArgumentException("value != 0 , value != 1");
    }

    public static List<String> prepareValues(String value, String splitSymbol)
    {
        ArrayList list = new ArrayList();
        String[] myList = value.split(splitSymbol);
        for(String i:myList)
            list.add(i);
        return list;
    }

     static List readValuesFromFile(String filePath)
    {
        List list = new ArrayList();
        try{
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String strLine;
            while ((strLine = br.readLine()) != null){
                list.add(strLine);
            }
        }catch (IOException e){
            System.out.println("Ошибка");
        }
        return list;
    }
}