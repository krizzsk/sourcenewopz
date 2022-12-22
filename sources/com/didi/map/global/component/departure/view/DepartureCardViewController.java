package com.didi.map.global.component.departure.view;

import android.content.Context;
import android.view.View;
import com.didi.map.global.component.departure.DepartureCompParams;
import com.didi.map.global.component.departure.manager.DepartureOmegaManager;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.model.DepartureFenceOptions;
import com.didi.map.global.component.departure.model.DeparturePickupSpotState;
import com.didi.map.global.component.departure.model.SPoi;
import com.didi.map.global.component.departure.view.ITerminalView;
import com.didi.map.global.component.departure.view.ITerminalWelcomeView;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.poi.FenceInfo;

public class DepartureCardViewController {

    /* renamed from: a */
    private Context f25308a;

    /* renamed from: b */
    private DepartureFenceOptions f25309b;

    /* renamed from: c */
    private ITerminalView f25310c;

    /* renamed from: d */
    private ITerminalWelcomeView f25311d;

    /* renamed from: e */
    private ITerminalView.Callback f25312e;

    /* renamed from: f */
    private ITerminalWelcomeView.Callback f25313f;

    /* renamed from: g */
    private DepartureCompParams f25314g;

    /* renamed from: h */
    private DeparturePickupSpotState f25315h;

    /* renamed from: i */
    private int f25316i = 0;

    /* renamed from: j */
    private int f25317j = 0;

    /* renamed from: k */
    private DepartureOmegaManager f25318k;

    public DepartureCardViewController(Context context, DepartureCompParams departureCompParams) {
        this.f25308a = context;
        this.f25314g = departureCompParams;
        this.f25309b = departureCompParams.getFenceOptions();
        this.f25315h = new DeparturePickupSpotState();
        DepartureFenceOptions departureFenceOptions = this.f25309b;
        if (departureFenceOptions != null) {
            this.f25316i = departureFenceOptions.cardWizardStart;
            this.f25317j = this.f25309b.cardStyle;
        }
    }

    public void setOmegaManager(DepartureOmegaManager departureOmegaManager) {
        this.f25318k = departureOmegaManager;
    }

    public void setTerminalViewCallback(ITerminalView.Callback callback) {
        this.f25312e = callback;
    }

    public void setWelcomeViewCallback(ITerminalWelcomeView.Callback callback) {
        this.f25313f = callback;
    }

    public boolean isWelcomeViewValid() {
        ITerminalWelcomeView iTerminalWelcomeView = this.f25311d;
        return iTerminalWelcomeView != null && iTerminalWelcomeView.isValid() && this.f25316i == 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.f25314g;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isTerminalViewValid() {
        /*
            r1 = this;
            com.didi.map.global.component.departure.view.ITerminalView r0 = r1.f25310c
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isValid()
            if (r0 == 0) goto L_0x0016
            com.didi.map.global.component.departure.DepartureCompParams r0 = r1.f25314g
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isTerminalViewVisible()
            if (r0 == 0) goto L_0x0016
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.departure.view.DepartureCardViewController.isTerminalViewValid():boolean");
    }

    public boolean isTerminal() {
        ITerminalView iTerminalView = this.f25310c;
        return iTerminalView != null && iTerminalView.isValid() && this.f25310c.isTerminal();
    }

    public boolean isValidAndTerminal() {
        return isTerminalViewValid() && isTerminal();
    }

    public boolean hasTerminalView() {
        return this.f25310c != null;
    }

    public SPoi getSelectedTerminalArea() {
        ITerminalView iTerminalView = this.f25310c;
        if (iTerminalView != null) {
            return iTerminalView.getSelectedTerminalArea();
        }
        return null;
    }

    public View getDepartureCardView() {
        DeparturePickupSpotState departurePickupSpotState;
        if (this.f25309b == null) {
            return null;
        }
        View a = m18115a();
        if (a != null) {
            return a;
        }
        if (this.f25309b.cardWizardStart != 1 || ((departurePickupSpotState = this.f25315h) != null && departurePickupSpotState.isValid() && this.f25315h.isChecked())) {
            return m18118b();
        }
        return null;
    }

    /* renamed from: a */
    private View m18115a() {
        ITerminalWelcomeView iTerminalWelcomeView;
        DepartureFenceOptions departureFenceOptions = this.f25309b;
        if (departureFenceOptions == null || departureFenceOptions.cardWizardStart != 2 || (iTerminalWelcomeView = this.f25311d) == null) {
            return null;
        }
        return iTerminalWelcomeView.getView();
    }

    /* renamed from: b */
    private View m18118b() {
        ITerminalView iTerminalView = this.f25310c;
        if (iTerminalView != null) {
            return iTerminalView.getView();
        }
        return null;
    }

    public void setSelectedTerminalArea(SPoi sPoi) {
        ITerminalView iTerminalView = this.f25310c;
        if (iTerminalView != null) {
            iTerminalView.setSelectedTerminalArea(sPoi);
        }
    }

    public void performSelectedArea(SPoi sPoi, RpcPoi rpcPoi) {
        ITerminalView iTerminalView = this.f25310c;
        if (iTerminalView != null) {
            iTerminalView.performSelectedArea(sPoi, rpcPoi);
        }
    }

    public void setSelectedDeparture(RpcPoi rpcPoi) {
        ITerminalView iTerminalView = this.f25310c;
        if (iTerminalView != null) {
            iTerminalView.setSelectedDeparture(rpcPoi);
        }
    }

    public void setData(DepartureAddress departureAddress, FenceInfo fenceInfo, RpcPoi rpcPoi) {
        m18117a(fenceInfo);
        m18116a(departureAddress, rpcPoi);
        boolean z = true;
        if (this.f25316i != 1 || !isTerminalViewValid()) {
            z = false;
        }
        DeparturePickupSpotState departurePickupSpotState = this.f25315h;
        if (departurePickupSpotState != null) {
            departurePickupSpotState.setValid(z);
        }
    }

    public void setPickupSpotChecked(boolean z) {
        DeparturePickupSpotState departurePickupSpotState = this.f25315h;
        if (departurePickupSpotState != null) {
            departurePickupSpotState.setChecked(z);
        }
    }

    public boolean isWaitCheckPickupSpot() {
        DeparturePickupSpotState departurePickupSpotState = this.f25315h;
        return departurePickupSpotState != null && !departurePickupSpotState.isChecked() && this.f25315h.isValid();
    }

    /* renamed from: a */
    private void m18117a(FenceInfo fenceInfo) {
        if (this.f25316i == 2) {
            if (this.f25311d == null) {
                this.f25311d = TerminalViewFactory.createTerminalWelcomeView(this.f25308a, this.f25313f);
            }
            ITerminalWelcomeView iTerminalWelcomeView = this.f25311d;
            if (iTerminalWelcomeView != null) {
                iTerminalWelcomeView.setData(fenceInfo);
            }
        }
    }

    /* renamed from: a */
    private void m18116a(DepartureAddress departureAddress, RpcPoi rpcPoi) {
        if (this.f25310c == null) {
            this.f25310c = TerminalViewFactory.createTerminalView(this.f25308a, this.f25312e);
        }
        ITerminalView iTerminalView = this.f25310c;
        if (iTerminalView != null) {
            iTerminalView.setCardStyle(this.f25317j);
            ITerminalView iTerminalView2 = this.f25310c;
            boolean z = true;
            if (this.f25317j != 1) {
                z = false;
            }
            iTerminalView2.setShowBroadOtherInAreaCard(z);
            this.f25310c.setData(departureAddress != null ? departureAddress.getSpecialPois() : null);
            this.f25310c.setSelectedDeparture(rpcPoi);
            refreshTerminalCardViewSubNotice(departureAddress);
        }
    }

    public void refreshTerminalCardViewSubNotice(DepartureAddress departureAddress) {
        if (this.f25310c == null) {
            return;
        }
        if (departureAddress == null || departureAddress.getExtendInfo() == null || isTerminal()) {
            this.f25310c.setPickupPoiNotice("");
        } else {
            this.f25310c.setPickupPoiNotice(departureAddress.getExtendInfo().getMainNoticeTitle());
        }
    }
}
