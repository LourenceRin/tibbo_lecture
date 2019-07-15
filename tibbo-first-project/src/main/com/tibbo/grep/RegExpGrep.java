package tibbo.grep;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegExpGrep extends AbstractGrep{

    Pattern pattern = Pattern.compile(regExpOrSubstring, Pattern.CASE_INSENSITIVE);

    public void checkValue(String value)
    {
        Matcher matcher = pattern.matcher(value);
        while(matcher.find()) {
            list.add(value);
            break;
        }

    }
    RegExpGrep(String reg) throws GrepException {
        super(reg);
    }
}