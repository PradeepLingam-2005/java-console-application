
import java.util.ArrayList;
import java.util.Scanner;

public class AdminAction {

    Scanner in = new Scanner(System.in);
    static int index = -1;


    String  login(ArrayList<Admin> Ad  )
    {
        int at = 3;
        int j = 0;
        if (Ad.isEmpty())

        {
            System.out.println("No admin account found");
            System.out.println("creating a new admin account");
            Admin NewAd = new Admin();
            System.out.println("Enter the Admin id");
            String uid = in.nextLine();
            NewAd.setId(uid);
            System.out.println("enter the pin");
            int tpass = Integer.parseInt(in.nextLine());
            System.out.println("Account created successful.");
            NewAd.setPin(tpass);
            Ad.add(NewAd);
            return "exit";

        }
        else
        {
            System.out.println("enter the AdminId");
            String Id = in.nextLine();
            for (int i = 0; i < Ad.size(); i++) {
                if (Ad.get(i).getId().equals(Id)) {
                    while (j < at) {
                        System.out.println("Enter the PIN:");
                        int tpin = Integer.parseInt(in.nextLine());
                        if (Ad.get(i).getPin() == tpin) {
                            System.out.println("Login successful!");
                            index = i;
                            return Ad.get(i).getId();
                        }
                        else
                        {
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


    void start(Admin Ad ,ArrayList<User> us ) {
        to: while (true) {
            System.out.println(" Add User \n Delete User \n Deposit  \n view all user \n View all Transaction \n exit");
            String choice = in.nextLine();
            switch (choice.toLowerCase()) {
                case "exit":
                    break to;

                case "add":
                    addUser(us);
                    break;

                case "delete":
                    deleteUser(us);
                    break;

                case "deposit":
                    deposit(Ad);
                    break;

                case "user":
                    viewuser();
                    break ;

                case "transaction":
                    viewTransaction(Ad);
                    break;

                default:
                    System.out.println("Invalid input");
            }
        }

    }

    private void viewuser() {
        for (User user : ATM.getuserarr()) {
            System.out.println(user.getId());
        }
    }

    void deposit(Admin Ad) {
        System.out.println("Amount available:" +ATM.getbal());
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the deposit amount: ");
        double atmBal = Double.parseDouble(in.nextLine());
        if (atmBal>0){
            ATM.setbal(atmBal+ATM.getbal());
            String temp =" "+Ad.getId()+" Deposited " + atmBal;
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
            Ad.settransactions(temp);

        }
        else {
            System.out.println("invalid amount");
        }



    }


    void addUser(ArrayList<User> us) {
        User Newuser = new User();
        System.out.println("Enter the user id");
        String uid = in.nextLine();
        Newuser.setId(uid);
        System.out.println("enter the pin");
        int tpass = Integer.parseInt(in.nextLine());
        Newuser.setpin(tpass);
        System.out.println("enter the initial bal");
        double tbal = Double.parseDouble(in.nextLine());
        System.out.println("Account created successful.");
        Newuser.setbal(tbal);
        us.add(Newuser);
    }

    void deleteUser(ArrayList<User> us) {
        System.out.println("Enter the User ID to Delete");
        Scanner in = new Scanner(System.in);
        String dAccount = in.nextLine();
        boolean exists = false;
        int Index = -1;

        for (int i = 0; i < us.size(); i++) {
            if (us.get(i).getId().equals(dAccount)) {
                exists = true;
                Index = i;
                break;
            }
        }
        if (exists) {
            us.remove(Index);
            System.out.println("User Deleted");
        } else {
            System.out.println("User Does not exist");
        }
    }

    void viewTransaction(Admin Ad) {
        System.out.println("Enter option (admin or user)");
        String choice = in.nextLine();
        switch (choice) {
            case "admin": {
                System.out.println("the Admin transactions ");
                ArrayList<String> Ad1 = Ad.gettransactions();
                for (int i = 0; i < Ad1.size(); i++) {
                    System.out.println(Ad1.get(i));
                }
                break;
            }
            case "user": {
                System.out.println("user transactions");
                for (User user : ATM.getuserarr()) {
                    ArrayList<String> atm1 = user.gettransactions();
                    for (int i = 0; i < atm1.size(); i++) {
                        System.out.println(atm1.get(i));
                    }
                }
                break;
            }
            case "exit":
            {
                System.out.println("thank you for using ATM");
                break;
            }
        }





    }


}