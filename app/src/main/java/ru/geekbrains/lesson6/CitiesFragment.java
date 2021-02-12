package ru.geekbrains.lesson6;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class CitiesFragment extends Fragment {

    // for example
    private List<SimpleNote> notes = new ArrayList<>();

    private boolean isLandscapeOrientation;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initArrayList();
        isLandscapeOrientation =
            getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cities_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        String[] array = getResources().getStringArray(R.array.cities);
        int padding = getResources().getDimensionPixelSize(R.dimen.default_margin);

        for (int i = 0; i < array.length; i++) {
            String name = array[i];
            TextView textView = new TextView(linearLayout.getContext());
            textView.setText(name);
            textView.setPadding(padding, 0, padding, 0);
            textView.setTextSize(30f);
            int index = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkOrientation(index);
                }
            });
            linearLayout.addView(textView);
        }
    }

    private void checkOrientation(int index) {
        if (isLandscapeOrientation) {
            openEmblemFragment(index);
        } else {
            startEmblemActivity(index);
        }
    }

    private void openEmblemFragment(int index) {
        EmblemFragment fragment = EmblemFragment.newInstance(index);
        requireActivity().getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.layout_container, fragment)
            .commit();
    }

    private void startEmblemActivity(int index) {
        Intent intent = new Intent(getActivity(), EmblemActivity.class);
        intent.putExtra(EmblemFragment.ARG_INDEX, index);
        startActivity(intent);
    }


    // for example
    private void initArrayList() {
        notes.add(new SimpleNote("title", "desc", "21.02.2004"));
        notes.add(new SimpleNote("title", "desc", "21.02.2004"));
        notes.add(new SimpleNote("title", "desc", "21.02.2004"));
        notes.add(new SimpleNote("title", "desc", "21.02.2004"));
    }
}
