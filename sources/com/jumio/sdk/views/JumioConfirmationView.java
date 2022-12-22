package com.jumio.sdk.views;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.component.comp_xpanel.XPanelScene;
import com.jumio.analytics.Analytics;
import com.jumio.analytics.MobileEvents;
import com.jumio.sdk.enums.JumioScanStep;
import jumio.core.C21357i;
import jumio.core.C21359j;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\b\u0007\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0005\u001a\u00020\u0003¨\u0006\u000f"}, mo175978d2 = {"Lcom/jumio/sdk/views/JumioConfirmationView;", "Ljumio/core/i;", "Ljumio/core/j;", "", "confirm", "retake", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "cornerRadius", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: JumioConfirmationView.kt */
public final class JumioConfirmationView extends C21357i<C21359j> {
    public JumioConfirmationView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
    }

    public JumioConfirmationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
    }

    public JumioConfirmationView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JumioConfirmationView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    public final void confirm() {
        C21359j jVar = (C21359j) getCheckInterface();
        if (jVar != null) {
            jVar.mo163120f();
        }
        Analytics.Companion.add(MobileEvents.userAction$default(XPanelScene.SCENE_CONFIRM, (JumioScanStep) null, (Object) null, 6, (Object) null));
    }

    public final void retake() {
        C21359j jVar = (C21359j) getCheckInterface();
        if (jVar != null) {
            jVar.mo163102a();
        }
        Analytics.Companion.add(MobileEvents.userAction$default("reject", (JumioScanStep) null, (Object) null, 6, (Object) null));
    }

    public JumioConfirmationView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
