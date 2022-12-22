package com.didi.component.common.dialog;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.appsflyer.internal.referrer.Payload;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.view.BaseDialogFragment;
import com.taxis99.R;

public class GlobalDialog extends BaseDialogFragment {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public View f11541a;

    /* renamed from: b */
    private TextView f11542b;

    /* renamed from: c */
    private TextView f11543c;

    /* renamed from: d */
    private TextView f11544d;

    /* renamed from: e */
    private TextView f11545e;

    /* renamed from: f */
    private Builder f11546f;

    /* renamed from: g */
    private boolean f11547g;

    public interface IButtonAction {

        public enum ButtonType {
            NEGATIVE,
            POSITIVE
        }

        Runnable getAction();

        String getName();

        ButtonType getType();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, 2132017496);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.global_dialog_layout, viewGroup, false);
        m7828a(inflate);
        return inflate;
    }

    /* renamed from: a */
    private void m7828a(View view) {
        this.f11541a = view.findViewById(R.id.global_dialog_content);
        this.f11542b = (TextView) view.findViewById(R.id.global_dialog_title);
        this.f11543c = (TextView) view.findViewById(R.id.global_dialog_desc);
        this.f11544d = (TextView) view.findViewById(R.id.global_dialog_negative);
        this.f11545e = (TextView) view.findViewById(R.id.global_dialog_positive);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Builder builder = this.f11546f;
        if (builder != null) {
            this.f11542b.setText(builder.title);
            this.f11543c.setVisibility(TextUtils.isEmpty(this.f11546f.message) ? 8 : 0);
            this.f11543c.setText(this.f11546f.message);
            this.f11545e.setVisibility(8);
            this.f11544d.setVisibility(8);
            for (final IButtonAction iButtonAction : this.f11546f.buttonActions) {
                int i = C47595.f11548x7f103bf7[iButtonAction.getType().ordinal()];
                if (i == 1) {
                    this.f11544d.setVisibility(0);
                    this.f11544d.setText(iButtonAction.getName());
                    this.f11544d.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            if (iButtonAction.getAction() != null) {
                                iButtonAction.getAction().run();
                            } else {
                                GlobalDialog.this.dismiss();
                            }
                        }
                    });
                } else if (i == 2) {
                    this.f11545e.setVisibility(0);
                    this.f11545e.setText(iButtonAction.getName());
                    this.f11545e.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            if (iButtonAction.getAction() != null) {
                                iButtonAction.getAction().run();
                            } else {
                                GlobalDialog.this.dismiss();
                            }
                        }
                    });
                }
            }
        }
        this.f11547g = false;
        this.f11541a.post(new Runnable() {
            public void run() {
                int measuredHeight = GlobalDialog.this.f11541a.getMeasuredHeight();
                GlobalDialog.this.f11541a.animate().cancel();
                GlobalDialog.this.f11541a.setTranslationY((float) measuredHeight);
                GlobalDialog.this.f11541a.animate().withStartAction(new Runnable() {
                    public void run() {
                        GlobalDialog.this.f11541a.setVisibility(0);
                    }
                }).translationYBy((float) (-measuredHeight)).setDuration(300).start();
            }
        });
    }

    /* renamed from: com.didi.component.common.dialog.GlobalDialog$5 */
    static /* synthetic */ class C47595 {

        /* renamed from: $SwitchMap$com$didi$component$common$dialog$GlobalDialog$IButtonAction$ButtonType */
        static final /* synthetic */ int[] f11548x7f103bf7;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.component.common.dialog.GlobalDialog$IButtonAction$ButtonType[] r0 = com.didi.component.common.dialog.GlobalDialog.IButtonAction.ButtonType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f11548x7f103bf7 = r0
                com.didi.component.common.dialog.GlobalDialog$IButtonAction$ButtonType r1 = com.didi.component.common.dialog.GlobalDialog.IButtonAction.ButtonType.NEGATIVE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f11548x7f103bf7     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.component.common.dialog.GlobalDialog$IButtonAction$ButtonType r1 = com.didi.component.common.dialog.GlobalDialog.IButtonAction.ButtonType.POSITIVE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.component.common.dialog.GlobalDialog.C47595.<clinit>():void");
        }
    }

    public void dismiss() {
        View view = this.f11541a;
        if (view != null) {
            this.f11547g = true;
            this.f11541a.animate().translationYBy((float) view.getMeasuredHeight()).setDuration(300).withEndAction(new Runnable() {
                public void run() {
                    GlobalDialog.this.f11541a.setVisibility(4);
                    GlobalDialog.super.dismiss();
                }
            }).start();
        }
    }

    public boolean isPendingDismiss() {
        return this.f11547g;
    }

    public Builder build() {
        Builder builder = new Builder();
        this.f11546f = builder;
        return builder;
    }

    public class Builder {
        IButtonAction[] buttonActions;
        String message;
        String title;

        public Builder() {
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder content(String str) {
            this.message = str;
            return this;
        }

        public Builder actions(IButtonAction[] iButtonActionArr) {
            this.buttonActions = iButtonActionArr;
            return this;
        }

        public void show(final FragmentManager fragmentManager, final String str) {
            UiThreadHandler.postDelayed(new Runnable() {
                public void run() {
                    if (fragmentManager != null) {
                        GlobalDialog.this.show(fragmentManager, str);
                    }
                }
            }, 300);
        }
    }

    public static abstract class PositiveButtonAction implements IButtonAction {
        public Runnable getAction() {
            return null;
        }

        public String getName() {
            return Payload.RESPONSE_OK;
        }

        public IButtonAction.ButtonType getType() {
            return IButtonAction.ButtonType.POSITIVE;
        }
    }
}
