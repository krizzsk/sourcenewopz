package com.didi.dimina.container.bridge.sheet;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public abstract class SheetCommonDialog implements View.OnClickListener, ISheetCommonDialog {

    /* renamed from: a */
    private Dialog f16764a;

    /* renamed from: b */
    private TextView f16765b;

    /* renamed from: c */
    private TextView f16766c;

    /* renamed from: d */
    private TextView f16767d;

    /* renamed from: e */
    private ISheetDialogItemClick f16768e;

    public SheetCommonDialog(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.dimina_bottom_sheet_common, (ViewGroup) null);
        this.f16766c = (TextView) inflate.findViewById(R.id.dimina_bottom_sheet_item_one);
        if (!TextUtils.isEmpty(getItemOneText())) {
            this.f16766c.setText(getItemOneText());
        }
        this.f16765b = (TextView) inflate.findViewById(R.id.dimina_bottom_sheet_item_two);
        if (!TextUtils.isEmpty(getItemTwoText())) {
            this.f16765b.setText(getItemTwoText());
        }
        this.f16767d = (TextView) inflate.findViewById(R.id.dimina_bottom_sheet_item_cancel);
        this.f16765b.setOnClickListener(this);
        this.f16766c.setOnClickListener(this);
        this.f16767d.setOnClickListener(this);
        this.f16764a = new AlertDialog.Builder(context, R.style.DiminaPhotoDialog).setCancelable(false).setView(inflate).create();
    }

    public void show() {
        Dialog dialog = this.f16764a;
        if (dialog != null && !dialog.isShowing()) {
            SystemUtils.showDialog(this.f16764a);
            if (this.f16764a.getWindow() != null) {
                Window window = this.f16764a.getWindow();
                window.getDecorView().setPadding(0, 0, 0, 0);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.height = -2;
                attributes.width = -1;
                attributes.gravity = 81;
                window.setAttributes(attributes);
            }
        }
    }

    public void setBottomDialogItemClick(ISheetDialogItemClick iSheetDialogItemClick) {
        this.f16768e = iSheetDialogItemClick;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view == this.f16767d) {
            this.f16764a.dismiss();
            ISheetDialogItemClick iSheetDialogItemClick = this.f16768e;
            if (iSheetDialogItemClick != null) {
                iSheetDialogItemClick.onCancel();
            }
        } else if (view == this.f16766c) {
            this.f16764a.dismiss();
            ISheetDialogItemClick iSheetDialogItemClick2 = this.f16768e;
            if (iSheetDialogItemClick2 != null) {
                iSheetDialogItemClick2.onClickItemOne();
            }
        } else if (view == this.f16765b) {
            this.f16764a.dismiss();
            ISheetDialogItemClick iSheetDialogItemClick3 = this.f16768e;
            if (iSheetDialogItemClick3 != null) {
                iSheetDialogItemClick3.onClickItemTwo();
            }
        }
    }
}
