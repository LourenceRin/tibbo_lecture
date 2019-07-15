package tibbo.grep;

import java.util.List;

public class GrepHelper
{
  public static final String GREP_EXPCETION_MESSAGE = "Значение null не подходит для поиска";
  public static final String FIRST_SPLIT_SYMBOL = "\n";
  public static final String SECOND_SPLIT_SYMBOL = " ";
  
  public static Grep getInstance(Integer value, String regExpOrSubstring) throws GrepException
  {
      //0 == StringGrep(regExpOrSubstring);
      //1 == RegExpGrep(regExpOrSubstring);
      //в случае если value != 0 и не равно 1 нужно выбросить исклюечение IllegalArgumentException
      //в случе если regExpOrSubstring == null нужно выбросить исключение GrepException, но выбросить его нужно не отсюда, а из конструктора класса
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
      {
          list.add(i);
      }
      return list;
  }
  
  public static List<String> readValuesFromFile(String filePath)
  {
    return null;
  }
}
