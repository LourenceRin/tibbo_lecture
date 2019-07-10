package tibbo.grep;

import java.util.ArrayList;
import java.util.List;

public class StringGrep implements Grep
{
    String regExpOrSubstring;
    StringGrep(String regExpOrSubstring)
    {
        this.regExpOrSubstring = regExpOrSubstring;
    }

    List<String> list = new ArrayList<>();

    @Override
    public void checkValue(String value)
    {
        if(regExpOrSubstring.indexOf(value)>=0)
            list.add(regExpOrSubstring);
    }

    @Override
    public List<String> getValuesList() {
        return list;
    }

    @Override
    public void printAllValues()
    {
        for(Object string : list)
        {
            System.out.println(string);
        }
    }

    @Override
    public Integer getValuesSize() {
        return list.size();
    }
}
