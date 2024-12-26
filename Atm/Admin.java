import java.util.ArrayList;

public class Admin {

    private String id ;
    private int pin;
    private ArrayList<String> transactions;

    Admin()
    {

        transactions= new ArrayList<>();
    }

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
        this.transactions.add(transactions);
    }
    public ArrayList<String> gettransactions()
    {
        return new ArrayList<>(transactions);
    }
}