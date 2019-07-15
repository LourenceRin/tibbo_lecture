package tibbo.grep;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegExpGrep extends AbstractGrep{

    public void checkValue(String value)
    {
        Pattern pattern = Pattern.compile(regExpOrSubstring, Pattern.CASE_INSENSITIVE);
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
