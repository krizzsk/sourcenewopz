package com.jumio.core.scanpart;

import com.jumio.commons.camera.PreviewProperties;
import com.jumio.core.Controller;
import com.jumio.core.data.ScanMode;
import com.jumio.core.data.document.DocumentPart;
import com.jumio.core.extraction.ExtractionClient;
import com.jumio.core.model.InvokeOnUiThread;
import com.jumio.core.model.StaticModel;
import com.jumio.core.models.DocumentDataModel;
import com.jumio.core.models.IDScanPartModel;
import com.jumio.core.overlay.Overlay;
import com.jumio.core.plugins.C20007a;
import com.jumio.core.plugins.ExtractionPlugin;
import com.jumio.core.plugins.ScanPartPlugin;
import com.jumio.core.views.ScanView;
import com.jumio.sdk.credentials.JumioIDCredential;
import com.jumio.sdk.document.JumioDocumentType;
import com.jumio.sdk.document.JumioDocumentVariant;
import com.jumio.sdk.enums.JumioCameraFacing;
import com.jumio.sdk.enums.JumioScanSide;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.enums.JumioScanUpdate;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import com.jumio.sdk.scanpart.JumioScanPart;
import com.taxis99.R;
import jumio.core.C21338a;
import jumio.core.C21381t;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0017¨\u0006\u0013"}, mo175978d2 = {"Lcom/jumio/core/scanpart/IDScanPart;", "Lcom/jumio/core/scanpart/JVisionScanPart;", "Lcom/jumio/core/models/IDScanPartModel;", "Lcom/jumio/core/model/StaticModel;", "result", "", "onResult", "", "error", "onError", "Lcom/jumio/core/Controller;", "controller", "Lcom/jumio/sdk/credentials/JumioIDCredential;", "credential", "scanPartModel", "Lcom/jumio/sdk/interfaces/JumioScanPartInterface;", "scanPartInterface", "<init>", "(Lcom/jumio/core/Controller;Lcom/jumio/sdk/credentials/JumioIDCredential;Lcom/jumio/core/models/IDScanPartModel;Lcom/jumio/sdk/interfaces/JumioScanPartInterface;)V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: IDScanPart.kt */
public final class IDScanPart extends JVisionScanPart<IDScanPartModel> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IDScanPart(Controller controller, JumioIDCredential jumioIDCredential, IDScanPartModel iDScanPartModel, JumioScanPartInterface jumioScanPartInterface) {
        super(controller, jumioIDCredential, iDScanPartModel, jumioScanPartInterface);
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(jumioIDCredential, "credential");
        Intrinsics.checkNotNullParameter(iDScanPartModel, "scanPartModel");
        Intrinsics.checkNotNullParameter(jumioScanPartInterface, "scanPartInterface");
    }

    /* renamed from: a */
    public ExtractionPlugin mo163092a(ScanMode scanMode) {
        Intrinsics.checkNotNullParameter(scanMode, "scanMode");
        ExtractionPlugin extractionPlugin = (ExtractionPlugin) C20007a.m39594b(getScanPluginMode(scanMode));
        while (true) {
            if (extractionPlugin != null && extractionPlugin.isUsable(getController(), getScanPartModel())) {
                return extractionPlugin;
            }
            scanMode = mo163099q().getFallbackAfter(scanMode);
            C20007a.C20010c scanPluginMode = getScanPluginMode(scanMode);
            ((IDScanPartModel) getScanPartModel()).setMode(scanMode);
            extractionPlugin = (ExtractionPlugin) C20007a.m39594b(scanPluginMode);
        }
    }

    public void checkForAddon(Function1<? super JumioScanPart, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "complete");
        ScanPartPlugin scanPartPlugin = (ScanPartPlugin) getController().getPluginManager().mo175786a(C20007a.C20010c.NFC);
        boolean z = true;
        if (scanPartPlugin == null || !scanPartPlugin.isUsable(getController(), getScanPartModel())) {
            z = false;
        }
        if (z) {
            IDScanPartModel iDScanPartModel = new IDScanPartModel(JumioScanSide.NFC, ScanMode.NFC, ((IDScanPartModel) getScanPartModel()).getFormat(), ((IDScanPartModel) getScanPartModel()).getSelectionModel());
            iDScanPartModel.setDocumentData(((IDScanPartModel) getScanPartModel()).getDocumentData());
            function1.invoke(new JumioScanPart(scanPartPlugin.getScanPart(getController(), getCredential(), iDScanPartModel, getScanPartInterface())));
            ScanPart.sendScanStep$default(this, JumioScanStep.ADDON_SCAN_PART, (Object) null, (Object) null, 6, (Object) null);
            return;
        }
        function1.invoke(null);
    }

    public void fallback() {
        if (getHasFallback() && mo163134p() != null) {
            if (((IDScanPartModel) getScanPartModel()).getScanStep() == JumioScanStep.SCAN_VIEW || ((IDScanPartModel) getScanPartModel()).getScanStep() == JumioScanStep.STARTED) {
                super.fallback();
                ScanMode fallbackAfter = mo163099q().getFallbackAfter(((IDScanPartModel) getScanPartModel()).getMode());
                ExtractionClient l = mo163129l();
                if (l != null) {
                    l.setDataExtractionActive(false);
                }
                ExtractionClient l2 = mo163129l();
                if (l2 != null) {
                    l2.unsubscribe(this);
                }
                ExtractionClient l3 = mo163129l();
                if (l3 != null) {
                    l3.destroy();
                }
                ((IDScanPartModel) getScanPartModel()).setMode(fallbackAfter);
                mo163108a(mo163092a(fallbackAfter));
                ExtractionClient extractionClient = mo163131n().getExtractionClient(getController().getContext());
                extractionClient.configure(getController().getDataManager(), getScanPartModel());
                extractionClient.subscribe(this);
                ScanView p = mo163134p();
                extractionClient.setPreviewProperties(p == null ? null : p.getPreviewProperties$jumio_core_release());
                ScanView p2 = mo163134p();
                extractionClient.setExtractionArea(p2 == null ? null : p2.getExtractionArea$jumio_core_release());
                extractionClient.reinit();
                Unit unit = Unit.INSTANCE;
                mo163106a(extractionClient);
                if (mo163130m() != null) {
                    Overlay m = mo163130m();
                    if (m != null) {
                        m.setVisible(8);
                    }
                    mo163107a(mo163131n().getOverlay(getController().getContext()));
                    Overlay m2 = mo163130m();
                    if (m2 != null) {
                        ScanView p3 = mo163134p();
                        if (p3 != null) {
                            C21381t drawView$jumio_core_release = p3.getDrawView$jumio_core_release();
                            if (drawView$jumio_core_release != null) {
                                m2.addViews(drawView$jumio_core_release);
                            }
                            m2.setScanPart(getScanPartModel());
                            m2.calculate(p3.getExtractionArea$jumio_core_release());
                            m2.prepareDraw(p3.getCameraFacing() == JumioCameraFacing.FRONT);
                        }
                        m2.setVisible(0);
                    }
                }
                ScanView p4 = mo163134p();
                if (p4 != null) {
                    p4.update$jumio_core_release(false);
                }
                ExtractionClient l4 = mo163129l();
                if (l4 != null) {
                    l4.setDataExtractionActive(true);
                }
                ScanPart.sendUpdate$default(this, JumioScanUpdate.FALLBACK, (Object) null, 2, (Object) null);
            }
        }
    }

    public void finish() {
        super.finish();
        ((C21338a) getController().getDataManager().get(C21338a.class)).mo175778a((IDScanPartModel) getScanPartModel());
    }

    public boolean getHasFallback() {
        return mo163099q().hasFallbackAfter(((IDScanPartModel) getScanPartModel()).getMode());
    }

    @InvokeOnUiThread(true)
    public void onError(Throwable th) {
        super.onError(th);
    }

    /* renamed from: q */
    public final DocumentPart mo163099q() {
        return ((IDScanPartModel) getScanPartModel()).getSelectionModel().getVariant().getPart(((IDScanPartModel) getScanPartModel()).getSide());
    }

    /* renamed from: r */
    public final int mo163100r() {
        String isoCode = ((IDScanPartModel) getScanPartModel()).getSelectionModel().getCountry().getIsoCode();
        int hashCode = isoCode.hashCode();
        if (hashCode != 67572) {
            if (hashCode != 74606) {
                if (hashCode == 77382 && isoCode.equals("NLD")) {
                    return R.string.jumio_id_scan_prompt_redact_nld;
                }
            } else if (!isoCode.equals("KOR")) {
                return 0;
            } else {
                return R.string.jumio_id_scan_prompt_redact_kor;
            }
        } else if (isoCode.equals("DEU")) {
            if (((IDScanPartModel) getScanPartModel()).getSelectionModel().getDocumentType().getIdType() == JumioDocumentType.PASSPORT) {
                return R.string.jumio_id_scan_prompt_redact_deu_passport;
            }
            if (((IDScanPartModel) getScanPartModel()).getSelectionModel().getDocumentType().getIdType() == JumioDocumentType.ID_CARD) {
                if (((IDScanPartModel) getScanPartModel()).getSelectionModel().getVariant().getVariant() == JumioDocumentVariant.PLASTIC) {
                    return R.string.jumio_id_scan_prompt_redact_deu_id_plastic;
                }
                if (((IDScanPartModel) getScanPartModel()).getSelectionModel().getVariant().getVariant() == JumioDocumentVariant.PAPER) {
                    return R.string.jumio_id_scan_prompt_redact_deu_id_paper;
                }
            }
        }
        return 0;
    }

    public void reset() {
        ScanMode scanMode = mo163099q().getExtraction().get(0);
        Intrinsics.checkNotNullExpressionValue(scanMode, "documentPart.extraction[0]");
        ((IDScanPartModel) getScanPartModel()).setMode(scanMode);
        ((IDScanPartModel) getScanPartModel()).setDocumentData((DocumentDataModel) null);
        super.reset();
    }

    public void onResult(StaticModel staticModel) {
        ((IDScanPartModel) getScanPartModel()).setDocumentData(staticModel instanceof DocumentDataModel ? (DocumentDataModel) staticModel : new DocumentDataModel());
        super.onResult(staticModel);
    }

    /* renamed from: a */
    public void mo163093a(PreviewProperties previewProperties) {
        int r;
        Intrinsics.checkNotNullParameter(previewProperties, "properties");
        super.mo163093a(previewProperties);
        if (mo163099q().getMasking() && (r = mo163100r()) != 0) {
            sendUpdate(JumioScanUpdate.LEGAL_HINT, getController().getContext().getString(r));
        }
    }
}
