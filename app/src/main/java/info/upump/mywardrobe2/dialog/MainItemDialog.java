package info.upump.mywardrobe2.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import info.upump.mywardrobe2.R;

/**
 * Created by Сергей on 25.08.2017.
 */

public class MainItemDialog extends DialogFragment {
    TextView textView;
    String  f;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View inflate = layoutInflater.inflate(R.layout.dialog_main_item, null);
        textView = (TextView) inflate.findViewById(R.id.textNameItem);
        builder.setView(inflate);
        builder.setMessage("Введите имя").
                setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("YES","YES");
                        Log.d( textView.getText().toString(),"deded");
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("No","No");
                    }
                });
        return  builder.create();

    }
}
