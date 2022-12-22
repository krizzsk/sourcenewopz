package com.didi.component.memberpoint;

import com.didi.component.core.IView;
import com.didi.travel.psnger.model.response.GlobalRichInfo;

public interface IMemberPointView extends IView<AbsMemberPointPresenter> {
    void bindRichInfo(GlobalRichInfo globalRichInfo);

    void setIcon(String str);

    void setLabel(String str);

    void setMemberpoint(String str);
}
