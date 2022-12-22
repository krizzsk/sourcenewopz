package com.didi.component.comp_anycar_append_list;

import com.didi.component.comp_anycar_append_list.AnyCarAppendData;
import com.didi.component.core.IView;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.travel.psnger.model.response.anycar.AnyCarGroup;
import com.didi.travel.psnger.model.response.estimate.CarMessageModel;
import java.util.List;

public interface IAnyCarAppendListView extends IView<AnyCarAppendListPresenter> {
    void refreshBtnContent();

    void setData(List<AnyCarGroup> list);

    void setSubmitBtn(AnyCarAppendData.BtnInfo btnInfo);

    void setTitle(LEGORichInfo lEGORichInfo);

    void updateBtnLoading(Boolean bool);

    void updateMsgTips(CarMessageModel carMessageModel);
}
