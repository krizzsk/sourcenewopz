package com.jumio.core.data.document;

import com.jumio.commons.log.Log;
import com.jumio.core.data.ScanMode;
import com.jumio.sdk.enums.JumioScanSide;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R)\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0012j\b\u0012\u0004\u0012\u00020\u0002`\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001b\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010¨\u0006 "}, mo175978d2 = {"Lcom/jumio/core/data/document/DocumentPart;", "Ljava/io/Serializable;", "Lcom/jumio/core/data/ScanMode;", "currentScanMode", "", "hasFallbackAfter", "getFallbackAfter", "Lcom/jumio/sdk/enums/JumioScanSide;", "a", "Lcom/jumio/sdk/enums/JumioScanSide;", "getSide", "()Lcom/jumio/sdk/enums/JumioScanSide;", "side", "b", "Z", "getMasking", "()Z", "masking", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "getExtraction", "()Ljava/util/ArrayList;", "extraction", "d", "getNfc", "nfc", "Lorg/json/JSONObject;", "jsonObject", "<init>", "(Lorg/json/JSONObject;)V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: DocumentPart.kt */
public final class DocumentPart implements Serializable {

    /* renamed from: a */
    public final JumioScanSide f54680a;

    /* renamed from: b */
    public final boolean f54681b;

    /* renamed from: c */
    public final ArrayList<ScanMode> f54682c = new ArrayList<>();

    /* renamed from: d */
    public final boolean f54683d;

    public DocumentPart(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        String string = jSONObject.getString("side");
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(\"side\")");
        this.f54680a = JumioScanSide.valueOf(string);
        this.f54681b = jSONObject.optBoolean("masking", false);
        JSONArray jSONArray = jSONObject.getJSONArray("extraction");
        int length = jSONArray.length();
        if (length > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                try {
                    ArrayList<ScanMode> arrayList = this.f54682c;
                    String string2 = jSONArray.getString(i);
                    Intrinsics.checkNotNullExpressionValue(string2, "data.getString(i)");
                    arrayList.add(ScanMode.valueOf(string2));
                } catch (Exception e) {
                    Log.printStackTrace(e);
                }
                if (i2 >= length) {
                    break;
                }
                i = i2;
            }
        }
        this.f54683d = jSONObject.optBoolean("nfc", false);
    }

    public final ArrayList<ScanMode> getExtraction() {
        return this.f54682c;
    }

    public final ScanMode getFallbackAfter(ScanMode scanMode) {
        Intrinsics.checkNotNullParameter(scanMode, "currentScanMode");
        int indexOf = this.f54682c.indexOf(scanMode);
        if (indexOf == CollectionsKt.getLastIndex(this.f54682c)) {
            return scanMode;
        }
        ScanMode scanMode2 = this.f54682c.get(indexOf + 1);
        Intrinsics.checkNotNullExpressionValue(scanMode2, "{\n\t\t\textraction.get(currentIndex + 1)\n\t\t}");
        return scanMode2;
    }

    public final boolean getMasking() {
        return this.f54681b;
    }

    public final boolean getNfc() {
        return this.f54683d;
    }

    public final JumioScanSide getSide() {
        return this.f54680a;
    }

    public final boolean hasFallbackAfter(ScanMode scanMode) {
        Intrinsics.checkNotNullParameter(scanMode, "currentScanMode");
        return this.f54682c.indexOf(scanMode) != CollectionsKt.getLastIndex(this.f54682c);
    }
}
