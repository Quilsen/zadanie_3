package com.company;

import java.io.Serializable;

abstract class Element implements Serializable {
    private String label = "Empty";

    public Element(){}

    public Element(String label){
        this.label = label;
    }

    public Element(Element e){
        this.label = e.label;
    }

    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }

    public abstract String toString();
    public abstract void move(double dx,double dy);
    public abstract double getArea();
    public abstract double getDistanceFromOrigin();

}
