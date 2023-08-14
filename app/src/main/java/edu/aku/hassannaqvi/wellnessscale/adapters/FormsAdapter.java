package edu.aku.hassannaqvi.wellnessscale.adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.aku.hassannaqvi.wellnessscale.R;
import edu.aku.hassannaqvi.wellnessscale.database.DatabaseHelper;
import edu.aku.hassannaqvi.wellnessscale.models.Form;

/**
 * Created by hassan.naqvi on 8/1/2016.
 */
public class FormsAdapter extends RecyclerView.Adapter<FormsAdapter.ViewHolder> {
    private static final String TAG = "FormsAdapter";
    Context c;
    DatabaseHelper db;
    private List<Form> fc = new ArrayList<>();

    // Provide a suitable constructor (depends on the kind of dataset)
    public FormsAdapter(List<Form> fc, Context c) {
        this.fc = fc;
        this.c = c;
        Log.d("TAG:count", String.valueOf(getItemCount()));
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pendingform_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        db = new DatabaseHelper(c);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        int memberCount = 0;
        memberCount = db.getMembersByUUID(fc.get(position).getUid());
       /* int photoChild = 0;
        photoChild = db.getChildrenPhotoCheck(fc.get(position).getUid());
        int cardChild = 0;
        cardChild = db.getChildrenCardCheck(fc.get(position).getUid());*/


        String tStatus = "Status  Unknown";
        boolean synced = fc.get(position).getSynced().equals("1");
        int iColor = 0;
        switch (fc.get(position).getiStatus()) {
            case "1":
                tStatus = "Complete";
                iColor = Color.GREEN;
                break;
            case "2":
                tStatus = "No Respondent";
                iColor = Color.RED;
                break;
            case "3":
                tStatus = "Memebers Absent";
                iColor = Color.RED;
                break;
            case "4":
                tStatus = "Refused";
                iColor = Color.RED;
                break;
            case "5":
                tStatus = "Empty";
                iColor = Color.RED;
                break;
            case "6":
                tStatus = "Not Found";
                iColor = Color.RED;
                break;
            case "96":
                tStatus = "Other Reason";
                iColor = Color.RED;
                break;
            default:
                tStatus = "Open Form";
                iColor = Color.RED;
                break;

        }

        holder.hhno.setText(fc.get(position).getKno() + " \t\t(" + fc.get(position).getSysDate() + ")");
        holder.cluster.setText(fc.get(position).getDistrictCode());
        holder.iStatus.setText(tStatus);
        holder.syncStatus.setText(synced ? "Data Synced" : "Sync Pending");
        holder.sysdate.setText("  Member Count: " + memberCount );
        holder.iStatus.setTextColor(iColor);


    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return fc.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public RecyclerView rv;
        public TextView sysdate;
        public TextView cluster;
        public TextView hhno;
        public TextView iStatus;
        public TextView syncStatus;
        // each data item is just a string in this case

        public ViewHolder(View v) {
            super(v);
//            rv = v.findViewById(R.id.FormsList);
            sysdate = v.findViewById(R.id.sysdate);
            cluster = v.findViewById(R.id.ebCode);
            hhno = v.findViewById(R.id.hhid);
            iStatus = v.findViewById(R.id.iStatus);
            syncStatus = v.findViewById(R.id.syncStatus);

        }


    }
}