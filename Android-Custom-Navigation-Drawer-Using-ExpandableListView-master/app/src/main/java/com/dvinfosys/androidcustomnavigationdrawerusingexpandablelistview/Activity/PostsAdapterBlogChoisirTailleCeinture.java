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

public class PostsAdapterBlogChoisirTailleCeinture extends RecyclerView.Adapter<PostsAdapterBlogChoisirTailleCeinture.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView titleMini,phrase;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleMini = (TextView) itemView.findViewById(R.id.titleMini);
            phrase =(TextView) itemView.findViewById(R.id.phrase);
            img = itemView.findViewById(R.id.img);
        }
    }

    private Context context;
    private List<postBlogChoisirTailleCeinture> posts;

    public PostsAdapterBlogChoisirTailleCeinture(Context c, List<postBlogChoisirTailleCeinture> postList)
    {
        this.context= c;
        posts = postList;
    }
    @NonNull
    @Override
    public PostsAdapterBlogChoisirTailleCeinture.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_posts_blogchoisirtailleceinture, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapterBlogChoisirTailleCeinture.ViewHolder viewHolder, int i) {

        postBlogChoisirTailleCeinture p = posts.get(i);
        viewHolder.titleMini.setText(p.getTitleMini());
        viewHolder.phrase.setText(p.getPhrase());
        viewHolder.img.setImageResource(p.getImg());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
