package com.DevCorner.DevCorner.ServiceTests;


import com.DevCorner.DevCorner.service.BlizzardMythicService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;

@SpringBootTest
public class BlizzardMythicServiceTests {
    @Autowired
    BlizzardMythicService blizzardMythicService;

    @Test
    public void whenGetWeeklyMythicAffixesThenReturnList() {
        ArrayList<String> mythicAffixes =  blizzardMythicService.getWeeklyMythicAffixes();

        Assert.isTrue(mythicAffixes.size() > 1);
    }
}
