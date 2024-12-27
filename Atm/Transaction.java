import java.util.ArrayList;

public class Transaction {
    private ArrayList<String> transactions;
    Transaction()
    {

        transactions= new ArrayList<>();
    }
    public void settransaction(String transaction) {
        transactions.add(transaction);
    }
    public ArrayList<String> gettransaction(){
        return transactions;
    }
}