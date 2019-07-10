package tibbo.grep;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegExpGrep implements Grep
{
    String regExpOrSubstring;
    RegExpGrep(String regExpOrSubstring)
    {
        this.regExpOrSubstring = regExpOrSubstring;
    }

    List<String> list = new ArrayList<>();


    @Override
    public void checkValue(String value)
    {
        Pattern pattern = Pattern.compile(value , Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(regExpOrSubstring);
        matcher.find();
        if(Pattern.CASE_INSENSITIVE>0)
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
