package org.sbtscholl.tihonov;

import java.io.IOException;
import java.util.*;

public class Main {
    //1.Подсчитать количество различных слов в файле
    private static void task1(String filePath, String delimiter) {
        try {
            HashMap<String, Integer> hashMap = ParserFile.parseToHashMap(filePath, delimiter);
            System.out.println("Количество уникальных слов:" + hashMap.size());


        } catch (IOException x) {
        }
    }

    //2.Выведите на  экран список различных слов файла
    private static void task2(String filePath, String delimiter) {
        try {
            TreeMap<String, Integer> treeMapLength = ParserFile.parseToTreeMap(filePath, delimiter,
                    (String firstStr, String secondStr) -> Integer.compare(firstStr.length(), secondStr.length()));

            treeMapLength.forEach((String str, Integer integ) -> System.out.println(str + ":" + integ));

            System.out.println("\n");

            TreeMap<String, Integer> treeMapWord = ParserFile.parseToTreeMap(filePath, delimiter,
                    (String first, String second) -> first.compareTo(second));
            treeMapWord.forEach((String str, Integer integ) -> System.out.println(str + ":" + integ));

        } catch (IOException x) {
        }
    }

    //3.Подсчитать количество различных слов в файле
    private static void task3(String filePath, String delimiter) {
        try {
            HashMap<String, Integer> hashMap = ParserFile.parseToHashMap(filePath, delimiter);
            for (Map.Entry<String, Integer> x : hashMap.entrySet()
            ) {

                System.out.println(x.getKey() + " : " + x.getValue());

            }
        } catch (IOException x) {
        }
    }

    //4. Вывести элементы в обратном порядке
    private static void task4(String filePath, String delimiter) {
        try {
            System.out.println("\n");
            Stack<String> stack = ParserFile.parseToStack(filePath, delimiter);
            while (!stack.isEmpty()) {
                System.out.println(stack.pop());
            }
        } catch (IOException x) {
        }
    }

    //5. Написать собственный итератор, который будет проходить в обратном порядке лист
    private static void task5(String filePath, String delimiter) {

        try {
            List<String> list = ParserFile.parseToListRevIter(filePath, delimiter);
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (IOException x) {
        }
    }

    //6. Вывести на экран строки, заданные пользователем.
    private static void task6(String filePath, String delimiter) {
        try {
            ArrayList<String> list = ParserFile.parseLineToArrayList(filePath, delimiter);
            System.out.println("Введите номера строк через пробел, которые необходимо вывести на экран");
            System.out.println("Нумерация строк начинается с 0");
            System.out.println("Для окончания ввода введите -1");
            ArrayList<Integer> listSelector = new ArrayList<>();

            try (Scanner scanner = new Scanner(System.in);) {
                Integer selector = scanner.nextInt();
                while (selector >= 0) {
                    listSelector.add(selector);
                    selector = scanner.nextInt();
                }
                for (Integer select : listSelector) {
                    if (select >= 0 && select < list.size()) System.out.println(list.get(select));
                    else System.out.println("Неверный номер строки :" + select);
                }
            }

        } catch (IOException x) {
        }
    }

    public static void main(String[] arg) {
        String filePath = "C:\\Users\\Alex\\IdeaProjects\\" +
                "Lession3\\src\\main\\java\\org\\sbtscholl\\tihonov\\input";

        task6(filePath, " ");


    }
}
