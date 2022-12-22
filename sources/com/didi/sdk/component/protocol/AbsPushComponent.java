package com.didi.sdk.component.protocol;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.log.Logger;
import com.didi.sdk.push.manager.DPushBody;
import com.didi.sdk.push.manager.DPushListener;
import com.didi.sdk.push.manager.DPushType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbsPushComponent implements IPushComponent {

    /* renamed from: a */
    private static final String f35657a = "AbsPushComponent";

    /* renamed from: b */
    private static ConcurrentHashMap<String, List<DPushListener>> f35658b = new ConcurrentHashMap<>();

    public void initPushConfig(Context context) {
    }

    public void startPush() {
    }

    public void stopPush() {
    }

    public void dispatcherPush(String str, DPushBody dPushBody, String str2) {
        List<DPushListener> list = f35658b.get(str);
        Logger.m25808d(f35657a, "dispatcherPush,pushKey = " + str + ",topic = " + str2 + ",content = " + dPushBody);
        if (list != null && list.size() != 0) {
            for (DPushListener dPushListener : list) {
                if (dPushListener.topic().equals(str2)) {
                    Logger.m25808d(f35657a, "dispatch to listener = " + dPushListener);
                    dPushListener.pushBody(dPushBody);
                }
            }
        }
    }

    public void dispatcherPush(String str, DPushBody dPushBody) {
        List<DPushListener> list = f35658b.get(str);
        Logger.m25808d(f35657a, "dispatcherPush,pushKey = " + str + ",dipatcher = " + list + ",content = " + dPushBody);
        if (list != null && list.size() != 0) {
            for (DPushListener pushBody : list) {
                pushBody.pushBody(dPushBody);
            }
        }
    }

    public boolean unregisterPush(DPushListener dPushListener) {
        String name = dPushListener.pushType().getName();
        Logger.m25808d(f35657a, "unregisterPush,listener = " + dPushListener + ",key = " + name);
        List list = f35658b.get(name);
        if (list == null || TextUtils.isEmpty(name)) {
            return false;
        }
        return list.remove(dPushListener);
    }

    public void registerPush(DPushListener dPushListener) {
        List list;
        DPushType pushType = dPushListener.pushType();
        Logger.m25808d(f35657a, "registerPush,listener = " + dPushListener + ",type = " + pushType);
        String name = pushType.getName();
        if (f35658b.get(name) != null) {
            list = f35658b.get(name);
        } else {
            ArrayList arrayList = new ArrayList();
            f35658b.put(name, arrayList);
            list = arrayList;
        }
        list.add(dPushListener);
    }
}
