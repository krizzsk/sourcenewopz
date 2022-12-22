package jumio.core;

import com.jumio.commons.PersistWith;
import com.jumio.commons.log.Log;
import com.jumio.core.Controller;
import com.jumio.core.credentials.C19967b;
import com.jumio.core.credentials.JumioDocumentCredential;
import com.jumio.core.enums.C19968a;
import com.jumio.core.model.StaticModel;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.credentials.JumioCredentialInfo;
import com.jumio.sdk.credentials.JumioFaceCredential;
import com.jumio.sdk.credentials.JumioIDCredential;
import com.jumio.sdk.document.JumioDocumentType;
import com.jumio.sdk.document.JumioDocumentVariant;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@PersistWith("ScanCredentialsModel")
/* renamed from: jumio.core.p */
/* compiled from: CredentialsModel.kt */
public final class C21373p implements StaticModel {

    /* renamed from: a */
    public int f59665a;

    /* renamed from: b */
    public String f59666b;

    /* renamed from: c */
    public final ArrayList<C21365l> f59667c = new ArrayList<>();

    /* renamed from: a */
    public final String mo175858a() {
        return this.f59666b;
    }

    /* renamed from: b */
    public final C21365l mo175862b() {
        C21365l lVar = this.f59667c.get(this.f59665a);
        Intrinsics.checkNotNullExpressionValue(lVar, "dataModels[index]");
        return lVar;
    }

    /* renamed from: c */
    public final boolean mo175865c() {
        Iterator<C21365l> it = this.f59667c.iterator();
        while (it.hasNext()) {
            if (!it.next().mo175837g()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    public final ArrayList<C21365l> mo175866d() {
        return this.f59667c;
    }

    /* renamed from: e */
    public final ArrayList<JumioCredentialInfo> mo175867e() {
        ArrayList<JumioCredentialInfo> arrayList = new ArrayList<>();
        Iterator<C21365l> it = this.f59667c.iterator();
        while (it.hasNext()) {
            C21365l next = it.next();
            arrayList.add(new JumioCredentialInfo(next.mo175834d(), next.mo175835e()));
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo175860a(org.json.JSONObject r9) {
        /*
            r8 = this;
            java.lang.String r0 = "jsonObject"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "id"
            java.lang.String r1 = r9.optString(r0)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r3 = "capabilities"
            org.json.JSONArray r4 = r9.getJSONArray(r3)
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x0033
            r5 = 0
        L_0x001d:
            int r6 = r5 + 1
            org.json.JSONArray r7 = r9.getJSONArray(r3)
            org.json.JSONObject r5 = r7.getJSONObject(r5)
            com.jumio.core.credentials.b r5 = com.jumio.core.credentials.C19967b.m39537a(r5)
            r2.add(r5)
            if (r6 < r4) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r5 = r6
            goto L_0x001d
        L_0x0033:
            java.lang.String r3 = "category"
            java.lang.String r3 = r9.getString(r3)
            if (r3 == 0) goto L_0x0082
            int r4 = r3.hashCode()
            r5 = -374349377(0xffffffffe9afe1bf, float:-2.657851E25)
            if (r4 == r5) goto L_0x0071
            r5 = 2331(0x91b, float:3.266E-42)
            if (r4 == r5) goto L_0x0060
            r9 = 1644347675(0x6202c11b, float:6.0299786E20)
            if (r4 == r9) goto L_0x004e
            goto L_0x0082
        L_0x004e:
            java.lang.String r9 = "DOCUMENT"
            boolean r9 = r3.equals(r9)
            if (r9 != 0) goto L_0x0057
            goto L_0x0082
        L_0x0057:
            jumio.core.m r9 = new jumio.core.m
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r9.<init>(r1, r2)
            goto L_0x0083
        L_0x0060:
            java.lang.String r4 = "ID"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0069
            goto L_0x0082
        L_0x0069:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            jumio.core.l r9 = r8.mo175859a(r9, r1, r2)
            goto L_0x0083
        L_0x0071:
            java.lang.String r4 = "FACEMAP"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x007a
            goto L_0x0082
        L_0x007a:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            jumio.core.n r9 = r8.mo175863b(r9, r1, r2)
            goto L_0x0083
        L_0x0082:
            r9 = 0
        L_0x0083:
            if (r9 != 0) goto L_0x0086
            goto L_0x008d
        L_0x0086:
            java.util.ArrayList r0 = r8.mo175866d()
            r0.add(r9)
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.core.C21373p.mo175860a(org.json.JSONObject):void");
    }

    /* renamed from: b */
    public final ArrayList<String> mo175861b(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("country");
        if (optJSONObject == null || !Intrinsics.areEqual((Object) optJSONObject.optString("predefinedType"), (Object) "DEFINED")) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        JSONArray jSONArray = optJSONObject.getJSONArray("values");
        int i = 0;
        int length = jSONArray.length();
        if (length <= 0) {
            return arrayList;
        }
        while (true) {
            int i2 = i + 1;
            arrayList.add(jSONArray.getString(i));
            if (i2 >= length) {
                return arrayList;
            }
            i = i2;
        }
    }

    /* renamed from: c */
    public final ArrayList<JumioDocumentType> mo175864c(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("type");
        if (optJSONObject == null || !Intrinsics.areEqual((Object) optJSONObject.optString("predefinedType"), (Object) "DEFINED")) {
            return null;
        }
        ArrayList<JumioDocumentType> arrayList = new ArrayList<>();
        JSONArray jSONArray = optJSONObject.getJSONArray("values");
        int i = 0;
        int length = jSONArray.length();
        if (length <= 0) {
            return arrayList;
        }
        while (true) {
            int i2 = i + 1;
            try {
                String string = jSONArray.getString(i);
                Intrinsics.checkNotNullExpressionValue(string, "values.getString(i)");
                arrayList.add(JumioDocumentType.valueOf(string));
            } catch (Exception unused) {
                Log.m39459e(Intrinsics.stringPlus(jSONArray.getString(i), " is not a valid DocumentType"));
            }
            if (i2 >= length) {
                return arrayList;
            }
            i = i2;
        }
    }

    /* renamed from: b */
    public final C21369n mo175863b(JSONObject jSONObject, String str, ArrayList<C19967b> arrayList) {
        ArrayList arrayList2;
        JSONObject optJSONObject = jSONObject.optJSONObject("type");
        if (optJSONObject != null && Intrinsics.areEqual((Object) optJSONObject.optString("predefinedType"), (Object) "DEFINED")) {
            arrayList2 = new ArrayList();
            JSONArray jSONArray = optJSONObject.getJSONArray("values");
            int i = 0;
            int length = jSONArray.length();
            if (length > 0) {
                while (true) {
                    int i2 = i + 1;
                    try {
                        String string = jSONArray.getString(i);
                        Intrinsics.checkNotNullExpressionValue(string, "values.getString(i)");
                        arrayList2.add(C19968a.valueOf(string));
                    } catch (Exception unused) {
                        Log.m39459e(Intrinsics.stringPlus(jSONArray.getString(i), " is not a valid DocumentType"));
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
        } else {
            arrayList2 = null;
        }
        return new C21369n(str, arrayList, arrayList2);
    }

    /* renamed from: a */
    public final C21365l mo175859a(JSONObject jSONObject, String str, ArrayList<C19967b> arrayList) {
        return new C21371o(str, arrayList, mo175861b(jSONObject), mo175864c(jSONObject), (JumioDocumentVariant) null);
    }

    /* renamed from: a */
    public final JumioCredential mo175857a(Controller controller, String str) {
        JumioCredential jumioCredential;
        C21365l data$jumio_core_release;
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(str, "id");
        Iterator<C21365l> it = this.f59667c.iterator();
        boolean z = false;
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (it.next().mo175835e().equals(str)) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            z = true;
        }
        if (z) {
            this.f59665a = i;
            C21365l b = mo175862b();
            String str2 = null;
            if (b instanceof C21371o) {
                jumioCredential = new JumioIDCredential(controller, (C21371o) mo175862b());
            } else if (b instanceof C21369n) {
                jumioCredential = new JumioFaceCredential(controller, (C21369n) mo175862b());
            } else {
                jumioCredential = b instanceof C21367m ? new JumioDocumentCredential(controller, (C21367m) mo175862b()) : null;
            }
            if (!(jumioCredential == null || (data$jumio_core_release = jumioCredential.getData$jumio_core_release()) == null)) {
                str2 = data$jumio_core_release.mo175835e();
            }
            this.f59666b = str2;
            return jumioCredential;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus(str, " not found").toString());
    }
}
