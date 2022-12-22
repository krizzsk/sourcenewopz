package com.didi.unifylogin.view.ability;

import com.didi.unifylogin.base.net.pojo.response.AuthListResponse;
import com.didi.unifylogin.base.view.ability.ILoginBaseFragment;
import java.util.List;

public interface IThirdPartySetView extends ILoginBaseFragment {
    void updateListView(List<AuthListResponse.Auth> list);
}
