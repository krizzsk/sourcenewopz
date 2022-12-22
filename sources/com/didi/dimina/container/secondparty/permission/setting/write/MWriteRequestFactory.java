package com.didi.dimina.container.secondparty.permission.setting.write;

import com.didi.dimina.container.secondparty.permission.setting.Setting;
import com.didi.dimina.container.secondparty.permission.source.Source;

public class MWriteRequestFactory implements Setting.SettingRequestFactory {
    public WriteRequest create(Source source) {
        return new MWriteRequest(source);
    }
}
