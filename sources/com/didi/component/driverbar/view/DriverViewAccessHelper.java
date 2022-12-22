package com.didi.component.driverbar.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.component.common.model.DataFieldWrapper;
import com.didi.component.driverbar.AvatarEnlargePopup;
import com.didi.component.driverbar.model.DriverBarCardInfo;
import com.didi.component.driverbar.model.DriverBarFieldInfo;
import com.didi.component.driverbar.model.DriverBarNormalData;
import com.didi.component.driverbar.model.DriverPersonalInfo;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didiglobal.travel.infra.widget.TextViewKt;
import com.didiglobal.travel.util.view.ViewEx;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/component/driverbar/view/DriverViewAccessHelper;", "", "()V", "cardInfo", "Lcom/didi/component/driverbar/model/DriverBarCardInfo;", "isDriverDetailEnabled", "", "()Z", "bindDriverName", "", "view", "Landroid/widget/TextView;", "info", "Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "popupAvatarEnlarge", "context", "Landroid/content/Context;", "setDriverInfo", "comp-driverbar_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DriverViewAccessHelper.kt */
public final class DriverViewAccessHelper {

    /* renamed from: a */
    private DriverBarCardInfo f13024a;

    /* renamed from: a */
    private final boolean m8847a() {
        DriverBarCardInfo driverBarCardInfo = this.f13024a;
        String str = null;
        if (driverBarCardInfo != null) {
            DataFieldWrapper<DriverBarNormalData> normal = driverBarCardInfo.getNormal();
            DriverBarNormalData data = normal == null ? null : normal.getData();
            if (data != null) {
                str = data.getDriverProfileUrl();
            }
            if (str == null) {
                str = "";
            }
        }
        CharSequence charSequence = str;
        return true ^ (charSequence == null || charSequence.length() == 0);
    }

    public final void setDriverInfo(DriverBarCardInfo driverBarCardInfo) {
        Intrinsics.checkNotNullParameter(driverBarCardInfo, "info");
        this.f13024a = driverBarCardInfo;
    }

    public final void bindDriverName(TextView textView, LEGORichInfo lEGORichInfo) {
        SpannableString parseRichInfo;
        if (textView != null) {
            CharSequence charSequence = null;
            if (lEGORichInfo != null) {
                Context context = textView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                CharSequence content = lEGORichInfo.getContent();
                if (!(!(content == null || content.length() == 0))) {
                    lEGORichInfo = null;
                }
                if (!(lEGORichInfo == null || (parseRichInfo = lEGORichInfo.parseRichInfo(context)) == null)) {
                    CharSequence charSequence2 = parseRichInfo;
                    if (!(charSequence2.length() > 0)) {
                        charSequence2 = null;
                    }
                    SpannableString spannableString = (SpannableString) charSequence2;
                    if (spannableString != null) {
                        CharSequence charSequence3 = spannableString;
                        if (charSequence3.length() > 0) {
                            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.driver_card_arrow_right_ic, 0);
                        } else {
                            textView.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                        TextViewKt.setTextWithVisible(textView, charSequence3, true);
                        charSequence = spannableString;
                    }
                }
                charSequence = charSequence;
            }
            if (charSequence == null) {
                textView.setVisibility(8);
            }
        }
    }

    public final void popupAvatarEnlarge(Context context) {
        DriverBarFieldInfo farInfo;
        DriverPersonalInfo driverInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        String str = null;
        View inflateViewAsync = ViewEx.inflateViewAsync(context, (int) R.layout.driver_avatar_enlarge_popup, (ViewGroup) null, false);
        DriverBarCardInfo driverBarCardInfo = this.f13024a;
        if (driverBarCardInfo != null) {
            DataFieldWrapper<DriverBarNormalData> normal = driverBarCardInfo.getNormal();
            DriverBarNormalData data = normal == null ? null : normal.getData();
            if (!(data == null || (farInfo = data.getFarInfo()) == null || (driverInfo = farInfo.getDriverInfo()) == null)) {
                str = driverInfo.getAvatar();
            }
        }
        if (str == null) {
            str = "";
        }
        new AvatarEnlargePopup(context, inflateViewAsync, -1, -1, str).show();
    }
}
