package com.didi.global.fintech.cashier.model.net.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR&\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006 "}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/CVVDrawerData;", "Ljava/io/Serializable;", "guideTitle", "", "title", "lines", "", "Lcom/didi/global/fintech/cashier/model/net/response/CVVDrawerData$LineData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getGuideTitle", "()Ljava/lang/String;", "setGuideTitle", "(Ljava/lang/String;)V", "getLines", "()Ljava/util/List;", "setLines", "(Ljava/util/List;)V", "getTitle", "setTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ImageData", "LineData", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CVVInfoResponse.kt */
public final class CVVDrawerData implements Serializable {
    @SerializedName("guide_title")
    private String guideTitle;
    @SerializedName("lines")
    private List<LineData> lines;
    @SerializedName("title")
    private String title;

    public CVVDrawerData() {
        this((String) null, (String) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CVVDrawerData copy$default(CVVDrawerData cVVDrawerData, String str, String str2, List<LineData> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cVVDrawerData.guideTitle;
        }
        if ((i & 2) != 0) {
            str2 = cVVDrawerData.title;
        }
        if ((i & 4) != 0) {
            list = cVVDrawerData.lines;
        }
        return cVVDrawerData.copy(str, str2, list);
    }

    public final String component1() {
        return this.guideTitle;
    }

    public final String component2() {
        return this.title;
    }

    public final List<LineData> component3() {
        return this.lines;
    }

    public final CVVDrawerData copy(String str, String str2, List<LineData> list) {
        return new CVVDrawerData(str, str2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CVVDrawerData)) {
            return false;
        }
        CVVDrawerData cVVDrawerData = (CVVDrawerData) obj;
        return Intrinsics.areEqual((Object) this.guideTitle, (Object) cVVDrawerData.guideTitle) && Intrinsics.areEqual((Object) this.title, (Object) cVVDrawerData.title) && Intrinsics.areEqual((Object) this.lines, (Object) cVVDrawerData.lines);
    }

    public int hashCode() {
        String str = this.guideTitle;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<LineData> list = this.lines;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "CVVDrawerData(guideTitle=" + this.guideTitle + ", title=" + this.title + ", lines=" + this.lines + VersionRange.RIGHT_OPEN;
    }

    public CVVDrawerData(String str, String str2, List<LineData> list) {
        this.guideTitle = str;
        this.title = str2;
        this.lines = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CVVDrawerData(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list);
    }

    public final String getGuideTitle() {
        return this.guideTitle;
    }

    public final void setGuideTitle(String str) {
        this.guideTitle = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final List<LineData> getLines() {
        return this.lines;
    }

    public final void setLines(List<LineData> list) {
        this.lines = list;
    }

    @Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003JG\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR&\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006&"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/CVVDrawerData$LineData;", "Ljava/io/Serializable;", "type", "", "textStyle", "imageStyle", "content", "images", "", "Lcom/didi/global/fintech/cashier/model/net/response/CVVDrawerData$ImageData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getImageStyle", "setImageStyle", "getImages", "()Ljava/util/List;", "setImages", "(Ljava/util/List;)V", "getTextStyle", "setTextStyle", "getType", "setType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CVVInfoResponse.kt */
    public static final class LineData implements Serializable {
        @SerializedName("content")
        private String content;
        @SerializedName("image_style")
        private String imageStyle;
        @SerializedName("images")
        private List<ImageData> images;
        @SerializedName("text_style")
        private String textStyle;
        @SerializedName("type")
        private String type;

        public LineData() {
            this((String) null, (String) null, (String) null, (String) null, (List) null, 31, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ LineData copy$default(LineData lineData, String str, String str2, String str3, String str4, List<ImageData> list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = lineData.type;
            }
            if ((i & 2) != 0) {
                str2 = lineData.textStyle;
            }
            String str5 = str2;
            if ((i & 4) != 0) {
                str3 = lineData.imageStyle;
            }
            String str6 = str3;
            if ((i & 8) != 0) {
                str4 = lineData.content;
            }
            String str7 = str4;
            if ((i & 16) != 0) {
                list = lineData.images;
            }
            return lineData.copy(str, str5, str6, str7, list);
        }

        public final String component1() {
            return this.type;
        }

        public final String component2() {
            return this.textStyle;
        }

        public final String component3() {
            return this.imageStyle;
        }

        public final String component4() {
            return this.content;
        }

        public final List<ImageData> component5() {
            return this.images;
        }

        public final LineData copy(String str, String str2, String str3, String str4, List<ImageData> list) {
            Intrinsics.checkNotNullParameter(str2, "textStyle");
            Intrinsics.checkNotNullParameter(str3, "imageStyle");
            return new LineData(str, str2, str3, str4, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LineData)) {
                return false;
            }
            LineData lineData = (LineData) obj;
            return Intrinsics.areEqual((Object) this.type, (Object) lineData.type) && Intrinsics.areEqual((Object) this.textStyle, (Object) lineData.textStyle) && Intrinsics.areEqual((Object) this.imageStyle, (Object) lineData.imageStyle) && Intrinsics.areEqual((Object) this.content, (Object) lineData.content) && Intrinsics.areEqual((Object) this.images, (Object) lineData.images);
        }

        public int hashCode() {
            String str = this.type;
            int i = 0;
            int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.textStyle.hashCode()) * 31) + this.imageStyle.hashCode()) * 31;
            String str2 = this.content;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            List<ImageData> list = this.images;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "LineData(type=" + this.type + ", textStyle=" + this.textStyle + ", imageStyle=" + this.imageStyle + ", content=" + this.content + ", images=" + this.images + VersionRange.RIGHT_OPEN;
        }

        public LineData(String str, String str2, String str3, String str4, List<ImageData> list) {
            Intrinsics.checkNotNullParameter(str2, "textStyle");
            Intrinsics.checkNotNullParameter(str3, "imageStyle");
            this.type = str;
            this.textStyle = str2;
            this.imageStyle = str3;
            this.content = str4;
            this.images = list;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ LineData(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.util.List r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
            /*
                r4 = this;
                r11 = r10 & 1
                r0 = 0
                if (r11 == 0) goto L_0x0007
                r11 = r0
                goto L_0x0008
            L_0x0007:
                r11 = r5
            L_0x0008:
                r5 = r10 & 2
                if (r5 == 0) goto L_0x000e
                java.lang.String r6 = "black"
            L_0x000e:
                r1 = r6
                r5 = r10 & 4
                if (r5 == 0) goto L_0x0015
                java.lang.String r7 = "big"
            L_0x0015:
                r2 = r7
                r5 = r10 & 8
                if (r5 == 0) goto L_0x001c
                r3 = r0
                goto L_0x001d
            L_0x001c:
                r3 = r8
            L_0x001d:
                r5 = r10 & 16
                if (r5 == 0) goto L_0x0023
                r10 = r0
                goto L_0x0024
            L_0x0023:
                r10 = r9
            L_0x0024:
                r5 = r4
                r6 = r11
                r7 = r1
                r8 = r2
                r9 = r3
                r5.<init>(r6, r7, r8, r9, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.model.net.response.CVVDrawerData.LineData.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final String getType() {
            return this.type;
        }

        public final void setType(String str) {
            this.type = str;
        }

        public final String getTextStyle() {
            return this.textStyle;
        }

        public final void setTextStyle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.textStyle = str;
        }

        public final String getImageStyle() {
            return this.imageStyle;
        }

        public final void setImageStyle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.imageStyle = str;
        }

        public final String getContent() {
            return this.content;
        }

        public final void setContent(String str) {
            this.content = str;
        }

        public final List<ImageData> getImages() {
            return this.images;
        }

        public final void setImages(List<ImageData> list) {
            this.images = list;
        }
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/CVVDrawerData$ImageData;", "Ljava/io/Serializable;", "img", "", "description", "(Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getImg", "setImg", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CVVInfoResponse.kt */
    public static final class ImageData implements Serializable {
        @SerializedName("description")
        private String description;
        @SerializedName("img")
        private String img;

        public ImageData() {
            this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ImageData copy$default(ImageData imageData, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = imageData.img;
            }
            if ((i & 2) != 0) {
                str2 = imageData.description;
            }
            return imageData.copy(str, str2);
        }

        public final String component1() {
            return this.img;
        }

        public final String component2() {
            return this.description;
        }

        public final ImageData copy(String str, String str2) {
            return new ImageData(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ImageData)) {
                return false;
            }
            ImageData imageData = (ImageData) obj;
            return Intrinsics.areEqual((Object) this.img, (Object) imageData.img) && Intrinsics.areEqual((Object) this.description, (Object) imageData.description);
        }

        public int hashCode() {
            String str = this.img;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.description;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "ImageData(img=" + this.img + ", description=" + this.description + VersionRange.RIGHT_OPEN;
        }

        public ImageData(String str, String str2) {
            this.img = str;
            this.description = str2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ImageData(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final String getImg() {
            return this.img;
        }

        public final void setImg(String str) {
            this.img = str;
        }

        public final String getDescription() {
            return this.description;
        }

        public final void setDescription(String str) {
            this.description = str;
        }
    }
}
