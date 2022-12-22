package com.didi.dimina.container.secondparty.citydata;

import com.didi.dimina.container.service.CityDataService;

public class DiminaCityDataService implements CityDataService {
    public String getCityData() {
        return CityDataManager.getCityData();
    }
}
