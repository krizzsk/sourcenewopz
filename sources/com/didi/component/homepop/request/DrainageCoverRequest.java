package com.didi.component.homepop.request;

import android.content.Context;
import com.didi.component.common.model.DrainageModel;
import com.didi.component.common.net.CarRequest;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.drainage.DrainageData;
import com.didi.travel.psnger.common.net.base.ResponseListener;

public class DrainageCoverRequest implements HomePopupRequest {
    public void cancelGroup() {
    }

    public void closeWindow() {
    }

    public void requestByService(Context context, String str) {
        CarRequest.fetchDrainage(context, str, new ResponseListener<DrainageModel>() {
            public void onSuccess(DrainageModel drainageModel) {
                super.onSuccess(drainageModel);
                if (drainageModel != null && drainageModel.getShow() == 1) {
                    DrainageData drainageData = new DrainageData();
                    drainageData.setImage(drainageModel.getImage());
                    drainageData.setContent_id(drainageModel.getContentId());
                    drainageData.setBusiness_type(drainageModel.getBusiness_type());
                    drainageData.setPoint_action(drainageModel.getPoint_action());
                    drainageData.setTips_action(drainageModel.getTips_action());
                    drainageData.setTips(drainageModel.getTips());
                    drainageData.setLogDataMap(drainageModel.getLogDataMap());
                    BaseEventPublisher.getPublisher().publish("event_drainage_guide", drainageData);
                }
            }

            public void onError(DrainageModel drainageModel) {
                super.onError(drainageModel);
            }
        });
    }
}
