package com.didi.soda.customer.widget.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class CustomerVerticalDialog extends Dialog {

    /* renamed from: a */
    private FrameLayout f41761a;

    /* renamed from: b */
    private LinearLayout f41762b;

    /* renamed from: c */
    private TextView f41763c;

    /* renamed from: d */
    private TextView f41764d;

    /* renamed from: e */
    private ImageView f41765e;

    /* renamed from: f */
    private String f41766f;

    /* renamed from: g */
    private String f41767g;

    /* renamed from: h */
    private int f41768h;

    /* renamed from: i */
    private View f41769i;

    /* renamed from: j */
    private LifecycleListener f41770j;

    /* renamed from: k */
    private List<Action> f41771k = new ArrayList();

    /* renamed from: l */
    private boolean f41772l = false;

    public interface LifecycleListener {
        void onDismiss(CustomerVerticalDialog customerVerticalDialog);

        void onShow(CustomerVerticalDialog customerVerticalDialog);
    }

    public TransformAnimation getEnterAnimation() {
        return null;
    }

    public TransformAnimation getExitAnimation() {
        return null;
    }

    public void onDestroy() {
    }

    public View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f41772l = true;
        View inflate = layoutInflater.inflate(R.layout.customer_dialog_vertical, viewGroup, false);
        m29495a(inflate);
        return inflate;
    }

    public void onShow() {
        LifecycleListener lifecycleListener = this.f41770j;
        if (lifecycleListener != null) {
            lifecycleListener.onShow(this);
        }
    }

    public void onDismiss() {
        LifecycleListener lifecycleListener = this.f41770j;
        if (lifecycleListener != null) {
            lifecycleListener.onDismiss(this);
        }
    }

    public void setTitle(String str) {
        this.f41766f = str;
        if (this.f41772l) {
            this.f41763c.setText(str);
        }
    }

    public void setMessage(String str) {
        this.f41767g = str;
        if (this.f41772l) {
            this.f41764d.setText(str);
        }
    }

    public void setIcon(int i) {
        this.f41768h = i;
        if (this.f41772l) {
            this.f41765e.setImageResource(i);
        }
    }

    public void setContentView(View view) {
        this.f41769i = view;
        if (this.f41772l) {
            this.f41761a.addView(view);
        }
    }

    public void setLifecycleListener(LifecycleListener lifecycleListener) {
        this.f41770j = lifecycleListener;
    }

    public void addAction(String str) {
        addAction(str, (View.OnClickListener) null);
    }

    public void addAction(String str, View.OnClickListener onClickListener) {
        addAction(str, onClickListener, true);
    }

    public void addAction(String str, final View.OnClickListener onClickListener, final boolean z) {
        boolean z2;
        int i = 0;
        if (this.f41771k.isEmpty()) {
            i = SkinUtil.getDialogMainActionTextColor();
            z2 = true;
        } else {
            z2 = false;
        }
        Action action = new Action(new View.OnClickListener() {
            public void onClick(View view) {
                if (onClickListener == null || z) {
                    CustomerVerticalDialog.this.dismiss();
                }
                View.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }, str, i);
        boolean unused = action.bold = z2;
        this.f41771k.add(action);
        if (this.f41772l) {
            m29496a(action);
        }
    }

    /* renamed from: a */
    private void m29495a(View view) {
        this.f41763c = (TextView) view.findViewById(R.id.tv_vertical_dialog_title);
        this.f41764d = (TextView) view.findViewById(R.id.tv_vertical_dialog_message);
        this.f41765e = (ImageView) view.findViewById(R.id.iv_vertical_dialog_icon);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.ll_dialog_content);
        this.f41761a = frameLayout;
        View view2 = this.f41769i;
        if (view2 != null) {
            frameLayout.addView(view2);
        } else {
            if (this.f41767g != null) {
                this.f41764d.setVisibility(0);
                this.f41764d.setText(this.f41767g);
            }
            if (this.f41766f != null) {
                this.f41763c.setVisibility(0);
                this.f41763c.setText(this.f41766f);
            }
            if (this.f41768h > 0) {
                this.f41765e.setVisibility(0);
                this.f41765e.setImageResource(this.f41768h);
            }
        }
        this.f41762b = (LinearLayout) view.findViewById(R.id.ll_action_container);
        if (this.f41771k.size() > 0) {
            for (Action a : this.f41771k) {
                m29496a(a);
            }
        }
    }

    /* renamed from: a */
    private void m29496a(Action action) {
        Context context = this.f41762b.getContext();
        ActionLayout actionLayout = new ActionLayout(context, action);
        actionLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, DisplayUtils.dip2px(context, 50.0f)));
        this.f41762b.addView(m29494a(context));
        this.f41762b.addView(actionLayout);
    }

    /* renamed from: a */
    private View m29494a(Context context) {
        View view = new View(context);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, DisplayUtils.dip2px(context, 0.5f)));
        view.setBackgroundResource(R.color.rf_color_gery_5_90_E5E5E5);
        return view;
    }

    private static class ActionLayout extends LinearLayout {
        public ActionLayout(Context context, Action action) {
            super(context);
            init(action);
            setGravity(17);
        }

        private void init(Action action) {
            LayoutInflater.from(getContext()).inflate(R.layout.customer_dialog_action_item, this);
            TextView textView = (TextView) findViewById(R.id.tv_action);
            if (!TextUtils.isEmpty(action.text)) {
                textView.setText(action.text);
            }
            if (action.color != 0) {
                textView.setTextColor(action.color);
            }
            if (action.bold) {
                ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(textView, IToolsService.FontType.BOLD);
            }
            setOnClickListener(action.onClickListener);
        }
    }

    private static class Action {
        /* access modifiers changed from: private */
        public boolean bold;
        /* access modifiers changed from: private */
        public int color;
        /* access modifiers changed from: private */
        public View.OnClickListener onClickListener;
        /* access modifiers changed from: private */
        public String text;

        public Action(View.OnClickListener onClickListener2, String str, int i) {
            this.onClickListener = onClickListener2;
            this.text = str;
            this.color = i;
        }
    }
}
