package com.anura.magkursach.ui.algebra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.anura.magkursach.Abb_multipl_formulas;
import com.anura.magkursach.R;
import com.anura.magkursach.Rad_to_Degrees;
import com.anura.magkursach.databinding.FragmentAlgebraBinding;

public class AlgebraFragment extends Fragment {

    private FragmentAlgebraBinding binding;
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
    /*
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

        card1.setOnClickListener((View.OnClickListener) this);
        //card2.setOnClickListener(this);
        //card3.setOnClickListener(this);
        //card4.setOnClickListener(this);
        //card5.setOnClickListener(this);
        card6.setOnClickListener((View.OnClickListener) this);
        //card7.setOnClickListener(this);
        //card8.setOnClickListener(this);
        //card9.setOnClickListener(this);
        //card10.setOnClickListener(this);
        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()) {
                case R.id.cardView:
                    intent = new Intent(getActivity(), Abb_multipl_formulas.class);
                    startActivity(intent);
                    break;
                case R.id.cardView6:
                    intent = new Intent(getActivity(), Rad_to_Degrees.class);
                    startActivity(intent);
                    break;

            }
        }
    }*/



}