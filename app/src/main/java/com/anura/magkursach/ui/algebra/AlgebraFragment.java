package com.anura.magkursach.ui.algebra;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.anura.magkursach.algebra.Abb_multipl_formulas;
import com.anura.magkursach.algebra.Degrees_and_etc;
import com.anura.magkursach.algebra.Derivatives;
import com.anura.magkursach.algebra.Progressions;
import com.anura.magkursach.algebra.Square_table;
import com.anura.magkursach.trigonometry.Degress_to_Rad;
import com.anura.magkursach.trigonometry.Rad_to_Degrees;
import com.anura.magkursach.databinding.FragmentAlgebraBinding;

public class AlgebraFragment extends Fragment {

    private FragmentAlgebraBinding binding;
    Intent intent;
    private CardView card1, card2, card3, card4, card5, card6, card7, card8, card9, card10;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //HomeViewModel homeViewModel =
        //new ViewModelProvider(this).get(HomeViewModel.class);
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_algebra);
        binding = FragmentAlgebraBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textHome;
        //homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
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

        card1 = binding.cardView;
        card2 = binding.cardView2;
        card3 = binding.cardView3;
        card4 = binding.cardView4;
        card5 = binding.cardView5;
        card6 = binding.cardView6;
        card7 = binding.cardView7;
        card8 = binding.cardView8;
        card9 = binding.cardView9;
        card10 = binding.cardView10;


        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(),Abb_multipl_formulas.class);
                startActivity(intent);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), Square_table.class);
                startActivity(intent);
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), Degrees_and_etc.class);
                startActivity(intent);
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), Progressions.class);
                startActivity(intent);
            }
        });
        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), Derivatives.class);
                startActivity(intent);
            }
        });

        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(),Rad_to_Degrees.class);
                startActivity(intent);
            }
        });
        card7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), Degress_to_Rad.class);
                startActivity(intent);
            }
        });
    }
}