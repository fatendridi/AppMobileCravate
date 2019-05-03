package com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.Activity;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.R;

public class MyViewHolderCravateLarge extends ViewHolder {

    TextView id,name,price;
    ImageView image;

    public MyViewHolderCravateLarge(View itemView) {
        super( itemView );
        this.id= itemView.findViewById(R.id.tv_id);
        this.name= itemView.findViewById(R.id.tv_name);
        this.price=itemView.findViewById(R.id.tv_price);
        this.image= itemView.findViewById(R.id.imagevieww);
    }
}
