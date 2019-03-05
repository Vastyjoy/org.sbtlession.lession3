package org.sbtscholl.tihonov;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ParserFile {
    /**
     * Convert a string to an array by removing all punctuation marks.
     *
     * @param str
     * @param delimiter
     * @return String[]
     */
    private static final String[] parseStringLine(String str, String delimiter) {
        String string[] = str.split(delimiter);
        for (int i = 0; i < string.length; i++) {
            string[i] = string[i].replaceAll("\\p{P}", "");
        }
        return string;
    }

    /**
     *
     * returns a List<String> with a special iterator ReverseIterator
     *
     * @param filePath  Path input file
     * @param delimiter Delimiter words
     * @return
     */
    public static final List<String> parseToListRevIter(String filePath, String delimiter) throws IOException {
        List<String> list = new ArrayList<>() {
            @Override
            public Iterator<String> iterator() {
                return new ReverseIterator<String>();
            }

            class ReverseIterator<String> implements Iterator<String> {
                int cursor;
                int lastRet = -1;

                ReverseIterator() {
                    cursor = size() - 1;
                }

                public boolean hasNext() {
                    return cursor >= 0;
                }

                public String next() {
                    int i = cursor;
                    if (i < 0) {
                        throw new NoSuchElementException();
                    }
                    lastRet = i;
                    cursor = i - 1;
                    return (String) get(i);
                }
            }
        };

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNext()) {
                String str = scanner.nextLine();
                String string[] = parseStringLine(str, delimiter);
                for (String iterStr : string) {
                    list.add(iterStr);
                }
            }
        }
        return list;
    }

    /**
     * Handles a file. Returns a Stack,
     * where string is a key word, integer is the number of occurrences of this word.
     *
     * @param filePath  Path input file
     * @param delimiter Delimiter words
     * @return
     */
    public static final Stack<String> parseToStack(String filePath, String delimiter) throws IOException {
        Stack<String> stack = new Stack<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNext()) {
                String str = scanner.nextLine();
                String string[] = parseStringLine(str, delimiter);
                for (String iterStr : string) {
                    stack.push(iterStr);
                }
            }
        }
        return stack;
    }

    /**
     * Handles a file. Returns a HashMap <String, Integer>,
     * where string is a key word, integer is the number of occurrences of this word.
     *
     * @param filePath  Path input file
     * @param delimiter Delimiter words
     * @return
     */
    public static final HashMap<String, Integer> parseToHashMap(String filePath, String delimiter) throws IOException {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(filePath));
            while (scanner.hasNext()) {
                String str = scanner.nextLine();
                String string[] = parseStringLine(str, delimiter);
                for (String word : string) {
                    if (hashMap.containsKey(word)) {
                        Integer count = hashMap.get(word) + 1;
                        hashMap.put(word, count);
                    } else hashMap.put(word, 1);
                }
            }

        } catch (IOException x) {
            throw x;
        }
        return hashMap;

    }

    /**
     * Handles a file. Returns a TreeMap <String, Integer>,
     * where string is a key word, integer is the number of occurrences of this word.
     *
     * @param filePath   Path input file
     * @param delimiter  Delimiter words
     * @param comparator Comporator<String>
     *                   * @return
     */
    public static final TreeMap<String, Integer> parseToTreeMap(String filePath, String delimiter, Comparator<String> comparator) throws IOException {
        TreeMap<String, Integer> treeMap = new TreeMap<>(comparator);
        HashMap<String, Integer> hashMap = parseToHashMap(filePath, delimiter);
        for (Map.Entry<String, Integer> x : hashMap.entrySet()) {
            treeMap.put(x.getKey(), x.getValue());
        }
        return treeMap;

    }

    /**

     * The method processes the file. Returns a ArrayList<String> of lines in a file.
     *
     * @param filePath   Path input file
     * @param delimiter  Delimiter words
     *                   * @return
    **/
    public  static ArrayList<String> parseLineToArrayList(String filePath, String delimiter)throws IOException{

        ArrayList<String> list=new ArrayList<>();
        try(Scanner scanner=new Scanner(new File(filePath))){
            while(scanner.hasNext()){
                list.add(scanner.nextLine());
            }
        }
    return list;
    }

}
