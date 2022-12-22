package com.yanzhenjie.permission.option;

import com.yanzhenjie.permission.install.InstallRequest;
import com.yanzhenjie.permission.notify.option.NotifyOption;
import com.yanzhenjie.permission.overlay.OverlayRequest;
import com.yanzhenjie.permission.runtime.option.RuntimeOption;
import com.yanzhenjie.permission.setting.Setting;

public interface Option {
    InstallRequest install();

    NotifyOption notification();

    OverlayRequest overlay();

    RuntimeOption runtime();

    Setting setting();
}
