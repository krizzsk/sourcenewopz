package com.didi.soda.order.component.preview;

import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.order.component.preview.Contract;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0014¨\u0006\b"}, mo175978d2 = {"Lcom/didi/soda/order/component/preview/EvaluatePreviewImagePresenter;", "Lcom/didi/soda/order/component/preview/Contract$AbsEvaluateImagePresenter;", "()V", "finish", "", "clickType", "", "onCreate", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EvaluatePreviewImagePresenter.kt */
public final class EvaluatePreviewImagePresenter extends Contract.AbsEvaluateImagePresenter {
    public void finish(int i) {
        getScopeContext().getNavigator().finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        int i = getScopeContext().getBundle().getInt(Const.PageParams.PREVIEW_IMAGE_WIDTH);
        String string = getScopeContext().getBundle().getString(Const.PageParams.PREVIEW_IMAGE_URL);
        String string2 = getScopeContext().getBundle().getString(Const.PageParams.LOCAL_PREVIEW_IMAGE);
        Contract.AbsEvaluateImageView absEvaluateImageView = (Contract.AbsEvaluateImageView) getLogicView();
        if (absEvaluateImageView != null) {
            absEvaluateImageView.updateView(i, string2, string);
        }
    }
}
