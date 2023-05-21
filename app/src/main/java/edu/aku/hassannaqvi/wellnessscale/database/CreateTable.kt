package edu.aku.hassannaqvi.wellnessscale.database


import edu.aku.hassannaqvi.wellnessscale.contracts.TableContracts.ChildTable
import edu.aku.hassannaqvi.wellnessscale.contracts.TableContracts.ClusterTable
import edu.aku.hassannaqvi.wellnessscale.contracts.TableContracts.EntryLogTable
import edu.aku.hassannaqvi.wellnessscale.contracts.TableContracts.FamilyMembersTable
import edu.aku.hassannaqvi.wellnessscale.contracts.TableContracts.FormsTable
import edu.aku.hassannaqvi.wellnessscale.contracts.TableContracts.RandomHHTable
import edu.aku.hassannaqvi.wellnessscale.contracts.TableContracts.UsersTable


object CreateTable {


    const val SQL_CREATE_FORMS = ("CREATE TABLE "
            + FormsTable.TABLE_NAME + "("
            + FormsTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FormsTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FormsTable.COLUMN_UID + " TEXT,"
            + FormsTable.COLUMN_DISTRICT_CODE + " TEXT,"
            + FormsTable.COLUMN_LHW_CODE + " TEXT,"
            + FormsTable.COLUMN_KNO + " TEXT,"
            + FormsTable.COLUMN_SNO + " TEXT,"
            + FormsTable.COLUMN_USERNAME + " TEXT,"
            + FormsTable.COLUMN_SYSDATE + " TEXT,"
            + FormsTable.COLUMN_ISTATUS + " TEXT,"
            + FormsTable.COLUMN_DEVICEID + " TEXT,"
            + FormsTable.COLUMN_DEVICETAGID + " TEXT,"
            + FormsTable.COLUMN_GPSLAT + " TEXT,"
            + FormsTable.COLUMN_GPSLNG + " TEXT,"
            + FormsTable.COLUMN_GPSDATE + " TEXT,"
            + FormsTable.COLUMN_GPSACC + " TEXT,"
/*
            + FormsTable.COLUMN_ENTRY_TYPE + " TEXT,"
*/
            + FormsTable.COLUMN_SYNCED + " TEXT,"
            + FormsTable.COLUMN_SYNC_DATE + " TEXT,"
            + FormsTable.COLUMN_APPVERSION + " TEXT,"
            + FormsTable.COLUMN_SA + " TEXT,"
            + FormsTable.COLUMN_SB + " TEXT,"
            + FormsTable.COLUMN_SC + " TEXT,"
            + FormsTable.COLUMN_SD + " TEXT,"
            + FormsTable.COLUMN_SE + " TEXT,"
            + FormsTable.COLUMN_SF + " TEXT,"
            + FormsTable.COLUMN_SG + " TEXT,"
            + FormsTable.COLUMN_SH + " TEXT"
            + " );"
            )

    const val SQL_CREATE_FAMILY_MEMBERS = ("CREATE TABLE "
            + FamilyMembersTable.TABLE_NAME + "("
            + FamilyMembersTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FamilyMembersTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FamilyMembersTable.COLUMN_UID + " TEXT,"
            + FamilyMembersTable.COLUMN_UUID + " TEXT,"
            + FamilyMembersTable.COLUMN_DISTRICT + " TEXT,"
            + FamilyMembersTable.COLUMN_LHW_CODE + " TEXT,"
            + FamilyMembersTable.COLUMN_KHANDAN_NO + " TEXT,"
            + FamilyMembersTable.COLUMN_USERNAME + " TEXT,"
            + FamilyMembersTable.COLUMN_SYSDATE + " TEXT,"
            + FamilyMembersTable.COLUMN_INDEXED + " TEXT,"
            + FamilyMembersTable.COLUMN_SNO + " TEXT,"
            + FamilyMembersTable.COLUMN_ISTATUS + " TEXT,"
            + FamilyMembersTable.COLUMN_DEVICEID + " TEXT,"
            + FamilyMembersTable.COLUMN_DEVICETAGID + " TEXT,"
            + FamilyMembersTable.COLUMN_SYNCED + " TEXT,"
            + FamilyMembersTable.COLUMN_SYNCED_DATE + " TEXT,"
            + FamilyMembersTable.COLUMN_APPVERSION + " TEXT,"
            + FamilyMembersTable.COLUMN_SA1 + " TEXT,"
            + FamilyMembersTable.COLUMN_SB1 + " TEXT,"
            + FamilyMembersTable.COLUMN_SC1 + " TEXT,"
            + FamilyMembersTable.COLUMN_SD1 + " TEXT,"
            + FamilyMembersTable.COLUMN_SE1 + " TEXT,"
            + FamilyMembersTable.COLUMN_SF1 + " TEXT,"
            + FamilyMembersTable.COLUMN_SG1 + " TEXT,"
            + FamilyMembersTable.COLUMN_SH1 + " TEXT"
            + " );"
            )

    const val SQL_CREATE_ENTRYLOGS = ("CREATE TABLE "
            + EntryLogTable.TABLE_NAME + "("
            + EntryLogTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + EntryLogTable.COLUMN_PROJECT_NAME + " TEXT,"
            + EntryLogTable.COLUMN_UID + " TEXT,"
            + EntryLogTable.COLUMN_UUID + " TEXT,"
            + EntryLogTable.COLUMN_EB_CODE + " TEXT,"
            + EntryLogTable.COLUMN_HHID + " TEXT,"
            + EntryLogTable.COLUMN_USERNAME + " TEXT,"
            + EntryLogTable.COLUMN_SYSDATE + " TEXT,"
            + EntryLogTable.COLUMN_DEVICEID + " TEXT,"
            + EntryLogTable.COLUMN_ENTRY_DATE + " TEXT,"
            + EntryLogTable.COLUMN_IStatus + " TEXT,"
            + EntryLogTable.COLUMN_IStatus96x + " TEXT,"
            + EntryLogTable.COLUMN_ENTRY_TYPE + " TEXT,"
            + EntryLogTable.COLUMN_SYNCED + " TEXT,"
            + EntryLogTable.COLUMN_SYNC_DATE + " TEXT,"
            + EntryLogTable.COLUMN_APPVERSION + " TEXT"
            + " );"
            )



    const val SQL_CREATE_CHILD = ("CREATE TABLE "
            + ChildTable.TABLE_NAME + "("
            + ChildTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ChildTable.COLUMN_PROJECT_NAME + " TEXT, "
            + ChildTable.COLUMN_UID + " TEXT, "
            + ChildTable.COLUMN_UUID + " TEXT, "
/*
            + ChildTable.COLUMN_MUID + " TEXT, "
*/
            + ChildTable.COLUMN_EB_CODE + " TEXT, "
            + ChildTable.COLUMN_HHID + " TEXT, "
            + ChildTable.COLUMN_SNO + " TEXT, "
            + ChildTable.COLUMN_USERNAME + " TEXT, "
            + ChildTable.COLUMN_SYSDATE + " TEXT, "
            + ChildTable.COLUMN_CSTATUS + " TEXT, "
            + ChildTable.COLUMN_DEVICEID + " TEXT, "
            + ChildTable.COLUMN_DEVICETAGID + " TEXT, "
            + ChildTable.COLUMN_SYNCED + " TEXT, "
            + ChildTable.COLUMN_SYNC_DATE + " TEXT, "
            + ChildTable.COLUMN_APPVERSION + " TEXT, "
            + ChildTable.COLUMN_GPSLAT + " TEXT,"
            + ChildTable.COLUMN_GPSLNG + " TEXT,"
            + ChildTable.COLUMN_GPSDATE + " TEXT,"
            + ChildTable.COLUMN_GPSACC + " TEXT,"
            + ChildTable.COLUMN_SCH + " TEXT, "
            + ChildTable.COLUMN_SCB + " TEXT, "
            + ChildTable.COLUMN_SIM + " TEXT "
            + " );"
            )


    const val SQL_CREATE_USERS = ("CREATE TABLE "
            + UsersTable.TABLE_NAME + "("
            + UsersTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UsersTable.COLUMN_USERNAME + " TEXT,"
            + UsersTable.COLUMN_PASSWORD + " TEXT,"
            + UsersTable.COLUMN_FULLNAME + " TEXT,"
            + UsersTable.COLUMN_DIST_ID + " TEXT,"
            + UsersTable.COLUMN_ENABLED + " TEXT,"
            + UsersTable.COLUMN_ISNEW_USER + " TEXT,"
            + UsersTable.COLUMN_PWD_EXPIRY + " TEXT,"
            + UsersTable.COLUMN_DESIGNATION + " TEXT"
            + " );"
            )


    const val SQL_CREATE_CLUSTERS = ("CREATE TABLE "
            + ClusterTable.TABLE_NAME + "("
            + ClusterTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ClusterTable.COLUMN_GEOAREA + " TEXT,"
            + ClusterTable.COLUMN_DIST_ID + " TEXT,"
            + ClusterTable.COLUMN_EB_CODE + " TEXT"
            + " );"
            )

    const val SQL_CREATE_RANDOM_HH = ("CREATE TABLE " + RandomHHTable.TABLE_NAME + "("
            + RandomHHTable.COLUMN_ID + " TEXT,"
            + RandomHHTable.COLUMN_EB_CODE + " TEXT,"
            + RandomHHTable.COLUMN_LUID + " TEXT,"
            + RandomHHTable.COLUMN_HH_NO + " TEXT,"
            + RandomHHTable.COLUMN_STRUCTURE_NO + " TEXT,"
            + RandomHHTable.COLUMN_FAMILY_EXT_CODE + " TEXT,"
            + RandomHHTable.COLUMN_HH_HEAD + " TEXT,"
            + RandomHHTable.COLUMN_CONTACT + " TEXT,"
            + RandomHHTable.COLUMN_HH_SELECTED_STRUCT + " TEXT,"
            + RandomHHTable.COLUMN_RANDOMDT + " TEXT,"
            + RandomHHTable.COLUMN_SNO + " TEXT );"
            )

/*    const val SQL_CREATE_VERSIONAPP = ("CREATE TABLE "
            + VersionTable.TABLE_NAME + " ("
            + VersionTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + VersionTable.COLUMN_VERSION_CODE + " TEXT, "
            + VersionTable.COLUMN_VERSION_NAME + " TEXT, "
            + VersionTable.COLUMN_PATH_NAME + " TEXT "
            + ");"
            )*/

    const val SQL_ALTER_FORMS_GPS_LAT =
        ("ALTER TABLE " + FormsTable.TABLE_NAME + " ADD " + FormsTable.COLUMN_GPSLAT + " TEXT; ")
    const val SQL_ALTER_FORMS_GPS_LNG =
        ("ALTER TABLE " + FormsTable.TABLE_NAME + " ADD " + FormsTable.COLUMN_GPSLNG + " TEXT; ")
    const val SQL_ALTER_FORMS_GPS_DATE =
        ("ALTER TABLE " + FormsTable.TABLE_NAME + " ADD " + FormsTable.COLUMN_GPSDATE + " TEXT; ")
    const val SQL_ALTER_FORMS_GPS_ACC =
        ("ALTER TABLE " + FormsTable.TABLE_NAME + " ADD " + FormsTable.COLUMN_GPSACC + " TEXT; ")

    const val SQL_ALTER_CHILD_GPS_LAT =
        ("ALTER TABLE " + ChildTable.TABLE_NAME + " ADD " + ChildTable.COLUMN_GPSLAT + " TEXT; ")
    const val SQL_ALTER_CHILD_GPS_LNG =
        ("ALTER TABLE " + ChildTable.TABLE_NAME + " ADD " + ChildTable.COLUMN_GPSLNG + " TEXT; ")
    const val SQL_ALTER_CHILD_GPS_DATE =
        ("ALTER TABLE " + ChildTable.TABLE_NAME + " ADD " + ChildTable.COLUMN_GPSDATE + " TEXT; ")
    const val SQL_ALTER_CHILD_GPS_ACC =
        ("ALTER TABLE " + ChildTable.TABLE_NAME + " ADD " + ChildTable.COLUMN_GPSACC + " TEXT; ")

}