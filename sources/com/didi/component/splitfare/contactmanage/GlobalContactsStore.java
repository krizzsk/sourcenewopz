package com.didi.component.splitfare.contactmanage;

import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.GLog;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.DIDIBaseApplication;
import com.didi.security.uuid.share.ShareDBHelper;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class GlobalContactsStore implements IGlobalContactsStore {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f15924a = GlobalContactsStore.class.getSimpleName();

    /* renamed from: b */
    private static Handler f15925b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    private static volatile SoftReference<List<GlobalContactsModel>> f15926c;

    /* renamed from: f */
    private static IGlobalContactsStore f15927f;

    /* renamed from: d */
    private List<GlobalContactsModel> f15928d;

    /* renamed from: e */
    private boolean f15929e;

    private GlobalContactsStore() {
    }

    public static IGlobalContactsStore getInstance() {
        if (f15927f == null) {
            synchronized (GlobalContactsStore.class) {
                if (f15927f == null) {
                    f15927f = new GlobalContactsStore();
                }
            }
        }
        return f15927f;
    }

    public void getSystemContacts(final GlobalContactsCallback globalContactsCallback) {
        this.f15929e = false;
        if (!m11630b()) {
            GLog.m7971i(f15924a, "getSystemContacts from cache");
            this.f15928d = f15926c.get();
            globalContactsCallback.onSucceed(m11632c(f15926c.get()));
            return;
        }
        Thread thread = new Thread(new Runnable() {
            public void run() {
                SystemUtils.setProcessThreadPriority(10);
                GLog.m7971i(GlobalContactsStore.f15924a, "getSystemContacts from database");
                try {
                    List a = GlobalContactsStore.this.m11631c();
                    GlobalContactsStore.this.m11627a((List<GlobalContactsModel>) a);
                    GlobalContactsStore.this.m11623a(globalContactsCallback, (List<GlobalContactsModel>) a);
                } catch (Exception e) {
                    GlobalContactsStore globalContactsStore = GlobalContactsStore.this;
                    GlobalContactsCallback globalContactsCallback = globalContactsCallback;
                    globalContactsStore.m11622a(globalContactsCallback, "something wrong! msg = " + e.toString());
                    e.printStackTrace();
                }
            }
        });
        thread.setName("global_getContacts_thread");
        thread.start();
    }

    public void clearData() {
        this.f15929e = true;
        if (this.f15928d != null) {
            this.f15928d = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11622a(final GlobalContactsCallback globalContactsCallback, final String str) {
        f15925b.post(new Runnable() {
            public void run() {
                globalContactsCallback.onFailed(str);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11623a(final GlobalContactsCallback globalContactsCallback, final List<GlobalContactsModel> list) {
        f15925b.post(new Runnable() {
            public void run() {
                globalContactsCallback.onSucceed(list);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11627a(List<GlobalContactsModel> list) {
        if (m11630b()) {
            f15926c = new SoftReference<>(list);
        }
        if (!this.f15929e) {
            this.f15928d = list;
        }
    }

    /* renamed from: b */
    private boolean m11630b() {
        return f15926c == null || f15926c.get() == null || f15926c.get().size() == 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public synchronized List<GlobalContactsModel> m11631c() {
        if (!m11630b()) {
            return m11632c(f15926c.get());
        }
        long currentTimeMillis = System.currentTimeMillis();
        List<GlobalContactsDataBaseModel> e = m11634e();
        List<GlobalContactsDataBaseModel> d = m11633d();
        if (!CollectionUtils.isEmpty((Collection) e)) {
            if (!CollectionUtils.isEmpty((Collection) d)) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < d.size(); i++) {
                    long j = d.get(i).f15923id;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= e.size()) {
                            break;
                        }
                        if (e.get(i2).f15923id == j) {
                            GlobalContactsModel globalContactsModel = new GlobalContactsModel();
                            globalContactsModel.phone = e.get(i2).phone;
                            globalContactsModel.name = d.get(i).name;
                            if (TextUtils.isEmpty(globalContactsModel.name)) {
                                break;
                            } else if (TextUtils.isEmpty(globalContactsModel.phone)) {
                                break;
                            } else if (!arrayList.contains(globalContactsModel)) {
                                arrayList.add(globalContactsModel);
                            }
                        }
                        i2++;
                    }
                }
                List<GlobalContactsModel> b = m11629b(arrayList);
                String str = f15924a;
                GLog.m7965d(str, "getContacts spend time = " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                return b;
            }
        }
        return null;
    }

    /* renamed from: b */
    private List<GlobalContactsModel> m11629b(List<GlobalContactsModel> list) {
        TreeMap treeMap = new TreeMap();
        if (list == null || list.size() == 0) {
            return null;
        }
        for (GlobalContactsModel next : list) {
            if (!TextUtils.isEmpty(next.name)) {
                char groupChar = GlobalCharMapUtil.getGroupChar(next.name.charAt(0));
                List list2 = (List) treeMap.get(new GlobalSortKey(groupChar));
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                list2.add(next);
                treeMap.put(new GlobalSortKey(groupChar), list2);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (GlobalSortKey globalSortKey : treeMap.keySet()) {
            List list3 = (List) treeMap.get(globalSortKey);
            if (list3 != null && !list3.isEmpty()) {
                for (int i = 0; i < list3.size(); i++) {
                    if (i == 0) {
                        GlobalContactsModel globalContactsModel = new GlobalContactsModel();
                        globalContactsModel.type = 3;
                        globalContactsModel.name = globalSortKey.key.toString();
                        arrayList.add(globalContactsModel);
                    }
                    arrayList.add(list3.get(i));
                }
            }
        }
        treeMap.clear();
        return arrayList;
    }

    /* renamed from: c */
    private List<GlobalContactsModel> m11632c(List<GlobalContactsModel> list) {
        if (!(list == null || list.size() == 0)) {
            for (GlobalContactsModel next : list) {
                next.checked = false;
                next.canSelected = true;
            }
        }
        return list;
    }

    /* renamed from: d */
    private List<GlobalContactsDataBaseModel> m11633d() {
        Cursor query = DIDIBaseApplication.getAppContext().getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, new String[]{ShareDBHelper.ID_NAME, "display_name"}, (String) null, (String[]) null, "display_name");
        if (query == null) {
            return null;
        }
        TreeSet treeSet = new TreeSet();
        while (query.moveToNext()) {
            GlobalContactsDataBaseModel globalContactsDataBaseModel = new GlobalContactsDataBaseModel();
            globalContactsDataBaseModel.f15923id = query.getLong(0);
            globalContactsDataBaseModel.name = query.getString(1);
            treeSet.add(globalContactsDataBaseModel);
        }
        query.close();
        return new ArrayList(treeSet);
    }

    /* renamed from: e */
    private List<GlobalContactsDataBaseModel> m11634e() {
        ArrayList arrayList = new ArrayList();
        Cursor query = DIDIBaseApplication.getAppContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"data1", "contact_id"}, (String) null, (String[]) null, (String) null);
        if (query == null || !query.moveToFirst()) {
            return arrayList;
        }
        do {
            GlobalContactsDataBaseModel globalContactsDataBaseModel = new GlobalContactsDataBaseModel();
            globalContactsDataBaseModel.phone = m11620a(query.getString(0));
            globalContactsDataBaseModel.f15923id = query.getLong(1);
            arrayList.add(globalContactsDataBaseModel);
        } while (query.moveToNext());
        return arrayList;
    }

    /* renamed from: a */
    private String m11620a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str.replace("-", "").replaceAll(" ", "");
    }

    public void getMatchList(String str, GlobalContactsCallback globalContactsCallback) {
        ArrayList arrayList = new ArrayList();
        List<GlobalContactsModel> list = this.f15928d;
        if (list == null || list.size() == 0) {
            globalContactsCallback.onFailed("origin data is null!");
            globalContactsCallback.onSucceed(arrayList);
            GLog.m7971i(f15924a, "getMatchList failed while cache is null");
            return;
        }
        for (GlobalContactsModel next : this.f15928d) {
            if (m11628a(next.name, str) || m11628a(next.phone, str)) {
                arrayList.add(next);
            }
        }
        globalContactsCallback.onSucceed(arrayList);
    }

    /* renamed from: a */
    private boolean m11628a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            return true;
        }
        return str.toLowerCase().contains(str2.toLowerCase());
    }
}
