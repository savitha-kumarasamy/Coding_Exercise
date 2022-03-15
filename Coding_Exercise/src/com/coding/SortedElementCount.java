package com.coding;


import java.util.*;
import java.util.stream.IntStream;

public class SortedElementCount
{

    public static void main(String[] args)
    {
        sortedElementCountsWithoutCollections(new int[]{9,4,6,7,9,5,4,6,5,3,3,3});

        System.out.println("-------------------------");

        sortedElementCountsWithoutCollections(new int[]{9,4,7,5,4,6,3});

        System.out.println("-------------------------");

        sortedElementCountsWithoutCollections(new int[]{893, 188, 89, 188, 893, 477, 556, 742});

        System.out.println("-------------------------");

        sortedElementCountsWithoutStream(new int[]{893, 188, 89, 188, 893, 477, 556, 742,9,4,7,9,5,4,6,3,9,4,7,9,5,4,6,3});

        System.out.println("-------------------------");

        sortedElementCountsWithoutCollections(new int[]{}); //Test for empty input

        System.out.println("-------------------------");

        sortedElementCountsWithoutCollections(null); //Test for Null

        System.out.println("-------------------------");

        sortedElementCounts(IntStream.range(1,100000).toArray()); //Test for a really long input
    }


    /**
     * This method takes a list of integer values and counts
     * the occurrence of each number using Collections and built
     * in functions
     */
    static void sortedElementCounts(int inputArray[])
    {
        if(null != inputArray) {
            //Use a tree map so the values are sorted
            Map<Integer, Long> value_count = new TreeMap<>();
            //iterate over the array and add each element as the key in the map and its number of occurance as value
            Arrays.stream(inputArray).forEach(e -> value_count.put(e, value_count.getOrDefault(e, 0L) + 1L));
            //Use a string joiner to create a delimited string with prefix and suffix
            StringJoiner result = new StringJoiner(", ", "{", "}");
            //iterate over the map and add each number and its count to the final output
            value_count.entrySet().forEach(e -> result.add(e.getKey() + ":" + e.getValue()));
            //print the results
            System.out.println(result);
        }
    }

    /**
     * This method takes a list of integer values and counts
     * the occurrence of each number without the help of streams
     * to count number of occurrences
     */
    static void sortedElementCountsWithoutStream(int inputArray[])
    {
        if(null != inputArray) {
            //Use a tree map so the values are sorted
            Map<Integer, Long> value_count = new TreeMap<>();

            for (int entry:inputArray) {
                if(value_count.containsKey(entry))
                    value_count.put(entry,value_count.get(entry)+1);
                else
                    value_count.put(entry,1L);
            }


            StringJoiner result = new StringJoiner(", ", "{", "}");
            //iterate over the map and add each number and its count to the final output
            value_count.entrySet().forEach(e -> result.add(e.getKey() + ":" + e.getValue()));
            //print the results
            System.out.println(result);
        }
    }

    /**
     * This method takes a list of integer values and counts
     * the occurrence of each number without the help of streams
     * or map to count number of occurrences
     */
    static void sortedElementCountsWithoutCollections(int inputArray[]) {
        if (null != inputArray) {
            //sort the array using bubble sort,
            // a merge sort maybe better suited for large input lists
            //but I am implementing a bubble as our inputs are short
            bubbleSort(inputArray);

            StringJoiner result = new StringJoiner(", ", "{", "}");

            int count = 1;
            for (int i = 0; i < inputArray.length; i++){
                if(i<inputArray.length-1 && (inputArray[i] == inputArray[i+1]))
                    count++;
                else{
                    result.add(inputArray[i]+":"+count);
                    count = 1;
                }
            }

            System.out.println(result);
        }
    }


    static void bubbleSort(int input[])
    {
        int length = input.length;
        for (int i = 0; i < length-1; i++)
            for (int j = 0; j < length-i-1; j++)
                if (input[j] > input[j+1])
                {
                    // swap input[j+1] and input[j]
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
    }


}
