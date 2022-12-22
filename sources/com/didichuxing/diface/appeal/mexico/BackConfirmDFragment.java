package com.didichuxing.diface.appeal.mexico;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.diface.utils.DisplayUtils;
import com.taxis99.R;

public class BackConfirmDFragment extends DialogFragment {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C15390a f47062a;

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.DfGlobalDialogStyle).create();
        try {
            SystemUtils.showDialog(create);
            create.setCanceledOnTouchOutside(false);
            Window window = create.getWindow();
            window.getDecorView().setPadding(0, 0, 0, 0);
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = DisplayUtils.getScreenWidth(getContext());
            attributes.height = -2;
            window.setAttributes(attributes);
            View inflate = getActivity().getLayoutInflater().inflate(R.layout.fragment_df_back_confirm_layout, (ViewGroup) null);
            window.setContentView(inflate);
            inflate.findViewById(R.id.confirm_btn).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    BackConfirmDFragment.this.dismiss();
                    if (BackConfirmDFragment.this.f47062a != null) {
                        BackConfirmDFragment.this.f47062a.onConfirmed();
                    }
                }
            });
            inflate.findViewById(R.id.cancel_btn).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    BackConfirmDFragment.this.dismiss();
                    if (BackConfirmDFragment.this.f47062a != null) {
                        BackConfirmDFragment.this.f47062a.onCanceled();
                    }
                }
            });
            create.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return create;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() instanceof C15390a) {
            this.f47062a = (C15390a) getActivity();
        }
    }
}
