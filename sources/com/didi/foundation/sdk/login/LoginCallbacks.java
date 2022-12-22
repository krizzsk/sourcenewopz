package com.didi.foundation.sdk.login;

import com.didi.unifylogin.listener.LoginListeners;

public class LoginCallbacks {

    public interface CancelAccFinishListener extends LoginListeners.CancelAccFinishListener {
    }

    public interface LocationListener extends LoginListeners.LocationListener {
    }

    public interface LogListener extends com.didi.unifylogin.base.log.LogListener {
    }

    public interface LoginListener extends LoginListeners.LoginListener {
    }

    public interface LoginNetModeListener extends com.didi.unifylogin.base.net.LoginNetModeListener {
    }

    public interface LoginOutListener extends LoginListeners.LoginOutListener {
    }

    public interface ModifyEmailListener extends LoginListeners.ModifyEmailListener {
    }

    public interface ModifyPasswordListener extends LoginListeners.ModifyPasswordListener {
    }

    public interface RiskParamListener extends LoginListeners.RiskParamListener {
    }

    public interface SetCellListener extends LoginListeners.SetCellListener {
    }

    public interface WebViewListener extends LoginListeners.WebViewListener {
    }
}
