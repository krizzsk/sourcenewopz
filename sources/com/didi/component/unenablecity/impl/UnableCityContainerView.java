package com.didi.component.unenablecity.impl;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.common.view.card.GlobalTemplateCardModel;
import com.didi.component.unenablecity.AbsUnableCityPresenter;
import com.didi.component.unenablecity.INoOpenPositionView;
import com.didi.component.unenablecity.IOrderBanView;
import com.didi.component.unenablecity.IPreheatCityView;
import com.didi.component.unenablecity.IUnableCityContainerView;
import com.didi.component.unenablecity.IUnopenedCityView;
import com.didi.component.unenablecity.utils.HomeCardOmegaUtils;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.model.response.OrderBanCardInfo;
import com.didi.travel.psnger.model.response.SafetyTrainCardInfo;
import com.taxis99.R;

public class UnableCityContainerView implements IUnableCityContainerView {

    /* renamed from: a */
    private static final int f16199a = 1;

    /* renamed from: b */
    private static final int f16200b = 2;

    /* renamed from: c */
    private static final int f16201c = 3;

    /* renamed from: d */
    private static final int f16202d = 4;

    /* renamed from: e */
    private static final int f16203e = 5;

    /* renamed from: f */
    private int f16204f = 0;

    /* renamed from: g */
    private Activity f16205g;

    /* renamed from: h */
    private ViewGroup f16206h;

    /* renamed from: i */
    private AbsUnableCityPresenter f16207i;

    /* renamed from: j */
    private IUnopenedCityView f16208j;

    /* renamed from: k */
    private IPreheatCityView f16209k;

    /* renamed from: l */
    private IOrderBanView f16210l;

    /* renamed from: m */
    private SafetyTrainView f16211m;

    /* renamed from: n */
    private INoOpenPositionView f16212n;

    public UnableCityContainerView(Activity activity, ViewGroup viewGroup) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(ResourcesHelper.getColor(activity, R.color.trans));
        this.f16206h = linearLayout;
        this.f16205g = activity;
    }

    public void setPresenter(AbsUnableCityPresenter absUnableCityPresenter) {
        this.f16207i = absUnableCityPresenter;
    }

    public View getView() {
        return this.f16206h;
    }

    public void showUnopenedCityView() {
        m11880a();
        NewUnopenedCityView newUnopenedCityView = new NewUnopenedCityView(this.f16205g, this.f16206h);
        this.f16208j = newUnopenedCityView;
        newUnopenedCityView.setPresenter(this.f16207i);
        this.f16204f = 1;
    }

    public void showNoOpenPositionView() {
        m11880a();
        NoOpenPositionView noOpenPositionView = new NoOpenPositionView(this.f16205g, this.f16206h);
        this.f16212n = noOpenPositionView;
        noOpenPositionView.setPresenter(this.f16207i);
        this.f16204f = 5;
    }

    public void showPreheatView() {
        m11880a();
        NewPreheatCityView newPreheatCityView = new NewPreheatCityView(this.f16205g, this.f16206h);
        this.f16209k = newPreheatCityView;
        newPreheatCityView.setPresenter(this.f16207i);
        this.f16204f = 2;
    }

    public void showOrderBanView(OrderBanCardInfo orderBanCardInfo, BusinessContext businessContext) {
        m11880a();
        OrderBanView orderBanView = new OrderBanView(this.f16205g, this.f16206h, businessContext);
        this.f16210l = orderBanView;
        orderBanView.setOrderBanCardInfo(orderBanCardInfo);
        this.f16210l.setPresenter(this.f16207i);
        HomeCardOmegaUtils.sendUnableCityCardSw(HomeCardOmegaUtils.CARD_ID_ORDER_BAN);
        this.f16204f = 3;
    }

    public boolean showSafetyTrainView(SafetyTrainCardInfo safetyTrainCardInfo) {
        if (FormStore.getInstance().isOrderBan() && this.f16204f == 3) {
            return false;
        }
        m11880a();
        SafetyTrainView safetyTrainView = new SafetyTrainView(this.f16205g, this.f16206h);
        this.f16211m = safetyTrainView;
        safetyTrainView.setSafetyTrainCardInfo(safetyTrainCardInfo);
        this.f16211m.setPresenter(this.f16207i);
        HomeCardOmegaUtils.sendUnableCityCardSw(HomeCardOmegaUtils.CARD_ID_EDU);
        this.f16204f = 4;
        return true;
    }

    public boolean hideSafetyTrainView() {
        if (this.f16211m == null || this.f16204f != 4) {
            return false;
        }
        m11880a();
        return true;
    }

    public void cleanType() {
        this.f16204f = 0;
    }

    /* renamed from: a */
    private void m11880a() {
        this.f16206h.removeAllViews();
        this.f16208j = null;
        this.f16209k = null;
        this.f16210l = null;
        this.f16211m = null;
        this.f16212n = null;
    }

    public void setTitle(CharSequence charSequence) {
        IPreheatCityView iPreheatCityView = this.f16209k;
        if (iPreheatCityView != null) {
            iPreheatCityView.setTitle(charSequence);
        }
    }

    public void setContent(CharSequence charSequence) {
        IPreheatCityView iPreheatCityView = this.f16209k;
        if (iPreheatCityView != null) {
            iPreheatCityView.setContent(charSequence);
        }
    }

    public void showImage(String str) {
        IPreheatCityView iPreheatCityView = this.f16209k;
        if (iPreheatCityView != null) {
            iPreheatCityView.showImage(str);
        }
    }

    public void showImage(int i) {
        IPreheatCityView iPreheatCityView = this.f16209k;
        if (iPreheatCityView != null) {
            iPreheatCityView.showImage(i);
        }
    }

    public void setData(GlobalTemplateCardModel globalTemplateCardModel) {
        IUnopenedCityView iUnopenedCityView = this.f16208j;
        if (iUnopenedCityView != null) {
            iUnopenedCityView.setData(globalTemplateCardModel);
        }
    }

    public void setNoPositionEnableListener(View.OnClickListener onClickListener) {
        INoOpenPositionView iNoOpenPositionView = this.f16212n;
        if (iNoOpenPositionView != null) {
            iNoOpenPositionView.setNoPositionEnableListener(onClickListener);
        }
    }

    public void setNoPositionManualEnterListener(View.OnClickListener onClickListener) {
        INoOpenPositionView iNoOpenPositionView = this.f16212n;
        if (iNoOpenPositionView != null) {
            iNoOpenPositionView.setNoPositionManualEnterListener(onClickListener);
        }
    }
}
