package edu.aku.hassannaqvi.wellnessscale.models;

import static edu.aku.hassannaqvi.wellnessscale.core.MainApp.PROJECT_NAME;
import static edu.aku.hassannaqvi.wellnessscale.core.MainApp._EMPTY_;

import android.database.Cursor;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.wellnessscale.BR;
import edu.aku.hassannaqvi.wellnessscale.contracts.TableContracts.FormsTable;
import edu.aku.hassannaqvi.wellnessscale.core.MainApp;


public class Form extends BaseObservable implements Observable {

    final String TAG = "Form";
    public String iStatus = _EMPTY_;
    public String iStatus96x = _EMPTY_;
    // FIELD VARIABLES
    public String a101= _EMPTY_;
    public String a102= _EMPTY_;
    public String a104= _EMPTY_;
    public String a105= _EMPTY_;
    public String a107= _EMPTY_;
    public String a103 = _EMPTY_;
    public String a110= _EMPTY_;

    transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();
    // FORM SECTIONS
    String sA = _EMPTY_;
    String sB = _EMPTY_;
    String sC = _EMPTY_;
    String sD = _EMPTY_;
    String sE = _EMPTY_;
    String sF = _EMPTY_;
    String sG = _EMPTY_;
    String sH = _EMPTY_;
    // APP VARIABLES
    String projectName = PROJECT_NAME;
    // APP VARIABLES
    String id = _EMPTY_;
    String uid = _EMPTY_;
    String userName = _EMPTY_;
    String sysDate = _EMPTY_;
    String districtCode = _EMPTY_;
    String lhwCode = _EMPTY_;
    String kno = _EMPTY_;
    String sno = _EMPTY_;
    String deviceId = _EMPTY_;
    String deviceTag = _EMPTY_;
    String appver = _EMPTY_;
    String endTime = _EMPTY_;
    String synced = _EMPTY_;
    String syncDate = _EMPTY_;
    String entryType = _EMPTY_;
    String gpsLat = _EMPTY_;
    String gpsLng = _EMPTY_;
    String gpsDT = _EMPTY_;
    String gpsAcc = _EMPTY_;


    public Form() {

        setSysDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
//        setUserName(MainApp.user.getUserName());
//        setDeviceId(MainApp.deviceid);
//        setAppver(MainApp.appInfo.getAppVersion());
//        setAppver(MainApp.appInfo.getAppVersion());

    }

    public String getsA() {
        return sA;
    }

    public void setsA(String sA) {
        this.sA = sA;
    }

    public String getsB() {
        return sB;
    }

    public void setsB(String sB) {
        this.sB = sB;
    }

    public String getsC() {
        return sC;
    }

    public void setsC(String sC) {
        this.sC = sC;
    }

    public String getsD() {
        return sD;
    }

    public void setsD(String sD) {
        this.sD = sD;
    }

    public String getsE() {
        return sE;
    }

    public void setsE(String sE) {
        this.sE = sE;
    }

    public String getsF() {
        return sF;
    }

    public void setsF(String sF) {
        this.sF = sF;
    }

    public String getsG() {
        return sG;
    }

    public void setsG(String sG) {
        this.sG = sG;
    }

    public String getsH() {
        return sH;
    }

    public void setsH(String sH) {
        this.sH = sH;
    }

    @Bindable
    public String getA101() {
        return a101;
    }

    public void setA101(String a101) {
        this.a101 = a101;
        notifyChange(BR.a101);
    }

    @Bindable
    public String getA102() {
        return a102;
    }

    public void setA102(String a102) {
        this.a102 = a102;
        notifyChange(BR.a102);
    }
 @Bindable
    public String getA104() {
        return a104;
    }

    public void setA104(String a104) {
        this.a104 = a104;
        notifyChange(BR.a104);
    }
 @Bindable
    public String getA105() {
        return a105;
    }

    public void setA105(String a105) {
        this.a105 = a105;
        notifyChange(BR.a105);
    }
 @Bindable
    public String getA103() {
        return a103;
    }

    public void setA103(String a103) {
        this.a103 = a103;
        notifyChange(BR.a106);
    }
    
    @Bindable
    public String getA107() {
        return a107;
    }

    public void setA107(String a107) {
        this.a107 = a107;
        notifyChange(BR.a106);
    }
 @Bindable
    public String getA110() {
        return a110;
    }

    public void setA110(String a110) {
        this.a110 = a110;
        notifyChange(BR.a110);
    }


    synchronized void notifyChange(int propertyId) {
        if (propertyChangeRegistry == null) {
            propertyChangeRegistry = new PropertyChangeRegistry();
        }
        propertyChangeRegistry.notifyChange(this, propertyId);
    }

    @Override
    public synchronized void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        if (propertyChangeRegistry == null) {
            propertyChangeRegistry = new PropertyChangeRegistry();
        }
        propertyChangeRegistry.add(callback);

    }

    @Override
    public synchronized void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        if (propertyChangeRegistry != null) {
            propertyChangeRegistry.remove(callback);
        }
    }

    public void populateMeta() {

        setSysDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
       setUserName(MainApp.user.getUserName());
       setDeviceId(MainApp.deviceid);
       /*  //   setUuid(MainApp.form.getUid());  // not applicable in Form table
        setAppver(MainApp.appInfo.getAppVersion());*/
        setProjectName(PROJECT_NAME);

        setEntryType(String.valueOf(MainApp.entryType));

        //SECTION VARIABLES
        setDistrictCode(MainApp.selectedDistrict);
        setLhwCode(MainApp.selectedLHW);
        setKno(MainApp.selectedHousehold);

    }


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Bindable
    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
        notifyPropertyChanged(BR.districtCode);
    }

    @Bindable
    public String getLhwCode() {
        return lhwCode;
    }

    public void setLhwCode(String lhwCode) {
        this.lhwCode = lhwCode;
        notifyPropertyChanged(BR.lhwCode);
    }

    @Bindable
    public String getKno() {
        return kno;
    }

    public void setKno(String kno) {
        this.kno = kno;
        notifyPropertyChanged(BR.hhid);
    }

    @Bindable
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
        notifyPropertyChanged(BR.sno);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSysDate() {
        return sysDate;
    }

    public void setSysDate(String sysDate) {
        this.sysDate = sysDate;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceTag() {
        return deviceTag;
    }

    public void setDeviceTag(String deviceTag) {
        this.deviceTag = deviceTag;
    }

    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    public String getAppver() {
        return appver;
    }

    public void setAppver(String appver) {
        this.appver = appver;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSyncDate() {
        return syncDate;
    }

    public void setSyncDate(String syncDate) {
        this.syncDate = syncDate;
    }

    @Bindable
    public String getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
        notifyPropertyChanged(BR.gpsLat);
    }

    @Bindable
    public String getGpsLng() {
        return gpsLng;
    }

    public void setGpsLng(String gpsLng) {
        this.gpsLng = gpsLng;
        notifyPropertyChanged(BR.gpsLng);
    }

    @Bindable
    public String getGpsDT() {
        return gpsDT;
    }

    public void setGpsDT(String gpsDT) {
        this.gpsDT = gpsDT;
        notifyPropertyChanged(BR.gpsDT);
    }

    @Bindable
    public String getGpsAcc() {
        return gpsAcc;
    }

    public void setGpsAcc(String gpsAcc) {
        this.gpsAcc = gpsAcc;
        notifyPropertyChanged(BR.gpsAcc);
    }


    @Bindable
    public String getiStatus() {
        return iStatus;
    }

    public void setiStatus(String iStatus) {
        this.iStatus = iStatus;
        notifyPropertyChanged(BR.iStatus);
    }

    @Bindable
    public String getiStatus96x() {
        return iStatus96x;
    }

    public void setiStatus96x(String iStatus96x) {
        this.iStatus96x = iStatus96x;
        notifyPropertyChanged(BR.iStatus96x);
    }
    
/*



    @Bindable
    public String getA104() {
        return a104;
    }

    public void setA104(String a104) {
        this.a104 = a104;
        notifyPropertyChanged(BR.a104);
    }

    @Bindable
    public String getA105() {
        return a105;
    }

    public void setA105(String a105) {
        this.a105 = a105;
        notifyPropertyChanged(BR.a105);
    }

    @Bindable
    public String getA106() {
        return a106;
    }

    public void setA106(String a106) {
        this.a106 = a106;
        notifyPropertyChanged(BR.a106);
    }

    @Bindable
    public String getA107() {
        return a107;
    }

    public void setA107(String a107) {
        this.a107 = a107;
        notifyPropertyChanged(BR.a107);
    }

    @Bindable
    public String getA101() {
        return a101;
    }

    public void setA101(String a101) {
        this.a101 = a101;
        notifyPropertyChanged(BR.a101);
    }

    @Bindable
    public String getA102() {
        return a102;
    }

    public void setA102(String a102) {
        this.a102 = a102;
        notifyPropertyChanged(BR.a102);
    }

    @Bindable
    public String getA108() {
        return a108;
    }

    public void setA108(String a108) {
        this.a108 = a108;
        notifyPropertyChanged(BR.a108);
    }

    @Bindable
    public String getA103() {
        return a103;
    }

    public void setA103(String a103) {
        this.a103 = a103;
        notifyPropertyChanged(BR.a103);
    }

    @Bindable
    public String getA113() {
        return a113;
    }

    public void setA113(String a113) {
        this.a113 = a113;
        notifyPropertyChanged(BR.a113);
    }

    @Bindable
    public String getA109() {
        return a109;
    }

    public void setA109(String a109) {
        this.a109 = a109;
        notifyPropertyChanged(BR.a109);
    }

    @Bindable
    public String getA110() {
        return a110;
    }

    public void setA110(String a110) {
        this.a110 = a110;
        notifyPropertyChanged(BR.a110);
    }

    @Bindable
    public String getA111() {
        return a111;
    }

    public void setA111(String a111) {
        this.a111 = a111;
        notifyPropertyChanged(BR.a111);
    }

    @Bindable
    public String getA112() {
        return a112;
    }

    public void setA112(String a112) {
        this.a112 = a112;
        notifyPropertyChanged(BR.a112);
    }

    @Bindable
    public String getA11297() {
        return a11297;
    }

    public void setA11297(String a11297) {
        if (this.a11297.equals(a11297)) return;     //For all checkboxes
        this.a11297 = a11297;
        setA112(a11297.equals("97") ? "" : this.a112);
        notifyPropertyChanged(BR.a11297);
    }
*//*

    @Bindable
    public String getHh01() {
        return hh01;
    }

    public void setHh01(String hh01) {
        this.hh01 = hh01;
        notifyPropertyChanged(BR.hh01);
    }

    @Bindable
    public String getHh02() {
        return hh02;
    }

    public void setHh02(String hh02) {
        this.hh02 = hh02;
        notifyPropertyChanged(BR.hh02);
    }

    @Bindable
    public String getHh03() {
        return hh03;
    }

    public void setHh03(String hh03) {
        this.hh03 = hh03;
        notifyPropertyChanged(BR.hh03);
    }

    @Bindable
    public String getHh03a() {
        return hh03a;
    }

    public void setHh03a(String hh03a) {
        this.hh03a = hh03a;
        notifyPropertyChanged(BR.hh03a);
    }

    @Bindable
    public String getHh04() {
        return hh04;
    }

    public void setHh04(String hh04) {
        this.hh04 = hh04;
        notifyPropertyChanged(BR.hh04);
    }

    @Bindable
    public String getHh04a() {
        return hh04a;
    }

    public void setHh04a(String hh04a) {
        this.hh04a = hh04a;
        notifyPropertyChanged(BR.hh04a);
    }

    @Bindable
    public String getHh05() {
        return hh05;
    }

    public void setHh05(String hh05) {
        this.hh05 = hh05;
        notifyPropertyChanged(BR.hh05);
    }

    @Bindable
    public String getHh06() {
        return hh06;
    }

    public void setHh06(String hh06) {
        this.hh06 = hh06;
        notifyPropertyChanged(BR.hh06);
    }

    @Bindable
    public String getHh07() {
        return hh07;
    }

    public void setHh07(String hh07) {
        this.hh07 = hh07;
        notifyPropertyChanged(BR.hh07);
    }

    @Bindable
    public String getHh08() {
        return hh08;
    }

    public void setHh08(String hh08) {
        this.hh08 = hh08;
        notifyPropertyChanged(BR.hh08);
    }

    @Bindable
    public String getHh09() {
        return hh09;
    }

    public void setHh09(String hh09) {
        this.hh09 = hh09;
        notifyPropertyChanged(BR.hh09);
    }

    @Bindable
    public String getHh10() {
        return hh10;
    }

    public void setHh10(String hh10) {
        this.hh10 = hh10;
        notifyPropertyChanged(BR.hh10);
    }

    @Bindable
    public String getHh11() {
        return hh11;
    }

    public void setHh11(String hh11) {
        this.hh11 = hh11;
        notifyPropertyChanged(BR.hh11);
    }

    @Bindable
    public String getHh12() {
        return hh12;
    }

    public void setHh12(String hh12) {
        this.hh12 = hh12;
        notifyPropertyChanged(BR.hh12);
    }

    @Bindable
    public String getHh13() {
        return hh13;
    }

    public void setHh13(String hh13) {
        this.hh13 = hh13;
        notifyPropertyChanged(BR.hh13);
    }

    @Bindable
    public String getHh18() {
        return hh18;
    }

    public void setHh18(String hh18) {
        this.hh18 = hh18;
        setHh13a(hh18.equals("1") ? this.hh13a : "");
        setHh14(hh18.equals("1") ? this.hh14 : "");
        setHh15(hh18.equals("1") ? this.hh15 : "");
        setHh16a(hh18.equals("1") ? this.hh16a : "");
        setHh16b(hh18.equals("1") ? this.hh16b : "");
        setHh19(hh18.equals("1") ? this.hh19 : "");
        setHh20(hh18.equals("1") ? this.hh20 : "");
        setHh20a(hh18.equals("1") ? this.hh20a : "");
        notifyPropertyChanged(BR.hh18);
    }

    @Bindable
    public String getHh13a() {
        return hh13a;
    }

    public void setHh13a(String hh13a) {
        this.hh13a = hh13a;
        notifyPropertyChanged(BR.hh13a);
    }

    @Bindable
    public String getHh14() {
        return hh14;
    }

    public void setHh14(String hh14) {
        this.hh14 = hh14;
        notifyPropertyChanged(BR.hh14);
    }

    @Bindable
    public String getHh15() {
        return hh15;
    }

    public void setHh15(String hh15) {
        this.hh15 = hh15;
        setHh16a(hh15.equals("2") ? this.hh16a : "");
        setHh16b(hh15.equals("2") ? this.hh16b : "");
        notifyPropertyChanged(BR.hh15);
    }

    @Bindable
    public String getHh16a() {
        return hh16a;
    }

    public void setHh16a(String hh16a) {
        this.hh16a = hh16a;
        notifyPropertyChanged(BR.hh16a);
    }

    @Bindable
    public String getHh16b() {
        return hh16b;
    }

    public void setHh16b(String hh16b) {
        this.hh16b = hh16b;
        notifyPropertyChanged(BR.hh16b);
    }

    @Bindable
    public String getHh19() {
        return hh19;
    }

    public void setHh19(String hh19) {
        this.hh19 = hh19;
        notifyPropertyChanged(BR.hh19);
    }

    @Bindable
    public String getHh19a() {
        return hh19a;
    }

    public void setHh19a(String hh19a) {
        this.hh19a = hh19a;
        notifyPropertyChanged(BR.hh19a);
    }

    @Bindable
    public String getHh19b() {
        return hh19b;
    }

    public void setHh19b(String hh19b) {
        this.hh19b = hh19b;
        notifyPropertyChanged(BR.hh19b);
    }

    @Bindable
    public String getHh20() {
        return hh20;
    }

    public void setHh20(String hh20) {
        this.hh20 = hh20;
        setHh20a(hh20.equals("1") ? this.hh20a : "");
        notifyPropertyChanged(BR.hh20);
    }

    @Bindable
    public String getHh20a() {
        return hh20a;
    }

    public void setHh20a(String hh20a) {
        this.hh20a = hh20a;
        notifyPropertyChanged(BR.hh20a);
    }

 

    @Bindable
    public String getsHH() {
        return sHH;
    }

    @Bindable
    public String getsCH() {
        return sCH;
    }

    @Bindable
    public String getsSS() {
        return sSS;
    }

    @Bindable
    public String getsCB() {
        return sCB;
    }

    @Bindable
    public String getsIM() {
        return sIM;
    }

    @Bindable
    public String getSs01() {
        return ss01;
    }

    public void setSs01(String ss01) {
        this.ss01 = ss01;
        setSs01xx(ss01.equals("96") ? this.ss01xx : ""); // for all skips, mention all skipped questions
        notifyPropertyChanged(BR.ss01);
    }

    @Bindable
    public String getSs01xx() {
        return ss01xx;
    }

    public void setSs01xx(String ss01xx) {
        this.ss01xx = ss01xx;
        notifyPropertyChanged(BR.ss01xx);
    }

    @Bindable
    public String getSs02() {
        return ss02;
    }

    public void setSs02(String ss02) {
        this.ss02 = ss02;
        setSs02xx(ss02.equals("96") ? this.ss02xx : ""); // for all skips, mention all skipped questions
        notifyPropertyChanged(BR.ss02);
    }

    @Bindable
    public String getSs02xx() {
        return ss02xx;
    }

    public void setSs02xx(String ss02xx) {
        this.ss02xx = ss02xx;
        notifyPropertyChanged(BR.ss02xx);
    }

    @Bindable
    public String getSs03() {
        return ss03;
    }

    public void setSs03(String ss03) {
        this.ss03 = ss03;
        setSs03xx(ss03.equals("96") ? this.ss03xx : ""); // for all skips, mention all skipped questions
        notifyPropertyChanged(BR.ss03);
    }

    @Bindable
    public String getSs03xx() {
        return ss03xx;
    }

    public void setSs03xx(String ss03xx) {
        this.ss03xx = ss03xx;
        notifyPropertyChanged(BR.ss03xx);
    }

    @Bindable
    public String getSs04() {
        return ss04;
    }

    public void setSs04(String ss04) {
        this.ss04 = ss04;
        setSs05(ss04.equals("1") ? this.ss05 : "");
        notifyPropertyChanged(BR.ss04);
    }

    @Bindable
    public String getSs05() {
        return ss05;
    }

    public void setSs05(String ss05) {
        this.ss05 = ss05;
        setSs05xx(ss05.equals("96") ? this.ss05xx : ""); // for all skips, mention all skipped questions
        notifyPropertyChanged(BR.ss05);
    }

    @Bindable
    public String getSs05xx() {
        return ss05xx;
    }

    public void setSs05xx(String ss05xx) {
        this.ss05xx = ss05xx;
        notifyPropertyChanged(BR.ss05xx);
    }

    @Bindable
    public String getSs06() {
        return ss06;
    }

    public void setSs06(String ss06) {
        this.ss06 = ss06;
        setSs06xx(ss06.equals("96") ? this.ss06xx : ""); // for all skips, mention all skipped questions
        notifyPropertyChanged(BR.ss06);
    }

    @Bindable
    public String getSs06xx() {
        return ss06xx;
    }

    public void setSs06xx(String ss06xx) {
        this.ss06xx = ss06xx;
        notifyPropertyChanged(BR.ss06xx);
    }

    @Bindable
    public String getSs07() {
        return ss07;
    }

    public void setSs07(String ss07) {
        this.ss07 = ss07;
        setSs07xx(ss07.equals("96") ? this.ss07xx : ""); // for all skips, mention all skipped questions
        final boolean b = ss07.equals("8") || ss07.equals("9") || ss07.equals("96");
        setSs08(b ? "" : this.ss08);
        setSs09(b ? "" : this.ss09);
        setSs11(b ? "" : this.ss11);
        setSs12(b ? "" : this.ss12);
        notifyPropertyChanged(BR.ss07);
    }

    @Bindable
    public String getSs07xx() {
        return ss07xx;
    }

    public void setSs07xx(String ss07xx) {
        this.ss07xx = ss07xx;
        notifyPropertyChanged(BR.ss07xx);
    }

    @Bindable
    public String getSs08() {
        return ss08;
    }

    public void setSs08(String ss08) {
        this.ss08 = ss08;
        notifyPropertyChanged(BR.ss08);
    }

    @Bindable
    public String getSs09() {
        return ss09;
    }

    public void setSs09(String ss09) {
        this.ss09 = ss09;
        setSs11(ss09.equals("1") ? this.ss11 : "");
        setSs12(ss09.equals("1") ? this.ss12 : "");
        notifyPropertyChanged(BR.ss09);
    }

    @Bindable
    public String getSs11() {
        return ss11;
    }

    public void setSs11(String ss11) {
        this.ss11 = ss11;
        setSs12(ss11.equals("2") ? "" : this.ss12);
        notifyPropertyChanged(BR.ss11);
    }

    @Bindable
    public String getSs12() {
        return ss12;
    }

    public void setSs12(String ss12) {
        this.ss12 = ss12;
        setSs12hhx(ss12.equals("66") ? this.ss12hhx : ""); // for all skips, mention all skipped questions
        notifyPropertyChanged(BR.ss12);
    }

    @Bindable
    public String getSs12hhx() {
        return ss12hhx;
    }

    public void setSs12hhx(String ss12hhx) {
        this.ss12hhx = ss12hhx;
        notifyPropertyChanged(BR.ss12hhx);
    }

    @Bindable
    public String getSs13() {
        return ss13;
    }

    public void setSs13(String ss13) {
        this.ss13 = ss13;
        setSs13xx(ss13.equals("96") ? this.ss13xx : ""); // for all skips, mention all skipped questions
        notifyPropertyChanged(BR.ss13);
    }

    @Bindable
    public String getSs13xx() {
        return ss13xx;
    }

    public void setSs13xx(String ss13xx) {
        this.ss13xx = ss13xx;
        notifyPropertyChanged(BR.ss13xx);
    }

    @Bindable
    public String getSs14a() {
        return ss14a;
    }

    public void setSs14a(String ss14a) {
        this.ss14a = ss14a;
        notifyPropertyChanged(BR.ss14a);
    }

    @Bindable
    public String getSs14b() {
        return ss14b;
    }

    public void setSs14b(String ss14b) {
        this.ss14b = ss14b;
        notifyPropertyChanged(BR.ss14b);
    }

    @Bindable
    public String getSs14c() {
        return ss14c;
    }

    public void setSs14c(String ss14c) {
        this.ss14c = ss14c;
        notifyPropertyChanged(BR.ss14c);
    }

    @Bindable
    public String getSs14d() {
        return ss14d;
    }

    public void setSs14d(String ss14d) {
        this.ss14d = ss14d;
        notifyPropertyChanged(BR.ss14d);
    }

    @Bindable
    public String getSs14e() {
        return ss14e;
    }

    public void setSs14e(String ss14e) {
        this.ss14e = ss14e;
        notifyPropertyChanged(BR.ss14e);
    }

    @Bindable
    public String getSs14f() {
        return ss14f;
    }

    public void setSs14f(String ss14f) {
        this.ss14f = ss14f;
        notifyPropertyChanged(BR.ss14f);
    }

    @Bindable
    public String getSs14g() {
        return ss14g;
    }

    public void setSs14g(String ss14g) {
        this.ss14g = ss14g;
        notifyPropertyChanged(BR.ss14g);
    }

    @Bindable
    public String getSs14h() {
        return ss14h;
    }

    public void setSs14h(String ss14h) {
        this.ss14h = ss14h;
        notifyPropertyChanged(BR.ss14h);
    }

    @Bindable
    public String getSs14i() {
        return ss14i;
    }

    public void setSs14i(String ss14i) {
        this.ss14i = ss14i;
        notifyPropertyChanged(BR.ss14i);
    }

    @Bindable
    public String getSs14j() {
        return ss14j;
    }

    public void setSs14j(String ss14j) {
        this.ss14j = ss14j;
        notifyPropertyChanged(BR.ss14j);
    }

    @Bindable
    public String getSs14k() {
        return ss14k;
    }

    public void setSs14k(String ss14k) {
        this.ss14k = ss14k;
        notifyPropertyChanged(BR.ss14k);
    }

    @Bindable
    public String getSs14l() {
        return ss14l;
    }

    public void setSs14l(String ss14l) {
        this.ss14l = ss14l;
        notifyPropertyChanged(BR.ss14l);
    }

    @Bindable
    public String getSs14m() {
        return ss14m;
    }

    public void setSs14m(String ss14m) {
        this.ss14m = ss14m;
        notifyPropertyChanged(BR.ss14m);
    }

    @Bindable
    public String getSs14n() {
        return ss14n;
    }

    public void setSs14n(String ss14n) {
        this.ss14n = ss14n;
        notifyPropertyChanged(BR.ss14n);
    }

    @Bindable
    public String getSs14o() {
        return ss14o;
    }

    public void setSs14o(String ss14o) {
        this.ss14o = ss14o;
        notifyPropertyChanged(BR.ss14o);
    }

    @Bindable
    public String getSs14p() {
        return ss14p;
    }

    public void setSs14p(String ss14p) {
        this.ss14p = ss14p;
        notifyPropertyChanged(BR.ss14p);
    }

    @Bindable
    public String getSs14q() {
        return ss14q;
    }

    public void setSs14q(String ss14q) {
        this.ss14q = ss14q;
        notifyPropertyChanged(BR.ss14q);
    }

    @Bindable
    public String getSs14r() {
        return ss14r;
    }

    public void setSs14r(String ss14r) {
        this.ss14r = ss14r;
        notifyPropertyChanged(BR.ss14r);
    }

    @Bindable
    public String getSs14s() {
        return ss14s;
    }

    public void setSs14s(String ss14s) {
        this.ss14s = ss14s;
        notifyPropertyChanged(BR.ss14s);
    }

    @Bindable
    public String getSs15a() {
        return ss15a;
    }

    public void setSs15a(String ss15a) {
        this.ss15a = ss15a;
        notifyPropertyChanged(BR.ss15a);
    }

    @Bindable
    public String getSs15b() {
        return ss15b;
    }

    public void setSs15b(String ss15b) {
        this.ss15b = ss15b;
        notifyPropertyChanged(BR.ss15b);
    }

    @Bindable
    public String getSs15c() {
        return ss15c;
    }

    public void setSs15c(String ss15c) {
        this.ss15c = ss15c;
        notifyPropertyChanged(BR.ss15c);
    }

    @Bindable
    public String getSs15d() {
        return ss15d;
    }

    public void setSs15d(String ss15d) {
        this.ss15d = ss15d;
        notifyPropertyChanged(BR.ss15d);
    }

    @Bindable
    public String getSs15e() {
        return ss15e;
    }

    public void setSs15e(String ss15e) {
        this.ss15e = ss15e;
        notifyPropertyChanged(BR.ss15e);
    }

    @Bindable
    public String getSs15f() {
        return ss15f;
    }

    public void setSs15f(String ss15f) {
        this.ss15f = ss15f;
        notifyPropertyChanged(BR.ss15f);
    }

    @Bindable
    public String getSs15g() {
        return ss15g;
    }

    public void setSs15g(String ss15g) {
        this.ss15g = ss15g;
        notifyPropertyChanged(BR.ss15g);
    }

    @Bindable
    public String getSs15h() {
        return ss15h;
    }

    public void setSs15h(String ss15h) {
        this.ss15h = ss15h;
        notifyPropertyChanged(BR.ss15h);
    }

    @Bindable
    public String getSs15i() {
        return ss15i;
    }

    public void setSs15i(String ss15i) {
        this.ss15i = ss15i;
        notifyPropertyChanged(BR.ss15i);
    }

    @Bindable
    public String getSs17() {
        return ss17;
    }

    public void setSs17(String ss17) {
        this.ss17 = ss17;
        setSs17xx(ss17.equals("96") ? this.ss17xx : ""); // for all skips, mention all skipped questions
        notifyPropertyChanged(BR.ss17);
    }

    @Bindable
    public String getSs17xx() {
        return ss17xx;
    }

    public void setSs17xx(String ss17xx) {
        this.ss17xx = ss17xx;
        notifyPropertyChanged(BR.ss17xx);
    }

    @Bindable
    public String getSs18() {
        return ss18;
    }

    public void setSs18(String ss18) {
        this.ss18 = ss18;
        setSs18xx(ss18.equals("96") ? this.ss18xx : ""); // for all skips, mention all skipped questions
        notifyPropertyChanged(BR.ss18);
    }

    @Bindable
    public String getSs18xx() {
        return ss18xx;
    }

    public void setSs18xx(String ss18xx) {
        this.ss18xx = ss18xx;
        notifyPropertyChanged(BR.ss18xx);
    }

    @Bindable
    public String getSs19() {
        return ss19;
    }

    public void setSs19(String ss19) {
        this.ss19 = ss19;
        setSs19xx(ss19.equals("96") ? this.ss19xx : ""); // for all skips, mention all skipped questions
        notifyPropertyChanged(BR.ss19);
    }

    @Bindable
    public String getSs19xx() {
        return ss19xx;
    }

    public void setSs19xx(String ss19xx) {
        this.ss19xx = ss19xx;
        notifyPropertyChanged(BR.ss19xx);
    }

    @Bindable
    public String getSs20() {
        return ss20;
    }

    public void setSs20(String ss20) {
        this.ss20 = ss20;
        setSs20xx(ss20.equals("96") ? this.ss20xx : ""); // for all skips, mention all skipped questions
        notifyPropertyChanged(BR.ss20);
    }

    @Bindable
    public String getSs20xx() {
        return ss20xx;
    }

    public void setSs20xx(String ss20xx) {
        this.ss20xx = ss20xx;
        notifyPropertyChanged(BR.ss20xx);
    }

    @Bindable
    public String getSs21a() {
        return ss21a;
    }

    public void setSs21a(String ss21a) {
        this.ss21a = ss21a;
        notifyPropertyChanged(BR.ss21a);
    }

    @Bindable
    public String getSs22() {
        return ss22;
    }

    public void setSs22(String ss22) {
        this.ss22 = ss22;
        setSs23(ss22.equals("1") ? this.ss23 : "");
        notifyPropertyChanged(BR.ss22);
    }

    @Bindable
    public String getSs23() {
        return ss23;
    }

    public void setSs23(String ss23) {
        this.ss23 = ss23;
        setSs23landx(ss23.equals("1") || ss23.equals("2") ? this.ss23landx : "");
        notifyPropertyChanged(BR.ss23);
    }

    @Bindable
    public String getSs23landx() {
        return ss23landx;
    }

    public void setSs23landx(String ss23landx) {
        this.ss23landx = ss23landx;
        notifyPropertyChanged(BR.ss23landx);
    }

    @Bindable
    public String getSs24() {
        return ss24;
    }

    public void setSs24(String ss24) {
        this.ss24 = ss24;
        setSs25a(ss24.equals("1") ? this.ss25a : "");
        setSs25b(ss24.equals("1") ? this.ss25b : "");
        setSs25c(ss24.equals("1") ? this.ss25c : "");
        setSs25d(ss24.equals("1") ? this.ss25d : "");
        setSs25e(ss24.equals("1") ? this.ss25e : "");
        setSs25f(ss24.equals("1") ? this.ss25f : "");
        setSs25g(ss24.equals("1") ? this.ss25g : "");
        notifyPropertyChanged(BR.ss24);
    }

    @Bindable
    public String getSs25a() {
        return ss25a;
    }

    public void setSs25a(String ss25a) {
        this.ss25a = ss25a;
        notifyPropertyChanged(BR.ss25a);
    }

    @Bindable
    public String getSs25b() {
        return ss25b;
    }

    public void setSs25b(String ss25b) {
        this.ss25b = ss25b;
        notifyPropertyChanged(BR.ss25b);
    }

    @Bindable
    public String getSs25c() {
        return ss25c;
    }

    public void setSs25c(String ss25c) {
        this.ss25c = ss25c;
        notifyPropertyChanged(BR.ss25c);
    }

    @Bindable
    public String getSs25d() {
        return ss25d;
    }

    public void setSs25d(String ss25d) {
        this.ss25d = ss25d;
        notifyPropertyChanged(BR.ss25d);
    }

    @Bindable
    public String getSs25e() {
        return ss25e;
    }

    public void setSs25e(String ss25e) {
        this.ss25e = ss25e;
        notifyPropertyChanged(BR.ss25e);
    }

    @Bindable
    public String getSs25f() {
        return ss25f;
    }

    public void setSs25f(String ss25f) {
        this.ss25f = ss25f;
        notifyPropertyChanged(BR.ss25f);
    }

    @Bindable
    public String getSs25g() {
        return ss25g;
    }

    public void setSs25g(String ss25g) {
        this.ss25g = ss25g;
        notifyPropertyChanged(BR.ss25g);
    }

    @Bindable
    public String getSs26() {
        return ss26;
    }

    public void setSs26(String ss26) {
        this.ss26 = ss26;
        notifyPropertyChanged(BR.ss26);
    }

    @Bindable
    public String getSs27() {
        return ss27;
    }

    public void setSs27(String ss27) {
        this.ss27 = ss27;
        notifyPropertyChanged(BR.ss27);
    }

    @Bindable
    public String getSs28() {
        return ss28;
    }

    public void setSs28(String ss28) {
        this.ss28 = ss28;
        notifyPropertyChanged(BR.ss28);
    }
*//*

    @Bindable
    public String getEc13() {
        return ec13;
    }

    public void setEc13(String ec13) {
        this.ec13 = ec13;
        notifyPropertyChanged(BR.ec13);
    }

    @Bindable
    public String getEc14() {
        return ec14;
    }

    public void setEc14(String ec14) {
        this.ec14 = ec14;
        notifyPropertyChanged(BR.ec14);
    }

    @Bindable
    public String getEc15() {
        return ec15;
    }

    public void setEc15(String ec15) {
        this.ec15 = ec15;
        notifyPropertyChanged(BR.ec15);
    }

    @Bindable
    public String getEc16() {
        return ec16;
    }

    public void setEc16(String ec16) {
        this.ec16 = ec16;
        notifyPropertyChanged(BR.ec16);
    }

    @Bindable
    public String getEc17() {
        return ec17;
    }

    public void setEc17(String ec17) {
        this.ec17 = ec17;
        notifyPropertyChanged(BR.ec17);
    }

    @Bindable
    public String getCb03_dd() {
        return cb03_dd;
    }

    public void setCb03_dd(String cb03_dd) {
        this.cb03_dd = cb03_dd;
        notifyPropertyChanged(BR.cb03_dd);
    }

    @Bindable
    public String getCb03_mm() {
        return cb03_mm;
    }

    public void setCb03_mm(String cb03_mm) {
        this.cb03_mm = cb03_mm;
        notifyPropertyChanged(BR.cb03_mm);
    }

    @Bindable
    public String getCb03_yy() {
        return cb03_yy;
    }

    public void setCb03_yy(String cb03_yy) {
        this.cb03_yy = cb03_yy;
        notifyPropertyChanged(BR.cb03_yy);
    }

    @Bindable
    public String getCb03_dk() {
        return cb03_dk;
    }

    public void setCb03_dk(String cb03_dk) {
        this.cb03_dk = cb03_dk;
        notifyPropertyChanged(BR.cb03_dk);
    }

    @Bindable
    public String getCb04_mm() {
        return cb04_mm;
    }

    public void setCb04_mm(String cb04_mm) {
        this.cb04_mm = cb04_mm;
        notifyPropertyChanged(BR.cb04_mm);
    }

    @Bindable
    public String getCb04_yy() {
        return cb04_yy;
    }

    public void setCb04_yy(String cb04_yy) {
        this.cb04_yy = cb04_yy;
        notifyPropertyChanged(BR.cb04_yy);
    }
*/


    public Form Hydrate(Cursor cursor) throws JSONException {
        this.id = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_UID));
        this.projectName = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_PROJECT_NAME));
        this.districtCode = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_DISTRICT_CODE));
        this.lhwCode = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_LHW_CODE));
        this.kno = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_KNO));
        this.sno = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SNO));
        this.userName = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SYSDATE));
        this.deviceId = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_DEVICETAGID));
        //   this.entryType = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_ENTRY_TYPE));
        this.appver = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_APPVERSION));
        this.iStatus = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_ISTATUS));
        this.synced = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SYNC_DATE));
        this.gpsLat = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_GPSLAT));
        this.gpsLng = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_GPSLNG));
        this.gpsDT = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_GPSDATE));
        this.gpsAcc = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_GPSACC));


        sAHydrate(cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SA)));


        return this;
    }

    public void sAHydrate(String string) throws JSONException {
        Log.d(TAG, "sAHydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);


            this.a101 = json.getString("a101");
            this.a102 = json.getString("a102");
            this.a104 = json.getString("a104");
            this.a105 = json.getString("a105");
            this.a103 = json.getString("a103");
            this.a107 = json.getString("a107");
            this.a110 = json.getString("a110");


            this.iStatus96x = json.has("iStatus96x") ? json.getString("iStatus96x") : "";

        }
    }




    public String sAtoString() throws JSONException {
        Log.d(TAG, "sAtoString: ");
        JSONObject json = new JSONObject();
        json.put("a101", a101)
                .put("a102", a102)
                .put("a104", a104)
                .put("a105", a105)
                .put("a103", a103)
                .put("a107", a107)
                .put("a110", a110);

        return json.toString();
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();

        json.put(FormsTable.COLUMN_ID, this.id);
        json.put(FormsTable.COLUMN_UID, this.uid);
        json.put(FormsTable.COLUMN_PROJECT_NAME, this.projectName);
        json.put(FormsTable.COLUMN_DISTRICT_CODE, this.districtCode);
        json.put(FormsTable.COLUMN_LHW_CODE, this.lhwCode);
        json.put(FormsTable.COLUMN_KNO, this.kno);
        json.put(FormsTable.COLUMN_SNO, this.sno);
        json.put(FormsTable.COLUMN_USERNAME, this.userName);
        json.put(FormsTable.COLUMN_SYSDATE, this.sysDate);
        json.put(FormsTable.COLUMN_DEVICEID, this.deviceId);
        json.put(FormsTable.COLUMN_DEVICETAGID, this.deviceTag);
        //    json.put(FormsTable.COLUMN_ENTRY_TYPE, this.entryType);
        json.put(FormsTable.COLUMN_ISTATUS, this.iStatus);
        json.put(FormsTable.COLUMN_SYNCED, this.synced);
        json.put(FormsTable.COLUMN_SYNC_DATE, this.syncDate);
        json.put(FormsTable.COLUMN_APPVERSION, this.appver);
        json.put(FormsTable.COLUMN_GPSLAT, this.gpsLat);
        json.put(FormsTable.COLUMN_GPSLNG, this.gpsLng);
        json.put(FormsTable.COLUMN_GPSDATE, this.gpsDT);
        json.put(FormsTable.COLUMN_GPSACC, this.gpsAcc);

        json.put(FormsTable.COLUMN_ID, this.id);
        json.put(FormsTable.COLUMN_UID, this.uid);
        json.put(FormsTable.COLUMN_USERNAME, this.userName);
        json.put(FormsTable.COLUMN_SYSDATE, this.sysDate);
        json.put(FormsTable.COLUMN_DEVICEID, this.deviceId);
        json.put(FormsTable.COLUMN_DEVICETAGID, this.deviceTag);
        json.put(FormsTable.COLUMN_SYNCED, this.synced);

        json.put(FormsTable.COLUMN_SA, new JSONObject(sAtoString()));



        return json;
    }
}