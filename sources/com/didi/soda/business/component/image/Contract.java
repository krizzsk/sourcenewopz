package com.didi.soda.business.component.image;

import com.didi.soda.business.component.home.PreviewImageModel;
import com.didi.soda.customer.base.ICustomerPresenter;
import com.didi.soda.customer.base.ICustomerView;

public interface Contract {

    public static abstract class AbsBusinessImagePresenter extends ICustomerPresenter<AbsBusinessImageView> {
        public abstract void clickAddBtn(PreviewImageModel previewImageModel);

        public abstract void finish(int i);

        public abstract void onBigImageSw(PreviewImageModel previewImageModel);
    }

    public static abstract class AbsBusinessImageView extends ICustomerView<AbsBusinessImagePresenter> {
        public abstract void updateView(PreviewImageModel previewImageModel);
    }
}
