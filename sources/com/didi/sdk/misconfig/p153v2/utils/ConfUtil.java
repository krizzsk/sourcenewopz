package com.didi.sdk.misconfig.p153v2.utils;

import com.didi.sdk.misconfig.event.CarInfoUpdateEvent;
import com.didi.sdk.misconfig.model.CarGrop;
import com.didi.sdk.misconfig.p153v2.model.PriConfGroupModel;
import com.didi.sdk.util.EventKeys;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.sdk.misconfig.v2.utils.ConfUtil */
public class ConfUtil {
    public static List<CarGrop> castToCarGrops(List<PriConfGroupModel> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (PriConfGroupModel castToCarGrop : list) {
                arrayList.add(castToCarGrop(castToCarGrop));
            }
        }
        return arrayList;
    }

    public static CarGrop castToCarGrop(PriConfGroupModel priConfGroupModel) {
        if (priConfGroupModel == null) {
            return null;
        }
        CarGrop carGrop = new CarGrop();
        carGrop.setGroupId(priConfGroupModel.getGroupId());
        carGrop.setGroupType(priConfGroupModel.getGroupType());
        carGrop.setLink(priConfGroupModel.getLink());
        carGrop.setLinkText(priConfGroupModel.getLinkText());
        carGrop.setGroupIcon(priConfGroupModel.getGroupIcon());
        carGrop.setGroupIconActived(priConfGroupModel.getGroupIconActived());
        carGrop.setName(priConfGroupModel.getName());
        carGrop.setNavTag(priConfGroupModel.getNavTag());
        carGrop.setSchema(priConfGroupModel.getSchema());
        carGrop.setA_T(priConfGroupModel.getA_T());
        return carGrop;
    }

    public static void dispatchCarInfoUpdate(int i, int i2) {
        dispatchCarInfoUpdate(i, i2, false);
    }

    public static void dispatchCarInfoUpdate(int i, int i2, boolean z) {
        CarInfoUpdateEvent carInfoUpdateEvent = new CarInfoUpdateEvent();
        carInfoUpdateEvent.seqId = i2;
        carInfoUpdateEvent.result = i;
        carInfoUpdateEvent.tag = EventKeys.MisConfig.CAR_INFO_UPDATE;
        carInfoUpdateEvent.versionChanged = z;
        EventBus.getDefault().post(carInfoUpdateEvent);
    }

    public static void dispatchLawFromUpdate(int i, int i2) {
        CarInfoUpdateEvent carInfoUpdateEvent = new CarInfoUpdateEvent();
        carInfoUpdateEvent.seqId = i2;
        carInfoUpdateEvent.result = i;
        carInfoUpdateEvent.tag = EventKeys.MisConfig.LAW_INFO_UPDATE;
        EventBus.getDefault().post(carInfoUpdateEvent);
    }

    public static void dispatchMisFromUpdate(int i, int i2, boolean z) {
        CarInfoUpdateEvent carInfoUpdateEvent = new CarInfoUpdateEvent();
        carInfoUpdateEvent.seqId = i2;
        carInfoUpdateEvent.result = i;
        carInfoUpdateEvent.tag = EventKeys.MisConfig.MIS_DATA_FROM_UPDATE;
        carInfoUpdateEvent.versionChanged = z;
        EventBus.getDefault().post(carInfoUpdateEvent);
    }
}
