package com.DevCorner.DevCorner.service;

import com.DevCorner.DevCorner.BlizzardApiConfigurationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

public class BlizzardMythicServiceImpl implements BlizzardMythicService {

    @Autowired
    BlizzardApiConfigurationImpl blizzardApiConfiguration;


    public ArrayList<String> getWeeklyMythicAffixes() {
        throw new NotImplementedException();
    }

}
