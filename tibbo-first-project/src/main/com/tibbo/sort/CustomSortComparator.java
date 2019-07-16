package tibbo.sort;

import java.util.*;

public class CustomSortComparator implements Sort
{
  private List<String> list = new ArrayList<>();
  private int direction;
  private boolean haveSymbol;
  private Character _symbol;

  private Integer count(String string)
  {
    int count = 0;
    int index=0;
    while(index>=0)
    {
      index = string.indexOf(_symbol,index+1);
      if(index>0)
        count++;
    }
    return count;
  }


  @Override
  public int compare(Object o1, Object o2) {
    //Метод сравнения, возращает 1 0 или -1 d зависимости от того какое из значений больше
    //Что тут нужно будет сделать если мы сортируем в обратную стороную?
    if(o1 instanceof String && o2 instanceof String) {
      if (haveSymbol)
        return count(o1.toString()).compareTo(count(o2.toString())) * direction;
      else {
        Integer int1 = o1.toString().length();
        Integer int2 = o2.toString().length();
        return int1.compareTo(int2);
      }
    }
    else
    {
      Boolean bool1 = o1 != null;
      Boolean bool2 = o2 != null;
      return bool1.compareTo(bool2)*direction;
    }
  }
  
  @Override
  public void setComparatorSymbol(Character symbol)
  {
    //Если symbol == null то в таком случае у нас нет символа по которому мы будет сравнить строки.
    //Сравнить в таком случае нужно по общему количеству симоволов в строке
    haveSymbol = symbol != null;
    if(haveSymbol)
      _symbol=symbol;
  }
  
  @Override
  public void setAscending(Boolean value)
  {
    //Нужно запомнить в какую сторону мы сортирутем. true по возврастанию, false - по убыванию
    if(value)
      direction = 1;
    else
      direction = -1;
  }
  
  @Override
  public void setValuesList(List<String> values)
  {
    //В этом случае нужно запомнить values.
    //Чтобы при сортировке не измениеть исходный список нужно как то его скопировать и запомнить уже копию;
    for(String i : values)
      list.add(i);
  }
  
  @Override
  public List<String> getvaluesList()
  {
    //вернуть список уже после сортировки
    sort();
    return list;
  }
  
  @Override
  public void sort()
  {
    //Сам метод сортироки. Сортировем по количеству символов в строке.
    for (int i = 1; i < list.size(); i++) {
      String current = list.get(i);
      int j = i - 1;
      while(j >= 0 && (compare(current,list.get(j)))<0) {
        list.set(j+1,list.get(j));
        j--;
      }
      // в этой точке мы вышли, так что j так же -1
      // или в первом элементе, где текущий >= a[j]
      list.set(j+1,current);
    }
  }
}
