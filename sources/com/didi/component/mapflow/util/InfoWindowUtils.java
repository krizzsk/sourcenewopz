package com.didi.component.mapflow.util;

import android.content.Context;
import android.text.TextUtils;
import com.android.didi.theme.DidiThemeManager;
import com.didi.component.mapflow.infowindow.model.SubMessage;
import com.taxis99.R;

public class InfoWindowUtils {
    public static TextBuilder getOneLineMessage(Context context, SubMessage subMessage, TextBuilder textBuilder) {
        if (subMessage == null) {
            return textBuilder;
        }
        if (textBuilder == null) {
            textBuilder = new TextBuilder(context);
        }
        if (!TextUtils.isEmpty(subMessage.getLeftText())) {
            textBuilder.addText(subMessage.getLeftText(), (int) R.dimen.oc_map_window_text_size_small, (int) R.color.mapflow_info_window_text_color);
        }
        if (subMessage.getValue() != 0.0d) {
            int i = ((subMessage.getValue() - Math.floor(subMessage.getValue())) > 0.0d ? 1 : ((subMessage.getValue() - Math.floor(subMessage.getValue())) == 0.0d ? 0 : -1));
            double value = subMessage.getValue();
            String valueOf = i == 0 ? String.valueOf((int) value) : String.valueOf(value);
            int color = DidiThemeManager.getIns().getResPicker(context).getColor(R.attr.caution_color);
            textBuilder.addTextWithColor(valueOf, R.dimen.oc_map_window_text_size_middle, color);
            textBuilder.addTextWithColor(subMessage.getUnit(), R.dimen.oc_map_window_text_size_small, color);
        }
        if (!TextUtils.isEmpty(subMessage.getRightText())) {
            textBuilder.addText(subMessage.getRightText(), (int) R.dimen.oc_map_window_text_size_small, (int) R.color.mapflow_info_window_text_color);
        }
        return textBuilder;
    }

    public static TextBuilder getOneLineMessage(Context context, SubMessage subMessage) {
        if (subMessage == null) {
            return null;
        }
        TextBuilder textBuilder = new TextBuilder(context);
        if (!TextUtils.isEmpty(subMessage.getLeftText())) {
            textBuilder.addText(subMessage.getLeftText(), (int) R.dimen.oc_map_window_text_size_small, (int) R.color.mapflow_info_window_text_color);
        }
        int color = DidiThemeManager.getIns().getResPicker(context).getColor(R.attr.caution_color);
        if (subMessage.getValue() != 0.0d) {
            int i = ((subMessage.getValue() - Math.floor(subMessage.getValue())) > 0.0d ? 1 : ((subMessage.getValue() - Math.floor(subMessage.getValue())) == 0.0d ? 0 : -1));
            double value = subMessage.getValue();
            textBuilder.addTextWithColor(i == 0 ? String.valueOf((int) value) : String.valueOf(value), R.dimen.oc_map_window_text_size_middle, color);
            textBuilder.addTextWithColor(subMessage.getUnit(), R.dimen.oc_map_window_text_size_small, color);
        } else if (!TextUtils.isEmpty(subMessage.getUnit())) {
            textBuilder.addTextWithColor("0", R.dimen.oc_map_window_text_size_middle, color);
            textBuilder.addTextWithColor(subMessage.getUnit(), R.dimen.oc_map_window_text_size_small, color);
        }
        if (!TextUtils.isEmpty(subMessage.getRightText())) {
            textBuilder.addText(subMessage.getRightText(), (int) R.dimen.oc_map_window_text_size_small, (int) R.color.mapflow_info_window_text_color);
        }
        return textBuilder;
    }
}
