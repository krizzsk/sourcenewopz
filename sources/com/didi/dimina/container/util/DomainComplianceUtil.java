package com.didi.dimina.container.util;

import com.didi.dimina.container.Dimina;
import com.didi.raven.config.RavenKey;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/dimina/container/util/DomainComplianceUtil;", "", "()V", "Companion", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DomainComplianceUtil.kt */
public final class DomainComplianceUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final String getHttps() {
        return Companion.getHttps();
    }

    @JvmStatic
    public static final String getHttpsColonDoubleSlash() {
        return Companion.getHttpsColonDoubleSlash();
    }

    @JvmStatic
    public static final String getWssColonDoubleSlash() {
        return Companion.getWssColonDoubleSlash();
    }

    @JvmStatic
    public static final boolean isStartWithHttp(String str) {
        return Companion.isStartWithHttp(str);
    }

    @JvmStatic
    public static final boolean isStartsWithHttpOrHttps(String str) {
        return Companion.isStartsWithHttpOrHttps(str);
    }

    @JvmStatic
    public static final boolean isStartsWithHttpOrHttpsColonDoubleSlash(String str) {
        return Companion.isStartsWithHttpOrHttpsColonDoubleSlash(str);
    }

    @JvmStatic
    public static final boolean isStartsWithHttps(String str) {
        return Companion.isStartsWithHttps(str);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0007J\b\u0010\t\u001a\u00020\u0006H\u0007J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0007J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/dimina/container/util/DomainComplianceUtil$Companion;", "", "()V", "alwaysTrue", "", "getColonDoubleSlash", "", "getHttp", "getHttps", "getHttpsColonDoubleSlash", "getWss", "getWssColonDoubleSlash", "isStartWithHttp", "str", "isStartsWithHttpOrHttps", "isStartsWithHttpOrHttpsColonDoubleSlash", "isStartsWithHttps", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: DomainComplianceUtil.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final String getHttps() {
            return getHttp() + RavenKey.STACK;
        }

        @JvmStatic
        public final String getHttpsColonDoubleSlash() {
            StringBuilder sb = new StringBuilder();
            Companion companion = this;
            sb.append(companion.getHttps());
            sb.append(companion.getColonDoubleSlash());
            return sb.toString();
        }

        @JvmStatic
        public final String getWssColonDoubleSlash() {
            StringBuilder sb = new StringBuilder();
            Companion companion = this;
            sb.append(companion.getWss());
            sb.append(companion.getColonDoubleSlash());
            return sb.toString();
        }

        @JvmStatic
        public final boolean isStartWithHttp(String str) {
            if (str != null) {
                return StringsKt.startsWith$default(str, DomainComplianceUtil.Companion.getHttp(), false, 2, (Object) null);
            }
            return false;
        }

        @JvmStatic
        public final boolean isStartsWithHttps(String str) {
            if (str != null) {
                return StringsKt.startsWith$default(str, DomainComplianceUtil.Companion.getHttps(), false, 2, (Object) null);
            }
            return false;
        }

        @JvmStatic
        public final boolean isStartsWithHttpOrHttps(String str) {
            Companion companion = this;
            return companion.isStartWithHttp(str) || companion.isStartsWithHttps(str);
        }

        @JvmStatic
        public final boolean isStartsWithHttpOrHttpsColonDoubleSlash(String str) {
            if (str == null) {
                return false;
            }
            Companion companion = this;
            if (!StringsKt.startsWith$default(str, companion.getHttpsColonDoubleSlash(), false, 2, (Object) null)) {
                StringBuilder sb = new StringBuilder();
                sb.append(companion.getHttp());
                sb.append(companion.getColonDoubleSlash());
                return StringsKt.startsWith$default(str, sb.toString(), false, 2, (Object) null);
            }
        }

        private final String getHttp() {
            StringBuilder sb = new StringBuilder();
            Companion companion = this;
            if (companion.alwaysTrue()) {
                sb.append("ht");
            } else {
                sb.append("..");
            }
            if (companion.alwaysTrue()) {
                sb.append("tp");
            } else {
                sb.append("..");
            }
            String sb2 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb2, "sb.toString()");
            return sb2;
        }

        private final String getColonDoubleSlash() {
            StringBuilder sb = new StringBuilder();
            Companion companion = this;
            if (companion.alwaysTrue()) {
                sb.append(":/");
            } else {
                sb.append("..");
            }
            if (companion.alwaysTrue()) {
                sb.append("/");
            } else {
                sb.append("..");
            }
            String sb2 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb2, "sb.toString()");
            return sb2;
        }

        private final String getWss() {
            StringBuilder sb = new StringBuilder();
            Companion companion = this;
            if (companion.alwaysTrue()) {
                sb.append("ws");
            } else {
                sb.append("..");
            }
            if (companion.alwaysTrue()) {
                sb.append(RavenKey.STACK);
            } else {
                sb.append("..");
            }
            String sb2 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb2, "sb.toString()");
            return sb2;
        }

        private final boolean alwaysTrue() {
            return (!Dimina.isInit() ? -9999 : 5) + ((long) 88888) > 0;
        }
    }
}
