package com.didiglobal.p205sa.biz.component.sapanel.view;

import android.content.Context;
import android.graphics.Color;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.sdk.util.SaApolloUtil;
import com.didi.unifiedPay.util.UIUtils;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.didiglobal.p205sa.biz.tab.manager.SaTabUserCenterDemoteManager;
import com.taxis99.R;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.view.PanelItemContainer */
public class PanelItemContainer extends SaShadowCard {

    /* renamed from: a */
    private int f51136a;

    /* renamed from: b */
    private String f51137b;

    public PanelItemContainer(String str, int i, Context context) {
        super(context);
        this.f51137b = str;
        this.f51136a = i;
        if (ComponentType.COMPONENT_RIDE_CARD.equals(str)) {
            setTag(ComponentType.COMPONENT_RIDE_CARD);
        }
        m36638a();
    }

    /* renamed from: a */
    private void m36638a() {
        int i;
        int i2;
        int i3;
        int dimension = (int) getContext().getResources().getDimension(R.dimen.view_padding);
        int dimension2 = (int) getContext().getResources().getDimension(R.dimen.view_padding);
        getContext().getResources().getDimension(R.dimen.view_padding);
        if (this.f51136a == 0) {
            i3 = Color.parseColor("#808E959C");
            if (!SaApolloUtil.INSTANCE.getSaOneState()) {
                i2 = UiUtils.dip2px(getContext(), 14.0f);
            } else if (SaTabUserCenterDemoteManager.INSTANCE.hideUserCenter()) {
                i2 = UiUtils.dip2px(getContext(), 14.0f);
            } else {
                i2 = UiUtils.dip2px(getContext(), 36.0f) + UIUtils.getStatusBarHeight(getContext());
            }
            i = UiUtils.dip2px(getContext(), 30.0f);
            setShadowLimit(UiUtils.dip2px(getContext(), 30.0f));
        } else {
            i3 = Color.parseColor("#4D89A2AE");
            i = UiUtils.dip2px(getContext(), 30.0f);
            setShadowLimit(UiUtils.dip2px(getContext(), 20.0f));
            i2 = 0;
        }
        if (ComponentType.COMPONENT_RECOMMEND.equals(this.f51137b) || ComponentType.COMPONENT_BUSINESS_CARD.equals(this.f51137b)) {
            setShowShadow(false);
            dimension = 0;
            dimension2 = 0;
        }
        if (ComponentType.COMPONENT_HOME_MSG.equals(this.f51137b)) {
            i = UiUtils.dip2px(getContext(), 10.0f);
            setShadowLimit(UiUtils.dip2px(getContext(), 10.0f));
        }
        if (ComponentType.COMPONENT_BUSINESS_CARD.equals(this.f51137b)) {
            i2 -= UiUtils.dip2px(getContext(), 10.0f);
            i -= UiUtils.dip2px(getContext(), 17.0f);
        }
        if (ComponentType.COMPONENT_BIZ_CARD.equals(this.f51137b)) {
            i = UiUtils.dip2px(getContext(), 16.0f);
            setShowShadow(false);
        }
        setPadding(dimension, i2, dimension2, i);
        setmShadowColor(i3);
    }
}
