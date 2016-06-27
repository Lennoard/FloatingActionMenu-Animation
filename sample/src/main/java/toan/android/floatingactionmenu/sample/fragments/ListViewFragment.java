package toan.android.floatingactionmenu.sample.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import toan.android.floatingactionmenu.FloatingActionButton;
import toan.android.floatingactionmenu.FloatingActionsMenu;
import toan.android.floatingactionmenu.sample.ListViewAdapter;
import toan.android.floatingactionmenu.sample.R;

public class ListViewFragment extends Fragment {
    @BindView(android.R.id.list)
    ListView mListView;
    @BindView(R.id.multiple_actions)
    FloatingActionsMenu mMenuMultipleActions;
    @BindView(R.id.action_a)
    FloatingActionButton mFloatingActionButtonA;
    @BindView(R.id.action_b)
    FloatingActionButton mFloatingActionButtonB;

    @BindView(R.id.btn_show_floatingaction)
    Button mBtnShow;
    @BindView(R.id.btn_hide_floatingaction)
    Button mBtnHide;

    ListViewAdapter mAdapter;

    @SuppressLint("InflateParams")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_listview, container, false);
        ButterKnife.bind(this, root);
        mAdapter = new ListViewAdapter(getActivity(),
                getResources().getStringArray(R.array.countries));
        mListView.setAdapter(mAdapter);

        mMenuMultipleActions.attachToListView(mListView);
        mFloatingActionButtonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMenuMultipleActions.collapse();
                mAdapter.sort(ListViewAdapter.SortType.AZ);
            }
        });
        mFloatingActionButtonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMenuMultipleActions.collapse();
                mAdapter.sort(ListViewAdapter.SortType.ZA);
            }
        });

        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMenuMultipleActions.setVisibleWithAnimation(true);
            }
        });

        mBtnHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMenuMultipleActions.setVisibleWithAnimation(false);
            }
        });

        return root;
    }
}