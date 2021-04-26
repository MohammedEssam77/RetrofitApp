package com.example.retrofitapp.activities;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.retrofitapp.R;
import com.example.retrofitapp.fragments.DetailsFragment;
import com.example.retrofitapp.fragments.ListFragment;
import com.example.retrofitapp.interfaces.Navigate;
import com.example.retrofitapp.models.ApiModel;

public class MainActivity extends AppCompatActivity implements Navigate {

    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListFragment fragmentList = new ListFragment();
        replaceFragment(fragmentList);
    }

    public void replaceFragment(Fragment fragment) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.content, fragment).commit();
    }

    @Override
    public void replaceFragments(ApiModel apiModel) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        DetailsFragment fragmentDetails = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ApiModelObj", apiModel);
        fragmentDetails.setArguments(bundle);
        fragmentTransaction.addToBackStack("ListFragment");
        fragmentTransaction.replace(R.id.content, fragmentDetails).commit();
    }
}