package com.didi.component.common.contacts;

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

public class GCommonContactsStore implements IGCommonContactsStore {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f11495a = GCommonContactsStore.class.getSimpleName();

    /* renamed from: b */
    private static Handler f11496b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    private static volatile SoftReference<List<GCommonContactsModel>> f11497c;

    /* renamed from: f */
    private static IGCommonContactsStore f11498f;

    /* renamed from: d */
    private List<GCommonContactsModel> f11499d;

    /* renamed from: e */
    private boolean f11500e;

    private GCommonContactsStore() {
    }

    public static IGCommonContactsStore getInstance() {
        if (f11498f == null) {
            synchronized (GCommonContactsStore.class) {
                if (f11498f == null) {
                    f11498f = new GCommonContactsStore();
                }
            }
        }
        return f11498f;
    }

    public void getSystemContacts(final GCommonContactsCallback gCommonContactsCallback) {
        this.f11500e = false;
        if (!m7782b()) {
            GLog.m7971i(f11495a, "getSystemContacts from cache");
            this.f11499d = f11497c.get();
            gCommonContactsCallback.onSucceed(m7784c(f11497c.get()));
            return;
        }
        Thread thread = new Thread(new Runnable() {
            public void run() {
                SystemUtils.setProcessThreadPriority(10);
                GLog.m7971i(GCommonContactsStore.f11495a, "getSystemContacts from database");
                try {
                    List a = GCommonContactsStore.this.m7783c();
                    GCommonContactsStore.this.m7779a((List<GCommonContactsModel>) a);
                    GCommonContactsStore.this.m7775a(gCommonContactsCallback, (List<GCommonContactsModel>) a);
                } catch (Exception e) {
                    GCommonContactsStore gCommonContactsStore = GCommonContactsStore.this;
                    GCommonContactsCallback gCommonContactsCallback = gCommonContactsCallback;
                    gCommonContactsStore.m7774a(gCommonContactsCallback, "something wrong! msg = " + e.toString());
                    e.printStackTrace();
                }
            }
        });
        thread.setName("global_getContacts_thread");
        thread.start();
    }

    public void clearData() {
        this.f11500e = true;
        if (this.f11499d != null) {
            this.f11499d = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7774a(final GCommonContactsCallback gCommonContactsCallback, final String str) {
        f11496b.post(new Runnable() {
            public void run() {
                gCommonContactsCallback.onFailed(str);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7775a(final GCommonContactsCallback gCommonContactsCallback, final List<GCommonContactsModel> list) {
        f11496b.post(new Runnable() {
            public void run() {
                gCommonContactsCallback.onSucceed(list);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7779a(List<GCommonContactsModel> list) {
        if (m7782b()) {
            f11497c = new SoftReference<>(list);
        }
        if (!this.f11500e) {
            this.f11499d = list;
        }
    }

    /* renamed from: b */
    private boolean m7782b() {
        return f11497c == null || f11497c.get() == null || f11497c.get().size() == 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public synchronized List<GCommonContactsModel> m7783c() {
        if (!m7782b()) {
            return m7784c(f11497c.get());
        }
        long currentTimeMillis = System.currentTimeMillis();
        List<GCommonContactsDataBaseModel> e = m7786e();
        List<GCommonContactsDataBaseModel> d = m7785d();
        if (!CollectionUtils.isEmpty((Collection) e)) {
            if (!CollectionUtils.isEmpty((Collection) d)) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < d.size(); i++) {
                    long j = d.get(i).f11494id;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= e.size()) {
                            break;
                        }
                        if (e.get(i2).f11494id == j) {
                            GCommonContactsModel gCommonContactsModel = new GCommonContactsModel();
                            gCommonContactsModel.phone = e.get(i2).phone;
                            gCommonContactsModel.name = d.get(i).name;
                            if (TextUtils.isEmpty(gCommonContactsModel.name)) {
                                break;
                            } else if (TextUtils.isEmpty(gCommonContactsModel.phone)) {
                                break;
                            } else if (!arrayList.contains(gCommonContactsModel)) {
                                arrayList.add(gCommonContactsModel);
                            }
                        }
                        i2++;
                    }
                }
                List<GCommonContactsModel> b = m7781b(arrayList);
                String str = f11495a;
                GLog.m7965d(str, "getContacts spend time = " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                return b;
            }
        }
        return null;
    }

    /* renamed from: b */
    private List<GCommonContactsModel> m7781b(List<GCommonContactsModel> list) {
        TreeMap treeMap = new TreeMap();
        if (list == null || list.size() == 0) {
            return null;
        }
        for (GCommonContactsModel next : list) {
            if (!TextUtils.isEmpty(next.name)) {
                char groupChar = GCommonCharMapUtil.getGroupChar(next.name.charAt(0));
                List list2 = (List) treeMap.get(new GCommonSortKey(groupChar));
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                list2.add(next);
                treeMap.put(new GCommonSortKey(groupChar), list2);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (GCommonSortKey gCommonSortKey : treeMap.keySet()) {
            List list3 = (List) treeMap.get(gCommonSortKey);
            if (list3 != null && !list3.isEmpty()) {
                for (int i = 0; i < list3.size(); i++) {
                    if (i == 0) {
                        GCommonContactsModel gCommonContactsModel = new GCommonContactsModel();
                        gCommonContactsModel.type = 3;
                        gCommonContactsModel.name = gCommonSortKey.key.toString();
                        arrayList.add(gCommonContactsModel);
                    }
                    arrayList.add(list3.get(i));
                }
            }
        }
        treeMap.clear();
        return arrayList;
    }

    /* renamed from: c */
    private List<GCommonContactsModel> m7784c(List<GCommonContactsModel> list) {
        if (!(list == null || list.size() == 0)) {
            for (GCommonContactsModel next : list) {
                next.checked = false;
                next.canSelected = true;
            }
        }
        return list;
    }

    /* renamed from: d */
    private List<GCommonContactsDataBaseModel> m7785d() {
        Cursor query = DIDIBaseApplication.getAppContext().getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, new String[]{ShareDBHelper.ID_NAME, "display_name"}, (String) null, (String[]) null, "display_name");
        if (query == null) {
            return null;
        }
        TreeSet treeSet = new TreeSet();
        while (query.moveToNext()) {
            GCommonContactsDataBaseModel gCommonContactsDataBaseModel = new GCommonContactsDataBaseModel();
            gCommonContactsDataBaseModel.f11494id = query.getLong(0);
            gCommonContactsDataBaseModel.name = query.getString(1);
            treeSet.add(gCommonContactsDataBaseModel);
        }
        query.close();
        return new ArrayList(treeSet);
    }

    /* renamed from: e */
    private List<GCommonContactsDataBaseModel> m7786e() {
        ArrayList arrayList = new ArrayList();
        Cursor query = DIDIBaseApplication.getAppContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"data1", "contact_id"}, (String) null, (String[]) null, (String) null);
        if (query == null || !query.moveToFirst()) {
            return arrayList;
        }
        do {
            GCommonContactsDataBaseModel gCommonContactsDataBaseModel = new GCommonContactsDataBaseModel();
            gCommonContactsDataBaseModel.phone = m7772a(query.getString(0));
            gCommonContactsDataBaseModel.f11494id = query.getLong(1);
            arrayList.add(gCommonContactsDataBaseModel);
        } while (query.moveToNext());
        return arrayList;
    }

    /* renamed from: a */
    private String m7772a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str.replace("-", "").replaceAll(" ", "");
    }

    public void getMatchList(String str, GCommonContactsCallback gCommonContactsCallback) {
        ArrayList arrayList = new ArrayList();
        List<GCommonContactsModel> list = this.f11499d;
        if (list == null || list.size() == 0) {
            gCommonContactsCallback.onFailed("origin data is null!");
            gCommonContactsCallback.onSucceed(arrayList);
            GLog.m7971i(f11495a, "getMatchList failed while cache is null");
            return;
        }
        for (GCommonContactsModel next : this.f11499d) {
            if (m7780a(next.name, str) || m7780a(next.phone, str)) {
                arrayList.add(next);
            }
        }
        gCommonContactsCallback.onSucceed(arrayList);
    }

    /* renamed from: a */
    private boolean m7780a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            return true;
        }
        return str.toLowerCase().contains(str2.toLowerCase());
    }
}
