package toan.android.floatingactionmenu.sample.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import toan.android.floatingactionmenu.FloatingActionButton;
import toan.android.floatingactionmenu.FloatingActionsMenu;
import toan.android.floatingactionmenu.ObservableScrollView;
import toan.android.floatingactionmenu.sample.R;

public class ScrollViewFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View root = inflater.inflate(R.layout.fragment_scrollview, container, false);
            ObservableScrollView scrollView = (ObservableScrollView) root.findViewById(R.id.scroll_view);
            LinearLayout list = (LinearLayout) root.findViewById(R.id.list);

            String[] countries = getResources().getStringArray(R.array.countries);
            for (String country : countries) {
                TextView textView = (TextView) inflater.inflate(R.layout.list_item, container, false);
                String[] values = country.split(",");
                String countryName = values[0];
                int flagResId = getResources().getIdentifier(values[1], "drawable", getActivity().getPackageName());
                textView.setText(countryName);
                textView.setCompoundDrawablesWithIntrinsicBounds(flagResId, 0, 0, 0);

                list.addView(textView);
            }
            final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) root.findViewById(R.id.multiple_actions);
            menuMultipleActions.attachToScrollView(scrollView);
            FloatingActionButton actionA = (FloatingActionButton) root.findViewById(R.id.action_a);
            actionA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    menuMultipleActions.collapse();
                }
            });
            FloatingActionButton actionB = (FloatingActionButton) root.findViewById(R.id.action_b);
            actionB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "Do nothing!", Toast.LENGTH_SHORT).show();
                }
            });

            return root;
        }
    }