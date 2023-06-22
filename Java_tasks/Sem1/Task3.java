package Java_tasks.Sem1;

import java.util.Scanner;

/**
 * Task3
 * Реализовать простой калькулятор
 */
public class Task3 {
    public static void main(String[] args) {
        Scanner input1 = new Scanner(System.in);
        int num1 = input1.nextInt();
        Scanner oper = new Scanner(System.in);
        String operator = oper.nextLine();
        Scanner input2 = new Scanner(System.in);
        int num2 = input2.nextInt();
      
        int res = 0;

        switch (operator) {
            case "+":
                res = num1 + num2;
                System.out.println(res);
                break;
            case "-":
                res = num1 - num2;
                System.out.println(res);
                break;
            case "*":
                res = 1;
                res = num1 * num2;
                System.out.println(res);
                break;
            case "/":              
                try {
                    res = num1 / num2;
                    System.out.println(res);
                }catch (ArithmeticException e) {
                    System.out.println("Деление на ноль");
                }                
                break;
            default:
                System.out.println("Введите корректный оператор");
                break;
        }     
    }
}
