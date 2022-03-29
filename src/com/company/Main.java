package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Picture obrazek = new Picture();
        Scanner input = new Scanner(System.in);
        String option;
        double x1,y1,x2,y2,r;

        do{
            System.out.println("Menu\n" +
                    "1 Dodaj punkt do obrazka.\n" +
                    "2 Dodaj odcinek do obrazka.\n" +
                    "3 Dodaj koło do obrazka.\n" +
                    "4 Wyświetlanie obiektu obrazka.\n" +
                    "5 Przesunięcie obrazka o wektor.\n" +
                    "6 Suma wszystkich pól.\n" +
                    "w Wyjście.\n" +
                    "Wybierz>");
            option = input.nextLine();
            switch(option){
                case"1":
                    System.out.println("Podaj współrzedne punktu x: \n");
                    x1 = input.nextDouble();
                    System.out.println("Podaj współrzedne punktu y: \n");
                    y1 = input.nextDouble();
                    obrazek.add(new Point(x1,y1));
                    break;
                case"2":
                    System.out.println("Podaj współrzędne punktu1 x1 i y1: \n");
                    x1 = input.nextDouble();
                    y1 = input.nextDouble();

                    System.out.println("Podaj współrzędne punktu2 x2 i y2: \n");
                    x2 = input.nextDouble();
                    y2 = input.nextDouble();

                    obrazek.add(new Section(new Point(x1,y1),new Point(x2,y2)));
                    break;
                case"3":
                    System.out.println("Podaj współrzędne środka x1 i y1: \n");
                    x1 = input.nextDouble();
                    y1 = input.nextDouble();

                    System.out.println("Podaj długość promienia: \n");
                    r = input.nextDouble();
                    obrazek.add(new Circle(new Point(x1,y1),r));
                    break;
                case"4":
                    System.out.println("Obrazek : \n");
                    System.out.println(obrazek);
                    break;
                case"5":
                    System.out.println("Przesunięcie obrazka o zadany wektor x i y: \n");
                    x1 = input.nextDouble();
                    y1 = input.nextDouble();

                    obrazek.movePicture(x1,y1);
                    break;
                case"6":
                    System.out.println("Suma wszystkich pól wynosi: \n");
                    System.out.println(obrazek.getArea());
                    break;
                default:
                    System.out.println("Brak opcji "+option);
                    break;
            }
        } while (!"w".equals(option));
    }
}
