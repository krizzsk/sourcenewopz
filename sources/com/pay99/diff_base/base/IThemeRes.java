package com.pay99.diff_base.base;

import kotlin.Metadata;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0003\t\n\u000bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&¨\u0006\f"}, mo175978d2 = {"Lcom/pay99/diff_base/base/IThemeRes;", "Lcom/pay99/diff_base/base/IDiff;", "()V", "getThemeColorResData", "Lcom/pay99/diff_base/base/IThemeRes$ThemeColorResData;", "getThemeImgResData", "Lcom/pay99/diff_base/base/IThemeRes$ThemeImgResData;", "getThemeStrResData", "Lcom/pay99/diff_base/base/IThemeRes$ThemeStrResData;", "ThemeColorResData", "ThemeImgResData", "ThemeStrResData", "diff-base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IThemeRes.kt */
public abstract class IThemeRes implements IDiff {
    public abstract ThemeColorResData getThemeColorResData();

    public abstract ThemeImgResData getThemeImgResData();

    public abstract ThemeStrResData getThemeStrResData();

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, mo175978d2 = {"Lcom/pay99/diff_base/base/IThemeRes$ThemeStrResData;", "", "csGuideContentResId", "", "(I)V", "getCsGuideContentResId", "()I", "setCsGuideContentResId", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "diff-base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IThemeRes.kt */
    public static final class ThemeStrResData {
        private int csGuideContentResId;

        public static /* synthetic */ ThemeStrResData copy$default(ThemeStrResData themeStrResData, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = themeStrResData.csGuideContentResId;
            }
            return themeStrResData.copy(i);
        }

        public final int component1() {
            return this.csGuideContentResId;
        }

        public final ThemeStrResData copy(int i) {
            return new ThemeStrResData(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ThemeStrResData) && this.csGuideContentResId == ((ThemeStrResData) obj).csGuideContentResId;
        }

        public int hashCode() {
            return this.csGuideContentResId;
        }

        public String toString() {
            return "ThemeStrResData(csGuideContentResId=" + this.csGuideContentResId + VersionRange.RIGHT_OPEN;
        }

        public ThemeStrResData(int i) {
            this.csGuideContentResId = i;
        }

        public final int getCsGuideContentResId() {
            return this.csGuideContentResId;
        }

        public final void setCsGuideContentResId(int i) {
            this.csGuideContentResId = i;
        }
    }

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, mo175978d2 = {"Lcom/pay99/diff_base/base/IThemeRes$ThemeImgResData;", "", "csUtilitiesEntranceTopIconResId", "", "(I)V", "getCsUtilitiesEntranceTopIconResId", "()I", "setCsUtilitiesEntranceTopIconResId", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "diff-base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IThemeRes.kt */
    public static final class ThemeImgResData {
        private int csUtilitiesEntranceTopIconResId;

        public static /* synthetic */ ThemeImgResData copy$default(ThemeImgResData themeImgResData, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = themeImgResData.csUtilitiesEntranceTopIconResId;
            }
            return themeImgResData.copy(i);
        }

        public final int component1() {
            return this.csUtilitiesEntranceTopIconResId;
        }

        public final ThemeImgResData copy(int i) {
            return new ThemeImgResData(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ThemeImgResData) && this.csUtilitiesEntranceTopIconResId == ((ThemeImgResData) obj).csUtilitiesEntranceTopIconResId;
        }

        public int hashCode() {
            return this.csUtilitiesEntranceTopIconResId;
        }

        public String toString() {
            return "ThemeImgResData(csUtilitiesEntranceTopIconResId=" + this.csUtilitiesEntranceTopIconResId + VersionRange.RIGHT_OPEN;
        }

        public ThemeImgResData(int i) {
            this.csUtilitiesEntranceTopIconResId = i;
        }

        public final int getCsUtilitiesEntranceTopIconResId() {
            return this.csUtilitiesEntranceTopIconResId;
        }

        public final void setCsUtilitiesEntranceTopIconResId(int i) {
            this.csUtilitiesEntranceTopIconResId = i;
        }
    }

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, mo175978d2 = {"Lcom/pay99/diff_base/base/IThemeRes$ThemeColorResData;", "", "csUtilitiesSubmitBtnBgResId", "", "(I)V", "getCsUtilitiesSubmitBtnBgResId", "()I", "setCsUtilitiesSubmitBtnBgResId", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "diff-base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IThemeRes.kt */
    public static final class ThemeColorResData {
        private int csUtilitiesSubmitBtnBgResId;

        public static /* synthetic */ ThemeColorResData copy$default(ThemeColorResData themeColorResData, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = themeColorResData.csUtilitiesSubmitBtnBgResId;
            }
            return themeColorResData.copy(i);
        }

        public final int component1() {
            return this.csUtilitiesSubmitBtnBgResId;
        }

        public final ThemeColorResData copy(int i) {
            return new ThemeColorResData(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ThemeColorResData) && this.csUtilitiesSubmitBtnBgResId == ((ThemeColorResData) obj).csUtilitiesSubmitBtnBgResId;
        }

        public int hashCode() {
            return this.csUtilitiesSubmitBtnBgResId;
        }

        public String toString() {
            return "ThemeColorResData(csUtilitiesSubmitBtnBgResId=" + this.csUtilitiesSubmitBtnBgResId + VersionRange.RIGHT_OPEN;
        }

        public ThemeColorResData(int i) {
            this.csUtilitiesSubmitBtnBgResId = i;
        }

        public final int getCsUtilitiesSubmitBtnBgResId() {
            return this.csUtilitiesSubmitBtnBgResId;
        }

        public final void setCsUtilitiesSubmitBtnBgResId(int i) {
            this.csUtilitiesSubmitBtnBgResId = i;
        }
    }
}
