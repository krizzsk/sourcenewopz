package com.didiglobal.p205sa.biz.component.interactivedialog;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.global.globalgenerickit.config.GGKConfigCallbackAdapter;
import com.didi.global.globalgenerickit.config.GGKConfigProcessor;
import com.didi.global.globalgenerickit.config.IConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/interactivedialog/InteractiveDialogUtils;", "", "()V", "show", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "jsonObject", "Lorg/json/JSONObject;", "configId", "", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.interactivedialog.InteractiveDialogUtils */
/* compiled from: InteractiveDialogUtils.kt */
public final class InteractiveDialogUtils {
    public static final InteractiveDialogUtils INSTANCE = new InteractiveDialogUtils();

    private InteractiveDialogUtils() {
    }

    public final void show(FragmentActivity fragmentActivity, JSONObject jSONObject, String str) {
        IConfig iConfig;
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        if (!TextUtils.isEmpty(str) && (iConfig = GGKConfigProcessor.getMaps().get(str)) != null) {
            iConfig.show(fragmentActivity, jSONObject, (GGKConfigCallbackAdapter) new InteractiveDialogUtils$show$1$1(fragmentActivity));
        }
    }
}
