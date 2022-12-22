package com.didi.component.business.bizconfig.store;

import android.content.Context;
import android.text.TextUtils;
import com.didi.component.common.util.GLog;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.store.BaseStore;
import com.didi.sdk.store.DiskCache;
import com.didi.sdk.util.SingletonHolder;
import org.json.JSONObject;

public class BizConfigStore extends BaseStore {

    /* renamed from: a */
    private Context f11174a = DIDIApplication.getAppContext();

    /* renamed from: b */
    private final Logger f11175b = LoggerFactory.getLogger(getClass());

    private BizConfigStore() {
        super("business-BizConfigStore");
    }

    public static BizConfigStore getInstance() {
        return (BizConfigStore) SingletonHolder.getInstance(BizConfigStore.class);
    }

    public BizConfigModel getBizConfigModel(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            Object obj = get(str);
            if (obj instanceof BizConfigModel) {
                GLog.m7964d("get model in cache");
                return (BizConfigModel) obj;
            }
            DiskCache.DEntry load = load(this.f11174a, str);
            if (load instanceof DiskCache.DEntry) {
                DiskCache.DEntry dEntry = load;
                if (dEntry.data != null) {
                    GLog.m7964d("get model in disk");
                    try {
                        String str2 = new String(dEntry.data, "UTF-8");
                        GLog.m7964d("get model in disk cache:" + str2);
                        if (!TextUtils.isEmpty(str2)) {
                            BizConfigModel parseFromJSON = BizConfigModel.parseFromJSON(str, new JSONObject(str2));
                            if (parseFromJSON != null) {
                                put(str, parseFromJSON);
                            }
                            return parseFromJSON;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    public void saveBizConfigModel(String str, BizConfigModel bizConfigModel, JSONObject jSONObject) {
        if (str != null && !TextUtils.isEmpty(str)) {
            if (bizConfigModel != null) {
                this.f11175b.info("BizConfigStore save in cache ", new Object[0]);
                put(str, bizConfigModel);
            }
            if (jSONObject != null) {
                try {
                    DiskCache.DEntry dEntry = new DiskCache.DEntry();
                    dEntry.data = jSONObject.toString().getBytes("UTF-8");
                    save(this.f11174a, str, dEntry);
                    Logger logger = this.f11175b;
                    logger.info("BizConfigStore save in disk " + jSONObject, new Object[0]);
                } catch (Exception e) {
                    Logger logger2 = this.f11175b;
                    logger2.info("BizConfigStore save disk error :" + e, new Object[0]);
                }
            }
        }
    }
}
