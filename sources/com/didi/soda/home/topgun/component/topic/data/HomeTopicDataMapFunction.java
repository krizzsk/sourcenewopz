package com.didi.soda.home.topgun.component.topic.data;

import android.text.TextUtils;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity;
import com.didi.soda.datasource.listener.DataMapFunction;
import com.didi.soda.datasource.listener.PayloadProvider;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import java.util.ArrayList;
import java.util.List;

public class HomeTopicDataMapFunction implements DataMapFunction<ComponentEntity, RecyclerModel> {
    public static final String FEED_BUSINESS = "3000";

    /* renamed from: a */
    private PayloadProvider<FeedPayload> f42884a;

    /* renamed from: b */
    private int f42885b;

    public HomeTopicDataMapFunction(PayloadProvider payloadProvider) {
        this.f42884a = payloadProvider;
    }

    public List<RecyclerModel> mapData(int i, List<ComponentEntity> list) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        List<String> receivedDataTypeList = receivedDataTypeList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            ComponentEntity componentEntity = list.get(i2);
            if (componentEntity != null && receivedDataTypeList.contains(componentEntity.mType)) {
                FeedPayload providePayload = this.f42884a.providePayload();
                providePayload.mPageIndex = i;
                if (providePayload != null) {
                    m30349a(providePayload, i2);
                }
                if (componentEntity.mComponentV2 == null || TextUtils.isEmpty(componentEntity.mComponentV2.getTmplId())) {
                    obj = HomeBusinessInfoRvModel.convertBusinessInfoEntity(componentEntity, providePayload);
                } else {
                    obj = HomeBusinessInfoRvModel.convertRvEntity(componentEntity, providePayload);
                }
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public List<String> receivedDataTypeList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("3000");
        return arrayList;
    }

    /* renamed from: a */
    private void m30349a(FeedPayload feedPayload, int i) {
        if (feedPayload.mPageIndex == 0) {
            this.f42885b = i;
        } else {
            this.f42885b++;
        }
        feedPayload.mComponentIndex = this.f42885b;
    }
}
