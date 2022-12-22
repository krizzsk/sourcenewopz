package kotlin.p245io;

import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, mo175978d2 = {"Lkotlin/io/ExposingBufferByteArrayOutputStream;", "Ljava/io/ByteArrayOutputStream;", "size", "", "(I)V", "buffer", "", "getBuffer", "()[B", "kotlin-stdlib"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* renamed from: kotlin.io.a */
/* compiled from: FileReadWrite.kt */
final class C21480a extends ByteArrayOutputStream {
    public C21480a(int i) {
        super(i);
    }

    /* renamed from: a */
    public final byte[] mo176744a() {
        byte[] bArr = this.buf;
        Intrinsics.checkNotNullExpressionValue(bArr, "buf");
        return bArr;
    }
}
