package com.didi.component.rideoption;

import android.view.View;
import com.didi.component.core.IView;
import com.didi.sdk.view.popup.PopupSelectView;
import com.didi.sdk.view.popup.model.PopupSelectModel;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import java.util.List;

public interface IRideOptionView extends IView<AbsRideOptionPresenter> {

    public interface OnConfirmListener {
        void onConfirm(View view);
    }

    void closeSelectMore();

    void setClickable(boolean z);

    void setContentLable(String str);

    void setDialogTitle(String str);

    void setNewContent(GlobalRichInfo globalRichInfo);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnConfirmListener(OnConfirmListener onConfirmListener);

    void setOnPopupSelectListClickListener(PopupSelectView.OnPopupSelectListClickListener onPopupSelectListClickListener);

    void setOptionIcon(String str);

    void setSelectListData(List<PopupSelectModel> list);

    void setSelectedPosition(int i);

    void showSelectMore(int i);
}
