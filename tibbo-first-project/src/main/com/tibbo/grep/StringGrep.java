package tibbo.grep;

import java.util.regex.Pattern;

class StringGrep extends AbstractGrep{

    public void checkValue(String value){
        if(value.toLowerCase().contains(regExpOrSubstring))
            list.add(value);
    }

    private Pattern pattern;

    StringGrep(String reg) throws GrepException {
        super(reg);
        pattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
    }
}