package global.didi.pay.view.popup.model;

import global.didi.pay.view.popup.BubbleCloseListener;

public class CashierBubbleBaseModel {
    public CashierBubbleArrow arrow;
    public String background_color;
    public int cancelable;
    public BubbleCloseListener closeListener;
    public String icon;
    public CashierTextModel text;
    public String url;
}
