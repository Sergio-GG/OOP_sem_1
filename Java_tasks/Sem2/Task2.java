package Java_tasks.Sem2;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Task2 {
    public static void main(String[] args) throws IOException {

        Logger logger = Logger.getLogger(Task2.class.getName());

        FileHandler fileCalc = new FileHandler("calcLog.txt");

        logger.addHandler(fileCalc);

        SimpleFormatter format = new SimpleFormatter();

        fileCalc.setFormatter(format);

        //fileCalc.close();


        Scanner input1 = new Scanner(System.in);
        int num1 = input1.nextInt();
        logger.info("Введено первое число");
        Scanner oper = new Scanner(System.in);
        String operator = oper.nextLine();
        logger.info("Введен оператор");
        Scanner input2 = new Scanner(System.in);
        int num2 = input2.nextInt();
        logger.info("Введено второе число");
      
        int res = 0;

        switch (operator) {
            case "+":
                res = num1 + num2;
                System.out.println(res);
                logger.info("Сложение");
                fileCalc.close();
                break;
            case "-":
                res = num1 - num2;
                System.out.println(res);
                logger.info("Вычитание");
                fileCalc.close();
                break;
            case "*":
                res = 1;
                res = num1 * num2;
                System.out.println(res);
                logger.info("Умножение");
                fileCalc.close();
                break;
            case "/":              
                try {
                    res = num1 / num2;
                    System.out.println(res);
                    
                }
                catch (ArithmeticException e) 
                {
                    System.out.println("Деление на ноль");
                }
                finally 
                {
                    logger.info("Деление");
                    fileCalc.close();
                }                
                break;
            default:
                System.out.println("Введите корректный оператор");
                logger.info("Ложный оператор");
                fileCalc.close();
                break;
        }     
    }
}