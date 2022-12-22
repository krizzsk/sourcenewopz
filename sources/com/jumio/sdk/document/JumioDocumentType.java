package com.jumio.sdk.document;

import android.content.Context;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, mo175978d2 = {"Lcom/jumio/sdk/document/JumioDocumentType;", "", "", "toString", "Landroid/content/Context;", "c", "getLocalizedName", "<init>", "(Ljava/lang/String;I)V", "Companion", "PASSPORT", "VISA", "DRIVING_LICENSE", "ID_CARD", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: JumioDocumentType.kt */
public enum JumioDocumentType {
    PASSPORT,
    VISA,
    DRIVING_LICENSE,
    ID_CARD;
    
    public static final Companion Companion = null;
    private static final String TYPE_DRIVER_LICENSE = "DRIVER_LICENSE";
    private static final String TYPE_DRIVING_LICENSE = "DRIVING_LICENSE";
    private static final String TYPE_ID_CARD = "ID_CARD";
    private static final String TYPE_PASSPORT = "PASSPORT";
    private static final String TYPE_VISA = "VISA";

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u000b¨\u0006\u0012"}, mo175978d2 = {"Lcom/jumio/sdk/document/JumioDocumentType$Companion;", "", "", "id", "Lcom/jumio/sdk/document/JumioDocumentType;", "fromString", "localizedDocument", "Landroid/content/Context;", "c", "fromLocalizedName", "TYPE_DRIVER_LICENSE", "Ljava/lang/String;", "TYPE_DRIVING_LICENSE", "TYPE_ID_CARD", "TYPE_PASSPORT", "TYPE_VISA", "<init>", "()V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: JumioDocumentType.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final JumioDocumentType fromLocalizedName(String str, Context context) {
            Intrinsics.checkNotNullParameter(str, "localizedDocument");
            Intrinsics.checkNotNullParameter(context, "c");
            if (Intrinsics.areEqual((Object) str, (Object) context.getString(R.string.jumio_idtype_pp))) {
                return JumioDocumentType.PASSPORT;
            }
            if (Intrinsics.areEqual((Object) str, (Object) context.getString(R.string.jumio_idtype_dl))) {
                return JumioDocumentType.DRIVING_LICENSE;
            }
            if (Intrinsics.areEqual((Object) str, (Object) context.getString(R.string.jumio_idtype_visa))) {
                return JumioDocumentType.VISA;
            }
            if (Intrinsics.areEqual((Object) str, (Object) context.getString(R.string.jumio_idtype_id))) {
                return JumioDocumentType.ID_CARD;
            }
            return null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
            if (r2.equals(com.jumio.sdk.document.JumioDocumentType.TYPE_DRIVING_LICENSE) == false) goto L_0x0046;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return com.jumio.sdk.document.JumioDocumentType.DRIVING_LICENSE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002b, code lost:
            if (r2.equals(com.jumio.sdk.document.JumioDocumentType.TYPE_DRIVER_LICENSE) == false) goto L_0x0046;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.jumio.sdk.document.JumioDocumentType fromString(java.lang.String r2) {
            /*
                r1 = this;
                java.lang.String r0 = "id"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                int r0 = r2.hashCode()
                switch(r0) {
                    case -1895130188: goto L_0x003a;
                    case -1808062583: goto L_0x002e;
                    case -1302291702: goto L_0x0025;
                    case 2634817: goto L_0x0019;
                    case 1999404050: goto L_0x000d;
                    default: goto L_0x000c;
                }
            L_0x000c:
                goto L_0x0046
            L_0x000d:
                java.lang.String r0 = "PASSPORT"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0016
                goto L_0x0046
            L_0x0016:
                com.jumio.sdk.document.JumioDocumentType r2 = com.jumio.sdk.document.JumioDocumentType.PASSPORT
                goto L_0x0047
            L_0x0019:
                java.lang.String r0 = "VISA"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0022
                goto L_0x0046
            L_0x0022:
                com.jumio.sdk.document.JumioDocumentType r2 = com.jumio.sdk.document.JumioDocumentType.VISA
                goto L_0x0047
            L_0x0025:
                java.lang.String r0 = "DRIVER_LICENSE"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0037
                goto L_0x0046
            L_0x002e:
                java.lang.String r0 = "DRIVING_LICENSE"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0037
                goto L_0x0046
            L_0x0037:
                com.jumio.sdk.document.JumioDocumentType r2 = com.jumio.sdk.document.JumioDocumentType.DRIVING_LICENSE
                goto L_0x0047
            L_0x003a:
                java.lang.String r0 = "ID_CARD"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0043
                goto L_0x0046
            L_0x0043:
                com.jumio.sdk.document.JumioDocumentType r2 = com.jumio.sdk.document.JumioDocumentType.ID_CARD
                goto L_0x0047
            L_0x0046:
                r2 = 0
            L_0x0047:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.sdk.document.JumioDocumentType.Companion.fromString(java.lang.String):com.jumio.sdk.document.JumioDocumentType");
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {}, mo175978d2 = {}, mo175979k = 3, mo175980mv = {1, 5, 1})
    /* compiled from: JumioDocumentType.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] iArr = new int[JumioDocumentType.values().length];
            iArr[JumioDocumentType.PASSPORT.ordinal()] = 1;
            iArr[JumioDocumentType.VISA.ordinal()] = 2;
            iArr[JumioDocumentType.DRIVING_LICENSE.ordinal()] = 3;
            iArr[JumioDocumentType.ID_CARD.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    public final String getLocalizedName(Context context) {
        int i;
        Intrinsics.checkNotNullParameter(context, "c");
        int i2 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i2 == 1) {
            i = R.string.jumio_idtype_pp;
        } else if (i2 == 2) {
            i = R.string.jumio_idtype_visa;
        } else if (i2 == 3) {
            i = R.string.jumio_idtype_dl;
        } else if (i2 == 4) {
            i = R.string.jumio_idtype_id;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (i == 0) {
            return "";
        }
        String string = context.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "c.getString(documentString)");
        return string;
    }

    public String toString() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return TYPE_PASSPORT;
        }
        if (i == 2) {
            return TYPE_VISA;
        }
        if (i == 3) {
            return TYPE_DRIVING_LICENSE;
        }
        if (i == 4) {
            return TYPE_ID_CARD;
        }
        throw new NoWhenBranchMatchedException();
    }
}
