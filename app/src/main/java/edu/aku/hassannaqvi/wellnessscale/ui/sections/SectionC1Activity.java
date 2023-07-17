package edu.aku.hassannaqvi.wellnessscale.ui.sections;

import static edu.aku.hassannaqvi.wellnessscale.core.MainApp.familyMembers;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import edu.aku.hassannaqvi.wellnessscale.R;
import edu.aku.hassannaqvi.wellnessscale.contracts.TableContracts;
import edu.aku.hassannaqvi.wellnessscale.core.MainApp;
import edu.aku.hassannaqvi.wellnessscale.database.DatabaseHelper;
import edu.aku.hassannaqvi.wellnessscale.databinding.ActivitySectionC1Binding;

public class SectionC1Activity extends AppCompatActivity {


    private static final String TAG = "SectionSS_2Activity";
    ActivitySectionC1Binding bi;
    private DatabaseHelper db;
    private ImageView chestImageView;
    private SparseBooleanArray quadrantBooleanMap;

    private int selectedColor;
    private int unselectedColor;
    private ImageView[] quadrantViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(MainApp.langRTL ? MainApp.selectedLanguage == 1 ? R.style.AppThemeUrdu : R.style.AppThemeSindhi : R.style.AppThemeEnglish1);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c1);
        setSupportActionBar(bi.toolbar);
        db = MainApp.appInfo.dbHelper;
        bi.setFamilymembers(familyMembers);
        bi.setCallback(this);


        // Initialize the quadrant boolean map
        quadrantBooleanMap = new SparseBooleanArray();

        // Define colors for selected and unselected quadrants
        selectedColor = Color.parseColor("#FFC0CB"); // Replace with your desired color code
        unselectedColor = Color.TRANSPARENT;

        chestImageView = findViewById(R.id.chestImageView);
      /*  chestImageView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    int touchX = (int) event.getX();
                    int touchY = (int) event.getY();

                    Toast.makeText(SectionC1Activity.this, "Chest Touched at: ["+ touchX+", "+touchY+"]", Toast.LENGTH_SHORT).show();
                    // Check if the touch coordinates fall within a specific quadrant
                    int quadrantId = getQuadrantId(touchX, touchY);
                    if (quadrantId != -1) {
                        // Update the boolean value for the touched quadrant
                        boolean isSelected = !quadrantBooleanMap.get(quadrantId, false);
                        quadrantBooleanMap.put(quadrantId, isSelected);
                        markQuadrant(quadrantId);

                        // Shade or unshade the quadrant based on the selection
                        //shadeQuadrant(quadrantId, isSelected);
                    }
                }
                return true;
            }
        });*/
    }

    private boolean updateDB() {
        if (MainApp.superuser) return true;
        familyMembers.updateRoseScore();
        db = MainApp.appInfo.getDbHelper();
        long updcount = 0;
        try {
            updcount = db.updatesFamilyMembersColumn(TableContracts.FamilyMembersTable.COLUMN_SC1, familyMembers.sC1toString());
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(TAG, R.string.upd_db + e.getMessage());
            Toast.makeText(this, R.string.upd_db + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        if (updcount > 0) return true;
        else {
            Toast.makeText(this, R.string.upd_db_error, Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public void btnContinue() {
        if (!formValidation()) return;
        if (updateDB()) {
            setResult(RESULT_OK);
            Intent i;
            i = new Intent(this, SectionD1Activity.class).putExtra("complete", true).setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
            startActivity(i);
            finish();
        } else {
            Toast.makeText(this, R.string.fail_db_upd, Toast.LENGTH_SHORT).show();

        }
    }


    public void btnEnd() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("requestCode", "1");
        setResult(RESULT_CANCELED, returnIntent);
        finish();
        //  startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    @Override
    public void onBackPressed() {
        // Allow BackPress
        super.onBackPressed();
        setResult(RESULT_CANCELED);

        // Dont Allow BackPress
        // Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();

    }

    private int getQuadrantId(int touchX, int touchY) {
        // Define the boundaries of each quadrant
        int width = chestImageView.getWidth();
        int height = chestImageView.getHeight();

        int leftThird = width / 3;
        int rightThird = (width / 3) * 2;
        int topThird = height / 3;
        int bottomThird = (height / 3) * 2;

        // Check which quadrant the touch coordinates fall within
        if (touchX < leftThird && touchY < topThird) {
            Toast.makeText(SectionC1Activity.this, "Right side of Chest 0", Toast.LENGTH_SHORT).show();
            return 0; // Quadrant 1: Right side of Chest
        } else if (touchX >= leftThird && touchX < rightThird && touchY < topThird) {
            Toast.makeText(SectionC1Activity.this, "Right side of Chest 1", Toast.LENGTH_SHORT).show();
            return 1; // Quadrant 2: Right side of Chest
        } else if (touchX >= rightThird && touchY < topThird) {
            return 2; // Quadrant 3: Right side of Chest
        } else if (touchX < leftThird && touchY >= topThird && touchY < bottomThird) {
            return 3; // Quadrant 4: Centre of Chest
        } else if (touchX >= leftThird && touchX < rightThird && touchY >= topThird && touchY < bottomThird) {
            return 4; // Quadrant 5: Centre of Chest
        } else if (touchX >= rightThird && touchY >= topThird && touchY < bottomThird) {
            return 5; // Quadrant 6: Centre of Chest
        } else if (touchX < leftThird && touchY >= bottomThird) {
            return 6; // Quadrant 7: Left side of Chest
        } else if (touchX >= leftThird && touchX < rightThird && touchY >= bottomThird) {
            return 7; // Quadrant 8: Left side of Chest
        } else if (touchX >= rightThird && touchY >= bottomThird) {
            return 8; // Quadrant 9: Left side of Chest
        }

        return -1; // Return -1 if touch coordinates do not fall within any quadrant
    }
 /*   private int getQuadrantId(int touchX, int touchY) {
        // Define the boundaries of each quadrant
        Rect upperLeftQuadrant = new Rect(0, 0, chestImageView.getWidth() / 3, chestImageView.getHeight() / 3);
        Rect upperMiddleQuadrant = new Rect(chestImageView.getWidth() / 3, 0, (chestImageView.getWidth() / 3) * 2, chestImageView.getHeight() / 3);
        Rect upperRightQuadrant = new Rect((chestImageView.getWidth() / 3) * 2, 0, chestImageView.getWidth(), chestImageView.getHeight() / 3);
        // Define the boundaries for other quadrants as per your grid layout

        // Check which quadrant the touch coordinates fall within
        if (upperLeftQuadrant.contains(touchX, touchY)) {
            return 0; // Replace with the appropriate quadrant ID for the upper left quadrant
        } else if (upperMiddleQuadrant.contains(touchX, touchY)) {
            return 1; // Replace with the appropriate quadrant ID for the upper middle quadrant
        } else if (upperRightQuadrant.contains(touchX, touchY)) {
            return 2; // Replace with the appropriate quadrant ID for the upper right quadrant
        }
        // Add conditions for other quadrants as per your grid layout

        return -1; // Return -1 if touch coordinates do not fall within any quadrant
    }*/

    private void shadeQuadrant(int quadrantId) {
        // Get the resource ID of the selected quadrant background
        int resourceId = getResourceIdForQuadrant(quadrantId);

        // Loop through each quadrant and shade/unshade accordingly
        for (int i = 0; i < quadrantViews.length; i++) {
            ImageView chestImageView = quadrantViews[i];

            // Check if the current quadrant matches the selected quadrant ID
            boolean isSelected = (i == quadrantId);

            // Shade or unshade the quadrant based on the selection
            if (isSelected) {
                // Shade the selected quadrant
                chestImageView.setBackgroundResource(resourceId);
            } else {
                // Unshade the unselected quadrants
                chestImageView.setBackgroundResource(R.drawable.default_quadrant_background);
            }
        }
    }


    private int getResourceIdForQuadrant(int quadrantId) {
        // Replace with your own implementation to map quadrant IDs to resource IDs
        switch (quadrantId) {
            case 0:
                return R.drawable.quadrant_0_baxckground;
            case 1:
                return R.drawable.quadrant_0_baxckground;
            case 2:
                return R.drawable.quadrant_0_baxckground;
            // Add cases for other quadrants as per your grid layout
            default:
                return R.drawable.default_quadrant_background;
        }
    }

    private void markQuadrant(int quadrantId) {
        ImageView quadrantImageView = quadrantViews[quadrantId];
        quadrantImageView.setImageResource(R.drawable.ic_marked_x);
    }
}