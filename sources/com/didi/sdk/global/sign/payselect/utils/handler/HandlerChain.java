package com.didi.sdk.global.sign.payselect.utils.handler;

import com.didi.sdk.global.sign.model.local.PaySelPageData;
import com.didi.soda.customer.app.constant.Const;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0004j\b\u0012\u0004\u0012\u00020\u0001`\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/didi/sdk/global/sign/payselect/utils/handler/HandlerChain;", "Lcom/didi/sdk/global/sign/payselect/utils/handler/IHandler;", "()V", "handlers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "process", "", "pageData", "Lcom/didi/sdk/global/sign/model/local/PaySelPageData;", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HandlerChain.kt */
public final class HandlerChain implements IHandler {
    public static final HandlerChain INSTANCE = new HandlerChain();

    /* renamed from: a */
    private static ArrayList<IHandler> f36286a;

    private HandlerChain() {
    }

    static {
        ArrayList<IHandler> arrayList = new ArrayList<>();
        f36286a = arrayList;
        arrayList.add(new BalanceCombineSwitchHandler());
    }

    public void process(PaySelPageData paySelPageData) {
        Intrinsics.checkNotNullParameter(paySelPageData, Const.PageParams.PAGE_DATA);
        for (IHandler process : f36286a) {
            process.process(paySelPageData);
        }
    }
}
