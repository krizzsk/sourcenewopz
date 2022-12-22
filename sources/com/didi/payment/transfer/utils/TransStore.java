package com.didi.payment.transfer.utils;

import com.didi.sdk.util.collection.CollectionUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TransStore {

    /* renamed from: a */
    private static TransStore f31495a = new TransStore();

    /* renamed from: b */
    private Map<Integer, String> f31496b = new ConcurrentHashMap();

    private TransStore() {
    }

    public static TransStore getInstance() {
        return f31495a;
    }

    public void addBankItem(int i, String str) {
        this.f31496b.put(Integer.valueOf(i), str);
    }

    public String getBankName(int i) {
        return this.f31496b.containsKey(Integer.valueOf(i)) ? this.f31496b.get(Integer.valueOf(i)) : "";
    }

    public int getBankCount() {
        return this.f31496b.size();
    }

    public boolean isBankDataPrepared() {
        return !CollectionUtil.isEmpty((Map<?, ?>) this.f31496b);
    }
}
