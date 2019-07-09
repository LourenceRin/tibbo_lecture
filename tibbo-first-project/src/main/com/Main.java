
public class Main
{
  public static void main(String[] args)
  {
    System.out.println("Hello world!");
  }
  public Integer plus(int[] array)
  {
      int summ=0;
      for(int i=0;i<array.length;i++)
      {
          summ+=array[i];
      }
      return summ;
  }
  
  public String encode(byte[] byteArray)
  {
      String solution = new String(byteArray);
      return solution;
  }
  
  public Boolean stringContains(String value, String subString)
  {
      int index = value.indexOf(subString);
      if(index>=0)
          return true;
      else
          return false;

  }
  
  @Override
  public String toString()
  {
      String solution = "This is the name of Main class";
      return solution;
  }
  
  public static Main getInstance()
  {
      Main main = new Main();
      return main;
  }
}
