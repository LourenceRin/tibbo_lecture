package tibbo.grep;

import java.util.ArrayList;
import java.util.List;

public class GrepHelper
{
    public static Grep getInstance(Integer value, String regExpOrSubstring)
    {
        //0 == StringGrep(regExpOrSubstring);
        //1 == RegExpGrep(regExpOrSubstring);

        return null;
    }

    public static List<String> prepareValues(String value, String splitSymbol) //передается текст со строкой
    {
        List list = new ArrayList();
        if (value.contains(splitSymbol)){
            list.add(splitSymbol);
        }
        return list;
    }
}
