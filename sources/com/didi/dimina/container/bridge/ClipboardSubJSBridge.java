package com.didi.dimina.container.bridge;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/dimina/container/bridge/ClipboardSubJSBridge;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "mClipboardManager", "Landroid/content/ClipboardManager;", "mContext", "getClipboardData", "", "paras", "Lorg/json/JSONObject;", "callback", "Lcom/didi/dimina/container/bridge/base/CallbackFunction;", "setClipboardData", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ClipboardSubJSBridge.kt */
public final class ClipboardSubJSBridge {

    /* renamed from: a */
    private final ClipboardManager f16561a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f16562b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f16563c = "ClipboardSubJSBridge";

    public ClipboardSubJSBridge(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Object systemService = context.getSystemService("clipboard");
        if (systemService != null) {
            this.f16561a = (ClipboardManager) systemService;
            this.f16562b = context;
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
    }

    public final void setClipboardData(JSONObject jSONObject, CallbackFunction callbackFunction) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "paras");
        LogUtil.m13412i(this.f16563c, "setClipboardData(), 参数内容 " + jSONObject);
        String optString = jSONObject.optString("data");
        boolean optBoolean = jSONObject.optBoolean("disableToast", false);
        try {
            if (TextUtils.isEmpty(optString)) {
                optString = null;
            }
            this.f16561a.setPrimaryClip(ClipData.newPlainText((CharSequence) null, optString));
            if (!optBoolean) {
                UIHandlerUtil.post(new ClipboardSubJSBridge$setClipboardData$1(this));
            }
            CallBackUtil.onSuccess$default((JSONObject) null, callbackFunction, 1, (Object) null);
        } catch (Exception e) {
            e.printStackTrace();
            CallBackUtil.onFail$default((JSONObject) null, "", callbackFunction, 1, (Object) null);
        }
        LogUtil.m13411i("clipboard setClipboardData: " + optString);
    }

    public final void getClipboardData(JSONObject jSONObject, CallbackFunction callbackFunction) {
        CharSequence charSequence = null;
        try {
            ClipData primaryClip = this.f16561a.getPrimaryClip();
            if (primaryClip != null && primaryClip.getItemCount() > 0) {
                ClipData.Item itemAt = primaryClip.getItemAt(0);
                Intrinsics.checkExpressionValueIsNotNull(itemAt, "primaryClip.getItemAt(0)");
                charSequence = itemAt.getText();
            }
            JSONObject jSONObject2 = new JSONObject();
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = "";
            }
            JSONUtil.put(jSONObject2, "data", (Object) charSequence);
            LogUtil.m13411i("clipboard getClipboardData: json:" + jSONObject2);
            CallBackUtil.onSuccess(jSONObject2, callbackFunction);
        } catch (Exception e) {
            e.printStackTrace();
            CallBackUtil.onFail$default((JSONObject) null, "", callbackFunction, 1, (Object) null);
        }
        LogUtil.m13411i("clipboard getClipboardData: " + charSequence);
    }
}
