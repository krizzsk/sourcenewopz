package com.didi.component.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import com.didi.component.Component;
import com.didi.component.ComponentGroup;
import com.didi.component.ComponentStub;
import com.didi.component.Inject;
import com.didi.component.config.BusinessRegistry;
import com.didi.component.core.ComponentFactory;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.ComponentStatus;
import com.didi.component.core.IComponent;
import com.didi.component.core.IComponentGroup;
import com.didi.component.core.IPresenter;
import com.didi.component.core.IView;
import com.didi.component.core.IViewContainer;
import com.didi.component.core.PresenterGroup;
import com.didi.component.core.util.CLog;
import com.didi.passenger.C10448R;
import com.didi.sdk.app.BusinessContext;
import com.didiglobal.font.iface.DecoratorFactory;
import com.taxis99.R;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbsBaseBizFragment<P extends PresenterGroup> extends BaseBizFragment<P> implements DecoratorFactory {
    private static final String TAG = AbsBaseBizFragment.class.getSimpleName();
    private Map<String, Field> mComponentField = new HashMap();
    private HashMap<String, IComponent> mComponentHashMap = new HashMap<>();
    private IViewContainer.IComponentCreator mViewCreator;

    private interface ViewProcessor {
        void process(View view);
    }

    /* access modifiers changed from: protected */
    public abstract int currentComboType();

    /* access modifiers changed from: protected */
    public abstract int currentPageId();

    /* access modifiers changed from: protected */
    public int currentRole() {
        return -1;
    }

    /* access modifiers changed from: protected */
    public int currentVersionCode() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public Bundle prepareExtraForComponent(String str) {
        return null;
    }

    public /* bridge */ /* synthetic */ boolean onActivityResultHappen(int i, int i2, Intent intent) {
        return super.onActivityResultHappen(i, i2, intent);
    }

    public /* bridge */ /* synthetic */ void onBackToHome() {
        super.onBackToHome();
    }

    public /* bridge */ /* synthetic */ Animation onCreateAnimation(int i, boolean z, int i2) {
        return super.onCreateAnimation(i, z, i2);
    }

    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    public /* bridge */ /* synthetic */ boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    public /* bridge */ /* synthetic */ boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return super.onKeyLongPress(i, keyEvent);
    }

    public /* bridge */ /* synthetic */ boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return super.onKeyMultiple(i, i2, keyEvent);
    }

    public /* bridge */ /* synthetic */ boolean onKeyUp(int i, KeyEvent keyEvent) {
        return super.onKeyUp(i, keyEvent);
    }

    public /* bridge */ /* synthetic */ void setBackVisible(boolean z) {
        super.setBackVisible(z);
    }

    public /* bridge */ /* synthetic */ void setBusinessContext(BusinessContext businessContext) {
        super.setBusinessContext(businessContext);
    }

    public /* bridge */ /* synthetic */ void setPresenter(PresenterGroup presenterGroup) {
        super.setPresenter(presenterGroup);
    }

    public /* bridge */ /* synthetic */ void setTitle(String str) {
        super.setTitle(str);
    }

    public AbsBaseBizFragment() {
        preInject();
    }

    /* access modifiers changed from: protected */
    public ComponentStatus checkComponentStatus(String str) {
        return ComponentFactory.get().checkComponentStatus(getContext(), currentBID(), str, currentPageId());
    }

    /* access modifiers changed from: protected */
    public void inflateViewlessComponents(String... strArr) {
        for (String inflateComponent : strArr) {
            inflateComponent(inflateComponent, (ViewGroup) null, (ViewGroup.LayoutParams) null);
        }
    }

    /* access modifiers changed from: protected */
    public void inflateViewlessComponent(String str, Bundle bundle) {
        inflateComponent(str, (ViewGroup) null, (ViewGroup.LayoutParams) null, bundle, 0);
    }

    /* access modifiers changed from: protected */
    public <T extends IComponent> T inflateComponent(String str, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, Bundle bundle) {
        return inflateComponent(str, viewGroup, layoutParams, bundle, 0);
    }

    /* access modifiers changed from: protected */
    public <T extends IComponent> T inflateComponent(String str, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        return inflateComponent(str, viewGroup, layoutParams, (Bundle) null, 0);
    }

    /* access modifiers changed from: protected */
    public <T extends IComponent> T inflateComponent(String str, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        return inflateComponent(str, viewGroup, layoutParams, (Bundle) null, i);
    }

    /* access modifiers changed from: protected */
    public <T extends IComponent> T inflateComponent(String str, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, Bundle bundle, int i) {
        View view = null;
        if (TextUtils.isEmpty(str)) {
            CLog.m8709e(TAG + " component type is empty");
            return null;
        }
        T newComponent = newComponent(str);
        if (newComponent == null) {
            CLog.m8709e(TAG + " " + str + " component is null");
            return null;
        }
        initComponent(newComponent, str, viewGroup, bundle);
        IView view2 = newComponent.getView();
        if (view2 != null) {
            view = view2.getView();
            setViewCreatorIfNeeded(view2);
        } else {
            CLog.m8709e(TAG + " " + str + " IView is null");
        }
        if (view != null) {
            if (i > 0) {
                view.setId(i);
            }
            if (!(viewGroup == null || layoutParams == null)) {
                viewGroup.addView(view, layoutParams);
                onComponentAdded(viewGroup, str, newComponent);
            }
        } else {
            CLog.m8709e(TAG + " " + str + " IView.getView() is null");
        }
        IPresenter presenter = newComponent.getPresenter();
        if (presenter == null) {
            CLog.m8709e(TAG + " " + str + " presenter is null");
        } else if (this.mTopPresenter != null) {
            this.mTopPresenter.addChild(presenter);
        } else {
            CLog.m8709e(TAG + " " + str + "TopPresenter is null");
        }
        onComponentInflated(str, newComponent);
        return newComponent;
    }

    private <T extends IComponent> T newComponent(String str) {
        return ComponentFactory.get().newComponent(getContext(), currentBID(), str, currentPageId(), getComboType(), isEnableComponentConfig());
    }

    private <T extends IComponent> void initComponent(T t, String str, ViewGroup viewGroup, Bundle bundle) {
        String bid2Sid = BusinessRegistry.bid2Sid(currentBID());
        if (TextUtils.isEmpty(bid2Sid)) {
            bid2Sid = BusinessRegistry.bid2ParentSid(currentBID());
        }
        int currentPageId = currentPageId();
        BusinessContext businessContext = getBusinessContext();
        int currentComboType = currentComboType();
        int currentRole = currentRole();
        ComponentParams versionCode = ComponentParams.from(businessContext, bid2Sid, currentPageId, currentComboType).type(str).role(currentRole).scene(currentScene()).versionCode(currentVersionCode());
        versionCode.add((Activity) getActivity()).add((Fragment) this).add(bundle);
        CLog.m8708d("component init params is" + versionCode);
        t.init(versionCode, viewGroup);
        if (t instanceof IComponentGroup) {
            onComponentGroupInitFinished(str, (IComponentGroup) t);
        }
    }

    /* access modifiers changed from: protected */
    public int currentScene() {
        return currentPageId();
    }

    private void setViewCreatorIfNeeded(IView iView) {
        if (iView instanceof IViewContainer) {
            ((IViewContainer) iView).setComponentCreator(generateComponentCreator());
        }
    }

    /* access modifiers changed from: protected */
    public IViewContainer.IComponentCreator generateComponentCreator() {
        if (this.mViewCreator == null) {
            this.mViewCreator = new IViewContainer.IComponentCreator() {
                public IComponent newComponent(String str, ViewGroup viewGroup) {
                    return AbsBaseBizFragment.this.newComponent(str, viewGroup, (Bundle) null);
                }

                public IComponent newComponent(String str, ViewGroup viewGroup, Bundle bundle) {
                    return AbsBaseBizFragment.this.newComponent(str, viewGroup, bundle);
                }

                public IComponent inflateComponent(String str, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, Bundle bundle) {
                    return AbsBaseBizFragment.this.inflateComponent(str, viewGroup, layoutParams, bundle);
                }

                public void removeComponent(IComponent iComponent) {
                    AbsBaseBizFragment.this.removeComponent(iComponent);
                }
            };
        }
        return this.mViewCreator;
    }

    /* access modifiers changed from: private */
    public IComponent newComponent(String str, ViewGroup viewGroup, Bundle bundle) {
        View view = null;
        if (TextUtils.isEmpty(str)) {
            CLog.m8709e(TAG + " ViewContainer component type is empty");
            return null;
        }
        IComponent newComponent = newComponent(str);
        if (newComponent == null) {
            CLog.m8709e(TAG + " " + str + " ViewContainer component is null");
            return null;
        }
        initComponent(newComponent, str, viewGroup, bundle);
        IView view2 = newComponent.getView();
        if (view2 != null) {
            view = view2.getView();
            setViewCreatorIfNeeded(view2);
        } else {
            CLog.m8709e(TAG + " " + str + " ViewContainer IView is null");
        }
        if (view == null) {
            CLog.m8709e(TAG + " " + str + " ViewContainer IView.getView is null");
        }
        IPresenter presenter = newComponent.getPresenter();
        if (presenter == null || this.mTopPresenter == null) {
            CLog.m8709e(TAG + " " + str + " ViewContainer presenter is null" + presenter);
        } else {
            this.mTopPresenter.addChild(presenter);
        }
        return newComponent;
    }

    /* access modifiers changed from: private */
    public void removeComponent(IComponent iComponent) {
        if (iComponent != null) {
            if (!(iComponent.getView() == null || iComponent.getView().getView() == null || iComponent.getView().getView().getParent() == null)) {
                ((ViewGroup) iComponent.getView().getView().getParent()).removeView(iComponent.getView().getView());
            }
            if (!(this.mTopPresenter == null || iComponent.getPresenter() == null)) {
                this.mTopPresenter.removeChild(iComponent.getPresenter());
            }
            onComponentRemoved(iComponent);
        }
    }

    private void onComponentInflated(String str, IComponent iComponent) {
        this.mComponentHashMap.put(str, iComponent);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onComponentRemoved(com.didi.component.core.IComponent r5) {
        /*
            r4 = this;
            if (r5 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 0
            java.util.HashMap<java.lang.String, com.didi.component.core.IComponent> r1 = r4.mComponentHashMap
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x000e:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0027
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getValue()
            if (r3 != r5) goto L_0x000e
            java.lang.Object r5 = r2.getKey()
            r0 = r5
            java.lang.String r0 = (java.lang.String) r0
        L_0x0027:
            if (r0 == 0) goto L_0x002e
            java.util.HashMap<java.lang.String, com.didi.component.core.IComponent> r5 = r4.mComponentHashMap
            r5.remove(r0)
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.base.AbsBaseBizFragment.onComponentRemoved(com.didi.component.core.IComponent):void");
    }

    /* access modifiers changed from: protected */
    public IComponent findComponentByName(String str) {
        return this.mComponentHashMap.get(str);
    }

    /* access modifiers changed from: protected */
    public void onDestroyViewImpl() {
        super.onDestroyViewImpl();
        this.mComponentHashMap.clear();
    }

    public void onDecorateView(View view, View view2, String str, Context context, AttributeSet attributeSet) {
        onCreateView(view, str, context, attributeSet);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z = true;
        if (TextUtils.equals(str, Component.class.getName()) || TextUtils.equals(str, ComponentGroup.class.getName())) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.Component);
            String string = obtainStyledAttributes.getString(0);
            obtainStyledAttributes.recycle();
            IComponent inflateComponent = inflateComponent(string, (ViewGroup) null, (ViewGroup.LayoutParams) null, prepareExtraForComponent(string), 0);
            if (inflateComponent == null) {
                return null;
            }
            inject(string, inflateComponent);
            IComponentGroup onComponentAdded = onComponentAdded(view, string, inflateComponent);
            if (onComponentAdded != null && !onComponentAdded.autoInflateChildView()) {
                z = false;
            }
            if (inflateComponent.getView() != null) {
                View view2 = inflateComponent.getView().getView();
                if (!z) {
                    view2 = view2 instanceof ViewGroup ? new DelegateViewGroup(getContext(), (ViewGroup) view2) : new Component(context);
                }
                if (view2 == null) {
                    view2 = new Component(context);
                }
                tagComponentView(view2, new Pair(string, inflateComponent));
                return view2;
            }
        } else if (TextUtils.equals(str, ComponentStub.class.getName())) {
            try {
                Constructor<ComponentStub> declaredConstructor = ComponentStub.class.getDeclaredConstructor(new Class[]{Context.class, AttributeSet.class});
                declaredConstructor.setAccessible(true);
                ComponentStub newInstance = declaredConstructor.newInstance(new Object[]{getContext(), attributeSet});
                newInstance.setComponentCreator(generateComponentCreator());
                return newInstance;
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InstantiationException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    private void tagComponentView(View view, Pair<String, IComponent> pair) {
        view.setTag(R.string.tag_component_name, pair.first);
        view.setTag(R.string.tag_component, pair.second);
    }

    /* access modifiers changed from: private */
    public Pair<String, IComponent> getComponentFromTag(View view) {
        String str = (String) view.getTag(R.string.tag_component_name);
        IComponent iComponent = (IComponent) view.getTag(R.string.tag_component);
        if (TextUtils.isEmpty(str) || iComponent == null) {
            return null;
        }
        return new Pair<>(str, iComponent);
    }

    private IComponentGroup onComponentAdded(View view, String str, IComponent iComponent) {
        IComponentGroup iComponentGroup = null;
        while (view != null) {
            iComponentGroup = (IComponentGroup) view.getTag(R.string.tag_component);
            if (iComponentGroup != null || !(view.getParent() instanceof View)) {
                break;
            }
            view = (View) view.getParent();
        }
        if (iComponentGroup != null) {
            iComponentGroup.onChildComponentCreated(str, iComponent);
        }
        return iComponentGroup;
    }

    private void onComponentGroupInitFinished(String str, final IComponentGroup iComponentGroup) {
        View view;
        if (iComponentGroup != null && iComponentGroup.getView() != null && (view = iComponentGroup.getView().getView()) != null) {
            tagComponentView(view, new Pair(str, iComponentGroup));
            if (view instanceof ViewGroup) {
                traverse((ViewGroup) view, new ViewProcessor() {
                    public void process(View view) {
                        Pair access$200 = AbsBaseBizFragment.this.getComponentFromTag(view);
                        if (access$200 != null) {
                            iComponentGroup.onChildComponentCreated((String) access$200.first, (IComponent) access$200.second);
                        }
                    }
                });
            }
        }
    }

    private void traverse(ViewGroup viewGroup, ViewProcessor viewProcessor) {
        int childCount = viewGroup.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != null) {
                    viewProcessor.process(childAt);
                    if (childAt instanceof ViewGroup) {
                        traverse((ViewGroup) childAt, viewProcessor);
                    }
                }
            }
        }
    }

    private void preInject() {
        Inject inject;
        for (Field field : getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class) && (inject = (Inject) field.getAnnotation(Inject.class)) != null) {
                this.mComponentField.put(inject.value(), field);
            }
        }
    }

    private boolean inject(String str, IComponent iComponent) {
        Field field = this.mComponentField.get(str);
        if (field == null) {
            return false;
        }
        try {
            field.setAccessible(true);
            field.set(this, iComponent);
            return true;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static class DelegateViewGroup extends ViewGroup {
        private ViewGroup mHost;

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        public DelegateViewGroup(Context context, ViewGroup viewGroup) {
            super(context);
            this.mHost = viewGroup;
        }

        public void addView(View view, ViewGroup.LayoutParams layoutParams) {
            this.mHost.addView(view, layoutParams);
        }

        public void addView(View view) {
            this.mHost.addView(view);
        }

        public void addView(View view, int i) {
            this.mHost.addView(view, i);
        }

        public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
            this.mHost.addView(view, i, layoutParams);
        }

        public void addView(View view, int i, int i2) {
            this.mHost.addView(view, i, i2);
        }

        public Object getTag(int i) {
            return this.mHost.getTag(i);
        }

        public void setTag(int i, Object obj) {
            this.mHost.setTag(i, obj);
        }
    }
}
