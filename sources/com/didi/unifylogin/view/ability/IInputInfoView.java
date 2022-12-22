package com.didi.unifylogin.view.ability;

import com.didi.unifylogin.base.net.pojo.response.SetEmailResponse;
import com.didi.unifylogin.base.view.ability.ILoginBaseFillerFragment;

public interface IInputInfoView extends ILoginBaseFillerFragment {
    String getEmail();

    String getFirstName();

    String getLastName();

    String getPromoCode();

    void showPromoDialog(SetEmailResponse.PromoConfig promoConfig);
}
