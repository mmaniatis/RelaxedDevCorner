package com.DevCorner.DevCorner.service;

import com.DevCorner.DevCorner.BlizzardApiConfigurationImpl;
import com.DevCorner.DevCorner.models.BlizzardMythicAffix;
import com.DevCorner.DevCorner.models.BlizzardMythicAffixResponse;
import com.google.gson.Gson;
import com.sun.org.glassfish.gmbal.NameValue;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class BlizzardMythicServiceImpl implements BlizzardMythicService {

    @Autowired
    BlizzardApiConfigurationImpl blizzardApiConfiguration;

    @Autowired
    HttpService httpServiceImpl;

    private Gson g = new Gson();

    public List<BlizzardMythicAffix> getWeeklyMythicAffixes() {
        String bearerToken = blizzardApiConfiguration.GetBlizzardApiToken();

        List<NameValuePair> params = new ArrayList<>(2);
        params.add(new BasicNameValuePair("namespace", "static-us"));
        params.add(new BasicNameValuePair("locale", "en_US"));
        BlizzardMythicAffixResponse mythicAffixResponse = g.fromJson(httpServiceImpl.sendGet("https://us.api.blizzard.com/data/wow/keystone-affix/index",
                params, bearerToken), BlizzardMythicAffixResponse.class);
        return mythicAffixResponse.affixes;
    }

}
