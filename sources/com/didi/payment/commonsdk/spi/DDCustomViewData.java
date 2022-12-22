package com.didi.payment.commonsdk.spi;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/spi/DDCustomViewData;", "", "()V", "exitDetail", "Lcom/didi/payment/commonsdk/spi/DDCustomViewData$ExitDetail;", "getExitDetail", "()Lcom/didi/payment/commonsdk/spi/DDCustomViewData$ExitDetail;", "setExitDetail", "(Lcom/didi/payment/commonsdk/spi/DDCustomViewData$ExitDetail;)V", "tipsList", "", "", "getTipsList", "()Ljava/util/List;", "setTipsList", "(Ljava/util/List;)V", "tipsTitle", "getTipsTitle", "()Ljava/lang/String;", "setTipsTitle", "(Ljava/lang/String;)V", "clearData", "", "ExitDetail", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DDCustomViewData.kt */
public final class DDCustomViewData {
    public static final DDCustomViewData INSTANCE = new DDCustomViewData();

    /* renamed from: a */
    private static String f30168a;

    /* renamed from: b */
    private static List<String> f30169b;

    /* renamed from: c */
    private static ExitDetail f30170c = new ExitDetail();

    private DDCustomViewData() {
    }

    public final String getTipsTitle() {
        return f30168a;
    }

    public final void setTipsTitle(String str) {
        f30168a = str;
    }

    public final List<String> getTipsList() {
        return f30169b;
    }

    public final void setTipsList(List<String> list) {
        f30169b = list;
    }

    public final ExitDetail getExitDetail() {
        return f30170c;
    }

    public final void setExitDetail(ExitDetail exitDetail) {
        Intrinsics.checkNotNullParameter(exitDetail, "<set-?>");
        f30170c = exitDetail;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/spi/DDCustomViewData$ExitDetail;", "", "()V", "firstBtn", "", "getFirstBtn", "()Ljava/lang/String;", "setFirstBtn", "(Ljava/lang/String;)V", "secondBtn", "getSecondBtn", "setSecondBtn", "subTitle", "getSubTitle", "setSubTitle", "title", "getTitle", "setTitle", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: DDCustomViewData.kt */
    public static final class ExitDetail {
        private String firstBtn = "";
        private String secondBtn = "";
        private String subTitle = "";
        private String title = "";

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }

        public final String getSubTitle() {
            return this.subTitle;
        }

        public final void setSubTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.subTitle = str;
        }

        public final String getFirstBtn() {
            return this.firstBtn;
        }

        public final void setFirstBtn(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.firstBtn = str;
        }

        public final String getSecondBtn() {
            return this.secondBtn;
        }

        public final void setSecondBtn(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.secondBtn = str;
        }
    }

    public final void clearData() {
        f30168a = null;
        f30169b = null;
        f30170c = new ExitDetail();
    }
}
