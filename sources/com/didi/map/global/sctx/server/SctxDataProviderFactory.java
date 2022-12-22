package com.didi.map.global.sctx.server;

import com.didi.map.global.sctx.case_parser.SctxCaseParser;
import com.didi.map.global.sctx.model.ErrorCodeCollect;
import com.didi.map.global.sctx.model.RuntimeErrorCollect;
import com.didi.map.global.sctx.server.ISctxDataProvider;
import com.didi.map.utils.ApolloUtils;

public class SctxDataProviderFactory {

    /* renamed from: a */
    private ISctxDataProvider f27695a;

    public static ISctxDataProvider createSctxDataProvider(ISctxDataProvider.DataSearchOptions dataSearchOptions, ErrorCodeCollect errorCodeCollect, RuntimeErrorCollect runtimeErrorCollect, SctxCaseParser sctxCaseParser) {
        return new SctxDataProviderFactory().create(dataSearchOptions, errorCodeCollect, runtimeErrorCollect, sctxCaseParser);
    }

    public ISctxDataProvider create(ISctxDataProvider.DataSearchOptions dataSearchOptions, ErrorCodeCollect errorCodeCollect, RuntimeErrorCollect runtimeErrorCollect, SctxCaseParser sctxCaseParser) {
        if (this.f27695a == null) {
            if (ApolloUtils.oraErrorDoSimulate()) {
                this.f27695a = new C9834b(dataSearchOptions, errorCodeCollect, runtimeErrorCollect, sctxCaseParser);
            } else {
                this.f27695a = new C9833a(dataSearchOptions, errorCodeCollect, runtimeErrorCollect, sctxCaseParser);
            }
        }
        return this.f27695a;
    }
}
