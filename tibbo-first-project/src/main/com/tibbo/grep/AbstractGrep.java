package tibbo.grep;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGrep implements Grep
{
    protected String regExpOrSubstring;
    protected List<String> list = new ArrayList();

    public void checkValue(String value){}

    public List<String> getValuesList() {
        return list;
    }

    public void printAllValues()
    {
        for(Object string : list)
            System.out.println(string);
    }

    public Integer getValuesSize() {
        return list.size();
    }
}