package com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.Activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.R;

import java.util.List;

public class PostsAdapterBlogHistoireCravate extends RecyclerView.Adapter<PostsAdapterBlogHistoireCravate.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView txt1,txt2,title;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            txt1 = (TextView) itemView.findViewById(R.id.txt1);
            txt2 =(TextView) itemView.findViewById(R.id.txt2);
            img = itemView.findViewById(R.id.img);
        }
    }

    private Context context;
    private List<postBlogHistoireCravate> posts;

    public PostsAdapterBlogHistoireCravate(Context c, List<postBlogHistoireCravate> postList)
    {
        this.context= c;
        posts = postList;
    }
    @NonNull
    @Override
    public PostsAdapterBlogHistoireCravate.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_posts_bloghistoirecravate, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapterBlogHistoireCravate.ViewHolder viewHolder, int i) {

        postBlogHistoireCravate p = posts.get(i);
        viewHolder.title.setText(p.getTitle());
        viewHolder.txt1.setText(p.getTxt1());
        viewHolder.txt2.setText(p.getTxt2());

        viewHolder.img.setImageResource(p.getImg());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
