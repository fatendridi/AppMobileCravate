package com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.Activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.R;

import java.util.List;

public class PostsAdapterBlogReglerCeinture extends RecyclerView.Adapter<PostsAdapterBlogReglerCeinture.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder
    {


        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
        }
    }

    private Context context;
    private List<postBlogReglerCeinture> posts;

    public PostsAdapterBlogReglerCeinture(Context c, List<postBlogReglerCeinture> postList)
    {
        this.context= c;
        posts = postList;
    }
    @NonNull
    @Override
    public PostsAdapterBlogReglerCeinture.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_posts_blog_reglerceinture, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapterBlogReglerCeinture.ViewHolder viewHolder, int i) {

        postBlogReglerCeinture p = posts.get(i);

        viewHolder.img.setImageResource(p.getImg());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
