package com.didi.unifylogin.view.ability;

import com.didi.unifylogin.base.view.ability.ILoginBaseFragment;
import com.didi.unifylogin.view.adpter.DeleteAccountReasonsAdapter;
import java.util.List;

public interface IDeleteAccountReasonsView extends ILoginBaseFragment {
    List<String> getSelectedReasons();

    void setNextBtn(String str);

    void setWarnTxt(String str);

    void showWarnDialog();

    void updateReasons(List<DeleteAccountReasonsAdapter.DeleteAccountReason> list);
}
