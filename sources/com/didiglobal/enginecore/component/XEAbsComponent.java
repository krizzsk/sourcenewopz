package com.didiglobal.enginecore.component;

import android.view.View;
import org.json.JSONObject;

public abstract class XEAbsComponent {

    /* renamed from: a */
    private JSONObject f50154a;

    /* renamed from: b */
    private boolean f50155b = false;

    /* renamed from: id */
    protected String f50156id;
    protected View mView;

    public abstract String getId();

    public boolean isDefered() {
        return this.f50155b;
    }

    public void setDefered(boolean z) {
        this.f50155b = z;
    }

    public View getView() {
        return this.mView;
    }

    public void setView(View view) {
        this.mView = view;
    }

    public JSONObject getData() {
        return this.f50154a;
    }

    public void setData(JSONObject jSONObject) {
        this.f50154a = jSONObject;
    }

    public String toString() {
        return "XEComponent{ getId=" + getId() + ", mView=" + this.mView + ", data=" + this.f50154a + ", defered=" + this.f50155b + " }";
    }
}
