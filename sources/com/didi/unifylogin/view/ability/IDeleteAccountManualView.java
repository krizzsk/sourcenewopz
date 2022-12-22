package com.didi.unifylogin.view.ability;

import com.didi.unifylogin.base.net.pojo.response.GetDeleteAccountManualResponse;
import com.didi.unifylogin.base.view.ability.ILoginBaseFragment;
import java.util.List;

public interface IDeleteAccountManualView extends ILoginBaseFragment {
    void setNextBtn(String str);

    void setWarnTxt(String str);

    void showWarnDialog();

    void updateContents(List<GetDeleteAccountManualResponse.DeleteContent> list);
}
