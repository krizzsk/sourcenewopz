package rui.widget.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.taxis99.R;
import rui.util.ViewUtils;
import rui.widget.dialog.base.DialogViews;

/* renamed from: rui.widget.dialog.a */
/* compiled from: FactoryDialog */
class C3024a {
    C3024a() {
    }

    /* renamed from: a */
    public void mo38501a(DialogView dialogView, DialogModel dialogModel) {
        Context context = dialogView.getContext();
        dialogView.setBackgroundResource(dialogModel.backgroundRes != DialogModel.NO_VALUE ? dialogModel.backgroundRes : R.drawable.rui_dialog_bg);
        View inflate = LayoutInflater.from(context).inflate(R.layout.rui_dialog_header, dialogView, true);
        TextView textView = (TextView) inflate.findViewById(R.id.close);
        if (dialogModel.hasClose) {
            ViewUtils.visible(textView);
            if (dialogModel.onCloseListener != null) {
                textView.setOnClickListener(dialogModel.onCloseListener);
            }
        } else {
            ViewUtils.invisible(textView);
        }
        ImageView imageView = (ImageView) inflate.findViewById(R.id.icon);
        if (dialogModel.iconImage != null) {
            ViewUtils.visible(imageView);
            dialogModel.iconImage.load(imageView);
        } else {
            ViewUtils.gone(imageView);
        }
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.header);
        if (dialogModel.headerImage != null) {
            ViewUtils.visible(imageView2);
            dialogModel.headerImage.load(imageView2);
        } else {
            ViewUtils.gone(imageView2);
        }
        if (!(dialogModel.iconImage == null && dialogModel.headerImage == null) && (!TextUtils.isEmpty(dialogModel.title) || !TextUtils.isEmpty(dialogModel.content))) {
            dialogView.addView(new View(context), new LinearLayout.LayoutParams(-2, (int) ViewUtils.m3859dp(context, 10.0f)));
        }
        if (dialogModel.title != null && !TextUtils.isEmpty(dialogModel.title)) {
            dialogView.addView(DialogViews.createTitle(context, dialogModel.title));
        }
        if (dialogModel.content != null && !TextUtils.isEmpty(dialogModel.content)) {
            TextView createContent = DialogViews.createContent(context, dialogModel.content);
            createContent.setGravity(dialogModel.contentAlign);
            dialogView.addView(createContent);
            if (dialogModel.onContentClickListener != null) {
                createContent.setOnClickListener(dialogModel.onContentClickListener);
            }
        }
        dialogView.addView(new View(context), new LinearLayout.LayoutParams(-2, (int) ViewUtils.m3859dp(context, 16.0f)));
        if (dialogModel.getButtons() != null && !dialogModel.getButtons().isEmpty()) {
            FrameLayout createButtonContainer = DialogViews.createButtonContainer(context);
            DialogViews.fillButtonContainer(context, (LinearLayout) createButtonContainer.findViewWithTag("container"), dialogModel.getButtons());
            dialogView.addView(createButtonContainer);
        }
    }
}
