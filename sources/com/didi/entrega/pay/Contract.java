package com.didi.entrega.pay;

import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.app.nova.skeleton.mvp.IView;
import com.didi.entrega.pay.model.PayMethodInfoModel;
import java.util.List;

public interface Contract {

    public static abstract class AbsPayMethodPresenter extends IPresenter<AbsPayMethodView> {
        public abstract void onClick99Pay(PayMethodInfoModel payMethodInfoModel, int i);

        public abstract void onClickCardPay(PayMethodInfoModel payMethodInfoModel, PayMethodInfoModel.CardInfoModel cardInfoModel);

        public abstract void onClickCashPay(PayMethodInfoModel payMethodInfoModel);

        public abstract void onClickDidiCashPay(PayMethodInfoModel payMethodInfoModel);

        public abstract void onClickPayPay(PayMethodInfoModel payMethodInfoModel);

        public abstract void onClose();
    }

    public static abstract class AbsPayMethodView extends IView<AbsPayMethodPresenter> {
        public abstract void updateView(List<PayMethodInfoModel> list);
    }
}
