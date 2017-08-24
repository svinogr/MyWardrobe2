package info.upump.mywardrobe2.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import info.upump.mywardrobe2.R;
import info.upump.mywardrobe2.adapters.MainMenuAdapter;
import info.upump.mywardrobe2.db.DB;
import info.upump.mywardrobe2.db.MyCursorLoader;
import info.upump.mywardrobe2.model.ItemMainMenu;

/**
 * Created by Сергей on 17.08.2017.
 */

public class MainMenuFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {
    public static final String TAG = "MainMenuFragment";
    private List<ItemMainMenu> list = new ArrayList<>();
    private MainMenuAdapter mainMenuAdapter;
    private RecyclerView recyclerView;
    private Cursor cursor;
    private DB db;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(0, null, this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        Log.d("OnCreate", TAG);
        View root = inflater.inflate(R.layout.fragment_main_menu, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.fragmentMainMenu);

        mainMenuAdapter = new MainMenuAdapter(getActivity(), list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mainMenuAdapter);
        return root;

    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        MyCursorLoader myCursorLoader = new MyCursorLoader(getContext(), db);
        myCursorLoader.setTable(DB.TABLE_MAIN_MENU);
        return myCursorLoader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        Log.d("onLoadFinishedColCount", String.valueOf(data.getColumnCount()));

        cursor = data;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {

                    ItemMainMenu itemMainMenu = new ItemMainMenu();
                    itemMainMenu.setId(cursor.getInt(0));
                    itemMainMenu.setName(cursor.getString(1));
                    if(!list.contains(itemMainMenu)) {
                        list.add(itemMainMenu);
                    }
                } while (cursor.moveToNext());
            }
        }
        Log.d("onLoadFinishedSizeList", String.valueOf(list.size()));
        mainMenuAdapter = new MainMenuAdapter(getActivity(),list);
        recyclerView.setAdapter(mainMenuAdapter);


    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
