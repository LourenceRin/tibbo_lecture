package tibbo.grep;

import java.util.ArrayList;

abstract class abstrGrep implements Grep{

    String str;

    abstrGrep(String reg){
        str = reg.toLowerCase();
    }

    ArrayList list = new ArrayList();


    @Override                                           //входит ли подстрока в строку
    public void checkValue(String value){
        if(value.toLowerCase().contains(str))
            list.add(value);
    }

    @Override                                         //список всех походящих строк
    public ArrayList getValuesList(){
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