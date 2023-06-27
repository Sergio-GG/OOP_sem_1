// Задача 1. Добавить логирование после каждой итерации сортировки массива в лог-файл.

package Java_tasks.Sem2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task1 {
    public static void main(String[] args) throws IOException{
        //Logger logg1 = Logger.getLogger(Task1.class.getName());

        //FileHandler file = new FileHandler("log.txt");

        //logg1.addHandler(file);

        //SimpleFormatter form = new SimpleFormatter();

        //file.setFormatter(form);

        //file.close();

        

        Scanner inputNums = new Scanner(System.in);
        System.out.println("Введите длину массива: ");
        int len = inputNums.nextInt();
        int mass[] = new int[len];

        System.out.println("Введите числа: ");
        for (int i = 0; i < len; i++) {
            mass[i] = inputNums.nextInt();
        }

        System.out.println("Изначальный массив: ");
        InitialArray(mass);
        
        System.out.println("Отсортированный масив: ");
        MethodSort(mass);
    }

    // Метод выведения на экран изначального массива

        public static void InitialArray(int[]arr) {
            for (int j = 0; j < arr.length; j++) {
                if (j < arr.length - 1){
                    System.out.print(arr[j] + " ");
                }
            else System.out.println(arr[j]);
            }
            
        }
    
    // Метод выведения на экран отсортированного массива

        public static void MethodSort(int[] arr) throws IOException
            {
            Logger logg1 = Logger.getLogger(Task1.class.getName());

            FileHandler file = new FileHandler("log.txt");

            logg1.addHandler(file);

            SimpleFormatter form = new SimpleFormatter();

            file.setFormatter(form);

            int tmp = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    
                    if (arr[i] > arr[j]) {
                        tmp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tmp;
                    }
                    String v1 = Integer.toString(arr[i]);
                    String v2 = Integer.toString(arr[j]);
                    logg1.info("Числа i, j: " + v1 + ", " + v2);        
                }
                //String v2 = Integer.toString(arr[i]);
                //logg1.info("Веденное число i " + v2);
    
                
            }
            file.close();
            for (int k = 0; k < arr.length; k++) {
                if (k < arr.length - 1){
                    System.out.print(arr[k] + " ");
                }
                else System.out.print(arr[k]);
            }
             
            }
    }


