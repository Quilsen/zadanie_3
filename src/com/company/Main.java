package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ArithmeticException {
        Picture obrazek = new Picture();
        Scanner input = new Scanner(System.in);
        String option;
        double x1,y1,x2,y2,r;

        do{
            System.out.println("""
                    Menu
                    1 Dodaj punkt do obrazka.
                    2 Dodaj odcinek do obrazka.
                    3 Dodaj koło do obrazka.
                    4 Wyświetlanie obiektu obrazka.
                    5 Przesunięcie obrazka o wektor.
                    6 Suma wszystkich pól.
                    w Wyjście.
                    Wybierz>""");
            option = input.nextLine();
            switch (option) {
                case "1" -> {
                    System.out.println("Podaj współrzedne punktu x: \n");
                    x1 = input.nextDouble();
                    System.out.println("Podaj współrzedne punktu y: \n");
                    y1 = input.nextDouble();
                    obrazek.add(new Point(x1, y1));
                }
                case "2" -> {
                    System.out.println("Podaj współrzędne punktu1 x1 i y1: \n");
                    x1 = input.nextDouble();
                    y1 = input.nextDouble();
                    System.out.println("Podaj współrzędne punktu2 x2 i y2: \n");
                    x2 = input.nextDouble();
                    y2 = input.nextDouble();
                    obrazek.add(new Section(new Point(x1, y1), new Point(x2, y2)));
                }
                case "3" -> {
                    System.out.println("Podaj współrzędne środka x1 i y1: \n");
                    x1 = input.nextDouble();
                    y1 = input.nextDouble();
                    System.out.println("Podaj długość promienia: \n");
                    r = input.nextDouble();
                    if (r < 0) {
                        throw new ArithmeticException("Wartość powinna być większa od zera");
                    }
                    obrazek.add(new Circle(new Point(x1, y1), r));
                }
                case "4" -> {
                    System.out.println("Obrazek : \n");
                    System.out.println(obrazek);
                }
                case "5" -> {
                    System.out.println("Przesunięcie obrazka o zadany wektor x i y: \n");
                    x1 = input.nextDouble();
                    y1 = input.nextDouble();
                    obrazek.movePicture(x1, y1);
                }
                case "6" -> {
                    System.out.println("Suma wszystkich pól wynosi: \n");
                    System.out.println(obrazek.getArea());
                }
                default -> System.out.println("Brak opcji " + option);
            }
        } while (!"w".equals(option));
    }
}
