package Java_tasks.Sem4;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class Task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        String number1 = scan.nextLine();
        System.out.println("Введите второе число: ");
        String number2 = scan.nextLine();


        var exp = number1.split("");
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int index = 0; index < exp.length; index++) {
            if (!exp[index].equals("-")){
                int a = Integer.parseInt(exp[index]);
                deque.push(a); 
            }  
        }

        exp = number2.split("");
        Deque<Integer> deque2 = new LinkedList<Integer>();
        for (int index = 0; index < exp.length; index++) {
            if (!exp[index].equals("-")){
                int a = Integer.parseInt(exp[index]);
                deque2.push(a);
            }   
        }


        System.out.println("Первый deque: " + deque);
        System.out.println("Второй deque: " + deque2);


        
        int resutMulty = Multiply(deque, deque2, number1, number2);
        System.out.println("Результат умножения число: " +  resutMulty);
        System.out.println("Связаный список произведения: " + PrintMultiplyList(resutMulty));


        int resultSum = Summa(deque, deque2, number1, number2);
        System.out.println("Результат сложения число: " +  resultSum);
        System.out.println("Связанный список суммы: " + PrintSummaList(resultSum));   
        

    }


    public static int Multiply(Deque<Integer> list1, Deque<Integer> list2, String numb1, String numb2) {
        int num1 = Integer.parseInt(numb1);
        int num2 = Integer.parseInt(numb2);
        Iterator<Integer> it = list1.iterator();
        Iterator<Integer> it2 = list2.iterator();
        int multy = 1;
        int sum = 0;
        int index = 1;
        int index2 = 1;
        while (it.hasNext()) {
                int a = it.next() * index2;
            
            while (it2.hasNext()) {
                int b = it2.next() * index;
                multy = a * b;
                sum += multy;
                index *= 10;
            }
            it2 = list2.iterator();
            index = 1;
            index2 *= 10;
        }
        if (num1 < 0 ^ num2 < 0) {
            sum = -sum;
        }
        return sum;
    }

    public static int Summa(Deque<Integer> list1, Deque<Integer> list2, String num1, String num2) {
        Integer[] mass1 = list1.toArray(new Integer[0]);
        Integer[] mass2 = list2.toArray(new Integer[0]);
    
        int number1 = Integer.parseInt(num1);
        int number2 = Integer.parseInt(num2);

        int sum = 0;
        int multySum = 0;
        int multySum1 = 0;
        int index = 1;
        
        for (int i = 0; i < mass1.length; i++) {
            sum = mass1[i] * index;
            multySum += sum;
        } 

        sum = 0;

        for (int j = 0; j < mass2.length; j++) {
            sum = mass2[j] * index;
            multySum1 += sum;
        }
        
        int summa = number1 + number2;
        return summa;
    }       

    public static LinkedList<String> PrintMultiplyList(int multiRes){

        String res  = Integer.toString(multiRes); 
            
        var exp = res.split("");
        LinkedList<String> finalList = new LinkedList<String>();
        for (int index = 0; index < exp.length; index++) {
            finalList.add(exp[index]); 
        }
        return finalList;
    }

    public static LinkedList<String> PrintSummaList(int summaRes){


        String res  = Integer.toString(summaRes);      
        var exp = res.split("");
        LinkedList<String> finalList = new LinkedList<String>();
        for (int index = 0; index < exp.length; index++) {
            finalList.add(exp[index]); 
        }
        return finalList;
    }

        
    
    
}
