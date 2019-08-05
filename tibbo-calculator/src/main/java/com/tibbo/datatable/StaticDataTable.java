package com.tibbo.datatable;

import com.tibbo.aggregate.common.datatable.*;

import java.util.Date;

public class StaticDataTable

{

  public static DataTable getSimpleTable()
  {
    TableFormat tableFormat = new TableFormat(1, 1);

    FieldFormat fieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_INTEGER_TEST, FieldFormat.INTEGER_FIELD, StaticDataTableHelper.INTEGER_DESCRIPTION, StaticDataTableHelper.INTEGER_DEFAULT_VALUE, true);

    FieldFormat secondfieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_DOUBLE_FIELD, FieldFormat.DOUBLE_FIELD, StaticDataTableHelper.DOUBLE_DESCRIPTION, 3.4, true);

    FieldFormat thirdfieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_BOOLEAN_FIELD, FieldFormat.BOOLEAN_FIELD, StaticDataTableHelper.BOOLEAN_DESCRIPTION, true, true);

    FieldFormat fourthfieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_LONG_FIELD, FieldFormat.LONG_FIELD, StaticDataTableHelper.LONG_DESCRIPTION, 3, true);

    FieldFormat fifthfieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_FLOAT_FIELD, FieldFormat.FLOAT_FIELD, StaticDataTableHelper.FLOAT_DESCRIPTION, 1.5, true);

    FieldFormat sixthfieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_STRING_TEST, FieldFormat.STRING_FIELD,StaticDataTableHelper.STRING_DESCRIPTION, "Default value" , true);
    sixthfieldFormat.setHidden(true);
    sixthfieldFormat.setReadonly(true);

    FieldFormat seventhfieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_DATE_FIELD, FieldFormat.DATE_FIELD, StaticDataTableHelper.DATE_DESCRIPTION, new Date(1212121212121L), true);

    FieldFormat eighththfieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_DATATABLE_FIELD, FieldFormat.DATATABLE_FIELD, StaticDataTableHelper.DATATABLE_DESCRIPTION, new SimpleDataTable(), true);


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

    TableFormat tableFormat = new TableFormat();
    FieldFormat firstFieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_DATATABLE_FIELD, FieldFormat.DATATABLE_FIELD, StaticDataTableHelper.DATATABLE_DESCRIPTION, getSimpleTable(), true);
    FieldFormat seconfFieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_INTEGER_TEST, FieldFormat.INTEGER_FIELD, StaticDataTableHelper.INTEGER_DESCRIPTION, 5, true);
    FieldFormat thirdieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_INTEGER_TEST, FieldFormat.INTEGER_FIELD, StaticDataTableHelper.INTEGER_DESCRIPTION, 6, true);
    FieldFormat fourththFieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_INTEGER_TEST, FieldFormat.INTEGER_FIELD, StaticDataTableHelper.INTEGER_DESCRIPTION, 7, true);
    FieldFormat fifthFieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_INTEGER_TEST, FieldFormat.INTEGER_FIELD, StaticDataTableHelper.INTEGER_DESCRIPTION, 8, true);

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
    TableFormat tableFormat = new TableFormat();

    FieldFormat stringFieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_STRING_TEST, FieldFormat.STRING_FIELD,StaticDataTableHelper.STRING_DESCRIPTION , "10" , true);
    FieldFormat integerFieldFormat = FieldFormat.create(StaticDataTableHelper.FIELD_INTEGER_TEST, FieldFormat.INTEGER_FIELD, StaticDataTableHelper.INTEGER_DESCRIPTION, 10, true);

    tableFormat.addField(integerFieldFormat);
    tableFormat.addField(stringFieldFormat);

    DataTable table = new SimpleDataTable(tableFormat);



    for(int i =0; i < 50; i++){
      if (i == 44){
        table.addRecord(50,"50",123);
      }else {
        table.addRecord(10, "10", 123);
      }
    }

    return table;
  }
}
