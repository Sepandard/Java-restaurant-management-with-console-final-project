public class Table {
    int status;
    String TableNumber;
    Boolean IsAssigned;
    String waiterName;

    public String getWaiterName() {
        return waiterName;
    }

    public void setWaiterName(String waiterName) {
        this.waiterName = waiterName;
    }

    public Boolean getAssigned() {
        return IsAssigned;
    }

    public void setAssigned(Boolean assigned) {
        IsAssigned = assigned;
    }

    public String getStatus() {
        String statusMeaning = "";
         switch (status){
             case 0:
                 statusMeaning = "Ready to use";
                 break;
             case 1:
                 statusMeaning= "Dirty";
                 break;
             case 2:
                 statusMeaning = "Is Full";
                 break;

         }
         return statusMeaning;

    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTableNumber() {
        return TableNumber;
    }

    public void setTableNumber(String tableNumber) {
        TableNumber = tableNumber;
    }
}
