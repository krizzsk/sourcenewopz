package com.didi.dimina.container.secondparty.permission.notify;

import android.os.Build;
import com.didi.dimina.container.secondparty.permission.notify.listener.J1RequestFactory;
import com.didi.dimina.container.secondparty.permission.notify.listener.J2RequestFactory;
import com.didi.dimina.container.secondparty.permission.notify.listener.ListenerRequest;
import com.didi.dimina.container.secondparty.permission.notify.option.NotifyOption;
import com.didi.dimina.container.secondparty.permission.source.Source;

public class Notify implements NotifyOption {

    /* renamed from: a */
    private static final PermissionRequestFactory f17363a;

    /* renamed from: b */
    private static final ListenerRequestFactory f17364b;

    /* renamed from: c */
    private final Source f17365c;

    public interface ListenerRequestFactory {
        ListenerRequest create(Source source);
    }

    public interface PermissionRequestFactory {
        PermissionRequest create(Source source);
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            f17363a = new ORequestFactory();
        } else {
            f17363a = new NRequestFactory();
        }
        if (Build.VERSION.SDK_INT >= 18) {
            f17364b = new J2RequestFactory();
        } else {
            f17364b = new J1RequestFactory();
        }
    }

    public Notify(Source source) {
        this.f17365c = source;
    }

    public PermissionRequest permission() {
        return f17363a.create(this.f17365c);
    }

    public ListenerRequest listener() {
        return f17364b.create(this.f17365c);
    }
}
