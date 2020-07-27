package com.DevCorner.DevCorner.service;

import com.DevCorner.DevCorner.BlizzardApiConfigurationImpl;
import com.DevCorner.DevCorner.configs.ApiConfiguration;
import com.DevCorner.DevCorner.models.BlizzardMythicAffix;
import com.DevCorner.DevCorner.models.BlizzardMythicAffixResponse;
import com.google.gson.Gson;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlizzardMythicServiceImpl implements BlizzardMythicService {
    HttpServiceImpl httpServiceImpl;
    BlizzardApiConfigurationImpl blizzardApiConfiguration;
    private String baseBlizzardApiUrl;
    private String blizzardAffixesApiUrl;
    private Gson g = new Gson();

    @Autowired
    public BlizzardMythicServiceImpl(
            BlizzardApiConfigurationImpl _blizzardApiConfiguration,
            HttpServiceImpl _httpServiceImpl) {

        httpServiceImpl = _httpServiceImpl;
        blizzardApiConfiguration = _blizzardApiConfiguration;
        baseBlizzardApiUrl = blizzardApiConfiguration.GetBaseApiUrl();
        blizzardAffixesApiUrl = baseBlizzardApiUrl + "keystone-affix/index";
    }

    public List<BlizzardMythicAffix> getWeeklyMythicAffixes() {
        String bearerToken = blizzardApiConfiguration.GetApiToken();

        List<NameValuePair> params = new ArrayList<>(2);
        params.add(new BasicNameValuePair("namespace", "static-us"));
        params.add(new BasicNameValuePair("locale", "en_US"));

        BlizzardMythicAffixResponse mythicAffixResponse = g.fromJson(httpServiceImpl.sendGet(blizzardAffixesApiUrl,
                params, bearerToken), BlizzardMythicAffixResponse.class);
        return mythicAffixResponse.affixes;
    }

}
