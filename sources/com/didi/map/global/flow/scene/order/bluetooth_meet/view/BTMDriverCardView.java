package com.didi.map.global.flow.scene.order.bluetooth_meet.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.map.global.flow.scene.order.bluetooth_meet.ViewExtKt;
import com.didiglobal.font.DiDiTypeface;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0013J\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0013R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/map/global/flow/scene/order/bluetooth_meet/view/BTMDriverCardView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarImg", "Landroid/widget/ImageView;", "carImg", "driverName", "Landroid/widget/TextView;", "licensePlateNumber", "manufactor", "bindCar", "", "url", "", "bindDirverAvatar", "initView", "setDriverName", "name", "setLicensePlateNumber", "number", "setManufactor", "info", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BTMDriverCardView.kt */
public final class BTMDriverCardView extends ConstraintLayout {

    /* renamed from: a */
    private ImageView f26527a;

    /* renamed from: b */
    private ImageView f26528b;

    /* renamed from: c */
    private TextView f26529c;

    /* renamed from: d */
    private TextView f26530d;

    /* renamed from: e */
    private TextView f26531e;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BTMDriverCardView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BTMDriverCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BTMDriverCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.btm_driver_card_view, this, true);
        m18814a();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BTMDriverCardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* renamed from: a */
    private final void m18814a() {
        this.f26527a = (ImageView) findViewById(R.id.driver_car_avatar);
        this.f26528b = (ImageView) findViewById(R.id.driver_avatar);
        TextView textView = (TextView) findViewById(R.id.driver_license_plate_number);
        this.f26529c = textView;
        ViewExtKt.setDidiTypeFont(textView, DiDiTypeface.FONT_BOLD);
        TextView textView2 = (TextView) findViewById(R.id.driver_manufacture);
        this.f26530d = textView2;
        ViewExtKt.setDidiTypeFont(textView2, DiDiTypeface.FONT_MEDIUM);
        TextView textView3 = (TextView) findViewById(R.id.driver_name);
        this.f26531e = textView3;
        ViewExtKt.setDidiTypeFont(textView3, DiDiTypeface.FONT_MEDIUM);
    }

    public final void bindCar(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        ImageView imageView = this.f26527a;
        if (imageView != null) {
            ViewExtKt.bindUrl$default(imageView, str, 0, 2, (Object) null);
        }
    }

    public final void bindDirverAvatar(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        ImageView imageView = this.f26528b;
        if (imageView != null) {
            ViewExtKt.bindUrl$default(imageView, str, 0, 2, (Object) null);
        }
    }

    public final void setLicensePlateNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "number");
        TextView textView = this.f26529c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void setManufactor(String str) {
        Intrinsics.checkNotNullParameter(str, "info");
        TextView textView = this.f26530d;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void setDriverName(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        TextView textView = this.f26531e;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
