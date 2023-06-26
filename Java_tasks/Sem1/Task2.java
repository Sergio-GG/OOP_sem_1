package Java_tasks.Sem1;
/**
 * Task 2
 * Вывести все простые числа от 1 до 1000 (не включая 1000)
 */
public class Task2 {
    public static void main(String[] args) {
        
        for (int i = 1; i < 1000; i++) {
            int k = 0;
            if (i < 2) {
                continue;
            }
            for (int j = 2; j < i / 2 + 1 ; j++) {
                if (i % j == 0){
                    k++;
                }                        
            }
        if (k == 0){
            System.out.println(i); 
        }        
        }            
    }
}

