package com.didi.soda.customer.widget.tabbar;

import android.os.Bundle;
import com.didi.soda.customer.foundation.rpc.entity.TagEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u00002\u00020\u0001:\u0001QB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010P\u001a\u00020\u0004H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\u001a\u0010(\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u000107X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR\u001c\u0010?\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010D\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0006\"\u0004\bF\u0010\bR\"\u0010G\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010L\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010M\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010L\u001a\u0004\bN\u0010I\"\u0004\bO\u0010K¨\u0006R"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/tabbar/TabBarItem;", "", "()V", "bottomName", "", "getBottomName", "()Ljava/lang/String;", "setBottomName", "(Ljava/lang/String;)V", "controller", "Lcom/didi/soda/customer/widget/tabbar/ComponentController;", "getController", "()Lcom/didi/soda/customer/widget/tabbar/ComponentController;", "setController", "(Lcom/didi/soda/customer/widget/tabbar/ComponentController;)V", "currentIndex", "", "getCurrentIndex", "()I", "setCurrentIndex", "(I)V", "iconRes", "getIconRes", "setIconRes", "iconResSelected", "getIconResSelected", "setIconResSelected", "iconUrl", "getIconUrl", "setIconUrl", "iconUrlSelected", "getIconUrlSelected", "setIconUrlSelected", "isCanDoubleClick", "", "()Z", "setCanDoubleClick", "(Z)V", "isLazyLoad", "setLazyLoad", "isSelected", "setSelected", "mDiscountTag", "Lcom/didi/soda/customer/foundation/rpc/entity/TagEntity;", "getMDiscountTag", "()Lcom/didi/soda/customer/foundation/rpc/entity/TagEntity;", "setMDiscountTag", "(Lcom/didi/soda/customer/foundation/rpc/entity/TagEntity;)V", "op", "Lcom/didi/soda/customer/widget/tabbar/TabBarOp;", "getOp", "()Lcom/didi/soda/customer/widget/tabbar/TabBarOp;", "setOp", "(Lcom/didi/soda/customer/widget/tabbar/TabBarOp;)V", "params", "Landroid/os/Bundle;", "getParams", "()Landroid/os/Bundle;", "setParams", "(Landroid/os/Bundle;)V", "tabPath", "getTabPath", "setTabPath", "tag", "getTag", "()Ljava/lang/Object;", "setTag", "(Ljava/lang/Object;)V", "text", "getText", "setText", "textColor", "getTextColor", "()Ljava/lang/Integer;", "setTextColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "textColorSelected", "getTextColorSelected", "setTextColorSelected", "toString", "TabBarItemBuilder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TabBarItem.kt */
public final class TabBarItem {

    /* renamed from: a */
    private int f42202a;

    /* renamed from: b */
    private int f42203b;

    /* renamed from: c */
    private String f42204c;

    /* renamed from: d */
    private String f42205d;

    /* renamed from: e */
    private String f42206e;

    /* renamed from: f */
    private Integer f42207f;

    /* renamed from: g */
    private Integer f42208g;

    /* renamed from: h */
    private ComponentController f42209h;

    /* renamed from: i */
    private boolean f42210i;

    /* renamed from: j */
    private boolean f42211j = true;

    /* renamed from: k */
    private boolean f42212k;

    /* renamed from: l */
    private String f42213l;

    /* renamed from: m */
    private Object f42214m;

    /* renamed from: n */
    private TabBarOp f42215n = TabBarOp.ADD;

    /* renamed from: o */
    private Bundle f42216o;

    /* renamed from: p */
    private TagEntity f42217p;

    /* renamed from: q */
    private String f42218q;

    /* renamed from: r */
    private int f42219r;

    public final int getIconRes() {
        return this.f42202a;
    }

    public final void setIconRes(int i) {
        this.f42202a = i;
    }

    public final int getIconResSelected() {
        return this.f42203b;
    }

    public final void setIconResSelected(int i) {
        this.f42203b = i;
    }

    public final String getIconUrl() {
        return this.f42204c;
    }

    public final void setIconUrl(String str) {
        this.f42204c = str;
    }

    public final String getIconUrlSelected() {
        return this.f42205d;
    }

    public final void setIconUrlSelected(String str) {
        this.f42205d = str;
    }

    public final String getText() {
        return this.f42206e;
    }

    public final void setText(String str) {
        this.f42206e = str;
    }

    public final Integer getTextColor() {
        return this.f42207f;
    }

    public final void setTextColor(Integer num) {
        this.f42207f = num;
    }

    public final Integer getTextColorSelected() {
        return this.f42208g;
    }

    public final void setTextColorSelected(Integer num) {
        this.f42208g = num;
    }

    public final ComponentController getController() {
        return this.f42209h;
    }

    public final void setController(ComponentController componentController) {
        this.f42209h = componentController;
    }

    public final boolean isSelected() {
        return this.f42210i;
    }

    public final void setSelected(boolean z) {
        this.f42210i = z;
    }

    public final boolean isLazyLoad() {
        return this.f42211j;
    }

    public final void setLazyLoad(boolean z) {
        this.f42211j = z;
    }

    public final boolean isCanDoubleClick() {
        return this.f42212k;
    }

    public final void setCanDoubleClick(boolean z) {
        this.f42212k = z;
    }

    public final String getTabPath() {
        return this.f42213l;
    }

    public final void setTabPath(String str) {
        this.f42213l = str;
    }

    public final Object getTag() {
        return this.f42214m;
    }

    public final void setTag(Object obj) {
        this.f42214m = obj;
    }

    public final TabBarOp getOp() {
        return this.f42215n;
    }

    public final void setOp(TabBarOp tabBarOp) {
        Intrinsics.checkNotNullParameter(tabBarOp, "<set-?>");
        this.f42215n = tabBarOp;
    }

    public final Bundle getParams() {
        return this.f42216o;
    }

    public final void setParams(Bundle bundle) {
        this.f42216o = bundle;
    }

    public final TagEntity getMDiscountTag() {
        return this.f42217p;
    }

    public final void setMDiscountTag(TagEntity tagEntity) {
        this.f42217p = tagEntity;
    }

    public final String getBottomName() {
        return this.f42218q;
    }

    public final void setBottomName(String str) {
        this.f42218q = str;
    }

    public final int getCurrentIndex() {
        return this.f42219r;
    }

    public final void setCurrentIndex(int i) {
        this.f42219r = i;
    }

    public String toString() {
        return "TabBarItem@" + hashCode() + " text = " + this.f42206e;
    }

    @Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0014J\u0010\u0010)\u001a\u00020\u00002\b\u0010*\u001a\u0004\u0018\u00010\u0006J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0016\u0010,\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010-\u001a\u00020\bJ\u0016\u0010.\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bJ\u000e\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0014J\u000e\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0014J\u000e\u00103\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u000bJ\u000e\u00104\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0001J\u000e\u00105\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u000bJ\u001f\u00106\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\u0010\"\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u00107J\u000e\u00108\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001c\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 ¨\u00069"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/tabbar/TabBarItem$TabBarItemBuilder;", "", "()V", "controller", "Lcom/didi/soda/customer/widget/tabbar/ComponentController;", "discountTag", "Lcom/didi/soda/customer/foundation/rpc/entity/TagEntity;", "iconRes", "", "iconResSelected", "iconUrl", "", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "iconUrlSelected", "getIconUrlSelected", "setIconUrlSelected", "isCanDoubleClick", "", "isLazyLoad", "isSelected", "params", "Landroid/os/Bundle;", "tabPath", "tag", "text", "textColor", "getTextColor", "()Ljava/lang/Integer;", "setTextColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "textColorSelected", "getTextColorSelected", "setTextColorSelected", "builder", "Lcom/didi/soda/customer/widget/tabbar/TabBarItem;", "setCanDoubleClick", "can", "setDiscountTag", "tagEntity", "setItemController", "setItemIconRes", "selectedIconRes", "setItemIconUrl", "setItemIsLazyLoad", "lazyLoad", "setItemIsSelected", "selected", "setItemTabPath", "setItemTag", "setItemText", "setItemTextColor", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/didi/soda/customer/widget/tabbar/TabBarItem$TabBarItemBuilder;", "setParams", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: TabBarItem.kt */
    public static final class TabBarItemBuilder {
        private ComponentController controller;
        private TagEntity discountTag;
        private int iconRes;
        private int iconResSelected;
        private String iconUrl;
        private String iconUrlSelected;
        private boolean isCanDoubleClick;
        private boolean isLazyLoad = true;
        private boolean isSelected;
        private Bundle params;
        private String tabPath;
        private Object tag;
        private String text;
        private Integer textColor;
        private Integer textColorSelected;

        public final Integer getTextColor() {
            return this.textColor;
        }

        public final void setTextColor(Integer num) {
            this.textColor = num;
        }

        public final Integer getTextColorSelected() {
            return this.textColorSelected;
        }

        public final void setTextColorSelected(Integer num) {
            this.textColorSelected = num;
        }

        public final String getIconUrl() {
            return this.iconUrl;
        }

        public final void setIconUrl(String str) {
            this.iconUrl = str;
        }

        public final String getIconUrlSelected() {
            return this.iconUrlSelected;
        }

        public final void setIconUrlSelected(String str) {
            this.iconUrlSelected = str;
        }

        public final TabBarItemBuilder setItemTag(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "tag");
            this.tag = obj;
            return this;
        }

        public final TabBarItemBuilder setItemTabPath(String str) {
            Intrinsics.checkNotNullParameter(str, "tabPath");
            this.tabPath = str;
            return this;
        }

        public final TabBarItemBuilder setItemIconRes(int i, int i2) {
            this.iconRes = i;
            this.iconResSelected = i2;
            return this;
        }

        public final TabBarItemBuilder setItemIconUrl(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "iconUrl");
            Intrinsics.checkNotNullParameter(str2, "iconUrlSelected");
            this.iconUrl = str;
            this.iconUrlSelected = str2;
            return this;
        }

        public final TabBarItemBuilder setItemText(String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            this.text = str;
            return this;
        }

        public final TabBarItemBuilder setItemTextColor(Integer num, Integer num2) {
            this.textColor = num;
            this.textColorSelected = num2;
            return this;
        }

        public final TabBarItemBuilder setItemController(ComponentController componentController) {
            Intrinsics.checkNotNullParameter(componentController, "controller");
            this.controller = componentController;
            return this;
        }

        public final TabBarItemBuilder setItemIsSelected(boolean z) {
            this.isSelected = z;
            return this;
        }

        public final TabBarItemBuilder setItemIsLazyLoad(boolean z) {
            this.isLazyLoad = z;
            return this;
        }

        public final TabBarItemBuilder setCanDoubleClick(boolean z) {
            this.isCanDoubleClick = z;
            return this;
        }

        public final TabBarItemBuilder setParams(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "params");
            this.params = bundle;
            return this;
        }

        public final TabBarItemBuilder setDiscountTag(TagEntity tagEntity) {
            this.discountTag = tagEntity;
            return this;
        }

        public final TabBarItem builder() {
            TabBarItem tabBarItem = new TabBarItem();
            tabBarItem.setText(this.text);
            tabBarItem.setTextColor(getTextColor());
            tabBarItem.setTextColorSelected(getTextColorSelected());
            tabBarItem.setController(this.controller);
            tabBarItem.setSelected(this.isSelected);
            tabBarItem.setLazyLoad(this.isLazyLoad);
            tabBarItem.setCanDoubleClick(this.isCanDoubleClick);
            tabBarItem.setIconRes(this.iconRes);
            tabBarItem.setIconResSelected(this.iconResSelected);
            tabBarItem.setIconUrl(getIconUrl());
            tabBarItem.setIconUrlSelected(getIconUrlSelected());
            tabBarItem.setTag(this.tag);
            tabBarItem.setTabPath(this.tabPath);
            tabBarItem.setParams(this.params);
            tabBarItem.setMDiscountTag(this.discountTag);
            return tabBarItem;
        }
    }
}
