package com.didiglobal.eevee.mew.widget;

import android.content.Context;
import android.view.View;
import com.didiglobal.enginecore.template.temp.IXEView;

public class VpTemplateView implements IXEView<VpTemplateModel> {

    /* renamed from: a */
    private VpTemplateFrameLayout f50086a;

    public void initView(Context context) {
        this.f50086a = new VpTemplateFrameLayout(context);
    }

    public void bindData(VpTemplateModel vpTemplateModel) {
        this.f50086a.bindData(vpTemplateModel);
    }

    public View getView() {
        return this.f50086a;
    }
}
