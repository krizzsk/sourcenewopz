package com.didiglobal.p205sa.biz.component.activity.model;

import android.view.View;
import com.didi.sdk.app.sapanel.ICardVisibleListener;
import com.google.gson.JsonObject;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.component.activity.model.ActivityProperty */
public class ActivityProperty {

    /* renamed from: a */
    private View f50734a;

    /* renamed from: b */
    private JsonObject f50735b;

    /* renamed from: c */
    private ActivityCardModel f50736c;

    /* renamed from: d */
    private String f50737d;

    /* renamed from: e */
    private String f50738e;

    /* renamed from: f */
    private ICardVisibleListener f50739f;

    /* renamed from: g */
    private Map<String, Object> f50740g;

    public ActivityCardModel getModel() {
        return this.f50736c;
    }

    public void setModel(ActivityCardModel activityCardModel) {
        this.f50736c = activityCardModel;
    }

    public String getTypeId() {
        return this.f50738e;
    }

    public void setTypeId(String str) {
        this.f50738e = str;
    }

    public View getView() {
        return this.f50734a;
    }

    public void setView(View view) {
        this.f50734a = view;
    }

    public JsonObject getData() {
        return this.f50735b;
    }

    public void setData(JsonObject jsonObject) {
        this.f50735b = jsonObject;
    }

    public String getId() {
        return this.f50737d;
    }

    public void setId(String str) {
        this.f50737d = str;
    }

    public ICardVisibleListener getListener() {
        return this.f50739f;
    }

    public void setListener(ICardVisibleListener iCardVisibleListener) {
        this.f50739f = iCardVisibleListener;
    }

    public Map<String, Object> getExtension() {
        return this.f50740g;
    }

    public void setExtension(Map<String, Object> map) {
        this.f50740g = map;
    }
}
