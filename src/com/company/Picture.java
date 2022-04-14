package com.company;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.nio.file.attribute.FileAttribute;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Picture implements Serializable {
    private ArrayList<Element> elements = new ArrayList<>();

    public Picture(){}

    public void setElements(ArrayList<Element> elements) {
        this.elements = elements;
    }
    public ArrayList<Element> getElements() {
        return elements;
    }

    private String listToString(List<Element> list){
        StringBuilder sb = new StringBuilder();

        for(Element e:list){
            sb.append(e.toString()).append("\n");
        }
        return sb.toString();
    }

    public String toString(){
        return listToString(elements);
    }

    public boolean add(Element e){
        elements.add(e);
        return true;
    }

    public void move(double dx, double dy){
        for(Element e:elements){
            e.move(dx,dy);
        }
    }

    public double getArea(){
        double totalArea = 0;
        for(Element e:elements){
            totalArea += e.getArea();
        }
        return totalArea;
    }

    public String toStringSortedByLabel(){
        ArrayList<Element> copy = new ArrayList<>(elements);
        copy.sort(new LabelComparator());
        return listToString(copy);
    }

    public String toStringSortedByClassName(){
        ArrayList<Element> copy = new ArrayList<>(elements);
        copy.sort(new ClassNameComparator());
        return listToString(copy);
    }

    public String toStringSortedByDistanceFromOrigin(){
        ArrayList<Element> copy = new ArrayList<>(elements);
        copy.sort(new DistanceFromOriginComparator());
        return listToString(copy);
    }

    public void fillObjects(int color){
        for(Element e:elements){
            if (e instanceof Fillable f){
                f.fill(color);
            }
        }
    }

    public void scaleObjects(double k){
        for (Element e:elements){
            if (e instanceof Scalable s){
                s.scaleParameter(k);
            }
        }
    }
}
