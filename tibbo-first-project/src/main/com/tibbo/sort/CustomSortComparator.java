package tibbo.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomSortComparator implements Sort {


  private List list = new ArrayList();
  private Character character = null;

  @Override
  public int compare(Object o1, Object o2) {
    //Метод сравнения, возращает 1 0 или -1 d зависимости от того какое из значений больше
    //Что тут нужно будет сделать если мы сортируем в обратную стороную?

    int res = 0;
    /*
    if (o1 instanceof String && o2 instanceof String){
      res = ((String) o1).compareTo((String) o2);
     //res = o1.toString().compareTo(o1.toString());
    }else if (character != null){
      res = num((String) o1, character) - num((String) o2, character);
    }else if (o1 == null || o2 == null){

    } */
    if (!(o1 instanceof String) && !(o2 instanceof String)) {
      return 0;
    } else if ((o1 instanceof String) && (o2 instanceof String)) {
      if (o1 != null && o2 == null) {
        return -1;
      } else if (o1 == null && o2 != null) {
        return 1;
      } else if (o1 == null && o2 == null) {
        return 0;
      }
    } else if (character != null) {
      res = num((String) o1) - num((String) o2);
    } else {
      res = o1.toString().compareTo(o1.toString());
    }
    return Integer.compare(res, 0);

    //  return Integer.compare(res, 0);
  }

  @Override
  public void setComparatorSymbol(Character symbol) {
    //Если symbol == null то в таком случае у нас нет символа по которому мы будет сравнить строки.
    //Сравнить в таком случае нужно по общему количеству симоволов в строке
    character = symbol;
  }

  @Override
  public void setAscending(Boolean value) {
    //Нужно запомнить в какую сторону мы сортирутем. true по возврастанию, false - по убыванию
    boolean ascending = value;
  }

  @Override
  public void setValuesList(List<String> values) {
    //В этом случае нужно запомнить values.
    //Чтобы при сортировке не измениеть исходный список нужно как то его скопировать и запомнить уже копию;
    list = new ArrayList<>(values);
  }

  @Override
  public List<String> getvaluesList() {
    //вернуть список уже после сортировки
    return list;
  }


  public void quickSort(int low, int high) {
    //Сам метод сортироки. Сортировем по количеству символов в строке.
    if (low >= high)
      return;
    int i = low, j = high;
    int res = i - (i - j) / 2;
    while (i < j) {
      while (i < res && (compare(list.get(i), list.get(res)) < 1)) {
        i++;
      }
      while (j > res && (compare(list.get(res), list.get(j)) < 1)) {
        j--;
      }
      if (i < j) {
        Collections.swap(list, i, j);
        if (i == res) {
          res = j;
        } else if (j == res) {
          res = i;
        }
      }
    }
    quickSort(low, res);
    quickSort(res + 1, high);
  }


  @Override
  public void sort() {
    quickSort(0, list.size() - 1);
  }

    private int num (String str){
      int index = 0;
      for (Character ignored : str.toCharArray())
        if (index + 1 == str.length()) {
          return 1;
        } else {
          return 1 + num(str.substring(index + 1, str.length() - 1));
        }
      return index;
    }
  }


