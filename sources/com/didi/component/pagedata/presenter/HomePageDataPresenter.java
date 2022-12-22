package com.didi.component.pagedata.presenter;

import android.content.Context;
import android.os.Bundle;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.HomeListener;
import com.didi.component.pagedata.AbsPageDataPresenter;

public class HomePageDataPresenter extends AbsPageDataPresenter {
    public HomePageDataPresenter(Context context) {
        super(context);
        PageCompDataTransfer.getInstance().setHomeListener(new HomeListener() {
        });
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        PageCompDataTransfer.getInstance().setHomeListener((HomeListener) null);
    }
}
