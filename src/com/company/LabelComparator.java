package com.company;

import java.util.Comparator;

public class LabelComparator implements Comparator<Element> {

   @Override
   public int compare(Element o1, Element o2){
       return o1.getLabel().compareToIgnoreCase(o2.getLabel());
   }
}
