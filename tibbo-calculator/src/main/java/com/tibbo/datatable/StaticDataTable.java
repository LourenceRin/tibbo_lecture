package com.tibbo.datatable;

import com.tibbo.aggregate.common.datatable.*;

import java.util.Date;

public class StaticDataTable

{

  public static DataTable getSimpleTable()
  {
    TableFormat tableFormat = new TableFormat(1, 1);

    FieldFormat<Integer> fieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_INTEGER_TEST, FieldFormat.INTEGER_FIELD, "Индекс", 5, true);

    FieldFormat<Double> secondfieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_DOUBLE_FIELD, FieldFormat.DOUBLE_FIELD, "Имя", 3.4, true);

    FieldFormat<Boolean> thirdfieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_BOOLEAN_FIELD, FieldFormat.BOOLEAN_FIELD, "Фамилия", true, true);

    FieldFormat<Integer> fourthfieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_LONG_FIELD, FieldFormat.LONG_FIELD, "Номер", 3, true);

    FieldFormat <Double>fifthfieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_FLOAT_FIELD, FieldFormat.FLOAT_FIELD, "первое значение", 1.5, true);

    FieldFormat <String>sixthfieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_STRING_TEST, FieldFormat.STRING_FIELD,"второе значение", "Default value" , true);
    sixthfieldFormat.setHidden(true);
    sixthfieldFormat.setReadonly(true);

    FieldFormat<Date> seventhfieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_DATE_FIELD, FieldFormat.DATE_FIELD, "третье значение", new Date(1212121212121L), true);

    FieldFormat<DataTable> eighththfieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_DATATABLE_FIELD, FieldFormat.DATATABLE_FIELD, "четвертое значение", new SimpleDataTable(), true);


    tableFormat.addField(fieldFormat);//field descriptor to field format
    tableFormat.addField(secondfieldFormat);
    tableFormat.addField(thirdfieldFormat);
    tableFormat.addField(fourthfieldFormat);
    tableFormat.addField(fifthfieldFormat);
    tableFormat.addField(sixthfieldFormat);
    tableFormat.addField(seventhfieldFormat);
    tableFormat.addField(eighththfieldFormat);

      return new SimpleDataTable(tableFormat);
  }
  
  public static DataTable getInnerTable()
  {

    TableFormat tableFormat = new TableFormat(5, 5);
    FieldFormat<DataTable> firstFieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_DATATABLE_FIELD, FieldFormat.DATATABLE_FIELD, "четвертое значение", getSimpleTable(), true);
    FieldFormat<Integer> seconfFieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_INTEGER_TEST, FieldFormat.INTEGER_FIELD, "Индекс", 5, true);
    FieldFormat<Integer> thirdieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_INTEGER_TEST, FieldFormat.INTEGER_FIELD, "Индекс", 6, true);
    FieldFormat<Integer> fourththFieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_INTEGER_TEST, FieldFormat.INTEGER_FIELD, "Индекс", 7, true);
    FieldFormat<Integer> fifthFieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_INTEGER_TEST, FieldFormat.INTEGER_FIELD, "Индекс", 8, true);

    tableFormat.addField(firstFieldFormat);
    tableFormat.addField(seconfFieldFormat);
    tableFormat.addField(thirdieldFormat);
    tableFormat.addField(fourththFieldFormat);
    tableFormat.addField(fifthFieldFormat);

   // DataTable cloneTable = getSimpleTable().clone();


    //cloneTable.getRecord(0);

    DataTable table = new SimpleDataTable(tableFormat);

    table.addRecord(getSimpleTable(),true,12345);
    table.addRecord(getSimpleTable(),true,124345);
    table.addRecord(getSimpleTable(),true,4);
    table.addRecord(getSimpleTable(),true,2);
    table.addRecord(getSimpleTable(),true,3);

    return table;
  }
  
  public static DataTable getBigTable()
  {
    TableFormat tableFormat = new TableFormat(50, 50);

    FieldFormat <String>stringFieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_STRING_TEST, FieldFormat.STRING_FIELD,"второе значение", "10" , true);
    FieldFormat<Integer> integerFieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_INTEGER_TEST, FieldFormat.INTEGER_FIELD, "Индекс", 10, true);

    tableFormat.addField(integerFieldFormat);
    tableFormat.addField(stringFieldFormat);

    DataTable table = new SimpleDataTable(tableFormat);



    for(int i =0; i < 50; i++){
      if (i == 45){
        table.addRecord(50,"50",123);
      }else {
        table.addRecord(10, "10", 123);
      }
    }

    return table;
  }
}
