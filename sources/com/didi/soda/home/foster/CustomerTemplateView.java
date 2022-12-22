package com.didi.soda.home.foster;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.didi.sdk.partner.supportcard.ITemplateView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/soda/home/foster/CustomerTemplateView;", "Lcom/didi/sdk/partner/supportcard/ITemplateView;", "()V", "container", "Lcom/didi/soda/home/foster/FosterContainer;", "context", "Landroid/content/Context;", "bindData", "", "model", "Lcom/didi/sdk/partner/supportcard/TemplateModel;", "getView", "Landroid/view/View;", "initView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerTemplateView.kt */
public final class CustomerTemplateView implements ITemplateView {

    /* renamed from: a */
    private FosterContainer f42643a;

    /* renamed from: b */
    private Context f42644b;

    public void initView(Context context) {
        this.f42644b = context;
        if (context != null) {
            this.f42643a = new FosterContainer(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r5 = r5.normal;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindData(com.didi.sdk.partner.supportcard.TemplateModel r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0005
        L_0x0003:
            r5 = r0
            goto L_0x000c
        L_0x0005:
            com.didi.sdk.partner.supportcard.TemplateModel$TemplateNormal r5 = r5.normal
            if (r5 != 0) goto L_0x000a
            goto L_0x0003
        L_0x000a:
            com.google.gson.JsonObject r5 = r5.data
        L_0x000c:
            com.didi.soda.home.foster.Foster r1 = com.didi.soda.home.foster.Foster.INSTANCE
            com.didi.soda.customer.foundation.rpc.entity.SuAppEntity r5 = r1.convertJsonToEntity(r5)
            android.content.Context r1 = r4.f42644b
            if (r1 == 0) goto L_0x0054
            if (r5 == 0) goto L_0x0054
            com.didi.soda.home.foster.Foster r2 = com.didi.soda.home.foster.Foster.INSTANCE
            android.view.View r1 = r2.getView(r1, r5)
            java.util.List r2 = r5.getCompList()
            java.util.Collection r2 = (java.util.Collection) r2
            r3 = 0
            if (r2 == 0) goto L_0x0030
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x002e
            goto L_0x0030
        L_0x002e:
            r2 = 0
            goto L_0x0031
        L_0x0030:
            r2 = 1
        L_0x0031:
            if (r2 != 0) goto L_0x004c
            java.util.List r2 = r5.getCompList()
            if (r2 != 0) goto L_0x003a
            goto L_0x0040
        L_0x003a:
            java.lang.Object r0 = r2.get(r3)
            com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity r0 = (com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity) r0
        L_0x0040:
            com.didi.soda.home.foster.FosterContainer r2 = r4.f42643a
            if (r2 != 0) goto L_0x0045
            goto L_0x004c
        L_0x0045:
            java.lang.String r5 = r5.getRecId()
            r2.mo106972a((com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity) r0, (java.lang.String) r5)
        L_0x004c:
            com.didi.soda.home.foster.FosterContainer r5 = r4.f42643a
            if (r5 != 0) goto L_0x0051
            goto L_0x0054
        L_0x0051:
            r5.mo106971a(r1)
        L_0x0054:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.foster.CustomerTemplateView.bindData(com.didi.sdk.partner.supportcard.TemplateModel):void");
    }

    public View getView() {
        return this.f42643a;
    }
}
