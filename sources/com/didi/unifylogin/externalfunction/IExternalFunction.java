package com.didi.unifylogin.externalfunction;

import android.content.Context;
import com.didi.unifylogin.listener.LoginListeners;
import java.util.Map;

public interface IExternalFunction {
    void getEmailStatus(Context context, LoginListeners.EmailStatusListener emailStatusListener);

    void passwordVerify(Context context, String str, LoginListeners.PasswordVerifyListener passwordVerifyListener);

    void refreshToken(Context context);

    void uploadLocation(Context context, Map<String, Object> map, LoginListeners.PassportServerCallback passportServerCallback);

    void validate(Context context, LoginListeners.ValidateTicketListener validateTicketListener);
}
