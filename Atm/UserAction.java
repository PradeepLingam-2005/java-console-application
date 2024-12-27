import java.util.ArrayList;
import java.util.Scanner;

public class UserAction {
    static Scanner in = new Scanner(System.in);
    static int index= -1;

    String  login( ArrayList<User> us )
    {
        int at = 3;
        int j = 0;
        if (us.isEmpty())
        {
            System.out.println("No  account found");
            return "exit";
        }
        else
        {
            System.out.println("enter the UserId");
            String Id = in.nextLine();
            for (int i = 0; i < us.size(); i++) {
                if (us.get(i).getId().equals(Id)) {
                    while (j < at) {
                        System.out.println("Enter the PIN:");
                        int tpin = Integer.parseInt(in.nextLine());
                        if (us.get(i).getpin() == tpin) {
                            System.out.println("Login successful!");
                            index = i;
                            return us.get(i).getId();
                        } else {
                            System.out.println("Invalid PIN. Please try again.");
                            j++;

                        }
                    }
                    return "";
                }
            }
            return new User().getId();
        }
    }
    void start(User us) throws CloneNotSupportedException {
        to : while (true)
        {
            System.out.println(" check balance \n withdraw  \n deposit \n change pin  \n View Transaction history \n exit");
            String choice = in.nextLine().toLowerCase();
            switch (choice.toLowerCase()) {
                case "exit":
                    System.out.println("thank you for using the ATM");
                    break to;

                case "check balance" : case "balance":
                    balance(us);
                    break;

                case "withdraw":
                    withdraw(us);
                    break;

                case "deposit":
                    deposit(us);
                    break;

                case "view transaction history": case "transaction":
                    TransactionHistory(us);
                    break;
                    
                case "change pin": case "pin":
                    cpin(us);
                    break;

                default:
                    System.out.println("Invalid input");
            }
        }

    }

    private void deposit(User us) {
        System.out.println("Enter the deposit amount: ");
        double atmBal =Double.parseDouble(in.nextLine());
        if (atmBal>0)
        {
            System.out.println("number of 2000 rupees notes");
            int t2000 = Integer.parseInt(in.nextLine());
            System.out.println("number of 500 rupees notes");
            int t500 = Integer.parseInt(in.nextLine());
            System.out.println("number of 200 rupees notes");
            int t200 = Integer.parseInt(in.nextLine());
            System.out.println("number of 100 rupees notes");
            int t100 = Integer.parseInt(in.nextLine());
            int temptotal = t200*200 + t100*100 + t500*500 + t2000*2000;
            if (atmBal == temptotal){
                double Oc;
                double Nc;
                for (Notes tnotes:ATM.getNote())
                {
                    if(tnotes.getNote().equals("2000"))
                    {
                        Oc=tnotes.getCount();
                        Nc=Oc+t2000;
                        tnotes.setCount(Nc);
                    }
                    else if(tnotes.getNote().equals("500"))
                    {
                        Oc=tnotes.getCount();
                        Nc=Oc+t500;
                        tnotes.setCount(Nc);
                    }
                    else if(tnotes.getNote().equals("200"))
                    {
                        Oc=tnotes.getCount();
                        Nc=Oc+t200;
                        tnotes.setCount(Nc);
                    }
                    else if(tnotes.getNote().equals("100"))
                    {
                        Oc=tnotes.getCount();
                        Nc=Oc+t100;
                        tnotes.setCount(Nc);
                    }
                }
            }
            ATM.setbal(atmBal + ATM.getbal());
            String temp = " " + us.getId() + " Deposited " + atmBal;
            us.setbal(us.getbal()+atmBal);
            us.settransactions(temp);
            ATM.settransactions(temp);
        }
        else
        {
            System.out.println("invalid amount");
        }

    }

    private void cpin(User us) {
        System.out.println("enter the current pin");
        int temp = Integer.parseInt(in.nextLine());
        if(us.getpin()==temp){
            System.out.println("enter the new pin");
            int tem = Integer.parseInt(in.nextLine());
            us.setpin(tem);
        }
        else{
            System.out.println("wrong pin");
        }
    }

    private void TransactionHistory(User us) {
        System.out.println("the transaction ");
        ArrayList<String> us1 = us.gettransactions();
        for (int i=0;i<us1.size();i++){
            System.out.println(us1.get(i));
        }

    }

    private double preformwithdraw(double amt , Notes notes , ArrayList<String> denomination){
        int noteval = Integer.parseInt(notes.getNote());
        long count = (long) (amt/noteval);
        if(noteval <=amt && count <= notes.getCount())
        {
            amt -= noteval*count;
            notes.setCount(notes.getCount()-count);
            denomination.add("You got " + count + " notes of " + noteval);
            return amt;
        }
        return amt;
    }

    private void withdraw(User us) throws CloneNotSupportedException {
        var denomination = new ArrayList<String>();
        ArrayList<Notes> copy = new ArrayList<>();
        for (Notes note : ATM.getNote()) {
            copy.add(note.clone());
        }
        System.out.println("enter the amount");
        double tamt = Double.parseDouble(in.nextLine());
        double withamount = tamt;

        if (tamt < 0) {
            System.out.println("invalid  balance.");
            return;
        } else if (tamt >= ATM.getbal()) {
            System.out.println("insufficient balance in Atm.");
            return;
        } else if (tamt > us.getbal()) {
            System.out.println("insufficient balance");
            return;
        }
        while (tamt > 0) {
            for (Notes notes : copy) {
                switch (notes.getNote()) {
                    case "2000", "500", "200", "100":
                        double remain = preformwithdraw(tamt, notes, denomination);
                        if (remain < tamt) {
                            tamt = remain;
                        }
                }
                if (tamt == 0) {
                    double olbal = us.getbal();
                    double nbal = olbal - withamount;
                    us.setbal(nbal);
                    break;
                }
            }
        }
        if (tamt == 0) {
            ATM.setNote(copy);

            for (var temp : denomination) {
                System.out.println(temp);
            }
            String arr = " " + us.getId() + " withdraw " + withamount;
            us.settransactions(arr);
            ATM.settransactions(arr);
        } else {
            System.out.println("Unable to withdraw the full amount. Please try another value.");

        }
    }

    private void balance(User us) {
        System.out.println("your  balance is :"+us.getbal());

    }
}
