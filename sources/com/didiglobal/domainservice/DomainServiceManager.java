package com.didiglobal.domainservice;

import android.content.Context;
import android.os.Bundle;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.domainservice.model.AbsDomainSuffixModel;
import com.didiglobal.domainservice.utils.ELog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DomainServiceManager {

    /* renamed from: b */
    private static DomainServiceManager f50035b = new DomainServiceManager();

    /* renamed from: a */
    private Map<Class, LinkedHashMap<String, Object>> f50036a = new HashMap();

    private DomainServiceManager() {
    }

    public static DomainServiceManager getInstance() {
        return f50035b;
    }

    public void initService() {
        this.f50036a.clear();
        loadDomainService();
        loadDomainFilter();
        loadDomainSwitchConds();
    }

    public void initService(Context context) {
        ELog.init(context);
        initService();
    }

    public <T> void loadServiceByType(Class<T> cls) {
        String str;
        ServiceLoader<S> load = ServiceLoader.load(cls);
        if (load == null) {
            ELog.log("load service: " + cls.getName() + " failed!");
            return;
        }
        if (!this.f50036a.containsKey(cls)) {
            this.f50036a.put(cls, new LinkedHashMap());
        }
        LinkedHashMap linkedHashMap = this.f50036a.get(cls);
        Iterator<S> it = load.iterator();
        int i = 0;
        while (it.hasNext()) {
            S next = it.next();
            ELog.log("  load service found: " + next);
            ServiceProvider serviceProvider = (ServiceProvider) next.getClass().getAnnotation(ServiceProvider.class);
            if (serviceProvider != null) {
                str = serviceProvider.alias();
            } else {
                str = "unknown" + i;
            }
            i++;
            linkedHashMap.put(str, next);
        }
    }

    public void loadDomainService() {
        loadServiceByType(IDomainService.class);
    }

    public void loadDomainFilter() {
        loadServiceByType(IDomainFilter.class);
    }

    public void loadDomainSwitchConds() {
        loadServiceByType(IDomainSwitchCondition.class);
    }

    public Set<IDomainFilter> getDomainFilter() {
        return getServiceInSetByType(IDomainFilter.class);
    }

    public List<IDomainFilter> getDomainFilterInList() {
        return getServiceInListByType(IDomainFilter.class);
    }

    public List<IDomainSwitchCondition> getDomainCondsInList() {
        return getServiceInListByType(IDomainSwitchCondition.class);
    }

    public <T> Set<T> getServiceInSetByType(Class<T> cls) {
        HashSet hashSet = new HashSet();
        if (!this.f50036a.containsKey(cls)) {
            ELog.log("no service: " + cls + " found!");
            return hashSet;
        }
        LinkedHashMap linkedHashMap = this.f50036a.get(cls);
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            for (String str : linkedHashMap.keySet()) {
                Object obj = linkedHashMap.get(str);
                Class<T>[] interfaces = obj.getClass().getInterfaces();
                int length = interfaces.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (interfaces[i] == cls) {
                        hashSet.add(obj);
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        return hashSet;
    }

    public <T> List<T> getServiceInListByType(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        if (!this.f50036a.containsKey(cls)) {
            ELog.log("no service: " + cls + " found!");
            return arrayList;
        }
        LinkedHashMap linkedHashMap = this.f50036a.get(cls);
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            for (String str : linkedHashMap.keySet()) {
                Object obj = linkedHashMap.get(str);
                Class<T>[] interfaces = obj.getClass().getInterfaces();
                int length = interfaces.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (interfaces[i] == cls) {
                        arrayList.add(obj);
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        return arrayList;
    }

    public void notifyAllDomainChange(String str) {
        if (!this.f50036a.containsKey(IDomainService.class)) {
            ELog.log("try to invoke IDomainService but not found!");
            return;
        }
        LinkedHashMap linkedHashMap = this.f50036a.get(IDomainService.class);
        for (String str2 : linkedHashMap.keySet()) {
            Object obj = linkedHashMap.get(str2);
            if (obj instanceof IDomainService) {
                ((IDomainService) obj).onNotifyDomainChanged(str);
            }
        }
    }

    public void notifyDomainChangeById(String str, String str2) {
        if (!this.f50036a.containsKey(IDomainService.class)) {
            ELog.log("try to invoke IDomainService but not found!");
            return;
        }
        LinkedHashMap linkedHashMap = this.f50036a.get(IDomainService.class);
        if (linkedHashMap != null && linkedHashMap.containsKey(str2)) {
            Object obj = linkedHashMap.get(str2);
            if (obj instanceof IDomainService) {
                ((IDomainService) obj).onNotifyDomainChanged(str);
            }
        }
    }

    public void notifyDomainSwitchEvent(int i, Bundle bundle) {
        List<IDomainService> serviceInListByType = getServiceInListByType(IDomainService.class);
        if (serviceInListByType != null && serviceInListByType.size() > 0) {
            for (IDomainService onNotifyDomainSwitchEvent : serviceInListByType) {
                onNotifyDomainSwitchEvent.onNotifyDomainSwitchEvent(i, bundle);
            }
        }
    }

    public void notifyCheckDomain(Bundle bundle) {
        notifyDomainSwitchEvent(0, bundle);
    }

    /* renamed from: a */
    private void m36049a(Context context, String str, Bundle bundle) {
        notifyAllDomainChange(str);
        notifyDomainSwitchEvent(1, bundle);
    }

    public String getDomainSuffix(Context context) {
        return DomainStore.getCacheDomainSuffix(context);
    }

    public String getDomainSuffix(Context context, String str) {
        return DomainStore.getCacheDomainSuffix(context, str);
    }

    public AbsDomainSuffixModel getDomainSuffixModel(Context context, String str) {
        return DomainStore.getCacheDomainSuffixModel(context, str);
    }

    public AbsDomainSuffixModel getDomainSuffixModel(Context context, String str, String str2) {
        return DomainStore.getCacheDomainSuffixModel(context, str, str2);
    }

    public void removeDomainSuffixModel(Context context, String str) {
        DomainStore.removeDomainSuffixModel(context, str);
    }

    public synchronized boolean cacheDomainSuffix(Context context, String str) {
        return DomainStore.refreshDomainSuffix(context, str);
    }

    public synchronized boolean cacheDomainSuffixModel(Context context, AbsDomainSuffixModel absDomainSuffixModel) {
        return DomainStore.refreshDomainSuffixModel(context, absDomainSuffixModel);
    }
}
