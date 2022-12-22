package com.didi.sdk.misconfig.p153v2;

import java.util.HashMap;

/* renamed from: com.didi.sdk.misconfig.v2.SecondConfProxy */
public class SecondConfProxy implements ISecondConf {

    /* renamed from: a */
    private HashMap<String, ISecondConf> f36817a;

    private SecondConfProxy() {
        this.f36817a = new HashMap<>();
    }

    /* renamed from: com.didi.sdk.misconfig.v2.SecondConfProxy$SingletonHolder */
    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final SecondConfProxy instance = new SecondConfProxy();

        private SingletonHolder() {
        }
    }

    public void addSecondConf(String str, ISecondConf iSecondConf) {
        this.f36817a.put(str, iSecondConf);
    }

    public ISecondConf getSecondConf(String str) {
        return this.f36817a.get(str);
    }

    public static SecondConfProxy getInstance() {
        return SingletonHolder.instance;
    }

    public void getSecConfigFromNet(double d, double d2, int i) {
        ISecondConf a = m26075a();
        if (a != null) {
            a.getSecConfigFromNet(d, d2, i);
        }
    }

    public boolean isCityOpen(String str) {
        ISecondConf iSecondConf = this.f36817a.get(str);
        if (iSecondConf != null) {
            return iSecondConf.isCityOpen(str);
        }
        return false;
    }

    /* renamed from: a */
    private ISecondConf m26075a() {
        return this.f36817a.get(ConfProxy.getInstance().getSelectedType());
    }
}
