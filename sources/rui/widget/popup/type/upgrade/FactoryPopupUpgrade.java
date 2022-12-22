package rui.widget.popup.type.upgrade;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import rui.util.ViewUtils;
import rui.widget.popup.PopupView;
import rui.widget.popup.base.IPopupFactory;
import rui.widget.popup.base.PopupViews;

public class FactoryPopupUpgrade implements IPopupFactory<PopupUpgrade>, IPopupUpgrade {

    /* renamed from: a */
    private static final int f6844a = Integer.MIN_VALUE;

    /* renamed from: b */
    private TextView f6845b;

    /* renamed from: c */
    private TextView f6846c;

    /* renamed from: d */
    private LinearLayout f6847d;

    /* renamed from: e */
    private LinearLayout f6848e;

    /* renamed from: f */
    private FrameLayout f6849f;

    public void create(PopupView popupView, PopupUpgrade popupUpgrade) {
        Context context = popupView.getContext();
        TextView createTitle = PopupViews.createTitle(context, popupUpgrade.title);
        this.f6845b = createTitle;
        popupView.addView(createTitle);
        TextView createUpgradeContent = PopupViews.createUpgradeContent(context, popupUpgrade.content);
        this.f6846c = createUpgradeContent;
        popupView.addView(createUpgradeContent);
        this.f6847d = PopupViews.createButtonContainer(context);
        this.f6848e = PopupViews.createButtonContainer(context);
        PopupViews.fillButtonContainer(context, this.f6847d, popupUpgrade.getConfirmButtons());
        PopupViews.fillButtonContainer(context, this.f6848e, popupUpgrade.getFinishButtons());
        this.f6849f = PopupViews.createProgressBar(context, popupUpgrade.progressDrawable);
        if (popupUpgrade.progressOnClick != null) {
            this.f6849f.setOnClickListener(popupUpgrade.progressOnClick);
        }
        showConfirm();
        popupView.addView(this.f6849f);
        popupView.addView(this.f6848e);
        popupView.addView(this.f6847d);
    }

    public void updateTitle(String str) {
        TextView textView = this.f6845b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void updateContent(String str) {
        TextView textView = this.f6846c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void showConfirm() {
        ViewUtils.gone(this.f6849f);
        ViewUtils.gone(this.f6848e);
        ViewUtils.visible(this.f6847d);
    }

    public void showProgress(String str) {
        showProgress(Integer.MIN_VALUE, str);
    }

    public void showProgress(int i, String str) {
        if (i != Integer.MIN_VALUE) {
            ((ProgressBar) this.f6849f.findViewWithTag("progress")).setProgress(i);
        }
        ((TextView) this.f6849f.findViewWithTag("title")).setText(str);
        ViewUtils.gone(this.f6847d);
        ViewUtils.gone(this.f6848e);
        ViewUtils.visible(this.f6849f);
    }

    public void showFinish() {
        ViewUtils.gone(this.f6847d);
        ViewUtils.gone(this.f6849f);
        ViewUtils.visible(this.f6848e);
    }
}
