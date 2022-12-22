package com.didi.beatles.p099im.views;

import android.app.Activity;
import android.app.Dialog;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.IMAudioDialog */
public class IMAudioDialog {

    /* renamed from: a */
    private ImageView f9841a;

    /* renamed from: b */
    private TextView f9842b;

    /* renamed from: c */
    private TextView f9843c;

    /* renamed from: d */
    private Activity f9844d;

    /* renamed from: e */
    private boolean f9845e;
    public Dialog mDialog;

    public IMAudioDialog(Activity activity) {
        try {
            m6668a(activity);
        } catch (Exception e) {
            Log.d("IMAudioDialog", "constructor", e);
        }
    }

    public void changeBackGroundBySound(int i) {
        try {
            m6667a(i);
        } catch (Exception e) {
            Log.d("IMAudioDialog", "changeBackGroundBySound", e);
        }
    }

    public void showResidueTime(String str) {
        try {
            m6669a(str);
        } catch (Exception e) {
            Log.d("IMAudioDialog", "showResidueTime", e);
        }
    }

    /* renamed from: a */
    private void m6668a(Activity activity) {
        this.f9844d = activity;
        Dialog dialog = new Dialog(activity, R.style.bts_SoundVolumeStyle);
        this.mDialog = dialog;
        dialog.requestWindowFeature(1);
        if (this.mDialog.getWindow() != null) {
            this.mDialog.getWindow().setFlags(1024, 1024);
        }
        this.mDialog.setContentView(R.layout.bts_im_sound_volume_dialog);
        this.mDialog.setCanceledOnTouchOutside(false);
        this.f9841a = (ImageView) this.mDialog.findViewById(R.id.tips_icon);
        this.f9842b = (TextView) this.mDialog.findViewById(R.id.tips_msg);
        this.f9843c = (TextView) this.mDialog.findViewById(R.id.tips_time);
        this.f9841a.setVisibility(0);
        this.f9843c.setVisibility(8);
    }

    public boolean show() {
        Dialog dialog = this.mDialog;
        if (dialog == null || dialog.isShowing()) {
            return false;
        }
        this.f9841a.setVisibility(0);
        this.f9843c.setVisibility(8);
        SystemUtils.showDialog(this.mDialog);
        return true;
    }

    public void dissMissAudioDialog() {
        try {
            if (this.mDialog != null) {
                this.mDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m6669a(String str) {
        ImageView imageView = this.f9841a;
        if (imageView != null && imageView.isShown()) {
            this.f9841a.setVisibility(4);
        }
        TextView textView = this.f9843c;
        if (textView != null) {
            if (!textView.isShown()) {
                this.f9843c.setVisibility(0);
            }
            this.f9843c.setText(str);
        }
    }

    public boolean isShowing() {
        Dialog dialog = this.mDialog;
        return dialog != null && dialog.isShowing();
    }

    public void setTip(boolean z) {
        if (this.mDialog != null) {
            this.f9845e = z;
            if (z) {
                this.f9841a.setImageResource(IMResource.getDrawableID(R.drawable.im_toast_garbage_bin));
                this.f9842b.setText(IMContextInfoHelper.getContext().getString(R.string.bts_im_record_dialog_tip_cancel_filp));
                this.f9842b.setTextColor(IMResource.getColor(R.color.im_color_text_gray));
                return;
            }
            this.f9841a.setImageResource(IMResource.getDrawableID(R.drawable.im_record_2));
            this.f9842b.setText(IMContextInfoHelper.getContext().getString(R.string.bts_im_record_dialog_tip_cancel));
            this.f9842b.setTextColor(IMResource.getColor(R.color.im_color_text_gray));
        }
    }

    /* renamed from: a */
    private void m6667a(int i) {
        if (!this.f9845e) {
            switch (i - 1) {
                case 0:
                case 1:
                    this.f9841a.setImageResource(IMResource.getDrawableID(R.drawable.im_record_1));
                    return;
                case 2:
                case 3:
                    this.f9841a.setImageResource(IMResource.getDrawableID(R.drawable.im_record_2));
                    return;
                case 4:
                case 5:
                    this.f9841a.setImageResource(IMResource.getDrawableID(R.drawable.im_record_3));
                    return;
                case 6:
                    this.f9841a.setImageResource(IMResource.getDrawableID(R.drawable.im_record_4));
                    return;
                default:
                    return;
            }
        }
    }

    public TextView getTvVoiceRecordTip() {
        return this.f9842b;
    }
}
