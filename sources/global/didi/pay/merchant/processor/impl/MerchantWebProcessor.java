package global.didi.pay.merchant.processor.impl;

import android.app.Activity;
import com.didichuxing.foundation.spi.ServiceLoader;
import global.didi.pay.merchant.processor.MerchantRequestHandler;
import global.didi.pay.merchant.processor.contract.IMerchantWebProcessor;
import global.didi.pay.merchant.processor.model.MerchantWebRequest;
import global.didi.pay.merchantcore.model.DPayRequest;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R?\u0010\u0003\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u00048BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, mo175978d2 = {"Lglobal/didi/pay/merchant/processor/impl/MerchantWebProcessor;", "Lglobal/didi/pay/merchant/processor/contract/IMerchantWebProcessor;", "()V", "requestHandler", "Lcom/didichuxing/foundation/spi/ServiceLoader;", "Lglobal/didi/pay/merchant/processor/MerchantRequestHandler;", "kotlin.jvm.PlatformType", "getRequestHandler", "()Lcom/didichuxing/foundation/spi/ServiceLoader;", "requestHandler$delegate", "Lkotlin/Lazy;", "handleRequest", "", "activity", "Landroid/app/Activity;", "request", "Lglobal/didi/pay/merchant/processor/model/MerchantWebRequest;", "handleResponse", "context", "Landroid/content/Context;", "response", "Lglobal/didi/pay/merchant/processor/model/MerchantWebResponse;", "payMerchantProcessor_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MerchantWebProcessor.kt */
public final class MerchantWebProcessor implements IMerchantWebProcessor {
    private final Lazy requestHandler$delegate = LazyKt.lazy(MerchantWebProcessor$requestHandler$2.INSTANCE);

    private final ServiceLoader<MerchantRequestHandler> getRequestHandler() {
        return (ServiceLoader) this.requestHandler$delegate.getValue();
    }

    public void handleRequest(Activity activity, MerchantWebRequest merchantWebRequest) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (merchantWebRequest != null) {
            Iterator<MerchantRequestHandler> it = getRequestHandler().iterator();
            Intrinsics.checkNotNullExpressionValue(it, "requestHandler.iterator()");
            while (it.hasNext()) {
                it.next().startMerchantRequest(true, activity, merchantWebRequest.type(), merchantWebRequest.getOutTradeId(), (DPayRequest) null, merchantWebRequest.getExtraParam());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
        if (r0 == false) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleResponse(android.content.Context r6, global.didi.pay.merchant.processor.model.MerchantWebResponse r7) {
        /*
            r5 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = r5
            global.didi.pay.merchant.processor.impl.MerchantWebProcessor r0 = (global.didi.pay.merchant.processor.impl.MerchantWebProcessor) r0
            global.didi.pay.merchant.processor.model.MerchantRequestType r0 = r7.type()
            global.didi.pay.merchant.processor.model.MerchantRequestType r1 = global.didi.pay.merchant.processor.model.MerchantRequestType.TYPE_H5
            r2 = 1
            r3 = 0
            r4 = 0
            if (r0 != r1) goto L_0x003d
            boolean r0 = r7 instanceof global.didi.pay.merchant.processor.model.MerchantH5Response
            if (r0 == 0) goto L_0x0020
            r0 = r7
            global.didi.pay.merchant.processor.model.MerchantH5Response r0 = (global.didi.pay.merchant.processor.model.MerchantH5Response) r0
            goto L_0x0021
        L_0x0020:
            r0 = r4
        L_0x0021:
            if (r0 != 0) goto L_0x0025
        L_0x0023:
            r0 = 0
            goto L_0x003a
        L_0x0025:
            java.lang.String r0 = r0.getUrl()
            if (r0 != 0) goto L_0x002c
            goto L_0x0023
        L_0x002c:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0036
            r0 = 1
            goto L_0x0037
        L_0x0036:
            r0 = 0
        L_0x0037:
            if (r0 != r2) goto L_0x0023
            r0 = 1
        L_0x003a:
            if (r0 == 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r2 = 0
        L_0x003e:
            if (r2 == 0) goto L_0x0042
            r0 = r5
            goto L_0x0043
        L_0x0042:
            r0 = r4
        L_0x0043:
            global.didi.pay.merchant.processor.impl.MerchantWebProcessor r0 = (global.didi.pay.merchant.processor.impl.MerchantWebProcessor) r0
            if (r0 != 0) goto L_0x0048
            goto L_0x0077
        L_0x0048:
            boolean r0 = r7 instanceof global.didi.pay.merchant.processor.model.MerchantH5Response
            if (r0 == 0) goto L_0x004f
            global.didi.pay.merchant.processor.model.MerchantH5Response r7 = (global.didi.pay.merchant.processor.model.MerchantH5Response) r7
            goto L_0x0050
        L_0x004f:
            r7 = r4
        L_0x0050:
            if (r7 != 0) goto L_0x0054
            r7 = r4
            goto L_0x0058
        L_0x0054:
            java.lang.String r7 = r7.getUrl()
        L_0x0058:
            android.net.Uri r7 = android.net.Uri.parse(r7)
            boolean r0 = r6 instanceof android.app.Activity     // Catch:{ RuntimeException -> 0x0073 }
            if (r0 == 0) goto L_0x0064
            r0 = r6
            android.app.Activity r0 = (android.app.Activity) r0     // Catch:{ RuntimeException -> 0x0073 }
            goto L_0x0065
        L_0x0064:
            r0 = r4
        L_0x0065:
            if (r0 != 0) goto L_0x0068
            goto L_0x0077
        L_0x0068:
            android.content.Intent r1 = new android.content.Intent     // Catch:{ RuntimeException -> 0x0073 }
            java.lang.String r2 = "android.intent.action.VIEW"
            r1.<init>(r2, r7)     // Catch:{ RuntimeException -> 0x0073 }
            r0.startActivity(r1)     // Catch:{ RuntimeException -> 0x0073 }
            goto L_0x0077
        L_0x0073:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0077:
            boolean r7 = r6 instanceof android.app.Activity
            if (r7 == 0) goto L_0x007c
            r4 = r5
        L_0x007c:
            global.didi.pay.merchant.processor.impl.MerchantWebProcessor r4 = (global.didi.pay.merchant.processor.impl.MerchantWebProcessor) r4
            android.app.Activity r6 = (android.app.Activity) r6
            r6.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: global.didi.pay.merchant.processor.impl.MerchantWebProcessor.handleResponse(android.content.Context, global.didi.pay.merchant.processor.model.MerchantWebResponse):void");
    }
}
