package com.didi.dimina.container.util;

import android.content.Context;
import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;

public class ToastUtil {
    public static void show(Context context, CharSequence charSequence) {
        show(context, charSequence, 0);
    }

    public static void show(Context context, CharSequence charSequence, int i) {
        UIHandlerUtil.post(new Runnable(context, charSequence, i) {
            public final /* synthetic */ Context f$0;
            public final /* synthetic */ CharSequence f$1;
            public final /* synthetic */ int f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                SystemUtils.showToast(Toast.makeText(this.f$0, this.f$1, this.f$2));
            }
        });
    }
}
