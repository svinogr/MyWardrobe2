package info.upump.mywardrobe2.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.upump.mywardrobe2.R;

/**
 * Created by Сергей on 22.08.2017.
 */

public class ItemPrevFragment extends Fragment {
    public final static String TAG = "ItemPrevFragment";
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        Log.d("OnCreate", TAG);
        View root = inflater.inflate(R.layout.fragment_main_menu, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.fragmentMainMenu);
        return root;

    }

}
