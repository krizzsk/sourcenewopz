package com.didi.component.core;

import com.taxis99.R;

public class Animations {

    /* renamed from: a */
    private int f12728a;

    /* renamed from: b */
    private int f12729b;

    /* renamed from: c */
    private int f12730c;

    /* renamed from: d */
    private int f12731d;

    public Animations() {
        this.f12728a = R.anim.comp_fragment_enter;
        this.f12729b = R.anim.comp_fragment_exit;
        this.f12730c = R.anim.comp_fragment_pop_enter;
        this.f12731d = R.anim.comp_fragment_pop_exit;
    }

    public Animations(int i, int i2, int i3, int i4) {
        this.f12728a = i;
        this.f12729b = i2;
        this.f12730c = i3;
        this.f12731d = i4;
    }

    public int enterAnim() {
        return this.f12728a;
    }

    public void setEnterAnim(int i) {
        this.f12728a = i;
    }

    public int exitAnim() {
        return this.f12729b;
    }

    public void setExitAnim(int i) {
        this.f12729b = i;
    }

    public int enterPopAnim() {
        return this.f12730c;
    }

    public void setEnterPopAnim(int i) {
        this.f12730c = i;
    }

    public int exitPopAnim() {
        return this.f12731d;
    }

    public void setExitPopAnim(int i) {
        this.f12731d = i;
    }
}
