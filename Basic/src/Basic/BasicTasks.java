package Basic;

import java.util.concurrent.ThreadLocalRandom;

public class BasicTasks {

    public static void main(String [] args){
//        printHelloWorld();

//        printHelloWorldV();

//        printParameterString("Cats!!");

//        String wordToPrint;
//        wordToPrint = helloWorld();
//        System.out.println(wordToPrint);

//        int sum;
//        sum = getSum(2,4);
//        System.out.println(sum);

//        int sum;
//        sum = conditionalMathOperation(2,4,false);
//        System.out.println(sum);

//        loopMathOperation();

//        arrays();

        arraysTwo();
    }

    public static void printHelloWorld(){
        System.out.println("Hello World");
    }

    public static void printHelloWorldV(){
        String helloWorld = "Hello World!";
        System.out.println(helloWorld);
    }

    public static void printParameterString(String words){
        System.out.println(words);
    }

    public static String helloWorld(){
        return "Hello World!";
    }

    public static int getSum(int firstNo, int secondNo){
        return firstNo+secondNo;
    }

    public static int conditionalMathOperation(int firstNo, int secondNo, boolean isAddition){
        if(firstNo == 0){
            return secondNo;
        }
        else if(secondNo == 0){
            return firstNo;
        }else{
            if (isAddition) {
                return firstNo + secondNo;
            }
            else {
                return firstNo * secondNo;
            }
        }
    }

    public static void loopMathOperation(){
        for (int i = 0; i<10; i++){
            System.out.println(conditionalMathOperation(i,4,true));
        }
    }

    public static void arrays(){
        int numArray[] = new int[10];
        int cntr = 0;
        while(cntr<numArray.length){
            numArray[cntr]= ThreadLocalRandom.current().nextInt(1,10+1);
            cntr++;
        }
        for (int i=0;i<numArray.length;i++){
            System.out.println(numArray[i]);
        }
        System.out.println("***End***");

        for(int i=0;i<numArray.length;i++){
            int toPrint = conditionalMathOperation(numArray[i], 4, true);
            System.out.println(toPrint);
        }

    }

    public static void arraysTwo(){
        int numArray[] = new int[10];
        int cntr = 0;
        while(cntr<numArray.length){
            numArray[cntr]= ThreadLocalRandom.current().nextInt(1,10+1);
            System.out.println(numArray[cntr]);
            cntr++;
        }
        System.out.println("***End***");
        for(int i =0; i< numArray.length;i++){
            numArray[i] = numArray[i]*10;
            System.out.println(numArray[i]);
        }
    }


}
