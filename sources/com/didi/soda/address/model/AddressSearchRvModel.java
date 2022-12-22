package com.didi.soda.address.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import java.util.ArrayList;
import java.util.List;

public class AddressSearchRvModel implements RecyclerModel {
    public boolean isLast;
    public AddressEntity mAddress;

    public static List<AddressSearchRvModel> convertFromSearchPoiEntity(List<AddressEntity.PoiEntity> list) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            AddressSearchRvModel addressSearchRvModel = new AddressSearchRvModel();
            AddressEntity addressEntity = new AddressEntity();
            addressEntity.poi = list.get(i);
            addressSearchRvModel.mAddress = addressEntity;
            boolean z = true;
            if (i != list.size() - 1) {
                z = false;
            }
            addressSearchRvModel.isLast = z;
            arrayList.add(addressSearchRvModel);
        }
        return arrayList;
    }
}
