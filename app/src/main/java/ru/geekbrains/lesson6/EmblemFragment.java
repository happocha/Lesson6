package ru.geekbrains.lesson6;

import android.app.DatePickerDialog;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Calendar;

public class EmblemFragment extends Fragment implements DatePickerDialog.OnDateSetListener {

    public static final String ARG_INDEX = "arg_index";
    public static final String TAG = "emblemfragment";

    public static EmblemFragment newInstance(int index) {
        EmblemFragment fragment = new EmblemFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_INDEX, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    private ImageView imageView;
    private EditText editText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_emblem, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.iv_emblem);
        editText = view.findViewById(R.id.et_emblem);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getArguments() != null) {
            int index = getArguments().getInt(ARG_INDEX);
            TypedArray array = getResources().obtainTypedArray(R.array.emblems);
            int drawableId = array.getResourceId(index, 0);
            imageView.setImageResource(drawableId);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showDatePickerDialog();
                }
            });
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
       String date = String.format("%s.%s.%s", day, month, year);
       editText.setText(date);
    }

    private void showDatePickerDialog() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        new DatePickerDialog(requireContext(), this, year, month, day).show();
    }
}
