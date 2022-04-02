package com.company;

public class Circle extends Element{
    private Point o;
    private double r;

    public Circle(){}

    public Circle(Point o, double r, String label){
        super(label);
        this.o = o;
        this.r = Math.abs(r);
    }

    public Circle(Circle c){
        super(c);
        this.o = new Point(c.o);
        this.r = c.getR();
    }

    public Point getO() {
        return o;
    }
    public double getR() {
        return r;
    }
    public void setO(Point o) {
        this.o = o;
    }
    public void setR(double r) {
        this.r = r;
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
}
