package tibbo.grep;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegExpGrep extends Grep
{
    RegExpGrep(String regExpOrSubstring)
    {
        this.regExpOrSubstring = regExpOrSubstring.toLowerCase();
    }

    @Override
    public void checkValue(String value)
    {
        Pattern pattern = Pattern.compile(regExpOrSubstring, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(value);
        if(matcher.find())
            list.add(value);
    }
}
