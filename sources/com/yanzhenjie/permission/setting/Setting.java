package com.yanzhenjie.permission.setting;

import android.os.Build;
import com.yanzhenjie.permission.setting.write.LWriteRequestFactory;
import com.yanzhenjie.permission.setting.write.MWriteRequestFactory;
import com.yanzhenjie.permission.setting.write.WriteRequest;
import com.yanzhenjie.permission.source.Source;

public class Setting {

    /* renamed from: a */
    private static final SettingRequestFactory f56246a;

    /* renamed from: b */
    private Source f56247b;

    public interface SettingRequestFactory {
        WriteRequest create(Source source);
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            f56246a = new MWriteRequestFactory();
        } else {
            f56246a = new LWriteRequestFactory();
        }
    }

    public Setting(Source source) {
        this.f56247b = source;
    }

    public WriteRequest write() {
        return f56246a.create(this.f56247b);
    }
}
