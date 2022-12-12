package Classes;
//28. Выбрать из текста все слова, в которых встречаются, как русские, так и
//        латинские буквы. Словом считается непрерывная последовательность символов (строчных и
//        прописных) А-Я, A-Z и цифр.


import java.io.IOException;
import java.util.regex.Pattern;

public class MainLogic {
    public static String getAnswer(String str){
        String string = " ";
        Pattern pattern1 = Pattern.compile("[a-zA-Zа-яА-Я]*[0-9]*[a-zA-Z]+[а-яА-Я]+[a-zA-Zа-яА-Я]*");
        Pattern pattern2 = Pattern.compile("[a-zA-Zа-яА-Я]*[a-zA-Z]+[а-яА-Я]+[0-9]*[a-zA-Zа-яА-Я]*");
        Pattern pattern3 = Pattern.compile("[a-zA-Zа-яА-Я]*[а-яА-Я]+[0-9]*[a-zA-Z]+[a-zA-Zа-яА-Я]*");
        Pattern pattern4 = Pattern.compile("[a-zA-Zа-яА-Я]*[0-9]*[а-яА-Я]+[a-zA-Z]+[a-zA-Zа-яА-Я]*");
        Pattern pattern5 = Pattern.compile("[a-zA-Zа-яА-Я]*[a-zA-Z]+[0-9]*[а-яА-Я]+[a-zA-Zа-яА-Я]*");
        Pattern pattern6 = Pattern.compile("[a-zA-Zа-яА-Я]*[а-яА-Я]+[a-zA-Z]+[0-9]*[a-zA-Zа-яА-Я]*");
        String[] parts = str.split("[,.;:!?()\\s]+");
        for (String p : parts){
            if ((pattern1.matcher(p).matches() | pattern2.matcher(p).matches() | pattern3.matcher(p).matches() | pattern4.matcher(p).matches() | pattern5.matcher(p).matches() | pattern6.matcher(p).matches())){
                string += "[" + p + "] ";
//            }else{
//                string += "kek ";
            }
        }
        return string.trim().replace(" ", ", ");
    }
    //    .\input.txt .\output.txt
    public static void readAndWriteMethod(InputArgs inputArgs) throws IOException {
        String str = ClassesForInAndOut.readFile(inputArgs.getInputFile());
        String answer = MainLogic.getAnswer(str);
        ClassesForInAndOut.writeFile(inputArgs.getOutputFile(),answer);
    }
    public static void printSuccessMessage(int num){
        if(num==0){
            System.out.println("Основная программа выполнена.");
        }else{
            System.out.println("Тест " + num + " выполнен успешно.");
        }
        System.out.println();
    }
}
