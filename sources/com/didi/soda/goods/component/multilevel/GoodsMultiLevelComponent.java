package com.didi.soda.goods.component.multilevel;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;

public class GoodsMultiLevelComponent extends MvpComponent<C13916b, C13915a> {

    /* renamed from: a */
    private C13915a f42354a;

    public GoodsMultiLevelComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public void onPageResult(Bundle bundle) {
        C13915a aVar = this.f42354a;
        if (aVar != null) {
            aVar.onPageResult(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public C13916b onCreateView() {
        return new C13916b();
    }

    /* access modifiers changed from: protected */
    public C13915a onCreatePresenter() {
        C13915a aVar = new C13915a();
        this.f42354a = aVar;
        return aVar;
    }
}
