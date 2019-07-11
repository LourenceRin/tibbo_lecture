package tibbo.grep;

import java.util.ArrayList;
import java.util.List;

public abstract class Grep
{
  /*
  * Реализовать интерфейс Grep;
  * 1) Создать класс StringGrep
  * 2) Создать StringGrep
  *
  * */
  String regExpOrSubstring;
  //значение которое нужно искать в строку я передаю в качетсве параметра класса в конструкторе;
  List<String> list = new ArrayList();
  //проверка входит ли подстрока в сторку, либо regexp что то нашел;
  public void checkValue(String value){}

  //вовращает список всех строк, которые подошли

  public List<String> getValuesList() {
    return list;
  }
  
  //распечатать в консоль все значения
  public void printAllValues()
  {
    for(Object string : list)
      System.out.println(string);
  }


  //вернуть размер списка
  public Integer getValuesSize() {
    return list.size();
  }
}
