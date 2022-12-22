package com.didi.component.common.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.model.NewGuidDialogModel;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOImgModel;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGOBaseDrawerModel;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;

public class NewUIBottomGuidePop {

    /* renamed from: a */
    private LEGOBaseDrawerModel f11573a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public LEGODrawer f11574b;

    /* renamed from: c */
    private Context f11575c;

    /* access modifiers changed from: protected */
    public int getLayoutItemId() {
        return R.layout.global_common_new_guide_dialog_item;
    }

    public NewUIBottomGuidePop(Context context, NewGuidDialogModel newGuidDialogModel) {
        String str;
        String str2;
        if (newGuidDialogModel != null) {
            this.f11575c = context;
            LinearLayout linearLayout = new LinearLayout(this.f11575c);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = UiUtils.dip2px(this.f11575c, 30.0f);
            layoutParams.leftMargin = UiUtils.dip2px(this.f11575c, 30.0f);
            layoutParams.rightMargin = UiUtils.dip2px(this.f11575c, 30.0f);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOrientation(1);
            if (!TextUtils.isEmpty(newGuidDialogModel.title)) {
                str = newGuidDialogModel.title;
            } else {
                str = ResourcesHelper.getString(this.f11575c, R.string.global_new_guide_ok);
            }
            if (newGuidDialogModel.textArray != null && !newGuidDialogModel.textArray.isEmpty()) {
                linearLayout.removeAllViews();
                linearLayout.addView(m7845b(str));
                for (String a : newGuidDialogModel.textArray) {
                    linearLayout.addView(m7843a(a));
                }
            }
            LEGOImgModel lEGOImgModel = new LEGOImgModel();
            lEGOImgModel.setImgUrl(newGuidDialogModel.imgUrl).setImgPlaceHolder(R.drawable.global_comp_new_guide_bg_default);
            if (!TextUtils.isEmpty(newGuidDialogModel.btText)) {
                str2 = newGuidDialogModel.btText;
            } else {
                str2 = ResourcesHelper.getString(this.f11575c, R.string.global_new_guide_ok);
            }
            LEGOBaseDrawerModel imgModel = new LEGODrawerModel1(str, new LEGOBtnTextAndCallback(str2, new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    NewUIBottomGuidePop.this.f11574b.dismiss();
                }
            })).setIsShowCloseImg(false).setExtendedView(linearLayout).setClickOutsideCanCancel(false).setImgModel(lEGOImgModel);
            this.f11573a = imgModel;
            this.f11574b = LEGOUICreator.showDrawerTemplate(this.f11575c, imgModel);
        }
    }

    /* renamed from: a */
    private View m7843a(String str) {
        View inflate = LayoutInflater.from(this.f11575c).inflate(getLayoutItemId(), (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.global_commone_new_guide_item_tv)).setText(str);
        return inflate;
    }

    /* renamed from: b */
    private View m7845b(String str) {
        View inflate = LayoutInflater.from(this.f11575c).inflate(R.layout.global_common_new_guide_title, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.pop_guide_tv)).setText(str);
        return inflate;
    }

    public void show(boolean z) {
        if (!this.f11574b.isShowing()) {
            this.f11574b.show();
            if (z) {
                GlobalSPUtil.setShownTaxisDispatchFeeDialogByUser(this.f11575c);
            }
        }
    }
}
