package com.didi.component.framework.pages.promo.view;

import com.didi.component.core.IView;
import com.didi.component.framework.pages.promo.model.PromoShareBtnModel;
import com.didi.component.framework.pages.promo.model.PromoShareItem;
import com.didi.component.framework.pages.promo.presenter.PromoSharePresenter;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.view.fragment.PlatformClickListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH&J\u001e\u0010\u000b\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0016\u0010\u0011\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006H&¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/component/framework/pages/promo/view/IPromoShareView;", "Lcom/didi/component/core/IView;", "Lcom/didi/component/framework/pages/promo/presenter/PromoSharePresenter;", "initRecyclerView", "", "list", "", "Lcom/didi/component/framework/pages/promo/model/PromoShareItem;", "isShowShareBottomView", "isShow", "", "showShareDialog", "info", "Ljava/util/ArrayList;", "Lcom/didi/onekeyshare/entity/OneKeyShareInfo;", "callback", "Lcom/didi/onekeyshare/view/fragment/PlatformClickListener;", "showSomeShareChannel", "Lcom/didi/component/framework/pages/promo/model/PromoShareBtnModel;", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IPromoShareView.kt */
public interface IPromoShareView extends IView<PromoSharePresenter> {
    void initRecyclerView(List<PromoShareItem> list);

    void isShowShareBottomView(boolean z);

    void showShareDialog(ArrayList<OneKeyShareInfo> arrayList, PlatformClickListener platformClickListener);

    void showSomeShareChannel(List<PromoShareBtnModel> list);
}
