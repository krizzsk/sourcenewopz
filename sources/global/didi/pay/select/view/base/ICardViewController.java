package global.didi.pay.select.view.base;

import android.view.ViewGroup;

public interface ICardViewController<T> {
    void addCardView(ViewGroup viewGroup, T t);

    void removeAllCardViews(ViewGroup viewGroup);
}
