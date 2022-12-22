package com.didi.sdk.app;

import com.didi.sdk.home.model.TopBarData;
import com.didi.sdk.misconfig.model.CarGrop;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\f\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/sdk/app/TabEventManager;", "", "()V", "lastSelected", "Lcom/didi/sdk/misconfig/model/CarGrop;", "getFromTab", "", "isFromLink", "", "updateLastSelect", "", "group", "TYPE", "TabHandleModel", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TabEventManager.kt */
public final class TabEventManager {
    public static final TabEventManager INSTANCE = new TabEventManager();

    /* renamed from: a */
    private static CarGrop f35222a;

    private TabEventManager() {
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/sdk/app/TabEventManager$TYPE;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "AUTO", "CLICK", "LINK", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: TabEventManager.kt */
    public enum TYPE {
        AUTO(DebugKt.DEBUG_PROPERTY_VALUE_AUTO),
        CLICK("click"),
        LINK("link");
        
        private String value;

        private TYPE(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }

        public final void setValue(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.value = str;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/sdk/app/TabEventManager$TabHandleModel;", "Ljava/io/Serializable;", "()V", "actionType", "Lcom/didi/sdk/app/TabEventManager$TYPE;", "getActionType", "()Lcom/didi/sdk/app/TabEventManager$TYPE;", "setActionType", "(Lcom/didi/sdk/app/TabEventManager$TYPE;)V", "actionUrl", "", "getActionUrl", "()Ljava/lang/String;", "setActionUrl", "(Ljava/lang/String;)V", "fromTab", "getFromTab", "setFromTab", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: TabEventManager.kt */
    public static final class TabHandleModel implements Serializable {
        private TYPE actionType;
        private String actionUrl;
        private String fromTab;

        public final String getActionUrl() {
            return this.actionUrl;
        }

        public final void setActionUrl(String str) {
            this.actionUrl = str;
        }

        public final String getFromTab() {
            return this.fromTab;
        }

        public final void setFromTab(String str) {
            this.fromTab = str;
        }

        public final TYPE getActionType() {
            return this.actionType;
        }

        public final void setActionType(TYPE type) {
            this.actionType = type;
        }
    }

    public final String getFromTab(boolean z) {
        CarGrop carGrop = f35222a;
        if (carGrop == null || z) {
            TopBarData topBarData = ConfProxy.getInstance().getTopBarData();
            String groupType = (topBarData == null || !topBarData.isShowTopBar() || topBarData.selectedGroup == null) ? "ride" : topBarData.selectedGroup.getGroupType();
            Intrinsics.checkNotNullExpressionValue(groupType, "{\n            val data =…e\n            }\n        }");
            return groupType;
        }
        Intrinsics.checkNotNull(carGrop);
        String groupType2 = carGrop.getGroupType();
        Intrinsics.checkNotNullExpressionValue(groupType2, "{\n            lastSelected!!.groupType\n        }");
        return groupType2;
    }

    public final void updateLastSelect(CarGrop carGrop) {
        Intrinsics.checkNotNullParameter(carGrop, "group");
        f35222a = carGrop;
    }
}
