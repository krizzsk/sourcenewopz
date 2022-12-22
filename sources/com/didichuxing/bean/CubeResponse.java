package com.didichuxing.bean;

public class CubeResponse {
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static CubeResponse f45662e;

    /* renamed from: a */
    private int f45663a;

    /* renamed from: b */
    private String f45664b;

    /* renamed from: c */
    private boolean f45665c;

    /* renamed from: d */
    private int f45666d;

    public int getErrno() {
        return this.f45663a;
    }

    public void setErrno(int i) {
        this.f45663a = i;
    }

    public String getErrMsg() {
        return this.f45664b;
    }

    public void setErrMsg(String str) {
        this.f45664b = str;
    }

    public boolean isUpdate() {
        return this.f45665c;
    }

    public void setUpdate(boolean z) {
        this.f45665c = z;
    }

    public int getInterval() {
        return this.f45666d;
    }

    public void setInterval(int i) {
        this.f45666d = i;
    }

    public static class Builder {
        public Builder() {
            CubeResponse unused = CubeResponse.f45662e = new CubeResponse();
        }

        public Builder setErrNo(int i) {
            CubeResponse.f45662e.setErrno(i);
            return this;
        }

        public Builder setErrMsg(String str) {
            CubeResponse.f45662e.setErrMsg(str);
            return this;
        }

        public Builder setInterval(int i) {
            CubeResponse.f45662e.setInterval(i);
            return this;
        }

        public Builder setUpdate(boolean z) {
            CubeResponse.f45662e.setUpdate(z);
            return this;
        }

        public CubeResponse build() {
            return CubeResponse.f45662e;
        }
    }

    public String toString() {
        return "CubeResponse :   errno = " + this.f45663a + " errMsg = " + this.f45664b + "update : " + this.f45665c + "  interval : " + this.f45666d;
    }
}
