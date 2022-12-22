package com.didi.map.sdk.nav.car;

import android.content.Context;
import android.os.AsyncTask;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CarIconsPreloader {

    /* renamed from: a */
    private static final String f28365a = "CarIconsPreloader";

    /* renamed from: b */
    private static final CarIconsPreloader f28366b = new CarIconsPreloader();

    /* renamed from: c */
    private static final int f28367c = 30;

    /* renamed from: d */
    private static final float f28368d = 0.8f;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Context f28369e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public volatile CopyOnWriteArrayList<LatLng> f28370f = new CopyOnWriteArrayList<>();

    /* renamed from: g */
    private int f28371g = 0;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f28372h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f28373i = 30;

    /* renamed from: j */
    private int f28374j = 24;

    /* renamed from: k */
    private boolean f28375k = false;

    private CarIconsPreloader() {
    }

    public static CarIconsPreloader getInstance() {
        return f28366b;
    }

    public void set3DCarEnabled(boolean z) {
        this.f28375k = z;
    }

    public void setRoutePoints(Context context, List<LatLng> list) {
        if (context != null && !CollectionUtil.isEmpty((Collection<?>) list)) {
            this.f28369e = context.getApplicationContext();
            this.f28370f.clear();
            this.f28370f.addAll(list);
            int size = list.size();
            this.f28371g = size;
            this.f28372h = 0;
            if (size <= 30) {
                this.f28373i = size - 1;
                this.f28374j = size - 1;
            } else {
                this.f28373i = 30;
                this.f28374j = 24;
            }
            m20109a();
        }
    }

    public void preloadCarIcons(int i) {
        int i2;
        if (this.f28375k && this.f28370f != null && (i2 = this.f28371g) > 0 && i > this.f28374j && i < i2 - 1) {
            int i3 = this.f28373i;
            this.f28372h = i3;
            int i4 = i3 + 30;
            this.f28373i = i4;
            if (i4 > i2) {
                this.f28373i = i2 - 1;
                this.f28374j = i2 - 1;
            } else {
                this.f28374j = (int) (((float) i4) * 0.8f);
            }
            m20109a();
        }
    }

    /* renamed from: a */
    private void m20109a() {
        int i;
        int i2;
        if (this.f28375k && !CollectionUtil.isEmpty((Collection<?>) this.f28370f) && CarAngleUtil.CAR_ICONS_CACHE.size() < CarAngleUtil.CAR_ICONS_COUNT && (i = this.f28371g) != 0 && (i2 = this.f28372h) < this.f28373i && i2 < i - 1) {
            try {
                new PreloadAsyncTask().execute(new Void[0]);
            } catch (Exception e) {
                DLog.m7384d(f28365a, "loadCarIcons: %s ", e.toString());
            }
        }
    }

    private class PreloadAsyncTask extends AsyncTask<Void, Void, Void> {
        private PreloadAsyncTask() {
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... voidArr) {
            int i;
            if (CollectionUtil.isEmpty((Collection<?>) CarIconsPreloader.this.f28370f)) {
                return null;
            }
            int b = CarIconsPreloader.this.f28372h;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (b > CarIconsPreloader.this.f28373i - 2 || CollectionUtil.isEmpty((Collection<?>) CarIconsPreloader.this.f28370f) || (i = b + 2) >= CarIconsPreloader.this.f28370f.size()) {
                    break;
                }
                try {
                    LatLng latLng = (LatLng) CarIconsPreloader.this.f28370f.get(b);
                    b++;
                    LatLng latLng2 = (LatLng) CarIconsPreloader.this.f28370f.get(b);
                    LatLng latLng3 = (LatLng) CarIconsPreloader.this.f28370f.get(i);
                    if (latLng == null || latLng2 == null) {
                        break;
                    } else if (latLng3 == null) {
                        break;
                    } else {
                        if (!latLng.toString().equals(latLng2.toString())) {
                            i2 = CarAngleUtil.getIndexByLocation(latLng, latLng2);
                        }
                        if (!latLng2.toString().equals(latLng3.toString())) {
                            i3 = CarAngleUtil.getIndexByLocation(latLng2, latLng3);
                        }
                        List<Integer> rotateIndexes = CarAngleUtil.getRotateIndexes(i2, i3);
                        if (rotateIndexes != null) {
                            if (rotateIndexes.size() != 0) {
                                for (Integer intValue : rotateIndexes) {
                                    int intValue2 = intValue.intValue();
                                    if (!CarAngleUtil.isCarIconCache(intValue2)) {
                                        CarAngleUtil.getCarBitmapDescriptor(CarIconsPreloader.this.f28369e, intValue2);
                                    }
                                }
                            }
                        }
                        if (!CarAngleUtil.isCarIconCache(i2)) {
                            CarAngleUtil.getCarBitmapDescriptor(CarIconsPreloader.this.f28369e, i2);
                        }
                    }
                } catch (Exception e) {
                    DLog.m7384d("3dcar", "CarIconsPreloader Exception:" + e.toString(), new Object[0]);
                }
            }
            DLog.m7384d("3dcar", "CarIconsPreloader cache size:" + CarAngleUtil.CAR_ICONS_CACHE.size(), new Object[0]);
            return null;
        }
    }

    public void destory() {
        this.f28370f.clear();
        this.f28371g = 0;
        this.f28372h = 0;
        this.f28373i = 30;
        this.f28374j = 24;
        this.f28375k = false;
    }
}
