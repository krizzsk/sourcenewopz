package com.didichuxing.carsliding.model;

import android.text.TextUtils;
import com.didi.common.map.model.BitmapDescriptor;

public class Driver {

    /* renamed from: a */
    private String f46253a;

    /* renamed from: b */
    private BitmapDescriptor f46254b;

    /* renamed from: c */
    private VectorCoordinateList f46255c;

    public Driver(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f46253a = str;
            return;
        }
        throw new NullPointerException("The id can't be Null!");
    }

    public String getId() {
        return this.f46253a;
    }

    public BitmapDescriptor getBitmap() {
        return this.f46254b;
    }

    public void setBitmap(BitmapDescriptor bitmapDescriptor) {
        this.f46254b = bitmapDescriptor;
    }

    public VectorCoordinateList getVectorCoordinateList() {
        return this.f46255c;
    }

    public void setVectorCoordinateList(VectorCoordinateList vectorCoordinateList) {
        this.f46255c = vectorCoordinateList;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Driver)) {
            return false;
        }
        Driver driver = (Driver) obj;
        if (TextUtils.isEmpty(this.f46253a) || TextUtils.isEmpty(driver.getId())) {
            return false;
        }
        return this.f46253a.equals(driver.getId());
    }

    public int hashCode() {
        if (TextUtils.isEmpty(this.f46253a)) {
            return 0;
        }
        return this.f46253a.hashCode();
    }

    public String toString() {
        return "{id=" + this.f46253a + "vectorCoordinateList=" + this.f46255c + "}";
    }
}
