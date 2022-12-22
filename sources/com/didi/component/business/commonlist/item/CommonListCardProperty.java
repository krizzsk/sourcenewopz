package com.didi.component.business.commonlist.item;

import android.view.View;
import java.util.Map;

public class CommonListCardProperty {

    /* renamed from: a */
    private View f11186a;

    /* renamed from: b */
    private String f11187b;

    /* renamed from: c */
    private String f11188c;

    /* renamed from: d */
    private Map<String, Object> f11189d;

    public String getId() {
        return this.f11187b;
    }

    public void setId(String str) {
        this.f11187b = str;
    }

    public View getView() {
        return this.f11186a;
    }

    public void setView(View view) {
        this.f11186a = view;
    }

    public Map<String, Object> getExtension() {
        return this.f11189d;
    }

    public void setExtension(Map<String, Object> map) {
        this.f11189d = map;
    }

    public String getTemplate() {
        return this.f11188c;
    }

    public void setTemplate(String str) {
        this.f11188c = str;
    }
}
