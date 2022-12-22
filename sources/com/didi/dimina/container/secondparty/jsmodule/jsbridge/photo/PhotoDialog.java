package com.didi.dimina.container.secondparty.jsmodule.jsbridge.photo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class PhotoDialog implements View.OnClickListener {

    /* renamed from: a */
    private final Dialog f17235a;

    /* renamed from: b */
    private final View f17236b;

    /* renamed from: c */
    private final View f17237c;

    /* renamed from: d */
    private final TextView f17238d;

    /* renamed from: e */
    private SingleCallback<Void> f17239e;

    /* renamed from: f */
    private SingleCallback<Void> f17240f;

    /* renamed from: g */
    private SingleCallback<Void> f17241g;

    PhotoDialog(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.dimina_photo_select_type, (ViewGroup) null);
        this.f17236b = inflate.findViewById(R.id.take_capture);
        this.f17237c = inflate.findViewById(R.id.take_pick);
        this.f17238d = (TextView) inflate.findViewById(R.id.take_cancel);
        this.f17236b.setOnClickListener(this);
        this.f17237c.setOnClickListener(this);
        this.f17238d.setOnClickListener(this);
        this.f17235a = new AlertDialog.Builder(context, R.style.DiminaPhotoDialog).setCancelable(false).setView(inflate).create();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55749a(int i) {
        TextView textView = this.f17238d;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55748a() {
        Dialog dialog = this.f17235a;
        if (dialog != null) {
            SystemUtils.showDialog(dialog);
            if (this.f17235a.getWindow() != null) {
                Window window = this.f17235a.getWindow();
                window.getDecorView().setPadding(0, 0, 0, 0);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.height = -2;
                attributes.width = -1;
                attributes.gravity = 81;
                window.setAttributes(attributes);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55750a(SingleCallback<Void> singleCallback) {
        this.f17239e = singleCallback;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo55751b(SingleCallback<Void> singleCallback) {
        this.f17240f = singleCallback;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo55752c(SingleCallback<Void> singleCallback) {
        this.f17241g = singleCallback;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view == this.f17238d) {
            this.f17235a.dismiss();
            SingleCallback<Void> singleCallback = this.f17241g;
            if (singleCallback != null) {
                singleCallback.onCallback(null);
            }
        } else if (view == this.f17237c) {
            this.f17235a.dismiss();
            SingleCallback<Void> singleCallback2 = this.f17239e;
            if (singleCallback2 != null) {
                singleCallback2.onCallback(null);
            }
        } else if (view == this.f17236b) {
            this.f17235a.dismiss();
            SingleCallback<Void> singleCallback3 = this.f17240f;
            if (singleCallback3 != null) {
                singleCallback3.onCallback(null);
            }
        }
    }
}
