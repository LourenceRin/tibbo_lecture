package tibbo.grep;

public class StringGrep extends AbstractGrep
{
    StringGrep(String regExpOrSubstring) throws GrepException
    {
        super(regExpOrSubstring);
    }

    @Override
    public void checkValue(String value)
    {
        if(value.toLowerCase().indexOf(regExpOrSubstring)>=0)
            list.add(value);
    }
}
