package edu.aku.hassannaqvi.wellnessscale.database;


import static edu.aku.hassannaqvi.wellnessscale.core.MainApp.IBAHC;
import static edu.aku.hassannaqvi.wellnessscale.core.MainApp.PROJECT_NAME;
import static edu.aku.hassannaqvi.wellnessscale.core.UserAuth.checkPassword;
import static edu.aku.hassannaqvi.wellnessscale.database.CreateTable.SQL_CREATE_FAMILY_MEMBERS;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import net.sqlcipher.Cursor;
import net.sqlcipher.MatrixCursor;
import net.sqlcipher.SQLException;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteException;
import net.sqlcipher.database.SQLiteOpenHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.wellnessscale.contracts.TableContracts.ChildTable;
import edu.aku.hassannaqvi.wellnessscale.contracts.TableContracts.EntryLogTable;
import edu.aku.hassannaqvi.wellnessscale.contracts.TableContracts.FamilyMembersTable;
import edu.aku.hassannaqvi.wellnessscale.contracts.TableContracts.FormsTable;
import edu.aku.hassannaqvi.wellnessscale.contracts.TableContracts.UsersTable;
import edu.aku.hassannaqvi.wellnessscale.core.MainApp;
import edu.aku.hassannaqvi.wellnessscale.models.EntryLog;
import edu.aku.hassannaqvi.wellnessscale.models.FamilyMembers;
import edu.aku.hassannaqvi.wellnessscale.models.Form;
import edu.aku.hassannaqvi.wellnessscale.models.Users;

/*
import edu.aku.hassannaqvi.wellnessscale.models.Villages;
*/



/*import edu.aku.hassannaqvi.naunehal.models.Immunization;*/

/**
 * @author hassan.naqvi on 11/30/2016.
 * @update ali azaz on 01/07/21
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = PROJECT_NAME + ".db";
    public static final String DATABASE_COPY = PROJECT_NAME + "_copy.db";
    public static final String DATABASE_PASSWORD = IBAHC;
    private static final int DATABASE_VERSION = 2;
    private final String TAG = "DatabaseHelper";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CreateTable.SQL_CREATE_USERS);
        db.execSQL(CreateTable.SQL_CREATE_CLUSTERS);
        db.execSQL(CreateTable.SQL_CREATE_RANDOM_HH);
        db.execSQL(SQL_CREATE_FAMILY_MEMBERS);

        db.execSQL(CreateTable.SQL_CREATE_FORMS);
        db.execSQL(CreateTable.SQL_CREATE_ENTRYLOGS);
        db.execSQL(CreateTable.SQL_CREATE_CHILD);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 1:
                db.execSQL(CreateTable.SQL_ALTER_FORMS_GPS_LAT);
                db.execSQL(CreateTable.SQL_ALTER_FORMS_GPS_LNG);
                db.execSQL(CreateTable.SQL_ALTER_FORMS_GPS_DATE);
                db.execSQL(CreateTable.SQL_ALTER_FORMS_GPS_ACC);

                db.execSQL(CreateTable.SQL_ALTER_CHILD_GPS_LAT);
                db.execSQL(CreateTable.SQL_ALTER_CHILD_GPS_LNG);
                db.execSQL(CreateTable.SQL_ALTER_CHILD_GPS_DATE);
                db.execSQL(CreateTable.SQL_ALTER_CHILD_GPS_ACC);
                // DO NOT BREAK AFTER EACH VERSION
                //break;
            case 2:

            default:

        }
    }


    //ADDITION in DB
    public Long addForm(Form form) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_PROJECT_NAME, form.getProjectName());
        values.put(FormsTable.COLUMN_UID, form.getUid());
        values.put(FormsTable.COLUMN_DISTRICT_CODE, form.getDistrictCode());
        values.put(FormsTable.COLUMN_LHW_CODE, form.getLhwCode());
        values.put(FormsTable.COLUMN_KNO, form.getKno());
        values.put(FormsTable.COLUMN_SNO, form.getSno());
        values.put(FormsTable.COLUMN_USERNAME, form.getUserName());
        values.put(FormsTable.COLUMN_SYSDATE, form.getSysDate());
        values.put(FormsTable.COLUMN_GPSLAT, form.getGpsLat());
        values.put(FormsTable.COLUMN_GPSLNG, form.getGpsLng());
        values.put(FormsTable.COLUMN_GPSDATE, form.getGpsDT());
        values.put(FormsTable.COLUMN_GPSACC, form.getGpsAcc());

        values.put(FormsTable.COLUMN_SA, form.sAtoString());


     /*   values.put(FormsTable.COLUMN_SSS, form.sMtoString());
        values.put(FormsTable.COLUMN_SCB, form.sNtoString());
        values.put(FormsTable.COLUMN_IM, form.sOtoString());*/

        values.put(FormsTable.COLUMN_ISTATUS, form.getiStatus());
        values.put(FormsTable.COLUMN_DEVICETAGID, form.getDeviceTag());
/*
        values.put(FormsTable.COLUMN_ENTRY_TYPE, form.getEntryType());
*/
        values.put(FormsTable.COLUMN_DEVICEID, form.getDeviceId());
        values.put(FormsTable.COLUMN_APPVERSION, form.getAppver());
        values.put(FormsTable.COLUMN_SYNCED, form.getSynced());
        values.put(FormsTable.COLUMN_SYNC_DATE, form.getSyncDate());

        long newRowId;
        newRowId = db.insertOrThrow(
                FormsTable.TABLE_NAME,
                FormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }
    public long addFamilyMember(FamilyMembers familyMembers) throws JSONException {
        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FamilyMembersTable.COLUMN_PROJECT_NAME, familyMembers.getProjectName());
        values.put(FamilyMembersTable.COLUMN_UID, familyMembers.getUid());
        values.put(FamilyMembersTable.COLUMN_UUID, familyMembers.getUuid());
        values.put(FamilyMembersTable.COLUMN_LHW_CODE, familyMembers.getLhwCode());
        values.put(FamilyMembersTable.COLUMN_DISTRICT, familyMembers.getDistCode());
        values.put(FamilyMembersTable.COLUMN_KHANDAN_NO, familyMembers.getkNo());
        values.put(FamilyMembersTable.COLUMN_USERNAME, familyMembers.getUserName());
        values.put(FamilyMembersTable.COLUMN_SYSDATE, familyMembers.getSysDate());
        values.put(FamilyMembersTable.COLUMN_SNO, familyMembers.getSno());
        values.put(FamilyMembersTable.COLUMN_SYNCED, familyMembers.getSynced());
        values.put(FamilyMembersTable.COLUMN_SYNCED_DATE, familyMembers.getSyncDate());


        values.put(FamilyMembersTable.COLUMN_SA1, familyMembers.sA1toString());

        values.put(FamilyMembersTable.COLUMN_ISTATUS, familyMembers.getiStatus());
        values.put(FamilyMembersTable.COLUMN_DEVICETAGID, familyMembers.getDeviceTag());
        values.put(FamilyMembersTable.COLUMN_DEVICEID, familyMembers.getDeviceId());
        values.put(FamilyMembersTable.COLUMN_APPVERSION, familyMembers.getAppver());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insertOrThrow(
                FamilyMembersTable.TABLE_NAME,
                FamilyMembersTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }
    public Long addEntryLog(EntryLog entryLog) throws SQLiteException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(EntryLogTable.COLUMN_PROJECT_NAME, entryLog.getProjectName());
        values.put(EntryLogTable.COLUMN_UUID, entryLog.getUuid());
        values.put(EntryLogTable.COLUMN_EB_CODE, entryLog.getEbCode());
        values.put(EntryLogTable.COLUMN_HHID, entryLog.getHhid());
        values.put(EntryLogTable.COLUMN_USERNAME, entryLog.getUserName());
        values.put(EntryLogTable.COLUMN_SYSDATE, entryLog.getSysDate());
        values.put(EntryLogTable.COLUMN_IStatus, entryLog.getIStatus());
        values.put(EntryLogTable.COLUMN_IStatus96x, entryLog.getIStatus96x());
        values.put(EntryLogTable.COLUMN_ENTRY_TYPE, entryLog.getEntryType());
        values.put(EntryLogTable.COLUMN_ENTRY_DATE, entryLog.getEntryDate());
        values.put(EntryLogTable.COLUMN_DEVICEID, entryLog.getDeviceId());
        values.put(EntryLogTable.COLUMN_SYNCED, entryLog.getSynced());
        values.put(EntryLogTable.COLUMN_SYNC_DATE, entryLog.getSyncDate());
        values.put(EntryLogTable.COLUMN_APPVERSION, entryLog.getAppver());

        long newRowId;
        newRowId = db.insertOrThrow(
                EntryLogTable.TABLE_NAME,
                EntryLogTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }



    //UPDATE in DB
    public int updatesFormColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = FormsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.form.getId())};

        return db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesFamilyMembersColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = FamilyMembersTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.familyMembers.getId())};

        return db.update(FamilyMembersTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesEntryLogColumn(String column, String value, String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = EntryLogTable._ID + " =? ";
        String[] selectionArgs = {id};

        return db.update(EntryLogTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }








    public int updateEnding() {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_ISTATUS, MainApp.form.getiStatus());

        // Which row to update, based on the ID
        String selection = FormsTable.COLUMN_ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.form.getId())};

        return db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    //Functions that dealing with table data
    public boolean doLogin(String username, String password) throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalArgumentException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause = UsersTable.COLUMN_USERNAME + "=? ";
        String[] whereArgs = {username};
        String groupBy = null;
        String having = null;
        String orderBy = UsersTable.COLUMN_ID + " ASC";

        Users loggedInUser = new Users();
        c = db.query(
                UsersTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            loggedInUser = new Users().hydrate(c);

        }
        boolean countCheck = c.getCount() > 0;
        if (c != null && !c.isClosed()) {
            c.close();
        }

        if (checkPassword(password, loggedInUser.getPassword())) {
            MainApp.user = loggedInUser;
            MainApp.selectedDistrict = loggedInUser.getDist_id();
            return countCheck;
        } else {
            return false;
        }
    }



    public ArrayList<Form> getFormsByDate(String sysdate) {

        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_SYSDATE,
                FormsTable.COLUMN_USERNAME,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_SYNCED,

        };
        String whereClause = FormsTable.COLUMN_SYSDATE + " Like ? ";
        String[] whereArgs = new String[]{"%" + sysdate + " %"};
        String groupBy = null;
        String having = null;
        String orderBy = FormsTable.COLUMN_ID + " ASC";
        ArrayList<Form> allForms = new ArrayList<>();

            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
        while (c.moveToNext()) {
            Form forms = new Form();
            forms.setId(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_ID)));
            forms.setUid(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_UID)));
            forms.setSysDate(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_SYSDATE)));
            forms.setUserName(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_USERNAME)));
            allForms.add(forms);
        }

        if (c != null && !c.isClosed()) {
            c.close();
        }

        return allForms;
    }


    public ArrayList<Cursor> getDatabaseManagerData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase(DATABASE_PASSWORD);
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(Query, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (Exception sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }

    public int syncversionApp(JSONArray VersionList) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        long count = 0;

        JSONObject jsonObjectVersion = ((JSONArray) VersionList.getJSONObject(0).get("elements")).getJSONObject(0);

        String appPath = jsonObjectVersion.getString("outputFile");
        String versionCode = jsonObjectVersion.getString("versionCode");

        MainApp.editor.putString("outputFile", jsonObjectVersion.getString("outputFile"));
        MainApp.editor.putString("versionCode", jsonObjectVersion.getString("versionCode"));
        MainApp.editor.putString("versionName", jsonObjectVersion.getString("versionName") + ".");
        MainApp.editor.apply();
        count++;
          /*  VersionApp Vc = new VersionApp();
            Vc.sync(jsonObjectVersion);

            ContentValues values = new ContentValues();

            values.put(VersionTable.COLUMN_PATH_NAME, Vc.getPathname());
            values.put(VersionTable.COLUMN_VERSION_CODE, Vc.getVersioncode());
            values.put(VersionTable.COLUMN_VERSION_NAME, Vc.getVersionname());

            count = db.insert(VersionTable.TABLE_NAME, null, values);
            if (count > 0) count = 1;

        } catch (Exception ignored) {
        } finally {
            db.close();
        }*/

        return (int) count;
    }

    public int syncAppUser(JSONArray userList) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        db.delete(UsersTable.TABLE_NAME, null, null);
        int insertCount = 0;
        for (int i = 0; i < userList.length(); i++) {

            JSONObject jsonObjectUser = userList.getJSONObject(i);

            Users user = new Users();
            user.sync(jsonObjectUser);
            ContentValues values = new ContentValues();

            values.put(UsersTable.COLUMN_USERNAME, user.getUserName());
            values.put(UsersTable.COLUMN_PASSWORD, user.getPassword());
            values.put(UsersTable.COLUMN_FULLNAME, user.getFullname());
            values.put(UsersTable.COLUMN_ENABLED, user.getEnabled());
            values.put(UsersTable.COLUMN_ISNEW_USER, user.getNewUser());
            values.put(UsersTable.COLUMN_PWD_EXPIRY, user.getPwdExpiry());
            values.put(UsersTable.COLUMN_DESIGNATION, user.getDesignation());
            values.put(UsersTable.COLUMN_DIST_ID, user.getDist_id());
            long rowID = db.insertOrThrow(UsersTable.TABLE_NAME, null, values);
            if (rowID != -1) insertCount++;
        }


        db.close();

        db.close();

        return insertCount;
    }

    //get UnSyncedTables
    public JSONArray getUnsyncedFormHH() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        //whereClause = null;
        whereClause = FormsTable.COLUMN_SYNCED + " = '' AND " +
                FormsTable.COLUMN_ISTATUS + "!= ''";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_ID + " ASC";

        JSONArray allForms = new JSONArray();
        c = db.query(
                FormsTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            /** WorkManager Upload
             /*Form fc = new Form();
             allFC.add(fc.Hydrate(c));*/
            Log.d(TAG, "getUnsyncedFormHH: " + c.getCount());
            Form form = new Form();
            allForms.put(form.Hydrate(c).toJSONObject());


        }

        if (c != null && !c.isClosed()) {
            c.close();
        }

        Log.d(TAG, "getUnsyncedFormHH: " + allForms.toString().length());
        Log.d(TAG, "getUnsyncedFormHH: " + allForms);
        return allForms;
    }

    public JSONArray getUnsyncedFamilyMembers() throws JSONException, ParseException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        android.database.Cursor c = null;
        String[] columns = null;

        String whereClause;
        //whereClause = null;
        whereClause = FamilyMembersTable.COLUMN_SYNCED + " ='' ";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy = FamilyMembersTable.COLUMN_ID + " ASC";

        JSONArray allFamilyMembers = new JSONArray();

        c = db.query(
                FamilyMembersTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            /** WorkManager Upload
             /*hhForm fc = new hhForm();
             allFC.add(fc.Hydrate(c));*/
            Log.d(TAG, "getUnsyncedFamilyMembers: " + c.getCount());


            FamilyMembers familyMember = new FamilyMembers();
            familyMember = familyMember.Hydrate(c);

           /* LHWHouseholds lhwHousehold = new LHWHouseholds().Hydrate(c);
            List<LHWHouseholds> lhwhhs = getKhandanNoByLHW(lhwHousehold.getA104c());
            LHWForm lhwForm = new LHWForm().Hydrate(c);
           */ //long days  = daysBetweenTwoDates(hhForm.getSysDate(), lhwForm.getSysDate());
            if (checkHHFormStatus(familyMember.getUuid()))
                allFamilyMembers.put(familyMember.toJSONObject());


        }

        Log.d(TAG, "getUnsyncedFamilyMembers: " + allFamilyMembers.toString().length());
        Log.d(TAG, "getUnsyncedFamilyMembers: " + allFamilyMembers);
        return allFamilyMembers;
    }

    public boolean checkHHFormStatus(String uid) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        android.database.Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = FormsTable.COLUMN_UID + "=? AND " +
                FormsTable.COLUMN_ISTATUS + " =? ";

        String[] whereArgs = {uid, "1"};

        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_ID + " ASC";

        Form form = null;

        c = db.query(
                FormsTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy,
                "1"// The sort order
        );

        int cCount = c.getCount();

        return cCount > 0;
    }

    public JSONArray getUnsyncedEntryLog() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause;
        whereClause = EntryLogTable.COLUMN_SYNCED + " = '' ";

        String[] whereArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = EntryLogTable.COLUMN_ID + " ASC";

        JSONArray all = new JSONArray();
        c = db.query(
                EntryLogTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            Log.d(TAG, "getUnsyncedEntryLog: " + c.getCount());
            EntryLog entryLog = new EntryLog();
            all.put(entryLog.Hydrate(c).toJSONObject());
        }
        Log.d(TAG, "getUnsyncedEntryLog: " + all.toString().length());
        Log.d(TAG, "getUnsyncedEntryLog: " + all);
        return all;
    }


    //update SyncedTables
    public void updateSyncedForms(String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SYNCED, true);
        values.put(FormsTable.COLUMN_SYNC_DATE, new Date().toString());

// Which row to update, based on the title
        String where = FormsTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                FormsTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedFamilyMember(String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FamilyMembersTable.COLUMN_SYNCED, true);
        values.put(FamilyMembersTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = FamilyMembersTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                FamilyMembersTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }


    public void updateSyncedChildren(String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(ChildTable.COLUMN_SYNCED, true);
        values.put(ChildTable.COLUMN_SYNC_DATE, new Date().toString());
        String where = ChildTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};
        int count = db.update(
                ChildTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedEntryLog(String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(EntryLogTable.COLUMN_SYNCED, true);
        values.put(EntryLogTable.COLUMN_SYNC_DATE, new Date().toString());
        String where = EntryLogTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};
        int count = db.update(
                EntryLogTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }


    public ArrayList<Cursor> getData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase(DATABASE_PASSWORD);
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            String maxQuery = Query;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (SQLException sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        } catch (Exception ex) {
            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + ex.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }

    public Form getFormByPsuhhid(String ebCode, String hhid) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = FormsTable.COLUMN_LHW_CODE + "=? AND " +
                FormsTable.COLUMN_KNO + " =? ";

        String[] whereArgs = {ebCode, hhid};

        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_ID + " ASC";

        Form form = null;
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
        while (c.moveToNext()) {
            form = new Form().Hydrate(c);
        }

        if (c != null && !c.isClosed()) {
            c.close();
        }

        return form;
    }


    public List<Form> getFormsByCluster(String cluster) {

        // String sysdate =  spDateT.substring(0, 8).trim()
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause = FormsTable.COLUMN_LHW_CODE + " = ? ";
        String[] whereArgs = new String[]{cluster};
//        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable.COLUMN_ID + " ASC";

        List<Form> allFC = new ArrayList<>();
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Form fc = new Form();
                fc.setId(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_ID)));
                fc.setUid(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_UID)));
                fc.setSysDate(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_SYSDATE)));
                fc.setDistrictCode(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_DISTRICT_CODE)));
                fc.setLhwCode(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_LHW_CODE)));
                fc.setKno(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_KNO)));
                fc.setSno(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_SNO)));
                fc.setiStatus(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_ISTATUS)));
                fc.setSynced(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_SYNCED)));
                allFC.add(fc);
            }

        if (c != null && !c.isClosed()) {
            c.close();
        }

        return allFC;
    }

    public List<Form> getTodayForms(String sysdate) {

        // String sysdate =  spDateT.substring(0, 8).trim()
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause = FormsTable.COLUMN_SYSDATE + " Like ? ";
        String[] whereArgs = new String[]{"%" + sysdate + " %"};
//        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_ID + " DESC";

        List<Form> allFC = new ArrayList<>();
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Form fc = new Form();
                fc.setId(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_ID)));
                fc.setUid(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_UID)));
                fc.setSysDate(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_SYSDATE)));
                fc.setDistrictCode(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_LHW_CODE)));
                fc.setKno(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_KNO)));
                fc.setiStatus(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_ISTATUS)));
                fc.setSynced(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_SYNCED)));
                allFC.add(fc);
            }
        if (c != null) {
            c.close();
        }
        if (db != null) {
            db.close();
        }
        return allFC;
    }


    public List<Form> getPendingForms() {

        // String sysdate =  spDateT.substring(0, 8).trim()
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause = FormsTable.COLUMN_ISTATUS + " = ?";
        String[] whereArgs = new String[]{""};
//        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_ID + " DESC";

        List<Form> allFC = new ArrayList<>();
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Form fc = new Form();
                fc.setId(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_ID)));
                fc.setUid(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_UID)));
                fc.setSysDate(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_SYSDATE)));
                fc.setDistrictCode(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_DISTRICT_CODE)));
                fc.setLhwCode(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_LHW_CODE)));
                fc.setKno(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_KNO)));
                fc.setSno(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_SNO)));
                fc.setiStatus(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_ISTATUS)));
                fc.setSynced(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_SYNCED)));
                allFC.add(fc);
            }
        if (c != null && !c.isClosed()) {
            c.close();
        }
        return allFC;
    }


    public int updatePassword(String hashedPassword) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(UsersTable.COLUMN_PASSWORD, hashedPassword);
        values.put(UsersTable.COLUMN_ISNEW_USER, "");

        String selection = UsersTable.COLUMN_USERNAME + " =? ";
        String[] selectionArgs = {MainApp.user.getUserName()};

        return db.update(UsersTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }


    public int getChildrenByUUID(String UUID) {
        String countQuery = "SELECT  * FROM " + ChildTable.TABLE_NAME + " WHERE " + ChildTable.COLUMN_UUID + " = '" + UUID + "' AND " + ChildTable.COLUMN_CSTATUS + " = '1'";
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int getChildrenPhotoCheck(String UID) {
        String countQuery = "SELECT  * FROM " + ChildTable.TABLE_NAME +
                " WHERE " + ChildTable.COLUMN_UUID + " = '" + UID +
                "' AND " + ChildTable.COLUMN_CSTATUS + " = '1' " +
                " AND (" + ChildTable.COLUMN_SIM + " NOT LIKE '%\"frontFileName\":\"\"%' " +
                " OR " + ChildTable.COLUMN_SIM + " NOT LIKE '%\"backFileName\":\"\"%') ";
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int getChildrenCardCheck(String UID) {
        String countQuery = "SELECT  * FROM " + ChildTable.TABLE_NAME +
                " WHERE " + ChildTable.COLUMN_UUID + " = '" + UID +
                "' AND " + ChildTable.COLUMN_CSTATUS + " = '1' " +
                " AND " + ChildTable.COLUMN_SIM + " LIKE '%\"im01\":\"1\"%' ";
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    //get UnSyncedTables
    public JSONArray getUnlockedUnsyncedFormHH() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        //whereClause = null;
        whereClause = FormsTable.COLUMN_SYNCED + " = '9' AND " +
                FormsTable.COLUMN_ISTATUS + "!= ''";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_ID + " ASC";

        JSONArray allForms = new JSONArray();
        c = db.query(
                FormsTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            /** WorkManager Upload
             /*Form fc = new Form();
             allFC.add(fc.Hydrate(c));*/
            Log.d(TAG, "getUnsyncedFormHH: " + c.getCount());
            Form form = new Form();
            allForms.put(form.Hydrate(c).toJSONObject());


        }

        c.close();
        db.close();

        Log.d(TAG, "getUnsyncedFormHH: " + allForms.toString().length());
        Log.d(TAG, "getUnsyncedFormHH: " + allForms);
        return allForms;
    }



    public Form getFormByUid(String uid) throws JSONException {

        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;

        Boolean distinct = false;
        String tableName = FormsTable.TABLE_NAME;
        String[] columns = null;
        String whereClause = FormsTable.COLUMN_UID + "= ? ";
        String[] whereArgs = {uid};
        String groupBy = null;
        String having = null;
        String orderBy = FormsTable.COLUMN_SYSDATE + " ASC";
        String limitRows = "1";

        c = db.query(
                distinct,       // Distinct values
                tableName,      // The table to query
                columns,        // The columns to return
                whereClause,    // The columns for the WHERE clause
                whereArgs,      // The values for the WHERE clause
                groupBy,        // don't group the rows
                having,         // don't filter by row groups
                orderBy,
                limitRows
        );

        Form form = new Form();
        while (c.moveToNext()) {
            form = (new Form().Hydrate(c));
        }

        c.close();
        db.close();
        return form;

    }


    public int syncUnlocked(JSONArray list) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SYNCED, "9");
        values.put(FormsTable.COLUMN_SYNC_DATE, "");
        values.put(FormsTable.COLUMN_ISTATUS, "");
        String where = FormsTable.COLUMN_UID + " = ? AND " +
                FormsTable.COLUMN_SYSDATE + " = ? ";
        int insertCount = 0;

        for (int i = 0; i < list.length(); i++) {

            JSONObject json = list.getJSONObject(i);

            // Removed '_x' from Unlocked UID
            String originalUID = json.getString(FormsTable.COLUMN_UID).split("_")[0];
            String[] whereArgs = {originalUID, json.getString(FormsTable.COLUMN_SYSDATE)};
            int rowID = db.update(
                    FormsTable.TABLE_NAME,
                    values,
                    where,
                    whereArgs);
            if (rowID != -1) insertCount++;
        }

        db.close();

        // Open all linked tables using Forms UID received from server
        syncUnlockedChildren(list);


        return insertCount;
    }

    // Call sync function for all linked tables sync function inside main table's sync function (syncUnlockedForms())
    public int syncUnlockedChildren(JSONArray list) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

// New value for one column
        ContentValues values = new ContentValues();
        values.put(ChildTable.COLUMN_SYNCED, "9");
        values.put(ChildTable.COLUMN_SYNC_DATE, "");
        String where = ChildTable.COLUMN_UUID + " = ? AND " +
                ChildTable.COLUMN_SYSDATE + " = ? AND " +
                ChildTable.COLUMN_SYNCED + " !='9'";
        int insertCount = 0;

        for (int i = 0; i < list.length(); i++) {

            JSONObject json = list.getJSONObject(i);

            //Remove '_x' from Unlocked UID
            //IMPORTANT: Getting "UID" field and "SYSDATE" from FORMS json
            String originalUID = json.getString(FormsTable.COLUMN_UID).split("_")[0];
            String[] whereArgs = {originalUID, json.getString(FormsTable.COLUMN_SYSDATE)};

            int rowID = db.update(
                    ChildTable.TABLE_NAME,
                    values,
                    where,
                    whereArgs);
            if (rowID != -1) insertCount++;
        }

        db.close();
        db.close();

        return insertCount;
    }

    public Form getFormByKNO() throws JSONException {

        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        android.database.Cursor c = null;

        Boolean distinct = false;
        String tableName = FormsTable.TABLE_NAME;
        String[] columns = null;
        String whereClause = FormsTable.COLUMN_LHW_CODE + "= ? AND " +
                FormsTable.COLUMN_KNO + "= ? ";
        String[] whereArgs = {MainApp.selectedLHW, MainApp.selectedHousehold};
        String groupBy = null;
        String having = null;
        String orderBy = FormsTable.COLUMN_SYSDATE + " ASC";
        String limitRows = "1";

        c = db.query(
                distinct,       // Distinct values
                tableName,      // The table to query
                columns,        // The columns to return
                whereClause,    // The columns for the WHERE clause
                whereArgs,      // The values for the WHERE clause
                groupBy,        // don't group the rows
                having,         // don't filter by row groups
                orderBy,
                limitRows
        );

        Form form = new Form();
        while (c.moveToNext()) {
            form = (new Form().Hydrate(c));
        }

        if (c != null && !c.isClosed()) {
            c.close();
        }
        return form;

    }

    public List<FamilyMembers> getMemberBYUID(String uid) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        android.database.Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = FamilyMembersTable.COLUMN_UUID + "=?";

        String[] whereArgs = {uid};

        String groupBy = null;
        String having = null;

        String orderBy = FamilyMembersTable.COLUMN_ID + " ASC";

        ArrayList<FamilyMembers> membersByUID = new ArrayList<>();
        c = db.query(
                FamilyMembersTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            FamilyMembers mwra = new FamilyMembers().Hydrate(c);

            membersByUID.add(mwra);
        }
        if (c != null) {
            c.close();
        }

        return membersByUID;
    }


}
