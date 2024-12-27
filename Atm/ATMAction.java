import java.util.Scanner;

public class ATMAction {

    public void start() throws CloneNotSupportedException {


        Scanner in = new Scanner(System.in);

        while (true){
            System.out.println("Welcome to the ATM!");
            System.out.println("admin or user (exit to stop) ");
            String temp = in.nextLine().toLowerCase();
            if(temp.equals("user")){
                String login = ATM.getuserobj().login(ATM.getuserarr());
                if(login.equals("exit"))
                {
                    System.out.println("...");
                }
                else if (login.equals(" "))
                {
                    System.out.println("Invalid ID. Please try again.");
                }
                else if (login.equals(""))
                {
                    System.out.println("Access denied.");
                }
                else if (ATM.getuserarr().get(UserAction.index).getId().equals(login)) {
                    ATM.getuserobj().start(ATM.getuserarr().get(UserAction.index));
                }
                else {
                    System.out.println("Error.");
                }
            }
            else if(temp.equals("admin")) {
                String login = ATM.getadminobj().login(ATM.getadminarr());
                if(login.equals("exit"))
                {
                    System.out.println("...");
                }
                else if (login.equals(" "))
                {
                    System.out.println("Invalid ID. Please try again.");
                }
                else if (login.equals(""))
                {
                    System.out.println("Access denied.");
                }
                else if (ATM.getadminarr().get(AdminAction.index).getId().equals(login)) {
                    ATM.getadminobj().start(ATM.getadminarr().get(AdminAction.index),ATM.getuserarr());
                }
                else {
                    System.out.println("Error.");
                }
            }
            else if (temp.equals("exit")) {
                System.out.println("thank you for using the ATM");
                break;
            }
            else {
                System.out.println("Invalid option");
            }

        }

    }
}
