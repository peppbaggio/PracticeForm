package ru.yandex.peppbaggio;

public class First {

     public static void main(String[] args) {

        /* применить несколько арифметических операций ( + , -, * , /)
        над двумя примитивами типа int */
            int x = 12;
            int y = 14;
            int result = (x + y) / (y-x) * x;

            System.out.println("result = " + result);


        /* применить несколько арифметических операций над int и double
        в одном выражении */

            double z = x;
            double doubleResult;
            doubleResult = z * y + x / z;

            System.out.println("doubleResult = " + doubleResult);


            // применить несколько логических операций (< , >, >=, <=)

            System.out.println("result > doubleResult: "+ (result > doubleResult));
            System.out.println("result + doubleResult <= x * y * z: " +
                    (result + doubleResult <= x * y * z));


            //получить переполнение при арифметической операции

            int minInt = Integer.MIN_VALUE;
            int maxInt = Integer.MAX_VALUE;
            System.out.println("Переполнение int: " + (minInt - 1));
            System.out.println("Переполнение int: " + (maxInt + 1));

        }
}


