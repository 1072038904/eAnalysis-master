package com.service.impl;

import com.dao.PointDao;
import com.dao.imple.PointDaoImple;
import com.domain.Location;
import com.service.PointService;

import java.util.ArrayList;
import java.util.Map;

public class PointServiceImple implements PointService {
    private PointDao pd;
    public PointServiceImple(){
        pd = new PointDaoImple();
    }
    public ArrayList<Location> getPoint(String videoid){
        return pd.getPoint(videoid);
    }
    public ArrayList<Location> getCount(String videoid){
        return pd.getPoint(videoid);
    }
    public Map countX(String videoid){
        return pd.countY(videoid);
    }
    public Map countY(String videoid){
        return pd.countY(videoid);
    }

    public static void main(String[] args) {
        PointService ad = new PointServiceImple();
        ArrayList <Location>d = ad.getPoint("helloworld");
        System.out.println(d.get(0).getX());
    }
}

