package com.company;

public class Section {
    private Point p1, p2;

    public Section(){}

    public Section(Point p1, Point p2) {
        this.p1 = new Point(p1);
        this.p2 = new Point(p2);
    }

    public Section(Section s){
        this.p1 = new Point(s.p1);
        this.p2 = new Point(s.p2);
    }

    public Point getP1() {
        return p1;
    }
    public Point getP2() {
        return p2;
    }
    public void setP1(Point p1) {
        this.p1 = p1;
    }
    public void setP2(Point p2) {
        this.p2 = p2;
    }

    @Override
    public String toString() {
        return "Section{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }

    public void move(double dx, double dy){
        p1.move(dx,dy);
        p2.move(dx,dy);
    }

    public double getArea(){
        return 0;
    }

}
