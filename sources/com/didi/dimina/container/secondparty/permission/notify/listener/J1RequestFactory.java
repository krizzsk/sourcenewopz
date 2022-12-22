package com.didi.dimina.container.secondparty.permission.notify.listener;

import com.didi.dimina.container.secondparty.permission.notify.Notify;
import com.didi.dimina.container.secondparty.permission.source.Source;

public class J1RequestFactory implements Notify.ListenerRequestFactory {
    public ListenerRequest create(Source source) {
        return new C7601b(source);
    }
}
