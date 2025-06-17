package game;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class FullPool {
    public int size;
    public Scanner sc = new Scanner(System.in);
    public char[][] mass;

    public FullPool() {
        System.out.println("Введіть куди записувати налаштування: ");
        String name = sc.nextLine();
        System.out.println("Введіть ім'я першого гравця(X): ");
        String kor = sc.nextLine();
        System.out.println("Введіть ім'я другого гравця(0): ");
        String kor2 = sc.nextLine();
        LocalDateTime now = LocalDateTime.now();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(name, true))){
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Оберіть розмір(3x3, 5x5, 7x7, 9x9)");
            size = scanner1.nextInt();
            mass = new char[size + 1][size + 1];
            for (int i = 0; i < mass.length; i++) {
                for (int j = 0; j < mass[i].length; j++) {
                    mass[i][j] = ' ';
                }
            }
            bw.write("Розмір поля: " + size + "\n" + "Ім'я першого граіця: " + kor + "\n" + "Ім'я другого гравця: " + kor2 + "\n" + "Дата гри: " + now);
            bw.close();
            Gra.set(mass, size, kor, kor2);
        } catch (IOException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
    public static void Pool() {
        FullPool fp = new FullPool();
    }
}
