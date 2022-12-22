package com.didi.raven;

import android.text.TextUtils;
import com.didi.raven.cache.RavenCache;
import com.didi.raven.cache.RavenData;
import com.didi.raven.cache.RavenRequestPool;
import com.didi.raven.config.RavenConstants;
import com.didi.raven.manger.RavenThreadExecutorManger;
import com.didi.raven.model.RavenPoolConfigModel;
import com.didi.raven.utils.RavenLogUtils;
import com.didi.raven.utils.RavenUtils;
import com.tencent.mmkv.MMKV;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

public class RavenDataManger {

    /* renamed from: a */
    private MMKV f33084a;

    /* renamed from: b */
    private final Map<String, RavenData> f33085b = new ConcurrentHashMap();

    /* renamed from: c */
    private RavenPoolConfigModel f33086c = new RavenPoolConfigModel();

    /* renamed from: d */
    private RavenRequestPool f33087d;

    private static class SingleTon {
        /* access modifiers changed from: private */
        public static final RavenDataManger INSTANCE = new RavenDataManger();

        private SingleTon() {
        }
    }

    public static RavenDataManger getInstance() {
        return SingleTon.INSTANCE;
    }

    public void init() {
        this.f33087d = new RavenRequestPool();
        m23276a();
        RavenCache.RAVEN_ID = this.f33087d.loadRavenId();
    }

    /* renamed from: a */
    private void m23276a() {
        this.f33084a = MMKV.mmkvWithID(RavenConstants.MMKV_ID, 1, RavenConstants.CRYPT_KEY);
    }

    public RavenPoolConfigModel getPoolConfig() {
        return this.f33086c;
    }

    public MMKV getMmkv() {
        return this.f33084a;
    }

    public RavenData getRavenData(String str) {
        RavenData ravenData = this.f33085b.get(str);
        if (ravenData != null) {
            return ravenData;
        }
        RavenData ravenData2 = new RavenData();
        this.f33085b.put(str, ravenData2);
        return ravenData2;
    }

    public synchronized void addParams(Map<String, Object> map) {
        String str = (String) map.get("aid");
        if (!TextUtils.isEmpty(str)) {
            map.put("si", Integer.valueOf(getInstance().getRavenData(str).getIndex()));
            m23283d().execute(new Runnable(map) {
                public final /* synthetic */ Map f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    RavenDataManger.this.m23279a(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23279a(Map map) {
        this.f33087d.addParams(map);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23278a(List list) {
        this.f33087d.addInError(list);
    }

    public void addParams(List<Map<String, Object>> list) {
        m23283d().execute(new Runnable(list) {
            public final /* synthetic */ List f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                RavenDataManger.this.m23278a(this.f$1);
            }
        });
    }

    public void addParams(String str) {
        m23283d().execute(new Runnable(str) {
            public final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                RavenDataManger.this.m23281b(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m23281b(String str) {
        List<Map<String, Object>> stringToList = RavenUtils.stringToList(str);
        if (stringToList != null && stringToList.size() > 0) {
            this.f33087d.addInError(stringToList);
        }
    }

    public List<Map<String, Object>> getParams() {
        return this.f33087d.getData();
    }

    public synchronized void clearPool() {
        this.f33087d.clear();
    }

    /* renamed from: a */
    private synchronized void m23277a(String str) {
        this.f33087d.clearError(str);
    }

    public int getPoolSize() {
        return this.f33087d.getSize();
    }

    public void uploadLastData() {
        try {
            m23280b();
            m23282c();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m23280b() {
        try {
            String dataWithMMKV = this.f33087d.getDataWithMMKV();
            RavenLogUtils.m23331i(RavenConstants.TAG, "uploadDataWithMMKV data:" + dataWithMMKV);
            if (!TextUtils.isEmpty(dataWithMMKV)) {
                RavenHttpManger.getInstance().trackPool(dataWithMMKV);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    private void m23282c() {
        for (String next : this.f33087d.getMmkvKeys()) {
            RavenLogUtils.m23331i(RavenConstants.TAG, "error_key:" + next);
            String loadData = this.f33087d.loadData(next);
            if (!TextUtils.isEmpty(loadData)) {
                RavenHttpManger.getInstance().trackPool(loadData);
            }
            this.f33087d.removeKey(next);
        }
        this.f33087d.clearAll();
    }

    /* renamed from: d */
    private ExecutorService m23283d() {
        return RavenThreadExecutorManger.getInstance().getEventExecutor();
    }

    public void storeRavenId(String str) {
        this.f33087d.storeData("bid", str);
        RavenCache.RAVEN_ID = str;
    }

    public String loadRavenId() {
        return this.f33087d.loadData("bid");
    }
}
