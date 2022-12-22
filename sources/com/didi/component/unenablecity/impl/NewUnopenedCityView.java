package com.didi.component.unenablecity.impl;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.component.common.view.card.GlobalTemplateCardModel;
import com.didi.component.common.view.card.GlobalTemplateCardView;
import com.didi.component.unenablecity.AbsUnableCityPresenter;
import com.didi.component.unenablecity.IUnopenedCityView;
import com.taxis99.R;

public class NewUnopenedCityView implements IUnopenedCityView {

    /* renamed from: a */
    private View f16180a;

    /* renamed from: b */
    private GlobalTemplateCardView f16181b;

    public void setPresenter(AbsUnableCityPresenter absUnableCityPresenter) {
    }

    public NewUnopenedCityView(Activity activity, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.global_new_unable_city_layout, viewGroup);
        this.f16180a = inflate;
        this.f16181b = (GlobalTemplateCardView) inflate.findViewById(R.id.xphb_global_unenable_cardView);
    }

    public View getView() {
        return this.f16181b;
    }

    public void setData(GlobalTemplateCardModel globalTemplateCardModel) {
        this.f16181b.setData(globalTemplateCardModel);
    }
}
