package com.company;

import javax.management.StandardEmitterMBean;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args){
        UniquePicture uP = new UniquePicture();
        System.out.println(uP.add(new Point(1,1,"Punkt")));
        System.out.println(uP.add(new Point(1,1,"Punkt")));

    }
}
