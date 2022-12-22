package com.didi.component.pagedata;

import android.content.Context;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.CommonListener;
import com.didi.component.core.IPresenter;
import com.didi.component.core.IView;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public abstract class AbsPageDataPresenter extends IPresenter<IView> {
    protected final Logger mLogger = LoggerFactory.getLogger(getClass());

    public AbsPageDataPresenter(Context context) {
        super(context);
        PageCompDataTransfer.getInstance().setCommonListener(new CommonListener() {
        });
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        PageCompDataTransfer.getInstance().setCommonListener((CommonListener) null);
    }
}
