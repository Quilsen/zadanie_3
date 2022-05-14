package com.company;

import java.io.*;
import java.util.Scanner;


public class Main {

    public static void main(String... args) {
        Matrix m1 = new Matrix(3,3);
        Matrix m2 = new Matrix(3,3);
        Matrix m3 = null;

        for(int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++){
                m1.set(i,j,1);
            }
        for(int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++){
                m2.set(i,j,2);
            }
        System.out.println(m1.toString());
        System.out.println(m2.toString());

        m3 = m1.mull(m2);

        for(Matrix row:m1.rows()){

        }



    }

        /*Picture picture = null;
        Scanner input = new Scanner(System.in);
        String option1 = "0", option2, label;
        double x1, y1, x2, y2, r;


        while (option1.equals("0")) {
            System.out.println("""
                    Wybór typu obrazka:
                    1 Picture
                    2 UniquePicture
                    3 StandarizedPicture
                    q Wyjście""");
            option1 = input.nextLine();
            switch (option1) {
                case "1" -> {
                    picture = new Picture();
                    System.out.println("Utworzono obiekt typu Picture\n");
                }

                case "2" -> {
                    picture = new UniquePicture();
                    System.out.println("Utworzono obiekt typu UniquePicture\n");
                }

                case "3" -> {
                    picture = new StandarizedPicture();
                    System.out.println("Utworzono obiekt typu StandarizedPicture\n");
                }

                case "q" -> System.exit(0);

                default -> System.out.println("Brak opcji: " + option1);
            }
        }

        while (true) {
            System.out.println("""
                    Menu
                    1 Dodaj punkt do obrazka.
                    2 Dodaj odcinek do obrazka.
                    3 Dodaj koło do obrazka.
                    4 Wyświetlanie obiektu obrazka.
                    5 Przesunięcie obrazka o wektor.
                    6 Suma wszystkich pól.
                    7 Sortowanie dodanych obiektów metodą toStringSortedByLabel() malejąco.
                    8 Sortowanie dodanych obiektów metodą toStringSortedByClassName() rosnąco.
                    9 Sortowanie dodanych obiektów metodą toStringSortedByDistanceFromOrigin() rosnąco.
                    10 Wykorzystanie metody fill().
                    11 Wykorzystanie metody scaleParameter().
                    12 Serializacja obiektu.
                    13 Deserializacja obiektu.
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
                    if (picture != null) {
                        if (picture.add(new Point(x1, y1, label))) {
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

                    if (picture != null) {
                        if (picture.add(new Section(new Point(x1, y1), new Point(x2, y2), label))) {
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

                    if (picture != null) {
                        if (picture.add(new Circle(new Point(x1, y1), r, label))) {
                            System.out.println("Utworzono obiekt z powodzeniem");
                        } else System.out.println("Nie udało się utworzyć obiektu");
                    }
                }

                case "4" -> {
                    System.out.println("Obrazek : \n");
                    System.out.println(picture);
                }

                case "5" -> {
                    System.out.println("Przesunięcie obrazka o zadany wektor x i y: \n");
                    x1 = input.nextDouble();
                    y1 = input.nextDouble();
                    if (picture != null) {
                        picture.move(x1, y1);
                    }
                }

                case "6" -> {
                    System.out.println("Suma wszystkich pól wynosi: \n");
                    if (picture != null) {
                        System.out.println(picture.getArea());
                    }
                }

                case "7" -> {
                    System.out.println("Sortowanie dodanych obiektów metodą toStringSortedByLabel malejąco:\n");
                    if (picture != null) {
                        System.out.println(picture.toStringSortedByLabel());
                    }
                }

                case "8" -> {
                    System.out.println("Sortowanie dodanych obiektów metodą toStringSortedByClassName rosnąco:\n");
                    if (picture != null) {
                        System.out.println(picture.toStringSortedByClassName());
                    }
                }

                case "9" -> {
                    System.out.println("Sortowanie dodanych obiektów metodą toStringSortedByDistanceFromOrigin rosnąco:\n");
                    if (picture != null) {
                        System.out.println(picture.toStringSortedByDistanceFromOrigin());
                    }
                }

                case "10" -> {
                    System.out.println("Podaj numer koloru, którym chcesz wypełnić pole obiektu:\n");
                    if (picture != null) {
                        picture.fillObjects(input.nextInt());
                    }
                }

                case "11" -> {
                    System.out.println("Podaj współczynnik skalujący:\n");
                    if (picture != null) {
                        picture.scaleObjects(input.nextDouble());
                    }
                }

                case "12" -> {
                    System.out.println("Serializacja obiektu do pliku object.bin");
                    try {
                        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("object.bin"));
                        outputStream.writeObject(picture);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                case "13" -> {
                    System.out.println("Deserializacja obiektu z pliku object.bin");
                    Picture deserializedPicture;
                    try {
                        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("object.bin"));
                        deserializedPicture = (Picture) inputStream.readObject();
                        System.out.println(deserializedPicture);
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }

                case "w" -> System.exit(0);

                default -> System.out.println("Brak opcji " + option2);
            }
        }
    }*/
}
