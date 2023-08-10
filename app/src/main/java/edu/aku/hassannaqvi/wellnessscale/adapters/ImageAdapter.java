package edu.aku.hassannaqvi.wellnessscale.adapters;

import static edu.aku.hassannaqvi.wellnessscale.core.MainApp.familyMembers;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.aku.hassannaqvi.wellnessscale.R;

public class ImageAdapter extends BaseAdapter {
    private final Context context;
    private final int[] imageIds;
    private final int numColumns = 5;
    private final boolean[] touchStates;
    private final ArrayList<Integer> positionsWithColorFilter;

    public ImageAdapter(Context context, ArrayList<Integer> positionsWithColorFilter) {
        this.context = context;
        this.positionsWithColorFilter = positionsWithColorFilter;

        this.imageIds = new int[]{
                R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4,
                R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8,
                R.drawable.img9, R.drawable.img10, R.drawable.img11, R.drawable.img12,
                R.drawable.img13, R.drawable.img14, R.drawable.img15
        };

        this.touchStates = new boolean[imageIds.length];
        //this.touchStates[2] = true;
        // Set touchStates to true for positions in disabledPositions
        for (int position : this.positionsWithColorFilter) {
            if (position >= 0 && position < touchStates.length) {
                touchStates[position] = true;
            }
        }

    }

    @Override
    public int getCount() {
        return imageIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ImageView imageView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            imageView = (ImageView) inflater.inflate(R.layout.grid_item_layout, parent, false);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(imageIds[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        if (touchStates[position]) {
            imageView.setColorFilter(Color.RED, PorterDuff.Mode.OVERLAY);
        } else {
            imageView.clearColorFilter();
        }
        if (position != 0 && position != 1 && position != 3 && position != 4) {

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if (touchStates[position]) {
                        touchStates[position] = false;
                        imageView.clearColorFilter();


                    } else {
                        touchStates[position] = true;
                        imageView.setColorFilter(Color.RED, PorterDuff.Mode.OVERLAY);
                    }



                    // Update the corresponding variables in the FamilyMembers class
                    if (position == 2) {
                        familyMembers.setC10201(touchStates[position] ? "1" : "");
                    } else if (position == 6) {
                        familyMembers.setC10202(touchStates[position] ? "2" : "");
                    } else if (position == 7) {
                        familyMembers.setC10203(touchStates[position] ? "3" : "");
                    } else if (position == 8) {
                        familyMembers.setC10204(touchStates[position] ? "4" : "");
                    } else if (position == 9 ) {
                        familyMembers.setC10205(touchStates[position]  ? "5" : !touchStates[position] && !touchStates[14]? "": "5"); // Quad 5 & Quad 14
                    } else if (position == 14) {
                        familyMembers.setC10205(touchStates[position]  ? "5" :  !touchStates[position] && !touchStates[9]? "": "5"); // Quad 5 & Quad 14
                    } else if (position == 11) {
                        familyMembers.setC10207(touchStates[position] ? "7" : "");
                    } else if (position == 12) {
                        familyMembers.setC10208(touchStates[position] ? "8" : "");
                    } else if (position == 13) {
                        familyMembers.setC10209(touchStates[position] ? "9" : "");
                    } else if (position == 5 ) {
                        familyMembers.setC10206(touchStates[position] ? "6" :  !touchStates[position] && !touchStates[10]? "": "6"); // Quad 6 & Quad 11
                    } else if (position == 10) {
                        familyMembers.setC10206(touchStates[position] ? "6" : !touchStates[position] && !touchStates[5]? "": "6"); // Quad 6 & Quad 11
                    }


                // Handle the click event for the selected image
                // You can retrieve the position or image ID to identify the clicked image
                // For example, you can display a Toast message with the clicked image information
                Toast.makeText(context, "Clicked image: " + imageIds[position], Toast.LENGTH_SHORT).show();
            }
        });}

        return imageView;
    }


}
