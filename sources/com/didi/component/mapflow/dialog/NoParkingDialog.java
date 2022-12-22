package com.didi.component.mapflow.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.dialog.AlertDialogBase;
import com.taxis99.R;

public class NoParkingDialog extends AlertDialogBase {

    /* renamed from: a */
    private View f14199a;

    /* renamed from: b */
    private TextView f14200b;

    /* renamed from: c */
    private TextView f14201c;

    /* renamed from: d */
    private CustomLottieAnimationView f14202d;

    /* access modifiers changed from: protected */
    public View getRootView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return this.f14199a;
    }

    public void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.global_noparking_dialog, (ViewGroup) null);
        this.f14199a = inflate;
        this.f14200b = (TextView) inflate.findViewById(R.id.tv_global_noparking_content);
        this.f14201c = (TextView) this.f14199a.findViewById(R.id.tv_global_noparking_confirm);
        CustomLottieAnimationView customLottieAnimationView = (CustomLottieAnimationView) this.f14199a.findViewById(R.id.global_noparking_image);
        this.f14202d = customLottieAnimationView;
        customLottieAnimationView.setImageAssetsFolder("images");
        this.f14202d.setAnimation("no_park_dialog.json");
        this.f14201c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                NoParkingDialog.this.dismiss();
            }
        });
    }
}
