package com.didi.component.framework.pages.promo.fragment;

import com.didi.component.framework.pages.promo.PromoCodePage;
import com.didi.component.framework.pages.promo.model.PromoData;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.view.fragment.PlatformClickListener;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J(\u0010\r\u001a\u00020\u00032\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0003H&¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/component/framework/pages/promo/fragment/ActionListener;", "Ljava/io/Serializable;", "addRspData", "", "rspData", "Lcom/didi/component/framework/pages/promo/model/PromoData;", "getRspData", "onBackArrowClick", "page", "Lcom/didi/component/framework/pages/promo/PromoCodePage;", "showDialog", "msg", "", "showShareDialog", "info", "Ljava/util/ArrayList;", "Lcom/didi/onekeyshare/entity/OneKeyShareInfo;", "Lkotlin/collections/ArrayList;", "callback", "Lcom/didi/onekeyshare/view/fragment/PlatformClickListener;", "switchToSharePage", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ActionListener.kt */
public interface ActionListener extends Serializable {
    void addRspData(PromoData promoData);

    PromoData getRspData();

    void onBackArrowClick(PromoCodePage promoCodePage);

    void showDialog(String str);

    void showShareDialog(ArrayList<OneKeyShareInfo> arrayList, PlatformClickListener platformClickListener);

    void switchToSharePage();
}
