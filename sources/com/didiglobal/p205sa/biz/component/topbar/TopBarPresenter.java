package com.didiglobal.p205sa.biz.component.topbar;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.ComponentPresenterImpl;
import com.didi.sdk.sidebar.SidebarEvent;
import com.didi.sdk.util.EventKeys;
import com.didiglobal.p205sa.biz.component.sapanel.PanelAnimatorMgr;
import com.didiglobal.p205sa.biz.component.sapanel.model.AnimationModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0006\u0010\u0011\u001a\u00020\u000bJ\b\u0010\u0012\u001a\u00020\u000bH\u0016R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0013"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/topbar/TopBarPresenter;", "Lcom/didi/component/never/core/ComponentPresenterImpl;", "Lcom/didiglobal/sa/biz/component/topbar/TopBarView;", "Lcom/didiglobal/sa/biz/component/sapanel/PanelAnimatorMgr$AnimationListener;", "params", "Lcom/didi/component/never/core/ComponentParams;", "(Lcom/didi/component/never/core/ComponentParams;)V", "mTopBarHeight", "", "Ljava/lang/Integer;", "onAdd", "", "arguments", "Landroid/os/Bundle;", "onAnimationProcess", "model", "Lcom/didiglobal/sa/biz/component/sapanel/model/AnimationModel;", "onMenuClick", "onRemove", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.topbar.TopBarPresenter */
/* compiled from: TopBarPresenter.kt */
public final class TopBarPresenter extends ComponentPresenterImpl<TopBarView> implements PanelAnimatorMgr.AnimationListener {

    /* renamed from: a */
    private Integer f51183a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopBarPresenter(ComponentParams componentParams) {
        super(componentParams);
        Intrinsics.checkNotNullParameter(componentParams, "params");
    }

    public final void onMenuClick() {
        EventBus.getDefault().post(new SidebarEvent(EventKeys.Sidebar.OPEN_SIDEBAR));
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        PanelAnimatorMgr.addAnimationListener(this);
    }

    public void onRemove() {
        super.onRemove();
        PanelAnimatorMgr.removeListener(this);
    }

    public void onAnimationProcess(AnimationModel animationModel) {
        Intrinsics.checkNotNullParameter(animationModel, "model");
        Integer num = null;
        if (this.f51183a == null) {
            View view = ((TopBarView) this.mView).getView();
            this.f51183a = view == null ? null : Integer.valueOf(view.getHeight());
        }
        View view2 = ((TopBarView) this.mView).getView();
        ViewGroup.LayoutParams layoutParams = view2 == null ? null : view2.getLayoutParams();
        if (animationModel.isExpand()) {
            if (layoutParams != null) {
                Integer num2 = this.f51183a;
                if (num2 != null) {
                    num = Integer.valueOf((int) (((float) num2.intValue()) * (((float) 1) - animationModel.getFraction())));
                }
                layoutParams.height = num.intValue();
            }
        } else if (layoutParams != null) {
            Integer num3 = this.f51183a;
            if (num3 != null) {
                num = Integer.valueOf((int) (((float) num3.intValue()) * animationModel.getFraction()));
            }
            layoutParams.height = num.intValue();
        }
    }
}
