import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class FakerMain {

    private static String locale;
    private static Locale loc;
    private static int quantity;
    private static float averageErr;
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private static String fullAlphabet = alphabet + alphabet.toUpperCase();
    private static String ruAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static String fullRuAlphabet = ruAlphabet + ruAlphabet.toUpperCase();
    private static String byAlphabet = "абвгдеёжз\u0456йклмнопрсту\u045Eфхцчшыьэюя";
    private static String fullByAlphabet = byAlphabet + byAlphabet.toUpperCase();

    public static void main(String[] args) {

        if (args.length == 3) {

            if ((args[0].equals("by_BY") || args[0].equals("en_US") || args[0].equals("ru_RU")) && ((args[1] != null &&
                    Integer.valueOf(args[1]) >= 1) && (args[2] != null && Float.valueOf(args[2]) >= 0))) {
                locale = args[0];
                quantity = Integer.valueOf(args[1]);
                averageErr = Float.valueOf(args[2]);
                loc = new Locale(locale);
                printData();
            } else {
                System.out.println("Incorrect input arguments");
            }

        } else if (args.length == 2) {
            if ((args[0].equals("by_BY") || args[0].equals("en_US") || args[0].equals("ru_RU")) && ((args[1] != null)
                    && (Integer.valueOf(args[1]) >= 1))) {
                locale = args[0];
                quantity = Integer.valueOf(args[1]);
                averageErr = 0;
                loc = new Locale(locale);
                printData();

            } else {
                System.out.println("Incorrect input arguments");
            }
        }
    }


    private static void printData() {

        for (int i = 0; i < quantity; ) {
            String personData = newPersonData();
            if (averageErr >= 1) {

                for (int j = 1; j <= averageErr; j++) {
                    if (i >= quantity) {
                        break;
                    }
                    personData = addError(personData);
                }
                System.out.println(personData);
                i++;
            }
            if (averageErr > 0 && averageErr < 1) {
                for (float j = averageErr; j < 1; j += averageErr) {
                    if (i >= quantity) {
                        break;
                    }
                    System.out.println(newPersonData());
                    i++;
                }
                if (i >= quantity) {
                    break;
                }
                personData = addError(personData);
                System.out.println(personData);
                i++;
            } else if (averageErr == 0) {
                System.out.println(newPersonData());
                i++;
            }
        }
    }

    private static String newPersonData() {

        return new Person(new Faker(loc)).toString();
    }

    private static String addError(String personData) {

        String data = personData;
        int index = new Random().nextInt(data.length() - 1);
        int err = new Random().nextInt(3);


        if (err == 0) {
            return replaceSymbol(data, index);
        } else if (err == 1) {
            return deleteSymbol(data, index);
        } else {
            return addSymbol(data, locale, index);
        }

    }

    private static String replaceSymbol(String data, int index) {
        return data.replace(data.charAt(index), data.charAt(index + 1));
    }

    private static String deleteSymbol(String data, int index) {
        return data.substring(0, index).concat(data.substring(index + 1));
    }

    private static String addSymbol(String data, String locale, int index) {

        switch (locale) {
            case "by_BY":
                data = data.substring(0, index) + fullByAlphabet.charAt(new Random().nextInt(fullByAlphabet.length())) +
                        data.substring(index);
                break;

            case "ru_RU":
                data = data.substring(0, index) + fullRuAlphabet.charAt(new Random().nextInt(fullRuAlphabet.length())) +
                        data.substring(index);
                break;
            case "en_US":
                data = data.substring(0, index) + fullAlphabet.charAt(new Random().nextInt(fullAlphabet.length())) +
                        data.substring(index);
                break;
        }
        return data;
    }


}