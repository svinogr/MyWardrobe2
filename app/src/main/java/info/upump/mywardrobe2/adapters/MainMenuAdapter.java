package info.upump.mywardrobe2.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import info.upump.mywardrobe2.R;
import info.upump.mywardrobe2.model.ItemMainMenu;
import info.upump.mywardrobe2.model.MainMenuViewHolder;

/**
 * Created by Сергей on 21.08.2017.
 */

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuViewHolder> {
    private Activity activity;
    private List<ItemMainMenu> list= Collections.emptyList();

    public MainMenuAdapter(Activity activity, List<ItemMainMenu> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public MainMenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_menu_fragment_item_card,parent,false);
        return new MainMenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainMenuViewHolder holder, final int position) {
        holder.textView.setText(list.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ddd", String.valueOf(list.get(position).getName()));

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
