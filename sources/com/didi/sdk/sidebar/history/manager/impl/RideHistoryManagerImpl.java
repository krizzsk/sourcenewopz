package com.didi.sdk.sidebar.history.manager.impl;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.app.router.PageRouter;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.receiver.ReceiverConstant;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.sdk.app.BroadcastSender;
import com.didi.sdk.events.SwitchTypeEvent;
import com.didi.sdk.push.ServerParam;
import com.didi.sdk.sidebar.history.adapter.InoiceCountListener;
import com.didi.sdk.sidebar.history.constant.HistoryRecordConstant;
import com.didi.sdk.sidebar.history.manager.HistoryDeleteCallBack;
import com.didi.sdk.sidebar.history.manager.HistoryRequestCallBack;
import com.didi.sdk.sidebar.history.manager.IRideHistoryManager;
import com.didi.sdk.sidebar.history.model.AbsHistoryOrder;
import com.didi.sdk.sidebar.history.model.HistoryOrder;
import com.didi.sdk.sidebar.history.store.HistoryRecordStore;
import com.didi.sdk.util.SaApolloUtil;
import com.didi.sdk.util.TextUtil;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

public class RideHistoryManagerImpl implements IRideHistoryManager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public InoiceCountListener f37380a;

    public void exitHistory() {
    }

    public boolean isSupportInvoice() {
        return true;
    }

    public boolean isSupportLongClickDelete() {
        return true;
    }

    private RideHistoryManagerImpl() {
    }

    public static RideHistoryManagerImpl getRideHistoryManager() {
        return RideHistoryManagerImplContainer.instance;
    }

    private static class RideHistoryManagerImplContainer {
        /* access modifiers changed from: private */
        public static RideHistoryManagerImpl instance = new RideHistoryManagerImpl();

        private RideHistoryManagerImplContainer() {
        }
    }

    public void setInoiceCountListener(InoiceCountListener inoiceCountListener) {
        this.f37380a = inoiceCountListener;
    }

    public void getHistoryDate(Context context, Map<String, Object> map, HistoryRequestCallBack historyRequestCallBack) {
        HistoryRecordStore.getInstance().getHistoryRecords(context, map);
    }

    public View getHistoryItemView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.v_history_record_item, (ViewGroup) null);
    }

    public void bindDateForHistoryItemView(AbsHistoryOrder absHistoryOrder, View view, boolean z) {
        DataViewHolder dataViewHolder = new DataViewHolder();
        dataViewHolder.dateTV = (TextView) view.findViewById(R.id.date_tv);
        dataViewHolder.timeTV = (TextView) view.findViewById(R.id.time_tv);
        dataViewHolder.statusTV = (TextView) view.findViewById(R.id.status_tv);
        dataViewHolder.priceTV = (TextView) view.findViewById(R.id.price_tv);
        dataViewHolder.startTV = (TextView) view.findViewById(R.id.start_tv);
        dataViewHolder.startImg = (ImageView) view.findViewById(R.id.start_img);
        dataViewHolder.endImg = (ImageView) view.findViewById(R.id.end_img);
        dataViewHolder.endTV = (TextView) view.findViewById(R.id.end_tv);
        dataViewHolder.businessTv = (TextView) view.findViewById(R.id.business_name_tv);
        dataViewHolder.checkBox = (ImageView) view.findViewById(R.id.checkbox);
        dataViewHolder.clickRegion = view.findViewById(R.id.check_region);
        dataViewHolder.splitFareTag = (TextView) view.findViewById(R.id.split_fare_tv);
        view.setTag(dataViewHolder);
        m26589a(absHistoryOrder, dataViewHolder, z);
    }

    /* renamed from: a */
    private void m26589a(AbsHistoryOrder absHistoryOrder, DataViewHolder dataViewHolder, boolean z) {
        if (absHistoryOrder != null && dataViewHolder != null && (absHistoryOrder instanceof HistoryOrder)) {
            Context context = dataViewHolder.dateTV.getContext();
            HistoryOrder historyOrder = (HistoryOrder) absHistoryOrder;
            dataViewHolder.dateTV.setText(historyOrder.getTime());
            dataViewHolder.startTV.setText(historyOrder.getFromAddress());
            dataViewHolder.endTV.setText(historyOrder.getToAddress());
            if (!(DidiThemeManager.getIns() == null || DidiThemeManager.getIns().getResPicker(context) == null)) {
                dataViewHolder.startImg.setImageResource(DidiThemeManager.getIns().getResPicker(context).getResIdByTheme(R.attr.dot_pickup_icon));
            }
            dataViewHolder.businessTv.setText(historyOrder.getProductName());
            List<String> scene = historyOrder.getScene();
            if (scene != null && scene.size() > 0 && !TextUtils.isEmpty(scene.get(0))) {
                dataViewHolder.businessTv.setText(scene.get(0));
            }
            if (absHistoryOrder.getStatus() != 1 || DidiThemeManager.getIns() == null || DidiThemeManager.getIns().getResPicker(context) == null) {
                dataViewHolder.statusTV.setTextColor(context.getResources().getColor(R.color.light_gray));
            } else {
                dataViewHolder.statusTV.setTextColor(DidiThemeManager.getIns().getResPicker(context).getColor(R.attr.caution_color));
            }
            dataViewHolder.statusTV.setText(absHistoryOrder.getHisStatus());
            if (!TextUtils.isEmpty(absHistoryOrder.priceString)) {
                dataViewHolder.priceTV.setVisibility(0);
                dataViewHolder.priceTV.setText(absHistoryOrder.priceString);
            } else {
                dataViewHolder.priceTV.setVisibility(8);
            }
            Drawable drawable = DidiThemeManager.getIns().getResPicker(context).getDrawable(R.attr.checkbox_selected_icon);
            Drawable drawable2 = DidiThemeManager.getIns().getResPicker(context).getDrawable(R.attr.checkbox_unselected_icon);
            Drawable drawable3 = DidiThemeManager.getIns().getResPicker(context).getDrawable(R.attr.checkbox_unable_icon);
            if (!z) {
                dataViewHolder.clickRegion.setOnClickListener((View.OnClickListener) null);
                dataViewHolder.clickRegion.setClickable(false);
                ImageView imageView = dataViewHolder.checkBox;
                if (!historyOrder.isInvoiceSelected()) {
                    drawable = drawable2;
                }
                imageView.setImageDrawable(drawable);
            } else if (absHistoryOrder.allowSendInvoice == 1) {
                dataViewHolder.clickRegion.setClickable(true);
                final HistoryOrder historyOrder2 = historyOrder;
                final DataViewHolder dataViewHolder2 = dataViewHolder;
                final Drawable drawable4 = drawable;
                final Drawable drawable5 = drawable2;
                dataViewHolder.clickRegion.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        boolean isInvoiceSelected = historyOrder2.isInvoiceSelected();
                        dataViewHolder2.checkBox.setSelected(!isInvoiceSelected);
                        dataViewHolder2.checkBox.setImageDrawable(!isInvoiceSelected ? drawable4 : drawable5);
                        historyOrder2.setInvoiceSelected(!isInvoiceSelected);
                        if (RideHistoryManagerImpl.this.f37380a != null) {
                            RideHistoryManagerImpl.this.f37380a.onSelectCountChange();
                        }
                    }
                });
                ImageView imageView2 = dataViewHolder.checkBox;
                if (!historyOrder.isInvoiceSelected()) {
                    drawable = drawable2;
                }
                imageView2.setImageDrawable(drawable);
            } else {
                dataViewHolder.clickRegion.setOnClickListener((View.OnClickListener) null);
                dataViewHolder.clickRegion.setClickable(false);
                dataViewHolder.checkBox.setImageDrawable(drawable3);
            }
            dataViewHolder.checkBox.setVisibility(z ? 0 : 8);
            String splitFareLabel = historyOrder.getSplitFareLabel();
            if (!TextUtils.isEmpty(splitFareLabel)) {
                dataViewHolder.splitFareTag.setVisibility(0);
                dataViewHolder.splitFareTag.setText(splitFareLabel);
                return;
            }
            dataViewHolder.splitFareTag.setVisibility(8);
        }
    }

    private static class DataViewHolder {
        TextView businessTv;
        ImageView checkBox;
        View clickRegion;
        TextView dateTV;
        ImageView endImg;
        TextView endTV;
        CheckBox isSelectedCB;
        TextView priceTV;
        TextView splitFareTag;
        ImageView startImg;
        TextView startTV;
        TextView statusTV;
        TextView timeTV;
        TextView tipsTV;
        ImageView typeImg;

        private DataViewHolder() {
        }
    }

    public void clickHistoryItemView(Context context, AbsHistoryOrder absHistoryOrder) {
        if (absHistoryOrder instanceof HistoryOrder) {
            JsonObject extra = absHistoryOrder.getExtra();
            if (extra != null && extra.has(HistoryRecordConstant.VAMOS_ROLE)) {
                try {
                    String asString = extra.get(HistoryRecordConstant.VAMOS_ROLE).getAsString();
                    if ("driver".equals(asString)) {
                        Context context2 = context;
                        PageRouter.getInstance().forwardVamosDriver(context2, extra.get(HistoryRecordConstant.VAMOS_TRIPID).getAsString(), absHistoryOrder.getOrderId(), absHistoryOrder.getProductId(), HistoryRecordConstant.VAMOS_HISTORY);
                    } else if ("passenger".equals(asString)) {
                        PageRouter.getInstance().forwardVamosPax(context, absHistoryOrder.getOrderId(), absHistoryOrder.getProductId(), HistoryRecordConstant.VAMOS_HISTORY);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (TextUtils.isEmpty(absHistoryOrder.groupType) || !HistoryRecordConstant.ENTREGA_HISTORY.equals(absHistoryOrder.groupType)) {
                m26588a(context, (HistoryOrder) absHistoryOrder);
            } else if (!TextUtils.isEmpty(absHistoryOrder.url)) {
                HistoryRecordStore.getInstance().closeHistoryRecordFragment();
                Request build = DRouter.build(absHistoryOrder.url);
                if (SaApolloUtil.INSTANCE.getSaState()) {
                    build = (Request) build.putExtra(HistoryRecordConstant.PARAMS_POP_BACK_STACK, 1);
                }
                build.start();
            }
            if (SaApolloUtil.INSTANCE.getSaState()) {
                HashMap hashMap = new HashMap();
                hashMap.put("content", "ride");
                OmegaSDKAdapter.trackEvent("ibt_gp_mytrip_order_ck", (Map<String, Object>) hashMap);
                return;
            }
            HashMap hashMap2 = new HashMap();
            try {
                hashMap2.put(ServerParam.PARAM_ORDER_TYPE, absHistoryOrder.getHisStatus());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            OmegaSDKAdapter.trackEvent("pas_mytriplist_ck", (Map<String, Object>) hashMap2);
        }
    }

    /* renamed from: a */
    private void m26588a(Context context, HistoryOrder historyOrder) {
        if (historyOrder != null) {
            Intent intent = new Intent();
            intent.setAction(ReceiverConstant.ACTION_ONTHEWAY);
            intent.setData(Uri.parse("OneReceiver://" + "extended" + ReceiverConstant.MATCHER_ONTHEWAY));
            intent.putExtra("oid", historyOrder.getOrderId());
            intent.putExtra("order", historyOrder.getOrder());
            intent.putExtra("product_id", historyOrder.getProductId());
            if (historyOrder.getExtraData() != null) {
                intent.putExtra("extra", historyOrder.getExtraData());
            }
            if (historyOrder.getExtraMap() != null) {
                intent.putExtra("extra_data", (Serializable) historyOrder.getExtraMap());
            }
            BroadcastSender.getInstance(context).sendBroadcast(intent);
            EventBus.getDefault().post(new SwitchTypeEvent("ride"));
        }
    }

    public void deleteHistoryDate(Context context, AbsHistoryOrder absHistoryOrder, HistoryDeleteCallBack historyDeleteCallBack) {
        StringBuilder sb = new StringBuilder();
        HashMap hashMap = new HashMap();
        JsonObject extra = absHistoryOrder.getExtra();
        String str = null;
        if (extra != null && extra.has(HistoryRecordConstant.VAMOS_ROLE)) {
            try {
                if ("driver".equals(extra.get(HistoryRecordConstant.VAMOS_ROLE).getAsString())) {
                    str = extra.get(HistoryRecordConstant.VAMOS_TRIPID).getAsString();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!TextUtil.isEmpty(str)) {
            sb.append(str);
            sb.append("_");
            sb.append(absHistoryOrder.getProduct());
            hashMap.put(PageRouter.VAMOS_TRIPID, sb.toString());
        } else if (!TextUtil.isEmpty(absHistoryOrder.getOrderId())) {
            sb.append(absHistoryOrder.getOrderId());
            sb.append("_");
            sb.append(absHistoryOrder.getProduct());
            hashMap.put("oid", sb.toString());
        } else {
            return;
        }
        HistoryRecordStore.getInstance().deleteRecords(context, hashMap, historyDeleteCallBack);
    }
}
