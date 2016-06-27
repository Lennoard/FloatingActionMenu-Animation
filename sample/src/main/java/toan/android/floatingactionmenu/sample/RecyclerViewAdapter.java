package toan.android.floatingactionmenu.sample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private final Context mContext;
    private final List<String> mDataset;

    public RecyclerViewAdapter(Context context, String[] dataset) {
        mContext = context;
        mDataset = Arrays.asList(dataset);
    }

    public void sort(ListViewAdapter.SortType type) {
        switch (type) {
            case AZ:
                Collections.sort(mDataset);
                break;
            case ZA:
                Collections.sort(mDataset, ListViewAdapter.sortZa);
                break;
        }
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView view = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        String[] values = mDataset.get(position).split(",");
        String countryName = values[0];
        int flagResId = mContext.getResources().getIdentifier(values[1], "drawable", mContext.getPackageName());
        viewHolder.mTextView.setText(countryName);
        viewHolder.mTextView.setCompoundDrawablesWithIntrinsicBounds(flagResId, 0, 0, 0);
        viewHolder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "test", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public ViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }
    }
}