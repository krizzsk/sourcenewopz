package com.koushikdutta.async.parser;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.future.ThenCallback;
import com.koushikdutta.async.stream.ByteBufferListInputStream;
import javax.xml.parsers.DocumentBuilderFactory;

/* renamed from: com.koushikdutta.async.parser.-$$Lambda$DocumentParser$1rn4BttcABaXJ79ZmLU_gAdRZL0  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$DocumentParser$1rn4BttcABaXJ79ZmLU_gAdRZL0 implements ThenCallback {
    public static final /* synthetic */ $$Lambda$DocumentParser$1rn4BttcABaXJ79ZmLU_gAdRZL0 INSTANCE = new $$Lambda$DocumentParser$1rn4BttcABaXJ79ZmLU_gAdRZL0();

    private /* synthetic */ $$Lambda$DocumentParser$1rn4BttcABaXJ79ZmLU_gAdRZL0() {
    }

    public final Object then(Object obj) {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteBufferListInputStream((ByteBufferList) obj));
    }
}
