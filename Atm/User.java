import java.util.ArrayList;

public class User {

    private String id = " ";
    private int pin;
    private double ibal;
    private ArrayList<String> transactions;

    User()
    {

        transactions= new ArrayList<>();
    }


    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {

        this.id = id;
    }
    public int getpin()
    {
        return pin;
    }
    public void setpin(int pass)
    {
        this.pin = pass;
    }
    public void setbal(double ibal)
    {
        this.ibal = ibal;
    }
    public double getbal()
    {
        return ibal;
    }
    public void settransactions(String transactions)
    {
        this.transactions.add(transactions);
    }
    public ArrayList<String> gettransactions()
    {
        return transactions;
    }
}
