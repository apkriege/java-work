// Homework 3: ATM 
// Student Name: Adam Krieger
// Course: CIS357, Winter 2017 
// Instructor: Il-Hyung Cho
// Date finished: 3/3/2017
// Program description: This program tests building a base account class, 
// then runs a an ATM instance, and finally tests for extra accounts
//

import java.util.Scanner;
import java.util.Date;

public class AtmKriegerHW3 {
  
  public static void main(String args[]) throws InsufficientException{
   
    System.out.println("Testing Account class ...");  
    testAccount();     
    
    System.out.println("Testing ATM ...");   
    testATM();
    
    System.out.println("Testing extra accounts ...");     
    testExtraAccounts();  

  }
  
  /**
  * This method test the basic account creation. It creates two accounts 
  * and sets their balance and annual interest rate.
  */
  public static void testAccount(){
    try {         
      Account a1 = new Account(1122,20000);   
      a1.setAnnualInterestRate(4.5);     
      a1.withdraw(2500);      
      a1.deposit(3000);
      
      Account a2 = new Account(1123,2000);   
      a2.setAnnualInterestRate(4.5);     
      a2.withdraw(500);
      a2.deposit(20);       
      
      if(a1.getBalance() < 0 || a2.getBalance() < 0){
        throw new InsufficientException();
      }
      
      System.out.println(a1);
      System.out.println(a2);
    }
    catch (InsufficientException ex) {  
      System.out.println("Insufficient fund!!!");
    } 
    catch (Exception ex) {   
      System.out.println("Exception thrown!"); 
    }
  }
  
  /**
  * This method test the ATM functoins for accounts. The user can either
  * check the balance, withdraw from the account, and make a deposit
  * to the account.
  */
  public static void testATM(){
    Scanner in = new Scanner(System.in);
    int id, choice;
    
    Account[] acts = new Account[10];
    
    for(int i=0; i<10; i++){
      acts[i] = new Account(i, 100.00);
    }
    
    System.out.print("Enter ID: ");
    id = in.nextInt();
    
    while(true){
      System.out.println("\nMenu");
      System.out.println("1: Check Balance");
      System.out.println("2: Withdraw");
      System.out.println("3: Deposit");
      System.out.println("4: Exit");
      System.out.print("Enter a choice: ");
      choice = in.nextInt();
      
      if(choice == 1 || choice == 2 || choice ==3){
        action(id, choice, acts);
      }
      else if(choice == 4){
        System.out.print("Enter ID: ");
        id = in.nextInt();
      }
      else{
        System.out.print("Invalid choice.");
        break;
      }
    }
  }
  
  /**
  * This method allows the user to see the balance, make a deposit, 
  * or make a withdraw
  * @param id  First param is the account id
  * @param choice  Second param is the menu choice
  * @param act  Third param is the account object
  */
  public static void action(int id, int choice, Account[] act){
    Scanner in = new Scanner(System.in);
    if(choice == 1){
      System.out.println("Balance: "+ act[id].getBalance());
    }
    if(choice == 2){
      System.out.print("Enter amount to withdraw: ");
      int wd = in.nextInt();
      act[id].withdraw(wd);
    }
    if(choice == 3){
      System.out.print("Enter amount to deposit: ");
      int dep = in.nextInt();
      act[id].deposit(dep);
    }
  }
  
  /**
  * This method tests additional savings and checking accounts and tests
  * to see if the account is overdrawn. If so an exception is throw, 
  * otherwise it prints the account details
  */
  public static void testExtraAccounts() throws InsufficientException{
    int withdrawAmt = 200;
    try{
      SavingsAccount act1 = new SavingsAccount(1123,20000);      
      act1.setAnnualInterestRate(5.5);  
      
      CheckingAccount act2 = new CheckingAccount(1124,1000);     
      act2.setAnnualInterestRate(5.0);  
      act2.setOverdrawLimit(500);     
  
      act2.withdraw(withdrawAmt);
      if(act2.getBalance() < 0){
        throw new InsufficientException();
      }
      
      System.out.println(act1);       
      System.out.println(act2); 
    }
    catch(InsufficientException ex){
      System.out.println("Account is overdrawn!!!");
    }
    catch(Exception ex){
      System.out.println("Exception thrown!");
    }
  }
}

class SavingsAccount extends Account{
  
  /** Savings acount constructor */
  public SavingsAccount(int id, double balance){
    super (id, balance);
  }
}

class CheckingAccount extends Account{
  double overdraft;
  
  /** Checking account constructor */
  public CheckingAccount(int id, double balance){
    super(id, balance);
  }
  
  /**
  * This method sets the overdraft limit
  * @param od  First param is the overdraft amount
  */
  public void setOverdrawLimit(double od){
    this.overdraft = od;
  }
  
}

class InsufficientException extends Exception{
  
  /** InsufficientException constructor */
  InsufficientException(){}
}

class Account{
  private int id;
  private double balance;
  private double annualIR = 0;
  private Date dateCreated = new Date();
  
  /** Constructor function */
  public Account(){};
  
  public Account(int id, double balance){
      setId(id);
      setBalance(balance);
  };
  
  /**
  * This method creates a string to display the account details
  * @return String  Returns output of account details
  */
  public String toString() { 
    
    String str;
    str = "ID: "+getId()+"\n"; 
    str += String.format("Balance: $%,.2f \n", getBalance());
    str += String.format("Monthly IR: %.2f \n", getMonthlyInterestRate());
    str += "Date Created: "+getDateCreated()+"\n";
    
    return str;
  } 
  
  /**
  * This method returns the account id
  * @return int  Returns the account id
  */
  public int getId(){
    return this.id;
  }
  
  /**
  * This method sets the account id
  * @param id  First param is the account id
  */
  public void setId(int id){
    this.id = id;
  }
  
  /**
  * This method returns the balance on the account
  * @return double  Returns the account balance
  */
  public double getBalance(){
    return this.balance;
  }
  
  /**
  * This method sets the initial balance 
  * @param balance  First param is the intial balance
  */
  public void setBalance(double balance){
    this.balance = balance;
  }
  
  /**
  * This method returns the annual interest rate
  * @return double  Returns the annual interest rate
  */
  public double getAnnualInterestRate(){
    return annualIR;
  }
  
  /**
  * This method sets the annual interst rate
  * @param double ir  First param is interest rate
  */
  public void setAnnualInterestRate(double ir){
    this.annualIR = ir;
  }
  
  /**
  * This method returns the date the Account was created 
  * @return Date  Returns the date createed
  */
  public Date getDateCreated(){
    return dateCreated;
  }
  
  /**
  * This method calculates the monthly interest rate
  * @return double  Returns calculate monthly interest
  */
  public double getMonthlyInterestRate() {
    return annualIR / 12;
  }
  
  /**
  * This method calculates the monthly interest
  * @return double  Returns the calculated monthly interest
  */
  public double getMontlyInterest(){
    return balance*getAnnualInterestRate();
  }
  
  /**
  * This method subtracts an amount from the balance
  * @param amt  First param is the amount
  */
  public void withdraw(double amt){
    this.balance = this.balance - amt;
  }
  
  /**
  * This method adds an amount to the balance
  * @param amt  First param is the amount
  */
  public void deposit(double amt){
    this.balance = this.balance + amt;
  }

}