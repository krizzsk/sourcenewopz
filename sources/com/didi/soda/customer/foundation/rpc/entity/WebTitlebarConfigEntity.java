package com.didi.soda.customer.foundation.rpc.entity;

import android.text.TextUtils;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import java.util.ArrayList;

public class WebTitlebarConfigEntity implements IEntity {
    private static final long serialVersionUID = 3689820516265986040L;
    public ItemEntity backBtn;
    public ItemEntity nav;
    public ArrayList<ButtonItemEntity> rightBtns;
    public int sysStatusBar;
    public ItemEntity title;

    public boolean equals(Object obj) {
        ItemEntity itemEntity;
        ItemEntity itemEntity2;
        ItemEntity itemEntity3;
        if (!(obj instanceof WebTitlebarConfigEntity)) {
            return false;
        }
        WebTitlebarConfigEntity webTitlebarConfigEntity = (WebTitlebarConfigEntity) obj;
        if (this.sysStatusBar != webTitlebarConfigEntity.sysStatusBar || (itemEntity = this.backBtn) == null || !itemEntity.equals(webTitlebarConfigEntity.backBtn) || (itemEntity2 = this.title) == null || !itemEntity2.equals(webTitlebarConfigEntity.title) || (itemEntity3 = this.nav) == null || !itemEntity3.equals(webTitlebarConfigEntity.nav)) {
            return false;
        }
        if ((CollectionsUtil.isEmpty(this.rightBtns) || !this.rightBtns.containsAll(webTitlebarConfigEntity.rightBtns) || CollectionsUtil.isEmpty(webTitlebarConfigEntity.rightBtns) || !webTitlebarConfigEntity.rightBtns.containsAll(this.rightBtns)) && (!CollectionsUtil.isEmpty(this.rightBtns) || !CollectionsUtil.isEmpty(webTitlebarConfigEntity.rightBtns))) {
            return false;
        }
        return true;
    }

    public static class ItemEntity implements IEntity {
        private static final long serialVersionUID = -912408080475297476L;
        public float alpha;
        public String color;
        public String content;
        public int hidden = 0;
        public String position;

        public boolean equals(Object obj) {
            if (!(obj instanceof ItemEntity)) {
                return false;
            }
            ItemEntity itemEntity = (ItemEntity) obj;
            if (this.alpha != itemEntity.alpha) {
                return false;
            }
            if ((TextUtils.isEmpty(this.color) || !this.color.equals(itemEntity.color)) && (!TextUtils.isEmpty(this.color) || !TextUtils.isEmpty(itemEntity.color))) {
                return false;
            }
            return true;
        }
    }

    public static class ButtonItemEntity implements IEntity {
        public static final int TYPE_ICON = 0;
        public static final int TYPE_TITLE = 1;
        private static final long serialVersionUID = 7166786511838869005L;
        public String action;
        public float alpha;
        public String currentIcon;
        public String name;
        public String preloadIcon;
        public String title;
        public int type;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ButtonItemEntity)) {
                return false;
            }
            ButtonItemEntity buttonItemEntity = (ButtonItemEntity) obj;
            if (Float.compare(buttonItemEntity.alpha, this.alpha) != 0 || this.type != buttonItemEntity.type) {
                return false;
            }
            String str = this.name;
            if (str == null ? buttonItemEntity.name != null : !str.equals(buttonItemEntity.name)) {
                return false;
            }
            String str2 = this.currentIcon;
            if (str2 == null ? buttonItemEntity.currentIcon != null : !str2.equals(buttonItemEntity.currentIcon)) {
                return false;
            }
            String str3 = this.preloadIcon;
            if (str3 == null ? buttonItemEntity.preloadIcon != null : !str3.equals(buttonItemEntity.preloadIcon)) {
                return false;
            }
            String str4 = this.action;
            if (str4 == null ? buttonItemEntity.action != null : !str4.equals(buttonItemEntity.action)) {
                return false;
            }
            String str5 = this.title;
            String str6 = buttonItemEntity.title;
            if (str5 != null) {
                return str5.equals(str6);
            }
            if (str6 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            String str = this.name;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            float f = this.alpha;
            int floatToIntBits = (hashCode + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
            String str2 = this.currentIcon;
            int hashCode2 = (floatToIntBits + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.preloadIcon;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.action;
            int hashCode4 = (((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.type) * 31;
            String str5 = this.title;
            if (str5 != null) {
                i = str5.hashCode();
            }
            return hashCode4 + i;
        }
    }
}
