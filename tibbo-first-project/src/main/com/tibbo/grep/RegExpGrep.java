package tibbo.grep;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegExpGrep extends AbstractGrep
{
    private Pattern pattern;
    RegExpGrep(String regExpOrSubstring)
    {
        this.regExpOrSubstring = regExpOrSubstring.toLowerCase();
        pattern = Pattern.compile(regExpOrSubstring, Pattern.CASE_INSENSITIVE);
    }

    @Override
    public void checkValue(String value)
    {
        Matcher matcher = pattern.matcher(value);
        if(matcher.find())
            list.add(value);
    }
}