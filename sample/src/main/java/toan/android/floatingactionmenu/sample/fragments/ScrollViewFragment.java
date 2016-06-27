package toan.android.floatingactionmenu.sample.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import toan.android.floatingactionmenu.FloatingActionButton;
import toan.android.floatingactionmenu.FloatingActionsMenu;
import toan.android.floatingactionmenu.ObservableScrollView;
import toan.android.floatingactionmenu.sample.R;

public class ScrollViewFragment extends Fragment {
    @BindView(R.id.scroll_view)
    ObservableScrollView mScrollView;
    @BindView(R.id.list)
    LinearLayout mListContainer;
    @BindView(R.id.multiple_actions)
    FloatingActionsMenu mMenuMultipleActions;
    @BindView(R.id.action_a)
    FloatingActionButton mFloatingActionButtonA;
    @BindView(R.id.action_b)
    FloatingActionButton mFloatingActionButtonB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_scrollview, container, false);
        ButterKnife.bind(this, root);
        String[] countries = getResources().getStringArray(R.array.countries);
        for (String country : countries) {
            TextView textView = (TextView) inflater.inflate(R.layout.list_item, container, false);
            String[] values = country.split(",");
            String countryName = values[0];
            int flagResId = getResources().getIdentifier(values[1], "drawable", getActivity().getPackageName());
            textView.setText(countryName);
            textView.setCompoundDrawablesWithIntrinsicBounds(flagResId, 0, 0, 0);

            mListContainer.addView(textView);
        }
        mMenuMultipleActions.attachToScrollView(mScrollView);
        mFloatingActionButtonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMenuMultipleActions.collapse();
            }
        });
        mFloatingActionButtonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMenuMultipleActions.collapse();
            }
        });

        return root;
    }
}