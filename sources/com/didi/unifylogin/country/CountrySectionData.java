package com.didi.unifylogin.country;

import com.didi.unifylogin.base.net.pojo.response.CountryListResponse;
import java.util.ArrayList;
import java.util.List;

public class CountrySectionData {
    public List<CountryListResponse.CountryRule> countryRules = new ArrayList();
    public String letter;

    public String toString() {
        return "CountrySectionData{countryRules=" + this.countryRules + ", letter=" + this.letter + '}';
    }
}
