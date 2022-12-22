package global.didi.pay.select.view.base;

import android.view.View;

public interface IPayMethodPageEventListener<T, K> {
    void onFrozenTitleClick(String str);

    void onPageClickEvent(View view, K k);

    void onPayMethodClickEvent(View view, T t);

    void onPayMethodSelectEvent(View view, T t);
}
