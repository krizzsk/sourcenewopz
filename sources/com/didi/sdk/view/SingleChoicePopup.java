package com.didi.sdk.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.titlebar.CommonPopupTitleBar;
import com.taxis99.R;
import java.util.List;

public class SingleChoicePopup extends SimplePopupBase {

    /* renamed from: a */
    private CommonPopupTitleBar f37890a;

    /* renamed from: b */
    private String f37891b;

    /* renamed from: c */
    private String f37892c;

    /* renamed from: d */
    private View.OnClickListener f37893d;

    /* renamed from: e */
    private ListView f37894e;

    /* renamed from: f */
    private SingleChoiceAdapter f37895f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public AdapterView.OnItemClickListener f37896g;

    /* renamed from: h */
    private int f37897h = -1;

    public static class SingleChoiceItem {
        public int mItemIconId = 0;
        public String mItemName = "";
        public String mMincontext;
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.v_common_single_choice_popup;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        m26821a(this.mRootView);
    }

    public void setTitle(String str) {
        this.f37891b = str;
    }

    public void setMessage(String str) {
        this.f37892c = str;
    }

    public void setLeftClickListener(View.OnClickListener onClickListener) {
        this.f37893d = onClickListener;
    }

    public void setContentAdapter(SingleChoiceAdapter singleChoiceAdapter) {
        this.f37895f = singleChoiceAdapter;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f37896g = onItemClickListener;
    }

    public void setLastSelectedIndex(int i) {
        this.f37897h = i;
    }

    /* renamed from: a */
    private void m26821a(View view) {
        CommonPopupTitleBar commonPopupTitleBar = (CommonPopupTitleBar) view.findViewById(R.id.title_bar);
        this.f37890a = commonPopupTitleBar;
        commonPopupTitleBar.setTitle(this.f37891b);
        if (!TextUtils.isEmpty(this.f37892c)) {
            this.f37890a.setMessage(this.f37892c);
        }
        CommonPopupTitleBar commonPopupTitleBar2 = this.f37890a;
        View.OnClickListener onClickListener = this.f37893d;
        if (onClickListener == null) {
            onClickListener = new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    SingleChoicePopup.this.dismiss();
                }
            };
        }
        commonPopupTitleBar2.setLeft(onClickListener);
        SingleChoiceAdapter singleChoiceAdapter = this.f37895f;
        if (singleChoiceAdapter != null) {
            singleChoiceAdapter.setLastSelectedIndex(this.f37897h);
        }
        ListView listView = (ListView) view.findViewById(R.id.lv_content_list);
        this.f37894e = listView;
        listView.setAdapter(this.f37895f);
        this.f37894e.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
                if (SingleChoicePopup.this.f37896g != null) {
                    SingleChoicePopup.this.f37896g.onItemClick(adapterView, view, i, j);
                }
                SingleChoicePopup.this.dismiss();
            }
        });
    }

    public static class SingleChoiceAdapter extends BaseAdapter {
        protected Context mContext;
        protected LayoutInflater mInflater;
        protected int mLastSelectedIndex = -1;
        protected List<SingleChoiceItem> mListContent;

        public long getItemId(int i) {
            return 0;
        }

        /* access modifiers changed from: protected */
        public int getTxtGravity() {
            return 8388627;
        }

        public SingleChoiceAdapter(Activity activity, List<SingleChoiceItem> list) {
            this.mContext = activity;
            this.mInflater = LayoutInflater.from(activity);
            this.mListContent = list;
        }

        public void setLastSelectedIndex(int i) {
            this.mLastSelectedIndex = i;
        }

        public int getCount() {
            List<SingleChoiceItem> list = this.mListContent;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public SingleChoiceItem getItem(int i) {
            List<SingleChoiceItem> list = this.mListContent;
            if (list == null || i < 0 || i >= list.size()) {
                return null;
            }
            return this.mListContent.get(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = this.mInflater.inflate(R.layout.v_common_pop_list_item, viewGroup, false);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            SingleChoiceItem item = getItem(i);
            if (item != null) {
                viewHolder.textView.setText(item.mItemName);
                if (!TextUtils.isEmpty(item.mMincontext)) {
                    viewHolder.minContextView.setVisibility(0);
                    viewHolder.minContextView.setText(item.mMincontext);
                }
                if (item.mItemIconId > 0) {
                    viewHolder.imageView.setImageResource(item.mItemIconId);
                    viewHolder.imageView.setVisibility(0);
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewHolder.contentView.getLayoutParams();
                layoutParams.gravity = getTxtGravity();
                viewHolder.contentView.setLayoutParams(layoutParams);
                if (i == this.mLastSelectedIndex) {
                    viewHolder.textView.setTextColor(this.mContext.getResources().getColor(R.color.common_dialog_recommend_option_txt_color));
                } else {
                    viewHolder.textView.setTextColor(this.mContext.getResources().getColor(R.color.dark_gray));
                }
            }
            return view;
        }

        public static class ViewHolder {
            public LinearLayout contentView;
            public ImageView imageView;
            public TextView minContextView;
            public TextView textView;

            public ViewHolder(View view) {
                this.contentView = (LinearLayout) view.findViewById(R.id.ll_root);
                this.imageView = (ImageView) view.findViewById(R.id.iv_icon);
                this.textView = (TextView) view.findViewById(R.id.tv_content);
                this.minContextView = (TextView) view.findViewById(R.id.tv_min_content);
            }
        }
    }
}
