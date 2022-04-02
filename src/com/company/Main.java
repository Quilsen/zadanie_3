package com.company;

import javax.management.StandardEmitterMBean;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args){
        UniquePicture uP = new UniquePicture();
        System.out.println(uP.add(new Point(1,1,"Punkt")));
        System.out.println(uP.add(new Point(1,1,"Punkt")));
        System.out.println(uP.add(new Circle(new Point(1,1,"srodek"),10,"kółko")));
        System.out.println(uP.add(new Circle(new Point(1,1,"srodek"),10,"kółko")));
        System.out.println("\n");
        StandarizedPicture sP = new StandarizedPicture();
        System.out.println(sP.add(new Point(1,1,"PunkTcik123")));
        System.out.println(sP.add(new Point(1,1,"P2UN3K4T5CIK123")));

    }
}
