package com.didi.entrega.info.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.didi.entrega.customer.widget.support.CustomerAppCompatTextView;
import com.didi.raven.config.RavenKey;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/entrega/info/widget/EntregaCustomerInfoProgressView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "setCurrentStep", "", "currentStep", "setTitleTxt", "txt", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EntregaCustomerInfoProgressView.kt */
public final class EntregaCustomerInfoProgressView extends ConstraintLayout {
    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EntregaCustomerInfoProgressView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.entrega_info_header_progress_view, this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EntregaCustomerInfoProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.entrega_info_header_progress_view, this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EntregaCustomerInfoProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.entrega_info_header_progress_view, this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EntregaCustomerInfoProgressView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
        LayoutInflater.from(getContext()).inflate(R.layout.entrega_info_header_progress_view, this);
    }

    public final void setCurrentStep(int i) {
        ((CustomerAppCompatTextView) findViewById(R.id.tv_current_step)).setText(String.valueOf(i));
        ((CustomerAppCompatTextView) findViewById(R.id.tv_progress_1)).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.entrega_info_customer_shape_round_progress_grey));
        ((CustomerAppCompatTextView) findViewById(R.id.tv_progress_2)).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.entrega_info_customer_shape_round_progress_grey));
        ((CustomerAppCompatTextView) findViewById(R.id.tv_progress_3)).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.entrega_info_customer_shape_round_progress_grey));
        if (i == 1) {
            ((CustomerAppCompatTextView) findViewById(R.id.tv_progress_1)).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.entrega_info_customer_shape_round_progress_brands));
        } else if (i == 2) {
            ((CustomerAppCompatTextView) findViewById(R.id.tv_progress_1)).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.entrega_info_customer_shape_round_progress_brands));
            ((CustomerAppCompatTextView) findViewById(R.id.tv_progress_2)).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.entrega_info_customer_shape_round_progress_brands));
        } else if (i == 3) {
            ((CustomerAppCompatTextView) findViewById(R.id.tv_progress_1)).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.entrega_info_customer_shape_round_progress_brands));
            ((CustomerAppCompatTextView) findViewById(R.id.tv_progress_2)).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.entrega_info_customer_shape_round_progress_brands));
            ((CustomerAppCompatTextView) findViewById(R.id.tv_progress_3)).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.entrega_info_customer_shape_round_progress_brands));
        }
    }

    public final void setTitleTxt(String str) {
        Intrinsics.checkNotNullParameter(str, "txt");
        ((CustomerAppCompatTextView) findViewById(R.id.tv_title)).setText(str);
    }
}
