package com.didi.component.mapflow.infowindow.factory;

import android.content.Context;
import com.didi.component.mapflow.infowindow.model.DepartureModel;
import com.didi.component.mapflow.infowindow.model.EditWithTipsModel;
import com.didi.component.mapflow.infowindow.model.NewWaitArrivalWithTipsModel;
import com.didi.component.mapflow.infowindow.model.OneMessageModel;
import com.didi.component.mapflow.infowindow.widget.DepartureInfoWindow;
import com.didi.component.mapflow.infowindow.widget.EditInfoWindow;
import com.didi.component.mapflow.infowindow.widget.FindCarCountdownInfoWindowV2;
import com.didi.component.mapflow.infowindow.widget.NewWaitArrivalInfoWindow;
import com.didi.component.mapflow.infowindow.widget.OneLineInfoWindow;
import com.didi.component.mapflow.infowindow.widget.TwoLineDepartureInfoWindow;

public class InfoWindowViewFactory {
    public static DepartureInfoWindow getInfoWindowView(Context context, DepartureModel departureModel) {
        DepartureInfoWindow departureInfoWindow;
        if (departureModel == null) {
            return null;
        }
        if (departureModel.isLeftTwoLine()) {
            departureInfoWindow = new TwoLineDepartureInfoWindow(context);
        } else {
            departureInfoWindow = new DepartureInfoWindow(context);
        }
        departureInfoWindow.setData(departureModel);
        return departureInfoWindow;
    }

    public static OneLineInfoWindow getInfoWindowView(Context context, OneMessageModel oneMessageModel) {
        if (oneMessageModel == null) {
            return null;
        }
        OneLineInfoWindow oneLineInfoWindow = new OneLineInfoWindow(context);
        oneLineInfoWindow.setData(oneMessageModel);
        return oneLineInfoWindow;
    }

    public static EditInfoWindow getInfoWindowView(Context context, EditWithTipsModel editWithTipsModel) {
        if (editWithTipsModel == null) {
            return null;
        }
        EditInfoWindow editInfoWindow = new EditInfoWindow(context);
        editInfoWindow.setData(editWithTipsModel);
        return editInfoWindow;
    }

    public static FindCarCountdownInfoWindowV2 getInfoWindowViewV2(Context context) {
        return new FindCarCountdownInfoWindowV2(context);
    }

    public static NewWaitArrivalInfoWindow getNewWaitArrivalInfoWindow(Context context, NewWaitArrivalWithTipsModel newWaitArrivalWithTipsModel) {
        if (newWaitArrivalWithTipsModel == null) {
            return null;
        }
        NewWaitArrivalInfoWindow newWaitArrivalInfoWindow = new NewWaitArrivalInfoWindow(context);
        newWaitArrivalInfoWindow.setData(newWaitArrivalWithTipsModel);
        return newWaitArrivalInfoWindow;
    }
}
