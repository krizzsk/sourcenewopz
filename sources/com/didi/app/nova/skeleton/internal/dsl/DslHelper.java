package com.didi.app.nova.skeleton.internal.dsl;

import android.view.View;
import com.didi.app.nova.skeleton.Component;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.tools.TraceUtil;
import com.didi.soda.nova.skeleton.dsl.DslComponent;
import com.didi.soda.nova.skeleton.dsl.ResolveDslResult;
import com.didi.soda.nova.skeleton.dsl.annotations.ComponentMvpDsl;
import com.didi.soda.nova.skeleton.dsl.annotations.ComponentMvvmDsl;
import com.didi.soda.nova.skeleton.dsl.annotations.MvpPageDsl;
import com.didi.soda.nova.skeleton.dsl.annotations.MvvmPageDsl;
import com.didi.sofa.utils.Reflection.MethodUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class DslHelper {

    /* renamed from: a */
    private static final String f8486a = "DslHelper";

    /* renamed from: b */
    private static final Map<String, Class<?>> f8487b = new LinkedHashMap();

    /* renamed from: c */
    private static final Map<String, Class<?>> f8488c = new LinkedHashMap();

    public static ResolveDslResult getPageDslInfo(Class<? extends Page> cls) {
        if (cls.getAnnotation(MvpPageDsl.class) == null && cls.getAnnotation(MvvmPageDsl.class) == null) {
            return null;
        }
        String name = cls.getName();
        if (name.startsWith("android.") || name.startsWith("java.")) {
            TraceUtil.trace(f8486a, "MISS: Reached framework class. Abandoning search.");
            return null;
        }
        try {
            Class<?> cls2 = f8487b.get(name);
            if (cls2 == null) {
                cls2 = Class.forName(name + "_SkeletonPageDsl");
                f8487b.put(name, cls2);
            }
            return (ResolveDslResult) MethodUtils.invokeStaticMethod(cls2, "getPageDslInfo", new Object[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public static List<Component> newPageComponents(Class<? extends Page> cls, ResolveDslResult resolveDslResult, View view) {
        if (!(resolveDslResult == null || resolveDslResult.components == null || resolveDslResult.components.size() == 0)) {
            String name = cls.getName();
            if (name.startsWith("android.") || name.startsWith("java.")) {
                TraceUtil.trace(f8486a, "MISS: Reached framework class. Abandoning search.");
            } else {
                try {
                    Class<?> cls2 = f8487b.get(name);
                    if (cls2 == null) {
                        cls2 = Class.forName(name + "_SkeletonPageDsl");
                        f8487b.put(name, cls2);
                    }
                    Object[] objArr = {resolveDslResult.components, view};
                    ArrayList arrayList = new ArrayList();
                    for (DslComponent dslComponent : (List) MethodUtils.invokeStaticMethod(cls2, "newComponents", objArr)) {
                        arrayList.add((Component) dslComponent);
                    }
                    return arrayList;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    return null;
                } catch (NoSuchMethodException e2) {
                    e2.printStackTrace();
                    return null;
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                    return null;
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace();
                    return null;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return null;
                }
            }
        }
        return null;
    }

    public static ResolveDslResult getComponentDslInfo(Class<? extends Component> cls) {
        if (cls.getAnnotation(ComponentMvpDsl.class) == null && cls.getAnnotation(ComponentMvvmDsl.class) == null) {
            return null;
        }
        String name = cls.getName();
        if (name.startsWith("android.") || name.startsWith("java.")) {
            TraceUtil.trace(f8486a, "MISS: Reached framework class. Abandoning search.");
            return null;
        }
        try {
            Class<?> cls2 = f8488c.get(name);
            if (cls2 == null) {
                cls2 = Class.forName(name + "_SkeletonComponentDsl");
                f8488c.put(name, cls2);
            }
            return (ResolveDslResult) MethodUtils.invokeStaticMethod(cls2, "getComponentDslInfo", new Object[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }
}
