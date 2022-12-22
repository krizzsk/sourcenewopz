package com.didi.soda.goodsV2.component.multilevel;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;

public class GoodsMultiLevelComponent extends MvpComponent<C13945b, C13944a> {

    /* renamed from: a */
    private C13944a f42442a;

    public GoodsMultiLevelComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public void onPageResult(Bundle bundle) {
        C13944a aVar = this.f42442a;
        if (aVar != null) {
            aVar.onPageResult(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public C13945b onCreateView() {
        return new C13945b();
    }

    /* access modifiers changed from: protected */
    public C13944a onCreatePresenter() {
        C13944a aVar = new C13944a();
        this.f42442a = aVar;
        return aVar;
    }
}
