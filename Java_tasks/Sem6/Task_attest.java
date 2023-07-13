package Java_tasks.Sem6;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Task_attest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите критерий фильтрации:\n1 - Название\n2 - Цвет\n3 - Размер ОЗУ\n4 - Размер жесткого диска\n5 - Операционная система"); 
        System.out.println("Ввод: ");
        int num = scan.nextInt();
        System.out.println("Введите условие поиска: ");
        String word = scan.next();


        Notebook laptop = new Notebook("Asus", "black", 8, 500, "Windows");
        Notebook laptop1 = new Notebook("LG", "white", 16, 1000, "Windows");
        Notebook laptop2 = new Notebook("Macbook", "white", 16, 1000, "MacOS");
        Notebook laptop3 = new Notebook("Dell", "grey", 24, 500, "Windows");

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "name");
        map.put(2, "color");
        map.put(3, "ram");
        map.put(4, "hardDrive");
        map.put(5, "os");

        //System.out.println(map);
        System.out.println();
        System.out.println();

        
        Set<Notebook> a = new LinkedHashSet<>();
        a.add(laptop);
        a.add(laptop1);
        a.add(laptop2);
        a.add(laptop3);

        

        

        Set<Notebook> resultSet = filteredSet(map, a, num, word);

        if (!resultSet.isEmpty()){
            System.out.println("Результат поиска: " + resultSet);
        }else{
            System.out.println("Поиск не дал результатов");
        }   
               
    }

    

    // Вызываем метод, который вернет отфильтрованое множество.

    public static Set<Notebook> filteredSet( Map<Integer, String> mapFilter, Set<Notebook> laptopSet, int x, String str ) {

        Set<Notebook> newSet = new LinkedHashSet<Notebook>();
        String word = "";
        for (Map.Entry<Integer, String> it: mapFilter.entrySet()) {
            if (it.getKey() == x) {
                word = it.getValue();
                System.out.println("Введенный критерий для поиска: " + word);
            }
        }
        //System.out.println(word);
        switch (word) {
            case "name":
                for (Notebook i : laptopSet) {
                    if(i.getName().equals(str)) {
                        newSet.add(i);
                    }
                }
                if(newSet.isEmpty()){
                    System.out.println("Такого зачения не существует");
                }
                break;
            case "color":
                for (Notebook i : laptopSet) {
                    if(i.getColor().equals(str)) {
                        newSet.add(i);
                    }
                }
                if(newSet.isEmpty()){
                    System.out.println("Такого зачения не существует");
                }
                break;    
            case "ram":
                int num = Integer.parseInt(str);
                for (Notebook i : laptopSet) {
                    if(i.getRam() == num) {
                        newSet.add(i);
                    }
                }
                if(newSet.isEmpty()){
                    System.out.println("Такого зачения не существует");
                }
                break;
            case "hardDrive":
                int num1 = Integer.parseInt(str);
                for (Notebook i : laptopSet) {
                    if(i.getHardDrive() == num1) {
                        newSet.add(i);
                    }
                }
                if(newSet.isEmpty()){
                    System.out.println("Такого зачения не существует");
                }
                break;
            case "os":
                for (Notebook i : laptopSet) {
                    if(i.getOs().equals(str)) {
                        newSet.add(i);
                    }
                }
                if(newSet.isEmpty()){
                    System.out.println("Такого зачения не существует");
                }
                break;    
            default:
                break;
        }

        return newSet;
    }
}
