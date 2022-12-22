package com.didi.dimina.container.secondparty.permission.setting;

import android.os.Build;
import com.didi.dimina.container.secondparty.permission.setting.write.LWriteRequestFactory;
import com.didi.dimina.container.secondparty.permission.setting.write.MWriteRequestFactory;
import com.didi.dimina.container.secondparty.permission.setting.write.WriteRequest;
import com.didi.dimina.container.secondparty.permission.source.Source;

public class Setting {

    /* renamed from: a */
    private static final SettingRequestFactory f17406a;

    /* renamed from: b */
    private final Source f17407b;

    public interface SettingRequestFactory {
        WriteRequest create(Source source);
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            f17406a = new MWriteRequestFactory();
        } else {
            f17406a = new LWriteRequestFactory();
        }
    }

    public Setting(Source source) {
        this.f17407b = source;
    }

    public WriteRequest write() {
        return f17406a.create(this.f17407b);
    }
}
