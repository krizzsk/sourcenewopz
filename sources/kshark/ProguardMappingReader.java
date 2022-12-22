package kshark;

import java.io.InputStream;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0006\u0010\r\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lkshark/ProguardMappingReader;", "", "proguardMappingInputStream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "parseClassField", "", "line", "", "currentClassName", "proguardMapping", "Lkshark/ProguardMapping;", "parseClassMapping", "readProguardMapping", "Companion", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: ProguardMappingReader.kt */
public final class ProguardMappingReader {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b */
    private static final String f4607b = "#";

    /* renamed from: c */
    private static final String f4608c = "->";

    /* renamed from: d */
    private static final String f4609d = ":";

    /* renamed from: e */
    private static final String f4610e = " ";

    /* renamed from: f */
    private static final String f4611f = "(";

    /* renamed from: a */
    private final InputStream f4612a;

    public ProguardMappingReader(InputStream inputStream) {
        Intrinsics.checkParameterIsNotNull(inputStream, "proguardMappingInputStream");
        this.f4612a = inputStream;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0088, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0089, code lost:
        kotlin.p245io.CloseableKt.closeFinally(r3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008c, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kshark.ProguardMapping readProguardMapping() throws java.io.FileNotFoundException, java.io.IOException, java.text.ParseException {
        /*
            r11 = this;
            kshark.ProguardMapping r0 = new kshark.ProguardMapping
            r0.<init>()
            java.io.InputStream r1 = r11.f4612a
            java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8
            java.io.InputStreamReader r3 = new java.io.InputStreamReader
            r3.<init>(r1, r2)
            java.io.Reader r3 = (java.io.Reader) r3
            boolean r1 = r3 instanceof java.io.BufferedReader
            if (r1 == 0) goto L_0x0017
            java.io.BufferedReader r3 = (java.io.BufferedReader) r3
            goto L_0x001f
        L_0x0017:
            java.io.BufferedReader r1 = new java.io.BufferedReader
            r2 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r3, r2)
            r3 = r1
        L_0x001f:
            java.io.Closeable r3 = (java.io.Closeable) r3
            r1 = 0
            r2 = r1
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            r4 = r3
            java.io.BufferedReader r4 = (java.io.BufferedReader) r4     // Catch:{ all -> 0x0086 }
            r5 = r1
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0086 }
        L_0x002b:
            java.lang.String r6 = r4.readLine()     // Catch:{ all -> 0x0086 }
            if (r6 == 0) goto L_0x0080
            if (r6 == 0) goto L_0x0078
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x0086 }
            java.lang.CharSequence r6 = kotlin.text.StringsKt.trim(r6)     // Catch:{ all -> 0x0086 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0086 }
            if (r6 == 0) goto L_0x0080
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ all -> 0x0086 }
            int r7 = r7.length()     // Catch:{ all -> 0x0086 }
            r8 = 0
            if (r7 != 0) goto L_0x004b
            r7 = 1
            goto L_0x004c
        L_0x004b:
            r7 = 0
        L_0x004c:
            if (r7 != 0) goto L_0x002b
            java.lang.String r7 = "#"
            r9 = 2
            boolean r7 = kotlin.text.StringsKt.startsWith$default(r6, r7, r8, r9, r1)     // Catch:{ all -> 0x0086 }
            if (r7 == 0) goto L_0x0058
            goto L_0x002b
        L_0x0058:
            java.lang.String r7 = ":"
            boolean r7 = kotlin.text.StringsKt.endsWith$default(r6, r7, r8, r9, r1)     // Catch:{ all -> 0x0086 }
            if (r7 == 0) goto L_0x0065
            java.lang.String r5 = r11.m2962a(r6, r0)     // Catch:{ all -> 0x0086 }
            goto L_0x002b
        L_0x0065:
            if (r5 == 0) goto L_0x002b
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ all -> 0x0086 }
            java.lang.String r10 = "("
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ all -> 0x0086 }
            boolean r7 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r7, (java.lang.CharSequence) r10, (boolean) r8, (int) r9, (java.lang.Object) r1)     // Catch:{ all -> 0x0086 }
            if (r7 != 0) goto L_0x002b
            r11.m2963a(r6, r5, r0)     // Catch:{ all -> 0x0086 }
            goto L_0x002b
        L_0x0078:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException     // Catch:{ all -> 0x0086 }
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.CharSequence"
            r0.<init>(r1)     // Catch:{ all -> 0x0086 }
            throw r0     // Catch:{ all -> 0x0086 }
        L_0x0080:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0086 }
            kotlin.p245io.CloseableKt.closeFinally(r3, r2)
            return r0
        L_0x0086:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0088 }
        L_0x0088:
            r1 = move-exception
            kotlin.p245io.CloseableKt.closeFinally(r3, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kshark.ProguardMappingReader.readProguardMapping():kshark.ProguardMapping");
    }

    /* renamed from: a */
    private final String m2962a(String str, ProguardMapping proguardMapping) {
        CharSequence charSequence = str;
        int indexOf$default = StringsKt.indexOf$default(charSequence, f4608c, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return null;
        }
        int i = indexOf$default + 2;
        int indexOf$default2 = StringsKt.indexOf$default(charSequence, ":", i, false, 4, (Object) null);
        if (indexOf$default2 == -1) {
            return null;
        }
        if (str != null) {
            String substring = str.substring(0, indexOf$default);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (substring != null) {
                String obj = StringsKt.trim(substring).toString();
                if (str != null) {
                    String substring2 = str.substring(i, indexOf$default2);
                    Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (substring2 != null) {
                        String obj2 = StringsKt.trim(substring2).toString();
                        proguardMapping.addMapping(obj2, obj);
                        return obj2;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: a */
    private final void m2963a(String str, String str2, ProguardMapping proguardMapping) {
        CharSequence charSequence = str;
        int indexOf$default = StringsKt.indexOf$default(charSequence, " ", 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            int i = indexOf$default + 1;
            int indexOf$default2 = StringsKt.indexOf$default(charSequence, f4608c, i, false, 4, (Object) null);
            if (indexOf$default2 != -1) {
                if (str != null) {
                    String substring = str.substring(i, indexOf$default2);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (substring != null) {
                        String obj = StringsKt.trim(substring).toString();
                        int i2 = indexOf$default2 + 2;
                        if (str != null) {
                            String substring2 = str.substring(i2);
                            Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
                            if (substring2 != null) {
                                String obj2 = StringsKt.trim(substring2).toString();
                                proguardMapping.addMapping(str2 + '.' + obj2, obj);
                                return;
                            }
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lkshark/ProguardMappingReader$Companion;", "", "()V", "ARROW_SYMBOL", "", "COLON_SYMBOL", "HASH_SYMBOL", "OPENING_PAREN_SYMBOL", "SPACE_SYMBOL", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: ProguardMappingReader.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
