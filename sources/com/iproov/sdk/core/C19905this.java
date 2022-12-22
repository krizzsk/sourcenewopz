package com.iproov.sdk.core;

/* renamed from: com.iproov.sdk.core.this */
/* compiled from: InternalOptions */
public class C19905this {

    /* renamed from: do */
    public final C19906do f54340do;

    /* renamed from: com.iproov.sdk.core.this$do */
    /* compiled from: InternalOptions */
    public enum C19906do {
        NATIVE("native"),
        NATIVE_BRIDGE("native_bridge");
        

        /* renamed from: do */
        public final String f54342do;

        private C19906do(String str) {
            this.f54342do = str;
        }
    }

    public C19905this(C19906do doVar) {
        this.f54340do = doVar;
    }

    public C19905this() {
        this.f54340do = C19906do.NATIVE;
    }
}
