package com.didi.component.comp_homecard.destination;

import android.view.View;
import com.didi.component.business.model.HomeCardModel;
import com.didi.component.comp_homecard.destination.HomeDestinationRecAdapter;
import com.didi.component.core.IView;
import java.util.List;

public interface IHomeDestinationCardView extends IView<AbsHomeDestinationCardPresenter> {

    public interface IClickCallBack {
        void clickWhereToGo();
    }

    void clearRecData();

    void hideCouponAssistant();

    void hideRecList();

    boolean isRecListShown();

    void setClickListener(IClickCallBack iClickCallBack);

    void setGuessItemClickListener(HomeDestinationRecAdapter.OnItemClickListener onItemClickListener);

    void setRecData(List<HomeCardModel> list);

    void setVisibility(int i, Runnable runnable);

    void showCouponAssistant(View view);

    void showRecList();
}
