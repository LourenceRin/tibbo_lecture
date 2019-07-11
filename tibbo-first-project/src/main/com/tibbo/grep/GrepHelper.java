package tibbo.grep;

import java.util.ArrayList;
import java.util.List;

public class GrepHelper
{
  public static Grep getInstance(Integer value, String regExpOrSubstring)
  {
      //0 == StringGrep(regExpOrSubstring);
      //1 == RegExpGrep(regExpOrSubstring);
    if(value == 0)
      return new StringGrep(regExpOrSubstring);
    if(value == 1)
      return new RegExpGrep(regExpOrSubstring);
    return null;
  }
  
  public static List<String> prepareValues(String value, String splitSymbol)
  {
      List<String> list = new ArrayList();
      String[] myList = value.split(splitSymbol);
      for(String i:myList)
          list.add(i);
      return list;
  }
}
