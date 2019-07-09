
public class Main
{
  public static void main(String[] args)
  {
    System.out.println("Hello world!");
  }
    public static final String str = "This is the name of Main class";
  public Integer plus(int[] array)
  {
      int summ = 0;
      for(int i:array)
          summ += i;
      return summ;
  }
  
  public String encode(byte[] byteArray)
  {
      return new String(byteArray);
  }
  
  public Boolean stringContains(String value, String subString)
  {
      return value.indexOf(subString)>=0;
  }
  
  @Override
  public String toString()
  {
      return str;
  }
  
  public static Main getInstance()
  {
      return new Main();
  }
}
