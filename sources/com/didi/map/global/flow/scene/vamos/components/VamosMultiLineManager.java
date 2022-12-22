package com.didi.map.global.flow.scene.vamos.components;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.flow.scene.vamos.model.VamosMultiLineModel;
import com.didi.map.global.flow.utils.ZIndexUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VamosMultiLineManager {

    /* renamed from: a */
    private Map f27060a;

    /* renamed from: b */
    private Context f27061b;
    public ICompLineContract mDriverHomeLine;
    public ICompLineContract mDriverPickupLine;
    public ICompLineContract mPaxLine;

    public VamosMultiLineManager(Map map, Context context) {
        this.f27060a = map;
        this.f27061b = context;
    }

    public void drawLine(VamosMultiLineModel vamosMultiLineModel) {
        if (vamosMultiLineModel != null) {
            if (vamosMultiLineModel.mPickUpPoints != null && vamosMultiLineModel.mPickUpPoints.size() > 0) {
                addOrUpdateDriverPickupLine(vamosMultiLineModel.mPickUpPoints, vamosMultiLineModel.mPickUpLineColor, (int) vamosMultiLineModel.mLineWidth);
            }
            if (vamosMultiLineModel.mHomePoints != null && vamosMultiLineModel.mHomePoints.size() > 0) {
                addOrUpdateDriverHomeLine(vamosMultiLineModel.mHomePoints, vamosMultiLineModel.mHomeLineColor, (int) vamosMultiLineModel.mLineWidth);
            }
            if (vamosMultiLineModel.mPaxPoints != null && vamosMultiLineModel.mPaxPoints.size() > 0) {
                addOrUpdatePaxLine(vamosMultiLineModel.mPaxPoints, vamosMultiLineModel.mPaxLineColor, (int) vamosMultiLineModel.mLineWidth);
            }
        }
    }

    public List<IMapElement> getAllLine() {
        ArrayList arrayList = new ArrayList();
        ICompLineContract iCompLineContract = this.mDriverPickupLine;
        if (iCompLineContract != null) {
            arrayList.addAll(iCompLineContract.getBestViewElements());
        }
        ICompLineContract iCompLineContract2 = this.mPaxLine;
        if (iCompLineContract2 != null) {
            arrayList.addAll(iCompLineContract2.getBestViewElements());
        }
        ICompLineContract iCompLineContract3 = this.mDriverHomeLine;
        if (iCompLineContract3 != null) {
            arrayList.addAll(iCompLineContract3.getBestViewElements());
        }
        return arrayList;
    }

    public void addOrUpdateDriverPickupLine(List<LatLng> list, int i, int i2) {
        if (this.f27060a != null && !CollectionUtil.isEmpty((Collection<?>) list) && this.f27061b != null) {
            LineParams lineParams = new LineParams(list, i, i2);
            lineParams.setZIndex(ZIndexUtil.getZIndex(7));
            ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_COMMON, this.f27060a, this.f27061b, lineParams);
            this.mDriverPickupLine = createLineComponent;
            createLineComponent.start();
        }
    }

    public void addOrUpdatePaxLine(List<LatLng> list, int i, int i2) {
        if (this.f27060a != null && !CollectionUtil.isEmpty((Collection<?>) list) && this.f27061b != null) {
            LineParams lineParams = new LineParams(list, i, i2);
            lineParams.setZIndex(ZIndexUtil.getZIndex(7));
            ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_COMMON, this.f27060a, this.f27061b, lineParams);
            this.mPaxLine = createLineComponent;
            createLineComponent.start();
        }
    }

    public void addOrUpdateDriverHomeLine(List<LatLng> list, int i, int i2) {
        if (this.f27060a != null && !CollectionUtil.isEmpty((Collection<?>) list) && this.f27061b != null) {
            LineParams lineParams = new LineParams(list, i, i2);
            lineParams.setZIndex(ZIndexUtil.getZIndex(7));
            ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_COMMON, this.f27060a, this.f27061b, lineParams);
            this.mDriverHomeLine = createLineComponent;
            createLineComponent.start();
        }
    }

    public void removeAllLine() {
        if (this.f27060a != null) {
            ICompLineContract iCompLineContract = this.mDriverPickupLine;
            if (iCompLineContract != null) {
                iCompLineContract.destroy();
                this.mDriverPickupLine = null;
            }
            ICompLineContract iCompLineContract2 = this.mPaxLine;
            if (iCompLineContract2 != null) {
                iCompLineContract2.destroy();
                this.mPaxLine = null;
            }
            ICompLineContract iCompLineContract3 = this.mDriverHomeLine;
            if (iCompLineContract3 != null) {
                iCompLineContract3.destroy();
                this.mDriverHomeLine = null;
            }
        }
    }
}
