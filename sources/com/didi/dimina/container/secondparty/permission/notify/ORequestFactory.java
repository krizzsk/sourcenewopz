package com.didi.dimina.container.secondparty.permission.notify;

import com.didi.dimina.container.secondparty.permission.notify.Notify;
import com.didi.dimina.container.secondparty.permission.source.Source;

public class ORequestFactory implements Notify.PermissionRequestFactory {
    public PermissionRequest create(Source source) {
        return new C7599c(source);
    }
}
