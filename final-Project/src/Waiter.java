import java.util.ArrayList;

public class Waiter extends Member {
    ArrayList<Integer> tableNumbers = new ArrayList<>();

    public ArrayList<Integer> getTableNumber() {
        return tableNumbers;
    }

    public void setTableNumber(ArrayList<Integer> tableNumber) {
        this.tableNumbers = tableNumber;
    }
}

