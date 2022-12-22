package com.didi.component.business.commonlist;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.didi.component.business.commonlist.compmodel.CommonListBizCardProperty;
import com.didi.component.business.commonlist.item.CommonListCardProperty;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.common.adapter.CommonListAdapter;
import com.didi.component.common.adapter.ICommonListCardBindDataReadyCallback;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IComponent;
import com.didi.component.core.IPresenter;
import com.didi.component.core.IViewContainer;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.enginecore.template.nat.NativeComponent;
import com.didiglobal.enginecore.template.temp.TemplateComponent;
import com.didiglobal.enginecore.template.xml.XMLComponent;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public abstract class AbsCommonListPresenter extends IPresenter<ICommonListView> implements IViewContainer {

    /* renamed from: a */
    private HashMap<String, LinkedTreeMap<String, Object>> f11182a = new HashMap<>();

    /* renamed from: b */
    private BaseEventPublisher.OnEventListener<View> f11183b = new BaseEventPublisher.OnEventListener<View>() {
        public void onEvent(String str, View view) {
            AbsCommonListPresenter.this.removeCard(view);
            AbsCommonListPresenter.this.afterRemoveCard();
        }
    };

    /* renamed from: c */
    private XEReqJSONParamsCallbackImpl f11184c = new XEReqJSONParamsCallbackImpl() {
        public JSONObject getRequestParams() {
            HashMap hashMap = new HashMap();
            AbsCommonListPresenter.this.addXERequestParams(hashMap);
            return new JSONObject(hashMap);
        }
    };
    public List<CommonListBizCardProperty> mBizCardProperties = new LinkedList();
    protected AtomicInteger mCardCount;
    public Map<CommonListCardProperty, Boolean> mCardsCacheMap = new LinkedHashMap();
    protected IViewContainer.IComponentCreator mComponentCreator;
    protected List<XEComponent> mComponentListFromEngine;
    protected ICommonListInterface mListInterface;
    protected Logger mLogger = LoggerFactory.getLogger(getClass().getName());
    protected XEResponseCallback xeResponse = new XEResponseCallback() {
        public void onFailed(String str, EngineErrorException engineErrorException) {
        }

        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            JsonObject jsonObject;
            if (xEngineData != null && (jsonObject = xEngineData.jsonObject) != null && !AbsCommonListPresenter.this.handleData(jsonObject, list)) {
                AbsCommonListPresenter.this.refresh(list);
                JsonArray asJsonArray = jsonObject.getAsJsonArray("list");
                if (asJsonArray != null && asJsonArray.size() > 0) {
                    GLog.m7970i("CommonListFlow: 后端下发卡片个数 = " + asJsonArray.size());
                    AbsCommonListPresenter.this.m7609a(asJsonArray);
                }
            }
        }
    };

    /* access modifiers changed from: protected */
    public abstract void addXERequestParams(Map<String, Object> map);

    /* access modifiers changed from: protected */
    public abstract void afterRemoveCard();

    /* access modifiers changed from: protected */
    public abstract String getComponentIdByType(String str);

    /* access modifiers changed from: protected */
    public abstract String[] getNativeCards();

    /* access modifiers changed from: protected */
    public abstract XERegisterModel getXERegisterModel();

    /* access modifiers changed from: protected */
    public abstract boolean handleData(JsonObject jsonObject, List<XEComponent> list);

    public abstract void request();

    public void removeCard(View view) {
        if (view != null) {
            this.mListInterface.removeCard(view);
        }
    }

    /* renamed from: b */
    private void m7611b() {
        AtomicInteger atomicInteger = this.mCardCount;
        if (atomicInteger != null) {
            atomicInteger.decrementAndGet();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.google.gson.internal.LinkedTreeMap} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m7609a(com.google.gson.JsonArray r5) {
        /*
            r4 = this;
            com.google.gson.Gson r0 = new com.google.gson.Gson
            r0.<init>()
            java.lang.String r5 = r5.toString()
            com.didi.component.business.commonlist.AbsCommonListPresenter$1 r1 = new com.didi.component.business.commonlist.AbsCommonListPresenter$1
            r1.<init>()
            java.lang.reflect.Type r1 = r1.getType()
            java.lang.Object r5 = r0.fromJson((java.lang.String) r5, (java.lang.reflect.Type) r1)
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x001c:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x005a
            java.lang.Object r0 = r5.next()
            com.google.gson.internal.LinkedTreeMap r0 = (com.google.gson.internal.LinkedTreeMap) r0     // Catch:{ Exception -> 0x0055 }
            if (r0 != 0) goto L_0x002b
            goto L_0x001c
        L_0x002b:
            java.lang.String r1 = "id"
            java.lang.Object r1 = r0.get(r1)     // Catch:{ Exception -> 0x0055 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0055 }
            r2 = 0
            java.lang.String r3 = "extension"
            java.lang.Object r0 = r0.get(r3)     // Catch:{ Exception -> 0x0055 }
            com.google.gson.internal.LinkedTreeMap r0 = (com.google.gson.internal.LinkedTreeMap) r0     // Catch:{ Exception -> 0x0055 }
            if (r0 == 0) goto L_0x0047
            java.lang.String r2 = "log_data"
            java.lang.Object r0 = r0.get(r2)     // Catch:{ Exception -> 0x0055 }
            r2 = r0
            com.google.gson.internal.LinkedTreeMap r2 = (com.google.gson.internal.LinkedTreeMap) r2     // Catch:{ Exception -> 0x0055 }
        L_0x0047:
            if (r2 == 0) goto L_0x001c
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0055 }
            if (r0 != 0) goto L_0x001c
            java.util.HashMap<java.lang.String, com.google.gson.internal.LinkedTreeMap<java.lang.String, java.lang.Object>> r0 = r4.f11182a     // Catch:{ Exception -> 0x0055 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x0055 }
            goto L_0x001c
        L_0x0055:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x001c
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.business.commonlist.AbsCommonListPresenter.m7609a(com.google.gson.JsonArray):void");
    }

    /* access modifiers changed from: protected */
    public void refresh(List<XEComponent> list) {
        Map map;
        if (list != null && list.size() != 0) {
            Logger logger = this.mLogger;
            logger.info("CommonListFlow:Engine callback List<XEComponent> size = " + list.size(), new Object[0]);
            this.mComponentListFromEngine = list;
            this.mCardCount = new AtomicInteger(list.size());
            Iterator<XEComponent> it = list.iterator();
            while (true) {
                boolean z = true;
                if (!it.hasNext()) {
                    break;
                }
                XEComponent next = it.next();
                if (next instanceof NativeComponent) {
                    Iterator<CommonListBizCardProperty> it2 = this.mBizCardProperties.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (it2.next().mId.equals(next.getId())) {
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z) {
                        m7611b();
                    }
                }
            }
            for (XEComponent next2 : list) {
                final CommonListCardProperty commonListCardProperty = new CommonListCardProperty();
                Logger logger2 = this.mLogger;
                logger2.info("CommonListFlow:Engine callback List<XEComponent> ids, id = " + next2.getId(), new Object[0]);
                HashMap<String, LinkedTreeMap<String, Object>> hashMap = this.f11182a;
                if (!(hashMap == null || hashMap.size() <= 0 || (map = this.f11182a.get(next2.getId())) == null)) {
                    commonListCardProperty.setExtension(map);
                }
                if (next2 instanceof NativeComponent) {
                    for (CommonListBizCardProperty next3 : this.mBizCardProperties) {
                        if (next3.mId.equals(next2.getId())) {
                            if (next2.getView() == null) {
                                commonListCardProperty.setView(next3.mView);
                                commonListCardProperty.setId(next3.mId);
                                commonListCardProperty.setTemplate(next2.getTemplateId());
                            }
                            JSONObject data = next2.getData();
                            if (!(data == null || next3.mAdapter == null)) {
                                next3.mAdapter.setViewWithData(data, new ICommonListCardBindDataReadyCallback() {
                                    public void ready(boolean z) {
                                        AbsCommonListPresenter.this.m7610a(z, commonListCardProperty);
                                    }
                                });
                            }
                        }
                    }
                } else if ((next2 instanceof TemplateComponent) || (next2 instanceof XMLComponent)) {
                    commonListCardProperty.setView(next2.getView());
                    commonListCardProperty.setId(next2.getId());
                    commonListCardProperty.setTemplate(next2.getTemplateId());
                    m7610a(true, commonListCardProperty);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7610a(boolean z, CommonListCardProperty commonListCardProperty) {
        m7611b();
        Logger logger = this.mLogger;
        logger.info("CommonListFlow:viewReady后剩余处理组件数 = " + this.mCardCount.get() + ", ready组件id = " + commonListCardProperty.getId() + ", 卡片是否可见：" + z, new Object[0]);
        if (z) {
            this.mCardsCacheMap.put(commonListCardProperty, false);
        }
        GLog.m7967e("lxsConfig:" + this.mCardCount.get() + commonListCardProperty.getId());
        if (this.mCardCount.get() == 0) {
            LinkedList linkedList = new LinkedList();
            for (XEComponent next : this.mComponentListFromEngine) {
                Iterator<CommonListCardProperty> it = this.mCardsCacheMap.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CommonListCardProperty next2 = it.next();
                    if (this.mCardsCacheMap.get(next2) != Boolean.TRUE && !TextUtils.isEmpty(next2.getId()) && next2.getId().equals(next.getId())) {
                        this.mCardsCacheMap.put(next2, true);
                        linkedList.add(next2);
                        Logger logger2 = this.mLogger;
                        logger2.info("CommonListFlow:业务处理后设置给列表容器的可见卡片id = " + next2.getId(), new Object[0]);
                        break;
                    }
                }
            }
            this.mListInterface.setData(linkedList);
            Logger logger3 = this.mLogger;
            logger3.info("CommonListFlow:业务处理后给到列表容器的可见卡片个数 = " + linkedList.size(), new Object[0]);
            this.mCardsCacheMap.clear();
        }
    }

    /* access modifiers changed from: protected */
    public void addNativeCard(String str) {
        ArrayList arrayList = new ArrayList();
        CommonListCardProperty commonListCardProperty = new CommonListCardProperty();
        for (CommonListBizCardProperty next : this.mBizCardProperties) {
            if (next.mId.equals(str)) {
                if (commonListCardProperty.getView() == null) {
                    commonListCardProperty.setView(next.mView);
                }
                arrayList.add(commonListCardProperty);
                this.mListInterface.setData(arrayList);
            }
        }
    }

    /* renamed from: a */
    private void m7606a(View view) {
        ArrayList arrayList = new ArrayList();
        CommonListCardProperty commonListCardProperty = new CommonListCardProperty();
        if (commonListCardProperty.getView() == null) {
            commonListCardProperty.setView(view);
        }
        GLog.m7968e("BizLog", "addNativeView()");
        arrayList.add(commonListCardProperty);
        this.mListInterface.setData(arrayList);
    }

    public AbsCommonListPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        loadNativeCards(bundle);
        this.mListInterface = ((ICommonListView) this.mView).getCommonListInterface();
        XERegisterModel xERegisterModel = getXERegisterModel();
        xERegisterModel.requestParams = this.f11184c;
        XERegister.registerTemplate(xERegisterModel);
        subscribe(BaseEventKeys.WaitRsp.EVENT_COMMON_LIST_REMOVE_CARD, this.f11183b);
    }

    /* access modifiers changed from: protected */
    public final void loadNativeCards(Bundle bundle) {
        String[] nativeCards = getNativeCards();
        if (nativeCards != null && nativeCards.length != 0) {
            for (String str : nativeCards) {
                if (!TextUtils.isEmpty(str)) {
                    inflateComponent(str, bundle);
                }
            }
        }
    }

    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.WaitRsp.EVENT_COMMON_LIST_REMOVE_CARD, this.f11183b);
    }

    public final void inflateComponent(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        IComponent newComponent = this.mComponentCreator.newComponent(str, (ViewGroup) ((ICommonListView) this.mView).getView(), bundle);
        if (newComponent != null && newComponent.getView() != null) {
            View view = newComponent.getView().getView();
            CommonListBizCardProperty commonListBizCardProperty = new CommonListBizCardProperty();
            commonListBizCardProperty.mView = view;
            commonListBizCardProperty.mType = str;
            commonListBizCardProperty.mId = getComponentIdByType(str);
            if (newComponent.getPresenter() instanceof CommonListAdapter) {
                commonListBizCardProperty.mAdapter = (CommonListAdapter) newComponent.getPresenter();
            }
            this.mBizCardProperties.add(commonListBizCardProperty);
        }
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.mComponentCreator = iComponentCreator;
    }
}
