package info.upump.mywardrobe2.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import info.upump.mywardrobe2.R;

/**
 * Created by Сергей on 24.08.2017.
 */

public class ItemPrevHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView textView;
    public ItemPrevHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.prevTextView);
        imageView = (ImageView) itemView.findViewById(R.id.prevImage);
    }
}
