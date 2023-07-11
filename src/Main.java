import java.util.Scanner;
class AtmMachine{
    private long balance=10000000;

    public long getBalance() {
        return balance;
    }

    public void setBalance(long amount) {
        System.out.println("your current Balance"+balance+amount);
        this.balance = amount+balance;
    }
}
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class OptionNotvalid  extends Exception
{
    public OptionNotvalid (String str)
    {
        // calling the constructor of parent Exception
        super(str);
    }
}
class InvalidAmountException  extends Exception
{
    public InvalidAmountException (String str)
    {
        // calling the constructor of parent Exception
        super(str);
    }
}
class InsufficientFundsException  extends Exception
{
    public InsufficientFundsException (String str)
    {
        // calling the constructor of parent Exception
        super(str);
    }
}

public class Main extends AtmMachine{

    public String deposit(long money,AtmMachine user)throws InvalidAmountException{
        if(money<=0){
            throw new InvalidAmountException("Invalid Money");
        }
        else {
            user.setBalance(money);


            return String.valueOf(money)+"rs Deposited successfully";
        }
    }
    public String withdraw(long money,AtmMachine user) throws InsufficientFundsException{
        if(money> user.getBalance()){
            throw new InsufficientFundsException("Insufficient Balance");
        }
        else {

            return String.valueOf(money)+"rs Withdrawed successfully";
        }
    }

    public static void main(String[] args) throws OptionNotvalid, InvalidAmountException ,InsufficientFundsException{
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter\n 1 for Deposit \n 2 for Withdraw\n 3 for checkbalance");
        int option=scan.nextInt();
        if(option>3 ||option<1) {
            throw new OptionNotvalid("invalid Option");
        }
        Main user=new Main();
        switch (option) {

            case 1: {
                System.out.println("Enter Deposit Amount");
                int depamount=scan.nextInt();
                try {
                    System.out.println(user.deposit(depamount,user));
                }
                catch (InvalidAmountException depo){
                    System.out.println(depo);
                }
                break;
            }
            case 2: {
                System.out.println("Enter Withdraw Amount");
                long withamount=scan.nextLong();
                try {


                    System.out.println(user.withdraw(withamount,user));
                }
                catch (InsufficientFundsException insufficient){
                    System.out.println(insufficient);
                }
                break;
            }
            case 3: {
                System.out.println(user.getBalance());
                break;
            }
        }


    }
}