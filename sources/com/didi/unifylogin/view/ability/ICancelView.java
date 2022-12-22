package com.didi.unifylogin.view.ability;

import com.didi.unifylogin.base.net.pojo.response.DeleteAccountResponse;
import com.didi.unifylogin.base.view.ability.ILoginBaseFragment;
import java.util.List;

public interface ICancelView extends ILoginBaseFragment {
    void setNextBtn(CharSequence charSequence);

    void setWarnTxt(CharSequence charSequence);

    void showWarnDialog();

    void updateContents(List<DeleteAccountResponse.DeleteContent> list);
}
