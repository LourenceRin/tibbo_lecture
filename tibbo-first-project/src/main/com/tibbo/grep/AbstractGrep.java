package tibbo.grep;

import java.util.ArrayList;

import java.util.List;

abstract class abstrGrep implements Grep{

    String str;

     abstrGrep(String reg){
        str = reg.toLowerCase();
    }

    List<String> list = new ArrayList();


    @Override                                           //входит ли подстрока в строку
    public void checkValue(String value){
        if(value.toLowerCase().indexOf(str) >= 0)
            list.add(value);
    }

    @Override                                         //список всех походящих строк
    public List<String> getValuesList(){
        return list;
    }

    @Override                                          //sout
    public void printAllValues(){
        for(Object string : list)
            System.out.println(string);
    }

    @Override
    public Integer getValuesSize(){         //рамзмер списка
        return list.size();
    }
}
