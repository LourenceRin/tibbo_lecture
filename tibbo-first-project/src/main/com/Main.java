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
    for (int i : array) {
      sum += i;
    }
    return sum;
  }
  
  public String encode(byte[] byteArray)
  {
    return new String(byteArray);
  }
  
  public Boolean stringContains(String value, String subString)
  {
    String string = value, string1 = subString;
    return string.contains(string1);
  }
  @Override
  public String toString()
  {
    return "This is the name of Main class";
  }
  
  public static Main getInstance()
  {
    return new Main();
  }
}
