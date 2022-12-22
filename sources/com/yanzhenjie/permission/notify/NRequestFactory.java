package com.yanzhenjie.permission.notify;

import com.yanzhenjie.permission.notify.Notify;
import com.yanzhenjie.permission.source.Source;

public class NRequestFactory implements Notify.PermissionRequestFactory {
    public PermissionRequest create(Source source) {
        return new C20710b(source);
    }
}
