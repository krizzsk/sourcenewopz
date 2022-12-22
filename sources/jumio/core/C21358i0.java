package jumio.core;

import com.google.common.base.Ascii;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import com.jumio.core.api.calls.AnalyticsCall;
import com.jumio.core.models.ApiCallDataModel;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;

/* renamed from: jumio.core.i0 */
/* compiled from: ReportingCall.kt */
public final class C21358i0 extends AnalyticsCall {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C21358i0(C21351f fVar, ApiCallDataModel<?> apiCallDataModel) {
        super(fVar, apiCallDataModel);
        Intrinsics.checkNotNullParameter(fVar, "apiCallSettings");
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
    }

    public String getUri() {
        return StringDeobfuscator.deobfuscate(new byte[]{78, -100, Ascii.f53596US, -124, -58, Ascii.DC2, -45, 0, -42, -18, 55, 32, -45, Utf8.REPLACEMENT_BYTE}, -8890451435662554744L);
    }
}
