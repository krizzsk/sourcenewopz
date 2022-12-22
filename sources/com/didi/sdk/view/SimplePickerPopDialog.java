package com.didi.sdk.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.wheel.Wheel;
import com.taxis99.R;
import java.util.List;

public class SimplePickerPopDialog extends BaseDialogFragment {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f37865a;

    /* renamed from: b */
    private TextView f37866b;

    /* renamed from: c */
    private TextView f37867c;

    /* renamed from: d */
    private TextView f37868d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Wheel f37869e;

    /* renamed from: f */
    private List<String> f37870f;

    /* renamed from: g */
    private String f37871g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public OnItemSelectListener f37872h;

    /* renamed from: i */
    private int f37873i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public onViewShowListener f37874j;

    /* renamed from: k */
    private View.OnClickListener f37875k = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            SimplePickerPopDialog.this.dismiss();
            if (SimplePickerPopDialog.this.f37872h != null) {
                SimplePickerPopDialog.this.f37872h.onConfirmed(SimplePickerPopDialog.this.f37869e.getSelectedIndex());
            }
        }
    };

    /* renamed from: l */
    private View.OnClickListener f37876l = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            SimplePickerPopDialog.this.dismiss();
            if (SimplePickerPopDialog.this.f37872h != null) {
                SimplePickerPopDialog.this.f37872h.onCanceled();
            }
        }
    };

    public interface OnChildItemSelectListener extends OnItemSelectListener {
        void onItemSelected(View view, int i);
    }

    public interface OnItemSelectListener {
        void onCanceled();

        void onConfirmed(int i);

        void onItemSelected(int i);
    }

    public interface onViewShowListener {
        void showComplete(View view);
    }

    public static SimplePickerPopDialog newInstance(List<String> list, OnItemSelectListener onItemSelectListener) {
        return newInstance(list, "", onItemSelectListener);
    }

    public static SimplePickerPopDialog newInstance(List<String> list, String str, OnItemSelectListener onItemSelectListener) {
        SimplePickerPopDialog simplePickerPopDialog = new SimplePickerPopDialog();
        simplePickerPopDialog.f37870f = list;
        simplePickerPopDialog.f37872h = onItemSelectListener;
        simplePickerPopDialog.f37871g = str;
        return simplePickerPopDialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Dialog dialog = getDialog();
        if (dialog == null) {
            return null;
        }
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        View inflate = layoutInflater.inflate(R.layout.simple_picker_pop, (ViewGroup) null);
        m26808a(inflate);
        m26807a();
        return inflate;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.PopDialog);
    }

    public Wheel getPicker() {
        return this.f37869e;
    }

    public void setSelectedIndex(int i) {
        this.f37873i = i;
        Wheel wheel = this.f37869e;
        if (wheel != null) {
            wheel.setSelectedIndex(i);
        }
    }

    /* renamed from: a */
    private void m26808a(View view) {
        this.f37866b = (TextView) view.findViewById(R.id.yes);
        this.f37867c = (TextView) view.findViewById(R.id.cancel);
        this.f37868d = (TextView) view.findViewById(R.id.title);
        this.f37869e = (Wheel) view.findViewById(R.id.simple_picker);
        this.f37866b.setOnClickListener(this.f37875k);
        this.f37867c.setOnClickListener(this.f37876l);
        this.f37869e.setData(this.f37870f);
        this.f37869e.setOnItemSelectedListener(new Wheel.OnItemChangedListener() {
            public void onItemChanged(int i) {
                if (SimplePickerPopDialog.this.f37872h == null) {
                    return;
                }
                if (SimplePickerPopDialog.this.f37872h instanceof OnChildItemSelectListener) {
                    ((OnChildItemSelectListener) SimplePickerPopDialog.this.f37872h).onItemSelected(SimplePickerPopDialog.this.f37869e, i);
                } else if (SimplePickerPopDialog.this.f37872h instanceof OnChildItemSelectListener) {
                    SimplePickerPopDialog.this.f37872h.onItemSelected(i);
                }
            }
        });
        this.f37868d.setText(this.f37871g);
        this.f37869e.setSelectedIndex(this.f37873i);
        this.f37869e.post(new Runnable() {
            public void run() {
                if (SimplePickerPopDialog.this.f37874j != null) {
                    SimplePickerPopDialog.this.f37874j.showComplete(SimplePickerPopDialog.this.f37869e);
                }
            }
        });
    }

    /* renamed from: a */
    private void m26807a() {
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4) {
                    return false;
                }
                if (!SimplePickerPopDialog.this.f37865a) {
                    return true;
                }
                SimplePickerPopDialog.this.dismiss();
                return true;
            }
        });
    }

    public void setCanCancel(boolean z) {
        this.f37865a = z;
    }

    public void setShowCompleteListener(onViewShowListener onviewshowlistener) {
        this.f37874j = onviewshowlistener;
    }
}
