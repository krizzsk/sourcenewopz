package com.didi.global.globaluikit;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.didi.global.globaluikit.datepicker.LEGODatePickerCallback;
import com.didi.global.globaluikit.datepicker.model.LEGODatePickerModel;
import com.didi.global.globaluikit.datepicker.time.LEGODatePicker;
import com.didi.global.globaluikit.dialog.LEGOBaseDialogModel;
import com.didi.global.globaluikit.dialog.LEGODialogFragment;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGOBaseDrawerModel;
import com.didi.global.globaluikit.popup.BubbleCloseListener;
import com.didi.global.globaluikit.popup.LEGOBubble;
import com.didi.global.globaluikit.popup.model.LEGOBubbleBaseModel;

public class LEGOUICreator {
    public static LEGODrawer showDrawerTemplate(Context context, LEGOBaseDrawerModel lEGOBaseDrawerModel) {
        LEGODrawer lEGODrawer = new LEGODrawer(context, lEGOBaseDrawerModel.convert());
        lEGODrawer.show();
        return lEGODrawer;
    }

    public static LEGODialogFragment showDialogModel(FragmentManager fragmentManager, LEGOBaseDialogModel lEGOBaseDialogModel, String str) {
        LEGODialogFragment newInstance = LEGODialogFragment.newInstance(lEGOBaseDialogModel);
        newInstance.show(fragmentManager, str);
        newInstance.setCancelable(false);
        return newInstance;
    }

    public static LEGOBubble createBubble(Context context, LEGOBubbleBaseModel lEGOBubbleBaseModel) {
        LEGOBubble lEGOBubble = new LEGOBubble(context);
        lEGOBubble.setBubbleContent(lEGOBubbleBaseModel);
        return lEGOBubble;
    }

    public static LEGOBubble createBubble(Context context, String str, int i, String str2, int i2, boolean z, BubbleCloseListener bubbleCloseListener) {
        LEGOBubble lEGOBubble = new LEGOBubble(context);
        lEGOBubble.setBubbleContent(str, i, str2, i2, z, bubbleCloseListener);
        return lEGOBubble;
    }

    public static LEGODatePicker showDatePicker(Context context, LEGODatePickerModel lEGODatePickerModel, LEGODatePickerCallback lEGODatePickerCallback) {
        LEGODatePicker lEGODatePicker = new LEGODatePicker(context, lEGODatePickerModel, lEGODatePickerCallback);
        lEGODatePicker.show();
        return lEGODatePicker;
    }
}
