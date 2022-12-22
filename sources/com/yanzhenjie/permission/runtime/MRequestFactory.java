package com.yanzhenjie.permission.runtime;

import com.yanzhenjie.permission.runtime.Runtime;
import com.yanzhenjie.permission.source.Source;

public class MRequestFactory implements Runtime.PermissionRequestFactory {
    public PermissionRequest create(Source source) {
        return new C20719b(source);
    }
}
