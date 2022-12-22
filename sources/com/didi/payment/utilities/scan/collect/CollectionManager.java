package com.didi.payment.utilities.scan.collect;

import android.text.TextUtils;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.utilities.scan.utils.PreviewCollectionUtils;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didichuxing.ditest.agent.android.util.C15538Util;
import com.didichuxing.omega.sdk.corelink.node.EventSpecialNode;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;

public class CollectionManager {

    /* renamed from: a */
    private static final String f31680a = "key_action_hit";

    /* renamed from: b */
    private String f31681b;

    /* renamed from: c */
    private int[] f31682c;

    /* renamed from: d */
    private int f31683d;

    /* renamed from: e */
    private float f31684e;

    /* renamed from: f */
    private int f31685f;

    /* renamed from: g */
    private int f31686g;

    /* renamed from: h */
    private Set<String> f31687h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public List<CollectionModel> f31688i;

    /* renamed from: j */
    private long f31689j;

    /* renamed from: k */
    private volatile boolean f31690k;

    public CollectionManager() {
        this.f31683d = 0;
        this.f31684e = 0.5f;
        this.f31685f = 70;
        this.f31686g = 3;
        this.f31687h = new HashSet();
        this.f31688i = new ArrayList();
        this.f31689j = System.currentTimeMillis();
        this.f31681b = new UUID(C15538Util.getRandom().nextLong(), C15538Util.getRandom().nextLong()).toString();
        this.f31686g = ((Integer) WalletApolloUtil.getParam(CollectionConstant.APOLLO_ID, CollectionConstant.APOLLO_PARAM_MAX_TIME, 3)).intValue();
        this.f31684e = ((Float) WalletApolloUtil.getParam(CollectionConstant.APOLLO_ID, CollectionConstant.APOLLO_PARAM_RATIO, Float.valueOf(0.5f))).floatValue();
        this.f31685f = ((Integer) WalletApolloUtil.getParam(CollectionConstant.APOLLO_ID, CollectionConstant.APOLLO_PARAM_QUALITY, 70)).intValue();
        m22474a();
        m22476b();
    }

    /* renamed from: a */
    private void m22474a() {
        String str = (String) WalletApolloUtil.getParam(CollectionConstant.APOLLO_ID, CollectionConstant.APOLLO_PARAM_TIME_POINTS, "[6]");
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                this.f31682c = new int[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.f31682c[i] = jSONArray.optInt(i) * 1000;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m22476b() {
        if (EventSpecialNode.getSpecial(CollectionConstant.EVENT_ID) == null) {
            Map map = null;
            Class<EventSpecialNode> cls = EventSpecialNode.class;
            try {
                Field declaredField = cls.getDeclaredField("specialMap");
                declaredField.setAccessible(true);
                map = (Map) declaredField.get(cls);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (map == null) {
                map = new HashMap();
            }
            PrintStream printStream = System.out;
            printStream.println("specialMap size: " + map.size());
            HashMap hashMap = new HashMap();
            hashMap.put("r", 1);
            map.put(CollectionConstant.EVENT_ID, hashMap);
            EventSpecialNode.putSpecial(map);
        }
    }

    public void collectIfNeeded(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        if (!this.f31690k && this.f31687h.size() < this.f31686g) {
            long currentTimeMillis = System.currentTimeMillis() - this.f31689j;
            int[] iArr = this.f31682c;
            if (iArr != null && iArr.length > 0) {
                int length = iArr.length;
                int i3 = 0;
                while (i3 < length) {
                    int i4 = iArr[i3];
                    if (i4 == 0 || currentTimeMillis <= ((long) i4) || this.f31687h.contains(String.valueOf(i4))) {
                        i3++;
                    } else {
                        String valueOf = String.valueOf(i4);
                        CollectionModel a = m22472a(bArr, i, i2, z, z2);
                        this.f31687h.add(valueOf);
                        m22475a(a);
                        return;
                    }
                }
            }
            if (z && !this.f31687h.contains(f31680a)) {
                CollectionModel a2 = m22472a(bArr, i, i2, z, z2);
                this.f31687h.add(f31680a);
                m22475a(a2);
            }
        }
    }

    /* renamed from: a */
    private CollectionModel m22472a(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        String compressData = PreviewCollectionUtils.compressData(bArr, i, i2, this.f31684e, this.f31685f);
        String str = this.f31681b;
        int i3 = this.f31683d;
        this.f31683d = i3 + 1;
        return new CollectionModel(compressData, str, i3, z, z2);
    }

    /* renamed from: a */
    private void m22475a(final CollectionModel collectionModel) {
        if (collectionModel != null) {
            UiThreadHandler.post(new Runnable() {
                public void run() {
                    CollectionManager.this.f31688i.add(collectionModel);
                }
            });
        }
    }

    public void dump(boolean z) {
        this.f31690k = true;
        if (!CollectionUtil.isEmpty((Collection<?>) this.f31688i)) {
            if (z) {
                for (CollectionModel map : this.f31688i) {
                    System.out.println("dump !!!!!!!!!!!");
                    PayTracker.trackEvent(CollectionConstant.EVENT_ID, map.toMap());
                }
            } else {
                System.out.println("dump !!!!!!!!! no track");
            }
            this.f31688i.clear();
        }
    }

    public boolean hasCollectedData() {
        return !this.f31690k && !CollectionUtil.isEmpty((Collection<?>) this.f31688i);
    }
}
