import java.util.ArrayList;

public class Admin {

    private String id ;
    private int pin;
    private Transaction transaction = new Transaction();
    public String getId() {
        return id;
    }
    public void setId(String id) {

        this.id = id;
    }
    public int getPin() {
        return pin;
    }
    public void setPin(int pin)
    {
        this.pin = pin;
    }

    public void settransactions(String transactions)
    {
        transaction.settransaction(transactions);
    }
    public ArrayList<String> gettransactions()
    {
        return transaction.gettransaction();
    }
}