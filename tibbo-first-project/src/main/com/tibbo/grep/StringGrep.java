package tibbo.grep;

import java.util.List;

public class StringGrep implements Grep
{

    @Override
    public void contains(String regExpOrSubstring, String value)
    {
        if(regExpOrSubstring.indexOf(value)>=0)
            myArray.add(regExpOrSubstring);
    }

    @Override
    public List<String> getValuesList() {
        return myArray;
    }

    @Override
    public void printAllValues()
    {
        for(Object string : myArray)
        {
            System.out.println(string);
        }
    }

    @Override
    public Integer getValuesSize() {
        return myArray.size();
    }
}
