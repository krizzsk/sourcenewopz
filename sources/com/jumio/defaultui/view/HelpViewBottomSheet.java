package com.jumio.defaultui.view;

import android.os.Bundle;
import android.view.View;
import com.jumio.sdk.scanpart.JumioScanPart;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\u0006H\u0014¨\u0006\r"}, mo175978d2 = {"Lcom/jumio/defaultui/view/HelpViewBottomSheet;", "Lcom/jumio/defaultui/view/JumioBottomSheet;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "onSecondaryAction", "onDismiss", "<init>", "()V", "Companion", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: HelpViewBottomSheet.kt */
public final class HelpViewBottomSheet extends JumioBottomSheet {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public void onDismiss() {
        getJumioViewModel$jumio_defaultui_release().mo30a(false);
    }

    public void onSecondaryAction() {
        JumioScanPart k = getJumioViewModel$jumio_defaultui_release().mo48k();
        if (k != null) {
            k.fallback();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        getJumioViewModel$jumio_defaultui_release().mo30a(true);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ.\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002¨\u0006\u000b"}, mo175978d2 = {"Lcom/jumio/defaultui/view/HelpViewBottomSheet$Companion;", "", "", "title", "description", "primaryActionButtonText", "secondaryActionButtonText", "Lcom/jumio/defaultui/view/HelpViewBottomSheet;", "newInstance", "<init>", "()V", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: HelpViewBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HelpViewBottomSheet newInstance(String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "description");
            Intrinsics.checkNotNullParameter(str3, "primaryActionButtonText");
            Intrinsics.checkNotNullParameter(str4, "secondaryActionButtonText");
            HelpViewBottomSheet helpViewBottomSheet = new HelpViewBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putString(JumioBottomSheet.TITLE, str);
            bundle.putString(JumioBottomSheet.DESCRIPTION, str2);
            bundle.putString(JumioBottomSheet.PRIMARY_ACTION, str3);
            bundle.putString(JumioBottomSheet.SECONDARY_ACTION, str4);
            Unit unit = Unit.INSTANCE;
            helpViewBottomSheet.setArguments(bundle);
            return helpViewBottomSheet;
        }

        public static /* synthetic */ HelpViewBottomSheet newInstance$default(Companion companion, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "";
            }
            if ((i & 2) != 0) {
                str2 = "";
            }
            if ((i & 4) != 0) {
                str3 = "";
            }
            if ((i & 8) != 0) {
                str4 = "";
            }
            return companion.newInstance(str, str2, str3, str4);
        }
    }
}
