package com.didiglobal.p205sa.biz.component.sapanel.model;

import android.view.View;
import com.didi.sdk.app.sapanel.ICardVisibleListener;
import com.didiglobal.p205sa.biz.component.sapanel.interfaces.ICardPosition;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.model.SACardProperty */
public class SACardProperty {

    /* renamed from: a */
    private View f51103a;

    /* renamed from: b */
    private String f51104b;

    /* renamed from: c */
    private ICardVisibleListener f51105c;

    /* renamed from: d */
    private ICardPosition f51106d;

    /* renamed from: e */
    private boolean f51107e;

    /* renamed from: f */
    private Map<String, Object> f51108f;

    public void setListener(ICardVisibleListener iCardVisibleListener) {
        this.f51105c = iCardVisibleListener;
    }

    public ICardVisibleListener getListener() {
        return this.f51105c;
    }

    public void setPosition(ICardPosition iCardPosition) {
        this.f51106d = iCardPosition;
    }

    public ICardPosition getPosition() {
        return this.f51106d;
    }

    public String getId() {
        return this.f51104b;
    }

    public void setId(String str) {
        this.f51104b = str;
    }

    public View getView() {
        return this.f51103a;
    }

    public void setView(View view) {
        this.f51103a = view;
    }

    public void setTransparent(boolean z) {
        this.f51107e = z;
    }

    public boolean isTransparent() {
        return this.f51107e;
    }

    public Map<String, Object> getExtension() {
        return this.f51108f;
    }

    public void setExtension(Map<String, Object> map) {
        this.f51108f = map;
    }
}
