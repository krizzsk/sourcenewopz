package com.didi.nova.kyc.jumio;

import com.jumio.sdk.credentials.JumioCredentialInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DDCustomActivity.kt */
final class DDCustomActivity$setupCredential$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ JumioCredentialInfo $credentialInfo;
    final /* synthetic */ DDCustomActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DDCustomActivity$setupCredential$1(DDCustomActivity dDCustomActivity, JumioCredentialInfo jumioCredentialInfo) {
        super(0);
        this.this$0 = dDCustomActivity;
        this.$credentialInfo = jumioCredentialInfo;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.jumio.sdk.document.JumioDocument} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.jumio.sdk.document.JumioDocument} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.jumio.sdk.document.JumioDocument} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.jumio.sdk.document.JumioDocument} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: com.jumio.sdk.document.JumioDocument} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.jumio.sdk.document.JumioDocument} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke() {
        /*
            r9 = this;
            com.didi.nova.kyc.jumio.DDCustomActivity r0 = r9.this$0
            com.jumio.sdk.credentials.JumioCredential r0 = r0.f29333o
            if (r0 != 0) goto L_0x0009
            goto L_0x000c
        L_0x0009:
            r0.finish()
        L_0x000c:
            com.didi.nova.kyc.jumio.DDCustomActivity r0 = r9.this$0
            r1 = 0
            r0.f29333o = r1
            com.didi.nova.kyc.jumio.DDCustomActivity r0 = r9.this$0
            com.jumio.sdk.credentials.JumioCredentialInfo r2 = r9.$credentialInfo
            if (r2 != 0) goto L_0x001a
            r2 = r1
            goto L_0x002a
        L_0x001a:
            com.jumio.sdk.controller.JumioController r3 = r0.f29332n
            if (r3 != 0) goto L_0x0026
            java.lang.String r3 = "jumioController"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r3 = r1
        L_0x0026:
            com.jumio.sdk.credentials.JumioCredential r2 = r3.start(r2)
        L_0x002a:
            r0.f29333o = r2
            com.didi.nova.kyc.jumio.DDCustomActivity r0 = r9.this$0
            com.jumio.sdk.credentials.JumioCredential r0 = r0.f29333o
            if (r0 != 0) goto L_0x0037
            goto L_0x00d0
        L_0x0037:
            com.didi.nova.kyc.jumio.DDCustomActivity r2 = r9.this$0
            boolean r3 = r0 instanceof com.jumio.sdk.credentials.JumioIDCredential
            if (r3 == 0) goto L_0x00a7
            r4 = r0
            com.jumio.sdk.credentials.JumioIDCredential r4 = (com.jumio.sdk.credentials.JumioIDCredential) r4
            java.util.Map r5 = r4.getCountries()
            java.lang.String r4 = r4.getSuggestedCountry()
            java.lang.String r6 = "Suggested Country: "
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r6, r4)
            r2.m20683b(r4)
            java.lang.String r4 = r2.f29338t
            java.lang.Object r4 = r5.get(r4)
            java.util.List r4 = (java.util.List) r4
            if (r4 != 0) goto L_0x005e
            goto L_0x0099
        L_0x005e:
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x0064:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0097
            java.lang.Object r5 = r4.next()
            r6 = r5
            com.jumio.sdk.document.JumioDocument r6 = (com.jumio.sdk.document.JumioDocument) r6
            com.jumio.sdk.document.JumioDocumentType r7 = r6.getType()
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "ID_CARD"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x0093
            com.jumio.sdk.document.JumioDocumentVariant r6 = r6.getVariant()
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "PLASTIC"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x0093
            r6 = 1
            goto L_0x0094
        L_0x0093:
            r6 = 0
        L_0x0094:
            if (r6 == 0) goto L_0x0064
            r1 = r5
        L_0x0097:
            com.jumio.sdk.document.JumioDocument r1 = (com.jumio.sdk.document.JumioDocument) r1
        L_0x0099:
            boolean r4 = r0.isConfigured()
            if (r4 == 0) goto L_0x00b8
            java.util.ArrayList r4 = r0.getScanSides()
            r2.m20676a((java.util.ArrayList<com.jumio.sdk.enums.JumioScanSide>) r4)
            goto L_0x00b8
        L_0x00a7:
            boolean r4 = r0 instanceof com.jumio.sdk.credentials.JumioFaceCredential
            if (r4 == 0) goto L_0x00b3
            java.util.ArrayList r4 = r0.getScanSides()
            r2.m20676a((java.util.ArrayList<com.jumio.sdk.enums.JumioScanSide>) r4)
            goto L_0x00b8
        L_0x00b3:
            java.lang.String r4 = "else part"
            r2.m20683b(r4)
        L_0x00b8:
            if (r3 == 0) goto L_0x00ce
            if (r1 != 0) goto L_0x00bd
            goto L_0x00ce
        L_0x00bd:
            r3 = r0
            com.jumio.sdk.credentials.JumioIDCredential r3 = (com.jumio.sdk.credentials.JumioIDCredential) r3
            java.lang.String r4 = r2.f29338t
            r3.setConfiguration(r4, r1)
            java.util.ArrayList r0 = r0.getScanSides()
            r2.m20676a((java.util.ArrayList<com.jumio.sdk.enums.JumioScanSide>) r0)
        L_0x00ce:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x00d0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.nova.kyc.jumio.DDCustomActivity$setupCredential$1.invoke():java.lang.Object");
    }
}
