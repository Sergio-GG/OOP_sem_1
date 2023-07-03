import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.function.ToDoubleFunction;

public class TASK {

    public static void main(String[] args) {
        System.out.println("Введите длину списка: ");
        Scanner scan = new Scanner(System.in);
        int lenght = scan.nextInt();

        ArrayList<Integer> list = ArrayCreate(lenght);
        System.out.println("Исходный список: ");
        ArrayPrint(list);

        ArrayList<Integer> Sortedlist = ArraySort(list);
        System.out.println("Отсортированный список: ");
        ArrayPrint(Sortedlist);

        ArrayList<Integer> OddList = ArrayOdds(list);
        System.out.println("Список без четных значений: ");
        ArrayPrint(OddList);

        System.out.print("Минимальное значение: ");
        int minimal = OddList.get(0);
        System.out.println(minimal);

        System.out.print("Максимальное значение: ");
        int maximal = OddList.get(OddList.size() - 1);
        System.out.println(maximal);

        
        System.out.print("Среднее значение: ");
        double average = Average(OddList);
        String formattedDouble = new DecimalFormat("#0.00").format(average);
        System.out.println(formattedDouble);


    }
        

    public static ArrayList<Integer> ArrayCreate(int len){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random rand = new Random();
            for (int i = 0; i < len; i++) {
                list.add(rand.nextInt(20));
            }
            return list;
    }


    public static void ArrayPrint(ArrayList<Integer> arr){
            System.out.println(arr);
    } 
    
    
    public static ArrayList<Integer> ArraySort(ArrayList<Integer> arr) {
            Collections.sort(arr);
            return arr;
    }

    public static ArrayList<Integer> ArrayOdds(ArrayList<Integer> arr) {
        ArrayList<Integer> newArr  = new ArrayList<Integer>();
        for (Integer i : arr) {
            if (i % 2 != 0) {
                newArr.add(i);  
            }
        }
        return newArr;
    }
    
    public static double Average(ArrayList<Integer> arr) {
        int sum = 0;
        for (Integer i : arr) {
            sum += i;        
        }
        double size = (double)arr.size();
        double avg = sum / size;
        return avg;
    }       
}

