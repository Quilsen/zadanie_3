package com.company;

import java.nio.file.attribute.FileAttribute;
import java.time.temporal.ValueRange;

public class Circle extends Element implements Fillable, Scalable {
    private Point o;
    private double r;
    private int color;

    public Circle(){}

    public Circle(Point o, double r){
        this.o = o;
        this.r = Math.abs(r);
    }

    public Circle(Point o, double r, String label){
        super(label);
        this.o = o;
        this.r = Math.abs(r);
    }
    public Circle(Point o, double r, String label,int color){
        super(label);
        this.o = o;
        this.r = Math.abs(r);
        this.color = color;
    }

    public Circle(Circle c){
        super(c);
        this.o = new Point(c.o);
        this.r = c.getR();
        this.color = c.color;
    }

    public Point getO() {
        return o;
    }
    public double getR() {
        return r;
    }
    public int getColor() {
        return color;
    }
    public void setColor(int color) {
        this.color = color;
    }
    public void setO(Point o) {
        this.o = o;
    }
    public void setR(double r) throws IllegalArgumentException {
        if (r >= 0){
            this.r = r;
        } else {
            throw new IllegalArgumentException("Value should be greater than zero");
        }
    }

    @Override
    public String toString() {
        return "Circle{" +
                getLabel()+
                ": o=" + o +
                ", r=" + r +
                '}';
    }

    @Override
    public void move(double dx, double dy){
        o.move(dx,dy);
    }
    @Override
    public double getArea(){
        return Math.PI*Math.pow(r,2);
    }

    @Override
    public void fill(int color) {
        this.color = color;
    }

    public double getDistanceFromOrigin() {
        return Math.sqrt(Math.pow(o.getX(),2) + Math.pow(o.getY(),2));
    }

    @Override
    public void scaleParameter(double k) throws IllegalArgumentException {
        if (k >= 0){
            setR(getR()*k);
        } else {
            throw new IllegalArgumentException("Value should be greater than zero");
        }
    }


}
