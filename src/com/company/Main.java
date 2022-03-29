package com.company;

public class Main {

    public static void main(String[] args) {
        Picture picture = new Picture();
        picture.add(new Point(1,2));
        picture.add(new Section(new Point(0,0),new Point(2,2)));

    }
}
