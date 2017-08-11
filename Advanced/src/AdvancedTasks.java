public class AdvancedTasks {
    public static void main(String[] args) {
        AdvancedTasks.primeNumbersTwo(3000000000.00);
    }

    public static int primeNumbersOne(int num) {

        int primeCntr = 2;
        switch (num) {
            case 1:
                return 0;
            case 2:
            case 3:
                return num;
            default:
                for (int i = 4; i < num; i++) {
                    boolean isPrime = true;
                    if (i % 2 == 0) {
                        isPrime = false;
                    }
                    else {
                        int numerator = 3;
                        while (numerator * numerator <= i) {
                            if (i % numerator == 0) {
                                isPrime = false;
                            }
                            numerator = numerator + 2;
                        }
                        if(isPrime){
                            primeCntr++;
                        }
                    }
                }
        }
        System.out.println(primeCntr);
        return primeCntr;
    }

    public static double primeNumbersTwo(double num) {

        double primeCntr = 2;
        switch ((int)num) {
            case 1:
                return 0;
            case 2:
            case 3:
                return num;
            default:
                for (double i = 4; i < num; i++) {
                    boolean isPrime = true;
                    if (i % 2 == 0) {
                        isPrime = false;
                    }
                    else {
                        double numerator = 3;
                        while (numerator * numerator <= i) {
                            if (i % numerator == 0) {
                                isPrime = false;
                            }
                            numerator = numerator + 2;
                        }
                        if(isPrime){
                            primeCntr++;
                            System.out.println(primeCntr);
                        }
                    }
                }
        }
        System.out.println(primeCntr);
        return primeCntr;
    }
}
