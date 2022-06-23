//import java.security.Key;
import java.util.*;
  
public class ATMinterface  
{ 
        public static void main(String args[] )  
    {    
        int balance=0, withdraw, deposit,pin=0,Transaction=0,entry=2;
        String TransacationHistory=""; 
        Map<Integer,String> map=new HashMap<Integer,String>();
        Map<Integer,Integer>amount=new HashMap<Integer,Integer>();
         map.put(1957,"Narmada");
        amount.put(1957, 20000);
         map.put(2056,"Sharavathi");
         amount.put(2056,30000);
         map.put(1256,"Gomathi");
         amount.put(1256,40000);
         map.put(2578,"Gouthami");
         amount.put(2578,18000);
         map.put(1589,"Sabari");
         amount.put(1589,25000);
         map.put(8564,"Kaveri");
         amount.put(8564,80000);
         map.put(2458,"Periyar");
         amount.put(2458,100000); 
         
        Scanner in = new Scanner(System.in);          
       
        { 
            System.out.println("Welcome to our Bank ATM\nPlease Insert your Card"); 
            System.out.println("Kindly Enter Your 4 digit Pin");
            pin=in.nextInt();
            while(true)
           { if(map.containsKey(pin))
           { System.out.printf("\nWelcome %s\n",map.get(pin)); 
            System.out.println("Choose 1 for Withdraw");  
            System.out.println("Choose 2 for Deposit");  
            System.out.println("Choose 3 for Check Balance");  
            System.out.println("Choose 4 for Transaction History");  
            System.out.println("Choose 5 for EXIT");  
            System.out.print("Choose the operation you want to perform:\n");  
              
            int choice = in.nextInt();  
            switch(choice)  
            {  
                case 1:  
            System.out.print("Enter money to be withdrawn in Rs:\n");   
            withdraw = in.nextInt();  
          if(amount.get(pin) >= withdraw)  
         {   balance=amount.get(pin);
            balance = balance - withdraw;  
            amount.replace(pin,balance);
            Transaction=Transaction+1;
            String history=withdraw +"\tWithdrawn amount(-)\n";
            TransacationHistory=TransacationHistory.concat(history);
            System.out.println("Please collect your money\nRs:"+withdraw+"\nThe available balance in your account is");
             balance=amount.get(pin);
            System.out.printf("Rs:%d ",balance);  
         }  
         else  
         {                 
            System.out.println("Insufficient Balance");  
            Transaction++;
            String history=withdraw+"\tInsufficient balance\n";
            TransacationHistory=TransacationHistory.concat(history);
         }  
         System.out.println("");  
         break;  
   
                case 2:  
        { System.out.print("Enter money to be deposited in\nRs:");                     
        deposit = in.nextInt();  
        balance=amount.get(pin);
        balance = balance + deposit;  
        amount.replace(pin,balance);
        Transaction=Transaction+1;
        String history=deposit +"\tDeposited amount(+)\n";
         TransacationHistory=TransacationHistory.concat(history);
        System.out.println("Your Money has been successfully depsited");  
        balance=amount.get(pin);
        System.out.printf("Available Balance is Rs:%d ",balance);  
        System.out.println("");  
        break;  
        }
   
                case 3:  
               balance=amount.get(pin);
        System.out.printf("Available Balance is Rs:%d ",balance);  
        System.out.println("");  
        break;  
              
               case 4:
       {System.out.println("Number of Transactions performed is\n"+Transaction);
        if(Transaction!=0)
        System.out.println("List of transactions\n"+TransacationHistory+"Balance Amount is Rs:"+balance);
        else
        System.out.println("No transaction was performed");
        break;
       }
               
              case 5: 
            { System.out.println("Thanks for using our services\nYou can remove your Card\n");
              in.close();
             System.exit(0);           
             break;
            }
        }
      } 
       else 
       { System.out.println("Sorry you are not registered for Internet Banking You can remove your card.\n Do you want to register with our bank??\nEnter Your Name");
        String name=in.next();
        System.out.println("Enter your pin number");
     
       while(entry>0)
       { pin=in.nextInt(); 
       
        if(map.containsKey(pin))
       { 
        System.out.println("Sorry the pin is already in use\nEnter the other pin Number");  
   
        } else
       { System.out.println("Enter the amount to be Deposited in Rs:");
        deposit=in.nextInt();
        balance=deposit;
        map.putIfAbsent(pin,name);
        amount.putIfAbsent(pin,balance);
       break;
         }  
         entry--;
       }
       if(entry==0)
      { System.out.println("An Error Occured Try again");
       System.exit(0);}
       else
       System.out.printf("Your money  %d is Succesfully Deposited in your account\n",amount.get(pin)); 
      }  
     }    
   }  
  } 
}
