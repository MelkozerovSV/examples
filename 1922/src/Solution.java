import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words.
Закрыть потоки.

Пример:
words содержит слова А, Б, В

Строки:
В Б А Д //3 слова из words, не подходит
А Б А Д //3 слова из words, не подходит
Д А Д //1 слово из words, не подходит
Д А Б Д //2 слова - подходит, выводим
Д А А Д //2 слова - подходит, выводим

Требования:
•	Класс Solution должен содержать публичное статическое поле words типа List<String>, которое должно быть сразу проинициализировано.
•	Класс Solution должен содержать статический блок, в котором добавляются три или больше слов в список words.
•	Программа должна считывать имя файла с консоли (используй BufferedReader).
•	BufferedReader для считывания данных с консоли должен быть закрыт.
•	Программа должна считывать содержимое файла (используй FileReader).
•	Поток чтения из файла (FileReader) должен быть закрыт.
•	Программа должна выводить в консоль все строки из файла, которые содержат всего 2 слова из списка words.
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileReader fr;
            fr = new FileReader(br.readLine());
            br.close();
            br = new BufferedReader(fr);
            ArrayList<String> output = new ArrayList<>();
            while (br.ready()) {
                int wordCounter = 0;
                StringBuilder fileStringBuilder = new StringBuilder(br.readLine());
                for (int i = 0; i < words.size(); i++) {
                    int ii;
                    for (int j = 0; j < fileStringBuilder.length(); j++) {

                        ii = fileStringBuilder.indexOf(words.get(i), j);
                        if (ii != -1) {
                            wordCounter++;
                            j += ii + words.get(i).length();
                        } else break;
                    }
                }
                if (wordCounter == 2) output.add(fileStringBuilder.toString());
            }
            br.close();
            for (int i = 0; i < output.size(); i++) System.out.println(output.get(i));

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
