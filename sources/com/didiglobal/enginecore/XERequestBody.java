package com.didiglobal.enginecore;

import java.io.File;
import java.io.IOException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\n"}, mo175978d2 = {"Lcom/didiglobal/enginecore/XERequestBody;", "", "()V", "contentLength", "", "writeTo", "", "sink", "Lokio/BufferedSink;", "Companion", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: XERequestBody.kt */
public abstract class XERequestBody {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final XERequestBody create(File file) {
        return Companion.create(file);
    }

    @JvmStatic
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'file' argument first to fix Java", replaceWith = @ReplaceWith(expression = "file.asRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.asRequestBody"}))
    public static final XERequestBody create(File file, long j) {
        return Companion.create(file, j);
    }

    public long contentLength() throws IOException {
        return -1;
    }

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0011\u0010\t\u001a\u00020\u0004*\u00020\u0006H\u0007¢\u0006\u0002\b\u0003¨\u0006\n"}, mo175978d2 = {"Lcom/didiglobal/enginecore/XERequestBody$Companion;", "", "()V", "create", "Lcom/didiglobal/enginecore/XERequestBody;", "file", "Ljava/io/File;", "size", "", "asRequestBody", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: XERequestBody.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final XERequestBody create(File file) {
            Intrinsics.checkParameterIsNotNull(file, "$this$asRequestBody");
            return new XERequestBody$Companion$asRequestBody$1(file);
        }

        @JvmStatic
        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'file' argument first to fix Java", replaceWith = @ReplaceWith(expression = "file.asRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.asRequestBody"}))
        public final XERequestBody create(File file, long j) {
            Intrinsics.checkParameterIsNotNull(file, "file");
            return create(file);
        }
    }
}
