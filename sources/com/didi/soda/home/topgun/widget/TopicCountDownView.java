package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.topgun.CountDownEntity;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.countdown.DurationFormatUtils;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0001OB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ0\u00105\u001a\u00020'2&\u00106\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u000207\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u000207\u0018\u0001`\u0016H\u0016J\u0006\u00108\u001a\u00020\u0011J\u0015\u00109\u001a\u00020\u00152\b\u0010:\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010;J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020'H\u0014J\b\u0010?\u001a\u00020'H\u0014J\u0018\u0010@\u001a\u00020\b2\b\u0010A\u001a\u0004\u0018\u00010\u00152\u0006\u0010B\u001a\u00020\bJ\u0010\u0010C\u001a\u00020'2\u0006\u0010D\u001a\u00020EH\u0016J\u0014\u0010F\u001a\u00020'2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00150HJ\u0018\u0010I\u001a\u00020'2\u0006\u0010J\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ0\u0010K\u001a\u00020\u000b2&\u00106\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u000207\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u000207\u0018\u0001`\u0016H\u0016J\b\u0010L\u001a\u00020'H\u0002J\u000e\u0010M\u001a\u00020'2\u0006\u0010N\u001a\u00020\u0011R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R4\u0010\u0013\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00020\u0014j\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u0002`\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u000200X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006P"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/TopicCountDownView;", "Landroid/widget/RelativeLayout;", "Lcom/didi/soda/blocks/widget/Buildable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "antiShake", "", "getAntiShake", "()Z", "setAntiShake", "(Z)V", "deadline", "", "dotWidth", "dynamicChildren", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDynamicChildren", "()Ljava/util/HashMap;", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/CountDownEntity;", "expireWhenDetach", "Ljava/lang/Runnable;", "isActive", "isHasRemainTimeWhenDetach", "lastTextSize", "getLastTextSize", "()I", "setLastTextSize", "(I)V", "maxNumWidth", "onTimerFinished", "Lkotlin/Function0;", "", "getOnTimerFinished", "()Lkotlin/jvm/functions/Function0;", "setOnTimerFinished", "(Lkotlin/jvm/functions/Function0;)V", "timer", "timerHandler", "Landroid/os/Handler;", "timerText", "Lcom/didi/soda/home/topgun/widget/TopicCountDownTimeView;", "getTimerText", "()Lcom/didi/soda/home/topgun/widget/TopicCountDownTimeView;", "setTimerText", "(Lcom/didi/soda/home/topgun/widget/TopicCountDownTimeView;)V", "bindProps", "props", "", "getRemainTime", "getTimeFormat", "style", "(Ljava/lang/Integer;)Ljava/lang/String;", "getView", "Landroid/view/View;", "onAttachedToWindow", "onDetachedFromWindow", "parseColor", "colorString", "defaultColorRes", "setScope", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "setTextWithFixWidth", "nextTextList", "", "setupTimeEntity", "localDeadLine", "shouldShow", "tearDown", "updateUI", "remainTime", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopicCountDownView.kt */
public final class TopicCountDownView extends RelativeLayout implements Buildable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long TIME_REFRESH_INTERVAL = 1000;

    /* renamed from: a */
    private final Handler f43193a;

    /* renamed from: b */
    private long f43194b;

    /* renamed from: c */
    private CountDownEntity f43195c;

    /* renamed from: d */
    private boolean f43196d;

    /* renamed from: e */
    private boolean f43197e;

    /* renamed from: f */
    private int f43198f;

    /* renamed from: g */
    private int f43199g;

    /* renamed from: h */
    private boolean f43200h;

    /* renamed from: i */
    private Function0<Unit> f43201i;

    /* renamed from: j */
    private final Runnable f43202j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final Runnable f43203k;

    /* renamed from: l */
    private final HashMap<String, Buildable> f43204l;

    /* renamed from: m */
    private TopicCountDownTimeView f43205m;

    /* renamed from: n */
    private int f43206n;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TopicCountDownView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TopicCountDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    public void bindProps(HashMap<String, Object> hashMap) {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TopicCountDownView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public void bindChildren(List<? extends Buildable> list) {
        Buildable.DefaultImpls.bindChildren(this, list);
    }

    public void bindStyles(HashMap<String, Object> hashMap) {
        Buildable.DefaultImpls.bindStyles(this, hashMap);
    }

    public Buildable findWidgetByComponentId(String str, int i) {
        return Buildable.DefaultImpls.findWidgetByComponentId(this, str, i);
    }

    public Buildable getParentWidget() {
        return Buildable.DefaultImpls.getParentWidget(this);
    }

    public Buildable getRoot() {
        return Buildable.DefaultImpls.getRoot(this);
    }

    public boolean handleClickTrigger(IBlockScope iBlockScope, List<? extends BaseAction> list, Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
        return Buildable.DefaultImpls.handleClickTrigger(this, iBlockScope, list, function3);
    }

    public boolean handleOtherTrigger(IBlockScope iBlockScope, String str, List<? extends BaseAction> list, Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
        return Buildable.DefaultImpls.handleOtherTrigger(this, iBlockScope, str, list, function3);
    }

    public boolean handleShownTrigger(IBlockScope iBlockScope, WidgetNodeModel widgetNodeModel, List<? extends BaseAction> list, Function4<? super IBlockScope, ? super WidgetNodeModel, ? super Buildable, ? super List<? extends BaseAction>, Unit> function4) {
        return Buildable.DefaultImpls.handleShownTrigger(this, iBlockScope, widgetNodeModel, list, function4);
    }

    public boolean isRoot() {
        return Buildable.DefaultImpls.isRoot(this);
    }

    public void onBindFinish(HashMap<String, Object> hashMap) {
        Buildable.DefaultImpls.onBindFinish(this, hashMap);
    }

    public void refreshLayout() {
        Buildable.DefaultImpls.refreshLayout(this);
    }

    public void setBinderRootConfig(BinderRootConfig<?> binderRootConfig) {
        Buildable.DefaultImpls.setBinderRootConfig(this, binderRootConfig);
    }

    public void setWidgetNode(WidgetNodeModel widgetNodeModel) {
        Buildable.DefaultImpls.setWidgetNode(this, widgetNodeModel);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopicCountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f43193a = new Handler(Looper.getMainLooper());
        this.f43194b = -1;
        this.f43198f = -1;
        this.f43199g = -1;
        this.f43202j = new Runnable() {
            public final void run() {
                TopicCountDownView.m30543a(TopicCountDownView.this);
            }
        };
        this.f43203k = new Runnable() {
            public final void run() {
                TopicCountDownView.m30544b(TopicCountDownView.this);
            }
        };
        this.f43204l = new HashMap<>();
        LayoutInflater.from(context).inflate(R.layout.customer_home_topic_timer, this);
        View findViewById = findViewById(R.id.customer_tv_timer_right_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_tv_timer_right_view)");
        this.f43205m = (TopicCountDownTimeView) findViewById;
    }

    public final boolean getAntiShake() {
        return this.f43200h;
    }

    public final void setAntiShake(boolean z) {
        this.f43200h = z;
    }

    public final Function0<Unit> getOnTimerFinished() {
        return this.f43201i;
    }

    public final void setOnTimerFinished(Function0<Unit> function0) {
        this.f43201i = function0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30543a(TopicCountDownView topicCountDownView) {
        Function0<Unit> onTimerFinished;
        Intrinsics.checkNotNullParameter(topicCountDownView, "this$0");
        long remainTime = topicCountDownView.getRemainTime();
        topicCountDownView.updateUI(Math.max(remainTime, 0));
        int i = (remainTime > 0 ? 1 : (remainTime == 0 ? 0 : -1));
        if (i > 0 && topicCountDownView.f43196d) {
            topicCountDownView.m30542a();
        }
        if (i <= 0 && (onTimerFinished = topicCountDownView.getOnTimerFinished()) != null) {
            onTimerFinished.invoke();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m30544b(TopicCountDownView topicCountDownView) {
        Intrinsics.checkNotNullParameter(topicCountDownView, "this$0");
        Function0<Unit> onTimerFinished = topicCountDownView.getOnTimerFinished();
        if (onTimerFinished != null) {
            onTimerFinished.invoke();
        }
    }

    public HashMap<String, Buildable> getDynamicChildren() {
        return this.f43204l;
    }

    public final TopicCountDownTimeView getTimerText() {
        return this.f43205m;
    }

    public final void setTimerText(TopicCountDownTimeView topicCountDownTimeView) {
        Intrinsics.checkNotNullParameter(topicCountDownTimeView, "<set-?>");
        this.f43205m = topicCountDownTimeView;
    }

    public final int getLastTextSize() {
        return this.f43206n;
    }

    public final void setLastTextSize(int i) {
        this.f43206n = i;
    }

    /* renamed from: a */
    private final void m30542a() {
        this.f43193a.postDelayed(this.f43202j, 1000);
    }

    public void setScope(IBlockScope iBlockScope) {
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        ScopeContext scopeContext = (ScopeContext) iBlockScope.getObject(Const.BusinessConst.SCOPE_KEY_SCOPE_CONTEXT);
        if (scopeContext != null) {
            scopeContext.addObserver(new TopicCountDownView$setScope$1(this));
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f43193a.removeCallbacks(this.f43202j);
        this.f43196d = false;
        long remainTime = getRemainTime();
        if (remainTime > 0) {
            this.f43197e = true;
            getHandler().postDelayed(this.f43203k, remainTime);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getHandler().removeCallbacks(this.f43203k);
        if (!this.f43196d && this.f43197e) {
            this.f43197e = false;
            this.f43196d = true;
            this.f43202j.run();
        }
    }

    public final void setupTimeEntity(long j, CountDownEntity countDownEntity) {
        if (countDownEntity != null) {
            this.f43195c = countDownEntity;
            this.f43194b = j;
            long remainTime = getRemainTime();
            int i = (remainTime > 0 ? 1 : (remainTime == 0 ? 0 : -1));
            if (i < 0) {
                LogUtil.m29104i("TimerWidget", ">>>>>>>>异常<<<<<<<< 剩余时间 = " + remainTime + "。当前时间 = " + System.currentTimeMillis() + " 截止时间 = " + this.f43194b + ' ');
            }
            this.f43193a.removeCallbacks(this.f43202j);
            if (this.f43194b <= 0 || i <= 0) {
                getTimerText().setVisibility(8);
                return;
            }
            getTimerText().setVisibility(0);
            this.f43196d = true;
            this.f43202j.run();
        }
    }

    public final long getRemainTime() {
        return this.f43194b - System.currentTimeMillis();
    }

    public final void updateUI(long j) {
        CountDownEntity countDownEntity = this.f43195c;
        String formatDuration = DurationFormatUtils.formatDuration(j, getTimeFormat(countDownEntity == null ? null : Integer.valueOf(countDownEntity.getStyle())));
        Intrinsics.checkNotNullExpressionValue(formatDuration, "formatDuration");
        setTextWithFixWidth(StringsKt.split$default((CharSequence) formatDuration, new String[]{":"}, false, 0, 6, (Object) null));
    }

    public final String getTimeFormat(Integer num) {
        if ((num != null && num.intValue() == 1) || num == null || num.intValue() != 3) {
            return "HH:mm:ss";
        }
        return "dd:HH:mm:ss";
    }

    public final void setTextWithFixWidth(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "nextTextList");
        this.f43205m.setData(list);
    }

    public View getView() {
        return this;
    }

    public boolean shouldShow(HashMap<String, Object> hashMap) {
        return hashMap != null && hashMap.size() > 0;
    }

    public final int parseColor(String str, int i) {
        if (str == null) {
            return ResourceHelper.getColor(i);
        }
        try {
            return Color.parseColor(str);
        } catch (Exception e) {
            e.printStackTrace();
            return ResourceHelper.getColor(i);
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/TopicCountDownView$Companion;", "", "()V", "TIME_REFRESH_INTERVAL", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: TopicCountDownView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
