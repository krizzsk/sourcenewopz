package com.didi.dimina.starbox;

import android.app.Activity;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.jsengine.DiminaEngine;
import com.didi.dimina.container.jsengine.JSEngine;
import com.didi.dimina.container.webengine.WebViewEngine;
import com.didi.dimina.container.webengine.webview.DMGeneralWebView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/dimina/starbox/StarBoxActivity$startDiminaRelease$1$1", "Lcom/didi/dimina/container/DMConfig$EngineFactory;", "createJSEngine", "Lcom/didi/dimina/container/jsengine/JSEngine;", "createWebViewEngine", "Lcom/didi/dimina/container/webengine/WebViewEngine;", "activity", "Landroid/app/Activity;", "starbox_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: StarBoxActivity.kt */
public final class StarBoxActivity$startDiminaRelease$1$1 implements DMConfig.EngineFactory {
    StarBoxActivity$startDiminaRelease$1$1() {
    }

    public WebViewEngine createWebViewEngine(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        return new DMGeneralWebView(activity);
    }

    public JSEngine createJSEngine() {
        return new DiminaEngine();
    }
}
