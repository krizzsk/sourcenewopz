package com.didi.soda.home.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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

@Metadata(mo175977d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0016\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\bJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\bH\u0002J\u0018\u0010!\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000¨\u0006\""}, mo175978d2 = {"Lcom/didi/soda/home/widget/TabMultiItemView;", "Landroid/widget/RelativeLayout;", "Lcom/didi/soda/home/widget/ITabItemView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "selectedTriangle", "Landroid/widget/ImageView;", "tabDesc", "Lcom/didi/soda/customer/widget/text/RichTextView;", "timeFrame", "timer", "Lcom/didi/soda/customer/widget/TimerView;", "bindData", "", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "tabInfoEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/TabInfoEntity;", "getColorWithAlpha", "alpha", "", "baseColor", "getView", "Landroid/view/View;", "parseColor", "colorString", "", "defaultColorRes", "setCountDown", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TabMultiItemView.kt */
public final class TabMultiItemView extends RelativeLayout implements ITabItemView {

    /* renamed from: a */
    private RichTextView f43326a;

    /* renamed from: b */
    private RichTextView f43327b;

    /* renamed from: c */
    private TimerView f43328c;

    /* renamed from: d */
    private ImageView f43329d;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TabMultiItemView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TabMultiItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TabMultiItemView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabMultiItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.customer_item_landing_tab_multi, this, true);
        View findViewById = inflate.findViewById(R.id.customer_tv_tab_time_frame);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_tv_tab_time_frame)");
        this.f43326a = (RichTextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_tv_tab_tab_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_tv_tab_tab_desc)");
        this.f43327b = (RichTextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_tv_tab_timer);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_tv_tab_timer)");
        this.f43328c = (TimerView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.customer_iv_tab_selected_triangle);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.custom…iv_tab_selected_triangle)");
        this.f43329d = (ImageView) findViewById4;
    }

    public View getView() {
        return this;
    }

    public void bindData(ScopeContext scopeContext, TabInfoEntity tabInfoEntity) {
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        Intrinsics.checkNotNullParameter(tabInfoEntity, "tabInfoEntity");
        int a = m30642a(tabInfoEntity.getBgColor(), (int) R.color.rf_color_white_100_alpha_0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(a);
        gradientDrawable.setGradientType(0);
        RichTextView richTextView = null;
        if (tabInfoEntity.isSelect() == 1) {
            ImageView imageView = this.f43329d;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedTriangle");
                imageView = null;
            }
            imageView.setVisibility(0);
        } else {
            ImageView imageView2 = this.f43329d;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedTriangle");
                imageView2 = null;
            }
            imageView2.setVisibility(8);
        }
        setBackground(gradientDrawable);
        RichTextView richTextView2 = this.f43326a;
        if (richTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeFrame");
            richTextView2 = null;
        }
        String title = tabInfoEntity.getTitle();
        String str = "";
        if (title == null) {
            title = str;
        }
        richTextView2.setText(title);
        if (tabInfoEntity.getCountDown() != null) {
            TimerView timerView = this.f43328c;
            if (timerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timer");
                timerView = null;
            }
            timerView.setVisibility(0);
            RichTextView richTextView3 = this.f43327b;
            if (richTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabDesc");
            } else {
                richTextView = richTextView3;
            }
            richTextView.setVisibility(8);
            m30643a(scopeContext, tabInfoEntity);
            return;
        }
        TimerView timerView2 = this.f43328c;
        if (timerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timer");
            timerView2 = null;
        }
        timerView2.setVisibility(8);
        RichTextView richTextView4 = this.f43327b;
        if (richTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabDesc");
            richTextView4 = null;
        }
        richTextView4.setVisibility(0);
        RichTextView richTextView5 = this.f43327b;
        if (richTextView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabDesc");
        } else {
            richTextView = richTextView5;
        }
        String statusDesc = tabInfoEntity.getStatusDesc();
        if (statusDesc != null) {
            str = statusDesc;
        }
        richTextView.setText(str);
    }

    /* renamed from: a */
    private final void m30643a(ScopeContext scopeContext, TabInfoEntity tabInfoEntity) {
        long localDeadLine = tabInfoEntity.getLocalDeadLine();
        if (localDeadLine == 0) {
            CountDownEntity countDown = tabInfoEntity.getCountDown();
            Intrinsics.checkNotNull(countDown);
            localDeadLine = countDown.getLocalDeadline();
            tabInfoEntity.setLocalDeadLine(localDeadLine);
        }
        TimerView timerView = this.f43328c;
        TimerView timerView2 = null;
        if (timerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timer");
            timerView = null;
        }
        timerView.setScopeContext(scopeContext);
        TimerView timerView3 = this.f43328c;
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
    private final int m30642a(String str, int i) {
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
