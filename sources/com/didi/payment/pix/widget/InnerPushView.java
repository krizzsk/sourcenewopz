package com.didi.payment.pix.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.soda.customer.p165h5.hybird.model.GuideParamModel;
import com.pay99.diff_base.model.WalletPushInfo;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/payment/pix/widget/InnerPushView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "set", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "attr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tvContent", "Landroid/widget/TextView;", "onAttachedToWindow", "", "onDetachedFromWindow", "onPushEvent", "info", "Lcom/pay99/diff_base/model/WalletPushInfo;", "setContent", "content", "", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InnerPushView.kt */
public final class InnerPushView extends FrameLayout {

    /* renamed from: a */
    private final TextView f31283a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InnerPushView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.layout_inner_push_view, this, true);
        View findViewById = findViewById(R.id.tv_content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_content)");
        this.f31283a = (TextView) findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InnerPushView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, GuideParamModel.ACTION_SET);
        LayoutInflater.from(getContext()).inflate(R.layout.layout_inner_push_view, this, true);
        View findViewById = findViewById(R.id.tv_content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_content)");
        this.f31283a = (TextView) findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InnerPushView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, GuideParamModel.ACTION_SET);
        LayoutInflater.from(getContext()).inflate(R.layout.layout_inner_push_view, this, true);
        View findViewById = findViewById(R.id.tv_content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_content)");
        this.f31283a = (TextView) findViewById;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EventBus.getDefault().unregister(this);
    }

    private final void setContent(String str) {
        this.f31283a.setText(str);
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onPushEvent(WalletPushInfo walletPushInfo) {
        Intrinsics.checkNotNullParameter(walletPushInfo, "info");
        String content = walletPushInfo.getContent();
        if (content != null) {
            EventBus.getDefault().removeStickyEvent((Object) walletPushInfo);
            setVisibility(0);
            setContent(content);
        }
    }
}
