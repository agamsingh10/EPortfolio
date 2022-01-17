package hlo;

//import javax.lang.model.util.ElementScanner6;
import javax.swing.*;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt. event.ActionEvent;

public class ePortfolio extends JFrame
{
public static final int WIDTH= 300;
public static final int HEIGHT = 200;
static ArrayList<Investment>  Invest = new ArrayList<Investment>();
    static HashMap<String, ArrayList<Integer>> key = new HashMap<>();
    Portfolio P1 = new Portfolio();

private JTextArea memoDisplay4;
private JTextField symbol4;
private JPanel buyPanel;
private JPanel sellPanel;
private JPanel updatePanel;
private JPanel gainPanel;
private JPanel searchPanel;
private JPanel mainPage = new JPanel();
ArrayList<Investment> invest; 
    Investment current;
    int curr = 0;



JLabel message;
JTextField name3;
JTextField symbol3;


private class BuyListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        setTitle("Buying invetsments");
    buyPanel.setVisible(true);
    sellPanel.setVisible(false);
    updatePanel.setVisible(false);
    gainPanel.setVisible(false);
    searchPanel.setVisible(false);
    mainPage.setVisible(false);
}
}

private class UpdateListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        setTitle("Updating invetsments");
        
    buyPanel.setVisible(false);
    sellPanel.setVisible(false);
    updatePanel.setVisible(true);
    gainPanel.setVisible(false);
    searchPanel.setVisible(false);
    mainPage.setVisible(false);


}
}

private class SellListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        setTitle("Selling invetsments");
    buyPanel.setVisible(false);
    sellPanel.setVisible(true);
    updatePanel.setVisible(false);
    gainPanel.setVisible(false);
    searchPanel.setVisible(false);
    mainPage.setVisible(false);
}
}

private class GainListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        setTitle("Get Gain");
    buyPanel.setVisible(false);
    sellPanel.setVisible(false);
    updatePanel.setVisible(false);
    gainPanel.setVisible(true);
    searchPanel.setVisible(false);
    mainPage.setVisible(false);
    memoDisplay4.setText("");

double getgain = P1.gain(memoDisplay4);
            String temp= String.valueOf(getgain);
            symbol4.setText(temp);
            memoDisplay4.setEditable(false);
            symbol4.setEditable(false);
}
}

private class SearchListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        setTitle("Searching invetsments");
    buyPanel.setVisible(false);
    sellPanel.setVisible(false);
    updatePanel.setVisible(false);
    gainPanel.setVisible(false);
    searchPanel.setVisible(true);
    mainPage.setVisible(false);
}
}

private class quitListener implements ActionListener{
    public void actionPerformed(ActionEvent e){

        System.exit(0);
    }
}

public static void main(String[] args)
{
ePortfolio gui = new ePortfolio() ;
gui.setVisible(true);
}

public ePortfolio()
{
super ("ePortfolio");
setSize (WIDTH, HEIGHT) ;
setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);



setLayout(new BoxLayout(getContentPane(),BoxLayout.X_AXIS));

buyPanel = new JPanel();
buyPanel.setLayout(new BorderLayout());

JPanel buyy = new JPanel();
buyy.setLayout(null);

JLabel buying = new JLabel("Buying an investment");
buying.setBounds(15, 0, 200, 25);
buyy.add(buying);


JLabel typeLabel = new JLabel("Type");
typeLabel.setBounds(20, 20, 80, 25);
buyy.add(typeLabel);

JComboBox<String> typeList;       
        String[] types = { "stock", "mutual fund"};
        typeList = new JComboBox<>(types);
        typeList.setSelectedIndex(0);

typeList.setBounds(100, 28, 165, 25);
buyy.add(typeList);


JLabel symbolLabel = new JLabel("Symbol");
symbolLabel.setBounds(20, 50, 80, 25);
buyy.add(symbolLabel);
JTextField symbol = new JTextField(30);
symbol.setBounds(100, 58, 120, 25);
buyy.add(symbol);

JLabel nameLabel = new JLabel("Name");
nameLabel.setBounds(20, 80, 80, 25);
buyy.add(nameLabel);
JTextField name = new JTextField(30);
name.setBounds(100, 88, 185, 25);
buyy.add(name);

JLabel qtyLabel = new JLabel("Quantity");
qtyLabel.setBounds(20, 110, 80, 25);
buyy.add(qtyLabel);
JTextField quantity = new JTextField(30);
quantity.setBounds(100, 118, 80, 25);
buyy.add(quantity);

JLabel pLabel = new JLabel("Price");
pLabel.setBounds(20, 140, 80, 25);
buyy.add(pLabel);
JTextField price = new JTextField(30);
price.setBounds(100, 148, 80, 25);
buyy.add(price);


JPanel textPanel = new JPanel();
JLabel msg = new JLabel("Messages");
msg.setBounds(20, 170, 80, 25);
buyy.add(msg);
JTextArea memoDisplay = new JTextArea(5, 100);
memoDisplay.setBackground(Color.WHITE);
memoDisplay.setLineWrap(true);
JScrollPane scrolledText = new JScrollPane(memoDisplay);
scrolledText.setHorizontalScrollBarPolicy( JScrollPane .HORIZONTAL_SCROLLBAR_ALWAYS) ;
scrolledText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
textPanel.add (scrolledText);
textPanel.setBounds(-219, 190, 1500, 500);


buyy.add (textPanel);


              
                
                //Border btnborder = new EmptyBorder(60, 50, 50, 50);
                //btns.setBorder(btnborder);

                JButton reset1 = new JButton("Reset");
                JButton buyinv = new JButton("Buy");

                reset1.setFocusable(false);
                reset1.setBounds(600, 40, 80, 30);
                buyinv.setFocusable(false);
                buyinv.setBounds(600, 130, 80, 30);

                // Styling the Buttons
                
                reset1.setPreferredSize(new Dimension(50, 20));
               // btns.add(reset);
                buyinv.setPreferredSize(new Dimension(50, 20));
               // btns.add(buyinv);
               


buyPanel.add(reset1);

buyPanel.add(buyinv);
buyPanel.add(buyy);

buyPanel.setVisible(false);
add(buyPanel);

buyinv.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            String symboll = symbol.getText();
            String namee = name.getText();
            int qtty = Integer.parseInt(quantity.getText());
            double pricee = Double.parseDouble(price.getText());
            String investment= typeList.getSelectedItem().toString();

            if (symboll.length() == 0 || namee.length()==0) {
                String out = "Symbol as well as the name must be filled.";
                memoDisplay.setText(out);
                memoDisplay.setEditable(false);
            } 
            
                
               else if (pricee <0 || qtty<0) {
                    String out = "Quantity as well as the price must be positive.";
                memoDisplay.setText(out);
                memoDisplay.setEditable(false);
                } 
            
           
                
                 else {
                    
                        int flag;
                        if(investment.equals("stock"))
                        flag= P1.checkSymbol(symboll, 1, investment, pricee, qtty);
                        else
                        flag= P1.checkSymbol(symboll, 2, investment, pricee, qtty);
                        
                            if(flag==1){
                                
                                String out = "Symbol already found in records and the Quantity and price you entered has been updated";
                                memoDisplay.setText(out);
                                memoDisplay.setEditable(false);
                            }
                               
                            else if(flag==2){
                                
                            String out = ("Sorry,Symbol already found in another investment type");;
                            memoDisplay.setText(out);
                            memoDisplay.setEditable(false);
                               
                            }
                         
                        else {
                            try{


                                P1.buyInvestment( symboll, qtty,  namee, pricee, investment);
                                String out = ("Succesfully bought the investment!\n");
                         
                           
                           
                               String output= P1.print();
                            
                              memoDisplay.setText(out + output + "\n");
                              memoDisplay.setEditable(false);
                            
                            }
                            catch (Exception e1) {
                                String out = e1.getMessage();
                                memoDisplay.setText(out);
                                
                                
                               
                            }
                        }
                    }

                     
                }
            

         catch (Exception error) {
            String out = "Something Went Wrong, Please Try Again.\n\nPlease make sure that\n1)You have filled the Symbol and the name.\n2)You have entered a the price and quantity greater than 0.\n3)You have entered an Integer Number for quantity or double for price and not a string.\n";
            memoDisplay.setText(out);
            memoDisplay.setEditable(false);
        }
    }
});
reset1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        quantity.setText("");
        price.setText("");
        symbol.setText("");
        name.setText("");
        memoDisplay.setText("");
        typeList.setSelectedIndex(0);
    }
});
//////////////////////////////////////////////////////////////////////////////////////////////////////////////

sellPanel = new JPanel();


sellPanel.setLayout(new BorderLayout());

JPanel selll = new JPanel();
selll.setLayout(null);

JLabel selling= new JLabel("Selling an investment");
selling.setBounds(15, 0, 200, 25);
selll.add(selling);


JLabel symbolLabel2 = new JLabel("Symbol");
symbolLabel2.setBounds(20, 20, 80, 25);
selll.add(symbolLabel2);
JTextField symbol2 = new JTextField(30);
symbol2.setBounds(100, 28, 120, 25);
selll.add(symbol2);

JLabel qtyLabel2 = new JLabel("Quantity");
qtyLabel2.setBounds(20, 50, 80, 25);
selll.add(qtyLabel2);
JTextField quantity2 = new JTextField(30);
quantity2.setBounds(100, 58, 80, 25);
selll.add(quantity2);

JLabel pLabel2 = new JLabel("Price");
pLabel2.setBounds(20, 80, 80, 25);
selll.add(pLabel2);
JTextField price2 = new JTextField(30);
price2.setBounds(100, 88, 80, 25);
selll.add(price2);


JPanel textPanel2 = new JPanel();
JLabel msg2 = new JLabel("Messages");
msg2.setBounds(20, 130, 80, 25);
selll.add(msg2);
JTextArea memoDisplay2 = new JTextArea(5, 100);
memoDisplay2.setBackground(Color.WHITE);
memoDisplay2.setLineWrap(true);
JScrollPane scrolledText2 = new JScrollPane(memoDisplay2);
scrolledText2.setHorizontalScrollBarPolicy( JScrollPane .HORIZONTAL_SCROLLBAR_ALWAYS) ;
scrolledText2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
textPanel2.add (scrolledText2);
textPanel2.setBounds(-219, 150, 1500, 500);


selll.add (textPanel2);


JButton reset = new JButton("Reset");
JButton sellinv = new JButton("Sell");

reset.setFocusable(false);
reset.setBounds(600, 25, 80, 30);
sellinv.setFocusable(false);
sellinv.setBounds(600, 100, 80, 30);

// Styling the Buttons

reset.setPreferredSize(new Dimension(50, 20));
// btns.add(reset);
sellinv.setPreferredSize(new Dimension(50, 20));
// btns.add(buyinv);



sellPanel.add(reset);

sellPanel.add(sellinv);

sellPanel.add(selll);
sellPanel.setVisible(false);
add(sellPanel);

sellinv.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            String symboll = symbol2.getText();
            int qtty = Integer.parseInt(quantity2.getText());
            double pricee = Double.parseDouble(price2.getText());
            

            if (symboll.length() == 0 ) {
                String out = "Symbol must be filled.";
                memoDisplay2.setText(out);
                memoDisplay2.setEditable(false);
            } 
            
                
               else if (pricee <0 || qtty<0) {
                    String out = "Quantity as well as the price must be positive.";
                memoDisplay2.setText(out);
                memoDisplay2.setEditable(false);
                } 
            
           
                
                 else {
                    int flag;
                     if(P1.typecheck(symboll, "stock")==1)
                     flag= P1.checkSell(symboll, 1, qtty, pricee, memoDisplay2);
                     else
                     flag= P1.checkSell(symboll, 2, qtty, pricee, memoDisplay2);
                    if(flag==1){
                        String out = "Succesfully sold!\n";
                        
                        String output= P1.print();
                            
                        memoDisplay2.append(out + output + "\n");
                        memoDisplay2.setEditable(false);
                    }
                    
                    else if(flag==2){
                        String out = "Successfully sold but the investment deleted due to 0 shares!\n";
                        
                        String output= P1.print();
                            
                        memoDisplay2.append(out + output + "\n");
                        memoDisplay2.setEditable(false);
                        
                        
                    }
                    else {
                        try{
                            String out = ("Symbol Not found or not enough quantity left !\n");
                         
                           
                           
                               String output= P1.print();
                            
                              memoDisplay2.append(out + output + "\n");
                              memoDisplay2.setEditable(false);
                            }

                            catch (Exception e1) {
                                String out = e1.getMessage();
                                memoDisplay2.setText(out);
                                
                               
                            }
                       
                    }
         
                }                              

        } catch (Exception error) {
            String out = "Something Went Wrong, Please Try Again.\n\nPlease make sure that\n1)You have filled the Symbol.\n2)You have entered a the price and quantity greater than 0.\n3)You have entered an Integer Number for quantity or double for price and not a string.\n";
            memoDisplay2.setText(out);
            memoDisplay2.setEditable(false);
        }
    }
});

reset.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        quantity2.setText("");
        price2.setText("");
        symbol2.setText("");
        memoDisplay2.setText("");
    }
});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
updatePanel = new JPanel();
updatePanel.setLayout(new BorderLayout());

JPanel updt = new JPanel();
updt.setLayout(null);

JLabel updating= new JLabel("Updating an investment");
updating.setBounds(15, 0, 200, 25);
updt.add(updating);


JLabel symbolLabel3 = new JLabel("Symbol");
symbolLabel3.setBounds(20, 20, 80, 25);
updt.add(symbolLabel3);
JTextField symbol3 = new JTextField(30);
symbol3.setBounds(100, 28, 120, 25);
updt.add(symbol3);

JLabel nameLabel3 = new JLabel("Name");
nameLabel3.setBounds(20, 50, 80, 25);
updt.add(nameLabel3);
JTextField name3 = new JTextField(30);
name3.setBounds(100, 58, 185, 25);
updt.add(name3);

JLabel pLabel3 = new JLabel("Price");
pLabel3.setBounds(20, 80, 80, 25);
updt.add(pLabel3);
JTextField price3 = new JTextField(30);
price3.setBounds(100, 88, 80, 25);
updt.add(price3);


JPanel textPanel3= new JPanel();
JLabel msg3= new JLabel("Messages");
msg3.setBounds(20, 150, 80, 25);
updt.add(msg3);
JTextArea memoDisplay3 = new JTextArea(5, 100);
memoDisplay3.setBackground(Color.WHITE);
memoDisplay3.setLineWrap(true);
JScrollPane scrolledText3 = new JScrollPane(memoDisplay3);
scrolledText3.setHorizontalScrollBarPolicy( JScrollPane .HORIZONTAL_SCROLLBAR_ALWAYS) ;
scrolledText3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
textPanel3.add (scrolledText3);
textPanel3.setBounds(-219, 170, 1500, 500);


updt.add (textPanel3);

invest=P1.getList();
// current = invest.get(curr);
//  symbol3.setText(current.symbol);
//  name3.setText(current.name);
        
        
        if (invest.size() > 0) {
            current = invest.get(0);

        }        
        
        symbol3.setEditable(false);
        name3.setEditable(false);

JButton prev = new JButton("Prev");
JButton next = new JButton("Next");
JButton save = new JButton("Save");

prev.setFocusable(false);
prev.setBounds(600, 30, 80, 30);
next.setFocusable(false);
next.setBounds(600, 75, 80, 30);
save.setFocusable(false);
save.setBounds(600, 120, 80, 30);

// Styling the Buttons

prev.setPreferredSize(new Dimension(50, 20));
next.setPreferredSize(new Dimension(50, 20));

save.setPreferredSize(new Dimension(50, 20));




updatePanel.add(prev);
updatePanel.add(next);
updatePanel.add(save);


updatePanel.add(updt);
updatePanel.setVisible(false);
add(updatePanel);

prev.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){
        invest= P1.getList();
        curr--;
        current = invest.get(curr);
        name3.setText(current.name);
        symbol3.setText(current.symbol);
    }
});


next.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){
        invest= P1.getList();
        curr++;
        current = invest.get(curr);
        name3.setText(current.name);
        symbol3.setText(current.symbol);
        
        
    }
});

save.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){
        String UP = price3.getText();
        String sym = symbol3.getText();
        if(UP.isBlank()){
            memoDisplay3.setText("ERROR: Price can not be empty");
            return;
        }
        try { 
            Integer.parseInt(UP); 
        } catch(NumberFormatException a) { 
           memoDisplay3.setText("ERROR: quantity must be an integer"); 
        }

        P1.updatePrices(current ,sym, UP);
        String out = P1.print();
        memoDisplay3.setText(out+ "\n");
    }
});
/////////////////////////////////////////////////////////////////////////////////////////////////////

gainPanel = new JPanel();

gainPanel.setLayout(new BorderLayout());

JPanel gainn = new JPanel();
gainn.setLayout(null);

JLabel gaining= new JLabel("Getting total gain");
gaining.setBounds(15, 0, 200, 25);
gainn.add(gaining);


JLabel symbolLabel4 = new JLabel("Total Gain");
symbolLabel4.setBounds(20, 25, 80, 25);
gainn.add(symbolLabel4);
symbol4 = new JTextField(30);
symbol4.setBounds(100, 28, 120, 25);
gainn.add(symbol4);


JPanel textPanel4= new JPanel();
JLabel msg4= new JLabel("Idividual gains");
msg4.setBounds(20, 70, 200, 25);
gainn.add(msg4);
memoDisplay4 = new JTextArea(5, 100);
memoDisplay4.setBackground(Color.WHITE);
memoDisplay4.setLineWrap(true);
JScrollPane scrolledText4 = new JScrollPane(memoDisplay4);
scrolledText4.setHorizontalScrollBarPolicy( JScrollPane .HORIZONTAL_SCROLLBAR_ALWAYS) ;
scrolledText4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
textPanel4.add (scrolledText4);
textPanel4.setBounds(-219, 90, 1500, 500);


gainn.add (textPanel4);

gainPanel.add(gainn);
gainPanel.setVisible(false);
add(gainPanel);


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
searchPanel = new JPanel();
searchPanel.setLayout(new BorderLayout());

JPanel searchh = new JPanel();
searchh.setLayout(null);

JLabel searching= new JLabel("Searching investments");
searching.setBounds(15, 0, 200, 25);
searchh.add(searching);

JLabel symbolLabel5 = new JLabel("Symbol");
symbolLabel5.setBounds(20, 50, 80, 25);
searchh.add(symbolLabel5);
JTextField symbol5 = new JTextField(30);
symbol5.setBounds(100, 58, 120, 25);
searchh.add(symbol5);

JLabel nameLabel5 = new JLabel("Name");
nameLabel5.setBounds(20, 80, 80, 25);
searchh.add(nameLabel5);
JLabel keywordL = new JLabel("keyword");
keywordL.setBounds(20, 91, 80, 25);
searchh.add(keywordL);
JTextField name5 = new JTextField(30);
name5.setBounds(100, 88, 185, 25);
searchh.add(name5);

JLabel lpLabel = new JLabel("Low Price");
lpLabel.setBounds(20, 110, 80, 25);
searchh.add(lpLabel);
JTextField lprice = new JTextField(30);
lprice.setBounds(100, 118, 80, 25);
searchh.add(lprice);

JLabel hpLabel = new JLabel("High Price");
hpLabel.setBounds(20, 140, 80, 25);
searchh.add(hpLabel);
JTextField hprice = new JTextField(30);
hprice.setBounds(100, 148, 80, 25);
searchh.add(hprice);


JPanel textPanel5 = new JPanel();
JLabel msg5 = new JLabel("Search Results");
msg5.setBounds(20, 180, 200, 25);
searchh.add(msg5);
JTextArea memoDisplay5 = new JTextArea(5, 100);
memoDisplay5.setBackground(Color.WHITE);
memoDisplay5.setLineWrap(true);
JScrollPane scrolledText5 = new JScrollPane(memoDisplay5);
scrolledText5.setHorizontalScrollBarPolicy( JScrollPane .HORIZONTAL_SCROLLBAR_ALWAYS) ;
scrolledText5.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
textPanel5.add (scrolledText5);
textPanel5.setBounds(-219, 200, 1500, 500);


searchh.add (textPanel5);
JButton reset5 = new JButton("Reset");
                JButton searchinv = new JButton("Search");

                reset5.setFocusable(false);
                reset5.setBounds(600, 50, 80, 30);
                searchinv.setFocusable(false);
                searchinv.setBounds(600, 130, 80, 30);

                // Styling the Buttons
                
                reset5.setPreferredSize(new Dimension(50, 20));
               // btns.add(reset);
               searchinv.setPreferredSize(new Dimension(50, 20));
               // btns.add(buyinv);
               


               searchPanel.add(reset5);

searchPanel.add(searchinv);


searchPanel.add(searchh);
searchPanel.setVisible(false);
add(searchPanel);

searchinv.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){
       try{   
        String symboll =symbol5.getText();
        String namee = name5.getText();
        String lPrice = lprice.getText();
        String hPrice = hprice.getText();
        /*double lower= Double.parseDouble(lPrice);
        double upper= Double.parseDouble(hPrice);
//
        if (lower <0 || upper<0) {
                 String out = "Quantity as well as the price must be positive.";
            memoDisplay5.setText(out);
            memoDisplay5.setEditable(false);
            } 
        
       
            
              */
      
       // try{
        Portfolio.searchPortfolio(symboll, namee , lPrice, hPrice,  memoDisplay5);
         //     }
          /*    catch (Exception e1) {
                String out = e1.getMessage();
                memoDisplay5.setText(out);
                memoDisplay5.setEditable(false);
               
            }*/
             //}
           }
            catch (Exception error) {
                String out = "Something Went Wrong, Please Try Again.\n\nPlease make sure that\n1)You have entered a the lower price and greater price greater than 0.\n2)You have entered double for prices and not a string.\n3)You have filled at least one field to search\n";
                memoDisplay5.setText(out);
                memoDisplay5.setEditable(false);
            }
        


    }
});

reset5.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        hprice.setText("");
        lprice.setText("");
        symbol5.setText("");
        name5.setText("");
        memoDisplay5.setText("");
    }
});


///////////////////////////////////////////////////////////////////////////////////////////////////////////



mainPage.setLayout(new BorderLayout());
JLabel intro = new JLabel("Welcome to EPortfolio");
intro.setBounds(100, 50, 200, 25);

        // Creating the intro description
        JTextArea description = new JTextArea(5, 36);
        description.setText(
            "Choose a command from the \"Commands\" menu to buy or sell an investment, update prices for all investments, get gain for the portfolio, search for relevant investments, or quit the program.");
            description.setBounds(100, 50, 200, 25);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setOpaque(false);
        description.setEditable(false);

        // Adding the Elements to the Home Frame
        mainPage.add(intro, BorderLayout.NORTH);
        mainPage.add(description, BorderLayout.CENTER);
        add(mainPage);
        
        mainPage.setVisible(true);
        buyPanel.setVisible(false);
    sellPanel.setVisible(false);
    updatePanel.setVisible(false);
    gainPanel.setVisible(false);
    searchPanel.setVisible(false);


JMenu cmdMenu = new JMenu("Commands") ;

JMenuItem buy = new JMenuItem("Buy") ;
buy.addActionListener(new BuyListener());
cmdMenu.add(buy);

JMenuItem sell = new JMenuItem("Sell") ;
sell.addActionListener(new SellListener());
cmdMenu.add(sell);

JMenuItem update = new JMenuItem("Update") ;
update.addActionListener(new UpdateListener());
cmdMenu.add(update);

JMenuItem gain = new JMenuItem("Get Gain ") ;
gain.addActionListener(new GainListener());
cmdMenu.add(gain );

JMenuItem search = new JMenuItem("Search") ;
search.addActionListener(new SearchListener());
cmdMenu.add(search);

JMenuItem quit = new JMenuItem("Quit") ;
quit.addActionListener(new quitListener());
cmdMenu.add(quit);


JMenuBar bar= new JMenuBar();
bar.add (cmdMenu);
setJMenuBar (bar) ;






}

}
