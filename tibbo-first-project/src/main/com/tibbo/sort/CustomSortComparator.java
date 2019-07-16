package tibbo.sort;

import java.util.ArrayList;
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
    if (o1 != null && o2 == null){
      return -1;
    }else if (o1 == null && o2 != null){
      return 1;
    }else if(o1 == null){
      return 0;
    } else if(!(o1 instanceof String) && !(o2 instanceof String)){
      return 0;
    }else if((o1 instanceof String) && (o2 instanceof String)){
      if (o1 != null && o2 == null){
        return -1;
      }else if (o1 == null && o2 != null){
        return 1;
      }else if(o1 == null && o2 == null) {
        return 0;
      }
    }else if (character != null) {
      res = num((String) o1, character) - num((String) o2, character);
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

  @Override
  public void sort() {
    //Сам метод сортироки. Сортировем по количеству символов в строке.
    for(int left = 0; left < list.size(); left++){
      String value = (String) list.get(left);
      int i = left -1;
      for(; i>=0; i--){
        if(compare(value, list.get(i)) == -1){
          list.set(i+1, list.get(i));
        }else{
          break;
        }
      }
      list.set(i + 1, value);
    }
  }

  private int num(String str, Character character1){
    int index = str.indexOf(character1);
    if(index + 1 == str.length()){
      return 1;
    }else if(index != -1){
      return 1 + num(str.substring(index + 1, str.length() - 1), character1);
    }else if(index == -1){
      return 0;
    }
    return 0;
  }
}