package tibbo.grep;

import java.util.ArrayList;

abstract class AbstractGrep implements Grep{

    AbstractGrep(String regExpOrSubstring) throws GrepException{
        if (regExpOrSubstring == null){
            throw new GrepException(GrepHelper.GREP_EXPCETION_MESSAGE);
        }else {
            this.regExpOrSubstring = regExpOrSubstring.toLowerCase();
        }
    }

    String regExpOrSubstring;

  /*  AbstractGrep(String regExpOrSubstring){
        regExpOrSubstring = regExpOrSubstring.toLowerCase();
    } */

    ArrayList list = new ArrayList();




    @Override                                           //входит ли подстрока в строку
    public void checkValue(String value){
        if(value.toLowerCase().contains(regExpOrSubstring))
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