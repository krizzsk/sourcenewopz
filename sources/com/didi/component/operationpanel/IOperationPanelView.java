package com.didi.component.operationpanel;

import android.view.View;
import com.didi.component.core.IView;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import java.util.ArrayList;

public interface IOperationPanelView extends IView<AbsOperationPanelPresenter> {
    void addItem(OperationPanelItemModel operationPanelItemModel, int i);

    void dismissPopup();

    void onRemove();

    void removeItem(OperationPanelItemModel operationPanelItemModel);

    void setTitle(GlobalRichInfo globalRichInfo);

    void setVisible(boolean z);

    void showItems(ArrayList<OperationPanelItemModel> arrayList);

    void showPopup(OperationPanelItemModel operationPanelItemModel, String str);

    void showPopup(OperationPanelItemModel operationPanelItemModel, String str, int i, int i2, View.OnClickListener onClickListener);

    void showPopup(OperationPanelItemModel operationPanelItemModel, String str, View.OnClickListener onClickListener);

    void update(ArrayList<OperationPanelItemModel> arrayList);

    void updateItem(OperationPanelItemModel operationPanelItemModel);
}
