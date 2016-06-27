package toan.android.floatingactionmenu.sample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    public enum SortType {
        AZ, ZA
    }

    private final Context mContext;
    private final List<String> mDataset;


    public ListViewAdapter(Context context, String[] dataset) {
        mContext = context;
        mDataset = Arrays.asList(dataset);
    }

    public void sort(SortType type) {
        switch (type) {
            case AZ:
                Collections.sort(mDataset);
                break;
            case ZA:
                Collections.sort(mDataset, sortZa);
                break;
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mDataset.size();
    }

    @Override
    public String getItem(int position) {
        return mDataset.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.mTextView = (TextView) convertView.findViewById(android.R.id.text1);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

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
        return convertView;
    }

    private static class ViewHolder {
        public TextView mTextView;
    }

    public static Comparator<String> sortZa = new Comparator<String>() {
        @Override
        public int compare(String lhs, String rhs) {
            if (lhs == null) {
                if (rhs == null) {
                    return 0;
                } else {
                    return -1;
                }
            }
            return -lhs.compareTo(rhs);
        }
    };
}