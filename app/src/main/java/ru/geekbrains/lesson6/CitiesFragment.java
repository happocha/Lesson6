package ru.geekbrains.lesson6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CitiesFragment extends Fragment implements CitiesAdapterCallback {

    private final List<City> cities = new ArrayList<>();
    private final CitiesAdapter citiesAdapter = new CitiesAdapter(this);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initArrayList();
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        citiesAdapter.setItems(cities);
    }

    @Override
    public void onOnItemClicked(int position) {
        City city = cities.get(position);
        Toast.makeText(requireContext(), city.getTitle(), Toast.LENGTH_SHORT).show();
    }

    private void initView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.rv_cities);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), RecyclerView.VERTICAL));
        recyclerView.addItemDecoration(new CitiesSpaceDecorator(getResources().getDimensionPixelSize(R.dimen.default_margin)));
        recyclerView.setAdapter(citiesAdapter);
    }

    private void initArrayList() {
        cities.add(new City("title1", "desc", "21.02.2004"));
        cities.add(new City("title2", "desc", "21.02.2004"));
        cities.add(new City("title3", "desc", "21.02.2004"));
        cities.add(new City("title4", "desc", "21.02.2004"));
        cities.add(new City("title5", "desc", "21.02.2004"));
        cities.add(new City("title6", "desc", "21.02.2004"));
        cities.add(new City("title7", "desc", "21.02.2004"));
        cities.add(new City("title8", "desc", "21.02.2004"));
        cities.add(new City("title9", "desc", "21.02.2004"));
        cities.add(new City("title10", "desc", "21.02.2004"));
        cities.add(new City("title11", "desc", "21.02.2004"));
        cities.add(new City("title12", "desc", "21.02.2004"));
        cities.add(new City("title13", "desc", "21.02.2004"));
        cities.add(new City("title14", "desc", "21.02.2004"));
        cities.add(new City("title15", "desc", "21.02.2004"));
        cities.add(new City("title16", "desc", "21.02.2004"));
    }
}
