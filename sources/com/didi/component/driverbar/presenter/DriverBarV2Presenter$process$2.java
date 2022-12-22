package com.didi.component.driverbar.presenter;

import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.common.model.DataFieldWrapper;
import com.didi.component.driverbar.IDriverBarView;
import com.didi.component.driverbar.model.DriverBarCardInfo;
import com.didi.component.driverbar.model.DriverBarNormalData;
import com.didi.component.driverbar.model.DriverBarStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p242io.reactivex.Completable;
import p242io.reactivex.CompletableSource;
import p242io.reactivex.functions.Action;
import p242io.reactivex.functions.Function;

@Metadata(mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, mo175978d2 = {"<anonymous>", "Lio/reactivex/CompletableSource;", "kotlin.jvm.PlatformType", "cardInfo", "Lcom/didi/component/driverbar/model/DriverBarCardInfo;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DriverBarV2Presenter.kt */
final class DriverBarV2Presenter$process$2<T, R> implements Function {
    final /* synthetic */ IDriverBarView $view;
    final /* synthetic */ DriverBarV2Presenter this$0;

    DriverBarV2Presenter$process$2(DriverBarV2Presenter driverBarV2Presenter, IDriverBarView iDriverBarView) {
        this.this$0 = driverBarV2Presenter;
        this.$view = iDriverBarView;
    }

    public final CompletableSource apply(final DriverBarCardInfo driverBarCardInfo) {
        Intrinsics.checkNotNullParameter(driverBarCardInfo, "cardInfo");
        final DriverBarV2Presenter driverBarV2Presenter = this.this$0;
        final IDriverBarView iDriverBarView = this.$view;
        return Completable.fromAction(new Action() {
            public final void run() {
                driverBarV2Presenter.f13004c = driverBarCardInfo;
                DataFieldWrapper<DriverBarNormalData> normal = driverBarCardInfo.getNormal();
                DriverBarStyle driverBarStyle = null;
                DriverBarNormalData data = normal == null ? null : normal.getData();
                if (data != null) {
                    driverBarStyle = data.getCardStyle();
                }
                if (driverBarStyle == null) {
                    driverBarStyle = DriverBarStyle.DEFAULT_STYLE;
                }
                driverBarV2Presenter.f13005d = driverBarStyle;
                iDriverBarView.setDriverBarStyle(driverBarStyle);
                if (driverBarStyle == DriverBarStyle.JAPAN_STYLE && !GlobalApolloUtil.isJpnPhoneEntranceEnable()) {
                    iDriverBarView.setPhoneVisible(false);
                }
                iDriverBarView.setData(driverBarCardInfo);
            }
        });
    }
}
