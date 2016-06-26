package toan.android.floatingactionmenu.sample.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import toan.android.floatingactionmenu.FloatingActionButton;
import toan.android.floatingactionmenu.FloatingActionsMenu;
import toan.android.floatingactionmenu.sample.ListViewAdapter;
import toan.android.floatingactionmenu.sample.R;

public class ListViewFragment extends Fragment {

        @SuppressLint("InflateParams")
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View root = inflater.inflate(R.layout.fragment_listview, container, false);
            ListView list = (ListView) root.findViewById(android.R.id.list);
            ListViewAdapter listAdapter = new ListViewAdapter(getActivity(),
                    getResources().getStringArray(R.array.countries));
            list.setAdapter(listAdapter);

            final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) root.findViewById(R.id.multiple_actions);
            menuMultipleActions.attachToListView(list);
            FloatingActionButton actionA = (FloatingActionButton) root.findViewById(R.id.action_a);
            actionA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    menuMultipleActions.collapse();
                    menuMultipleActions.setIcon(getActivity().getResources().getDrawable(R.drawable.it));
                }
            });
            FloatingActionButton actionB = (FloatingActionButton) root.findViewById(R.id.action_b);
            actionB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    menuMultipleActions.collapse();
                    menuMultipleActions.setVisibleWithAnimation(false);
                }
            });

            return root;
        }
    }