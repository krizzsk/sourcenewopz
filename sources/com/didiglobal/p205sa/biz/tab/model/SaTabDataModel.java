package com.didiglobal.p205sa.biz.tab.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR.\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/tab/model/SaTabDataModel;", "Ljava/io/Serializable;", "()V", "curVersion", "", "getCurVersion", "()Ljava/lang/String;", "setCurVersion", "(Ljava/lang/String;)V", "tabMenu", "Ljava/util/ArrayList;", "Lcom/didiglobal/sa/biz/tab/model/SaTabMenuModel;", "Lkotlin/collections/ArrayList;", "getTabMenu", "()Ljava/util/ArrayList;", "setTabMenu", "(Ljava/util/ArrayList;)V", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.tab.model.SaTabDataModel */
/* compiled from: SaTabDataModel.kt */
public final class SaTabDataModel implements Serializable {
    @SerializedName("curVersion")
    private String curVersion = "";
    @SerializedName("tabMenu")
    private ArrayList<SaTabMenuModel> tabMenu = new ArrayList<>();

    public final String getCurVersion() {
        return this.curVersion;
    }

    public final void setCurVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.curVersion = str;
    }

    public final ArrayList<SaTabMenuModel> getTabMenu() {
        return this.tabMenu;
    }

    public final void setTabMenu(ArrayList<SaTabMenuModel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.tabMenu = arrayList;
    }
}
