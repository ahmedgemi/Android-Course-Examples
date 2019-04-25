package com.ahmed.roomdatabase2;

import android.app.Dialog;
import android.content.Context;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddDialog extends Dialog {

    @BindView(R.id.editText_name)
    EditText editText_name;
    @BindView(R.id.editText_price)
    EditText editText_price;
    @BindView(R.id.editText_image)
    EditText editText_image;

    public AddDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_add);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void addFood(){
        String name = editText_name.getText().toString();
        String image = editText_image.getText().toString();
        String price = editText_price.getText().toString();


       MyDatabase.getInstance(getContext()).getDao().addFood(new Food(name,Double.valueOf(price),image));

        dismiss();
    }
}
