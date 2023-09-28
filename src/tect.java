import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class tect {
    public static void main(String args[]) throws FileNotFoundException {
        int i = (int) (Math.random() * 100) + 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int a = scanner.nextInt();
        int b = 1;
        while (a != i) {
            b++;
            if (a > i) {
                System.out.println("Загаданное число меньше");
                System.out.println("Введите число");
                a = scanner.nextInt();
            } else {
                System.out.println("Загаданное число больше");
                System.out.println("Введите число");
                a = scanner.nextInt();
            }
        }
        System.out.println(b);
        scanner.close();
        File file = new File("results.txt");
        try {
            Scanner scanner1 = new Scanner(file);
            String line = scanner1.nextLine();
            int c = Integer.parseInt(line.trim());
            if (b < c) {
                PrintWriter pw;
                pw = new PrintWriter(file);
                pw.println(b);
                pw.close();
                System.out.println("Последняя лучшая попытка - " + c);
            } else {
                System.out.println("Лучшая попытка - " + c);
            }
        } catch (NoSuchElementException kiril) {
            PrintWriter pw;
            pw = new PrintWriter(file);
            pw.println(b);
            pw.close();
        }
    }
}
