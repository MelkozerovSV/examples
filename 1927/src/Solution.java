/*
Контекстная реклама
В методе main подмени объект System.out написанной тобой реадер-оберткой.
Твоя реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а.
Вызови готовый метод printSomething(), воспользуйся testString.
Верни переменной System.out первоначальный поток.

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth

Требования:
•	Класс Solution должен содержать класс TestString.
•	Класс Solution должен содержать публичное статическое поле testString типа TestString, которое сразу проинициализировано.
•	Класс TestString должен содержать публичный void метод printSomething().
•	Метод printSomething() класса TestString должен выводить на экран строки: "first","second","third","fourth","fifth".
•	Метод main(String[] args) класса Solution должен создавать поток PrintStream (используй PrintStream c конструктором принимающим ByteArrayOutputStream).
•	Метод main(String[] args) класса Solution должен подменять и восстанавливать поток вывода в консоль объекта System.out.
•	Метод main(String[] args) класса Solution должен вызывать метод printSomething(),объекта testString.
•	Метод main(String[] args) класса Solution должен модифицировать строки(вставлять контекстную рекламу) выведенные методом printSomething() согласно заданию, и выводить её в консоль.
*/


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream fakeSysOut = new PrintStream(outputStream);
        System.setOut(fakeSysOut);
        TestString testString = new TestString();
        testString.printSomething();
        System.setOut(consoleStream);
        String[] sySout = outputStream.toString().split("\n");
        for (int i = 0; i < sySout.length; i++){
            if (i%2 == 0 & i != 0) {
                System.out.println("JavaRush - курсы Java онлайн");
            }
            System.out.println(sySout[i]);
        }
        //System.out.println(sySout);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
