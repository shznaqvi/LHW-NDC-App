package edu.aku.hassannaqvi.wellnessscale.ui;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static edu.aku.hassannaqvi.wellnessscale.core.MainApp.editor;
import static edu.aku.hassannaqvi.wellnessscale.core.MainApp.sharedPref;

import android.app.DownloadManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import edu.aku.hassannaqvi.wellnessscale.R;
import edu.aku.hassannaqvi.wellnessscale.core.MainApp;
import edu.aku.hassannaqvi.wellnessscale.database.AndroidManager;
import edu.aku.hassannaqvi.wellnessscale.databinding.ActivityMainBinding;
import edu.aku.hassannaqvi.wellnessscale.databinding.ActivityParticipantFormBinding;
import edu.aku.hassannaqvi.wellnessscale.models.Form;
import edu.aku.hassannaqvi.wellnessscale.ui.lists.FormsReportDate;
import edu.aku.hassannaqvi.wellnessscale.ui.sections.SectionA1Activity;
import edu.aku.hassannaqvi.wellnessscale.ui.sections.SectionB1Activity;
import edu.aku.hassannaqvi.wellnessscale.ui.sections.SectionC1Activity;
import edu.aku.hassannaqvi.wellnessscale.ui.sections.SectionD1Activity;
import edu.aku.hassannaqvi.wellnessscale.ui.sections.SectionE1Activity;
import edu.aku.hassannaqvi.wellnessscale.ui.sections.SectionF1Activity;
import edu.aku.hassannaqvi.wellnessscale.ui.sections.SectionG1Activity;
import edu.aku.hassannaqvi.wellnessscale.ui.sections.SectionH1Activity;


public class ParticipantFormActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    ActivityParticipantFormBinding bi;
    SharedPreferences sp;
    private long downloadId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = ActivityParticipantFormBinding.inflate(getLayoutInflater());
        setContentView(bi.getRoot());
        // Retrieve downloadId from SharedPreferences

        // bi = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(bi.toolbar);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //getSupportActionBar().setIcon(R.drawable.app_icon);
        //bi.adminView.setVisibility(MainApp.admin ? View.VISIBLE : View.GONE);
        bi.toolbar.setSubtitle("Welcome, " + MainApp.user.getFullname() + (MainApp.admin ? " (Admin)" : "") + "!");
        invalidateOptionsMenu();


        try {
            String pwExpiry = String.valueOf(new JSONObject(MainApp.user.getPwdExpiry()).get("date")).substring(0, 10);
            //     Toast.makeText(this, pwExpiry, Toast.LENGTH_LONG).show();
            Log.d(TAG, "onCreate: pwExpiry: " + pwExpiry);

            Calendar cal = Calendar.getInstance();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            cal.setTime(sdf.parse(pwExpiry));// all done

            int daysLeft = (int) MILLISECONDS.toDays(cal.getTimeInMillis() - System.currentTimeMillis());
            //  Toast.makeText(this, daysLeft+" Days left", Toast.LENGTH_LONG).show();
            if (daysLeft < 1) {
                Toast.makeText(this, "Your password has expired. Please contact your supervisor.", Toast.LENGTH_LONG).show();
                finish();
            }


        } catch (JSONException | ParseException e) {
            e.printStackTrace();
        }


        String latestVersionName = sharedPref.getString("versionName", "");
        int latestVersionCode = Integer.parseInt(sharedPref.getString("versionCode", "0"));


    }



    public void sectionPress(View view) {


        if (view.getId() == R.id.startInterview) {
            MainApp.entryType = 1;
        } else {
            MainApp.entryType = 0;
        }

        if (view.getId() == R.id.startSecB) {
            startActivity(new Intent(this, SectionB1Activity.class));
        } else if (view.getId() == R.id.startSecC) {
             startActivity(new Intent(this, SectionC1Activity.class));
        }  else if (view.getId() == R.id.startSecD) {
             startActivity(new Intent(this, SectionD1Activity.class));
        }  else if (view.getId() == R.id.startSecE) {
             startActivity(new Intent(this, SectionE1Activity.class));
        }  else if (view.getId() == R.id.startSecF) {
             startActivity(new Intent(this, SectionF1Activity.class));
        }  else if (view.getId() == R.id.startSecG) {
             startActivity(new Intent(this, SectionG1Activity.class));
        }  else if (view.getId() == R.id.startSecH) {
             startActivity(new Intent(this, SectionH1Activity.class));
        }
    }




}