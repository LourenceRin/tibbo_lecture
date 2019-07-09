import sun.awt.CharsetString;

import java.nio.charset.Charset;
import java.util.Arrays;

public class Main
{
  public static void main(String[] args)
  {
    System.out.println("Hello world!");
  }
  
  public Integer plus(int[] array)
  {
    int sum = 0;
    for (int i = 0; i < array.length; i++) sum = sum + array[i];
    return sum;
  }
  
  public String encode(byte[] byteArray)
  {
    String str = new String(byteArray);
    return str;
  }
  
  public Boolean stringContains(String value, String subString)
  {
    String string = value, string1 = subString;

    Boolean bool = true;
    if (string.contains(string1)){
      bool = true;
    }else {
      bool = false;
    }
    return bool;
  }
  @Override
  public String toString()
  {
    //String className = this.getClass().getSimpleName();
    String str = "This is the name of Main class"; //знаю что не то, пытаюсь переделать
    return str;
  }
  
  public static Main getInstance()
  {
    Main main = new Main();
    return main;
  }
}
