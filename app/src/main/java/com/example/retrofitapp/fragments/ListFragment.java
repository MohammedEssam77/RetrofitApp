package com.example.retrofitapp.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitapp.R;
import com.example.retrofitapp.adapters.MyAdapter;
import com.example.retrofitapp.interfaces.Navigate;
import com.example.retrofitapp.interfaces.OnClickListner;
import com.example.retrofitapp.models.ApiModel;
import com.example.retrofitapp.networks.ApiInterface;
import com.example.retrofitapp.networks.NetworkApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListFragment extends Fragment implements OnClickListner {
    ProgressDialog progressDoalog;
    private RecyclerView recyclerView;
    private Navigate navigate;
    private List<ApiModel> apiModel = new ArrayList<>();

    public ListFragment() {

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_list, container, false);

        progressDoalog = new ProgressDialog(getActivity());
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        recyclerView = view.findViewById(R.id.recyclerVid);
        ApiInterface serve = NetworkApi.getRetrofitInstance().create(ApiInterface.class);
        Call<List<ApiModel>> call = serve.getData();
        call.enqueue(new Callback<List<ApiModel>>() {
            @Override
            public void onResponse(Call<List<ApiModel>> call, Response<List<ApiModel>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<ApiModel>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private void generateDataList(List<ApiModel> apiModels) {
        MyAdapter mAdapter = new MyAdapter(getContext(), apiModels, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        this.apiModel = apiModels;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        navigate = (Navigate) context;
    }

    @Override
    public void onClick(int pos) {
        navigate.replaceFragments(apiModel.get(pos));
    }
}