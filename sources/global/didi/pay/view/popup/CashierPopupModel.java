package global.didi.pay.view.popup;

import android.view.View;
import global.didi.pay.view.popup.model.CashierBubbleArrow;
import global.didi.pay.view.popup.model.CashierBubbleBaseModel;
import global.didi.pay.view.popup.model.CashierTextModel;

class CashierPopupModel {
    public CashierBubbleArrow arrow;
    public String background_color;
    public int cancelable;
    public View.OnClickListener closeListener;
    public String icon;
    public CashierTextModel text;
    public String url;

    CashierPopupModel(CashierBubbleBaseModel cashierBubbleBaseModel, View.OnClickListener onClickListener) {
        this.text = cashierBubbleBaseModel.text;
        this.icon = cashierBubbleBaseModel.icon;
        this.cancelable = cashierBubbleBaseModel.cancelable;
        this.background_color = cashierBubbleBaseModel.background_color;
        this.url = cashierBubbleBaseModel.url;
        this.arrow = cashierBubbleBaseModel.arrow;
        this.closeListener = onClickListener;
    }
}
