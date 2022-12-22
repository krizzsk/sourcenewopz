package com.didiglobal.pay.paysecure.net;

import com.didichuxing.foundation.gson.GsonAdapter;
import com.didichuxing.foundation.p188io.AbstractDeserializer;
import com.didichuxing.foundation.p188io.Streams;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0002B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u0011\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\t\u001a\u0004\u0018\u00018\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/net/PaySecureGsonDeserializer;", "T", "Lcom/didichuxing/foundation/io/AbstractDeserializer;", "()V", "type", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)V", "mAdapter", "Lcom/didichuxing/foundation/gson/GsonAdapter;", "deserialize", "in", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)Ljava/lang/Object;", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: PaySecureGsonDeserializer.kt */
public final class PaySecureGsonDeserializer<T> extends AbstractDeserializer<T> {

    /* renamed from: a */
    private final GsonAdapter f50321a = new GsonAdapter();

    public PaySecureGsonDeserializer() {
    }

    public PaySecureGsonDeserializer(Type type) {
        super(type);
    }

    public T deserialize(InputStream inputStream) throws IOException {
        Intrinsics.checkParameterIsNotNull(inputStream, "in");
        try {
            return this.f50321a.getGson().fromJson(Streams.readFullyNoClose((Reader) new InputStreamReader(inputStream)), getType());
        } catch (JsonSyntaxException e) {
            e.getMessage();
            return null;
        }
    }
}
