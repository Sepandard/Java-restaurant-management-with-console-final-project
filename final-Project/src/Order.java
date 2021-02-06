import java.util.ArrayList;

public class Order {
    String id;
    int status;
    String waiterName ;
    String feedBack;
    String foodName;
    String price;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getStatus() {
        String statusMeaning = "";
        switch (status){
            case 0:
                statusMeaning = "Preparing";
                break;
            case 1:
                statusMeaning= "Delivered";
                break;
            case 2:
                statusMeaning = "Paid";
                break;

        }
        return statusMeaning;

    }

    public void setStatus(int status) {
        this.status = status;
    }


    public String getWaiterName() {
        return waiterName;
    }

    public void setWaiterName(String waiterName) {
        this.waiterName = waiterName;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }
}
