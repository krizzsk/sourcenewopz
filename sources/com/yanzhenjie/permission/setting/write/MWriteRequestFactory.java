package com.yanzhenjie.permission.setting.write;

import com.yanzhenjie.permission.setting.Setting;
import com.yanzhenjie.permission.source.Source;

public class MWriteRequestFactory implements Setting.SettingRequestFactory {
    public WriteRequest create(Source source) {
        return new MWriteRequest(source);
    }
}
