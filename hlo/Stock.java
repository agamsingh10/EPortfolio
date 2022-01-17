package hlo;

/**
 * Stock class containing constructor and is a derived class
 */
public class Stock extends Investment {
    
    /**
     * This function is a constructor of Stock class which calls the constructor of base class Investment
     * @param Symbol String, it holds the value of symbol of investment
     * @param Name String, it holds the value of name of investment
     * @param Quantity double,  it holds the value of quantity of investment
     * @param Price double, it holds the value of price of investment
     * @throws Exception
     */
    Stock(String Symbol, String Name, int Quantity, double Price)   {
        super(Symbol, Name, Quantity, Price, "stock");
    }
    }
