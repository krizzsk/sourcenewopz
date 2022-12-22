package com.didi.map.setting.global;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.map.setting.common.IMapSettingPreferences;
import com.didi.map.setting.common.MapSettingAppInfo;
import com.didi.map.setting.global.MapSettingSelectedView;
import com.taxis99.R;
import java.util.List;

public class MapSettingSelectedView extends FrameLayout {

    /* renamed from: a */
    private MapSettingSelectedAdapter f28979a;

    /* renamed from: b */
    private OnItemClickListener f28980b;

    /* renamed from: c */
    private RecyclerView f28981c;

    public interface OnItemClickListener {
        void onItemClick(MapSettingAppInfo mapSettingAppInfo, int i);
    }

    public void clearData() {
    }

    public MapSettingSelectedView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MapSettingSelectedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (getChildCount() > 0) {
            removeAllViews();
        }
        RecyclerView recyclerView = new RecyclerView(context);
        this.f28981c = recyclerView;
        recyclerView.setFadingEdgeLength(0);
        this.f28981c.setOverScrollMode(2);
        this.f28981c.setLayoutManager(new LinearLayoutManager(context));
        addView(this.f28981c, new ViewGroup.LayoutParams(-1, -1));
    }

    public void initListData(List<MapSettingAppInfo> list, IMapSettingPreferences iMapSettingPreferences) {
        MapSettingSelectedAdapter mapSettingSelectedAdapter = new MapSettingSelectedAdapter(getContext(), list, iMapSettingPreferences);
        this.f28979a = mapSettingSelectedAdapter;
        OnItemClickListener onItemClickListener = this.f28980b;
        if (onItemClickListener != null) {
            mapSettingSelectedAdapter.setOnItemClickListener(onItemClickListener);
        }
        this.f28981c.setAdapter(this.f28979a);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f28980b = onItemClickListener;
        MapSettingSelectedAdapter mapSettingSelectedAdapter = this.f28979a;
        if (mapSettingSelectedAdapter != null) {
            mapSettingSelectedAdapter.setOnItemClickListener(onItemClickListener);
        }
    }

    public void rememberChange(boolean z) {
        MapSettingSelectedAdapter mapSettingSelectedAdapter = this.f28979a;
        if (mapSettingSelectedAdapter != null) {
            mapSettingSelectedAdapter.setEnable(z);
        }
    }

    private static class MapSettingSelectedAdapter extends RecyclerView.Adapter<C10212VH> {
        private Context mContext;
        private boolean mEnable;
        private ImageView mLastSelectedView;
        private OnItemClickListener mOnItemClickListener;
        private IMapSettingPreferences mPreferences;
        private List<MapSettingAppInfo> mThirdNavList;

        public MapSettingSelectedAdapter(Context context, List<MapSettingAppInfo> list, IMapSettingPreferences iMapSettingPreferences) {
            this.mContext = context;
            this.mThirdNavList = list;
            this.mPreferences = iMapSettingPreferences;
            if (iMapSettingPreferences != null) {
                this.mEnable = iMapSettingPreferences.getNavRemember();
            }
        }

        public void setEnable(boolean z) {
            this.mEnable = z;
            notifyDataSetChanged();
        }

        public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.mOnItemClickListener = onItemClickListener;
        }

        public C10212VH onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C10212VH(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.map_setting_selected_item_view, viewGroup, false));
        }

        public void onBindViewHolder(C10212VH vh, int i) {
            MapSettingAppInfo item = getItem(i);
            if (item != null) {
                if (i == 0) {
                    vh.mDivider.setVisibility(8);
                } else {
                    vh.mDivider.setVisibility(0);
                }
                vh.mNavIconImg.setImageDrawable(item.appIcon);
                vh.mNavNameTv.setText(item.appLabel);
                if (!item.isInstalled || !this.mEnable) {
                    vh.mSelectedFlag.setVisibility(8);
                    vh.mNavNameTv.setTextColor(this.mContext.getResources().getColor(R.color.map_setting_item_gray));
                    vh.itemView.setEnabled(false);
                    return;
                }
                vh.mNavNameTv.setTextColor(this.mContext.getResources().getColor(R.color.map_setting_item_text));
                vh.itemView.setEnabled(true);
                vh.itemView.setOnClickListener(new View.OnClickListener(item, i, vh) {
                    public final /* synthetic */ MapSettingAppInfo f$1;
                    public final /* synthetic */ int f$2;
                    public final /* synthetic */ MapSettingSelectedView.MapSettingSelectedAdapter.C10212VH f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void onClick(View view) {
                        MapSettingSelectedView.MapSettingSelectedAdapter.this.mo79889x8c107bfe(this.f$1, this.f$2, this.f$3, view);
                    }
                });
                if (this.mPreferences == null || !item.pkgName.equals(this.mPreferences.getNavSelectedPath())) {
                    vh.mSelectedFlag.setVisibility(8);
                    return;
                }
                vh.mSelectedFlag.setVisibility(0);
                this.mLastSelectedView = vh.mSelectedFlag;
            }
        }

        /* renamed from: lambda$onBindViewHolder$0$MapSettingSelectedView$MapSettingSelectedAdapter */
        public /* synthetic */ void mo79889x8c107bfe(MapSettingAppInfo mapSettingAppInfo, int i, C10212VH vh, View view) {
            OnItemClickListener onItemClickListener = this.mOnItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(mapSettingAppInfo, i);
                ImageView imageView = this.mLastSelectedView;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                this.mLastSelectedView = vh.mSelectedFlag;
                vh.mSelectedFlag.setVisibility(0);
            }
        }

        private MapSettingAppInfo getItem(int i) {
            List<MapSettingAppInfo> list = this.mThirdNavList;
            if (list == null || list.size() <= i) {
                return null;
            }
            return this.mThirdNavList.get(i);
        }

        public int getItemCount() {
            List<MapSettingAppInfo> list = this.mThirdNavList;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        /* renamed from: com.didi.map.setting.global.MapSettingSelectedView$MapSettingSelectedAdapter$VH */
        private static class C10212VH extends RecyclerView.ViewHolder {
            /* access modifiers changed from: private */
            public View mDivider;
            /* access modifiers changed from: private */
            public ImageView mNavIconImg;
            /* access modifiers changed from: private */
            public TextView mNavNameTv;
            /* access modifiers changed from: private */
            public ImageView mSelectedFlag;

            public C10212VH(View view) {
                super(view);
                this.mNavIconImg = (ImageView) view.findViewById(R.id.nav_icon);
                this.mNavNameTv = (TextView) view.findViewById(R.id.nav_name);
                this.mSelectedFlag = (ImageView) view.findViewById(R.id.sel_flag_img);
                this.mDivider = view.findViewById(R.id.nav_divider);
            }
        }
    }
}
