package com.didi.entrega.home.component.city.entity;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import java.util.List;

public class HomeServiceCountryEntity implements IEntity {
    private static final long serialVersionUID = 26438691687821949L;
    public List<HomeServiceCityEntity> cities;
    public String countryCode;
    public String countryName;
}
