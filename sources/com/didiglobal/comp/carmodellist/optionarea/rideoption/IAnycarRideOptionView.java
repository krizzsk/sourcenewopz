package com.didiglobal.comp.carmodellist.optionarea.rideoption;

import android.view.View;
import com.didi.sdk.view.popup.PopupSelectView;
import com.didi.sdk.view.popup.model.PopupSelectModel;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import java.util.List;

public interface IAnycarRideOptionView {

    public interface OnConfirmListener {
        void onConfirm(View view);
    }

    void closeSelectMore();

    void setClickable(boolean z);

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
