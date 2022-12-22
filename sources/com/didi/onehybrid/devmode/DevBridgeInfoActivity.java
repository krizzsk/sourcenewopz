package com.didi.onehybrid.devmode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.onehybrid.devmode.FusionRuntimeInfo;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class DevBridgeInfoActivity extends Activity {

    /* renamed from: a */
    private Map<String, FusionRuntimeInfo.BridgeInfo> f29530a = null;

    /* renamed from: b */
    private View f29531b;

    /* renamed from: c */
    private RecyclerView f29532c;

    /* renamed from: d */
    private View f29533d;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.activity_dev_bridge_info);
        this.f29530a = ((FusionRuntimeInfo) getIntent().getSerializableExtra("fusionRuntimeInfo")).getBridgeInfoMap();
        m20791a();
    }

    /* renamed from: a */
    private void m20791a() {
        View findViewById = findViewById(R.id.title_back);
        this.f29531b = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DevBridgeInfoActivity.this.finish();
            }
        });
        this.f29532c = (RecyclerView) findViewById(R.id.bridge_info_list);
        this.f29533d = findViewById(R.id.empty_view);
        this.f29532c.setLayoutManager(new LinearLayoutManager(this, 1, false));
        BridgeInfoAdapter bridgeInfoAdapter = new BridgeInfoAdapter(this, this.f29530a.values());
        this.f29532c.setAdapter(bridgeInfoAdapter);
        this.f29532c.addItemDecoration(new RecycleViewDivider(this, 1));
        if (bridgeInfoAdapter.getItemCount() > 0) {
            this.f29532c.setVisibility(0);
            this.f29533d.setVisibility(8);
            return;
        }
        this.f29532c.setVisibility(8);
        this.f29533d.setVisibility(0);
    }

    private static class BridgeInfoAdapter extends RecyclerView.Adapter<ViewHolder> {
        /* access modifiers changed from: private */
        public ArrayList<FusionRuntimeInfo.BridgeInfo> mBridgeInfoDatas;
        /* access modifiers changed from: private */
        public Context mContext;

        public BridgeInfoAdapter(Context context, Collection<FusionRuntimeInfo.BridgeInfo> collection) {
            this.mContext = context;
            this.mBridgeInfoDatas = new ArrayList<>(collection);
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_bridge_info, viewGroup, false));
        }

        public void onBindViewHolder(ViewHolder viewHolder, final int i) {
            viewHolder.bridgeInfoView.setText(bridgeInfoToString(this.mBridgeInfoDatas.get(i)));
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    Intent intent = new Intent(BridgeInfoAdapter.this.mContext, DevBridgeDetailActivity.class);
                    intent.putExtra("bridgeInfo", (Serializable) BridgeInfoAdapter.this.mBridgeInfoDatas.get(i));
                    BridgeInfoAdapter.this.mContext.startActivity(intent);
                }
            });
        }

        public int getItemCount() {
            return this.mBridgeInfoDatas.size();
        }

        private String bridgeInfoToString(FusionRuntimeInfo.BridgeInfo bridgeInfo) {
            String str;
            String str2;
            StringBuilder sb = new StringBuilder();
            if (bridgeInfo.isRejected) {
                sb.append("调用被拒绝");
                sb.append("\n");
                sb.append("Bridge调用信息: ");
                sb.append(bridgeInfo.bridgeUrl);
                sb.append("\n");
                sb.append("错误原因: ");
                sb.append(bridgeInfo.errMsg);
            } else {
                if (TextUtils.isEmpty(bridgeInfo.errMsg)) {
                    sb.append("调用成功");
                    sb.append("\n");
                } else {
                    sb.append("调用异常");
                    sb.append("\n");
                }
                if (bridgeInfo.args.length() > 103) {
                    str = bridgeInfo.args.substring(0, 100) + "...";
                } else {
                    str = bridgeInfo.args;
                }
                sb.append("协议版本：");
                sb.append(bridgeInfo.bridgeVersion);
                sb.append("\n");
                sb.append("调用信息：");
                sb.append(bridgeInfo.moduleName);
                sb.append(".");
                sb.append(bridgeInfo.functionName);
                sb.append("\n");
                sb.append("参   数：");
                sb.append(str);
                sb.append("\n");
                if (!TextUtils.isEmpty(bridgeInfo.callbackResult)) {
                    if (bridgeInfo.callbackResult.length() > 103) {
                        str2 = bridgeInfo.callbackResult.substring(0, 100) + "...";
                    } else {
                        str2 = bridgeInfo.callbackResult;
                    }
                    sb.append("响应数据：");
                    sb.append(str2);
                    sb.append("\n");
                } else if (!TextUtils.isEmpty(bridgeInfo.errMsg)) {
                    sb.append("异常信息：");
                    sb.append(bridgeInfo.errMsg);
                    sb.append("\n");
                } else {
                    sb.append("响应数据：");
                    sb.append("无");
                    sb.append("\n");
                }
            }
            return sb.toString();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            TextView bridgeInfoView;

            public ViewHolder(View view) {
                super(view);
                this.bridgeInfoView = (TextView) view.findViewById(R.id.bridge_info_text);
            }
        }
    }

    public static class RecycleViewDivider extends RecyclerView.ItemDecoration {
        private static final int[] ATTRS = {16843284};
        private Drawable mDivider;
        private int mDividerHeight;
        private int mOrientation;
        private Paint mPaint;

        public RecycleViewDivider(Context context, int i) {
            this.mDividerHeight = 2;
            if (i == 1 || i == 0) {
                this.mOrientation = i;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(ATTRS);
                this.mDivider = obtainStyledAttributes.getDrawable(0);
                obtainStyledAttributes.recycle();
                return;
            }
            throw new IllegalArgumentException("请输入正确的参数！");
        }

        public RecycleViewDivider(Context context, int i, int i2) {
            this(context, i);
            Drawable drawable = ContextCompat.getDrawable(context, i2);
            this.mDivider = drawable;
            this.mDividerHeight = drawable.getIntrinsicHeight();
        }

        public RecycleViewDivider(Context context, int i, int i2, int i3) {
            this(context, i);
            this.mDividerHeight = i2;
            Paint paint = new Paint(1);
            this.mPaint = paint;
            paint.setColor(i3);
            this.mPaint.setStyle(Paint.Style.FILL);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            rect.set(0, 0, 0, this.mDividerHeight);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            super.onDraw(canvas, recyclerView, state);
            if (this.mOrientation == 1) {
                drawVertical(canvas, recyclerView);
            } else {
                drawHorizontal(canvas, recyclerView);
            }
        }

        private void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
            int paddingLeft = recyclerView.getPaddingLeft();
            int measuredWidth = recyclerView.getMeasuredWidth() - recyclerView.getPaddingRight();
            int childCount = recyclerView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                int i2 = this.mDividerHeight + bottom;
                Drawable drawable = this.mDivider;
                if (drawable != null) {
                    drawable.setBounds(paddingLeft, bottom, measuredWidth, i2);
                    this.mDivider.draw(canvas);
                }
                Paint paint = this.mPaint;
                if (paint != null) {
                    canvas.drawRect((float) paddingLeft, (float) bottom, (float) measuredWidth, (float) i2, paint);
                }
            }
        }

        private void drawVertical(Canvas canvas, RecyclerView recyclerView) {
            int paddingTop = recyclerView.getPaddingTop();
            int measuredHeight = recyclerView.getMeasuredHeight() - recyclerView.getPaddingBottom();
            int childCount = recyclerView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                int right = childAt.getRight() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).rightMargin;
                int i2 = this.mDividerHeight + right;
                Drawable drawable = this.mDivider;
                if (drawable != null) {
                    drawable.setBounds(right, paddingTop, i2, measuredHeight);
                    this.mDivider.draw(canvas);
                }
                Paint paint = this.mPaint;
                if (paint != null) {
                    canvas.drawRect((float) right, (float) paddingTop, (float) i2, (float) measuredHeight, paint);
                }
            }
        }
    }
}
