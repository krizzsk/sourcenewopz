package com.didi.safetoolkit.widget;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.android.didi.safetoolkit.fragment.BaseDialogFragment;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class SfBaseDialog extends BaseDialogFragment {
    protected DialogBuilder mBuilder;
    protected View mRootView;

    /* access modifiers changed from: protected */
    public int getLayoutRes() {
        return R.layout.sf_common_dialog_layout;
    }

    /* access modifiers changed from: protected */
    public void initData() {
    }

    /* access modifiers changed from: protected */
    public void initObjects() {
    }

    /* access modifiers changed from: protected */
    public void parseBundle(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void setListener() {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.mRootView = onCreateView;
        return onCreateView;
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        if (this.mBuilder.btnLayoutGravity != 0) {
            ((ViewStub) this.mRootView.findViewById(R.id.sf_dialog_btn_container_vertical_stub)).inflate();
        } else {
            ((ViewStub) this.mRootView.findViewById(R.id.sf_dialog_btn_container_horizontal_stub)).inflate();
        }
        if (!TextUtils.isEmpty(this.mBuilder.title)) {
            TextView textView = (TextView) this.mRootView.findViewById(R.id.sf_dialog_title);
            textView.setText(this.mBuilder.title);
            textView.setTypeface(textView.getTypeface(), this.mBuilder.titleTypeface);
            textView.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.mBuilder.content)) {
            TextView textView2 = (TextView) this.mRootView.findViewById(R.id.sf_dialog_intro);
            textView2.setText(this.mBuilder.content);
            textView2.setVisibility(0);
        }
        FrameLayout frameLayout = (FrameLayout) this.mRootView.findViewById(R.id.sf_dialog_content_container);
        if (this.mBuilder.contentLayoutId != 0) {
            LayoutInflater.from(getContext()).inflate(this.mBuilder.contentLayoutId, frameLayout);
        } else {
            frameLayout.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.mBuilder.rightBtnText) || !TextUtils.isEmpty(this.mBuilder.leftBtnText)) {
            TextView textView3 = (TextView) this.mRootView.findViewById(R.id.sf_right_btn);
            if (!TextUtils.isEmpty(this.mBuilder.rightBtnText)) {
                textView3.setText(this.mBuilder.rightBtnText);
                textView3.setTypeface(textView3.getTypeface(), this.mBuilder.rightBtnTypeface);
                textView3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (SfBaseDialog.this.mBuilder.rightBtnClickListener != null) {
                            SfBaseDialog.this.mBuilder.rightBtnClickListener.onClick(view);
                        }
                        SfBaseDialog.this.dismiss();
                    }
                });
                if (this.mBuilder.rightBtnBg != 0) {
                    textView3.setBackgroundResource(this.mBuilder.rightBtnBg);
                }
                if (this.mBuilder.rightBtnTextColor != 0) {
                    textView3.setTextColor(this.mBuilder.rightBtnTextColor);
                }
            } else {
                textView3.setVisibility(8);
            }
            TextView textView4 = (TextView) this.mRootView.findViewById(R.id.sf_left_btn);
            if (!TextUtils.isEmpty(this.mBuilder.leftBtnText)) {
                textView4.setText(this.mBuilder.leftBtnText);
                textView4.setTypeface(textView4.getTypeface(), this.mBuilder.leftBtnTypeface);
                textView4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (SfBaseDialog.this.mBuilder.leftBtnClickListener != null) {
                            SfBaseDialog.this.mBuilder.leftBtnClickListener.onClick(view);
                        }
                        SfBaseDialog.this.dismiss();
                    }
                });
                if (this.mBuilder.leftBtnBg != 0) {
                    textView4.setBackgroundResource(this.mBuilder.leftBtnBg);
                }
                if (this.mBuilder.leftBtnTextColor != 0) {
                    textView4.setTextColor(this.mBuilder.leftBtnTextColor);
                }
            } else {
                textView4.setVisibility(8);
            }
        } else {
            this.mRootView.findViewById(R.id.sf_dialog_btn_container).setVisibility(8);
        }
        setCancelable(this.mBuilder.cancelableWhenTouchOutside);
    }

    public void onStart() {
        super.onStart();
        getDialog().getWindow().setBackgroundDrawableResource(R.drawable.sf_common_dialog_bg);
    }

    public static class DialogBuilder {
        /* access modifiers changed from: private */
        public int btnLayoutGravity;
        /* access modifiers changed from: private */
        public boolean cancelableWhenTouchOutside = true;
        /* access modifiers changed from: private */
        public String content;
        /* access modifiers changed from: private */
        public int contentLayoutId;
        protected Context context;
        protected LayoutInflater inflater;
        /* access modifiers changed from: private */
        public int leftBtnBg;
        /* access modifiers changed from: private */
        public View.OnClickListener leftBtnClickListener;
        /* access modifiers changed from: private */
        public String leftBtnText;
        /* access modifiers changed from: private */
        public int leftBtnTextColor;
        /* access modifiers changed from: private */
        public int leftBtnTypeface;
        /* access modifiers changed from: private */
        public int rightBtnBg;
        /* access modifiers changed from: private */
        public View.OnClickListener rightBtnClickListener;
        /* access modifiers changed from: private */
        public String rightBtnText;
        /* access modifiers changed from: private */
        public int rightBtnTextColor;
        /* access modifiers changed from: private */
        public int rightBtnTypeface;
        /* access modifiers changed from: private */
        public String title;
        /* access modifiers changed from: private */
        public int titleTypeface;

        public DialogBuilder(Context context2) {
            this.context = context2;
            this.inflater = LayoutInflater.from(context2);
        }

        public DialogBuilder setTitle(String str) {
            this.title = str;
            return this;
        }

        public DialogBuilder setTitle(int i) {
            if (i != 0) {
                this.title = this.context.getString(i);
            }
            return this;
        }

        public String getTitle() {
            return this.title;
        }

        public DialogBuilder setTitleTypeface(int i) {
            this.titleTypeface = i;
            return this;
        }

        public DialogBuilder setContent(String str) {
            this.content = str;
            return this;
        }

        public DialogBuilder setContent(int i) {
            if (i != 0) {
                this.content = this.context.getString(i);
            }
            return this;
        }

        public String getContent() {
            return this.content;
        }

        public DialogBuilder setButtonLayoutGravity(int i) {
            this.btnLayoutGravity = i;
            return this;
        }

        public DialogBuilder setCustomContentLayout(int i) {
            this.contentLayoutId = i;
            return this;
        }

        public DialogBuilder setLeftBtn(String str) {
            this.leftBtnText = str;
            return this;
        }

        public DialogBuilder setLeftBtn(int i) {
            if (i != 0) {
                this.leftBtnText = this.context.getString(i);
            }
            return this;
        }

        public DialogBuilder setLeftBtn(String str, View.OnClickListener onClickListener) {
            this.leftBtnText = str;
            this.leftBtnClickListener = onClickListener;
            return this;
        }

        public DialogBuilder setLeftBtn(int i, View.OnClickListener onClickListener) {
            if (i != 0) {
                this.leftBtnText = this.context.getString(i);
            }
            this.leftBtnClickListener = onClickListener;
            return this;
        }

        public DialogBuilder setLeftBtnTypeface(int i) {
            this.leftBtnTypeface = i;
            return this;
        }

        public DialogBuilder setLeftBtnBg(int i) {
            if (i != 0) {
                this.leftBtnBg = i;
            }
            return this;
        }

        public DialogBuilder setLeftBtnTextColor(int i) {
            this.leftBtnTextColor = i;
            return this;
        }

        public DialogBuilder setLeftBtnTextColorRes(int i) {
            if (i != 0) {
                this.leftBtnTextColor = this.context.getResources().getColor(i);
            }
            return this;
        }

        public DialogBuilder setRightBtn(String str) {
            this.rightBtnText = str;
            return this;
        }

        public DialogBuilder setRightBtn(int i) {
            if (i != 0) {
                this.rightBtnText = this.context.getString(i);
            }
            return this;
        }

        public DialogBuilder setRightBtn(String str, View.OnClickListener onClickListener) {
            this.rightBtnText = str;
            this.rightBtnClickListener = onClickListener;
            return this;
        }

        public DialogBuilder setRightBtn(int i, View.OnClickListener onClickListener) {
            if (i != 0) {
                this.rightBtnText = this.context.getString(i);
            }
            this.rightBtnClickListener = onClickListener;
            return this;
        }

        public DialogBuilder setRightBtnTypeface(int i) {
            this.rightBtnTypeface = i;
            return this;
        }

        public DialogBuilder setRightBtnTextColor(int i) {
            this.rightBtnTextColor = i;
            return this;
        }

        public DialogBuilder setRightBtnTextColorRes(int i) {
            if (i != 0) {
                this.rightBtnTextColor = this.context.getResources().getColor(i);
            }
            return this;
        }

        public DialogBuilder setRightBtnBg(int i) {
            if (i != 0) {
                this.rightBtnBg = i;
            }
            return this;
        }

        public DialogBuilder setCancelableWhenTouchOutside(boolean z) {
            this.cancelableWhenTouchOutside = z;
            return this;
        }

        public SfCommonDialog build() {
            return SfCommonDialog.getInstance(this);
        }
    }
}
