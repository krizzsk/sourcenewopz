package com.didi.component.groupform.anycar.view;

import com.didi.component.core.IView;
import com.didi.component.groupform.anycar.presenter.AbsAnycarGroupFormPresenter;
import com.didi.travel.psnger.model.response.estimate.FormOperationModel;
import java.util.List;

public interface IAnycarGroupFormView extends IView<AbsAnycarGroupFormPresenter> {
    void onDestroy();

    void setAnyCarFormOperationData(FormOperationModel formOperationModel);

    void setButtonText(CharSequence charSequence);

    void setEnabled(boolean z);

    void setMaxColCount(int i);

    void setOptionViews(List<Integer> list);

    void setPriceBtn(String str);

    void setVisible(boolean z);
}
