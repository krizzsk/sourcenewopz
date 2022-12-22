package com.didi.global.fintech.cashier.p117ui.viewholder;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/FeeHelpInfo;", "", "type", "", "title", "", "message", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getTitle", "setTitle", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.FeeHelpInfo */
/* compiled from: GlobalCashierFeeViewHolder.kt */
public class FeeHelpInfo {

    /* renamed from: a */
    private Integer f21781a;

    /* renamed from: b */
    private String f21782b;

    /* renamed from: c */
    private String f21783c;

    public FeeHelpInfo() {
        this((Integer) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public FeeHelpInfo(Integer num, String str, String str2) {
        this.f21781a = num;
        this.f21782b = str;
        this.f21783c = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeeHelpInfo(Integer num, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }

    public final Integer getType() {
        return this.f21781a;
    }

    public final void setType(Integer num) {
        this.f21781a = num;
    }

    public final String getTitle() {
        return this.f21782b;
    }

    public final void setTitle(String str) {
        this.f21782b = str;
    }

    public final String getMessage() {
        return this.f21783c;
    }

    public final void setMessage(String str) {
        this.f21783c = str;
    }
}
