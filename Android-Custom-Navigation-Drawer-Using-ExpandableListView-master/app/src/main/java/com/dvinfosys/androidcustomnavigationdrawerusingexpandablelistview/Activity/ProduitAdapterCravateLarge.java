package com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.Activity;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public  class ProduitAdapterCravateLarge extends RecyclerView.Adapter <MyViewHolderCravateLarge> {
    ArrayList<ProduitCravateLarge> dataset;
    Activity act ;

    public ProduitAdapterCravateLarge(ArrayList<ProduitCravateLarge> DataModels, Activity act) {
        this.dataset = DataModels;
        this.act=act;

    }

    @Override
    public MyViewHolderCravateLarge onCreateViewHolder(ViewGroup parent, int viewType ) {
        View view= LayoutInflater.from( act ).inflate( R.layout.item_posts_cravate_large , parent,false );
        return new MyViewHolderCravateLarge( view);
    }

    @Override
    public void onBindViewHolder(MyViewHolderCravateLarge holder, int position) {
       // TextView textView = holder.textViewId;

      //  textView.setText( dataset.get( position ).getId() );
        TextView id=holder.id;
        TextView name=holder.name;
        TextView price=holder.price;
        ImageView image = holder.image;
        //TextView prenom= holder.Prenom;
       // TextView date= holder.Date_Nais;
        //TextView email =holder.Email;

        id.setText(String.valueOf(dataset.get(position).getId()));
        name.setText(dataset.get(position).getName());
        price.setText(dataset.get(position).getPrice());
        Picasso.get().load(dataset.get(position).getImage()).placeholder(R.drawable.crav).into(image);
      //  email.setText(dataset.get(position).getEmail());
      //  date.setText(dataset.get(position).getDate_nais());


    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
