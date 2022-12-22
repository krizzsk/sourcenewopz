package com.didi.dimina.container.secondparty.permission.runtime;

import com.didi.dimina.container.secondparty.permission.runtime.Runtime;
import com.didi.dimina.container.secondparty.permission.source.Source;

public class LRequestFactory implements Runtime.PermissionRequestFactory {
    public PermissionRequest create(Source source) {
        return new C7606a(source);
    }
}
