package com.anura.magkursach.ui.geometry;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.anura.magkursach.planimetry.Circle;
import com.anura.magkursach.planimetry.Geometry_figures;
import com.anura.magkursach.planimetry.Polygons;
import com.anura.magkursach.planimetry.Squares;
import com.anura.magkursach.planimetry.Triangles;
import com.anura.magkursach.stereometry.StereometriaSquares;
import com.anura.magkursach.databinding.FragmentGeometryBinding;
import com.anura.magkursach.stereometry.StereometriaVolume;

public class GeometryFragment extends Fragment {

    private FragmentGeometryBinding binding;
    Intent intent;
    private CardView card1, card2, card3, card4, card5, card6, card7;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       // GalleryViewModel galleryViewModel =
                //new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGeometryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textGallery;
        //galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    @Override

    public void onViewCreated(View view, Bundle savedInstanceState)  {
        //работа с CardView
        card1 = binding.cardViewGeom1;
        card2 = binding.cardViewGeom2;
        card3 = binding.cardViewGeom3;
        card4 = binding.cardViewGeom4;
        card5 = binding.cardViewGeom5;
        card6 = binding.cardViewGeom6;
        card7 = binding.cardViewGeom7;


        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), Geometry_figures.class);
                startActivity(intent);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), Triangles.class);
                startActivity(intent);
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), Circle.class);
                startActivity(intent);
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), Polygons.class);
                startActivity(intent);
            }
        });
        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), Squares.class);
                startActivity(intent);
            }
        });
        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), StereometriaSquares.class);
                startActivity(intent);
            }
        });
        card7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), StereometriaVolume.class);
                startActivity(intent);
            }
        });
    }
}