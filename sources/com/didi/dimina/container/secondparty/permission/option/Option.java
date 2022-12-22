package com.didi.dimina.container.secondparty.permission.option;

import com.didi.dimina.container.secondparty.permission.install.InstallRequest;
import com.didi.dimina.container.secondparty.permission.notify.option.NotifyOption;
import com.didi.dimina.container.secondparty.permission.overlay.OverlayRequest;
import com.didi.dimina.container.secondparty.permission.runtime.option.RuntimeOption;
import com.didi.dimina.container.secondparty.permission.setting.Setting;

public interface Option {
    InstallRequest install();

    NotifyOption notification();

    OverlayRequest overlay();

    RuntimeOption runtime();

    Setting setting();
}
