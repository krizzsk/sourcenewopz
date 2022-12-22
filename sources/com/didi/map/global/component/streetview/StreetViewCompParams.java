package com.didi.map.global.component.streetview;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;

public class StreetViewCompParams {

    /* renamed from: a */
    private boolean f26201a;

    /* renamed from: b */
    private boolean f26202b;

    /* renamed from: c */
    private boolean f26203c;

    /* renamed from: d */
    private boolean f26204d;

    /* renamed from: e */
    private boolean f26205e;

    /* renamed from: f */
    private String f26206f;

    /* renamed from: g */
    private String f26207g;

    /* renamed from: h */
    private String f26208h;

    /* renamed from: i */
    private String f26209i;

    /* renamed from: j */
    private FragmentActivity f26210j;

    /* renamed from: k */
    private StreetVersion f26211k;

    /* renamed from: l */
    private String f26212l;

    public boolean isStreetNamesEnable() {
        return this.f26201a;
    }

    public boolean isZoomGesturesEnable() {
        return this.f26202b;
    }

    public boolean isPanningGesturesEnable() {
        return this.f26203c;
    }

    public boolean isUserNavigationEnabled() {
        return this.f26204d;
    }

    public String getStreetViewUrl() {
        return this.f26206f;
    }

    public String getTripId() {
        return TextUtils.isEmpty(this.f26207g) ? "tripId" : this.f26207g;
    }

    public String getOrderId() {
        return this.f26208h;
    }

    public String getUid() {
        return this.f26209i;
    }

    public boolean isShowGuideTipsText() {
        return this.f26205e;
    }

    public FragmentActivity getActivity() {
        return this.f26210j;
    }

    public StreetVersion getStreetVersion() {
        return this.f26211k;
    }

    public String getStreetHintContent() {
        return this.f26212l;
    }

    private StreetViewCompParams(Builder builder) {
        this.f26210j = builder.activity;
        this.f26201a = builder.streetNamesEnable;
        this.f26202b = builder.zoomGesturesEnable;
        this.f26203c = builder.panningGesturesEnable;
        this.f26204d = builder.userNavigationEnabled;
        this.f26206f = builder.streetViewUrl;
        this.f26207g = builder.tripId;
        this.f26205e = builder.showGuideTipsText;
        this.f26208h = builder.orderId;
        this.f26209i = builder.uid;
        this.f26211k = builder.streetVersion;
        this.f26212l = builder.streetHintContent;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public FragmentActivity activity;
        /* access modifiers changed from: private */
        public String orderId;
        /* access modifiers changed from: private */
        public boolean panningGesturesEnable;
        /* access modifiers changed from: private */
        public boolean showGuideTipsText = true;
        /* access modifiers changed from: private */
        public String streetHintContent;
        /* access modifiers changed from: private */
        public boolean streetNamesEnable;
        /* access modifiers changed from: private */
        public StreetVersion streetVersion;
        /* access modifiers changed from: private */
        public String streetViewUrl;
        /* access modifiers changed from: private */
        public String tripId;
        /* access modifiers changed from: private */
        public String uid;
        /* access modifiers changed from: private */
        public boolean userNavigationEnabled;
        /* access modifiers changed from: private */
        public boolean zoomGesturesEnable;

        private void debugThrowException(String str) {
        }

        public Builder activity(FragmentActivity fragmentActivity) {
            this.activity = fragmentActivity;
            return this;
        }

        public Builder setStreetHintContent(String str) {
            this.streetHintContent = str;
            return this;
        }

        public Builder streetNamesEnabled(boolean z) {
            this.streetNamesEnable = z;
            return this;
        }

        public Builder setStreetVersion(StreetVersion streetVersion2) {
            this.streetVersion = streetVersion2;
            return this;
        }

        public Builder zoomGesturesEnabled(boolean z) {
            this.zoomGesturesEnable = z;
            return this;
        }

        public Builder panningGesturesEnable(boolean z) {
            this.panningGesturesEnable = z;
            return this;
        }

        public Builder userNavigationEnabled(boolean z) {
            this.userNavigationEnabled = z;
            return this;
        }

        public Builder streetViewUrl(String str) {
            this.streetViewUrl = str;
            return this;
        }

        public Builder tripId(String str) {
            this.tripId = str;
            return this;
        }

        public Builder showGuideTipsText(boolean z) {
            this.showGuideTipsText = z;
            return this;
        }

        public Builder orderId(String str) {
            this.orderId = str;
            return this;
        }

        public Builder uid(String str) {
            this.uid = str;
            return this;
        }

        public StreetViewCompParams build() {
            checkParams();
            return new StreetViewCompParams(this);
        }

        private void checkParams() {
            if (this.activity == null) {
                debugThrowException("activity is null !!!");
            }
        }
    }
}
