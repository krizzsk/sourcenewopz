package com.didi.payment.base.view.webview.util;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.payment.base.utils.ktx.ActivityKtxKt;
import com.didi.sdk.util.UiThreadHandler;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0002J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0006\u0010\u001a\u001a\u00020\u0014J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\"\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\"H\u0002R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, mo175978d2 = {"Lcom/didi/payment/base/view/webview/util/ChooseFileHelper;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "args", "Lorg/json/JSONObject;", "mCallback", "Lcom/didi/onehybrid/jsbridge/CallbackFunction;", "(Landroidx/fragment/app/FragmentActivity;Lorg/json/JSONObject;Lcom/didi/onehybrid/jsbridge/CallbackFunction;)V", "ERR_CODE_FILE_TYPE_NOT_MATCH", "", "ERR_CODE_OPEN_FAIL", "ERR_CODE_READ_FAIL", "ERR_CODE_SIZE_FAIL", "ERR_CODE_SUCCESS", "REQUEST_CODE_OPEN_FILE", "mFileMaxSize", "mFileType", "", "callbackJS", "", "errno", "result", "encodeByBase64", "data", "", "execute", "getBytesFromStore", "Lcom/didi/payment/base/view/webview/util/Result;", "uri", "Landroid/net/Uri;", "handleActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ChooseFileHelper.kt */
public final class ChooseFileHelper {

    /* renamed from: a */
    private final FragmentActivity f30052a;

    /* renamed from: b */
    private final JSONObject f30053b;

    /* renamed from: c */
    private final CallbackFunction f30054c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final int f30055d = 1000;

    /* renamed from: e */
    private final int f30056e = 104;

    /* renamed from: f */
    private final int f30057f = -1;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final int f30058g = -2;

    /* renamed from: h */
    private final int f30059h = -3;

    /* renamed from: i */
    private final int f30060i = -4;

    /* renamed from: j */
    private String f30061j = "";

    /* renamed from: k */
    private int f30062k;

    public ChooseFileHelper(FragmentActivity fragmentActivity, JSONObject jSONObject, CallbackFunction callbackFunction) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(jSONObject, "args");
        this.f30052a = fragmentActivity;
        this.f30053b = jSONObject;
        this.f30054c = callbackFunction;
    }

    public final void execute() {
        String optString = this.f30053b.optString("file_extension");
        Intrinsics.checkNotNullExpressionValue(optString, "args.optString(\"file_extension\")");
        this.f30061j = optString;
        String optString2 = this.f30053b.optString("file_path");
        this.f30062k = this.f30053b.optInt("max_size");
        if (this.f30061j.length() == 0) {
            this.f30061j = "application/pdf";
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.addFlags(2097152);
        if (!TextUtils.isEmpty(optString2)) {
            intent.setData(Uri.parse(optString2));
        }
        intent.setType(this.f30061j);
        try {
            ActivityKtxKt.startActivityForResult(this.f30052a, intent, this.f30055d, new ChooseFileHelper$execute$1(this));
        } catch (Exception unused) {
            m21051a(this.f30057f, (String) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m21050a(int i, int i2, Intent intent) {
        Uri uri;
        if (i == this.f30055d) {
            if (intent == null) {
                uri = null;
            } else {
                uri = intent.getData();
            }
            if (uri == null) {
                m21051a(this.f30058g, (String) null);
            } else {
                Job unused = C21836d.m45637a(LifecycleOwnerKt.getLifecycleScope(this.f30052a), (CoroutineContext) null, (CoroutineStart) null, new ChooseFileHelper$handleActivityResult$1(this, uri, (Continuation<? super ChooseFileHelper$handleActivityResult$1>) null), 3, (Object) null);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0083 A[SYNTHETIC, Splitter:B:38:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0092 A[SYNTHETIC, Splitter:B:46:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a1 A[SYNTHETIC, Splitter:B:54:0x00a1] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b4 A[SYNTHETIC, Splitter:B:64:0x00b4] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:51:0x009a=Splitter:B:51:0x009a, B:43:0x008b=Splitter:B:43:0x008b, B:35:0x007c=Splitter:B:35:0x007c} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.didi.payment.base.view.webview.util.Result m21048a(android.net.Uri r10) {
        /*
            r9 = this;
            int r0 = r9.f30056e
            r1 = 0
            androidx.fragment.app.FragmentActivity r2 = r9.f30052a     // Catch:{ FileNotFoundException -> 0x0098, IOException -> 0x0089, Exception -> 0x007a, all -> 0x0078 }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0098, IOException -> 0x0089, Exception -> 0x007a, all -> 0x0078 }
            java.lang.String r2 = r2.getType(r10)     // Catch:{ FileNotFoundException -> 0x0098, IOException -> 0x0089, Exception -> 0x007a, all -> 0x0078 }
            java.lang.String r3 = r9.f30061j     // Catch:{ FileNotFoundException -> 0x0098, IOException -> 0x0089, Exception -> 0x007a, all -> 0x0078 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ FileNotFoundException -> 0x0098, IOException -> 0x0089, Exception -> 0x007a, all -> 0x0078 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ FileNotFoundException -> 0x0098, IOException -> 0x0089, Exception -> 0x007a, all -> 0x0078 }
            boolean r2 = android.text.TextUtils.equals(r3, r2)     // Catch:{ FileNotFoundException -> 0x0098, IOException -> 0x0089, Exception -> 0x007a, all -> 0x0078 }
            if (r2 != 0) goto L_0x0021
            com.didi.payment.base.view.webview.util.Result r10 = new com.didi.payment.base.view.webview.util.Result     // Catch:{ FileNotFoundException -> 0x0098, IOException -> 0x0089, Exception -> 0x007a, all -> 0x0078 }
            int r0 = r9.f30060i     // Catch:{ FileNotFoundException -> 0x0098, IOException -> 0x0089, Exception -> 0x007a, all -> 0x0078 }
            r10.<init>(r0, r1)     // Catch:{ FileNotFoundException -> 0x0098, IOException -> 0x0089, Exception -> 0x007a, all -> 0x0078 }
            return r10
        L_0x0021:
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ FileNotFoundException -> 0x0098, IOException -> 0x0089, Exception -> 0x007a, all -> 0x0078 }
            r2.<init>()     // Catch:{ FileNotFoundException -> 0x0098, IOException -> 0x0089, Exception -> 0x007a, all -> 0x0078 }
            androidx.fragment.app.FragmentActivity r3 = r9.f30052a     // Catch:{ FileNotFoundException -> 0x0098, IOException -> 0x0089, Exception -> 0x007a, all -> 0x0078 }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0098, IOException -> 0x0089, Exception -> 0x007a, all -> 0x0078 }
            java.io.InputStream r10 = r3.openInputStream(r10)     // Catch:{ FileNotFoundException -> 0x0098, IOException -> 0x0089, Exception -> 0x007a, all -> 0x0078 }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x006e, Exception -> 0x0069, all -> 0x0065 }
            r4 = 0
            r5 = 0
        L_0x0036:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x006e, Exception -> 0x0069, all -> 0x0065 }
            int r6 = r10.read(r3)     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x006e, Exception -> 0x0069, all -> 0x0065 }
            if (r6 <= 0) goto L_0x004f
            int r5 = r5 + r6
            r2.write(r3, r4, r6)     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x006e, Exception -> 0x0069, all -> 0x0065 }
            int r6 = r9.f30062k     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x006e, Exception -> 0x0069, all -> 0x0065 }
            if (r6 <= 0) goto L_0x0036
            int r6 = r5 / 1024
            int r7 = r9.f30062k     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x006e, Exception -> 0x0069, all -> 0x0065 }
            if (r6 <= r7) goto L_0x0036
            int r0 = r9.f30059h     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x006e, Exception -> 0x0069, all -> 0x0065 }
        L_0x004f:
            int r3 = r9.f30056e     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x006e, Exception -> 0x0069, all -> 0x0065 }
            if (r0 != r3) goto L_0x005b
            byte[] r2 = r2.toByteArray()     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x006e, Exception -> 0x0069, all -> 0x0065 }
            java.lang.String r1 = r9.m21049a((byte[]) r2)     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x006e, Exception -> 0x0069, all -> 0x0065 }
        L_0x005b:
            r10.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x00aa
        L_0x0060:
            r10 = move-exception
            r10.printStackTrace()
            goto L_0x00aa
        L_0x0065:
            r0 = move-exception
            r1 = r10
            r10 = r0
            goto L_0x00b2
        L_0x0069:
            r0 = move-exception
            r8 = r0
            r0 = r10
            r10 = r8
            goto L_0x007c
        L_0x006e:
            r0 = move-exception
            r8 = r0
            r0 = r10
            r10 = r8
            goto L_0x008b
        L_0x0073:
            r0 = move-exception
            r8 = r0
            r0 = r10
            r10 = r8
            goto L_0x009a
        L_0x0078:
            r10 = move-exception
            goto L_0x00b2
        L_0x007a:
            r10 = move-exception
            r0 = r1
        L_0x007c:
            int r2 = r9.f30058g     // Catch:{ all -> 0x00b0 }
            r10.printStackTrace()     // Catch:{ all -> 0x00b0 }
            if (r0 == 0) goto L_0x00a9
            r0.close()     // Catch:{ IOException -> 0x0087 }
            goto L_0x00a9
        L_0x0087:
            r10 = move-exception
            goto L_0x00a6
        L_0x0089:
            r10 = move-exception
            r0 = r1
        L_0x008b:
            int r2 = r9.f30058g     // Catch:{ all -> 0x00b0 }
            r10.printStackTrace()     // Catch:{ all -> 0x00b0 }
            if (r0 == 0) goto L_0x00a9
            r0.close()     // Catch:{ IOException -> 0x0096 }
            goto L_0x00a9
        L_0x0096:
            r10 = move-exception
            goto L_0x00a6
        L_0x0098:
            r10 = move-exception
            r0 = r1
        L_0x009a:
            int r2 = r9.f30058g     // Catch:{ all -> 0x00b0 }
            r10.printStackTrace()     // Catch:{ all -> 0x00b0 }
            if (r0 == 0) goto L_0x00a9
            r0.close()     // Catch:{ IOException -> 0x00a5 }
            goto L_0x00a9
        L_0x00a5:
            r10 = move-exception
        L_0x00a6:
            r10.printStackTrace()
        L_0x00a9:
            r0 = r2
        L_0x00aa:
            com.didi.payment.base.view.webview.util.Result r10 = new com.didi.payment.base.view.webview.util.Result
            r10.<init>(r0, r1)
            return r10
        L_0x00b0:
            r10 = move-exception
            r1 = r0
        L_0x00b2:
            if (r1 == 0) goto L_0x00bc
            r1.close()     // Catch:{ IOException -> 0x00b8 }
            goto L_0x00bc
        L_0x00b8:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00bc:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.base.view.webview.util.ChooseFileHelper.m21048a(android.net.Uri):com.didi.payment.base.view.webview.util.Result");
    }

    /* renamed from: a */
    private final String m21049a(byte[] bArr) {
        if (bArr != null) {
            if (!(bArr.length == 0)) {
                try {
                    return Base64.encodeToString(bArr, 2);
                } catch (Exception unused) {
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m21051a(int i, String str) {
        if (this.f30054c != null) {
            UiThreadHandler.post(new Runnable(i, str, this) {
                public final /* synthetic */ int f$0;
                public final /* synthetic */ String f$1;
                public final /* synthetic */ ChooseFileHelper f$2;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    ChooseFileHelper.m21052a(this.f$0, this.f$1, this.f$2);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21052a(int i, String str, ChooseFileHelper chooseFileHelper) {
        Intrinsics.checkNotNullParameter(chooseFileHelper, "this$0");
        Map hashMap = new HashMap();
        hashMap.put(Constants.ERROR_CODE, Integer.valueOf(i));
        hashMap.put("fileBase64String", str);
        chooseFileHelper.f30054c.onCallBack(new JSONObject(hashMap));
    }
}
