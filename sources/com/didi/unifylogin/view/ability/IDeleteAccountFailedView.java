package com.didi.unifylogin.view.ability;

import com.didi.unifylogin.base.net.pojo.response.DeleteUserResponse;
import com.didi.unifylogin.base.view.ability.ILoginBaseFragment;
import java.util.List;

public interface IDeleteAccountFailedView extends ILoginBaseFragment {
    void setNextBtn(String str);

    void updateDeleteAccountFailTexts(List<DeleteUserResponse.DeleteContent> list);

    void updatePrompTitleText(String str);

    void updateSubTitleText(String str);
}
