package tibbo.grep;

public class StringGrep extends Grep
{
    StringGrep(String regExpOrSubstring)
    {
        this.regExpOrSubstring = regExpOrSubstring.toLowerCase();
    }

    @Override
    public void checkValue(String value)
    {
        String _value = value.toLowerCase();
        if(_value.indexOf(regExpOrSubstring)>=0)
            list.add(value);

    }
}
