package tibbo.grep;

import java.util.ArrayList;

import java.util.List;

public class StringGrep implements Grep
{
    String regExpOrSubstring;
    StringGrep(String regExpOrSubstring)
    {
        this.regExpOrSubstring = regExpOrSubstring.toLowerCase();
    }

    List<String> list = new ArrayList();

    @Override
    public void checkValue(String value)
    {
        String _value = value.toLowerCase();
        if(_value.indexOf(regExpOrSubstring)>=0)
            list.add(value);

    }

    @Override
    public List<String> getValuesList() {
        return list;
    }

    @Override
    public void printAllValues()
    {
        for(Object string : list)
            System.out.println(string);
    }

    @Override
    public Integer getValuesSize() {
        return list.size();
    }
}
