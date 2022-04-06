package com.company;


import java.util.Scanner;


public class Main {

    public static void main(String... args){
        Picture p = null;
        Scanner input = new Scanner(System.in);
        String option1 = "0", option2 ,label;
        double x1,y1,x2,y2,r;


        while (option1.equals("0")){
            System.out.println("""
                    Wybór typu obrazka:
                    1 Picture
                    2 UniquePicture
                    3 StandarizedPicture
                    q Wyjście""");
            option1 = input.nextLine();
            switch (option1){
                case "1" -> {
                    p = new Picture();
                    System.out.println("Utworzono obiekt typu Picture\n");
                }

                case "2" -> {
                    p = new UniquePicture();
                    System.out.println("Utworzono obiekt typu UniquePicture\n");
                }

                case "3" ->{
                    p = new StandarizedPicture();
                    System.out.println("Utworzono obiekt typu StandarizedPicture\n");
                }

                case "q" -> System.exit(0);

                default -> System.out.println("Brak opcji: " + option1);
            }
        }

        while (true){
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
            option2 = input.next();
            switch (option2) {
                case "1" -> {
                    System.out.println("Podaj współrzedne punktu x: \n");
                    x1 = input.nextDouble();
                    System.out.println("Podaj współrzedne punktu y: \n");
                    y1 = input.nextDouble();
                    System.out.println("Podaj nazwę punktu label: \n");
                    label = input.next();
                    if (p != null) {
                        if (p.add(new Point(x1,y1,label))){
                            System.out.println("Utworzono obiekt z powodzeniem");
                        } else System.out.println("Nie udało się utworzyć obiektu");
                    }
                }

                case "2" -> {
                    System.out.println("Podaj współrzędne punktu1 x1 i y1: \n");
                    x1 = input.nextDouble();
                    y1 = input.nextDouble();
                    System.out.println("Podaj współrzędne punktu2 x2 i y2: \n");
                    x2 = input.nextDouble();
                    y2 = input.nextDouble();
                    System.out.println("Podaj nazwę sekcji label: \n");
                    label = input.next();

                    if (p != null) {
                        if (p.add(new Section(new Point(x1, y1,label), new Point(x2, y2, label),label))){
                            System.out.println("Utworzono obiekt z powodzeniem");
                        } else System.out.println("Nie udało się utworzyć obiektu");
                    }
                }

                case "3" -> {
                    System.out.println("Podaj współrzędne środka x1 i y1: \n");
                    x1 = input.nextDouble();
                    y1 = input.nextDouble();
                    System.out.println("Podaj długość promienia: \n");
                    r = input.nextDouble();
                    System.out.println("Podaj nazwę okręgu label: \n");
                    label = input.next();

                    if (r < 0) {
                        throw new ArithmeticException("Wartość powinna być większa od zera");
                    }

                    if (p != null) {
                        if (p.add(new Circle(new Point(x1,y1,label),r,label))){
                            System.out.println("Utworzono obiekt z powodzeniem");
                        } else System.out.println("Nie udało się utworzyć obiektu");
                    }
                }

                case "4" -> {
                    System.out.println("Obrazek : \n");
                    System.out.println(p);
                }

                case "5" -> {
                    System.out.println("Przesunięcie obrazka o zadany wektor x i y: \n");
                    x1 = input.nextDouble();
                    y1 = input.nextDouble();
                    if (p != null) {
                        p.move(x1, y1);
                    }
                }

                case "6" -> {
                    System.out.println("Suma wszystkich pól wynosi: \n");
                    if (p != null) {
                        System.out.println(p.getArea());
                    }
                }
                case "w" -> System.exit(0);

                default -> System.out.println("Brak opcji " + option2);
            }
        }
    }
}
