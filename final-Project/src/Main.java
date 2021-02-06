import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Manager manager = new Manager();
//        manager.loginMenu();
//Sys
       Shop shop = new Shop();
   while (true){
       Scanner scanner = new Scanner(System.in);
       int inputUser;
       System.out.println("---------------------------------");
       System.out.println("1.add phone");
       System.out.println("2.show phone");
       System.out.println("3.search phone");
       inputUser=scanner.nextInt();
       if (inputUser==1){
           try {
               Scanner inputString = new Scanner(System.in);
               Scanner inputInt = new Scanner(System.in);
               String inputname =inputString.nextLine();
               int inputPrice=inputInt.nextInt();
               shop.add(inputname,inputPrice);
           }catch (Exception e){
               System.out.println("your input is invalid");
           }

       }else  if (inputUser==2){
           shop.showPhone();
       }else if (inputUser==3){
           Scanner inputString = new Scanner(System.in);
           String inputname =inputString.nextLine();
           shop.searchPhone(inputname);
       }else {
           System.out.println("your input is invalid");
       }
   }

    }
}
