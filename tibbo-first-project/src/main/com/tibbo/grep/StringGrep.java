package tibbo.grep;

import java.util.regex.Pattern;

public class StringGrep extends AbstractGrep{

     Pattern pattern;

    StringGrep(String reg) throws GrepException {
        super(reg);
        pattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
    }
}