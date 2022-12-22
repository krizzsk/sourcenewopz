package com.jumio.defaultui.view;

import android.os.Bundle;
import com.jumio.sdk.document.JumioDocument;
import com.jumio.sdk.document.JumioDocumentType;
import com.jumio.sdk.document.JumioDocumentVariant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\b\u001a\u00020\u0006H\u0014¨\u0006\f"}, mo175978d2 = {"Lcom/jumio/defaultui/view/VariantBottomSheet;", "Lcom/jumio/defaultui/view/JumioBottomSheet;", "Lcom/jumio/sdk/document/JumioDocumentVariant;", "variant", "Lcom/jumio/sdk/document/JumioDocument;", "toJumioDocument", "", "onPrimaryAction", "onSecondaryAction", "<init>", "()V", "Companion", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: VariantBottomSheet.kt */
public final class VariantBottomSheet extends JumioBottomSheet {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DOCUMENT_TYPE = "VARIANT_BUTTOM_SHEET_DOCUMENT_TYPE";

    private final JumioDocument toJumioDocument(JumioDocumentVariant jumioDocumentVariant) {
        Bundle arguments = getArguments();
        JumioDocumentType jumioDocumentType = (JumioDocumentType) (arguments == null ? null : arguments.getSerializable(DOCUMENT_TYPE));
        if (jumioDocumentType == null) {
            return null;
        }
        return new JumioDocument(jumioDocumentType, jumioDocumentVariant);
    }

    public void onPrimaryAction() {
        getJumioViewModel$jumio_defaultui_release().mo28a(getJumioViewModel$jumio_defaultui_release().mo51n(), toJumioDocument(JumioDocumentVariant.PLASTIC));
    }

    public void onSecondaryAction() {
        getJumioViewModel$jumio_defaultui_release().mo28a(getJumioViewModel$jumio_defaultui_release().mo51n(), toJumioDocument(JumioDocumentVariant.PAPER));
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ8\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004R\u0016\u0010\u000b\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, mo175978d2 = {"Lcom/jumio/defaultui/view/VariantBottomSheet$Companion;", "", "Lcom/jumio/sdk/document/JumioDocumentType;", "selectedDocumentType", "", "title", "description", "primaryActionButtonText", "secondaryActionButtonText", "Lcom/jumio/defaultui/view/VariantBottomSheet;", "newInstance", "DOCUMENT_TYPE", "Ljava/lang/String;", "<init>", "()V", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: VariantBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VariantBottomSheet newInstance(JumioDocumentType jumioDocumentType, String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "description");
            Intrinsics.checkNotNullParameter(str3, "primaryActionButtonText");
            Intrinsics.checkNotNullParameter(str4, "secondaryActionButtonText");
            VariantBottomSheet variantBottomSheet = new VariantBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putSerializable(VariantBottomSheet.DOCUMENT_TYPE, jumioDocumentType);
            bundle.putString(JumioBottomSheet.TITLE, str);
            bundle.putString(JumioBottomSheet.DESCRIPTION, str2);
            bundle.putString(JumioBottomSheet.PRIMARY_ACTION, str3);
            bundle.putString(JumioBottomSheet.SECONDARY_ACTION, str4);
            Unit unit = Unit.INSTANCE;
            variantBottomSheet.setArguments(bundle);
            return variantBottomSheet;
        }

        public static /* synthetic */ VariantBottomSheet newInstance$default(Companion companion, JumioDocumentType jumioDocumentType, String str, String str2, String str3, String str4, int i, Object obj) {
            return companion.newInstance(jumioDocumentType, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4);
        }
    }
}
