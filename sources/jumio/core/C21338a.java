package jumio.core;

import com.jumio.commons.PersistWith;
import com.jumio.core.model.StaticModel;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

@PersistWith("AdditionalDataPointsModel")
/* renamed from: jumio.core.a */
/* compiled from: AdditionalDataPointsModel.kt */
public final class C21338a implements StaticModel {

    /* renamed from: a */
    public String f59583a = "";

    /* renamed from: b */
    public int f59584b;

    /* renamed from: c */
    public int f59585c;

    /* renamed from: d */
    public ArrayList<String> f59586d;

    /* renamed from: e */
    public int f59587e;

    /* renamed from: f */
    public boolean f59588f;

    /* renamed from: g */
    public String f59589g = "";

    /* renamed from: h */
    public String f59590h = "";

    /* renamed from: i */
    public String f59591i = "";

    /* renamed from: a */
    public final void mo175779a(String str, int i, int i2, ArrayList<String> arrayList, int i3, boolean z, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "localeString");
        Intrinsics.checkNotNullParameter(str2, "localeCountry");
        Intrinsics.checkNotNullParameter(str3, "countryForIp");
        this.f59583a = str;
        this.f59584b = i;
        this.f59585c = i2;
        this.f59586d = arrayList;
        this.f59587e = i3;
        this.f59588f = z;
        this.f59590h = str2;
        this.f59589g = str3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        if ((r0.length() == 0) != false) goto L_0x001e;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo175778a(com.jumio.core.models.IDScanPartModel r3) {
        /*
            r2 = this;
            java.lang.String r0 = "scanPart"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.jumio.core.models.DocumentDataModel r0 = r3.getDocumentData()
            if (r0 != 0) goto L_0x000d
            r0 = 0
            goto L_0x0011
        L_0x000d:
            java.lang.String r0 = r0.getIssuingCountry()
        L_0x0011:
            if (r0 == 0) goto L_0x001e
            int r1 = r0.length()
            if (r1 != 0) goto L_0x001b
            r1 = 1
            goto L_0x001c
        L_0x001b:
            r1 = 0
        L_0x001c:
            if (r1 == 0) goto L_0x002a
        L_0x001e:
            com.jumio.core.models.SelectionModel r3 = r3.getSelectionModel()
            com.jumio.core.data.country.Country r3 = r3.getCountry()
            java.lang.String r0 = r3.getIsoCode()
        L_0x002a:
            r2.f59591i = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.core.C21338a.mo175778a(com.jumio.core.models.IDScanPartModel):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0143  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.jumio.analytics.MetaInfo mo175777a(android.content.Context r10, com.jumio.core.persistence.DataManager r11) {
        /*
            r9 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "dataManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r1)
            java.lang.Class<jumio.core.b> r1 = jumio.core.C21340b.class
            java.io.Serializable r11 = r11.get(r1)
            jumio.core.b r11 = (jumio.core.C21340b) r11
            java.lang.String r1 = r11.mo175782b()     // Catch:{ Exception -> 0x0051 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0051 }
            if (r1 != 0) goto L_0x0023
            java.lang.String r1 = r11.mo175782b()     // Catch:{ Exception -> 0x0051 }
            java.lang.String r2 = "addressModel.adminArea"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ Exception -> 0x0051 }
            goto L_0x0024
        L_0x0023:
            r1 = r0
        L_0x0024:
            java.lang.String r2 = r11.mo175784d()     // Catch:{ Exception -> 0x004e }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x004e }
            if (r2 != 0) goto L_0x0038
            java.lang.String r2 = r11.mo175784d()     // Catch:{ Exception -> 0x004e }
            java.lang.String r3 = "addressModel.postalCode"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ Exception -> 0x004e }
            goto L_0x0039
        L_0x0038:
            r2 = r0
        L_0x0039:
            java.lang.String r3 = r11.mo175783c()     // Catch:{ Exception -> 0x004c }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x004c }
            if (r3 != 0) goto L_0x0059
            java.lang.String r11 = r11.mo175783c()     // Catch:{ Exception -> 0x004c }
            java.lang.String r11 = com.jumio.sdk.util.IsoCountryConverter.convertToAlpha3(r11)     // Catch:{ Exception -> 0x004c }
            goto L_0x005a
        L_0x004c:
            r11 = move-exception
            goto L_0x0054
        L_0x004e:
            r11 = move-exception
            r2 = r0
            goto L_0x0054
        L_0x0051:
            r11 = move-exception
            r1 = r0
            r2 = r1
        L_0x0054:
            java.lang.String r3 = "Failed to convert geocoded information"
            com.jumio.commons.log.Log.m39463e((java.lang.String) r3, (java.lang.Throwable) r11)
        L_0x0059:
            r11 = r0
        L_0x005a:
            r3 = 0
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x006b }
            long r7 = jumio.core.C21377r.m42191a(r10)     // Catch:{ Exception -> 0x006b }
            long r5 = r5 - r7
            r7 = 1000(0x3e8, float:1.401E-42)
            long r7 = (long) r7     // Catch:{ Exception -> 0x006b }
            long r3 = r5 / r7
            goto L_0x006f
        L_0x006b:
            r5 = move-exception
            com.jumio.commons.log.Log.printStackTrace(r5)
        L_0x006f:
            com.jumio.analytics.MetaInfo r5 = new com.jumio.analytics.MetaInfo
            r5.<init>()
            java.lang.String r6 = r9.f59583a
            java.lang.String r7 = "locale"
            r5.put(r7, r6)
            int r6 = r9.f59584b
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r7 = "srX"
            r5.put(r7, r6)
            int r6 = r9.f59585c
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r7 = "srY"
            r5.put(r7, r6)
            java.util.ArrayList<java.lang.String> r6 = r9.f59586d
            if (r6 == 0) goto L_0x0096
            goto L_0x0097
        L_0x0096:
            r6 = r0
        L_0x0097:
            java.lang.String r7 = "supportedLocales"
            r5.put(r7, r6)
            int r6 = r9.f59587e
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r7 = "timezone"
            r5.put(r7, r6)
            boolean r6 = r9.f59588f
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            java.lang.String r7 = "isRooted"
            r5.put(r7, r6)
            java.lang.String r6 = r9.f59589g
            java.lang.String r7 = "countryForIP"
            r5.put(r7, r6)
            java.lang.String r6 = r9.f59590h
            java.lang.String r7 = "localeCountry"
            r5.put(r7, r6)
            java.lang.String r6 = r9.f59591i
            java.lang.String r7 = "issuingCountry"
            r5.put(r7, r6)
            com.jumio.analytics.MetaInfo r6 = new com.jumio.analytics.MetaInfo
            r6.<init>()
            if (r11 != 0) goto L_0x00cf
            goto L_0x00d0
        L_0x00cf:
            r0 = r11
        L_0x00d0:
            java.lang.String r7 = "country"
            r6.put(r7, r0)
            java.lang.String r0 = "state"
            r6.put(r0, r1)
            java.lang.String r0 = "zip"
            r6.put(r0, r2)
            java.lang.String r0 = "geocoded"
            r5.put(r0, r6)
            java.lang.String r0 = "Jumio04"
            int r0 = jumio.core.C21377r.m42190a((android.content.Context) r10, (java.lang.String) r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r1 = "numOfVerifications"
            r5.put(r1, r0)
            java.lang.String r0 = "Jumio03"
            int r0 = jumio.core.C21377r.m42190a((android.content.Context) r10, (java.lang.String) r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r1 = "numOfRetakes"
            r5.put(r1, r0)
            java.lang.String r0 = "Jumio05"
            int r10 = jumio.core.C21377r.m42190a((android.content.Context) r10, (java.lang.String) r0)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.String r0 = "numOfCancels"
            r5.put(r0, r10)
            java.util.HashSet r10 = new java.util.HashSet
            r10.<init>()
            java.lang.String r0 = r9.f59590h
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0123
            java.lang.String r0 = r9.f59590h
            r10.add(r0)
        L_0x0123:
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 != 0) goto L_0x012e
            if (r11 == 0) goto L_0x012e
            r10.add(r11)
        L_0x012e:
            java.lang.String r11 = r9.f59591i
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x013b
            java.lang.String r11 = r9.f59591i
            r10.add(r11)
        L_0x013b:
            java.lang.String r11 = r9.f59589g
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x0148
            java.lang.String r11 = r9.f59589g
            r10.add(r11)
        L_0x0148:
            int r10 = r10.size()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.String r11 = "numOfCountries"
            r5.put(r11, r10)
            java.lang.Long r10 = java.lang.Long.valueOf(r3)
            java.lang.String r11 = "secInSdk"
            r5.put(r11, r10)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.core.C21338a.mo175777a(android.content.Context, com.jumio.core.persistence.DataManager):com.jumio.analytics.MetaInfo");
    }
}
