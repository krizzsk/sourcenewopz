package com.google.android.play.core.splitinstall;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SplitInstallRequest {

    /* renamed from: a */
    private final List<String> f53257a;

    /* renamed from: b */
    private final List<Locale> f53258b;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final List<String> f53259a = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final List<Locale> f53260b = new ArrayList();

        private Builder() {
        }

        /* synthetic */ Builder(byte[] bArr) {
        }

        public Builder addLanguage(Locale locale) {
            this.f53260b.add(locale);
            return this;
        }

        public Builder addModule(String str) {
            this.f53259a.add(str);
            return this;
        }

        public SplitInstallRequest build() {
            return new SplitInstallRequest(this);
        }
    }

    /* synthetic */ SplitInstallRequest(Builder builder) {
        this.f53257a = new ArrayList(builder.f53259a);
        this.f53258b = new ArrayList(builder.f53260b);
    }

    public static Builder newBuilder() {
        return new Builder((byte[]) null);
    }

    public List<Locale> getLanguages() {
        return this.f53258b;
    }

    public List<String> getModuleNames() {
        return this.f53257a;
    }

    public String toString() {
        return String.format("SplitInstallRequest{modulesNames=%s,languages=%s}", new Object[]{this.f53257a, this.f53258b});
    }
}
