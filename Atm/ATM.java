import java.util.ArrayList;
import java.util.Arrays;

public class ATM {
    private static double bal;
    private static AdminAction ad = new AdminAction();
    private static UserAction us = new UserAction();
    private static ArrayList<Admin> Ad = new ArrayList<>();
    private static ArrayList<User> Us = new ArrayList<>();
    static ArrayList<String> transactions = new ArrayList<>();
    private static ArrayList<Notes> notes = new ArrayList<>(
            Arrays.asList(
                    new TwoThousand("2000",0),
                    new FiveHundred("500",0),
                    new TwoHundred("200",0),
                    new Hundred("100",0)
            )
    );
    static ArrayList<Notes> getNote()
    {
        return notes;
    }
    static void setNote(ArrayList<Notes> temp)
    {
        notes = temp;
    }
    static public AdminAction getadminobj()
    {
        return ad;
    }
    static public UserAction getuserobj()
    {
        return us;
    }
    static public ArrayList<Admin> getadminarr()
    {
        return Ad;
    }
    static public ArrayList<User> getuserarr()
    {
        return Us;
    }
    static public void settransactions(String transaction)
    {
        transactions.add(transaction);
    }
    static public ArrayList<String> gettransactions()
    {
        return transactions;
    }
    static public double getbal()
    {
        return bal;
    }
    static public void setbal(double bal)
    {
        ATM.bal = bal;
    }
}
