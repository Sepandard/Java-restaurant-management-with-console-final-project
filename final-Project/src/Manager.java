import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Manager extends  Member implements Login{

    String waiterLogin="";

    public void waiterList(){
        String userName  ;
        String passWord  ;

        try {
            Scanner X = new Scanner(new File("Waiter.txt"));
            X.useDelimiter("[Δ\n]");
            int i=1;
                System.out.println("No. \t username");
            while (X.hasNext()) {
                userName = X.next();
                passWord = X.next();


                System.out.println(i+"\t  "+userName);
                i++;
            }


        } catch (Exception e) {
            System.out.println("something went wrong");


        }
    }
    public void orderList(){
        String id;
        String status;
        String waiterName ;
        String feedBack;
        String foodName;
        String price;
        try {
            Scanner X = new Scanner(new File("Order.txt"));
           
            X.useDelimiter("[Δ\n]");
            int i=1;
            System.out.println("No. \t Order Id \t foodName \t waiterName \t status  \t price  \t feed Back ");
            while (X.hasNext()) {
                id = X.next();
                foodName=X.next();
                price=X.next();
                status = X.next();
                waiterName =X.next();
                feedBack=X.next();

                System.out.println(i+"\t  "+id+"\t\t"+foodName+"\t\t"+price+"\t\t"+waiterName+"\t\t"+status+"\t\t"+price+"\t\t"+feedBack);
                i++;
            }

            X.close();   
            X=null;   
        } catch (Exception e) {
            System.out.println("something went wrong");


        }
    }
    public void chefList(){
        String userName  ;
        String passWord  ;

        try {
            Scanner X = new Scanner(new File("Chef.txt"));
            X.useDelimiter("[Δ\n]");
            int i=1;
                System.out.println("No. \t username");
            while (X.hasNext()) {
                userName = X.next();
                passWord = X.next();


                System.out.println(i+"\t  "+userName);
                i++;
            }
            X.close(); 
            X=null;   

        } catch (Exception e) {
            System.out.println("something went wrong");


        }
    }
    public void tableList(){
        String tableNumber;
        String waitersName;
        String Status;
        String assigned;
        try {
            Scanner X = new Scanner(new File("Table.txt"));
            X.useDelimiter("[Δ\n]");
            int i=1;
            System.out.println("No.\t table Number\t assigned \t Status \t");
            while (X.hasNext()) {
                tableNumber = X.next();
                assigned=X.next();
                Status=X.next();
                waitersName=X.next();

                System.out.println(i+"\t  "+tableNumber+"\t  "+assigned+"\t  "+Status+"\t  "+waitersName);
                i++;
            }
            X.close(); 
            X=null;   

        } catch (Exception e) {
            System.out.println("something went wrong");


        }
    }

    public void loginMenu() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("** Login Menu **");
            System.out.println("-\t1.Admin Login");
            System.out.println("-\t2.Waiter Login");
            System.out.println("-\t3.Chef Login");
            System.out.println("-\t4.Cashier Login");
            int userInput = input.nextInt();
            if (userInput == 1) {
                login();

            } else if (userInput == 2) {
                waiterLogin();
            } else if (userInput == 3) {
                chefLogin();
            } else if (userInput == 4) {
                chasherLogin();
            }
        } catch (Exception e) {
            System.out.println("your input is Invalid");
            loginMenu();
        }
    }

    @Override
    public boolean login() {
        Scanner input = new Scanner(System.in);
        Boolean userExist = true;
        System.out.println("** Enter Username and Password ** \n ** manger login **\n  type '99' for go  login menu");
        setUserName(input.nextLine());
        setPassWord(input.nextLine());
        String str = getUserName();
        str = str.replaceAll("\\s", "");
        str = str.toLowerCase();


        if (getUserName().equals("admin") && getPassWord().equals("admin")) {
            mangerMenu();
            return true;

        } else if (str.equals("99")) {
            loginMenu();
        } else {
            System.out.println("|| Username or password is wrong ||");
            login();
            return false;
        }
        return false;
    }
    public void waiterLogin() {
        Scanner input = new Scanner(System.in);
        Scanner inputPass = new Scanner(System.in);
        String inputUsername;
        String inputPassword;
        String userName  ;
        String passWord ;
        System.out.println("** Enter Username and Password ** \n ** Waiter login **\n  type '99' for go  login menu");
        inputUsername = input.nextLine();
        inputPassword = inputPass.nextLine();
        Boolean found = false;
        try {
            Scanner X = new Scanner(new File("Waiter.txt"));
            X.useDelimiter("[Δ\n]");
            while (X.hasNext() && found==false) {
                userName = X.next();
                passWord = X.next();
                passWord= passWord.replaceAll("\\s", "");
                System.out.println(userName+"~"+passWord);
                System.out.println(userName.equals(inputUsername)+"~"+passWord.equals(inputPassword));
                if (userName.equals(inputUsername) && passWord.equals(inputPassword)) {
                    found = true;
                }
            }
                if(found==true){
                    waiterLogin=inputUsername;
                    waiterMenu();
                }else if (inputUsername.equals("99")) {
                    loginMenu();
                } else {
                    System.out.println("|| Username or password is wrong ||");
                    waiterLogin();

                }

        } catch (Exception e) {
            System.out.println("something went wrong "+e);
            loginMenu();

        }

    }
   public void chefLogin(){
        Scanner input = new Scanner(System.in);
       Scanner inputPass = new Scanner(System.in);
       String inputUsername;
       String inputPassword;
       String userName  ;
       String passWord ;
       System.out.println("** Enter Username and Password ** \n ** Chef login **\n  type '99' for go  login menu");
       inputUsername = input.nextLine();
       inputPassword = inputPass.nextLine();
       Boolean found = false;
       try {
           Scanner X = new Scanner(new File("Chef.txt"));
           X.useDelimiter("[Δ\n]");
           while (X.hasNext() && found==false) {
               userName = X.next();
               passWord = X.next();
               passWord= passWord.replaceAll("\\s", "");
               if (userName.equals(inputUsername) && passWord.equals(inputPassword)) {
                   found = true;
                   
               }
             
           }
           if(found==true){
               chefMenu();
           }else if (inputUsername.equals("99")) {
               loginMenu();
           } else {
               System.out.println("|| Username or password is wrong ||");
            chefLogin();

           }

       } catch (Exception e) {
           System.out.println("something went wrong");
           loginMenu();

       }}

       private void chasherLogin(){
           Scanner input = new Scanner(System.in);
           Boolean userExist = true;
           System.out.println("** Enter Username and Password ** \n ** Chashier login **\n  type '99' for go  login menu");
           setUserName(input.nextLine());
           setPassWord(input.nextLine());
           String str = getUserName();
           str = str.replaceAll("\\s", "");
           str = str.toLowerCase();


           if (getUserName().equals("cashier") && getPassWord().equals("cashier")) {
               cashierMenu();


           } else if (str.equals("99")) {
               loginMenu();
           } else {
               System.out.println("|| Username or password is wrong ||");
               loginMenu();

           }

       }

    public  void mangerMenu(){

        System.out.println("-------------------------------------------------");
        System.out.println("** Mangers Menu **");
        System.out.println("1.Add Waiter");
        System.out.println("2.Remove Waiter");
        System.out.println("3.Add Chef");
        System.out.println("4.Remove Chef");
        System.out.println("5.Order List");
        System.out.println("6.Add Table");
        System.out.println("7.Assigned Table to Waiter");
        System.out.println("8.Log out");
        Scanner UserInput =new Scanner(System.in);
        int numberOfOption = UserInput.nextInt();
        try {

            if (numberOfOption==1){
                try {
                System.out.println("------------- Add Waiter -------------");
                Waiter waiter = new Waiter();
                Scanner addUserInput =new Scanner(System.in);
                String inputUsername;
                String inputPassWord;

                System.out.println("Enter Username: ");
                inputUsername = addUserInput.next();
                waiter.setUserName(inputUsername);
                System.out.println("Enter Password: ");
                inputPassWord = addUserInput.next();
                waiter.setPassWord(inputPassWord);

                System.out.println("User Username: " + inputUsername);
                System.out.println("User Password: " + inputPassWord);

                    FileWriter fw = new FileWriter("Waiter.txt",true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);

                    pw.println(inputUsername+"Δ"+inputPassWord);
                    pw.flush();
                    pw.close();
                    mangerMenu();

                }catch (Exception e){
                    System.out.println("something went wrong");
                    waiterMenu();
                }


            }else if (numberOfOption==2){

                Scanner addUserInput =new Scanner(System.in);
                String inputUsername;
                waiterList();
                System.out.println("Enter Username for remove waiter: ");
                inputUsername = addUserInput.next();
                File oldFile = new File("Waiter.txt");
                File newFile = new File("temp.txt");
                String userName ;
                String passWord ;
                try {
                FileWriter fw = new FileWriter("temp.txt",true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                Scanner X = new Scanner(new File("Waiter.txt"));
                X.useDelimiter("[Δ\n]");
                while (X.hasNext()){
                    userName = X.next();
                    passWord=X.next();
                    if (!userName.equals(inputUsername)){
                        pw.println(userName+"Δ"+passWord);
                    }
                }
                X.close();
                    X=null;
                pw.flush();
                pw.close();
                System.gc();
                Boolean isRemove=oldFile.delete();
                File dump = new File("Waiter.txt");
                Boolean isRename = newFile.renameTo(dump);
                    System.out.println(isRename+"~"+isRemove);
                if (isRemove && isRename) {
                    System.out.println("remove successfully");
                    mangerMenu();
                }else {
                    System.out.println("remove Failed");
                    newFile.delete();
                    mangerMenu();
                }
                }catch (Exception e){
                    System.out.println("something Went Wrong");
                    newFile.delete();
                    mangerMenu();
                }

            }else if (numberOfOption==3){
                Chef chef = new Chef();
                Scanner addUserInput =new Scanner(System.in);
                String inputUsername;
                String inputPassWord;

                System.out.println("Enter Username: ");
                inputUsername = addUserInput.next();
                chef.setUserName(inputUsername);
                System.out.println("Enter Password: ");
                inputPassWord = addUserInput.next();
                chef.setPassWord(inputPassWord);

                System.out.println("User Username: " + inputUsername);
                System.out.println("User Password: " + inputPassWord);

                FileWriter fw = new FileWriter("Chef.txt",true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                pw.println(inputUsername+"Δ"+inputPassWord);
                pw.flush();
                pw.close();
                mangerMenu();
            }else if (numberOfOption==4){

                Scanner addUserInput =new Scanner(System.in);
                String inputUsername;
                chefList();
                System.out.println("Enter Username for remove chef: ");
                inputUsername = addUserInput.next();
                File oldFile = new File("Chef.txt");
                File newFile = new File("temp.txt");
                String userName ;
                String passWord ;
                try {
                    FileWriter fw = new FileWriter("temp.txt",true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);
                    Scanner X = new Scanner(new File("Chef.txt"));
                    X.useDelimiter("[Δ\n]");
                    while (X.hasNext()){
                        userName = X.next();
                        passWord=X.next();
                        if (!userName.equals(inputUsername)){
                            pw.println(userName+"Δ"+passWord);
                        }
                    }
                    X.close();
                    X=null;
                    pw.flush();
                    pw.close();
                    System.gc();
                    Boolean isRemove=oldFile.delete();
                    File dump = new File("Chef.txt");
                    Boolean isRename = newFile.renameTo(dump);
                    System.out.println(isRename+"~"+isRemove);
                    if (isRemove && isRename) {
                        System.out.println("remove successfully");
                        mangerMenu();
                    }else {
                        System.out.println("remove Failed");
                        isRemove=newFile.delete();
                        mangerMenu();
                    }
                }catch (Exception e){
                    System.out.println("something Went Wrong");
                    Boolean isRemove=newFile.delete();
                    mangerMenu();
                    
                }
            }else if(numberOfOption==5){
                     orderList();

                     String id;
                     String status;
                     String waiterName ;
                     String feedBack;
                     String foodName;
                     String price;
                     try {
                         Scanner X = new Scanner(new File("Order.txt"));
                        
                         X.useDelimiter("[Δ\n]");
                         int allPayment=0;
                      
                             while (X.hasNext()) {
                            id = X.next();
                            foodName=X.next();
                            price=X.next();
                            status = X.next();
                            waiterName =X.next();
                            feedBack=X.next();
                            allPayment=allPayment+Integer.parseInt(price);  
                         }
                         System.out.println("All salary: " + allPayment);
                         X.close();
                    X=null;
             
                     } catch (Exception e) {
                         System.out.println("something went wrong");
             
             
                     }

                     mangerMenu();
            }
            else if (numberOfOption==6){
                try {

                Table table = new Table();
                Scanner addUserInput =new Scanner(System.in);
                String inputTableNumber;
                System.out.println("Enter Number of table: ");
                inputTableNumber = addUserInput.nextLine();
                table.setAssigned(false);
                table.setStatus(0);
                FileWriter fw = new FileWriter("Table.txt",true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                pw.println(inputTableNumber+"Δ"+"false"+"Δ"+table.getStatus()+"Δ"+"");
                pw.flush();
                pw.close();
                mangerMenu();
                }catch (Exception e){
                    System.out.println("Something went wrong");
                }


            }else if (numberOfOption==7){

                Scanner addUserInput =new Scanner(System.in);
                String inputTableNumber;
                String inputWaiterName;
                String tableNumber;
                String waitersName;
                String Status;
                String assigned;
                tableList();
                System.out.println("Enter table number: ");
                inputTableNumber = addUserInput.next();
                System.out.println("Enter waiter's name: ");
                inputWaiterName = addUserInput.next();
                File oldFile = new File("Table.txt");
                File newFile = new File("temp.txt");

                try {
                    FileWriter fw = new FileWriter("temp.txt",true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);
                    Scanner X = new Scanner(new File("Table.txt"));

                    X.useDelimiter("[Δ\n]");
                    while (X.hasNext()){
                        tableNumber = X.next();
                        assigned=X.next();
                        Status=X.next();
                        waitersName=X.next();
                        if (inputTableNumber.equals(tableNumber)){

                            pw.println(inputTableNumber+"Δ"+"true"+"Δ"+Status+"Δ"+inputWaiterName);
                        }else{

                            pw.println(tableNumber+"Δ"+assigned+"Δ"+Status+"Δ"+waitersName);
                        }
                    }
                    X.close();
                    X=null;
                    pw.flush();
                    pw.close();
                    System.gc();
                    Boolean isRemove=oldFile.delete();
                    File dump = new File("Table.txt");
                    Boolean isRename = newFile.renameTo(dump);

                    if (isRemove && isRename) {
                        System.out.println("Sign successfully");
                        mangerMenu();
                    }else {
                        System.out.println("Sign Failed");
                        isRemove=newFile.delete();
                        mangerMenu();
                    }
                }catch (Exception e){
                    Boolean isRemove=newFile.delete();
                    System.out.println("something Went Wrong");
                    mangerMenu();
                }

            }else if (numberOfOption==8){
                Scanner input = new Scanner(System.in);

                System.out.println("Do you Want logging out ?(Y/N)");
                String loginQuestion=input.nextLine();
                loginQuestion.toLowerCase();
                if (loginQuestion.equals("y")){
                    loginMenu();
                }
                else if( loginQuestion.equals("n")){
                    mangerMenu();
                }  else{
                    System.out.println("your input is Invalid .");
                    mangerMenu();
                }

            }else{
                System.out.println("your input is Invalid");
                mangerMenu();
            }
        }catch (Exception e){
            System.out.println("your input is Invalid");
            mangerMenu();
        }


    }
    public void waiterMenu(){
        System.out.println("-------------------------------------------------");
        System.out.println("** Waiter Menu **");
        System.out.println("1.View Table status and edit them");
        System.out.println("2.Submit Order");
        System.out.println("3.View Order List and edit");
        System.out.println("4.Log out");
        Scanner UserInput =new Scanner(System.in);
        int numberOfOption = UserInput.nextInt();
        try {
            if (numberOfOption == 1) {
                String tableNumber;
                String waitersName;
                String Status;
                String assigned;
                int statusTable;
                Scanner stringInput =new Scanner(System.in);
                Scanner intInput =new Scanner(System.in);
                try {
                    Scanner X = new Scanner(new File("Table.txt"));
                    tableList();
                    System.out.println("type any thing for back to menu:");
                    System.out.println("enter status number:");
                    System.out.println("\t1.Ready to use");
                    System.out.println("\t2.Dirty");
                    System.out.println("\t3.Is full");

                    statusTable=intInput.nextInt();
                    statusTable=statusTable-1;
                    if(statusTable>=0 && statusTable<=2){
                        Table table = new Table();
                        table.setStatus(statusTable);
                        Scanner addUserInput =new Scanner(System.in);
                        String inputTableNumber;


                        System.out.println("Enter table number: ");
                        inputTableNumber = addUserInput.next();
                        File oldFile = new File("Table.txt");
                        File newFile = new File("temp.txt");

                        try {
                            FileWriter fw = new FileWriter("temp.txt",true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            PrintWriter pw = new PrintWriter(bw);


                            X.useDelimiter("[Δ\n]");
                            while (X.hasNext()){
                                tableNumber = X.next();
                                assigned=X.next();
                                Status=X.next();
                                waitersName=X.next();
                                if (inputTableNumber.equals(tableNumber)){
                                    System.out.println("1");
                                    pw.println(inputTableNumber+"Δ"+true+"Δ"+table.getStatus()+"Δ"+waitersName);
                                }else{
                                    System.out.println("2");
                                    pw.println(tableNumber+"Δ"+assigned+"Δ"+Status+"Δ"+waitersName);
                                }
                            }
                            X.close();
                            X=null;
                            pw.flush();
                            pw.close();
                            System.gc();
                            Boolean isRemove=oldFile.delete();
                            File dump = new File("Table.txt");
                            Boolean isRename = newFile.renameTo(dump);

                            if (isRemove && isRename) {
                                System.out.println("Status change  successfully");
                                waiterMenu();
                            }else {
                                System.out.println("Status change Failed");
                                isRemove=newFile.delete();
                                waiterMenu();
                            }
                        }catch (Exception e){
                            Boolean  isRemove=newFile.delete();
                            System.out.println("something Went Wrong");
                            waiterMenu();
                        }

                    }else{
                        System.out.println("your input is invalid");
                        waiterMenu();
                    }



                } catch (Exception e) {
                    System.out.println(e);
                    System.out.println("something went wrong");
                    waiterMenu();

                }
            } else if (numberOfOption == 2) {


                try {
                    
                    Order order = new Order();
                    FileWriter fw = new FileWriter("Order.txt",true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);
                    Scanner input =new Scanner(System.in);
                    Scanner inputString =new Scanner(System.in);
                  
                    String idOrder;
                    int menuNumber;
                    System.out.println("Menu...................");
                    System.out.println("\t1.Pizza...................20$");
                    System.out.println("\t2.Hamburger...............15$");
                    System.out.println("\t3.Cheeseburger............17$");
                    System.out.println("\t4.Sandwich................12$");
                    System.out.println("\t5.Donuts..................5$");
                    System.out.println("\t6.Noodle..................3$");
                    menuNumber = input.nextInt();
                        System.out.println("Enter a Id for Order");
                        idOrder=inputString.next();
                    

                         if(menuNumber==1){

                            order.setId(idOrder);
                            order.setFoodName("Pizza");
                            order.setPrice("20");
                            order.setStatus(0);
                            order.setWaiterName(waiterLogin);
                            order.setFeedBack("");
                            pw.println(order.getId()+"Δ"+order.getFoodName()+"Δ"+order.getPrice()+"Δ"+order.getStatus()+"Δ"+order.getWaiterName()+"Δ"+order.getFeedBack());
                            pw.flush();
                            pw.close();
                            System.out.println("Order Submitted");
                            waiterMenu();}
                            else if(menuNumber==2){

                            order.setId(idOrder);
                            order.setFoodName("Hamburger");
                            order.setPrice("15");
                            order.setStatus(0);
                            order.setWaiterName(waiterLogin);
                            order.setFeedBack("");
                            pw.println(order.getId()+"Δ"+order.getFoodName()+"Δ"+order.getPrice()+"Δ"+order.getStatus()+"Δ"+order.getWaiterName()+"Δ"+order.getFeedBack());
                            pw.flush();
                            pw.close();
                            System.out.println("Order Submitted");
                            waiterMenu();}
                            else if(menuNumber==3){

                            order.setId(idOrder);
                            order.setFoodName("Cheeseburger");
                            order.setPrice("17");
                            order.setStatus(0);
                            order.setWaiterName(waiterLogin);
                            order.setFeedBack("");
                            pw.println(order.getId()+"Δ"+order.getFoodName()+"Δ"+order.getPrice()+"Δ"+order.getStatus()+"Δ"+order.getWaiterName()+"Δ"+order.getFeedBack());
                            pw.flush();
                            pw.close();
                            System.out.println("Order Submitted");
                            waiterMenu();}
                            else if(menuNumber==4){

                            order.setId(idOrder);
                            order.setFoodName("Sandwich");
                            order.setPrice("12");
                            order.setStatus(0);
                            order.setWaiterName(waiterLogin);
                            order.setFeedBack("");
                            pw.println(order.getId()+"Δ"+order.getFoodName()+"Δ"+order.getPrice()+"Δ"+order.getStatus()+"Δ"+order.getWaiterName()+"Δ"+order.getFeedBack());
                            pw.flush();
                            pw.close();
                            System.out.println("Order Submitted");
                            waiterMenu();}
                            else if(menuNumber==5){

                            order.setId(idOrder);
                            order.setFoodName("Donuts");
                            order.setPrice("5");
                            order.setStatus(0);
                            order.setWaiterName(waiterLogin);
                            order.setFeedBack("");
                            pw.println(order.getId()+"Δ"+order.getFoodName()+"Δ"+order.getPrice()+"Δ"+order.getStatus()+"Δ"+order.getWaiterName()+"Δ"+order.getFeedBack());
                            pw.flush();
                            pw.close();
                            System.out.println("Order Submitted");
                            waiterMenu();}
                        else if(menuNumber==6){

                            order.setId(idOrder);
                            order.setFoodName("Noodle");
                            order.setPrice("3");
                            order.setStatus(0);
                            order.setWaiterName(waiterLogin);
                            order.setFeedBack("");
                            pw.println(order.getId()+"Δ"+order.getFoodName()+"Δ"+order.getPrice()+"Δ"+order.getStatus()+"Δ"+order.getWaiterName()+"Δ"+order.getFeedBack());
                            pw.flush();
                            pw.close();
                            System.out.println("Order Submitted");
                            waiterMenu();
                        }else{
                            System.out.println("input invalid");
                            waiterMenu();
                        } 
                            
                            
                    
                   
                    
                }catch (Exception e){
                    System.out.println("something Went Wrong");
                    waiterMenu();
                }

            } else if (numberOfOption == 3) {
                
                orderList();
                String id;
                String status;
                String waiterName ;
                String feedBack;
                String foodName;
                String price;
                Scanner input = new Scanner(System.in);
                Scanner inputString = new Scanner(System.in);
                String inputOrderId;
                
                System.out.println("Enter Order Id: ");
                inputOrderId = inputString.nextLine();
                
                File oldFile = new File("Order.txt");
                File newFile = new File("temp.txt");

                try {
                    
                    Scanner X = new Scanner(new File("Order.txt"));
                    X.useDelimiter("[Δ\n]");
                    while (X.hasNext()){
                        FileWriter fw = new FileWriter("temp.txt",true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);

                        id = X.next();
                        foodName=X.next();
                        price=X.next();
                        status = X.next();
                        waiterName =X.next();
                        feedBack=X.next();
                        


                        if (inputOrderId.equals(id)){

                            Order order = new Order();
                 
                  
                    
                    int menuNumber;
                    System.out.println("Menu...................");
                    System.out.println("\t1.Pizza...................20$");
                    System.out.println("\t2.Hamburger...............15$");
                    System.out.println("\t3.Cheeseburger............17$");
                    System.out.println("\t4.Sandwich................12$");
                    System.out.println("\t5.Donuts..................5$");
                    System.out.println("\t6.Noodle..................3$");
                    menuNumber = input.nextInt();
                      
                    

                         if(menuNumber==1){

                            order.setId(inputOrderId);
                            order.setFoodName("Pizza");
                            order.setPrice("20");
                            order.setStatus(0);
                            order.setWaiterName(waiterLogin);
                            order.setFeedBack("");
                            pw.println(order.getId()+"Δ"+order.getFoodName()+"Δ"+order.getPrice()+"Δ"+order.getStatus()+"Δ"+order.getWaiterName()+"Δ"+order.getFeedBack());
                            pw.flush();
                            pw.close();
                            System.out.println("Order Submitted");
                          
                            
                            }
                            else if(menuNumber==2){

                            order.setId(inputOrderId);
                            order.setFoodName("Hamburger");
                            order.setPrice("15");
                            order.setStatus(0);
                            order.setWaiterName(waiterLogin);
                            order.setFeedBack("");
                            pw.println(order.getId()+"Δ"+order.getFoodName()+"Δ"+order.getPrice()+"Δ"+order.getStatus()+"Δ"+order.getWaiterName()+"Δ"+order.getFeedBack());
                            pw.flush();
                            pw.close();
                            System.out.println("Order Submitted");
                           
                        }
                            else if(menuNumber==3){

                            order.setId(inputOrderId);
                            order.setFoodName("Cheeseburger");
                            order.setPrice("17");
                            order.setStatus(0);
                            order.setWaiterName(waiterLogin);
                            order.setFeedBack("");
                            pw.println(order.getId()+"Δ"+order.getFoodName()+"Δ"+order.getPrice()+"Δ"+order.getStatus()+"Δ"+order.getWaiterName()+"Δ"+order.getFeedBack());
                            pw.flush();
                            pw.close();
                            System.out.println("Order Submitted");
                           
                                
                        }
                            else if(menuNumber==4){

                            order.setId(inputOrderId);
                            order.setFoodName("Sandwich");
                            order.setPrice("12");
                            order.setStatus(0);
                            order.setWaiterName(waiterLogin);
                            order.setFeedBack("");
                            pw.println(order.getId()+"Δ"+order.getFoodName()+"Δ"+order.getPrice()+"Δ"+order.getStatus()+"Δ"+order.getWaiterName()+"Δ"+order.getFeedBack());
                            pw.flush();
                            pw.close();
                            System.out.println("Order Submitted");
                        
                        }
                            else if(menuNumber==5){

                            order.setId(inputOrderId);
                            order.setFoodName("Donuts");
                            order.setPrice("5");
                            order.setStatus(0);
                            order.setWaiterName(waiterLogin);
                            order.setFeedBack("");
                            pw.println(order.getId()+"Δ"+order.getFoodName()+"Δ"+order.getPrice()+"Δ"+order.getStatus()+"Δ"+order.getWaiterName()+"Δ"+order.getFeedBack());
                            pw.flush();
                            pw.close();
                            System.out.println("Order Submitted");
                            
                        }
                        else if(menuNumber==6){

                            order.setId(inputOrderId);
                            order.setFoodName("Noodle");
                            order.setPrice("3");
                            order.setStatus(0);
                            order.setWaiterName(waiterLogin);
                            order.setFeedBack("");
                            pw.println(order.getId()+"Δ"+order.getFoodName()+"Δ"+order.getPrice()+"Δ"+order.getStatus()+"Δ"+order.getWaiterName()+"Δ"+order.getFeedBack());
                            pw.flush();
                            pw.close();
                            System.out.println("Order Submitted");
                       
                        }else{
                            System.out.println("input invalid");
                            Boolean isRemove=newFile.delete();
                            waiterMenu();                     
                        } 
                            
                            
                    
                        }else{
                            pw.println(id+"Δ"+foodName+"Δ"+price+"Δ"+status+"Δ"+waiterName+"Δ"+null);
                            pw.flush();
                            pw.close();
                        }
                    }
                    X.close();
                    X=null;
            
                    System.gc();
                    Boolean isRemove=oldFile.delete();
                    File dump = new File("Order.txt");
                    Boolean isRename = newFile.renameTo(dump);

                    if (isRemove && isRename) {
                        System.out.println("Order Submitted successfully");
                        waiterMenu();
                    }else {
                        System.out.println("Order Submitted Failed");
                        isRemove=newFile.delete();
                        waiterMenu();
                    }
                }catch (Exception e){
                    Boolean  isRemove=newFile.delete();
                    System.out.println("something Went Wrong");
                    waiterMenu();
                }


                




            } else if (numberOfOption == 4) {
                Scanner input = new Scanner(System.in);

                System.out.println("Do you Want logging out ?(Y/N)");
                String loginQuestion=input.nextLine();
                loginQuestion.toLowerCase();
                if (loginQuestion.equals("y")){
                    loginMenu();
                }
                else if( loginQuestion.equals("n")){
                    waiterMenu();
                }  else{
                    System.out.println("your input is Invalid .");
                    waiterMenu();
                }

            } else {
                System.out.println("your input is invalid");
                waiterMenu();
            }

        }catch(Exception e){
            System.out.println("your input is invalid");
            waiterMenu();

        }
    }

    public void chefMenu() {
        System.out.println("-------------------------------------------------");
        System.out.println("** Chef Menu **");
        System.out.println("1.View & edit Order ");
        System.out.println("2.log out");
        Scanner UserInput =new Scanner(System.in);
        int numberOfOption = UserInput.nextInt();
        try {
            if (numberOfOption == 1) {
                orderList();
                String id;
                String status;
                String waiterName ;
                String feedBack;
                String foodName;
                String price;
                Scanner input = new Scanner(System.in);
                Scanner inputString = new Scanner(System.in);
                String inputOrderId;
                
                System.out.println("Enter Order Id: ");
                inputOrderId = inputString.nextLine();
                
                File oldFile = new File("Order.txt");
                File newFile = new File("temp.txt");

                try {
                    
                    Scanner X = new Scanner(new File("Order.txt"));
                    X.useDelimiter("[Δ\n]");
                    while (X.hasNext()){
                        FileWriter fw = new FileWriter("temp.txt",true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);

                        id = X.next();
                        foodName=X.next();
                        price=X.next();
                        status = X.next();
                        waiterName =X.next();
                        feedBack=X.next();
                        


                        if (inputOrderId.equals(id)){
                            Scanner inputInt = new Scanner(System.in);        
                            Order order = new Order();
                            int indexStatus;
                              
                            System.out.println("Enter Orders Status: ");
                            System.out.println("\t1:Preparing ");
                            System.out.println("\t2.Delivered: ");
                            System.out.println("\t3:Paid: ");
                            indexStatus=inputInt.nextInt();
                            order.setStatus(indexStatus-1);
                            pw.println(id+"Δ"+foodName+"Δ"+price+"Δ"+order.getStatus()+"Δ"+waiterName+"Δ"+null);
                            pw.flush();
                            pw.close();
                        }else{
                            pw.println(id+"Δ"+foodName+"Δ"+price+"Δ"+status+"Δ"+waiterName+"Δ"+null);
                            pw.flush();
                            pw.close();
                        }
                    }
                    X.close();
                    X=null;
            
                    
                    Boolean isRemove=oldFile.delete();
                    File dump = new File("Order.txt");
                    Boolean isRename = newFile.renameTo(dump);
                    
                    System.gc();    

                    if (isRemove && isRename) {
                        System.out.println("Order edit successfully");
                        chefMenu();
                    }else {
                        System.out.println("Order edit Failed");
                        isRemove=newFile.delete();
                        chefMenu();
                    }
                }catch (Exception e){
                    Boolean  isRemove=newFile.delete();
                    System.out.println("something Went Wrong");
                    chefMenu();
                }

                
            } else if (numberOfOption == 2) {
                Scanner input = new Scanner(System.in);
                
                System.out.println("Do you Want logging out ?(Y/N)");
                String loginQuestion=input.nextLine();
                loginQuestion.toLowerCase();
                if (loginQuestion.equals("y")){
                    loginMenu();
                }
                else if( loginQuestion.equals("n")){
                    chefMenu();
                }  else{
                    System.out.println("your input is Invalid .");
                    chefMenu();
                }

            }else{
                System.out.println("your input is invalid");
                chefMenu();
            }
        }catch (Exception e){
            System.out.println("your input is invalid");
            chefMenu();

        }
    }
    public void cashierMenu(){
        System.out.println("-------------------------------------------------");
        System.out.println("** Cashier Menu **");
        System.out.println("1.Pony and Record feedback");
        System.out.println("2.log out");
        Scanner UserInput =new Scanner(System.in);
        int numberOfOption = UserInput.nextInt();
        try {
            if (numberOfOption == 1) {

                orderList();
                String id;
                String status;
                String waiterName ;
                String feedBack;
                String foodName;
                String price;
                Scanner input = new Scanner(System.in);
                Scanner inputString = new Scanner(System.in);
                String inputOrderId;
                String inputOrderFeedBack;
                
                System.out.println("Enter Order Id: ");
                inputOrderId = inputString.nextLine();

                System.out.println("Enter Customer's feedback: ");
                inputOrderFeedBack = inputString.nextLine();
                
                File oldFile = new File("Order.txt");
                File newFile = new File("temp.txt");
                       
       
                try {
                    
                    Scanner X = new Scanner(new File("Order.txt"));
                    X.useDelimiter("[Δ\n]");
                    while (X.hasNext()){
                        FileWriter fw = new FileWriter("temp.txt",true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);

                        id = X.next();
                        foodName=X.next();
                        price=X.next();
                        status = X.next();
                        waiterName =X.next();
                        feedBack=X.next();
                        


                        if (inputOrderId.equals(id)){ 
                            Order order = new Order();
                            order.setStatus(2);
                            order.setFeedBack(inputOrderFeedBack);
                            pw.println(id+"Δ"+foodName+"Δ"+price+"Δ"+order.getStatus()+"Δ"+waiterName+"Δ"+order.getFeedBack());
                            pw.flush();
                            pw.close();
                        }else{
                            pw.println(id+"Δ"+foodName+"Δ"+price+"Δ"+status+"Δ"+waiterName+"Δ"+null);
                            pw.flush();
                            pw.close();
                        }
                    }
                    X.close();
            
                    System.gc();
                    Boolean isRemove=oldFile.delete();
                    File dump = new File("Order.txt");
                    Boolean isRename = newFile.renameTo(dump);

                    if (isRemove && isRename) {
                        System.out.println("Settlement completed successfully");
                        chefMenu();
                    }else {
                        System.out.println("Settlement completed  Failed");
                        isRemove=newFile.delete();
                        chefMenu();
                    }
                }catch (Exception e){
                    
                    Boolean  isRemove=newFile.delete();
                    System.out.println("something Went Wrong");
                    chefMenu();
                }


            }else if(numberOfOption == 2){
                Scanner input = new Scanner(System.in);
                
                System.out.println("Do you Want logging out ?(Y/N)");
                String loginQuestion=input.nextLine();
                loginQuestion.toLowerCase();
                if (loginQuestion.equals("y")){
                    loginMenu();
                }
                else if( loginQuestion.equals("n")){
                    cashierMenu();
                }  else{
                    System.out.println("your input is Invalid .");
                    cashierMenu();
                }
            }else{
                System.out.println("Input invalid");
                cashierMenu();
            }

        }catch(Exception e){
            System.out.println("Input invalid");
            cashierMenu();
        }
    }
}


