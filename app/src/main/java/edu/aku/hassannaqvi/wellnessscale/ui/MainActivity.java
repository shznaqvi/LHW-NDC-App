package edu.aku.hassannaqvi.wellnessscale.ui;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static edu.aku.hassannaqvi.wellnessscale.core.MainApp.sharedPref;

import android.content.Intent;
import android.content.SharedPreferences;
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
import edu.aku.hassannaqvi.wellnessscale.models.Form;
import edu.aku.hassannaqvi.wellnessscale.ui.lists.FormsReportCluster;
import edu.aku.hassannaqvi.wellnessscale.ui.lists.FormsReportDate;
import edu.aku.hassannaqvi.wellnessscale.ui.lists.FormsReportPending;
import edu.aku.hassannaqvi.wellnessscale.ui.sections.SectionA1Activity;



public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    ActivityMainBinding bi;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bi.getRoot());

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
            if (daysLeft < 10) {
                bi.newApp.setText("Your current password is expiring in " + daysLeft + " day(s) on " + pwExpiry + ". Please change your password to avoid account lockout. (Internet Required.)");
                // bi.message.setText("Your password will expire on " + pwExpiry + ". There are only " + daysLeft + " Days left.");
                bi.newApp.setVisibility(View.VISIBLE);
            } else {
                bi.newApp.setVisibility(View.INVISIBLE);
            }

        } catch (JSONException | ParseException e) {
            e.printStackTrace();
        }


        String latestVersionName = sharedPref.getString("versionName", "");
        int latestVersionCode = Integer.parseInt(sharedPref.getString("versionCode", "0"));

        if (MainApp.appInfo.getVersionCode() < latestVersionCode) {
            bi.newApp.setVisibility(View.VISIBLE);
            bi.newApp.setText("NOTICE: There is a newer version of this app available on server (" + latestVersionName + latestVersionCode + "). \nPlease download update the app now.");
        } else {
            bi.newApp.setVisibility(View.INVISIBLE);

        }
    }

    public void sectionPress(View view) {


        if (view.getId() == R.id.startInterview) {
            MainApp.entryType = 1;
        } else {
            MainApp.entryType = 0;
        }

        if (view.getId() == R.id.startInterview) {
            MainApp.form = new Form();
            startActivity(new Intent(this, IdentificationActivity.class));
        } else if (view.getId() == R.id.seca1) {
            // MainApp.form = new Form();
            // startActivity(new Intent(this, SectionHHActivity.class));
        } else if (view.getId() == R.id.secri) {
            MainApp.form = new Form();
            startActivity(new Intent(this, SectionA1Activity.class));
        } else if (view.getId() == R.id.secis) {
            MainApp.form = new Form();
            startActivity(new Intent(this, EndingActivity.class));
        } else if (view.getId() == R.id.dbManager) {
            startActivity(new Intent(this, AndroidManager.class));
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        int itemId = item.getItemId();

        if (itemId == R.id.action_database) {
            intent = new Intent(MainActivity.this, AndroidManager.class);
            startActivity(intent);
        } else if (itemId == R.id.onSync) {
            intent = new Intent(MainActivity.this, SyncActivity.class);
            startActivity(intent);
        } else if (itemId == R.id.checkPendingForms) {
            intent = new Intent(MainActivity.this, FormsReportPending.class);
            startActivity(intent);
        } else if (itemId == R.id.formsReportDate) {
            intent = new Intent(MainActivity.this, FormsReportDate.class);
            startActivity(intent);
        } else if (itemId == R.id.changePassword) {
            intent = new Intent(MainActivity.this, ChangePasswordActivity.class);
            startActivity(intent);
        } else if (itemId == R.id.formsReportCluster) {
            intent = new Intent(MainActivity.this, FormsReportCluster.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_menu, menu);
        MenuItem action_database = menu.findItem(R.id.action_database);

        action_database.setVisible(MainApp.admin);
        return true;

    }

    public void takePhoto(View view) {

        Intent intent = new Intent(this, TakePhoto.class);

        intent.putExtra("picID", "000000" + "_" + "A-0000-000" + "_" + "01" + "_");
        intent.putExtra("childName", "Test ChilD");
/*
        intent.putExtra("picID", "901001" + "_" + "A-0001-001" + "_" + "1" + "_");
        intent.putExtra("childName", "Hassan");
*/
        if (view.getId() == R.id.frontPhoto) {
            intent.putExtra("picView", "front".toUpperCase());
            startActivityForResult(intent, 1); // Activity is started with requestCode 1 = Front
        } else {
            intent.putExtra("picView", "back".toUpperCase());
            startActivityForResult(intent, 2); // Activity is started with requestCode 2 = Back
        }
    }

    // Call Back method  to get the Message form other Activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED) {
            Toast.makeText(this, requestCode + "_" + resultCode, Toast.LENGTH_SHORT).show();

            String fileName = data.getStringExtra("FileName");

            // Check if the requestCode 1 = Front : 2 = Back -- resultCode 1 = Success : 2 = Failure
            // Results received with requestCode 1 = Front

            if (requestCode == 1 && resultCode == RESULT_OK) {
                Toast.makeText(this, "Photo Taken", Toast.LENGTH_SHORT).show();

             /*   bi.frontFileName.setText(fileName);
                bi.frontPhoto.setEnabled(false);
*/

            } else if (requestCode == 1 && resultCode != RESULT_CANCELED) {
                Toast.makeText(this, "Photo Cancelled", Toast.LENGTH_SHORT).show();

                //TODO: Implement functionality below when photo was not taken
                // ...
                //     bi.frontFileName.setText("Photo not taken.");

            }

            // Results received with requestCode 2 = Back
            if (requestCode == 2 && resultCode == RESULT_OK) {
                Toast.makeText(this, "Photo Taken", Toast.LENGTH_SHORT).show();
/*
                bi.backFileName.setText(fileName);
                bi.backPhoto.setEnabled(false);*/
            } else if (requestCode == 2 && resultCode != RESULT_CANCELED) {

                Toast.makeText(this, "Photo Cancelled", Toast.LENGTH_SHORT).show();

                //TODO: Implement functionality below when photo was not taken
                // ...
                //      bi.backFileName.setText("Photo not taken.");

            }
        }
    }

}