package com.didi.soda.business.manager;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import com.didi.soda.business.widget.BusinessDeliveryFeeTips;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0003\u001a\u001b\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\nJ\u0006\u0010\u0010\u001a\u00020\nJH\u0010\u0011\u001a\u00020\n2&\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00142\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/soda/business/manager/BusinessDeliveryFeeTipsManager;", "", "()V", "TAG", "", "mCountDownTimer", "Landroid/os/CountDownTimer;", "mTipsView", "Lcom/didi/soda/business/widget/BusinessDeliveryFeeTips;", "attachToParent", "", "parent", "Landroid/view/ViewGroup;", "ctx", "Landroid/content/Context;", "hideTipsView", "release", "showDeliveryFeeTips", "properties", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "anchorView", "Landroid/view/View;", "triggerCountDownTimer", "duration", "", "Companion", "DeliverFeeDismissTimer", "Holder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessDeliveryFeeTipsManager.kt */
public final class BusinessDeliveryFeeTipsManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long INTERVAL_TIME_OF_COUNT_DOWN = 1000;
    public static final int STATUS_OF_CHECK_NEW_GUIDE = 1;
    public static final String TIPS_CONTENT_NAME = "content";
    public static final String TIPS_DURATION = "duration";
    public static final String TIPS_EVENT_NAME = "showTips";
    public static final String TIPS_MAX_LINE = "maxLine";
    public static final long TOTAL_TIME_OF_COUNT_DOWN = 5000;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static BusinessDeliveryFeeTipsManager f39670d = Holder.INSTANCE.getHolder();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f39671a;

    /* renamed from: b */
    private BusinessDeliveryFeeTips f39672b;

    /* renamed from: c */
    private CountDownTimer f39673c;

    public /* synthetic */ BusinessDeliveryFeeTipsManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private BusinessDeliveryFeeTipsManager() {
        this.f39671a = "BusinessDeliveryFeeTipsManager";
    }

    /* renamed from: a */
    private final void m28267a(ViewGroup viewGroup, Context context) {
        BusinessDeliveryFeeTips businessDeliveryFeeTips = this.f39672b;
        if ((businessDeliveryFeeTips == null ? null : businessDeliveryFeeTips.getParent()) == null) {
            BusinessDeliveryFeeTips businessDeliveryFeeTips2 = new BusinessDeliveryFeeTips(context);
            viewGroup.addView(businessDeliveryFeeTips2, new ViewGroup.LayoutParams(-1, -1));
            businessDeliveryFeeTips2.setVisibility(0);
            businessDeliveryFeeTips2.setEnableTransition(false);
            Unit unit = Unit.INSTANCE;
            this.f39672b = businessDeliveryFeeTips2;
        }
    }

    public final void showDeliveryFeeTips(HashMap<String, Object> hashMap, ViewGroup viewGroup, View view, Context context) {
        String str;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Intrinsics.checkNotNullParameter(context, "ctx");
        if (view == null) {
            LogUtil.m29104i(this.f39671a, "parent and anchor view is null");
        } else if (hashMap == null) {
            LogUtil.m29104i(this.f39671a, "properties is null");
        } else {
            BusinessDeliveryFeeTips businessDeliveryFeeTips = this.f39672b;
            boolean z = false;
            int i = 1;
            if (businessDeliveryFeeTips != null && businessDeliveryFeeTips.isShown()) {
                z = true;
            }
            if (z) {
                LogUtil.m29104i(this.f39671a, "tips is shown");
                return;
            }
            if (hashMap.get("content") == null || !(hashMap.get("content") instanceof String)) {
                str = "";
            } else {
                Object obj = hashMap.get("content");
                if (obj != null) {
                    str = (String) obj;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }
            if (hashMap.get(TIPS_MAX_LINE) != null && (hashMap.get(TIPS_MAX_LINE) instanceof String)) {
                try {
                    Object obj2 = hashMap.get(TIPS_MAX_LINE);
                    if (obj2 != null) {
                        i = Integer.parseInt((String) obj2);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } catch (Exception e) {
                    LogUtil.m29104i(this.f39671a, Intrinsics.stringPlus("maxLine parse error:", e.getMessage()));
                }
            }
            float f = 0.0f;
            if (hashMap.get("duration") != null && (hashMap.get("duration") instanceof String)) {
                try {
                    Object obj3 = hashMap.get("duration");
                    if (obj3 != null) {
                        f = Float.parseFloat((String) obj3);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } catch (Exception e2) {
                    LogUtil.m29104i(this.f39671a, Intrinsics.stringPlus(" duration parse error:", e2.getMessage()));
                }
            }
            m28267a(viewGroup, context);
            BusinessDeliveryFeeTips businessDeliveryFeeTips2 = this.f39672b;
            if (businessDeliveryFeeTips2 != null) {
                businessDeliveryFeeTips2.setContentMaxLine(i);
            }
            BusinessDeliveryFeeTips businessDeliveryFeeTips3 = this.f39672b;
            if (businessDeliveryFeeTips3 != null) {
                businessDeliveryFeeTips3.setText((CharSequence) str);
            }
            BusinessDeliveryFeeTips businessDeliveryFeeTips4 = this.f39672b;
            if (businessDeliveryFeeTips4 != null) {
                businessDeliveryFeeTips4.setOnCloseListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        BusinessDeliveryFeeTipsManager.m28268a(BusinessDeliveryFeeTipsManager.this, view);
                    }
                });
            }
            BusinessDeliveryFeeTips businessDeliveryFeeTips5 = this.f39672b;
            if (businessDeliveryFeeTips5 != null) {
                businessDeliveryFeeTips5.bindAnchorView(view);
            }
            triggerCountDownTimer(f);
            LogUtil.m29104i(this.f39671a, Intrinsics.stringPlus("deliveryfeetips show success and properties is ", GsonUtil.toJson(hashMap)));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28268a(BusinessDeliveryFeeTipsManager businessDeliveryFeeTipsManager, View view) {
        Intrinsics.checkNotNullParameter(businessDeliveryFeeTipsManager, "this$0");
        businessDeliveryFeeTipsManager.hideTipsView();
    }

    public final void hideTipsView() {
        LogUtil.m29104i(this.f39671a, "hideTipsView");
        BusinessDeliveryFeeTips businessDeliveryFeeTips = this.f39672b;
        if (!(businessDeliveryFeeTips == null || businessDeliveryFeeTips.getParent() == null || businessDeliveryFeeTips.getVisibility() != 0)) {
            businessDeliveryFeeTips.setVisibility(8);
        }
        CountDownTimer countDownTimer = this.f39673c;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public final void triggerCountDownTimer(float f) {
        CountDownTimer countDownTimer = this.f39673c;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (f > 0.0f) {
            CountDownTimer deliverFeeDismissTimer = new DeliverFeeDismissTimer(this, (long) (f * ((float) 1000)), 1000);
            this.f39673c = deliverFeeDismissTimer;
            if (deliverFeeDismissTimer != null) {
                deliverFeeDismissTimer.start();
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/business/manager/BusinessDeliveryFeeTipsManager$DeliverFeeDismissTimer;", "Landroid/os/CountDownTimer;", "totalTime", "", "intervalTIme", "(Lcom/didi/soda/business/manager/BusinessDeliveryFeeTipsManager;JJ)V", "getIntervalTIme", "()J", "getTotalTime", "onFinish", "", "onTick", "millisUntilFinished", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BusinessDeliveryFeeTipsManager.kt */
    public final class DeliverFeeDismissTimer extends CountDownTimer {
        private final long intervalTIme;
        final /* synthetic */ BusinessDeliveryFeeTipsManager this$0;
        private final long totalTime;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeliverFeeDismissTimer(BusinessDeliveryFeeTipsManager businessDeliveryFeeTipsManager, long j, long j2) {
            super(j, j2);
            Intrinsics.checkNotNullParameter(businessDeliveryFeeTipsManager, "this$0");
            this.this$0 = businessDeliveryFeeTipsManager;
            this.totalTime = j;
            this.intervalTIme = j2;
        }

        public final long getIntervalTIme() {
            return this.intervalTIme;
        }

        public final long getTotalTime() {
            return this.totalTime;
        }

        public void onTick(long j) {
            LogUtil.m29100d(this.this$0.f39671a, "DeliverFeeDismissTimer onTick");
        }

        public void onFinish() {
            LogUtil.m29100d(this.this$0.f39671a, "DeliverFeeDismissTimer onFinish");
            this.this$0.hideTipsView();
        }
    }

    public final void release() {
        LogUtil.m29100d(this.f39671a, "release");
        hideTipsView();
        this.f39673c = null;
        this.f39672b = null;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/business/manager/BusinessDeliveryFeeTipsManager$Holder;", "", "()V", "holder", "Lcom/didi/soda/business/manager/BusinessDeliveryFeeTipsManager;", "getHolder", "()Lcom/didi/soda/business/manager/BusinessDeliveryFeeTipsManager;", "setHolder", "(Lcom/didi/soda/business/manager/BusinessDeliveryFeeTipsManager;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BusinessDeliveryFeeTipsManager.kt */
    private static final class Holder {
        public static final Holder INSTANCE = new Holder();
        private static BusinessDeliveryFeeTipsManager holder = new BusinessDeliveryFeeTipsManager((DefaultConstructorMarker) null);

        private Holder() {
        }

        public final BusinessDeliveryFeeTipsManager getHolder() {
            return holder;
        }

        public final void setHolder(BusinessDeliveryFeeTipsManager businessDeliveryFeeTipsManager) {
            Intrinsics.checkNotNullParameter(businessDeliveryFeeTipsManager, "<set-?>");
            holder = businessDeliveryFeeTipsManager;
        }
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/soda/business/manager/BusinessDeliveryFeeTipsManager$Companion;", "", "()V", "INTERVAL_TIME_OF_COUNT_DOWN", "", "STATUS_OF_CHECK_NEW_GUIDE", "", "TIPS_CONTENT_NAME", "", "TIPS_DURATION", "TIPS_EVENT_NAME", "TIPS_MAX_LINE", "TOTAL_TIME_OF_COUNT_DOWN", "<set-?>", "Lcom/didi/soda/business/manager/BusinessDeliveryFeeTipsManager;", "instance", "getInstance", "()Lcom/didi/soda/business/manager/BusinessDeliveryFeeTipsManager;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BusinessDeliveryFeeTipsManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BusinessDeliveryFeeTipsManager getInstance() {
            return BusinessDeliveryFeeTipsManager.f39670d;
        }
    }
}
