package global.didi.pay.merchantcore;

import global.didi.pay.merchantcore.model.DPayRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lglobal/didi/pay/merchantcore/TestConstant;", "", "()V", "Companion", "merchantCore_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: TestConstant.kt */
public final class TestConstant {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final DPayRequest DemoIncompletePayParam = new DPayRequest((String) null, "payOrderId", "merchantId", "appId", "timestamp", "nonceStr", "version", "signature");
    /* access modifiers changed from: private */
    public static final DPayRequest DemoPayParam = new DPayRequest("merchantOrderId", "payOrderId", "merchantId", "appId", "timestamp", "nonceStr", "version", "signature");

    public static final DPayRequest getDemoIncompletePayParam() {
        return DemoIncompletePayParam;
    }

    public static final DPayRequest getDemoPayParam() {
        return DemoPayParam;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, mo175978d2 = {"Lglobal/didi/pay/merchantcore/TestConstant$Companion;", "", "()V", "DemoIncompletePayParam", "Lglobal/didi/pay/merchantcore/model/DPayRequest;", "DemoIncompletePayParam$annotations", "getDemoIncompletePayParam", "()Lglobal/didi/pay/merchantcore/model/DPayRequest;", "DemoPayParam", "DemoPayParam$annotations", "getDemoPayParam", "merchantCore_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: TestConstant.kt */
    public static final class Companion {
        @JvmStatic
        public static /* synthetic */ void DemoIncompletePayParam$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void DemoPayParam$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DPayRequest getDemoPayParam() {
            return TestConstant.DemoPayParam;
        }

        public final DPayRequest getDemoIncompletePayParam() {
            return TestConstant.DemoIncompletePayParam;
        }
    }
}
