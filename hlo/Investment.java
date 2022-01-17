package hlo;

import javax.swing.JTextArea;

/**
 * Investment class is the abstract super class containing super constructors and methods common in subclasses
 */
public abstract class Investment{
    protected String symbol, type;
    protected int quantity;
    protected String name;
    protected double bookValue=0.0, price, gain=0.0;

    
   /**
    * Sets the symbol of investment
    * @param symbol String, symbol that the user enters
    */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    
    /**
     * Sets the quantity of investment
     * @param quantity int, quantity that the user enters
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    /**
     * updates the quantity of investment
     * @param quantity int, new quantity that the user enters
     */
    public void updateQuantity(int quantity) {
        this.quantity += quantity;
    }
    
    /**
     * updates the quantity
     * @param quantity int, quantity updated after selling
     * @return int, returns the updated quantity
     */
    public int updateQuantity2(int quantity) {
        this.quantity -= quantity;
        return this.quantity;
    }
    
    /**
     * function to get the type of investment
     * @return String, returns the type of investment
     */
    public String getInvestment(){
        return this.type;
    }
    
    /**
     * Sets the name of investment
     * @param name String, name entered by the user
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Sets the book value of investment
     * @param bookValue double, bookvalue that is calculated
     */
    public void setBookValue(double bookValue) {
        this.bookValue = bookValue;
    }
    
    /**
     * Sets the price of investment
     * @param price double, price entered by the user
     */
    public void setPrice(double price) {
        this.price = price;
    }
    

    /**
     * updates the prices of items
     * @param price double, new price entered by user
     */
    public void updatePrice(double price) {
        this.price = price;
    }
    
    /**
     * updates the bookvalue of investment
     * @param bookValue, new bookvalue calculated
     */
    public void updateBookValue(double bookValue) {
        this.bookValue += bookValue;
    }
    
    /**
     * Updates the book value again using different calculations
     * @param bookValue, this is the new quantity over old quantity
     */
    public void updateBookValue2(double bookValue) {
        
        this.bookValue =(this.bookValue * bookValue);

    }
    
    /**
     * Displays the payment after selling
     * @param payment, payment that is calculated
     */
    public void printPayment(double payment){
        System.out.println("Payment :" + payment);
    }
    

    /**
     * To access the symbol of an investment
     * @return String, returns the symbol
     */
    public String getSymbol( ) {
        return this.symbol ;
    }
    
    /**
     * To access the quantity of an investment
     * @return int, returns the quantity
     */
    public int getQuantity() {
        return this.quantity  ;
    }
    

    /**
     * To access the name of an investment
     * @return String, returns the name
     */
    public String getName() {
        return this.name  ;
    }
    
    /**
     * update the gain o every price update
     * @param commission double,commision for stock and mutual fund
     */
    public void updateGain(double commission) {
        this.gain = ((this.price * this.quantity - commission) - this.bookValue);
    }

    /**
     * To access the book value of an investment
     * @return double, returns the book value
     */
    public double getBookValue() {
        return this.bookValue  ;
    }
    
    /**
     * To access the price of an investment 
     * @return double, returns the price
     */
    public double getPrice() {
        return this.price  ;
    }
    
    /**
     * To print all the values
     * @return String, returns the combined string
     */
    public String toString(){
        return "Type: " + this.type + "\n" + "symbol  : " + this.symbol + "\nname : " + this.name + "\nquantity : " + this.quantity + "\nprice : " + this.price + "\nbookValue : " + this.bookValue + "\n";

    }

   
     /**
     * constructor of class Investment
     * @param tempSymbol String, stores the symbol
     * @param tempName String, stores the name
     * @param tempQuantity, double stores the quantity
     * @param tempPrice double, stores the price
     * @param type String, stores the type of investment
     * @throws Exception
     */  
    Investment(String tempSymbol, String tempName, int tempQuantity, double tempPrice,  String type) //throws Exception
    {
        //  if(!symbol.isBlank()){
        //      this.symbol = tempSymbol;
        //  }
        //  else{
        //      throw new Exception("ERROR: Symbol must be filled");
        //  }
        // if(!symbol.contains(" ")){
        //     this.symbol = tempSymbol;
        // }
        // else{
        //     throw new Exception("ERROR: Symbol should not contains spaces");
        // }
        // if(!name.isBlank()){
        //     this.name = tempName;
        // }
        // else{
        //     throw new Exception("ERROR: Name must be filled");
        // }
        // if(quantity >= 0){
        //     this.quantity = tempQuantity;
        // }
        // else{
        //     throw new Exception("ERROR: Quantity should be positive");
        // }
              
        // if(price >= 0){
        //     this.price = tempPrice;
        // } 
        // else{
        //     throw new Exception("ERROR: Price should be positive");
        // }

        this.symbol = tempSymbol;
         this.name = tempName;
         this.quantity = tempQuantity;
         this.price = tempPrice; 
        this.type = type;

       
    }
    
    /**
     * Empty Constructor
     */
    Investment(){

    }
    
    /**
     * Prints all values in file
     * @return String, returns the combined string
     */
    public String toStringFile(){
        return "\n" + this.type +  "\n" + this.symbol + "\n" + this.name + "\n" + this.quantity + "\n" + this.price + "\n" + this.bookValue +"\n";      
    }

/**
 * Consider different cases for search
 * @param symbol String, symbol of investment
 * @param name String, name
 * @param tempLowPrice String, Low price range
 * @param tempHighPrice Sring, high price range
 * @return boolean, true if match found false otherwise
 */   
    
    public boolean equals(String symbol, String name, String tempLowPrice, String tempHighPrice) {

        boolean flag = false;
        
        if (name != null && !name.isEmpty()) { // name is given
            String word[] = name.split("( )+");

            for (int i = 0; i < word.length; i++) {   // name not equals
                if (!this.name.toLowerCase().contains(word[i].toLowerCase())) {
                    return false;
                }
            }
            flag = true;
        }      
        
            double lower = -1;
            double upper = Double.MAX_VALUE;
            if(tempLowPrice!=null && !tempLowPrice.isEmpty()){
                lower = Double.parseDouble(tempLowPrice);
            }
            if(tempHighPrice!=null && !tempHighPrice.isEmpty()){
                upper = Double.parseDouble(tempHighPrice);
            }
           
            if (this.price < lower || this.price > upper) {  // if price is outside the upper and lower bounds
                return false;
            }
            flag = true;
      //  }

        // when symbol was entered
        if (symbol != null && !symbol.isEmpty()) {
            if (!this.symbol.equalsIgnoreCase(symbol)) {
                return false;
            }
            flag = true;
        }

        if (flag) {
            return true;    //if match is found 
        } else {
            return false;
        }
    }


   /**
    * returns the calcylate gain
    * @param memoDisplay, text area in which we need to output
    * @param symboll, symbol of investment
    * @return double, gain calculated
    */
    public double getGain(JTextArea memoDisplay ,String symboll){
        
        String temp = String.valueOf(this.gain);

        memoDisplay.append("Get Gain of the investment "+ symboll + " is "+ temp +"\n");
        
        return this.gain;
    }
}

