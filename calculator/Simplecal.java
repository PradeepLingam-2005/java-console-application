import java.util.Scanner;
import java.util.Stack;

public class Simplecal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mode;
        int no;
        double num;
        double num1;
        double num2;
        double result=0;
        while(true){
            System.out.println("Enter the mode : (eg: add, sub ,mul,div,pow)");
            mode = scanner.nextLine();
            System.out.println("Enter  2 or 3  number:");
            no=scanner.nextInt();
            System.out.println("Enter the numbers:");
            if(no==2){
                num = scanner.nextDouble();
                num1 = scanner.nextDouble();
                if (mode.equals("add")) {
                    result=Calculator.add(num,num1);
                }
                if  (mode.equals("sub")){
                    result=Calculator.sub(num,num1);
                }
                if (mode.equals("mul")&& num1!=0){
                    result=Calculator.mul(num,num1);
                }
                if (mode.equals("div")&& num1!=0){
                    result=Calculator.div(num,num1);
                }
                if (mode.equals("pow")&&num1!=0) {
                    result=Calculator.pow(num, num1);
                }
                if((num==0)||(num1==0)) {
                    break;
                }
                if (result%1==0){
                    if(Integer.MAX_VALUE>result && Integer.MIN_VALUE<result ){
                        System.out.println("the result is "+(int)result);
                    }
                    else if (Long.MIN_VALUE<result && Long.MAX_VALUE>result ) {
                        System.out.println("the result is "+(long)result);
                    }
                    else{
                        System.out.println("the result is "+result);
                    }
                }
            }
            else if (no==3) {
                num = scanner.nextDouble();
                num1 = scanner.nextDouble();
                num2 = scanner.nextDouble();
                if (mode.equals("add")) {
                    result=Calculator.add(num,num1,num2);
                }
                if  (mode.equals("sub")){
                    result=Calculator.sub(num,num1,num2);
                }
                if (mode.equals("mul")&& num1!=0){
                    result=Calculator.mul(num,num1,num2);
                }
                if (mode.equals("div")&& num1!=0){
                    result=Calculator.div(num,num1,num2);
                }
                if (mode.equals("pow")&&num1!=0) {
                    result=Calculator.pow(num, num1,num2);
                }
                if((num==0)||(num1==0)||num2==0) {
                    break;
                }
                if (result%1==0){
                    if(Integer.MAX_VALUE>result && Integer.MIN_VALUE<result ){
                        result=(int)result;
                        System.out.println("the result is "+result);
                    }
                    else if (Long.MIN_VALUE<result && Long.MAX_VALUE>result ) {
                        result=(long)result;
                        System.out.println("the result is "+result);
                    }
                    else{
                        System.out.println("the result is "+result);
                    }
                }
            }
            else if (no==0) {
                break;
            }
            else {
                System.out.println("input incorrect");
            }
        }
    }
}
