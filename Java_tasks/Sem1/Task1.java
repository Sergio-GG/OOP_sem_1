package Java_tasks.Sem1;
import java.util.Scanner;

/**
 * Task1
 * Вычислить n! (произведение чисел от 1 до n)
 */
public class Task1 {

    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);
        int n = number.nextInt();
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;           
        }
        System.out.println(factorial);
    }
}