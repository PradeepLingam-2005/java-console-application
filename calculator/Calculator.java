public class Calculator {
    static double add(double num1 , double num2){
        return num1+num2;
    }
    static double sub(double num1 , double num2){
        return num1-num2;
    }
    static double mul(double num1 , double num2){
        return num1*num2;
    }
    static double div(double num1 , double num2){
        return num1/num2;
    }
    static double pow(double num1 , double num2){
        return  Math.pow(num1,num2);
    }
    static double add(double num1 , double num2 ,double num3){
        return num1+num2+num3;
    }
    static double sub(double num1 , double num2,double num3){
        return num1-num2-num3;
    }
    static double mul(double num1 , double num2 , double num3){
        return num1*num2*num3;
    }
    static double div(double num1 , double num2, double num3 ){
        return (num1/num2)/num3;
    }
    static double pow(double num1 , double num2 , double num3){
        return  Math.pow(Math.pow(num1,num2),num3);
    }
}

