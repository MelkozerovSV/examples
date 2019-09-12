/*
Перевертыши
1. Считать с консоли имя файла. Считать содержимое файла.
2. Для каждой строки в файле:
2.1. переставить все символы в обратном порядке.
2.2. вывести на экран.
3. Закрыть потоки.

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА

Требования:
•	Программа должна считывать имя файла с консоли (используй BufferedReader).
•	BufferedReader для считывания данных с консоли должен быть закрыт.
•	Программа должна считывать содержимое файла (используй FileReader).
•	Поток чтения из файла (FileReader) должен быть закрыт.
•	Программа должна выводить в консоль все символы из файла в обратном порядке.

C:\Users\operator\Desktop\file1.txt
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileReader fr = new FileReader(br.readLine());
            br.close();
            br = new BufferedReader(fr);
            ArrayList<String> lines = new ArrayList<>();
            while (br.ready()) {
                lines.add(br.readLine());
            }
            for (int i = 0; i < lines.size(); i ++) {
                for (int ii = lines.get(i).length() - 1; ii >= 0; ii--) {
                    System.out.print(lines.get(i).toCharArray()[ii]);
                }
                System.out.println();
            }
            fr.close();

        }catch (IOException ioe) {ioe.printStackTrace();}
    }
}