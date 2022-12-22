package com.yanzhenjie.permission.notify;

import android.os.Build;
import com.yanzhenjie.permission.notify.listener.J1RequestFactory;
import com.yanzhenjie.permission.notify.listener.J2RequestFactory;
import com.yanzhenjie.permission.notify.listener.ListenerRequest;
import com.yanzhenjie.permission.notify.option.NotifyOption;
import com.yanzhenjie.permission.source.Source;

public class Notify implements NotifyOption {

    /* renamed from: a */
    private static final PermissionRequestFactory f56202a;

    /* renamed from: b */
    private static final ListenerRequestFactory f56203b;

    /* renamed from: c */
    private Source f56204c;

    public interface ListenerRequestFactory {
        ListenerRequest create(Source source);
    }

    public interface PermissionRequestFactory {
        PermissionRequest create(Source source);
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            f56202a = new ORequestFactory();
        } else {
            f56202a = new NRequestFactory();
        }
        if (Build.VERSION.SDK_INT >= 18) {
            f56203b = new J2RequestFactory();
        } else {
            f56203b = new J1RequestFactory();
        }
    }

    public Notify(Source source) {
        this.f56204c = source;
    }

    public PermissionRequest permission() {
        return f56202a.create(this.f56204c);
    }

    public ListenerRequest listener() {
        return f56203b.create(this.f56204c);
    }
}
