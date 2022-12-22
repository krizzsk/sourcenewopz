package com.yanzhenjie.permission.notify.listener;

import com.yanzhenjie.permission.notify.Notify;
import com.yanzhenjie.permission.source.Source;

public class J1RequestFactory implements Notify.ListenerRequestFactory {
    public ListenerRequest create(Source source) {
        return new C20713b(source);
    }
}
