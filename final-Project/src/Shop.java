import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
  ArrayList<Phone> phone = new ArrayList<Phone>();

  public void add(String name , int price){
      Scanner inputString = new Scanner(System.in);
      Scanner inputInt = new Scanner(System.in);

      if(!checkExisting(name)){
          Phone p = new Phone();
          p.setName(name);
          p.setPrice(price);
          phone.add(p);
       }else{
          System.out.println("this phone is exist");
      }

  }
  public boolean checkExisting(String name){

      for (int i = 0; i < phone.size() ; i++) {
          if (phone.get(i).getName().equals(name)){
              return true;
          }else{
              return false;
          }
      }
    return false;
  }
  public void  showPhone(){
      for (int i = 0; i <phone.size() ; i++) {
          System.out.println("name: " + phone.get(i).getName());
          System.out.println("price: " + phone.get(i).getPrice());
      }
  }
  public void  searchPhone( String name){
      for (int i = 0; i <phone.size() ; i++) {
         if (phone.get(i).getName().equals(name)){
             System.out.println("name: " + phone.get(i).getName());
             System.out.println("price: " + phone.get(i).getPrice());
         }else{
             System.out.println("not exist");
         }
      }
  }
}
