package com.didi.soda.home.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.rpc.entity.TabInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.CountDownEntity;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.TimerView;
import com.didi.soda.customer.widget.text.RichTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\bH\u0002J\u0018\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006 "}, mo175978d2 = {"Lcom/didi/soda/home/widget/TabSingleItemView;", "Landroid/widget/LinearLayout;", "Lcom/didi/soda/home/widget/ITabItemView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tabDesc", "Lcom/didi/soda/customer/widget/text/RichTextView;", "timeFrame", "timer", "Lcom/didi/soda/customer/widget/TimerView;", "bindData", "", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "tabInfoEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/TabInfoEntity;", "getColorWithAlpha", "alpha", "", "baseColor", "getView", "Landroid/view/View;", "parseColor", "colorString", "", "defaultColorRes", "setCountDown", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TabSingleItemView.kt */
public final class TabSingleItemView extends LinearLayout implements ITabItemView {

    /* renamed from: a */
    private RichTextView f43330a;

    /* renamed from: b */
    private RichTextView f43331b;

    /* renamed from: c */
    private TimerView f43332c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TabSingleItemView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TabSingleItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TabSingleItemView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabSingleItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.customer_item_landing_tab_single, this, true);
        View findViewById = inflate.findViewById(R.id.customer_tv_tab_time_frame);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_tv_tab_time_frame)");
        this.f43330a = (RichTextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_tv_tab_tab_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_tv_tab_tab_desc)");
        this.f43331b = (RichTextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_tv_tab_timer);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_tv_tab_timer)");
        this.f43332c = (TimerView) findViewById3;
    }

    public View getView() {
        return this;
    }

    public void bindData(ScopeContext scopeContext, TabInfoEntity tabInfoEntity) {
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        Intrinsics.checkNotNullParameter(tabInfoEntity, "tabInfoEntity");
        int a = m30644a(tabInfoEntity.getBgColor(), (int) R.color.rf_color_white_100_alpha_0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(a);
        gradientDrawable.setGradientType(0);
        setBackground(gradientDrawable);
        RichTextView richTextView = this.f43330a;
        RichTextView richTextView2 = null;
        if (richTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeFrame");
            richTextView = null;
        }
        String title = tabInfoEntity.getTitle();
        String str = "";
        if (title == null) {
            title = str;
        }
        richTextView.setText(title);
        if (tabInfoEntity.getCountDown() != null) {
            TimerView timerView = this.f43332c;
            if (timerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timer");
                timerView = null;
            }
            timerView.setVisibility(0);
            RichTextView richTextView3 = this.f43331b;
            if (richTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabDesc");
            } else {
                richTextView2 = richTextView3;
            }
            richTextView2.setVisibility(8);
            m30645a(scopeContext, tabInfoEntity);
            return;
        }
        TimerView timerView2 = this.f43332c;
        if (timerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timer");
            timerView2 = null;
        }
        timerView2.setVisibility(8);
        RichTextView richTextView4 = this.f43331b;
        if (richTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabDesc");
            richTextView4 = null;
        }
        richTextView4.setVisibility(0);
        RichTextView richTextView5 = this.f43331b;
        if (richTextView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabDesc");
        } else {
            richTextView2 = richTextView5;
        }
        String statusDesc = tabInfoEntity.getStatusDesc();
        if (statusDesc != null) {
            str = statusDesc;
        }
        richTextView2.setText(str);
    }

    /* renamed from: a */
    private final void m30645a(ScopeContext scopeContext, TabInfoEntity tabInfoEntity) {
        long localDeadLine = tabInfoEntity.getLocalDeadLine();
        if (localDeadLine == 0) {
            CountDownEntity countDown = tabInfoEntity.getCountDown();
            Intrinsics.checkNotNull(countDown);
            localDeadLine = countDown.getLocalDeadline();
            tabInfoEntity.setLocalDeadLine(localDeadLine);
        }
        TimerView timerView = this.f43332c;
        TimerView timerView2 = null;
        if (timerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timer");
            timerView = null;
        }
        timerView.setScopeContext(scopeContext);
        TimerView timerView3 = this.f43332c;
        if (timerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timer");
        } else {
            timerView2 = timerView3;
        }
        CountDownEntity countDown2 = tabInfoEntity.getCountDown();
        Intrinsics.checkNotNull(countDown2);
        timerView2.setupTimeEntity(localDeadLine, countDown2);
    }

    /* renamed from: a */
    private final int m30644a(String str, int i) {
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

    public final int getColorWithAlpha(float f, int i) {
        return (Math.min(255, Math.max(0, (int) (f * ((float) 255)))) << 24) + (i & 16777215);
    }
}
