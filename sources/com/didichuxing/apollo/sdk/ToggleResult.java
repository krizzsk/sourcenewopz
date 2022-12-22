package com.didichuxing.apollo.sdk;

public class ToggleResult {

    /* renamed from: a */
    private int f45600a = 0;

    /* renamed from: b */
    private IToggle f45601b;

    public ToggleResult(int i, IToggle iToggle) {
        this.f45600a = i;
        this.f45601b = iToggle;
    }

    public int getErrorNo() {
        return this.f45600a;
    }

    public void setErrorNo(int i) {
        this.f45600a = i;
    }

    public IToggle getToggle() {
        return this.f45601b;
    }

    public void setToggle(IToggle iToggle) {
        this.f45601b = iToggle;
    }
}
