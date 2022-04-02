package com.company;

import java.util.ArrayList;

public class Picture {
    private ArrayList<Element> elements = new ArrayList<>();

    public Picture(){}

    public void setElements(ArrayList<Element> elements) {
        this.elements = elements;
    }
    public ArrayList<Element> getElements() {
        return elements;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        for(Element e:elements){
            sb.append(e.toString()).append("\n");
        }
        return sb.toString();
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
}
