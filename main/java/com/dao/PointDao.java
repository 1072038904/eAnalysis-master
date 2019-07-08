package com.dao;

import com.domain.Location;

import java.util.ArrayList;
import java.util.Map;

public interface PointDao {
    public ArrayList<Location> getPoint(String videoid);
    public Map countX(String videoid);
    public Map countY(String videoid);
}
