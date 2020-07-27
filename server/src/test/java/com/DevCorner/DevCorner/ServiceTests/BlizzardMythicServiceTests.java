package com.DevCorner.DevCorner.ServiceTests;


import com.DevCorner.DevCorner.models.BlizzardMythicAffix;
import com.DevCorner.DevCorner.service.BlizzardMythicService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BlizzardMythicServiceTests {
    @Autowired
    BlizzardMythicService blizzardMythicServiceImpl;

    @Test
    public void whenGetWeeklyMythicAffixesThenReturnList() {
        List<BlizzardMythicAffix> mythicAffixes =  blizzardMythicServiceImpl.getWeeklyMythicAffixes();
        Assert.assertTrue(mythicAffixes.size() > 1);
    }
}
