package com.util;

import org.apache.xalan.templates.ElemValueOf;

import java.util.HashMap;
import java.util.Map;

public  class Value {
    private Map mapx= new HashMap();
    private Map mapy = new HashMap();

    public  Float getValue(Value value,Integer x,Integer y){
       Map xs = value.getMapx();
       Map ys = value.getMapy();
       Float a = (Float) xs.get(x);
        Float b = (Float) ys.get(y);
       return a+b;
    }

    public Value(Map mapx, Map mapy) {
        this.mapx = mapx;
        this.mapy = mapy;
    }

    public Map getMapx() {
        return mapx;
    }

    public void setMapx(Map mapx) {
        this.mapx = mapx;
    }

    public Map getMapy() {
        return mapy;
    }

    public void setMapy(Map mapy) {
        this.mapy = mapy;
    }
}
