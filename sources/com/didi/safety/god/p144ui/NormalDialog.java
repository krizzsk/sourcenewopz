package com.didi.safety.god.p144ui;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

/* renamed from: com.didi.safety.god.ui.NormalDialog */
public class NormalDialog extends DialogFragment implements DialogInterface.OnKeyListener, View.OnClickListener {

    /* renamed from: a */
    private TextView f34783a;

    /* renamed from: b */
    private TextView f34784b;

    /* renamed from: c */
    private TextView f34785c;

    /* renamed from: d */
    private TextView f34786d;

    /* renamed from: e */
    private View f34787e;

    /* renamed from: f */
    private View.OnClickListener f34788f;

    /* renamed from: g */
    private String f34789g;

    /* renamed from: h */
    private String f34790h;

    /* renamed from: i */
    private String f34791i;

    /* renamed from: j */
    private String f34792j;

    /* renamed from: k */
    private View f34793k;

    /* renamed from: l */
    private boolean f34794l;

    /* renamed from: m */
    private int f34795m;

    /* renamed from: n */
    private float f34796n;

    /* renamed from: o */
    private float f34797o;

    /* renamed from: p */
    private int f34798p;

    /* renamed from: q */
    private int f34799q;

    /* renamed from: r */
    private int f34800r;

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 4;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        getDialog().requestWindowFeature(1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        int i = this.f34798p;
        if (i != 0) {
            view = layoutInflater.inflate(i, viewGroup);
        } else {
            view = layoutInflater.inflate(R.layout.safety_god_dialog, viewGroup);
        }
        this.f34783a = (TextView) view.findViewById(R.id.title);
        this.f34784b = (TextView) view.findViewById(R.id.content);
        this.f34785c = (TextView) view.findViewById(R.id.cancel);
        this.f34786d = (TextView) view.findViewById(R.id.confirm);
        this.f34787e = view.findViewById(R.id.cancel_divider);
        this.f34793k = view.findViewById(R.id.bottom_layout);
        this.f34785c.setOnClickListener(this);
        this.f34786d.setOnClickListener(this);
        String str = this.f34789g;
        if (str != null) {
            this.f34783a.setText(str);
        } else {
            this.f34783a.setVisibility(8);
        }
        String str2 = this.f34790h;
        if (str2 != null) {
            this.f34784b.setText(str2);
        }
        float f = this.f34797o;
        if (f != 0.0f) {
            this.f34784b.setTextSize(0, f);
        }
        if (this.f34791i == null && this.f34792j == null) {
            this.f34793k.setVisibility(8);
        } else {
            String str3 = this.f34791i;
            if (str3 != null) {
                this.f34786d.setText(str3);
                int i2 = this.f34800r;
                if (i2 != 0) {
                    this.f34786d.setTextColor(i2);
                }
            } else {
                this.f34786d.setVisibility(8);
            }
            String str4 = this.f34792j;
            if (str4 != null) {
                this.f34785c.setText(str4);
                int i3 = this.f34799q;
                if (i3 != 0) {
                    this.f34785c.setTextColor(i3);
                }
            } else {
                this.f34785c.setVisibility(8);
                this.f34787e.setVisibility(8);
            }
        }
        getDialog().setCancelable(false);
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().setOnKeyListener(this);
        return view;
    }

    public void setInfo(String str, String str2, String str3, String str4) {
        this.f34789g = str;
        this.f34790h = str2;
        this.f34791i = str3;
        this.f34792j = str4;
    }

    public void setConfirmTextColor(int i) {
        this.f34800r = i;
    }

    public void onResume() {
        Window window;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.safety_god_dialog_width);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.safety_god_dialog_height);
        int i = this.f34795m;
        if (i != 0) {
            dimensionPixelSize2 = i;
        }
        float f = this.f34796n;
        if (f != 0.0f) {
            dimensionPixelSize = (int) (((float) dimensionPixelSize) * f);
        }
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setLayout(dimensionPixelSize, dimensionPixelSize2);
        }
        super.onResume();
    }

    public void onStart() {
        super.onStart();
        if (this.f34794l) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
            attributes.width = displayMetrics.widthPixels;
            attributes.height = displayMetrics.heightPixels;
            attributes.gravity = 80;
            getDialog().getWindow().setAttributes(attributes);
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        View.OnClickListener onClickListener = this.f34788f;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f34788f = onClickListener;
    }

    public void show(Activity activity, String str) {
        try {
            setConfirmTextColor(activity.getResources().getColor(R.color.safety_god_confirm_color));
            FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
