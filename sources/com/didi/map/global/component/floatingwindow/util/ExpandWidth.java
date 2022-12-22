package com.didi.map.global.component.floatingwindow.util;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B'\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bB\u0011\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\nJ\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/map/global/component/floatingwindow/util/ExpandWidth;", "", "()V", "left", "", "top", "right", "bottom", "(IIII)V", "src", "(Lcom/didi/map/global/component/floatingwindow/util/ExpandWidth;)V", "getBottom", "()I", "setBottom", "(I)V", "getLeft", "setLeft", "getRight", "setRight", "getTop", "setTop", "equals", "", "other", "hashCode", "toString", "", "compFloatingWindow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ViewExt.kt */
public final class ExpandWidth {

    /* renamed from: a */
    private int f25613a;

    /* renamed from: b */
    private int f25614b;

    /* renamed from: c */
    private int f25615c;

    /* renamed from: d */
    private int f25616d;

    public final int getLeft() {
        return this.f25613a;
    }

    public final void setLeft(int i) {
        this.f25613a = i;
    }

    public final int getTop() {
        return this.f25614b;
    }

    public final void setTop(int i) {
        this.f25614b = i;
    }

    public final int getRight() {
        return this.f25615c;
    }

    public final void setRight(int i) {
        this.f25615c = i;
    }

    public final int getBottom() {
        return this.f25616d;
    }

    public final void setBottom(int i) {
        this.f25616d = i;
    }

    public ExpandWidth() {
    }

    public ExpandWidth(int i, int i2, int i3, int i4) {
        this.f25613a = i;
        this.f25614b = i2;
        this.f25615c = i3;
        this.f25616d = i4;
    }

    public ExpandWidth(ExpandWidth expandWidth) {
        if (expandWidth != null) {
            this.f25614b = expandWidth.f25614b;
            this.f25616d = expandWidth.f25616d;
            this.f25613a = expandWidth.f25613a;
            this.f25615c = expandWidth.f25615c;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ExpandWidth)) {
            return false;
        }
        ExpandWidth expandWidth = (ExpandWidth) obj;
        if (expandWidth.f25613a == this.f25613a && expandWidth.f25615c == this.f25615c && expandWidth.f25616d == this.f25616d && expandWidth.f25614b == this.f25614b) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "top=" + this.f25614b + ", bottom=" + this.f25616d + ", left=" + this.f25613a + ", right=" + this.f25615c;
    }

    public int hashCode() {
        return (((((this.f25613a * 31) + this.f25614b) * 31) + this.f25615c) * 31) + this.f25616d;
    }
}
