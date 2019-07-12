package tibbo.grep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GrepHelper
{
    public static final String GREP_EXPCETION_MESSAGE = "Значение null не подходит для поиска";

    public static Grep getInstance(Integer value, String regExpOrSubstring) throws GrepException
    {
        //0 == StringGrep(regExpOrSubstring);
        //1 == RegExpGrep(regExpOrSubstring);
        //в случае если value != 0 и не равно 1 нужно выбросить исклюечение IllegalArgumentException
        //в случе если regExpOrSubstring == null нужно выбросить исключение GrepException, но выбросить его нужно не отсюда, а из конструктора класса
        if(value == 0)
            return new StringGrep(regExpOrSubstring);
        if(value == 1)
            return new RegExpGrep(regExpOrSubstring);

        return null;
    }

    public static List prepareValues(String value, String splitSymbol)
    {
        List list = new ArrayList();
        String[] stringList = value.split(splitSymbol);

        Collections.addAll(list, stringList);
        return list;
    }

    public static List<String> readValuesFromFile(String filePath)
    {

        return null;
    }
}

