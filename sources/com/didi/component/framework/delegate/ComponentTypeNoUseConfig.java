package com.didi.component.framework.delegate;

import com.didi.component.common.base.ComponentType;
import com.didi.component.config.IComponentTypeNoUseConfigService;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.ArrayList;

@ServiceProvider({IComponentTypeNoUseConfigService.class})
public class ComponentTypeNoUseConfig implements IComponentTypeNoUseConfigService {
    public ArrayList<String> getCompListNoUseConfig() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(ComponentType.FLEX_LIST);
        arrayList.add(ComponentType.FLEX_OPTION);
        arrayList.add(ComponentType.OFFER_FLEX_PRICE);
        arrayList.add(ComponentType.FLEX_AUTOMATIC_MATCH_CARD);
        arrayList.add(ComponentType.ANYCAR_LIST);
        arrayList.add(ComponentType.ANYCAR_GROUP_FORM_CONTAINER);
        arrayList.add(ComponentType.ANYCAR_FORM_COMMON_ITEM);
        arrayList.add(ComponentType.ANYCAR_PAYWAY);
        arrayList.add(ComponentType.PAGE_DATA);
        arrayList.add(ComponentType.HOME_PANEL);
        arrayList.add(ComponentType.HOME_ADDRESS_CARD);
        return arrayList;
    }
}
