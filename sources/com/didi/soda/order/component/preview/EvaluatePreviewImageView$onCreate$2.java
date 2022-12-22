package com.didi.soda.order.component.preview;

import com.didi.soda.business.component.image.GestureDetector;
import com.didi.soda.order.component.preview.Contract;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, mo175978d2 = {"com/didi/soda/order/component/preview/EvaluatePreviewImageView$onCreate$2", "Lcom/didi/soda/business/component/image/GestureDetector$OnGestureListener;", "onClick", "", "onGlide", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EvaluatePreviewImageView.kt */
public final class EvaluatePreviewImageView$onCreate$2 implements GestureDetector.OnGestureListener {
    final /* synthetic */ EvaluatePreviewImageView this$0;

    EvaluatePreviewImageView$onCreate$2(EvaluatePreviewImageView evaluatePreviewImageView) {
        this.this$0 = evaluatePreviewImageView;
    }

    public void onGlide() {
        Contract.AbsEvaluateImagePresenter absEvaluateImagePresenter = (Contract.AbsEvaluateImagePresenter) this.this$0.getPresenter();
        if (absEvaluateImagePresenter != null) {
            absEvaluateImagePresenter.finish(1);
        }
    }

    public void onClick() {
        Contract.AbsEvaluateImagePresenter absEvaluateImagePresenter = (Contract.AbsEvaluateImagePresenter) this.this$0.getPresenter();
        if (absEvaluateImagePresenter != null) {
            absEvaluateImagePresenter.finish(2);
        }
    }
}
