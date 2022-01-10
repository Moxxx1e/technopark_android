package com.technopark.hw_1;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import static com.technopark.hw_1.Consts.*;

interface OnNumberClickListener {
    void onNumberClick(NumberModel numberModel);
}


public class FirstFragment extends Fragment implements OnNumberClickListener {

    private int dataSize = DEFAULT_SIZE;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

        int numberOfColumns = getResources()
                .getConfiguration()
                .orientation == Configuration.ORIENTATION_PORTRAIT ? PORTRAIT_COLUMNS : LANDSCAPE_COLUMNS;

        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), numberOfColumns));

        restoreState(savedInstanceState);
        DataSource dataSource = new DataSource(dataSize);

        RecyclerView.Adapter adapter = new NumberAdapter(dataSource, this);
        recyclerView.setAdapter(adapter);

        Button button = view.findViewById(R.id.button_plus);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSource.AddNextNumber();
                dataSize++;
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NotNull final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(DATASIZE_KEY, dataSize);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        restoreState(savedInstanceState);
    }

    private void restoreState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            dataSize = savedInstanceState.getInt(DATASIZE_KEY);
        }
    }

    @Override
    public void onNumberClick(NumberModel numberModel) {
        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new SecondFragment(numberModel))
                .addToBackStack(null)
                .commit();
    }
}