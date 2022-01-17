package hlo;

//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JTextArea;

import java.util.ArrayList;

/**
 * Contains the helper and important functions
 */

public class Portfolio {
  Scanner scannerObj = new Scanner(System.in);
    static ArrayList<Investment>  Invest = new ArrayList<Investment>();
    static HashMap<String, ArrayList<Integer>> key = new HashMap<>();
    
    private double gain=0.0;

    /**
    * Sets the values of all the variables using setter functions and then adds the object to arraylist..
    * @param symbol String,it is a unique symbol of stock investment
    * @param name String, it is the name of the stock investment
    * @param quantity int, it is the number of shares of a particular stock investment
    * @param price double,  it is the price per share
    * @param investment String, type of investment
    
    */
    
    public void buyInvestment(String symbol, int quantity, String name, double price, String investment)  {

        
        if (investment.equals("stock")){
          
          Stock S1 = new Stock(symbol, name, quantity, price);
          S1.setBookValue(quantity*price + 9.99);
          Invest.add(S1);
          hashMap();
        }
        else{
            MutualFund MF1 = new  MutualFund(symbol, name, quantity, price);
          MF1.setBookValue(quantity*price + 45);
          Invest.add(MF1);
          hashMap();
        }
          
          
          
    }

    /**
     * 
     * @return  ArrayList, returns investment
     */
    public ArrayList<Investment> getList(){
    
        return Invest;

    }

    
    

/**
    * Checks if the arraylist contains a particular symbol entered by the user. If found it 
    * updates the variables quatity, price, gain and  bookValue.
    * @param symbol String,is the symbol entered by user that he wants to buy
    * @param a int, another parameter, if we send 1 infers working on stock otherwise on mutual funds
    * @param investment String, type of investment
    * @param price int, price of investment
    * @param quantity int, quantity of investment
    * @return int; returns  0 if symbol not found and 1 if symbol found and returns 2 if symbol found in wrong investment
    */

  public int checkSymbol(String symbol, int a, String investment, double price, int quantity){
      if(a==1){     
          
        
        for(Investment I1 : Invest){     
          
          if(symbol.equals(I1.getSymbol()) && investment.equals(I1.getInvestment())){           //checks if symbol is already present in the array list or not     
              //when found, user prompted for quantity and price and both variables updated by calling functions
                             
              I1.updatePrice(price);

              //gain variable is updated whenever there is an update in price
             
              //gain = gain + ((I1.getQuantity()* I1.getPrice() -9.99)-I1.getBookValue());
              I1.updateGain(9.99);
              I1.updateBookValue(quantity*price + 9.99);      //function called to update bookValue
              I1.updateQuantity(quantity);
              
              return 1; 
                 
            }
            else if(symbol.equals(I1.getSymbol()) && !(investment.equals(I1.getInvestment()))){
              return 2;
            }
        }        
        return 0;                      //returns 0 if symbol not found
      }
        //same steps done for mutualfunds
      else{

        
              
        for(Investment I1 : Invest){
              if(symbol.equals(I1.getSymbol()) && investment.equals(I1.getInvestment())){  
                  
                 
                  I1.updatePrice(price); 
                  
                 //Just chnaged  gain = gain + ((I1.getQuantity()* I1.getPrice() -45)-I1.getBookValue());
                  I1.updateGain(45);
                  I1.updateBookValue(quantity*price);
                  I1.updateQuantity(quantity);
                  return 1;            
                }
                else if(symbol.equals(I1.getSymbol()) && !(investment.equals(I1.getInvestment()))){
                  return 2;
                }
                 
            }
            return 0;
        }
  }


  /**
    * Checks if the arraylist contains a particular symbol entered by the user. If found it 
    * performs certain conditions and deletes if remaining shares
    * @param symbol String, is the symbol entered by user that he wants to sell
    * @param a int ,another parameter, if we send 1 infers working on stock otherwise on mutual funds
    * @param quantity int, quantity of investment
    * @param price double, price
    * @param memoDisplay JTextArea, text area to output
    * @return int; returns 1 if remaining shares are greater than 0; 2 if less than 0; and 0 if symbol not found or given quantity greater than original
    */
  
  public int checkSell(String symbol, int a, int quantity, double price, JTextArea memoDisplay){

    if(a==1){     
      
      int temp2=0;   //temperory variables
      int temp3=0; 
      
      for(Investment I1 : Invest)
              
      {     
           if(symbol.equals(I1.getSymbol()))          //check if symbol is present or not
           {              
            
            I1.updatePrice(price);                      
           //Just changed gain = gain + ((I1.getQuantity()* I1.getPrice() -9.99)-I1.getBookValue());
           I1.updateGain(9.99);
            //S1.updateBookValue(S1.getQuantity()*price + 9.99);
            
            double payment = quantity * I1.getPrice()-9.99;
            memoDisplay.setText("Payment: " + payment+ "\n");
            //I1.printPayment(payment);
            temp3=I1.getQuantity();                //stored original quantity
            if(I1.getQuantity() >= quantity){         //check if quantity ntered by user is less that original
                temp2= I1.updateQuantity2(quantity);       //quanity reduced by calling the function and stored
                if(temp2>0){
                  //gain =  gain + payment- (I1.getBookValue()* (double)I1.getQuantity()/temp3);
                  I1.updateBookValue2((double)I1.getQuantity()/temp3);       //updated bookValue
                  
                  return 1;
               
                }
                else{
                Invest.remove(I1);                //deleted the investment
                hashMap();
                System.out.println(key);
                return 2; 
               
                }
            }            
          }
               
      }
        return 0;
    }
  //same steps for mutual funds        
    else{
      
      int temp2=0; 
      int temp3=0; 
      for(Investment I1 : Invest)    {
          if(symbol.equals(I1.getSymbol()) ) {  
            
            I1.updatePrice(price);
            //Just changed gain = gain + ((I1.getQuantity()* I1.getPrice() -45)-I1.getBookValue());
            I1.updateGain(45);
            //I1.updateBookValue(I1.getQuantity()*price); 
            
            double payment = quantity * I1.getPrice()-45;
            memoDisplay.setText("Payment: " + payment + "\n");
            //I1.printPayment(payment);
            temp3=I1.getQuantity();
            if(I1.getQuantity() >= quantity){
                temp2= I1.updateQuantity2(quantity);
                if(temp2>0){
                  //gain = gain + payment- (I1.getBookValue()* (double)I1.getQuantity()/temp3);
                  I1.updateBookValue2((double)I1.getQuantity()/temp3);
                  return 1;
                }
                else{
                Invest.remove(I1);
                hashMap();
                System.out.println(key);
                return 2;
                }
            }
            
                       
          }
            
            
        }    
        return 0;
      }

  }

  /**
   * To check if symbol already present in a particular type
   * @param symbol Sring, symbol of investment
   * @param type String, type
   * @return int, 1 if matched 0 if not
   */
  public int typecheck(String symbol, String type){
    for(Investment I1: Invest){
        if (symbol.equals(I1.getSymbol()) && type.equals(I1.getInvestment())){   
            return 1;
        }
    }

    return 0;
}
 
  

    /**
     * Traverses through the list to update new prices.
     * @param symbol String, symbol of investment
     * @param a String,  price of investment
     * @param current Investment, object
     */

  public void updatePrices(Investment current , String symbol, String a){
    if(typecheck(symbol, "stock")==1){
    double price=Double.parseDouble(a);
  
    
           
      current.setPrice(price);
      current.updateGain(9.99);
      current.updateBookValue(current.getQuantity()*price); 
      
    
  }
    else{
        double price=Double.parseDouble(a);
  
        
               
            current.setPrice(price);
            current.updateGain(45);
            current.updateBookValue(current.getQuantity()*price); 
          
        
    }
  }

 

    /**
     * Traverses through the list and stores all investments.
     * @return String, all investments
     */
  public String print(){
    String output="";
    for(Investment obj : Invest){
      output = output+ obj.toString();
      
    }
    return output;
 }

 

/**
    * returns variable gain
    @return double ; returns the variable gain which is updated every time price is updated
 */
 public double getGainm(){
   return gain;
 }


 /**
  * Reads the contents of file and stores in arrayList
  * @param filename String, reads the file entered by user and stores in ArrayList
  */
//  public void readFile(String filename)
//     {
//         double price = 0;
//         int quantity = 0;
//         double book = 0;
//         String type = null;
//         String symbol = null;
//         String name = null;

//         try{
//             BufferedReader reader = new BufferedReader(new FileReader(filename));
//             type = reader.readLine();

//             while (type != null){
                 
//                 symbol = reader.readLine();
//                 name = reader.readLine();
//                 quantity = Integer.parseInt(reader.readLine());
//                 price = Double.parseDouble(reader.readLine());
//                 book = Double.parseDouble(reader.readLine());


//                 if (type.equals("stock")){
//                     Investment I1 = new Investment(symbol, name, quantity, price, type);
//                     I1.setBookValue(book);
//                     Invest.add(I1);
//                     hashMap();
//                     System.out.println(key);

//                 }
//                 else if (type.equals("Mutual Fund")){
//                     Investment I1 = new Investment(symbol, name, quantity, price, type);
//                     I1.setBookValue(book);
//                     Invest.add(I1);
//                     hashMap();
//                     System.out.println(key);
//                 }

//                 reader.readLine();
//                 type = reader.readLine();
//             }
            
//         }
//         catch(IOException e)
//         {
//                 System.out.println("File can't be opened");
//         }
//     }

    /**
     * Writes the contents of arrayList in the file
     * @param filename String, Writes all the information that the user enters inside the file.
     */
    public static void writeFile(String filename)
    {
        try{
            PrintWriter writeFile = new PrintWriter(filename, "UTF-8");
            for(Investment list: Invest){
                writeFile.println(list.toStringFile());     //writing in toStringFile format to file
            }
            writeFile.close();  //close the PrintFile
        }
        catch(Exception e){
            System.out.println("Failed to write.\n");
        }
    }
/**
 * Implements hash mapping
 */
    public void hashMap(){
      key = new HashMap<String, ArrayList<Integer>>();
      String[] str;
      for(int i=0;i< Invest.size();i++){
        str = (Invest.get(i).getName().toLowerCase()).split("[ ]+",0);
        for(int j=0; j< str.length; j++){
          if(key.get(str[j])==null) {
              key.put(str[j],new ArrayList<Integer>());
          }
              key.get(str[j]).add(i);
        }
      } 
    }

/**
 * Calculates gain by calling getGain function
 * @param getgainDisplay JTextArea, area in which we need to display
 * @return double, returns total gain
 */
    public  double gain(JTextArea getgainDisplay)
    {
        double gainn = 0;

        for(Investment list: Invest)
        {
           

            gainn += list.getGain(getgainDisplay,list.symbol);
            
            
        }

        return gainn;
    }
   
    
    /**
     * Search fuction
     * @param symbol String, symbol of investment
     * @param name String,name of investment
     * @param lprice String,low price range of investment
     * @param hprice String,high price range o f investment
     * @param memoDisplay JTextArea, text area for output
     */
    public static void searchPortfolio(String symbol, String name, String lprice, String hprice, JTextArea memoDisplay) {
        name = name.toLowerCase();
        
    
   ArrayList<String> investt  = new ArrayList<String>(); // declaring our result ArrayList
        ArrayList<Integer> invest = new ArrayList<Integer>();

        
        

       String []temp = name.split("[ ]+");
        for (int i = 0; i < temp.length; i++){
            if (i == 0){
                invest = key.get(temp[i]);
            }
            else{
                invest.retainAll(key.get(temp[i]));
            }
        }
        if(invest != null){

            for(int counter: invest){
                    if (Invest.get(counter).equals(symbol, name, lprice, hprice)){
                        memoDisplay.append(Invest.get(counter).toString());
                    }
            }
        }
        else{   
            for (int i = 0; i < Invest.size(); i++) {
               
                if (Invest.get(i).equals(symbol, name, lprice, hprice)) {
                    investt.add(Invest.get(i).toString());
                }
            }         
            for (int i = 0; i < investt.size(); i++) {
                memoDisplay.append(investt.get(i));
            }
            if (investt.size() == 0) {
                memoDisplay.setText(" Not found! Try again\n");
            }
        }
    }
}

 
