package com.example.retrofitapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.retrofitapp.R;
import com.example.retrofitapp.models.ApiModel;
import com.squareup.picasso.Picasso;


public class DetailsFragment extends Fragment {

    ApiModel apiModel;
    private TextView name,bio,realname,team,appearance,publisher;
    private ImageView imageDet;
    public DetailsFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);

        if (getArguments() != null)
            apiModel = getArguments().getParcelable("ApiModelObj");

        name = view.findViewById(R.id.name_details);
        bio = view.findViewById(R.id.bio_details);
        realname = view.findViewById(R.id.realname_details);
        team = view.findViewById(R.id.team_details);
        appearance = view.findViewById(R.id.fappearance_details);
        publisher = view.findViewById(R.id.publisher_details);
        imageDet = view.findViewById(R.id.image_details);

        name.setText(apiModel.getName());
        bio.setText(apiModel.getBio());
        realname.setText(apiModel.getRealname());
        team.setText(apiModel.getTeam());
        appearance.setText(apiModel.getFirstappearance());
        publisher.setText(apiModel.getPublisher());

        Picasso.get().load(apiModel.getImageurl()).into(imageDet);

        return view;
    }

}

