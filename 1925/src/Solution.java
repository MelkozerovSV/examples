/*
Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.

Пример выходных данных в файл2:
длинное,короткое,аббревиатура

Требования:
•	Программа НЕ должна считывать данные с консоли.
•	Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
•	Поток чтения из файла (FileReader) должен быть закрыт.
•	Программа должна записывать через запятую во второй файл все слова из первого файла длина которых строго больше 6(используй FileWriter).
•	Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader(args[0]);
            BufferedReader br = new BufferedReader(fr);
            ArrayList<String> words = new ArrayList<>();
            String[] parsedFileLine;
            while (br.ready()) {
                parsedFileLine = br.readLine().split(" ");
                for (int i = 0; i < parsedFileLine.length; i++) {
                    words.add(parsedFileLine[i]);
                }
            }
            fr.close();
            br.close();
            FileWriter fw = new FileWriter(args[1]);
            BufferedWriter bw = new BufferedWriter(fw);
            String result = "";
            for (int i = 0; i < words.size(); i++) {
                if (words.get(i).length() > 6) {
                    result+= words.get(i) + ",";
                }
            }
            bw.write(result, 0, result.length() - 1);
            bw.flush();
            bw.close();
            fw.close();
        }catch (IOException ioe) {ioe.printStackTrace();}
    }
}
