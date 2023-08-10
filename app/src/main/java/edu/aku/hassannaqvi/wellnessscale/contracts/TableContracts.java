package edu.aku.hassannaqvi.wellnessscale.contracts;

import android.provider.BaseColumns;

public class TableContracts {


    public static abstract class FamilyMembersTable implements BaseColumns {
        public static final String TABLE_NAME = "FamilyMember";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECT_NAME = "projectName";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_UUID = "_uuid";
        public static final String COLUMN_LHW_CODE = "lhwCode";
        public static final String COLUMN_DISTRICT = "distCode";
        public static final String COLUMN_KHANDAN_NO = "kno";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_SYSDATE = "sysdate";
        public static final String COLUMN_INDEXED = "indexed";
        public static final String COLUMN_SNO = "sno";
        public static final String COLUMN_SA1 = "sA1";
        public static final String COLUMN_SB1 = "sB1";
        public static final String COLUMN_SC1 = "sC1";
        public static final String COLUMN_SD1 = "sD1";
        public static final String COLUMN_SE1 = "sE1";
        public static final String COLUMN_SF1 = "sF1";
        public static final String COLUMN_SG1 = "sG1";
        public static final String COLUMN_SH1 = "sH1";

        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "devicetagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_APPVERSION = "appversion";
        public static final String COLUMN_ISTATUS = "istatus";
    }
    public static abstract class FormsTable implements BaseColumns {
        public static final String TABLE_NAME = "Forms";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECT_NAME = "projectName";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_DISTRICT_CODE = "distCode";
        public static final String COLUMN_LHW_CODE = "lhwCode";
        public static final String COLUMN_KNO = "kno";
        public static final String COLUMN_SNO = "sno";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_SYSDATE = "sysdate";
        public static final String COLUMN_GPSLAT = "xlt";
        public static final String COLUMN_GPSLNG = "xlg";
        public static final String COLUMN_GPSDATE = "xdt";
        public static final String COLUMN_GPSACC = "xac";

        public static final String COLUMN_SA = "sA";
        public static final String COLUMN_SB = "sB";
        public static final String COLUMN_SC = "sC";
        public static final String COLUMN_SD = "sD";
        public static final String COLUMN_SE = "sE";
        public static final String COLUMN_SF = "sF";
        public static final String COLUMN_SG = "sG";
        public static final String COLUMN_SH = "sH";

        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "devicetagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNC_DATE = "sync_date";
        //  public static final String COLUMN_ENTRY_TYPE = "entry_type";
        public static final String COLUMN_APPVERSION = "appversion";
        public static final String COLUMN_ISTATUS = "iStatus";
    }

    public static abstract class EntryLogTable implements BaseColumns {
        public static final String TABLE_NAME = "EntryLog";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECT_NAME = "projectName";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_UUID = "_uuid";
        public static final String COLUMN_EB_CODE = "ebCode";
        public static final String COLUMN_HHID = "hhid";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_SYSDATE = "sysdate";
        public static final String COLUMN_ENTRY_DATE = "entryDate";

        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNC_DATE = "sync_date";
        public static final String COLUMN_ENTRY_TYPE = "entry_type";
        public static final String COLUMN_APPVERSION = "appversion";
        public static final String COLUMN_IStatus = "iStatus";
        public static final String COLUMN_IStatus96x = "iStatus96x";
    }




    public static abstract class UsersTable implements BaseColumns {
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_PASSWORD = "passwordEnc";
        public static final String COLUMN_FULLNAME = "full_name";
        public static final String COLUMN_DESIGNATION = "designation";
        public static final String COLUMN_ENABLED = "enabled";
        public static final String COLUMN_ISNEW_USER = "isNewUser";
        public static final String COLUMN_PWD_EXPIRY = "pwdExpiry";
        public static final String COLUMN_DIST_ID = "dist_id";
    }

/*    public static abstract class VillagesTable implements BaseColumns {
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String TABLE_NAME = "villages";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_COUNTRY = "clusterNo";
        public static final String COLUMN_CCODE = "geoarea";
        public static final String COLUMN_PROVINCE = "distId";
        public static final String COLUMN_PROVCODE = "provcode";
        public static final String COLUMN_DISTRICT_NAME = "districtName";
        public static final String COLUMN_DCODE = "dcode";
        public static final String COLUMN_TEHSIL_NAME = "tehsilName";
        public static final String COLUMN_TCODE = "tcode";
        public static final String COLUMN_UC_NAME = "ucName";
        public static final String COLUMN_UC_CODE = "uccode";
        public static final String COLUMN_VILLAGE = "village";
        public static final String COLUMN_VCODE = "vcode";
        public static final String COLUMN_PSUCODE = "psucode";
    }*/

    public static abstract class ClusterTable implements BaseColumns {
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String TABLE_NAME = "Clusters";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_DIST_ID = "dist_id";
        public static final String COLUMN_GEOAREA = "geoarea";
        public static final String COLUMN_EB_CODE = "ebcode";

    }

    public static abstract class RandomHHTable implements BaseColumns {
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String TABLE_NAME = "Randomised";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_RANDOMDT = "randDT";
        public static final String COLUMN_LUID = "UID";
        public static final String COLUMN_EB_CODE = "a102c";
        public static final String COLUMN_STRUCTURE_NO = "hh03";
        public static final String COLUMN_FAMILY_EXT_CODE = "hh07";
        public static final String COLUMN_HH_NO = "hh";
        public static final String COLUMN_HH_HEAD = "hh08";
        public static final String COLUMN_CONTACT = "hh09";
        public static final String COLUMN_HH_SELECTED_STRUCT = "hhss";
        public static final String COLUMN_SNO = "sno";
        public static final String COLUMN_TAB_NO = "tabNo";
        public static String COLUMN_DIST_CODE = "dist_id";
    }


    public static abstract class ChildTable implements BaseColumns {
        public static final String TABLE_NAME = "Children";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECT_NAME = "projectName";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_UUID = "_uuid";
        public static final String COLUMN_EB_CODE = "ebCode";
        public static final String COLUMN_HHID = "hhid";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_CSTATUS = "cstatus";
        public static final String COLUMN_SYSDATE = "sysdate";
        public static final String COLUMN_GPSLAT = "xlt";
        public static final String COLUMN_GPSLNG = "xlg";
        public static final String COLUMN_GPSDATE = "xdt";
        public static final String COLUMN_GPSACC = "xac";
        public static final String COLUMN_SNO = "sno";
        public static final String COLUMN_SCH = "sch";
        public static final String COLUMN_SCB = "scb";
        public static final String COLUMN_SIM = "sim";

        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "devicetagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNC_DATE = "sync_date";
        public static final String COLUMN_APPVERSION = "appversion";
    }


    public static abstract class TableLhw implements BaseColumns {

        public static final String TABLE_NAME = "lhw";
        public static final String COLUMN_NAME_NULLABLE = "nullColumnHack";
        public static final String COLUMN_ID = "_ID";
        public static final String COLUMN_HF_CODE = "hfcode";
        public static final String COLUMN_LHW_NAME = "lhw_name";
        public static final String COLUMN_LHW_CODE = "lhw_code";

    }

    public static abstract class TableHealthFacilities implements BaseColumns {
        public static final String TABLE_NAME = "HealthFacility";
        public static final String COLUMN_NAME_NULLABLE = "nullColumnHack";
        public static final String COLUMN_ID = "_ID";
        public static final String COLUMN_DIST_ID = "dist_id";
        public static final String COLUMN_HF_CODE = "hfcode";
        public static final String COLUMN_HF_NAME = "hf_name";
    }

    public static abstract class TableDistricts implements BaseColumns {
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String TABLE_NAME = "district";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_DISTRICT_NAME = "district_name";
        public static final String COLUMN_DISTRICT_CODE = "district_code";

    }

    public static abstract class VersionTable implements BaseColumns {
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String TABLE_NAME = "versionApp";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_VERSION_PATH = "elements";
        public static final String COLUMN_VERSION_CODE = "versionCode";
        public static final String COLUMN_VERSION_NAME = "versionName";
        public static final String COLUMN_PATH_NAME = "outputFile";
        public static final String SERVER_URI = "output-metadata.json";

    }
}
