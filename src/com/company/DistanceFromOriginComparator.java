package com.company;

import java.util.Comparator;

public class DistanceFromOriginComparator implements Comparator<Element> {

    @Override
    public int compare(Element o1, Element o2) {
        return Double.compare(o1.getDistanceFromOrigin(),o2.getDistanceFromOrigin());
    }
}
