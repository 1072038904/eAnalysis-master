package com.service;

import com.domain.Location;

import java.util.ArrayList;
import java.util.Map;

public interface PointService {
    public ArrayList<Location> getPoint(String video);
    public Map countX(String videoid);
    public Map countY(String videoid);
}
