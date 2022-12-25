import java.util.Scanner;

public class Main {
/*    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.matches("\\d+")) { // it checks if the input line contains only digits
            int number = Integer.parseInt(input);
            System.out.println(number + 1);
        } else {
            System.out.println("Incorrect number: " + input);
        }
    }*/
public static String concatStrings(String str1, String str2) {
    if (str1 != null && str2 != null) {
        return str1.concat(str2);
    }
    else if (str1 == null && str2 != null) {
        return str2;
    } else if (str1 != null && str2 == null) {
        return str1;
    } else {
        return "";
    }

}

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        str1 = "null".equalsIgnoreCase(str1) ? null : str1;
        str2 = "null".equalsIgnoreCase(str2) ? null : str2;

        System.out.println(concatStrings(str1, str2));
    }
}