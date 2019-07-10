package tibbo.grep;

import java.util.ArrayList;
import java.util.List;

public class StringGrep implements Grep {

    String word;
    List list = new ArrayList();

    @Override
    public String contains(String regExpOrSubstring, String value) { // ищет слово в тексте
        boolean str = regExpOrSubstring.contains(value);
        if (str == true) {
            word = regExpOrSubstring;
            return word;
        } else {
            return "ничего не найдено";
        }
    }

    @Override
    public List<String> getValuesList() { // список всех слов которые подошли
        list.add(word);
        return list;
    }

    @Override
    public void printAllValues() { //вывод всех найденых слов
        for (Object i : list) {
            System.out.println(i);
        }
    }

    @Override
    public int getValuesSize() {// сколько слов мы нашли
        int num = 0;
        for (Object i : list) {
            num = list.size();
        }
        return num;
    }
}
