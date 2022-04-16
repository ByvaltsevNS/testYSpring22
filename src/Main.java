import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void taskA() {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();

        int[] arr = new int[count+1];
        arr[0] = 0;
        int[] numbers = new int[count];
        char[] chars = new char[count];

        for (int i = 1; i <= count; i++) {
            arr[i] = input.nextInt();
            //Get 1 in the changed bit
            numbers[i-1] = arr[i-1] ^ arr[i];
            //Get the rank number
            chars[i-1] = (char) (Math.log(numbers[i-1]) / Math.log(2));
            //Get the char code in ASCII
            if (chars[i-1] == 26) {
                chars[i-1] = 32;
            } else {
                chars[i-1] += 97;
            }
        }

        for (int i = 0; i < count; i++) {
            System.out.print(chars[i]);
        }
    }

    public static void taskB() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();

        StringBuilder[] field = new StringBuilder[n];
        for (int i = 0; i < n; i++) {
            field[i] = new StringBuilder(input.next());
        }
        // Output
        for (int i = 0; i < n; i++) {
            System.out.print(i);
            System.out.println(field[i]);
        }

        Pattern pattern;
        // "/_\" top
        pattern = Pattern.compile("[.]_[.]");
        for (int i = 0; i < n/2; i++) {
            field[i] = new StringBuilder(pattern.matcher(field[i]).replaceAll("/_\\\\"));
        }
        // Output
        System.out.println("\"/_\\\" top");
        for (int i = 0; i < n; i++) {
            System.out.print(i);
            System.out.println(field[i]);
        }
        // "._." bottom
        pattern = Pattern.compile("[.]\\\\_/[.]");
        for (int i = n/2+1; i < n; i++) {
            field[i] = new StringBuilder(pattern.matcher(field[i]).replaceAll("._."));
        }
        // Output
        System.out.println("\"._.\" bottom");
        for (int i = 0; i < n; i++) {
            System.out.print(i);
            System.out.println(field[i]);
        }

        StringBuilder aux;
        // Vertical
        for (int i = 0; i < n; i++) {
            field[i] = field[i].reverse();
        }
        // Output
        System.out.println("Vertical:");
        for (int i = 0; i < n; i++) {
            System.out.print(i);
            System.out.println(field[i]);
        }
        // Horizontal
        for (int i = 1; i < n / 2; i++) {
            aux = field[i];
            field[i] = field[n-i-1];
            field[n-i-1] = aux;
        }
        // Output
        System.out.println("Horizontal:");
        for (int i = 0; i < n; i++) {
            System.out.print(i);
            System.out.println(field[i]);
        }

        // "\." top bottom middle
        pattern = Pattern.compile("/[.]");
        for (int i = 0; i < n; i++) {
            field[i] = new StringBuilder(pattern.matcher(field[i]).replaceAll("\\\\."));
        }
        // Output
        System.out.println("\"\\.\" top bottom middle");
        for (int i = 0; i < n; i++) {
            System.out.print(i);
            System.out.println(field[i]);
        }
        // "\_/" bottom + middle
        pattern = Pattern.compile("\\D_\\D");
        for (int i = n/2; i < n; i++) {
            field[i] = new StringBuilder(pattern.matcher(field[i]).replaceAll("\\\\_/"));
        }
        // Output
        System.out.println("\"\\_/\" bottom + middle");
        for (int i = 0; i < n; i++) {
            System.out.print(i);
            System.out.println(field[i]);
        }
        //
        for (int i = 1; i < n/2; i++) {
            pattern = Pattern.compile("[.]\\D");
            field[i] = new StringBuilder(pattern.matcher(field[i]).replaceAll("./"));
            pattern = Pattern.compile("\\D[.]");
            field[i] = new StringBuilder(pattern.matcher(field[i]).replaceAll("\\\\."));
        }
        // Output
        for (int i = 0; i < n; i++) {
            System.out.print(i);
            System.out.println(field[i]);
        }
        System.out.println();
        for (int i = 1; i < n/2; i++) {
            pattern = Pattern.compile("[.]\\D_");
            field[i] = new StringBuilder(pattern.matcher(field[i]).replaceAll(".._"));
            pattern = Pattern.compile("_\\D[.]");
            field[i] = new StringBuilder(pattern.matcher(field[i]).replaceAll("_.."));
            pattern = Pattern.compile("_\\\\");
            field[i] = new StringBuilder(pattern.matcher(field[i]).replaceAll("_/"));
            pattern = Pattern.compile("/_");
            field[i] = new StringBuilder(pattern.matcher(field[i]).replaceAll("\\\\_"));
        }
        // Output
        for (int i = 0; i < n; i++) {
            System.out.print(i);
            System.out.println(field[i]);
        }
        System.out.println();

        pattern = Pattern.compile("\\D_\\D");
        for (int i = n/2; i < n; i++) {
            field[i] = new StringBuilder(pattern.matcher(field[i]).replaceAll("\\\\_/"));
        }
        // Output
        for (int i = 0; i < n; i++) {
            System.out.print(i);
            System.out.println(field[i]);
        }
        System.out.println();
        pattern = Pattern.compile("[.]\\D");
        field[n/2] = new StringBuilder(pattern.matcher(field[n/2]).replaceAll("./"));
        pattern = Pattern.compile("\\D[.]");
        field[n/2] = new StringBuilder(pattern.matcher(field[n/2]).replaceAll("\\\\."));
        // Output
        for (int i = 0; i < n; i++) {
            System.out.print(i);
            System.out.println(field[i]);
        }
        System.out.println();
    }

    public static void test() {
        char[] arr = {'.', '/', 'A', '\\', '_', '/', '.'};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();

        char[] arr1 = new char[10];
        for (int i = 0; i < arr.length; i++) {
            if (arr[arr.length-1-i] == '/') {
                arr1[i] = '\\';
            } else if(arr[arr.length-1-i] == '\\') {
                arr1[i] = '/';
            } else {
                arr1[i] = arr[arr.length-1-i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr1[i]);
        }
        System.out.println();
    }
    public static void main (String[] args) {
        //test();
        taskB();
    }
}
