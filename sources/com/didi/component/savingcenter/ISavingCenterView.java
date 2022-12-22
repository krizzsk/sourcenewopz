package com.didi.component.savingcenter;

import com.didi.component.core.IView;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H&J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0017\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0002\u0010\u000fJ\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u0014\u001a\u00020\u0004H&J\u0017\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0002\u0010\u000f¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/component/savingcenter/ISavingCenterView;", "Lcom/didi/component/core/IView;", "Lcom/didi/component/savingcenter/AbsSavingCenterPresenter;", "hideSideText", "", "setIcon", "url", "", "setScanVisible", "isShow", "", "deepLink", "setShowTime", "showTime", "", "(Ljava/lang/Integer;)V", "setSideText", "scSideText", "Lcom/didi/travel/psnger/model/response/GlobalRichInfo;", "setVisible", "showDefaultIcon", "showSideText", "hideDelay", "comp-savingcenter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ISavingCenterView.kt */
public interface ISavingCenterView extends IView<AbsSavingCenterPresenter> {
    void hideSideText();

    void setIcon(String str);

    void setScanVisible(boolean z, String str);

    void setShowTime(Integer num);

    void setSideText(GlobalRichInfo globalRichInfo);

    void setVisible(boolean z);

    void showDefaultIcon();

    void showSideText(Integer num);
}
