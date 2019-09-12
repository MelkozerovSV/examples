
/*В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013

Требования:
•	Класс Solution должен содержать публичную константу PEOPLE типа List<Person>, которая должна быть сразу проинициализирована.
•	Программа НЕ должна считывать данные с консоли.
•	Программа должна считывать содержимое файла (используй FileReader).
•	Поток чтения из файла (FileReader) должен быть закрыт.
•	Программа должна заполнить список PEOPLE данными из файла.
•	Программа должна правильно работать с двойными именами, например Анна-Надежда.
*/
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader(args[0]);
            BufferedReader br = new BufferedReader(fr);
            String[] nameAndBirthdaySplited;
            String nameAndBirthday, name = "";
            DateTimeFormatter formatter;
            LocalDate brthdate;
            Date brthDate;
            int nameAndBirthdaySplitedLength;
            while (br.ready()) {
                name = "";

                nameAndBirthdaySplited = br.readLine().split(" ");
                brthDate = new SimpleDateFormat("d/M/yyyy").parse(nameAndBirthdaySplited[nameAndBirthdaySplited.length - 3] + "/" +
                        nameAndBirthdaySplited[nameAndBirthdaySplited.length - 2] + "/" +
                        nameAndBirthdaySplited[nameAndBirthdaySplited.length - 1]);
                for (int i = 0; i <= nameAndBirthdaySplited.length - 4; i++) {
                    if (i != nameAndBirthdaySplited.length - 4)
                        name += nameAndBirthdaySplited[i] + " ";
                    else name += nameAndBirthdaySplited[i];
                }
                PEOPLE.add(new Person(name, brthDate));


            }

            fr.close();
            br.close();

        }
        catch (IOException ioe) {ioe.printStackTrace();}
        catch (ParseException pe) {pe.printStackTrace();}
        for (int i = 0; i < PEOPLE.size(); i ++) System.out.println(PEOPLE.get(i).getName() + " " + PEOPLE.get(i).getBirthDate());
    }
}