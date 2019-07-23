package tibbo.sort;

import java.util.*;

public class CustomSortComparator implements Sort
{
  private List<String> list;
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

  private void qSort(int low,int high)
    {
        if (list.size() == 0)
            return;
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        String opora = list.get(middle);
        int i = low, j = high;
        while (i <= j) {
            while(compare(list.get(i),opora)<0)
                i++;
            while(compare(list.get(j),opora)>0)
                j--;

            if (i <= j) {
                String temp = list.get(i);
                list.set(i,list.get(j));
                list.set(j,temp);
                i++;
                j--;
            }
        }
        if (low < j)
            qSort(low, j);
        if (high > i)
            qSort( i, high);
    }

  @Override
  public void sort()
  {
      int low =0;
      int high = list.size()-1;
      qSort(low,high);
  }
}
