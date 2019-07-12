package tibbo.grep;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegExpGrep extends abstrGrep{

    public void checkValue(String value)      ////входит ли подстрока в строку
    {
        Pattern pattern = Pattern.compile(str, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(value);
        while(matcher.find()) {
            list.add(value);
            break;
        }

    }

    RegExpGrep(String reg) {
        super(reg);
    }
}
