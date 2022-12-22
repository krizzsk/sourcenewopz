package com.didi.payment.pix.home;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0007\t\n\u000b\f\r\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/payment/pix/home/PixChannelResp;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "()V", "data", "Lcom/didi/payment/pix/home/PixChannelResp$Data;", "getData", "()Lcom/didi/payment/pix/home/PixChannelResp$Data;", "setData", "(Lcom/didi/payment/pix/home/PixChannelResp$Data;)V", "ChannelEntry", "Data", "KeyMgrSelection", "LearnMoreSection", "PanelEntry", "PanelSection", "PixSelection", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixChannelResp.kt */
public final class PixChannelResp extends WBaseResp {
    public Data data;

    public final Data getData() {
        Data data2 = this.data;
        if (data2 != null) {
            return data2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }

    public final void setData(Data data2) {
        Intrinsics.checkNotNullParameter(data2, "<set-?>");
        this.data = data2;
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/payment/pix/home/PixChannelResp$Data;", "", "()V", "helpSection", "Lcom/didi/payment/pix/home/PixChannelResp$LearnMoreSection;", "getHelpSection", "()Lcom/didi/payment/pix/home/PixChannelResp$LearnMoreSection;", "keyMgrSelection", "Lcom/didi/payment/pix/home/PixChannelResp$KeyMgrSelection;", "getKeyMgrSelection", "()Lcom/didi/payment/pix/home/PixChannelResp$KeyMgrSelection;", "setKeyMgrSelection", "(Lcom/didi/payment/pix/home/PixChannelResp$KeyMgrSelection;)V", "panelSection", "Lcom/didi/payment/pix/home/PixChannelResp$PanelSection;", "getPanelSection", "()Lcom/didi/payment/pix/home/PixChannelResp$PanelSection;", "pixSelection", "Lcom/didi/payment/pix/home/PixChannelResp$PixSelection;", "getPixSelection", "()Lcom/didi/payment/pix/home/PixChannelResp$PixSelection;", "setPixSelection", "(Lcom/didi/payment/pix/home/PixChannelResp$PixSelection;)V", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixChannelResp.kt */
    public static final class Data {
        @SerializedName("helpSelection")
        private final LearnMoreSection helpSection;
        @SerializedName("keyManageSelection")
        private KeyMgrSelection keyMgrSelection;
        private final PanelSection panelSection;
        @SerializedName("pixSection")
        private PixSelection pixSelection;

        public final PixSelection getPixSelection() {
            return this.pixSelection;
        }

        public final void setPixSelection(PixSelection pixSelection2) {
            this.pixSelection = pixSelection2;
        }

        public final KeyMgrSelection getKeyMgrSelection() {
            return this.keyMgrSelection;
        }

        public final void setKeyMgrSelection(KeyMgrSelection keyMgrSelection2) {
            this.keyMgrSelection = keyMgrSelection2;
        }

        public final PanelSection getPanelSection() {
            return this.panelSection;
        }

        public final LearnMoreSection getHelpSection() {
            return this.helpSection;
        }
    }

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/payment/pix/home/PixChannelResp$PixSelection;", "", "()V", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "entryList", "", "Lcom/didi/payment/pix/home/PixChannelResp$ChannelEntry;", "getEntryList", "()Ljava/util/List;", "setEntryList", "(Ljava/util/List;)V", "icon", "getIcon", "setIcon", "title", "getTitle", "setTitle", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixChannelResp.kt */
    public static class PixSelection {
        @SerializedName("desc")
        private String description;
        @SerializedName("entryList")
        public List<? extends ChannelEntry> entryList;
        private String icon;
        private String title;

        public final String getIcon() {
            return this.icon;
        }

        public final void setIcon(String str) {
            this.icon = str;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final String getDescription() {
            return this.description;
        }

        public final void setDescription(String str) {
            this.description = str;
        }

        public final List<ChannelEntry> getEntryList() {
            List<? extends ChannelEntry> list = this.entryList;
            if (list != null) {
                return list;
            }
            Intrinsics.throwUninitializedPropertyAccessException("entryList");
            return null;
        }

        public final void setEntryList(List<? extends ChannelEntry> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.entryList = list;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/payment/pix/home/PixChannelResp$ChannelEntry;", "", "()V", "icon", "", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "linkUrl", "getLinkUrl", "setLinkUrl", "name", "getName", "setName", "productLine", "", "getProductLine", "()I", "setProductLine", "(I)V", "typeId", "getTypeId", "setTypeId", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixChannelResp.kt */
    public static class ChannelEntry {
        @SerializedName("iconUrl")
        public String icon;
        public String linkUrl;
        public String name;
        private int productLine = 99996;
        private int typeId;

        public final String getName() {
            String str = this.name;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("name");
            return null;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }

        public final String getIcon() {
            String str = this.icon;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("icon");
            return null;
        }

        public final void setIcon(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.icon = str;
        }

        public final String getLinkUrl() {
            String str = this.linkUrl;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("linkUrl");
            return null;
        }

        public final void setLinkUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.linkUrl = str;
        }

        public final int getTypeId() {
            return this.typeId;
        }

        public final void setTypeId(int i) {
            this.typeId = i;
        }

        public final int getProductLine() {
            return this.productLine;
        }

        public final void setProductLine(int i) {
            this.productLine = i;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/payment/pix/home/PixChannelResp$KeyMgrSelection;", "", "()V", "icon", "", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "linkUrl", "getLinkUrl", "setLinkUrl", "name", "getName", "setName", "title", "getTitle", "setTitle", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixChannelResp.kt */
    public static final class KeyMgrSelection {
        private String icon;
        private String linkUrl;
        private String name;
        private String title;

        public final String getIcon() {
            return this.icon;
        }

        public final void setIcon(String str) {
            this.icon = str;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            this.name = str;
        }

        public final String getLinkUrl() {
            return this.linkUrl;
        }

        public final void setLinkUrl(String str) {
            this.linkUrl = str;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/payment/pix/home/PixChannelResp$LearnMoreSection;", "", "()V", "linkUrl", "", "getLinkUrl", "()Ljava/lang/String;", "setLinkUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixChannelResp.kt */
    public static final class LearnMoreSection {
        private String linkUrl = "";
        private String name = "";

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            this.name = str;
        }

        public final String getLinkUrl() {
            return this.linkUrl;
        }

        public final void setLinkUrl(String str) {
            this.linkUrl = str;
        }
    }

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/payment/pix/home/PixChannelResp$PanelSection;", "", "()V", "panelList", "", "Lcom/didi/payment/pix/home/PixChannelResp$PanelEntry;", "getPanelList", "()Ljava/util/List;", "setPanelList", "(Ljava/util/List;)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixChannelResp.kt */
    public static final class PanelSection {
        public List<PanelEntry> panelList;
        public String title;

        public final String getTitle() {
            String str = this.title;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("title");
            return null;
        }

        public final void setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }

        public final List<PanelEntry> getPanelList() {
            List<PanelEntry> list = this.panelList;
            if (list != null) {
                return list;
            }
            Intrinsics.throwUninitializedPropertyAccessException("panelList");
            return null;
        }

        public final void setPanelList(List<PanelEntry> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.panelList = list;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/payment/pix/home/PixChannelResp$PanelEntry;", "", "()V", "bgColor", "", "", "getBgColor", "()Ljava/util/List;", "setBgColor", "(Ljava/util/List;)V", "imageUrl", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "linkUrl", "getLinkUrl", "setLinkUrl", "subTitle", "getSubTitle", "setSubTitle", "title", "getTitle", "setTitle", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixChannelResp.kt */
    public static final class PanelEntry {
        public List<String> bgColor;
        public String imageUrl;
        public String linkUrl;
        public String subTitle;
        public String title;

        public final String getTitle() {
            String str = this.title;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("title");
            return null;
        }

        public final void setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }

        public final String getSubTitle() {
            String str = this.subTitle;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("subTitle");
            return null;
        }

        public final void setSubTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.subTitle = str;
        }

        public final String getImageUrl() {
            String str = this.imageUrl;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
            return null;
        }

        public final void setImageUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.imageUrl = str;
        }

        public final List<String> getBgColor() {
            List<String> list = this.bgColor;
            if (list != null) {
                return list;
            }
            Intrinsics.throwUninitializedPropertyAccessException("bgColor");
            return null;
        }

        public final void setBgColor(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.bgColor = list;
        }

        public final String getLinkUrl() {
            String str = this.linkUrl;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("linkUrl");
            return null;
        }

        public final void setLinkUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.linkUrl = str;
        }
    }
}
