package com.example.test.bean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Grades {
    private int id;
    private Double higher;
    private Double linear;
    private Double discrete;
    private Double physics;
    private Double javaPoints;
    private Double cpp;

    public Grades(int id, Double higher, Double linear, Double discrete, Double physics,
                  Double javaPoints, Double cpp) {
        this.id = id;
        this.higher = higher;
        this.linear = linear;
        this.discrete = discrete;
        this.physics = physics;
        this.javaPoints = javaPoints;
        this.cpp = cpp;
    }
    public double getGpa(){
        int n = 6;
        double sum = 0;
        List<Double> grs = new ArrayList<>();
        grs.add(higher);
        grs.add(linear);
        grs.add(discrete);
        grs.add(physics);
        grs.add(javaPoints);
        grs.add(cpp);
        for(int i=0;i< grs.size();i++){
            if(grs.get(i) == null || grs.get(i) == 0)
                n--;
            else
                sum += grs.get(i);
        }
//        if(higher == null || higher == 0) n--;
//        if(linear == null || linear == 0) n--;
//        if(discrete == null || discrete == 0) n--;
//        if(physics == null || physics == 0) n--;
//        if(javaPoints == null || javaPoints == 0) n--;
//        if(cpp == null || cpp == 0) n--;
        double ans = (sum-n*50)/(n*10);
        if(ans<0) ans = 0;
        return ans;
    }
}
