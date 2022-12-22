package com.didi.zxing.barcodescanner.store;

import android.content.Context;
import com.didi.sdk.dependency.ConstantHolder;
import com.didi.sdk.dependency.ConstantListener;
import com.didi.sdk.store.BaseStore;
import java.util.ArrayList;
import java.util.Collections;

public class DqrStore extends BaseStore {

    /* renamed from: a */
    private static final String f45449a = "DQR-Store";

    /* renamed from: b */
    private static volatile DqrStore f45450b;

    public static DqrStore getInstance() {
        if (f45450b == null) {
            synchronized (DqrStore.class) {
                if (f45450b == null) {
                    ConstantListener constantListener = ConstantHolder.getInstance().getConstantListener();
                    final ArrayList arrayList = new ArrayList();
                    if (constantListener != null) {
                        Collections.addAll(arrayList, ConstantHolder.getInstance().getConstantListener().getBusinessIds());
                    }
                    arrayList.add(f45449a);
                    ConstantHolder.getInstance().setConstantListener(new ConstantListener() {
                        public String[] getBusinessIds() {
                            ArrayList arrayList = arrayList;
                            return (String[]) arrayList.toArray(new String[arrayList.size()]);
                        }
                    });
                    f45450b = new DqrStore();
                }
            }
        }
        return f45450b;
    }

    private DqrStore() {
        super(f45449a);
    }

    public int getInt(Context context, String str, int i) {
        try {
            return Integer.valueOf(getString(context, str, i + "")).intValue();
        } catch (Exception unused) {
            return i;
        }
    }

    public void putAndSave(Context context, String str, int i) {
        super.putAndSave(context, str, i + "");
    }

    public String getString(Context context, String str, String str2) {
        Object inner = getInner(context, str);
        if (inner instanceof byte[]) {
            return new String((byte[]) inner);
        }
        return inner instanceof String ? (String) inner : str2;
    }
}
