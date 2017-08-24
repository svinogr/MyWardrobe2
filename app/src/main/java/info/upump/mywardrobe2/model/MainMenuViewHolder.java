package info.upump.mywardrobe2.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import info.upump.mywardrobe2.R;

/**
 * Created by Сергей on 21.08.2017.
 */

public class MainMenuViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;

    //Картинка
    public MainMenuViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.main_menu_item_card_text);
    }

}
