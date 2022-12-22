package com.component.android.comp_location.presenter;

import android.os.Bundle;
import android.view.View;
import com.component.android.comp_location.AbsGlobalLocationPresenter;
import com.component.android.comp_location.IGlobalLocationView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.common.map.util.DLog;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.ComponentParams;

public class GlobalUpdatePickUpLocationPresenter extends AbsGlobalLocationPresenter {

    /* renamed from: a */
    private int f3302a = 0;

    /* access modifiers changed from: protected */
    public void hideResetView() {
    }

    /* access modifiers changed from: protected */
    public void showResetView() {
    }

    public GlobalUpdatePickUpLocationPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
        requestMapLayout();
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        ((IGlobalLocationView) this.mView).setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        super.onClick(view);
    }

    public void onXPanelDefaultHeightChanged(int i) {
        if (this.f3302a == 0) {
            DLog.m7384d("GlobalUpdatePickUpLocationPresenter", "height=0", new Object[0]);
            this.f3302a = i;
            super.onXPanelDefaultHeightChanged(i);
        }
        DLog.m7384d("GlobalUpdatePickUpLocationPresenter", "height=+" + i, new Object[0]);
        doPublish(BaseEventKeys.Confirm.EVENT_UPDATE_PICK_UP_XPANEL_HEIGHT_CHANGED, Integer.valueOf(i));
    }
}
