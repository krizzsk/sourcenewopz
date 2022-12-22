package com.didichuxing.omega.sdk.feedback.wheelUi;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.didichuxing.omega.sdk.feedback.wheelUi.Wheel;
import com.taxis99.R;
import java.util.List;

public class SimplePickerPopDialog extends DialogFragment {
    private final View.OnClickListener mCancelListener = new View.OnClickListener() {
        public void onClick(View view) {
            SimplePickerPopDialog.this.dismiss();
        }
    };
    private final View.OnClickListener mConfirmListener = new View.OnClickListener() {
        public void onClick(View view) {
            SimplePickerPopDialog.this.dismiss();
            if (SimplePickerPopDialog.this.mOnItemSelectListener != null) {
                SimplePickerPopDialog.this.mOnItemSelectListener.onConfirmed(SimplePickerPopDialog.this.mPicker.getSelectedIndex());
            }
        }
    };
    private List<String> mData;
    /* access modifiers changed from: private */
    public OnItemSelectListener mOnItemSelectListener;
    /* access modifiers changed from: private */
    public Wheel mPicker;
    private String mTitleMsg;

    public interface OnChildItemSelectListener extends OnItemSelectListener {
        void onItemSelected(View view, int i);
    }

    public interface OnItemSelectListener {
        void onConfirmed(int i);
    }

    public static SimplePickerPopDialog newInstance(List<String> list, OnItemSelectListener onItemSelectListener) {
        return newInstance(list, "", onItemSelectListener);
    }

    private static SimplePickerPopDialog newInstance(List<String> list, String str, OnItemSelectListener onItemSelectListener) {
        SimplePickerPopDialog simplePickerPopDialog = new SimplePickerPopDialog();
        simplePickerPopDialog.mData = list;
        simplePickerPopDialog.mOnItemSelectListener = onItemSelectListener;
        simplePickerPopDialog.mTitleMsg = str;
        return simplePickerPopDialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Dialog dialog = getDialog();
        if (dialog == null) {
            return null;
        }
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        View inflate = layoutInflater.inflate(R.layout.af_simple_picker_pop, (ViewGroup) null);
        init(inflate);
        setKeyEventListener();
        return inflate;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.afanty_PopDialog);
    }

    private void init(View view) {
        this.mPicker = (Wheel) view.findViewById(R.id.simple_picker);
        ((TextView) view.findViewById(R.id.yes)).setOnClickListener(this.mConfirmListener);
        ((TextView) view.findViewById(R.id.cancel)).setOnClickListener(this.mCancelListener);
        this.mPicker.setData(this.mData);
        this.mPicker.setOnItemSelectedListener(new Wheel.OnItemChangedListener() {
            public void onItemChanged(int i) {
                if (SimplePickerPopDialog.this.mOnItemSelectListener != null && (SimplePickerPopDialog.this.mOnItemSelectListener instanceof OnChildItemSelectListener)) {
                    ((OnChildItemSelectListener) SimplePickerPopDialog.this.mOnItemSelectListener).onItemSelected(SimplePickerPopDialog.this.mPicker, i);
                }
            }
        });
        ((TextView) view.findViewById(R.id.title)).setText(this.mTitleMsg);
    }

    private void setKeyEventListener() {
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4;
            }
        });
    }
}
