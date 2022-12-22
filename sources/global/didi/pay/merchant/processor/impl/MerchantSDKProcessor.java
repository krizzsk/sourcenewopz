package global.didi.pay.merchant.processor.impl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.didichuxing.foundation.spi.ServiceLoader;
import global.didi.pay.merchant.processor.MerchantRequestChecker;
import global.didi.pay.merchant.processor.MerchantRequestHandler;
import global.didi.pay.merchant.processor.MerchantResponseHandler;
import global.didi.pay.merchant.processor.contract.IMerchantSDKProcessor;
import global.didi.pay.merchant.processor.model.MerchantSDKRequest;
import global.didi.pay.merchantcore.model.DPayRequest;
import global.didi.pay.merchantcore.model.DPayResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R2\u0010\u0007\u001a&\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t \n*\u0012\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t\u0018\u00010\b0\bX\u000e¢\u0006\u0002\n\u0000R2\u0010\u000b\u001a&\u0012\f\u0012\n \n*\u0004\u0018\u00010\f0\f \n*\u0012\u0012\f\u0012\n \n*\u0004\u0018\u00010\f0\f\u0018\u00010\b0\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R2\u0010\u000f\u001a&\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00100\u0010 \n*\u0012\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\b0\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo175978d2 = {"Lglobal/didi/pay/merchant/processor/impl/MerchantSDKProcessor;", "Lglobal/didi/pay/merchant/processor/contract/IMerchantSDKProcessor;", "()V", "payExtraJsonParam", "Lorg/json/JSONObject;", "payRequest", "Lglobal/didi/pay/merchantcore/model/DPayRequest;", "requestChecker", "Lcom/didichuxing/foundation/spi/ServiceLoader;", "Lglobal/didi/pay/merchant/processor/MerchantRequestChecker;", "kotlin.jvm.PlatformType", "requestHandler", "Lglobal/didi/pay/merchant/processor/MerchantRequestHandler;", "requestPath", "", "responseHandler", "Lglobal/didi/pay/merchant/processor/MerchantResponseHandler;", "responsePackageName", "handleRequest", "", "activity", "Landroid/app/Activity;", "request", "Lglobal/didi/pay/merchant/processor/model/MerchantSDKRequest;", "handleResponse", "context", "Landroid/content/Context;", "response", "Lglobal/didi/pay/merchantcore/model/DPayResponse;", "legal", "", "payMerchantProcessor_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MerchantSDKProcessor.kt */
public final class MerchantSDKProcessor implements IMerchantSDKProcessor {
    private JSONObject payExtraJsonParam;
    private DPayRequest payRequest;
    private ServiceLoader<MerchantRequestChecker> requestChecker = ServiceLoader.load(MerchantRequestChecker.class);
    private ServiceLoader<MerchantRequestHandler> requestHandler = ServiceLoader.load(MerchantRequestHandler.class);
    private String requestPath;
    private ServiceLoader<MerchantResponseHandler> responseHandler = ServiceLoader.load(MerchantResponseHandler.class);
    private String responsePackageName;

    /* JADX WARNING: type inference failed for: r13v9, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleRequest(android.app.Activity r12, global.didi.pay.merchant.processor.model.MerchantSDKRequest r13) {
        /*
            r11 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            boolean r0 = r11.legal(r12, r13)
            if (r0 != 0) goto L_0x000c
            return
        L_0x000c:
            r0 = 0
            if (r13 != 0) goto L_0x0011
        L_0x000f:
            r2 = r0
            goto L_0x0031
        L_0x0011:
            android.content.Intent r1 = r13.getRequestIntent()     // Catch:{ Exception -> 0x002e }
            if (r1 != 0) goto L_0x0018
            goto L_0x000f
        L_0x0018:
            android.os.Bundle r1 = r1.getExtras()     // Catch:{ Exception -> 0x002e }
            if (r1 != 0) goto L_0x001f
            goto L_0x000f
        L_0x001f:
            java.lang.String r2 = "extra_json_param"
            java.lang.String r1 = r1.getString(r2)     // Catch:{ Exception -> 0x002e }
            if (r1 != 0) goto L_0x0028
            goto L_0x000f
        L_0x0028:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x002e }
            r2.<init>(r1)     // Catch:{ Exception -> 0x002e }
            goto L_0x0031
        L_0x002e:
            r2 = r0
            org.json.JSONObject r2 = (org.json.JSONObject) r2
        L_0x0031:
            r11.payExtraJsonParam = r2
            if (r13 != 0) goto L_0x0036
            goto L_0x004d
        L_0x0036:
            android.content.Intent r13 = r13.getRequestIntent()
            if (r13 != 0) goto L_0x003d
            goto L_0x004d
        L_0x003d:
            android.os.Bundle r13 = r13.getExtras()
            if (r13 != 0) goto L_0x0044
            goto L_0x004d
        L_0x0044:
            java.lang.String r0 = "request"
            android.os.Parcelable r13 = r13.getParcelable(r0)
            r0 = r13
            global.didi.pay.merchantcore.model.DPayRequest r0 = (global.didi.pay.merchantcore.model.DPayRequest) r0
        L_0x004d:
            r11.payRequest = r0
            java.lang.String r13 = r11.requestPath
            java.lang.String r0 = "/pay"
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r0)
            if (r13 == 0) goto L_0x00a7
            global.didi.pay.merchantcore.model.DPayRequest r13 = r11.payRequest
            r0 = 0
            r1 = 1
            if (r13 != 0) goto L_0x0060
            goto L_0x0067
        L_0x0060:
            boolean r13 = r13.illegal()
            if (r13 != r1) goto L_0x0067
            r0 = 1
        L_0x0067:
            if (r0 == 0) goto L_0x007e
            android.content.Context r12 = (android.content.Context) r12
            global.didi.pay.merchantcore.model.DPayResponse r13 = new global.didi.pay.merchantcore.model.DPayResponse
            r0 = 2
            global.didi.pay.merchantcore.model.DPayMsg r1 = new global.didi.pay.merchantcore.model.DPayMsg
            r2 = 10003(0x2713, float:1.4017E-41)
            java.lang.String r3 = "pay Params are illegal"
            r1.<init>(r2, r3)
            r13.<init>(r0, r1)
            r11.handleResponse(r12, r13)
            goto L_0x00a7
        L_0x007e:
            global.didi.pay.merchantcore.model.DPayRequest r13 = r11.payRequest
            if (r13 != 0) goto L_0x0083
            goto L_0x00a7
        L_0x0083:
            com.didichuxing.foundation.spi.ServiceLoader<global.didi.pay.merchant.processor.MerchantRequestHandler> r0 = r11.requestHandler
            java.util.Iterator r0 = r0.iterator()
            java.lang.String r1 = "requestHandler.iterator()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
        L_0x008e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00a7
            java.lang.Object r1 = r0.next()
            r4 = r1
            global.didi.pay.merchant.processor.MerchantRequestHandler r4 = (global.didi.pay.merchant.processor.MerchantRequestHandler) r4
            r5 = 1
            global.didi.pay.merchant.processor.model.MerchantRequestType r7 = global.didi.pay.merchant.processor.model.MerchantRequestType.TYPE_MERCHANT_SDK
            r8 = 0
            org.json.JSONObject r10 = r11.payExtraJsonParam
            r6 = r12
            r9 = r13
            r4.startMerchantRequest(r5, r6, r7, r8, r9, r10)
            goto L_0x008e
        L_0x00a7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: global.didi.pay.merchant.processor.impl.MerchantSDKProcessor.handleRequest(android.app.Activity, global.didi.pay.merchant.processor.model.MerchantSDKRequest):void");
    }

    public void handleResponse(Context context, DPayResponse dPayResponse) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dPayResponse, "response");
        CharSequence charSequence = this.responsePackageName;
        if (charSequence == null || charSequence.length() == 0) {
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        Intent intent = new Intent();
        String str = this.responsePackageName;
        Intrinsics.checkNotNull(str);
        intent.setComponent(new ComponentName(str, "global.didi.pay.merchantsdk.activity.DCashierContainerActivity"));
        Bundle bundle = new Bundle();
        bundle.putParcelable("response", dPayResponse);
        Unit unit = Unit.INSTANCE;
        intent.putExtras(bundle);
        intent.putExtra("type", "response");
        intent.addFlags(805306368);
        context.startActivity(intent);
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    private final boolean legal(Activity activity, MerchantSDKRequest merchantSDKRequest) {
        String str;
        String str2;
        Intent requestIntent;
        Uri data;
        Intent requestIntent2;
        Uri data2;
        MerchantSDKProcessor merchantSDKProcessor = this;
        MerchantRequestChecker merchantRequestChecker = this.requestChecker.get();
        MerchantSDKProcessor merchantSDKProcessor2 = null;
        MerchantSDKProcessor merchantSDKProcessor3 = merchantRequestChecker != null && !merchantRequestChecker.isLogin() ? this : null;
        if (merchantSDKProcessor3 == null) {
            if (merchantSDKRequest == null || (requestIntent2 = merchantSDKRequest.getRequestIntent()) == null || (data2 = requestIntent2.getData()) == null) {
                str = null;
            } else {
                str = data2.getPath();
            }
            this.requestPath = str;
            if (merchantSDKRequest == null || (requestIntent = merchantSDKRequest.getRequestIntent()) == null || (data = requestIntent.getData()) == null) {
                str2 = null;
            } else {
                str2 = data.getQueryParameter("packageName");
            }
            this.responsePackageName = str2;
            String str3 = this.requestPath;
            if (!(str3 != null && str3.length() > 0)) {
                merchantSDKProcessor2 = this;
            }
            return merchantSDKProcessor2 == null;
        }
        MerchantRequestChecker merchantRequestChecker2 = merchantSDKProcessor3.requestChecker.get();
        if (merchantRequestChecker2 != null) {
            merchantRequestChecker2.login(activity, merchantSDKRequest);
        }
        return false;
    }
}
