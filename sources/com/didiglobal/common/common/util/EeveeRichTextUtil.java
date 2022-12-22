package com.didiglobal.common.common.util;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.didiglobal.common.common.model.EeveeRichText;

public class EeveeRichTextUtil {
    public static void setText(TextView textView, EeveeRichText eeveeRichText) {
        if (textView != null && textView.getContext() != null) {
            Context context = textView.getContext();
            if (eeveeRichText.richInfo != null) {
                eeveeRichText.richInfo.bindTextView(textView);
            } else if (eeveeRichText.defaultItem != null && !TextUtils.isEmpty(eeveeRichText.defaultItem.f49740id)) {
                try {
                    textView.setText(context.getResources().getString(context.getResources().getIdentifier(eeveeRichText.defaultItem.f49740id, TypedValues.Custom.S_STRING, context.getPackageName())));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
