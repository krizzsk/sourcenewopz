package global.didi.pay.select.view.base;

import global.didi.pay.select.model.PayMethodPageHeadInfo;

public interface IPayMethodListView<T> {
    void dismissProgressDialog();

    void setPayMethodPageEventListener(IPayMethodPageEventListener iPayMethodPageEventListener);

    void showContentView();

    void showEmptyView();

    void showFrozenContent(PayMethodPageHeadInfo payMethodPageHeadInfo);

    void showProgressDialog(String str);

    void updateContentView(T t, String str);
}
