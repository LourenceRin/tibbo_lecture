package tibbo.grep;

public class GrepHelper
{
  public static Grep getInstance(Integer value)
  {
    //value == 0 создаем StringGrep
    //value == 1 создаем RegExpGrep
    if (value == 0) {
      return new StringGrep();
    }else
    return null;
  }
}
