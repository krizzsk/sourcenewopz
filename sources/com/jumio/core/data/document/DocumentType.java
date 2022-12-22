package com.jumio.core.data.document;

import com.datadog.android.rum.RumAttributes;
import com.jumio.sdk.document.JumioDocumentType;
import com.jumio.sdk.document.JumioDocumentVariant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0003J\u0011\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0000H\u0002J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0016R\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R)\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0016j\b\u0012\u0004\u0012\u00020\u0007`\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006!"}, mo175978d2 = {"Lcom/jumio/core/data/document/DocumentType;", "", "Ljava/io/Serializable;", "Lcom/jumio/sdk/document/JumioDocumentVariant;", "variant", "", "hasVariant", "Lcom/jumio/core/data/document/DocumentVariant;", "getVariant", "other", "", "compareTo", "", "another", "equals", "hashCode", "Lcom/jumio/sdk/document/JumioDocumentType;", "a", "Lcom/jumio/sdk/document/JumioDocumentType;", "getIdType", "()Lcom/jumio/sdk/document/JumioDocumentType;", "idType", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "getVariants", "()Ljava/util/ArrayList;", "variants", "Lorg/json/JSONObject;", "jsonObject", "<init>", "(Lorg/json/JSONObject;)V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: DocumentType.kt */
public final class DocumentType implements Serializable, Comparable<DocumentType> {

    /* renamed from: a */
    public final JumioDocumentType f54684a;

    /* renamed from: b */
    public final ArrayList<DocumentVariant> f54685b = new ArrayList<>();

    public DocumentType(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        String string = jSONObject.getString("idType");
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(\"idType\")");
        this.f54684a = JumioDocumentType.valueOf(string);
        JSONArray jSONArray = jSONObject.getJSONArray("variants");
        int length = jSONArray.length();
        if (length > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                ArrayList<DocumentVariant> arrayList = this.f54685b;
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "data.getJSONObject(i)");
                arrayList.add(new DocumentVariant(jSONObject2));
                if (i2 < length) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof DocumentType ? compareTo((DocumentType) obj) : -1) == 0;
    }

    public final JumioDocumentType getIdType() {
        return this.f54684a;
    }

    public final DocumentVariant getVariant(JumioDocumentVariant jumioDocumentVariant) {
        T t;
        boolean z;
        Intrinsics.checkNotNullParameter(jumioDocumentVariant, RumAttributes.VARIANT);
        Iterator<T> it = this.f54685b.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (((DocumentVariant) t).getVariant() == jumioDocumentVariant) {
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
        return (DocumentVariant) t;
    }

    public final ArrayList<DocumentVariant> getVariants() {
        return this.f54685b;
    }

    public final boolean hasVariant(JumioDocumentVariant jumioDocumentVariant) {
        Intrinsics.checkNotNullParameter(jumioDocumentVariant, RumAttributes.VARIANT);
        ArrayList<DocumentVariant> arrayList = this.f54685b;
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = arrayList.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                return !arrayList2.isEmpty();
            }
            T next = it.next();
            if (((DocumentVariant) next).getVariant() != jumioDocumentVariant) {
                z = false;
            }
            if (z) {
                arrayList2.add(next);
            }
        }
    }

    public int hashCode() {
        return System.identityHashCode(this);
    }

    public int compareTo(DocumentType documentType) {
        JumioDocumentType jumioDocumentType;
        Intrinsics.checkNotNullParameter(documentType, "other");
        JumioDocumentType jumioDocumentType2 = this.f54684a;
        JumioDocumentType jumioDocumentType3 = JumioDocumentType.PASSPORT;
        if (jumioDocumentType2 == jumioDocumentType3 && documentType.f54684a != jumioDocumentType3) {
            return -1;
        }
        JumioDocumentType jumioDocumentType4 = JumioDocumentType.DRIVING_LICENSE;
        if (!(jumioDocumentType2 == jumioDocumentType4 && documentType.f54684a == jumioDocumentType3)) {
            if (jumioDocumentType2 == jumioDocumentType4 && documentType.f54684a != jumioDocumentType4) {
                return -1;
            }
            JumioDocumentType jumioDocumentType5 = JumioDocumentType.ID_CARD;
            if (!(jumioDocumentType2 == jumioDocumentType5 && documentType.f54684a == jumioDocumentType3) && (!(jumioDocumentType2 == jumioDocumentType5 && documentType.f54684a == jumioDocumentType4) && ((jumioDocumentType2 == jumioDocumentType5 && documentType.f54684a == JumioDocumentType.VISA) || jumioDocumentType2 != (jumioDocumentType = JumioDocumentType.VISA) || documentType.f54684a == jumioDocumentType))) {
                return -1;
            }
        }
        return 1;
    }
}
