package com.didi.map.global.component.myLocation;

public class MyLocationCompParam {

    /* renamed from: a */
    private int f26041a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f26042b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f26043c;

    private MyLocationCompParam(int i) {
        this.f26041a = i;
    }

    public int getzIndex() {
        return this.f26041a;
    }

    public int getArrowIcon() {
        return this.f26042b;
    }

    public int getPositionIcon() {
        return this.f26043c;
    }

    public static class Builder {
        private MyLocationCompParam locationCompParam;

        public Builder(int i) {
            this.locationCompParam = new MyLocationCompParam(i);
        }

        public Builder arrowIcon(int i) {
            int unused = this.locationCompParam.f26042b = i;
            return this;
        }

        public Builder positionIcon(int i) {
            int unused = this.locationCompParam.f26043c = i;
            return this;
        }

        public MyLocationCompParam build() {
            return this.locationCompParam;
        }
    }
}
