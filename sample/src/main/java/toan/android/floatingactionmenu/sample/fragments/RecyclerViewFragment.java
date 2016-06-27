package toan.android.floatingactionmenu.sample.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import toan.android.floatingactionmenu.FloatingActionButton;
import toan.android.floatingactionmenu.FloatingActionsMenu;
import toan.android.floatingactionmenu.sample.DividerItemDecoration;
import toan.android.floatingactionmenu.sample.ListViewAdapter;
import toan.android.floatingactionmenu.sample.R;
import toan.android.floatingactionmenu.sample.RecyclerViewAdapter;

public class RecyclerViewFragment extends Fragment {
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.multiple_actions)
    FloatingActionsMenu mMenuMultipleActions;
    @BindView(R.id.action_a)
    FloatingActionButton mFloatingActionButtonA;
    @BindView(R.id.action_b)
    FloatingActionButton mFloatingActionButtonB;

    @BindView(R.id.btn_change_icon)
    Button mBtnChangeIcon;
    @BindView(R.id.btn_change_child_icon)
    Button mBtnChangeChild;

    RecyclerViewAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        ButterKnife.bind(this, root);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));

        mAdapter = new RecyclerViewAdapter(getActivity(), getResources()
                .getStringArray(R.array.countries));
        mRecyclerView.setAdapter(mAdapter);

        mMenuMultipleActions.attachToRecyclerView(mRecyclerView);
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
                mAdapter.sort(ListViewAdapter.SortType.AZ);
            }
        });

        mBtnChangeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMenuMultipleActions.setIcon(getRandomDrawable());
            }
        });

        mBtnChangeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFloatingActionButtonA.setIcon(getRandomDrawableId());
                mFloatingActionButtonB.setIcon(getRandomDrawableId());
            }
        });
        return root;
    }

    private int getRandomDrawableId() {
        String[] arr = getResources().getStringArray(R.array.countries);
        int random = (int) (Math.random() * arr.length);
        String[] split = arr[random].split(",");
        int flagResId = getActivity().getResources().getIdentifier(split[1], "drawable", getActivity().getPackageName());
        return flagResId;
    }

    private Drawable getRandomDrawable() {
        return getResources().getDrawable(getRandomDrawableId());
    }

}