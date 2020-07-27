package com.DevCorner.DevCorner.models;

import java.util.List;

public class BlizzardMythicAffixResponse {
    public BlizzardLinksObject _links;
    public List<BlizzardMythicAffix> affixes;

    public BlizzardMythicAffixResponse(BlizzardLinksObject _links, List<BlizzardMythicAffix> affixes){
        this._links = _links;
        this.affixes = affixes;
    }
}

