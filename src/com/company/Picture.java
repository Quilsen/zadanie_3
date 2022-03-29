package com.company;

import java.util.ArrayList;
import java.util.List;

public class Picture {
    private List<Section> sections = new ArrayList<>();
    private List<Point> points = new ArrayList<>();
    private List<Circle> circles = new ArrayList<>();

    public Picture() {}

    public List<Section> getSections() {
        return sections;
    }
    public List<Point> getPoints() {
        return points;
    }
    public List<Circle> getCircles() {
        return circles;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
    public void setPoints(List<Point> points) {
        this.points = points;
    }
    public void setCircles(List<Circle> circles) {
        this.circles = circles;
    }

    public void add(Point p){
        points.add(p);
    }

    public void add(Section s){
        sections.add(s);
    }

    public void add(Circle c){
        circles.add(c);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("points\n");
        for(int i = 0; i<points.size(); ++i){
            sb.append(i+1).append(": ").append(points.get(i)).append("\n");
        }
        sb.append("circles\n");
        for(int i = 0; i<circles.size(); ++i){
            sb.append(i+1).append(": ").append(circles.get(i)).append("\n");
        }
        sb.append("sections\n");
        for(int i = 0; i<sections.size(); ++i){
            sb.append(i+1).append(": ").append(sections.get(i)).append("\n");
        }
        return sb.toString();
    }

    public void movePicture(double dx, double dy){
        for (Point point : points) {
            point.move(dx, dy);
        }
        for (Section section : sections) {
            section.move(dx, dy);
        }
        for (Circle circle : circles) {
            circle.move(dx, dy);
        }
    }

    public double getArea() {
        double totalArea = 0;
        for (Point point : points) {
            totalArea += point.getArea();
        }
        for (Section section : sections) {
            totalArea += section.getArea();
        }
        for (Circle circle : circles) {
            totalArea += circle.getArea();
        }
        return totalArea;
    }

}
