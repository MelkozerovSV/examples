
/*
Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со словами, разделенными пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.

Требования:
•	Программа НЕ должна считывать данные с консоли.
•	Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
•	Поток чтения из файла (FileReader) должен быть закрыт.
•	Программа должна записывать во второй файл все слова из первого файла которые содержат цифры (используй FileWriter).
•	Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader(args[0]);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(args[1]);
            BufferedWriter bw = new BufferedWriter(fw);
            String[] inputStringArray;
            String result = "";
            Pattern pattern = Pattern.compile(".*\\d+.*");
            while (br.ready()) {
                inputStringArray = br.readLine().split(" ");
                for (int i = 0; i < inputStringArray.length; i ++) {
                    if (pattern.matcher(inputStringArray[i]).find()) {
                        result = result.concat(inputStringArray[i] + " ");
                    }
                }
            }
            bw.write(result, 0, result.length() - 1);
            bw.flush();
            fr.close();
            br.close();
            fw.close();
            bw.close();
        }catch (IOException ioe) {ioe.printStackTrace();}
    }
}
