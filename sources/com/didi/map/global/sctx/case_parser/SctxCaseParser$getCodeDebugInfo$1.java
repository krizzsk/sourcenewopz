package com.didi.map.global.sctx.case_parser;

import com.didi.map.global.sctx.case_parser.model.SctxCaseCode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "", "it", "Lcom/didi/map/global/sctx/case_parser/model/SctxCaseCode;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: SctxCaseParser.kt */
final class SctxCaseParser$getCodeDebugInfo$1 extends Lambda implements Function1<SctxCaseCode, String> {
    public static final SctxCaseParser$getCodeDebugInfo$1 INSTANCE = new SctxCaseParser$getCodeDebugInfo$1();

    SctxCaseParser$getCodeDebugInfo$1() {
        super(1);
    }

    public final String invoke(SctxCaseCode sctxCaseCode) {
        Intrinsics.checkParameterIsNotNull(sctxCaseCode, "it");
        return sctxCaseCode.getPrimaryMsg();
    }
}
