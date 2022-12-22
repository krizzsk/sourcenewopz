package com.airbnb.lottie.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyPath {
    public static final KeyPath COMPOSITION = new KeyPath("COMPOSITION");

    /* renamed from: a */
    private final List<String> f1381a;

    /* renamed from: b */
    private KeyPathElement f1382b;

    public KeyPath(String... strArr) {
        this.f1381a = Arrays.asList(strArr);
    }

    private KeyPath(KeyPath keyPath) {
        this.f1381a = new ArrayList(keyPath.f1381a);
        this.f1382b = keyPath.f1382b;
    }

    public KeyPath addKey(String str) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.f1381a.add(str);
        return keyPath;
    }

    public KeyPath resolve(KeyPathElement keyPathElement) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.f1382b = keyPathElement;
        return keyPath;
    }

    public KeyPathElement getResolvedElement() {
        return this.f1382b;
    }

    public boolean matches(String str, int i) {
        if (m1307a(str)) {
            return true;
        }
        if (i >= this.f1381a.size()) {
            return false;
        }
        if (this.f1381a.get(i).equals(str) || this.f1381a.get(i).equals("**") || this.f1381a.get(i).equals("*")) {
            return true;
        }
        return false;
    }

    public int incrementDepthBy(String str, int i) {
        if (m1307a(str)) {
            return 0;
        }
        if (!this.f1381a.get(i).equals("**")) {
            return 1;
        }
        if (i != this.f1381a.size() - 1 && this.f1381a.get(i + 1).equals(str)) {
            return 2;
        }
        return 0;
    }

    public boolean fullyResolvesTo(String str, int i) {
        if (i >= this.f1381a.size()) {
            return false;
        }
        boolean z = i == this.f1381a.size() - 1;
        String str2 = this.f1381a.get(i);
        if (!str2.equals("**")) {
            boolean z2 = str2.equals(str) || str2.equals("*");
            if ((z || (i == this.f1381a.size() - 2 && m1306a())) && z2) {
                return true;
            }
            return false;
        }
        if (!z && this.f1381a.get(i + 1).equals(str)) {
            if (i == this.f1381a.size() - 2 || (i == this.f1381a.size() - 3 && m1306a())) {
                return true;
            }
            return false;
        } else if (z) {
            return true;
        } else {
            int i2 = i + 1;
            if (i2 < this.f1381a.size() - 1) {
                return false;
            }
            return this.f1381a.get(i2).equals(str);
        }
    }

    public boolean propagateToChildren(String str, int i) {
        if (!"__container".equals(str) && i >= this.f1381a.size() - 1 && !this.f1381a.get(i).equals("**")) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m1307a(String str) {
        return "__container".equals(str);
    }

    /* renamed from: a */
    private boolean m1306a() {
        List<String> list = this.f1381a;
        return list.get(list.size() - 1).equals("**");
    }

    public String keysToString() {
        return this.f1381a.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f1381a);
        sb.append(",resolved=");
        sb.append(this.f1382b != null);
        sb.append('}');
        return sb.toString();
    }
}
