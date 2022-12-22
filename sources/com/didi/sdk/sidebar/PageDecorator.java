package com.didi.sdk.sidebar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.didi.sdk.view.GlobalTitleBar;
import com.didi.sdk.view.titlebar.CommonTitleBar;

public class PageDecorator {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public CommonTitleBar f37171a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public GlobalTitleBar f37172b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ViewGroup f37173c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f37174d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Integer f37175e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Integer f37176f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Integer f37177g;

    private PageDecorator() {
    }

    public static class PageDecoratorBuilder {
        private CommonTitleBar commonTitleBar;
        private ViewGroup content;
        private int dividerRes;
        private GlobalTitleBar globalTitleBar;
        private Integer height;
        private Integer paddingLeft;
        private Integer paddingRight;

        public PageDecoratorBuilder(ViewGroup viewGroup) {
            this.content = viewGroup;
        }

        public PageDecoratorBuilder setTitleView(CommonTitleBar commonTitleBar2) {
            this.commonTitleBar = commonTitleBar2;
            return this;
        }

        public PageDecoratorBuilder setGlobalTitleView(GlobalTitleBar globalTitleBar2) {
            this.globalTitleBar = globalTitleBar2;
            return this;
        }

        public PageDecoratorBuilder setDividerColor(int i) {
            this.dividerRes = i;
            return this;
        }

        public PageDecoratorBuilder setItemMarin(int i, int i2) {
            this.paddingLeft = Integer.valueOf(i);
            this.paddingRight = Integer.valueOf(i2);
            return this;
        }

        public PageDecoratorBuilder setDividerHeight(int i) {
            this.height = Integer.valueOf(i);
            return this;
        }

        public PageDecorator build() {
            PageDecorator pageDecorator = new PageDecorator();
            ViewGroup unused = pageDecorator.f37173c = this.content;
            CommonTitleBar unused2 = pageDecorator.f37171a = this.commonTitleBar;
            GlobalTitleBar unused3 = pageDecorator.f37172b = this.globalTitleBar;
            int unused4 = pageDecorator.f37174d = this.dividerRes;
            Integer unused5 = pageDecorator.f37175e = this.height;
            Integer unused6 = pageDecorator.f37176f = this.paddingLeft;
            Integer unused7 = pageDecorator.f37177g = this.paddingRight;
            return pageDecorator;
        }
    }

    public void addView(View view) {
        this.f37173c.addView(view);
        Integer num = this.f37176f;
        int i = 0;
        int intValue = num != null ? num.intValue() : 0;
        Integer num2 = this.f37177g;
        if (num2 != null) {
            i = num2.intValue();
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(view.getWidth(), view.getHeight());
        }
        layoutParams.setMargins(intValue, layoutParams.topMargin, i, layoutParams.bottomMargin);
        layoutParams.setMarginStart(intValue);
        layoutParams.setMarginEnd(i);
        view.setLayoutParams(layoutParams);
    }

    public void addDivider(View view) {
        this.f37173c.addView(view);
    }

    public CommonTitleBar getCommonTitleBar() {
        return this.f37171a;
    }

    public GlobalTitleBar getGlobalTitleBar() {
        return this.f37172b;
    }

    public int getDividerColor() {
        return this.f37174d;
    }

    public int getDividerHeight() {
        Integer num = this.f37175e;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }
}
