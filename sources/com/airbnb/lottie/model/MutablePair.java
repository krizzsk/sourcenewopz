package com.airbnb.lottie.model;

import androidx.core.util.Pair;

public class MutablePair<T> {

    /* renamed from: a */
    T f1387a;

    /* renamed from: b */
    T f1388b;

    public void set(T t, T t2) {
        this.f1387a = t;
        this.f1388b = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (!m1308a(pair.first, this.f1387a) || !m1308a(pair.second, this.f1388b)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m1308a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public int hashCode() {
        T t = this.f1387a;
        int i = 0;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.f1388b;
        if (t2 != null) {
            i = t2.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f1387a) + " " + String.valueOf(this.f1388b) + "}";
    }
}
