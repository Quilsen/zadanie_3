package com.company;

import java.util.Comparator;

public class ClassNameComparator implements Comparator<Element> {

    @Override
    public int compare(Element o1, Element o2) {
        return o1.getClass().getSimpleName().compareToIgnoreCase(o2.getClass().getSimpleName());
    }
}
