package tibbo;

public class Main
{
  public static void main(String[] args)
  {
    System.out.println("Hello world!");
  }

  public static final String string = "This is the name of Main class";
  public Integer plus(int[] array)
  {
    int sum = 0;
    for (int i : array) {
      sum += i;
    }
    return sum;
  }

  public String encode(byte[] byteArray){
    return new String(byteArray);
  }


  public Boolean stringContains(String value, String subString){
    return value.contains(subString);
  }

  @Override
  public String toString()
  {
    return string.getClass().getName();
  }

  public static Main getInstance(){
    return new Main();
  }
}
