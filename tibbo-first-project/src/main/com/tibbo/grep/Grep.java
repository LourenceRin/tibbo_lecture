package tibbo.grep;

import java.util.List;

public interface Grep
{
  /*
  * Реализовать интерфейс Grep;
  * 1) Создать класс StringGrep
  * 2) Создать RegExpGrep
  *
  * */
  
  //значение которое нужно искать в строку я передаю в качетсве параметра класса в конструкторе;
  
  //проверка входит ли подстрока в сторку, либо regexp что то нашел;
<<<<<<< HEAD
  public String contains(String regExpOrSubstring, String value);
=======
  public void checkValue(String value);
>>>>>>> 7d1b9628580068509228180a9b9fdfc0534d45c5
  
  //вовращает список всех строк, которые подошли
  public List<String> getValuesList();
  
  //распечатать в консоль все значения
  public void printAllValues();
  
  //вернуть размер списка
<<<<<<< HEAD
  public int getValuesSize();
=======
  public Integer getValuesSize();
  
>>>>>>> 7d1b9628580068509228180a9b9fdfc0534d45c5
}
