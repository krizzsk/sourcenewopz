package com.didi.component.business.xengine.model;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.xpanelnew.OmegaXPTrack;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.drouter.api.DRouter;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.sdk.global.common.com.UiUtils;
import com.didiglobal.enginecore.template.temp.IXEViewModel;
import com.google.gson.annotations.SerializedName;

public class TemplateButtonModel {
    @SerializedName("bg_color")
    public TemplateBgColorModel btnBgColor;
    public String optionId;
    public LEGORichInfo title;
    public String url;

    public void bindTextView(final IXEViewModel iXEViewModel, TextView textView, int i) {
        LEGORichInfo lEGORichInfo;
        if (textView != null && (lEGORichInfo = this.title) != null) {
            lEGORichInfo.bindTextView(textView);
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    IXEViewModel iXEViewModel = iXEViewModel;
                    if (iXEViewModel != null) {
                        OmegaXPTrack.omegaTrackWhenClickBtn(iXEViewModel, TemplateButtonModel.this.optionId);
                    }
                    DRouter.build(TemplateButtonModel.this.url).start();
                }
            });
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

    public void bindView(View view) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    DRouter.build(TemplateButtonModel.this.url).start();
                }
            });
            TemplateBgColorModel templateBgColorModel = this.btnBgColor;
            if (templateBgColorModel != null) {
                templateBgColorModel.bindView(view, 0);
            }
        }
    }
}
