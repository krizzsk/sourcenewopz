package com.didi.component.business.data.form.listener;

import android.graphics.Rect;
import com.didi.component.business.data.form.listener.observer.CustomObserver;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarGroup;
import com.didi.travel.psnger.model.response.anycar.AnyCarPayModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarResponse;
import java.util.List;

public interface ConfirmListener {
    public static final int PAGE_CONFIRM_ADDRESS = 3;
    public static final int PAGE_ESTIMATE = 1;
    public static final int PAGE_NULL = 0;
    public static final int PAGE_UNABLE_CITY = 2;

    void addConfirmAddressObserver(ConfirmAddressListener confirmAddressListener);

    void addCustomObserver(CustomObserver customObserver);

    List<AnyCarEstimateItemModel> getAllCarItems();

    AnyCarResponse getAnyCarResponse();

    Rect getAnycarEstimtePanleRect();

    AnyCarPayModel getAnycarPayModel();

    List<ConfirmAddressListener> getConfirmAddressObservers();

    int getCurrentPage();

    List<CustomObserver> getCustomObservers();

    AnyCarEstimateItemModel getFirstSelectedItem();

    List<AnyCarGroup> getGroups();

    AnyCarEstimateItemModel getHitPreOrderItem();

    boolean getIsAnyCar();

    AnycarItemStatusListener getItemStatusListener();

    int getPreference();

    Rect getPreferenceRect();

    List<AnyCarEstimateItemModel> getSelectedAnyCarItems();

    AnyCarEstimateItemModel getSelectedSingleAnyCarItem();

    boolean isConfirmAddressPage();

    void setAllCarItems(List<AnyCarEstimateItemModel> list);

    void setAnyCarResponse(AnyCarResponse anyCarResponse);

    void setAnycarEstimteRect(Rect rect);

    void setAnycarPayModel(AnyCarPayModel anyCarPayModel);

    void setCurrentPage(int i);

    void setGroups(List<AnyCarGroup> list);

    void setHitPreOrderItem(AnyCarEstimateItemModel anyCarEstimateItemModel);

    void setIsAnyCar(boolean z);

    void setItemStatusLisener(AnycarItemStatusListener anycarItemStatusListener);

    void setPreference(int i);

    void setPreferenceRect(Rect rect);

    void setSelectedAnyCarItem(List<AnyCarEstimateItemModel> list);

    void setSelectedSingleAnyCarItem(AnyCarEstimateItemModel anyCarEstimateItemModel);

    @Deprecated
    void update(int i);

    void updateAlpha(float f);
}
