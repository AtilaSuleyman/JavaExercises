package Intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntermediateTasks {

    public static void main(String[] args) {

//        int result = blackjack(19,14);
//        System.out.println(result);

//        int result = uniqueSum(2,3,2);
//        System.out.println(result);

//        tooHot(91, true);

//        outputPeople();

        System.out.println(searchName("Ben"));

    }

    public static int blackjack(int firstNo, int secondNo) {
        int firstPlayer = firstNo;
        int secondPlayer = secondNo;
        int firstResult = 0;
        int secondResult = 0;
        int finalResult = 0;
        if (firstPlayer > 21 && secondPlayer > 21) {
            return finalResult;
        } else {
            if (firstPlayer > 21) {
                finalResult = secondPlayer;
            } else if (secondPlayer > 21) {
                finalResult = firstPlayer;
            } else {
                firstResult = 21 - firstNo;
                secondResult = 21 - secondNo;
                if (firstResult < secondResult) {
                    finalResult = firstPlayer;
                } else {
                    finalResult = secondPlayer;
                }
            }
        }
        return finalResult;
    }

    public static int uniqueSum(int firstNo, int secondNo, int thirdNo) {

//        Integer [] numArray = {firstNo, secondNo, thirdNo};
//        Set<Integer> set = new HashSet<Integer>(Arrays.asList(numArray));
//        numArray = set.toArray(new Integer[set.size()]);
//        System.out.println(numArray.length);
//
//        int sum = 0;
//        for(Integer i : numArray){
//            sum = sum+i;
//        }
//        return sum;

        if (firstNo == secondNo && firstNo == thirdNo) {
            return 0;
        } else if (firstNo == thirdNo) {
            return secondNo;
        } else if (secondNo == thirdNo) {
            return firstNo;
        } else if (firstNo == secondNo) {
            return thirdNo;
        } else {
            return firstNo + secondNo + thirdNo;
        }
    }

    public static Boolean tooHot(int temp, boolean isSummer) {
        boolean tooHot = false;
        if (isSummer) {
            if (temp > 59 && temp < 101) {
                tooHot = true;
            }
        } else {
            if (temp > 59 && temp < 91) {
                tooHot = true;
            }
        }
        System.out.println(tooHot);
        return tooHot;
    }

    public static ArrayList intialisePeople() {
        ArrayList<Person> people = new ArrayList<Person>();
        Person p = new Person("Atila", 22, "IT Consultant");
        people.add(p);
        p = new Person("Mahmoud", 22, "IT Consultant");
        people.add(p);
        p = new Person("Ben", 22, "IT Consultant");
        people.add(p);

        return people;
    }

    public static void outputPeople() {
        ArrayList<Person> people = intialisePeople();
        for (Person p : people) {
            System.out.println(p);
        }
    }

    public static Person searchName(String name) {
        ArrayList<Person> people = intialisePeople();
        for (Person p : people) {
            if (name.equalsIgnoreCase(p.getName())) {
                System.out.println("Your person has been found! \n");
                return p;

            }
        }
        System.out.println(name + " " + "has not been found!");
        return null;
    }
}
