package com.didi.unifylogin.base.view.ability;

import com.didi.unifylogin.base.net.pojo.response.ActionResponse;

public interface ILoginBaseFillerFragment extends ILoginBaseFragment {
    ActionResponse.Action getAction();
}
