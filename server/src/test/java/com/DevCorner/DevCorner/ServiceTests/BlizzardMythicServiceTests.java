package com.DevCorner.DevCorner.ServiceTests;

import com.DevCorner.DevCorner.BlizzardApiConfigurationImpl;
import com.DevCorner.DevCorner.models.BlizzardMythicAffix;
import com.DevCorner.DevCorner.models.BlizzardMythicAffixResponse;
import com.DevCorner.DevCorner.service.BlizzardMythicServiceImpl;
import com.DevCorner.DevCorner.service.HttpServiceImpl;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.when;

import static org.mockito.ArgumentMatchers.any;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
public class BlizzardMythicServiceTests {
    @Mock
    HttpServiceImpl httpService;
    @Autowired
    BlizzardApiConfigurationImpl blizzardApiConfiguration;
    private BlizzardMythicServiceImpl blizzardMythicService;
    Gson g = new Gson();
    List<BlizzardMythicAffix> mythicAffixList;
    BlizzardMythicAffixResponse blizzardMythicAffixResponse;
    @BeforeEach
    public void setUp() {
        mythicAffixList= Stream.of(new BlizzardMythicAffix(null, "Teeming", 1)).collect(Collectors.toList());
        blizzardMythicAffixResponse= new BlizzardMythicAffixResponse(null, mythicAffixList);

        blizzardMythicService = new BlizzardMythicServiceImpl(blizzardApiConfiguration, httpService);
    }
    @Test
    public void whenGetWeeklyMythicAffixesThenReturnList() {
        when(httpService.sendGet(any(String.class), any(List.class), any(String.class)))
                .thenReturn(g.toJson(blizzardMythicAffixResponse));
        List<BlizzardMythicAffix> mythicAffixes =  blizzardMythicService.getWeeklyMythicAffixes();
        Assert.assertTrue(mythicAffixes.size() > 0);
    }
}
