package com.didi.component.business.model;

import com.sdk.poibase.model.RpcPoi;
import java.util.ArrayList;

public class PudoPickUpPointsModel {

    /* renamed from: a */
    private ArrayList<RpcPoi> f11323a;

    public PudoPickUpPointsModel(ArrayList<RpcPoi> arrayList) {
        this.f11323a = arrayList;
    }

    public ArrayList<RpcPoi> getPickUpPoints() {
        return this.f11323a;
    }
}
