package com.didiglobal.xpanelnew.base;

import android.view.View;
import java.util.Map;

public class XpCardProperty {

    /* renamed from: a */
    private View f51601a;

    /* renamed from: b */
    private String f51602b;

    /* renamed from: c */
    private Map<String, Object> f51603c;

    public String getId() {
        return this.f51602b;
    }

    public void setId(String str) {
        this.f51602b = str;
    }

    public View getView() {
        return this.f51601a;
    }

    public void setView(View view) {
        this.f51601a = view;
    }

    public Map<String, Object> getExtension() {
        return this.f51603c;
    }

    public void setExtension(Map<String, Object> map) {
        this.f51603c = map;
    }
}
