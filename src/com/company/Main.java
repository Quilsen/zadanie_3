package com.company;

import com.sun.source.tree.WhileLoopTree;

import java.io.*;
import java.util.Scanner;


public class Main {

    public static void main(String... args) {
        Scanner input = new Scanner(System.in);
        String option;
        Matrix a = null, b = null;
        while(true){
            System.out.println("""
                    Menu
                    1. Wczytanie macierzy A
                    2. Wczytanie macierzy B
                    3. Wyświetlenie A + B
                    4. Wyświetlenie A * B
                    5. Wyjście
                    """);
            option = input.next();
            switch (option){
                case "1":
                    if (a != null){
                        System.out.println("Macierz została już utworzona");
                        break;
                    }
                    else{
                        System.out.println("Podaj ilość wierszy i kolumn");
                        int rows = input.nextInt();
                        int cols = input.nextInt();
                        double val = 0;
                        if (rows >= 0 && cols >=0){
                            a = new Matrix(rows,cols);
                        }
                        else{
                            System.out.println("Podane liczby muszą być dodatnie");
                            break;
                        }
                        System.out.println("Podaj kolejno wartości do wpisania");
                        for (int i = 0; i < rows; i++) {
                            for (int j = 0; j < cols; j++) {
                                System.out.println("Podaj wartość dla pozycji: "+ i + " " + j);
                                val = input.nextInt();
                                a.set(i,j,val);
                            }
                        }
                        System.out.println(a);
                        break;
                    }

                case "2":
                    if (b != null){
                        System.out.println("Macierz została już utworzona");
                        break;
                    }
                    else{
                        System.out.println("Podaj ilość wierszy i kolumn");
                        int rows = input.nextInt();
                        int cols = input.nextInt();
                        double val = 0;
                        if (rows >= 0 && cols >=0){
                            b = new Matrix(rows,cols);
                        }
                        else{
                            System.out.println("Podane liczby muszą być dodatnie");
                            break;
                        }

                        System.out.println("Podaj kolejno wartości do wpisania");
                        for (int i = 0; i < rows; i++) {
                            for (int j = 0; j < cols; j++) {
                                System.out.println("Podaj wartość dla pozycji: "+ i + " " + j);
                                val = input.nextInt();
                                b.set(i,j,val);
                            }
                        }
                        System.out.println(b);
                        break;
                    }
                case "3":
                    Matrix addResult = new Matrix();

                    try{
                        addResult = a.add(b);
                        System.out.println("Jako sekwencja liczb:");
                        for (double elem:addResult){
                            System.out.println(elem);
                        }
                        System.out.println("Jako wiersze:");
                        for (Matrix rows:addResult.rows()) {
                            System.out.println(rows.toString());
                        }
                    }
                    catch (MatrixOperationException e){
                        System.out.println("Macierze nie są tych samych rozmiarów");
                    }
                    catch (NullPointerException e){
                        System.out.println(e);
                    }
                    break;

                case "4":
                    Matrix mullResult = new Matrix();

                    try{
                        mullResult = a.mull(b);
                        System.out.println("Jako sekwencja liczb");
                        for (double elem:mullResult){
                            System.out.println(elem);
                        }
                        System.out.println("Jako wiersze:");
                        for (Matrix rows:mullResult.rows()) {
                            System.out.println(rows.toString());
                        }
                    }
                    catch (MatrixOperationException e){
                        System.out.println("Macierze nie są tych samych rozmiarów:");
                    }
                    catch (NullPointerException e){
                        System.out.println(e);
                    }
                    break;

                case "5":
                    System.exit(0);

                default:
                    System.out.println("Brak opcji " + option);
                    break;
            }
        }
    }
}
