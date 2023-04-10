package com.example.smarthouse.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.smarthouse.AddRoom;
import com.example.smarthouse.Device;
import com.example.smarthouse.R;
import com.example.smarthouse.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    ImageButton addRoomBtn, imageButtonKitchen;
    LinearLayout kitchenLay;

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        addRoomBtn = (ImageButton) getActivity().findViewById(R.id.addRoomBtn);
        kitchenLay = (LinearLayout) getActivity().findViewById(R.id.kitchenLay);




        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //      final TextView textView = binding.textHome;
        //      homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addRoomBtn = (ImageButton) getActivity().findViewById(R.id.addRoomBtn);
        kitchenLay = (LinearLayout) getActivity().findViewById(R.id.kitchenLay);

        addRoomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddRoom.class);
                startActivity(intent);
            }
        });

        kitchenLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Device.class);
                startActivity(intent);
            }
        });

    }
}