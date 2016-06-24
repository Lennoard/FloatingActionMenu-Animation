package toan.android.floatingactionmenu.sample.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import toan.android.floatingactionmenu.FloatingActionButton;
import toan.android.floatingactionmenu.FloatingActionsMenu;
import toan.android.floatingactionmenu.sample.DividerItemDecoration;
import toan.android.floatingactionmenu.sample.R;
import toan.android.floatingactionmenu.sample.RecyclerViewAdapter;

public class RecyclerViewFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(), getResources()
                .getStringArray(R.array.countries));
        recyclerView.setAdapter(adapter);

        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) root.findViewById(R.id.multiple_actions);
        menuMultipleActions.attachToRecyclerView(recyclerView);

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