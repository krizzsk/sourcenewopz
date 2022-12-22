package com.didi.dimina.container.p106ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bridge.permission.PermissionDescInfo;
import com.taxis99.R;
import java.io.File;

/* renamed from: com.didi.dimina.container.ui.dialog.BottomDialog */
public class BottomDialog extends Dialog {

    /* renamed from: a */
    private final PermissionDescInfo f17553a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public BottomDialogClickListener f17554b;

    /* renamed from: com.didi.dimina.container.ui.dialog.BottomDialog$BottomDialogClickListener */
    public interface BottomDialogClickListener {
        void onNegativeBtnClick();

        void onPositiveBtnClick();
    }

    public BottomDialog(Context context, PermissionDescInfo permissionDescInfo) {
        super(context, R.style.ThemeHalfTransparentDialog);
        this.f17553a = permissionDescInfo;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dimina_bottom_sheet_authorize);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        findViewById(R.id.dialog_cancel_btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BottomDialog.this.dismiss();
                if (BottomDialog.this.f17554b != null) {
                    BottomDialog.this.f17554b.onNegativeBtnClick();
                }
            }
        });
        findViewById(R.id.dialog_confirm_btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BottomDialog.this.dismiss();
                if (BottomDialog.this.f17554b != null) {
                    BottomDialog.this.f17554b.onPositiveBtnClick();
                }
            }
        });
        if (this.f17553a != null) {
            ((TextView) findViewById(R.id.dialog_title)).setText(this.f17553a.getTitle());
            ((TextView) findViewById(R.id.dialog_subTitle)).setText(this.f17553a.getSubTitle());
            ((TextView) findViewById(R.id.dialog_desc)).setText(this.f17553a.getContent());
            ImageView imageView = (ImageView) findViewById(R.id.dialog_icon);
            if (!TextUtils.isEmpty(this.f17553a.getIcon())) {
                Dimina.getConfig().getAdapterConfig().getImageLoaderService().loadCircleInto(getContext(), new File(this.f17553a.getIcon()), imageView);
                imageView.setVisibility(0);
                return;
            }
            imageView.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        Window window = getWindow();
        window.setGravity(80);
        window.setLayout(-1, -2);
    }

    public void setBottomDialogClickListener(BottomDialogClickListener bottomDialogClickListener) {
        this.f17554b = bottomDialogClickListener;
    }
}
