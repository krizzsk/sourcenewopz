package com.didi.unifylogin.view.ability;

import androidx.fragment.app.Fragment;
import com.didi.unifylogin.base.net.pojo.response.GateKeeperResponse;
import com.didi.unifylogin.base.view.ability.ILoginBaseFragment;
import java.util.List;

public interface IInputPhoneView extends ILoginBaseFragment {
    String getEmail();

    Fragment getFragment();

    String getPhone();

    void hideThirdPartyView();

    boolean isAgreeLaw();

    void selectDoubleIdentity(List<GateKeeperResponse.Role> list);

    void setEmail(String str);

    void setOtherWaVisibility(boolean z);

    void setPhone(String str);

    void updateLawLayoutVisibility(boolean z);
}
