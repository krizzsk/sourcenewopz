package com.jumio.sdk.document;

import com.datadog.android.rum.RumAttributes;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0019\u0010\t\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u000f\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, mo175978d2 = {"Lcom/jumio/sdk/document/JumioDocument;", "Ljava/io/Serializable;", "", "toString", "Lcom/jumio/sdk/document/JumioDocumentType;", "a", "Lcom/jumio/sdk/document/JumioDocumentType;", "getType", "()Lcom/jumio/sdk/document/JumioDocumentType;", "type", "Lcom/jumio/sdk/document/JumioDocumentVariant;", "b", "Lcom/jumio/sdk/document/JumioDocumentVariant;", "getVariant", "()Lcom/jumio/sdk/document/JumioDocumentVariant;", "variant", "<init>", "(Lcom/jumio/sdk/document/JumioDocumentType;Lcom/jumio/sdk/document/JumioDocumentVariant;)V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: JumioDocument.kt */
public final class JumioDocument implements Serializable {

    /* renamed from: a */
    public final JumioDocumentType f55083a;

    /* renamed from: b */
    public final JumioDocumentVariant f55084b;

    public JumioDocument(JumioDocumentType jumioDocumentType, JumioDocumentVariant jumioDocumentVariant) {
        Intrinsics.checkNotNullParameter(jumioDocumentType, "type");
        Intrinsics.checkNotNullParameter(jumioDocumentVariant, RumAttributes.VARIANT);
        this.f55083a = jumioDocumentType;
        this.f55084b = jumioDocumentVariant;
    }

    public final JumioDocumentType getType() {
        return this.f55083a;
    }

    public final JumioDocumentVariant getVariant() {
        return this.f55084b;
    }

    public String toString() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s %s", Arrays.copyOf(new Object[]{this.f55083a.name(), this.f55084b.name()}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }
}
