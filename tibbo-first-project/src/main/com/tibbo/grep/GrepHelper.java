package tibbo.grep;

import java.util.Arrays;
import java.util.List;

public class GrepHelper
{
  public static Grep getInstance(Integer value, String regExpOrSubstring)
  {
      //0 == StringGrep(regExpOrSubstring);
      //1 == RegExpGrep(regExpOrSubstring);
    return null;
  }
  
  public static List<String> prepareValues(String value, String splitSymbol)
  {
<<<<<<< HEAD
    //value == 0 создаем StringGrep
    //value == 1 создаем RegExpGrep
    if (value == 0) {
      return new StringGrep();
    }else
=======
>>>>>>> 7d1b9628580068509228180a9b9fdfc0534d45c5
    return null;
  }
}
