package com.didi.component.unenablecity.impl;

import android.os.Bundle;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.BusinessUtils;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.common.util.ApkUtils;
import com.didi.component.common.view.card.GlobalTemplateCardModel;
import com.didi.component.core.ComponentParams;
import com.didi.component.unenablecity.AbsUnableCityPresenter;
import com.didi.component.unenablecity.IUnableCityContainerView;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;

public class ConfirmUnableCityPresenter extends AbsUnableCityPresenter {

    /* renamed from: a */
    private View.OnClickListener f16175a = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            ConfirmUnableCityPresenter.this.goBackRoot();
        }
    };

    public ConfirmUnableCityPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m11865b();
    }

    /* renamed from: b */
    private void m11865b() {
        ((IUnableCityContainerView) this.mView).showUnopenedCityView();
        GlobalTemplateCardModel globalTemplateCardModel = new GlobalTemplateCardModel();
        if (BusinessUtils.isStopService(this.mBizContext)) {
            globalTemplateCardModel.textAreaModel = new GlobalTemplateCardModel.TextAreaModel(GlobalApolloUtil.getStopServiceConfirmText(this.mContext), (String) null, (String) null, 4);
            globalTemplateCardModel.newBtnModel = new GlobalTemplateCardModel.NewBtnModel(this.mContext.getResources().getString(R.string.global_unenbale_city_back_home), this.f16175a);
        } else {
            globalTemplateCardModel.textAreaModel = new GlobalTemplateCardModel.TextAreaModel(ResourcesHelper.getString(this.mContext, R.string.global_unenable_city_title, ApkUtils.getAppName(this.mContext)), (String) null, ResourcesHelper.getString(this.mContext, R.string.global_unenbale_city_confirm_content));
            globalTemplateCardModel.btnModel = new GlobalTemplateCardModel.BtnModel((String) null, ResourcesHelper.getString(this.mContext, R.string.global_unenbale_city_confirm), (View.OnClickListener) null);
        }
        globalTemplateCardModel.setCardBackGround(R.color.white);
        ((IUnableCityContainerView) this.mView).setData(globalTemplateCardModel);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
    }
}
