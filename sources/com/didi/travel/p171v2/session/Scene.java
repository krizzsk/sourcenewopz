package com.didi.travel.p171v2.session;

/* renamed from: com.didi.travel.v2.session.Scene */
public final class Scene {
    public final int code;
    public final String desc;

    public Scene(int i, String str) {
        this.code = i;
        this.desc = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.code == ((Scene) obj).code) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.code;
    }

    public String toString() {
        return "Scene{code=" + this.code + ", desc='" + this.desc + '\'' + '}';
    }
}
