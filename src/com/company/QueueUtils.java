package com.company;

import java.io.ObjectInputStream;
import java.lang.reflect.Type;
import java.util.ServiceConfigurationError;

public class QueueUtils{

    public static <T> void printAndClear(MyQueue<T> q){
        System.out.println(q.get());
    }

    public static void printFiguresAndClear(MyQueue<? extends Element> q){
        System.out.println(q.get().getLabel());
    }

    public static <T> void move(MyQueue<? extends T> source,MyQueue<? super T> dest){
        dest.add(source.get());
    }
}

