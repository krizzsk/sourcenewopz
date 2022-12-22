package com.yanzhenjie.permission.runtime;

import com.yanzhenjie.permission.runtime.Runtime;
import com.yanzhenjie.permission.source.Source;

public class LRequestFactory implements Runtime.PermissionRequestFactory {
    public PermissionRequest create(Source source) {
        return new C20718a(source);
    }
}
