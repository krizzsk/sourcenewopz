package com.didi.component.homedestination.newversion.p102b;

import android.view.View;
import com.didi.component.homedestination.newversion.AbsNewUiPresenter;
import com.didi.component.homedestination.newversion.AbsNewUiView;

/* renamed from: com.didi.component.homedestination.newversion.b.IHomeDestinationPlantBNewView */
public interface IHomeDestinationPlantBNewView<T extends AbsNewUiPresenter> extends AbsNewUiView<T> {

    /* renamed from: com.didi.component.homedestination.newversion.b.IHomeDestinationPlantBNewView$IClickCallBack */
    public interface IClickCallBack {
        void clickWhereToGo();
    }

    void hideCouponAssistant();

    void setClickListener(IClickCallBack iClickCallBack);

    void showCouponAssistant(View view);
}
