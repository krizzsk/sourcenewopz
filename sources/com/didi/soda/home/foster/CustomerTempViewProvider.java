package com.didi.soda.home.foster;

import com.didi.sdk.partner.ITemplateViewProvider;
import com.didi.sdk.partner.supportcard.TemplateInfo;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@ServiceProvider(alias = "soda", value = {ITemplateViewProvider.class})
@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/soda/home/foster/CustomerTempViewProvider;", "Lcom/didi/sdk/partner/ITemplateViewProvider;", "()V", "getSupportCardTemplateInfo", "Lcom/didi/sdk/partner/supportcard/TemplateInfo;", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerTempViewProvider.kt */
public final class CustomerTempViewProvider implements ITemplateViewProvider {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private static final String f42641a = "food_scroll";

    /* renamed from: b */
    private static final String f42642b = "waimai_template_card";

    public TemplateInfo getSupportCardTemplateInfo() {
        return new TemplateInfo(f42641a, f42642b, CustomerTemplateView.class);
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/soda/home/foster/CustomerTempViewProvider$Companion;", "", "()V", "templateId", "", "templateName", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerTempViewProvider.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
