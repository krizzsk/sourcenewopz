package com.didi.sdk.misconfig.p153v2.impl;

import com.didi.sdk.misconfig.store.ICityChangeListener;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.sdk.misconfig.v2.impl.CityChangedNotifier */
public class CityChangedNotifier {

    /* renamed from: a */
    private List<ICityChangeListener> f36818a = new ArrayList();

    public void registerCityChangeListener(ICityChangeListener iCityChangeListener) {
        if (iCityChangeListener != null) {
            synchronized (this.f36818a) {
                if (!this.f36818a.contains(iCityChangeListener)) {
                    this.f36818a.add(iCityChangeListener);
                }
            }
        }
    }

    public void unRegisterCityChangeListener(ICityChangeListener iCityChangeListener) {
        if (iCityChangeListener != null) {
            synchronized (this.f36818a) {
                this.f36818a.remove(iCityChangeListener);
            }
        }
    }

    public void dispatchCityChangeEvent(int i, int i2) {
        synchronized (this.f36818a) {
            if (this.f36818a != null) {
                int size = this.f36818a.size();
                for (int i3 = 0; i3 < size; i3++) {
                    this.f36818a.get(i3).onCityChange(i, i2);
                }
            }
        }
    }
}
