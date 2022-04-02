package com.company;

public class Point extends Element {
    private double x,y;

    public Point(){}

    public Point(double x, double y,String label){
        super(label);
        this.x = x;
        this.y = y;
    }

    public Point(Point p){
        super(p);
        this.x = p.x;
        this.y = p.y;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                getLabel() +
                ": x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public void move(double dx, double dy){
        x+=dx;
        y+=dy;
    }

    @Override
    public double getArea(){
        return 0;
    }

}
