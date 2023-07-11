package Java_tasks.Sem5;

import java.util.ArrayList;
//import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
//import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
// java.util.Set;

public class TaskNew {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = 8;
        int count = 0;
        Map<Integer, String> book = new HashMap<>();
        Map<String, Integer> numberCount = new HashMap<>();
        LinkedHashMap<String, Integer> sortedNumsUsers = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> phoneBook = new LinkedHashMap<>();
        ArrayList<String> phoneUsersList = new ArrayList<String>();
        ArrayList<String> sortedphoneUsersList = new ArrayList<String>();
        ArrayList<Integer> phoneNumbersCountList = new ArrayList<Integer>();

        // Заполняем map вводом. Почему-то кириллицу не распонает.
        while (count < size){
            System.out.println("Введите имя: ");
            String userName = scan.next();
            System.out.println("Введите число: ");
            int userNumber = scan.nextInt();
    
            
            book.put(userNumber, userName);
            count++;
        }

        System.out.println("Input map: " + book);

        // Создаем список пользователей.
        for (Map.Entry<Integer, String>  it: book.entrySet()) {
            phoneUsersList.add(it.getValue());
        }

        //System.out.println("List: " + phoneUsersList);


        // Создаем map, где определили количество номеров каждого пользователя.
        for (Map.Entry<Integer, String>  it1: book.entrySet()) {
            int counter = 0;
            for (String x : phoneUsersList) {
                String user = it1.getValue();
                if (user.equals(x)) {
                    counter++;
                }
            }
            numberCount.put(it1.getValue(), counter);
        }

        System.out.println("users, ammout of numbers: " + numberCount);


        // Отсортировываем по убыванию количество номеров.
        for (Map.Entry<String, Integer> it3: numberCount.entrySet()) {
            phoneNumbersCountList.add(it3.getValue());
        }
        Collections.sort(phoneNumbersCountList, Collections.reverseOrder());

        //System.out.println("Sorted ammont: " + phoneNumbersCountList);


        // Отсортировываем пользователей (map), исходя из количества номеров.
        for ( int i : phoneNumbersCountList) {
            for (Map.Entry<String, Integer> it4: numberCount.entrySet()){
                if (it4.getValue().equals(i)){
                    sortedNumsUsers.put(it4.getKey(), i);
                }
            }
        }

        //System.out.println("Sorted map: " + sortedNumsUsers);


        // Создаем остортированный список пользователей.
        for (Map.Entry<String, Integer>  it5: sortedNumsUsers.entrySet()) {
            sortedphoneUsersList.add(it5.getKey());
        }

        //System.out.println("Sorted users list: " + sortedphoneUsersList);
        

        // Выводим на экран телефонную книгу.
        for ( String i: sortedphoneUsersList) {
            for (Map.Entry<Integer, String> it6: book.entrySet()){
                if (it6.getValue().equals(i)) {
                    phoneBook.put(it6.getKey(), i);
                }
                
            }
        }   

        System.out.println("Отсортированная телефоная книга: " + phoneBook);
    }      
        
}    
