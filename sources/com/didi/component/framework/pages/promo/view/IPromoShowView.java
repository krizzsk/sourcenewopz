package com.didi.component.framework.pages.promo.view;

import android.view.View;
import com.didi.component.core.IView;
import com.didi.component.framework.pages.promo.model.PromoData;
import com.didi.component.framework.pages.promo.presenter.PromoShowPresenter;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J8\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\b2&\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\r0\fj\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\r`\u000eH&J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\b\u0010\u0012\u001a\u00020\u0005H&¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/component/framework/pages/promo/view/IPromoShowView;", "Lcom/didi/component/core/IView;", "Lcom/didi/component/framework/pages/promo/presenter/PromoShowPresenter;", "Landroid/view/View$OnClickListener;", "hideLoadingView", "", "onApplyError", "msg", "", "onApplyH5Success", "url", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "onApplySuccess", "rspData", "Lcom/didi/component/framework/pages/promo/model/PromoData;", "showLoadingView", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IPromoShowView.kt */
public interface IPromoShowView extends View.OnClickListener, IView<PromoShowPresenter> {
    void hideLoadingView();

    void onApplyError(String str);

    void onApplyH5Success(String str, HashMap<String, Object> hashMap);

    void onApplySuccess(PromoData promoData);

    void showLoadingView();
}
