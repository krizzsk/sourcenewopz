package com.didi.raven.cache;

import android.text.TextUtils;
import com.didi.raven.RavenDataManger;
import com.didi.raven.RavenHttpManger;
import com.didi.raven.config.RavenConstants;
import com.didi.raven.model.RavenPoolConfigModel;
import com.didi.raven.utils.RavenLogUtils;
import com.didi.raven.utils.RavenUtils;
import com.didi.sdk.logging.LoggerFactory;
import com.tencent.mmkv.MMKV;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class RavenRequestPool {

    /* renamed from: a */
    private static final String f33094a = "RavenRequestPool";

    /* renamed from: b */
    private static final int f33095b = RavenDataManger.getInstance().getPoolConfig().getPostMax();

    /* renamed from: c */
    private static final int f33096c = RavenDataManger.getInstance().getPoolConfig().getMax();

    /* renamed from: d */
    private static final int f33097d = RavenDataManger.getInstance().getPoolConfig().getCacheMax();

    /* renamed from: e */
    private final List<Map<String, Object>> f33098e = new CopyOnWriteArrayList();

    /* renamed from: f */
    private String f33099f = "";

    public void addParams(Map<String, Object> map) {
        if (map != null) {
            if (m23308b(RavenUtils.mapToJson(map))) {
                RavenLogUtils.m23331i("RAVEN", "data is bigger than max size");
                return;
            }
            this.f33098e.add(map);
            String listToJson = RavenUtils.listToJson(this.f33098e);
            if (m23306a(listToJson)) {
                RavenHttpManger.getInstance().trackPool(listToJson);
                clear();
                return;
            }
            RavenPoolConfigModel poolConfig = RavenDataManger.getInstance().getPoolConfig();
            if (poolConfig == null || poolConfig.getCount() <= 0 || getSize() % poolConfig.getCount() != 0) {
                storeData(RavenConstants.MMKV_ID, listToJson);
                return;
            }
            RavenHttpManger.getInstance().trackPool(listToJson);
            clear();
        }
    }

    public void clear() {
        this.f33098e.clear();
        m23307b();
    }

    public void clearError(String str) {
        try {
            RavenDataManger.getInstance().getMmkv().remove(str);
        } catch (Exception e) {
            RavenLogUtils.m23331i(RavenConstants.TAG, "error:" + e.getMessage());
        }
    }

    public void addInError(List<Map<String, Object>> list) {
        m23303a(list);
    }

    /* renamed from: a */
    private void m23303a(List<Map<String, Object>> list) {
        RavenLogUtils.m23331i(RavenConstants.TAG, "storeErrorPool");
        if (!m23305a(m23302a())) {
            try {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                if (!TextUtils.isEmpty(this.f33099f)) {
                    String loadData = loadData(this.f33099f);
                    arrayList.addAll(RavenUtils.stringToList(loadData));
                    i = 0 + loadData.getBytes().length;
                }
                for (Map next : list) {
                    String mapToJson = RavenUtils.mapToJson(next);
                    if (m23308b(mapToJson)) {
                        String str = "raven_id_error_" + System.currentTimeMillis() + "_" + new Random().nextInt();
                        RavenLogUtils.m23331i(RavenConstants.TAG, "key:" + str);
                        storeData(str, mapToJson);
                        this.f33099f = "";
                    } else {
                        arrayList.add(next);
                        i += mapToJson.getBytes().length;
                        if (m23304a(i)) {
                            String str2 = "raven_id_error_" + System.currentTimeMillis() + "_" + new Random().nextInt();
                            RavenLogUtils.m23331i(RavenConstants.TAG, "key:" + str2);
                            storeData(str2, mapToJson);
                            this.f33099f = "";
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    String str3 = "raven_id_error_" + System.currentTimeMillis() + "_" + new Random().nextInt();
                    RavenLogUtils.m23331i(RavenConstants.TAG, "key:" + str3);
                    storeData(str3, RavenUtils.listToJson(arrayList));
                }
            } catch (Exception e) {
                e.printStackTrace();
                LoggerFactory.getLogger(RavenConstants.TAG).error("storeErrorPool", (Throwable) e);
            }
        }
    }

    /* renamed from: a */
    private long m23302a() {
        return RavenDataManger.getInstance().getMmkv().totalSize();
    }

    /* renamed from: b */
    private void m23307b() {
        List<Map<String, Object>> list = this.f33098e;
        if (list == null || list.size() == 0) {
            storeData(RavenConstants.MMKV_ID, "");
        } else {
            storeData(RavenConstants.MMKV_ID, RavenUtils.listToJson(this.f33098e));
        }
    }

    public String loadRavenId() {
        return loadData("bid");
    }

    public void storeData(String str, Object obj) {
        try {
            MMKV mmkv = RavenDataManger.getInstance().getMmkv();
            if (obj instanceof String) {
                mmkv.encode(str, (String) obj);
            } else if (obj instanceof Integer) {
                mmkv.encode(str, ((Integer) obj).intValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
            LoggerFactory.getLogger(RavenConstants.TAG).error("storeData", (Throwable) e);
        }
    }

    public String getDataWithMMKV() {
        return loadData(RavenConstants.MMKV_ID);
    }

    public String loadData(String str) {
        try {
            RavenLogUtils.m23331i(f33094a, "loadData start");
            String string = RavenDataManger.getInstance().getMmkv().getString(str, "");
            RavenLogUtils.m23331i(f33094a, "loadData end");
            return string;
        } catch (Exception e) {
            e.printStackTrace();
            LoggerFactory.getLogger(RavenConstants.TAG).error("loadData", (Throwable) e);
            return "";
        }
    }

    public List<String> getMmkvKeys() {
        ArrayList arrayList = new ArrayList();
        String[] allKeys = RavenDataManger.getInstance().getMmkv().allKeys();
        if (!(allKeys == null || allKeys.length == 0)) {
            for (String str : allKeys) {
                if (!TextUtils.isEmpty(str) && str.startsWith(RavenConstants.MMKV_ID_ERROR)) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    public void removeKey(String str) {
        try {
            RavenDataManger.getInstance().getMmkv().removeValueForKey(str);
        } catch (Exception e) {
            e.printStackTrace();
            LoggerFactory.getLogger(RavenConstants.TAG).error("removeKey", (Throwable) e);
        }
    }

    public void clearAll() {
        try {
            MMKV mmkv = RavenDataManger.getInstance().getMmkv();
            mmkv.clearAll();
            mmkv.trim();
        } catch (Exception e) {
            e.printStackTrace();
            LoggerFactory.getLogger(RavenConstants.TAG).error("clearAll", (Throwable) e);
        }
    }

    public List<Map<String, Object>> getData() {
        return this.f33098e;
    }

    public int getSize() {
        return this.f33098e.size();
    }

    /* renamed from: a */
    private boolean m23306a(String str) {
        if (!TextUtils.isEmpty(str) && str.getBytes().length / 1024 >= f33096c) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private boolean m23308b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m23304a(str.getBytes().length);
    }

    /* renamed from: a */
    private boolean m23304a(int i) {
        return i / 1024 > f33095b;
    }

    /* renamed from: a */
    private boolean m23305a(long j) {
        return j / 1024 > ((long) f33097d);
    }
}
