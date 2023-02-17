package utilities;

public class ReUsableMethods {

    public String findLocationOfElementInSpecificTableCell(int row, int data){

        String xpath = "//table/tbody/tr[" + row + "]/td[" + data + "]";
        return xpath;

    }

    public String findLocationOfElementInSpecificTableCell(int table, int row, int data){

        String xpath = "//table[" + table + "]/tbody/tr[" + row + "]/td[" + data + "]";
        return xpath;

    }

}
