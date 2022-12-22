package com.didi.component.routeguide;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.didi.component.common.view.card.GlobalTemplateCardModel;
import com.didi.component.common.view.card.GlobalTemplateCardView;

public class RouteGuideView implements IRouteGuideView {

    /* renamed from: a */
    private GlobalTemplateCardView f15354a;

    public void setPresenter(AbsRouteGuidePresenter absRouteGuidePresenter) {
    }

    public RouteGuideView(Context context, ViewGroup viewGroup) {
        this.f15354a = new GlobalTemplateCardView(context);
    }

    public View getView() {
        return this.f15354a;
    }

    public void updateData(RouteGuideData routeGuideData) {
        if (routeGuideData != null) {
            GlobalTemplateCardModel globalTemplateCardModel = new GlobalTemplateCardModel();
            globalTemplateCardModel.textAreaModel = new GlobalTemplateCardModel.TextAreaModel(routeGuideData.title, (String) null, routeGuideData.subTitle);
            globalTemplateCardModel.imageModel = new GlobalTemplateCardModel.ImageModel(routeGuideData.iconResId, routeGuideData.iconUrl, 70, 70, 2);
            globalTemplateCardModel.btnModel = new GlobalTemplateCardModel.BtnModel((String) null, routeGuideData.bottom, routeGuideData.listener);
        }
    }
}
