package com.didi.sdk.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import com.didi.sdk.view.BaseDialogFragment;
import com.didi.sdk.view.dialog.FreeDialogParam;

public class FreeDialog extends BaseDialogFragment {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public FreeDialogParam f37966a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public FreeDialogParam.Setting f37967b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, 16973939);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().requestWindowFeature(1);
        return this.f37966a.mo97498b();
    }

    public void onStart() {
        super.onStart();
        this.f37966a.mo97497a();
    }

    public static class Builder {
        private FreeDialogParam.Setting mSetting;

        public Builder(Context context) {
            FreeDialogParam.Setting setting = new FreeDialogParam.Setting();
            this.mSetting = setting;
            setting.mContext = context;
        }

        public Builder setWindow(FreeDialogParam.Window window) {
            this.mSetting.mWindow = window;
            return this;
        }

        public Builder setCustomView(View view) {
            this.mSetting.mCustomContentView = view;
            return this;
        }

        public Builder setBackgroundColor(int i) {
            this.mSetting.mBackgroundColor = i;
            return this;
        }

        public Builder setBackgroundDrawable(Drawable drawable) {
            this.mSetting.mBackgroundDrawable = drawable;
            return this;
        }

        public Builder setCloseVisible(boolean z) {
            this.mSetting.mCloseVisible = z;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.mSetting.mCancelable = z;
            return this;
        }

        public Builder setOnCloseListener(FreeDialogParam.OnCloseListener onCloseListener) {
            this.mSetting.mOnCloseListener = onCloseListener;
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.mSetting.mIcon = drawable;
            return this;
        }

        public Builder setIcon(FreeDialogParam.IconType iconType) {
            this.mSetting.mIconType = iconType;
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.mSetting.mTitle = charSequence;
            return this;
        }

        public Builder setTitleSize(int i) {
            this.mSetting.mTitleSize = i;
            return this;
        }

        public Builder setTitleColor(int i) {
            this.mSetting.mTitleColor = i;
            return this;
        }

        public Builder setTitleMultiLine(int i) {
            this.mSetting.mTitleMultiLine = i;
            return this;
        }

        public Builder setMessage(CharSequence charSequence) {
            this.mSetting.mMessage = charSequence;
            return this;
        }

        public Builder setMessageSize(int i) {
            this.mSetting.mMessageSize = i;
            return this;
        }

        public Builder setMessageGravity(int i) {
            this.mSetting.mMessageGravity = i;
            return this;
        }

        public Builder setMessageColor(int i) {
            this.mSetting.mMessageColor = i;
            return this;
        }

        public Builder setDefaultButtonColor(int i) {
            this.mSetting.mDefaultButtonColor = i;
            return this;
        }

        public Builder addButton(CharSequence charSequence, FreeDialogParam.OnClickListener onClickListener) {
            addButton(charSequence, false, onClickListener);
            return this;
        }

        public Builder addButton(CharSequence charSequence, boolean z, FreeDialogParam.OnClickListener onClickListener) {
            FreeDialogParam.Button.Builder clickListener = new FreeDialogParam.Button.Builder(charSequence).setClickListener(onClickListener);
            if (z) {
                clickListener.setDefault();
            }
            addButton(clickListener.build());
            return this;
        }

        public Builder addButton(FreeDialogParam.Button button) {
            this.mSetting.mButtons.add(button);
            return this;
        }

        public Builder setButtonOrientation(FreeDialogParam.Orientation orientation) {
            this.mSetting.mOrientation = orientation;
            if (orientation == FreeDialogParam.Orientation.VERTICAL) {
                this.mSetting.mDiverContentLineVisible = false;
            }
            return this;
        }

        public FreeDialog build() {
            FreeDialog freeDialog = new FreeDialog();
            FreeDialogParam unused = freeDialog.f37966a = new FreeDialogParam(this.mSetting, freeDialog);
            FreeDialogParam.Setting unused2 = freeDialog.f37967b = this.mSetting;
            return freeDialog;
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.f37967b.mOnCloseListener != null) {
            this.f37967b.mOnCloseListener.onDismiss(this);
        }
    }

    public void show(FragmentManager fragmentManager, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "__didi_FreeDialog";
        }
        super.show(fragmentManager, str);
    }
}
