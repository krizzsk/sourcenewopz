package com.didi.component.never.core;

import com.taxis99.R;

public class Animations {

    /* renamed from: a */
    private int f14638a;

    /* renamed from: b */
    private int f14639b;

    /* renamed from: c */
    private int f14640c;

    /* renamed from: d */
    private int f14641d;

    public Animations() {
        this.f14638a = R.anim.comp_fragment_enter;
        this.f14639b = R.anim.comp_fragment_exit;
        this.f14640c = R.anim.comp_fragment_pop_enter;
        this.f14641d = R.anim.comp_fragment_pop_exit;
    }

    public Animations(int i, int i2, int i3, int i4) {
        this.f14638a = i;
        this.f14639b = i2;
        this.f14640c = i3;
        this.f14641d = i4;
    }

    public int enterAnim() {
        return this.f14638a;
    }

    public void setEnterAnim(int i) {
        this.f14638a = i;
    }

    public int exitAnim() {
        return this.f14639b;
    }

    public void setExitAnim(int i) {
        this.f14639b = i;
    }

    public int enterPopAnim() {
        return this.f14640c;
    }

    public void setEnterPopAnim(int i) {
        this.f14640c = i;
    }

    public int exitPopAnim() {
        return this.f14641d;
    }

    public void setExitPopAnim(int i) {
        this.f14641d = i;
    }
}
