package com.didi.component.travelGroupInfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.component.core.IViewContainer;
import com.taxis99.R;

public class TravelGroupInfoViewV2 implements IViewContainer, ITravelGroupInfoViewV2 {

    /* renamed from: a */
    private View f16146a;

    /* renamed from: b */
    private AbsTravelGroupInfoPresenterV2 f16147b;

    public TravelGroupInfoViewV2(Context context, ViewGroup viewGroup) {
        this.f16146a = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.layout_travel_group_info_v2, viewGroup, false);
    }

    public View getView() {
        return this.f16146a;
    }

    public void setPresenter(AbsTravelGroupInfoPresenterV2 absTravelGroupInfoPresenterV2) {
        this.f16147b = absTravelGroupInfoPresenterV2;
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        AbsTravelGroupInfoPresenterV2 absTravelGroupInfoPresenterV2 = this.f16147b;
        if (absTravelGroupInfoPresenterV2 != null) {
            absTravelGroupInfoPresenterV2.setComponentCreator(iComponentCreator);
        }
    }
}
