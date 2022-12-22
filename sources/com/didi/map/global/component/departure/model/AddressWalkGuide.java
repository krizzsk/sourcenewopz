package com.didi.map.global.component.departure.model;

import android.text.TextUtils;

public class AddressWalkGuide {

    /* renamed from: a */
    private String f25171a;

    /* renamed from: b */
    private String f25172b;

    public String getGuidePhoto() {
        return this.f25171a;
    }

    public void setGuidePhoto(String str) {
        this.f25171a = str;
    }

    public String getGuidePhotoH5() {
        return this.f25172b;
    }

    public void setGuidePhotoH5(String str) {
        this.f25172b = str;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.f25171a) && !TextUtils.isEmpty(this.f25172b);
    }

    public String toString() {
        return "AddressWalkGuide{guidePhoto='" + this.f25171a + '\'' + ", guidePhotoH5='" + this.f25172b + '\'' + '}';
    }
}
