package com.didi.soda.home.foster;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.sdk.app.sapanel.ICardVisibleListener;
import com.didi.soda.customer.blocks.widget.ScrollWidget;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\b\u0010\u0013\u001a\u00020\u0011H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/soda/home/foster/FosterContainer;", "Landroid/widget/FrameLayout;", "Lcom/didi/sdk/app/sapanel/ICardVisibleListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "componentEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/ComponentEntity;", "recId", "", "view", "Landroid/view/View;", "addFosterView", "", "bindTrackData", "cardWillDisplay", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerTemplateView.kt */
final class FosterContainer extends FrameLayout implements ICardVisibleListener {

    /* renamed from: a */
    private View f42645a;

    /* renamed from: b */
    private ComponentEntity f42646b;

    /* renamed from: c */
    private String f42647c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FosterContainer(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FosterContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* renamed from: a */
    public void mo106970a() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FosterContainer(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FosterContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* renamed from: a */
    public final void mo106971a(View view) {
        this.f42645a = view;
        if (view != null) {
            addView(view);
        }
    }

    /* renamed from: a */
    public final void mo106972a(ComponentEntity componentEntity, String str) {
        this.f42646b = componentEntity;
        this.f42647c = str;
    }

    public void cardWillDisplay() {
        LogUtil.m29100d("TAG", " >>>> cardWillDisplay <<<<< ");
        View view = this.f42645a;
        if (view instanceof ScrollWidget) {
            ((ScrollWidget) view).post(new Runnable(this) {
                public final /* synthetic */ FosterContainer f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    FosterContainer.m30123a(View.this, this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30123a(View view, FosterContainer fosterContainer) {
        Intrinsics.checkNotNullParameter(fosterContainer, "this$0");
        new FosterTrackHelper().trackFirstVisibleChildren((ScrollWidget) view, fosterContainer.f42646b, fosterContainer.f42647c);
    }
}
