package com.didi.sdk.view.dialog;

import android.content.Context;
import com.taxis99.R;
import java.util.Locale;

public class ProductControllerStyleManager {

    /* renamed from: a */
    private static ProductControllerStyleManager f37983a;

    /* renamed from: b */
    private Context f37984b;

    /* renamed from: c */
    private ProductThemeStyle f37985c = new ProductThemeStyle();

    /* renamed from: d */
    private LocaleDelegate f37986d;

    public void setLocaleDelegate(LocaleDelegate localeDelegate) {
        this.f37986d = localeDelegate;
    }

    public LocaleDelegate getLocaleDelegate() {
        LocaleDelegate localeDelegate = this.f37986d;
        return localeDelegate == null ? new LocaleDelegate() {
            public Locale getLocale() {
                return Locale.getDefault();
            }
        } : localeDelegate;
    }

    private ProductControllerStyleManager() {
    }

    public void init(Context context) {
        this.f37984b = context;
        this.f37985c.setDefaultButtonTextColor(context.getResources().getColor(R.color.common_dialog_recommend_option_txt_color));
        this.f37985c.setProductBasicColor(this.f37984b.getResources().getColor(R.color.orange));
    }

    public static ProductControllerStyleManager getInstance() {
        if (f37983a == null) {
            f37983a = new ProductControllerStyleManager();
        }
        return f37983a;
    }

    public void setProductThemeStyle(ProductThemeStyle productThemeStyle) {
        this.f37985c = productThemeStyle;
    }

    public ProductThemeStyle getProductThemeStyle() {
        return this.f37985c;
    }
}
