package com.company;

import java.util.ArrayList;
import java.util.List;

public class Picture {
    private List<Section> sections = new ArrayList<>();
    private List<Point> points = new ArrayList<>();
    private List<Circle> circles = new ArrayList<>();

    public Picture() {}

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

    public double getArea() {
        double totalArea = 0;
        for(int i = 0; i < points.size(); i++) {
            totalArea += points.get(i).getArea();
        }
        for(int i = 0; i < sections.size(); i++) {
            totalArea += sections.get(i).getArea();
        }
        for(int i = 0; i<circles.size(); i++){
            totalArea += circles.get(i).getArea();
        }
        return totalArea;
    }

}
