package com.didi.component.framework.pages.carcheck;

import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.CarEvaluateQuestionData;
import com.didi.travel.psnger.model.response.CarOrder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/component/framework/pages/carcheck/CarCheckActivity$getCarResult$1", "Lcom/didi/travel/psnger/common/net/base/ResponseListener;", "Lcom/didi/travel/psnger/model/response/CarEvaluateQuestionData;", "onError", "", "t", "onFail", "onFinish", "onSuccess", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CarCheckActivity.kt */
public final class CarCheckActivity$getCarResult$1 extends ResponseListener<CarEvaluateQuestionData> {
    final /* synthetic */ CarOrder $order;
    final /* synthetic */ CarCheckActivity this$0;

    CarCheckActivity$getCarResult$1(CarCheckActivity carCheckActivity, CarOrder carOrder) {
        this.this$0 = carCheckActivity;
        this.$order = carOrder;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(com.didi.travel.psnger.model.response.CarEvaluateQuestionData r9) {
        /*
            r8 = this;
            super.onSuccess(r9)
            r0 = 0
            if (r9 != 0) goto L_0x0008
            r1 = r0
            goto L_0x000a
        L_0x0008:
            java.lang.String r1 = r9.title
        L_0x000a:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0019
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r1 = 0
            goto L_0x001a
        L_0x0019:
            r1 = 1
        L_0x001a:
            if (r1 != 0) goto L_0x0033
            com.didi.component.framework.pages.carcheck.CarCheckActivity r1 = r8.this$0
            r4 = 2131428062(0x7f0b02de, float:1.8477758E38)
            android.view.View r1 = r1.findViewById(r4)
            com.didi.sdk.webview.WebTitleBar r1 = (com.didi.sdk.webview.WebTitleBar) r1
            if (r1 != 0) goto L_0x002a
            goto L_0x0033
        L_0x002a:
            if (r9 != 0) goto L_0x002e
            r4 = r0
            goto L_0x0030
        L_0x002e:
            java.lang.String r4 = r9.title
        L_0x0030:
            r1.setTitle((java.lang.String) r4)
        L_0x0033:
            long r4 = android.os.SystemClock.uptimeMillis()
            com.didi.component.framework.pages.carcheck.CarCheckActivity r1 = r8.this$0
            long r6 = r1.f13762c
            long r4 = r4 - r6
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.util.Map r1 = (java.util.Map) r1
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.String r5 = "load_time"
            r1.put(r5, r4)
            java.lang.String r4 = "gp_feedbackVehicle_page"
            com.didi.component.business.util.GlobalOmegaUtils.trackEvent((java.lang.String) r4, (java.util.Map<java.lang.String, java.lang.Object>) r1)
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            if (r9 != 0) goto L_0x005c
            r4 = r0
            goto L_0x005e
        L_0x005c:
            java.lang.String r4 = r9.user_reply
        L_0x005e:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x0068
            int r4 = r4.length()
            if (r4 != 0) goto L_0x0069
        L_0x0068:
            r2 = 1
        L_0x0069:
            java.lang.String r3 = "answers"
            if (r2 == 0) goto L_0x00f2
            com.didi.component.framework.pages.carcheck.CarCheckActivity r2 = r8.this$0
            java.lang.String r2 = r2.f13761b
            java.lang.String r4 = "order_id"
            r1.putString(r4, r2)
            if (r9 != 0) goto L_0x007c
            r2 = r0
            goto L_0x007e
        L_0x007c:
            java.lang.String r2 = r9.question_body
        L_0x007e:
            java.lang.String r4 = "question_body"
            r1.putString(r4, r2)
            if (r9 != 0) goto L_0x0087
            r2 = -1
            goto L_0x0091
        L_0x0087:
            int r2 = r9.question_id
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r2 = r2.intValue()
        L_0x0091:
            java.lang.String r4 = "question_id"
            r1.putInt(r4, r2)
            if (r9 != 0) goto L_0x009a
            r9 = r0
            goto L_0x009c
        L_0x009a:
            java.lang.String[] r9 = r9.answers
        L_0x009c:
            r1.putStringArray(r3, r9)
            com.didi.component.framework.pages.carcheck.CarCheckActivity r9 = r8.this$0
            java.lang.String r9 = r9.f13761b
            com.didi.travel.psnger.model.response.CarOrder r2 = r8.$order
            if (r2 != 0) goto L_0x00ab
            r2 = r0
            goto L_0x00ad
        L_0x00ab:
            java.lang.String r2 = r2.oid
        L_0x00ad:
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r2)
            java.lang.String r2 = ""
            if (r9 == 0) goto L_0x00c0
            com.didi.travel.psnger.model.response.CarOrder r9 = r8.$order
            com.didi.travel.psnger.core.model.response.DTSDKDriverModel r9 = r9.carDriver
            if (r9 != 0) goto L_0x00bd
            r9 = r0
            goto L_0x00c1
        L_0x00bd:
            java.lang.String r9 = r9.carType
            goto L_0x00c1
        L_0x00c0:
            r9 = r2
        L_0x00c1:
            java.lang.String r3 = "card_type"
            r1.putString(r3, r9)
            com.didi.component.framework.pages.carcheck.CarCheckActivity r9 = r8.this$0
            java.lang.String r9 = r9.f13761b
            com.didi.travel.psnger.model.response.CarOrder r3 = r8.$order
            if (r3 != 0) goto L_0x00d2
            r3 = r0
            goto L_0x00d4
        L_0x00d2:
            java.lang.String r3 = r3.oid
        L_0x00d4:
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r3)
            if (r9 == 0) goto L_0x00e4
            com.didi.travel.psnger.model.response.CarOrder r9 = r8.$order
            com.didi.travel.psnger.core.model.response.DTSDKDriverModel r9 = r9.carDriver
            if (r9 != 0) goto L_0x00e1
            goto L_0x00e5
        L_0x00e1:
            java.lang.String r0 = r9.card
            goto L_0x00e5
        L_0x00e4:
            r0 = r2
        L_0x00e5:
            java.lang.String r9 = "card_num"
            r1.putString(r9, r0)
            com.didi.component.framework.pages.carcheck.CarCheckActivity r9 = r8.this$0
            java.lang.String r0 = "car_check"
            r9.switchToTargetPage(r0, r1)
            goto L_0x010c
        L_0x00f2:
            if (r9 != 0) goto L_0x00f6
            r2 = r0
            goto L_0x00f8
        L_0x00f6:
            java.lang.String r2 = r9.user_reply
        L_0x00f8:
            java.lang.String r4 = "user_reply"
            r1.putString(r4, r2)
            if (r9 != 0) goto L_0x0100
            goto L_0x0102
        L_0x0100:
            java.lang.String[] r0 = r9.answers
        L_0x0102:
            r1.putStringArray(r3, r0)
            com.didi.component.framework.pages.carcheck.CarCheckActivity r9 = r8.this$0
            java.lang.String r0 = "car_result"
            r9.switchToTargetPage(r0, r1)
        L_0x010c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.pages.carcheck.CarCheckActivity$getCarResult$1.onSuccess(com.didi.travel.psnger.model.response.CarEvaluateQuestionData):void");
    }

    public void onFail(CarEvaluateQuestionData carEvaluateQuestionData) {
        String str;
        super.onFail(carEvaluateQuestionData);
        if (carEvaluateQuestionData == null) {
            str = null;
        } else {
            str = carEvaluateQuestionData.errmsg;
        }
        if (str != null) {
            CarCheckActivity carCheckActivity = this.this$0;
            String errorMsg = carEvaluateQuestionData.getErrorMsg();
            Intrinsics.checkNotNullExpressionValue(errorMsg, "t.errorMsg");
            carCheckActivity.showErrorDialog(errorMsg);
        }
    }

    public void onError(CarEvaluateQuestionData carEvaluateQuestionData) {
        super.onError(carEvaluateQuestionData);
        this.this$0.showErrorView();
    }

    public void onFinish(CarEvaluateQuestionData carEvaluateQuestionData) {
        super.onFinish(carEvaluateQuestionData);
        this.this$0.hideLoading();
    }
}
