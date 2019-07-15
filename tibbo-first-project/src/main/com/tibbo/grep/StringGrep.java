package tibbo.grep;

import java.util.regex.Pattern;

class StringGrep extends AbstractGrep{

    private Pattern pattern;

    StringGrep(String reg) throws GrepException {
        super(reg);
        pattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
    }
}