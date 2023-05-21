package edu.aku.hassannaqvi.wellnessscale.ui;

import static edu.aku.hassannaqvi.wellnessscale.core.MainApp.form;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import net.sqlcipher.database.SQLiteException;

import org.json.JSONException;

import edu.aku.hassannaqvi.wellnessscale.R;
import edu.aku.hassannaqvi.wellnessscale.contracts.TableContracts;
import edu.aku.hassannaqvi.wellnessscale.core.MainApp;
import edu.aku.hassannaqvi.wellnessscale.database.DatabaseHelper;
import edu.aku.hassannaqvi.wellnessscale.databinding.ActivityEndingBinding;
import edu.aku.hassannaqvi.wellnessscale.models.EntryLog;


public class EndingActivity extends AppCompatActivity {

    ActivityEndingBinding bi;
    int checkToEnable;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(MainApp.langRTL ? MainApp.selectedLanguage == 1 ? R.style.AppThemeUrdu:R.style.AppThemeSindhi  : R.style.AppThemeEnglish1);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_ending);
        bi.setForm(form);

        setSupportActionBar(bi.toolbar);
        //setTitle(R.string.section1mainheading);
        if (MainApp.superuser)
            bi.btnContinue.setText("End Review");

        db = MainApp.appInfo.dbHelper;
        boolean check = getIntent().getBooleanExtra("complete", false);

        checkToEnable = getIntent().getIntExtra("checkToEnable", 0);

        bi.iStatusa.setEnabled(check);
        bi.iStatusb.setEnabled(check);
        bi.iStatusc.setEnabled(check);
        bi.iStatusd.setEnabled(check);
        bi.iStatuse.setEnabled(check);
        bi.iStatusf.setEnabled(check);
       // bi.iStatusg.setEnabled(check);
        bi.iStatus96.setEnabled(check);

        switch (checkToEnable) {
            case 1:
                bi.iStatusa.setEnabled(!check);
                break;
            case 2:
                bi.iStatusb.setEnabled(!check);
                break;
            case 3:
                bi.iStatusc.setEnabled(!check);
                break;
            case 4:
                bi.iStatusd.setEnabled(!check);
                break;
            case 5:
                bi.iStatuse.setEnabled(!check);
                break;
            case 6:
                bi.iStatusf.setEnabled(!check);
                break;
//            case 7:
//                bi.iStatusg.setEnabled(!check);
//                break;
            case 8:
                bi.iStatus96.setEnabled(!check);
                break;
            default:
                bi.iStatusa.setEnabled(check);
                bi.iStatusb.setEnabled(!check);
                bi.iStatusc.setEnabled(!check);
                bi.iStatusd.setEnabled(!check);
                bi.iStatuse.setEnabled(!check);
                bi.iStatusf.setEnabled(!check);
              //  bi.iStatusg.setEnabled(!check);
                bi.iStatus96.setEnabled(!check);

        }

     //   bi.bScore.setText("Risk of Diabetes: "+checkScore());

    }



    private void saveDraft() {
        form.setiStatus(bi.iStatusa.isChecked() ? "1"
                : bi.iStatusb.isChecked() ? "2"
                : bi.iStatusc.isChecked() ? "3"
                : bi.iStatusd.isChecked() ? "4"
                : bi.iStatuse.isChecked() ? "5"
                : bi.iStatusf.isChecked() ? "6"
             //   : bi.iStatusg.isChecked() ? "7"
                : bi.iStatus96.isChecked() ? "96"
                : "-1");
        form.setiStatus96x(bi.iStatus96x.getText().toString());
        // form.setEndTime(new SimpleDateFormat("dd-MM-yy HH:mm", Locale.ENGLISH).format(new Date().getTime()));
    }


    public void btnEnd(View view) {
        if (!formValidation()) return;
        saveDraft();
        if (UpdateDB()) {

            recordEntry();
            finish();
            setResult(RESULT_OK);
           /* Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
           */
            Toast.makeText(this, "Data has been updated.", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Error in updating Database.", Toast.LENGTH_SHORT).show();
        }
    }


    private void recordEntry() {

        EntryLog entryLog = new EntryLog();
        entryLog.populateMeta();
        Long rowId = null;
        try {
            rowId = db.addEntryLog(entryLog);
        } catch (SQLiteException e) {
            Toast.makeText(this, "SQLiteException(EntryLog)" + entryLog, Toast.LENGTH_SHORT).show();
        }
        if (rowId != -1) {
            entryLog.setId(String.valueOf(rowId));
            entryLog.setUid(entryLog.getDeviceId() + entryLog.getId());
            db.updatesEntryLogColumn(TableContracts.EntryLogTable.COLUMN_UID, entryLog.getUid(), entryLog.getId());
        } else {
            Toast.makeText(this, R.string.upd_db_error, Toast.LENGTH_SHORT).show();

        }

    }


    private boolean UpdateDB() {
        if (MainApp.superuser) return true;
        try {
            db.updatesFormColumn(TableContracts.FormsTable.COLUMN_SA, form.sAtoString());
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "JSONException(Forms): ", Toast.LENGTH_SHORT).show();
        }
        int updcount = db.updatesFormColumn(TableContracts.FormsTable.COLUMN_ISTATUS, form.getiStatus());
        return updcount > 0;
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpEnd);
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
        setResult(RESULT_CANCELED); finish();
    }

}
