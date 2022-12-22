package com.jumio.core.data.document;

import com.datadog.android.rum.RumAttributes;
import com.didi.travel.p171v2.store.IStoreCallback;
import com.jumio.sdk.document.JumioDocumentVariant;
import com.jumio.sdk.enums.JumioScanSide;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR)\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u000ej\b\u0012\u0004\u0012\u00020\u0006`\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u001a\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, mo175978d2 = {"Lcom/jumio/core/data/document/DocumentVariant;", "Ljava/io/Serializable;", "Lcom/jumio/sdk/enums/JumioScanSide;", "side", "", "hasPart", "Lcom/jumio/core/data/document/DocumentPart;", "getPart", "Lcom/jumio/sdk/document/JumioDocumentVariant;", "a", "Lcom/jumio/sdk/document/JumioDocumentVariant;", "getVariant", "()Lcom/jumio/sdk/document/JumioDocumentVariant;", "variant", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "getParts", "()Ljava/util/ArrayList;", "parts", "Lcom/jumio/core/data/document/DocumentFormat;", "c", "Lcom/jumio/core/data/document/DocumentFormat;", "getFormat", "()Lcom/jumio/core/data/document/DocumentFormat;", "format", "Lorg/json/JSONObject;", "jsonObject", "<init>", "(Lorg/json/JSONObject;)V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: DocumentVariant.kt */
public final class DocumentVariant implements Serializable {

    /* renamed from: a */
    public final JumioDocumentVariant f54686a;

    /* renamed from: b */
    public final ArrayList<DocumentPart> f54687b = new ArrayList<>();

    /* renamed from: c */
    public final DocumentFormat f54688c;

    public DocumentVariant(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        String string = jSONObject.getString(RumAttributes.VARIANT);
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(\"variant\")");
        this.f54686a = JumioDocumentVariant.valueOf(string);
        JSONArray jSONArray = jSONObject.getJSONArray("parts");
        int length = jSONArray.length();
        if (length > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                ArrayList<DocumentPart> arrayList = this.f54687b;
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "data.getJSONObject(i)");
                arrayList.add(new DocumentPart(jSONObject2));
                if (i2 >= length) {
                    break;
                }
                i = i2;
            }
        }
        String optString = jSONObject.optString("format", IStoreCallback.DEFAULT_API_DETAIL_KEY);
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"format\", \"NONE\")");
        this.f54688c = DocumentFormat.valueOf(optString);
    }

    public final DocumentFormat getFormat() {
        return this.f54688c;
    }

    public final DocumentPart getPart(JumioScanSide jumioScanSide) {
        boolean z;
        T t;
        boolean z2;
        Intrinsics.checkNotNullParameter(jumioScanSide, "side");
        Iterator<T> it = this.f54687b.iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (((DocumentPart) t).getSide() == jumioScanSide) {
                z2 = true;
                continue;
            } else {
                z2 = false;
                continue;
            }
            if (z2) {
                break;
            }
        }
        DocumentPart documentPart = (DocumentPart) t;
        if (documentPart == null) {
            z = false;
        }
        if (z) {
            return documentPart;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Could not find ", jumioScanSide).toString());
    }

    public final ArrayList<DocumentPart> getParts() {
        return this.f54687b;
    }

    public final JumioDocumentVariant getVariant() {
        return this.f54686a;
    }

    public final boolean hasPart(JumioScanSide jumioScanSide) {
        T t;
        boolean z;
        Intrinsics.checkNotNullParameter(jumioScanSide, "side");
        Iterator<T> it = this.f54687b.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (((DocumentPart) t).getSide() == jumioScanSide) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        return t != null;
    }
}
