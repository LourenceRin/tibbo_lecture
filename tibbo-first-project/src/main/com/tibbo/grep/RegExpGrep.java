package tibbo.grep;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegExpGrep implements Grep
{
    @Override
    public void contains(String regExpOrSubstring, String value)
    {
        Pattern pattern = Pattern.compile(value , Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(regExpOrSubstring);
        matcher.find();
        if(Pattern.CASE_INSENSITIVE>0)
            myArray.add(regExpOrSubstring);
    }

    @Override
    public List<String> getValuesList() {
        return myArray;
    }

    @Override
    public void printAllValues()
    {
        for(Object string : myArray)
        {
            System.out.println(string);
        }
    }

    @Override
    public Integer getValuesSize() {
        return myArray.size();
    }
}
