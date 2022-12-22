package com.didi.rfusion.widget.titlebar;

import android.view.View;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001e\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J'\u0010\u000e\u001a\u00020\u00052\u0018\b\u0001\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00110\u0010\"\u0004\u0018\u00010\u0011H&¢\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u00020\u00052\b\b\u0001\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0003H&J\u0012\u0010\u0016\u001a\u00020\u00052\b\b\u0001\u0010\u0018\u001a\u00020\u0015H&¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/rfusion/widget/titlebar/RFTitleBar;", "", "getTitle", "", "setFitSystemWindow", "", "fitable", "", "setLeftIcon", "icon", "", "listener", "Landroid/view/View$OnClickListener;", "setOnCloseListener", "setRightButton", "attrs", "", "Lcom/didi/rfusion/widget/titlebar/RFMenuAttr;", "([Lcom/didi/rfusion/widget/titlebar/RFMenuAttr;)V", "setTextColor", "color", "", "setTitle", "text", "strRes", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFTitleBar.kt */
public interface RFTitleBar {
    CharSequence getTitle();

    void setFitSystemWindow(boolean z);

    void setLeftIcon(String str, View.OnClickListener onClickListener);

    void setOnCloseListener(View.OnClickListener onClickListener);

    void setRightButton(RFMenuAttr... rFMenuAttrArr);

    void setTextColor(int i);

    void setTitle(int i);

    void setTitle(CharSequence charSequence);

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 16})
    /* compiled from: RFTitleBar.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void setLeftIcon$default(RFTitleBar rFTitleBar, String str, View.OnClickListener onClickListener, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    onClickListener = null;
                }
                rFTitleBar.setLeftIcon(str, onClickListener);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setLeftIcon");
        }
    }
}
