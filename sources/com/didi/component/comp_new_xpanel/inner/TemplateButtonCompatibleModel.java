package com.didi.component.comp_new_xpanel.inner;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.xengine.model.TemplateBgColorModel;
import com.didi.component.business.xpanelnew.OmegaXPTrack;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.drouter.api.DRouter;
import com.didi.sdk.global.common.com.UiUtils;
import com.didiglobal.enginecore.template.temp.IXEViewModel;
import com.google.gson.annotations.SerializedName;

public class TemplateButtonCompatibleModel {
    @SerializedName("bg_color")
    public TemplateBgColorModel btnBgColor;
    public String optionId;
    @SerializedName(alternate = {"title"}, value = "text")
    public RichInfoCompatible title;
    public String url;

    public void bindTextView(final IXEViewModel iXEViewModel, TextView textView, int i) {
        RichInfoCompatible richInfoCompatible;
        if (textView != null && (richInfoCompatible = this.title) != null) {
            richInfoCompatible.bindTextView(textView);
            if (!TextUtils.isEmpty(this.url)) {
                textView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        IXEViewModel iXEViewModel = iXEViewModel;
                        if (iXEViewModel != null) {
                            OmegaXPTrack.omegaTrackWhenClickBtn(iXEViewModel, TemplateButtonCompatibleModel.this.optionId);
                        }
                        DRouter.build(TemplateButtonCompatibleModel.this.url).start();
                    }
                });
            }
            TemplateBgColorModel templateBgColorModel = this.btnBgColor;
            if (templateBgColorModel != null) {
                templateBgColorModel.bindView(textView, i);
                return;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius((float) UiUtils.dip2px(textView.getContext(), (float) i));
            gradientDrawable.setColor(Color.parseColor(ColorUtils.DIDI_GREY));
            textView.setBackground(gradientDrawable);
        }
    }

    public void bindView(final IXEViewModel iXEViewModel, View view) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    IXEViewModel iXEViewModel = iXEViewModel;
                    if (iXEViewModel != null) {
                        OmegaXPTrack.omegaTrackWhenClickCard(iXEViewModel);
                    }
                    DRouter.build(TemplateButtonCompatibleModel.this.url).start();
                }
            });
            TemplateBgColorModel templateBgColorModel = this.btnBgColor;
            if (templateBgColorModel != null) {
                templateBgColorModel.bindView(view, 0);
            }
        }
    }
}
