package tibbo.sort;

import java.util.*;

public class CustomSortComparator implements Sort
{
  public List<String> list;
  private int direction;
  private Character symbol;

  private Integer count(String string)
  {
    int count = 0;
    int index=0;
    while(index>=0)
    {
      index = string.indexOf(symbol,index+1);
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
      if (symbol!=null)
        return count(o1.toString()).compareTo(count(o2.toString())) * direction;
      else {
        Integer firstLenght = o1.toString().length();
        Integer secondLenght = o2.toString().length();
        return firstLenght.compareTo(secondLenght);
      }
    }
    else
    {
      Boolean isFirstNotNull = o1 != null;
      Boolean isSecondNotNull = o2 != null;
      return isFirstNotNull.compareTo(isSecondNotNull)*direction;
    }
  }
  
  @Override
  public void setComparatorSymbol(Character symbol)
  {
    //Если symbol == null то в таком случае у нас нет символа по которому мы будет сравнить строки.
    //Сравнить в таком случае нужно по общему количеству симоволов в строке
    this.symbol=symbol;
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
    list = new ArrayList<>(values);
  }
  
  @Override
  public List<String> getvaluesList()
  {
    //вернуть список уже после сортировки
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