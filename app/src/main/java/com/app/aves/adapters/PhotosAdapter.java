package com.app.aves.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.app.aves.R;
import com.app.aves.Response;
import com.app.aves.activities.PageThree;
import com.app.aves.activities.PageTwo;
import com.bumptech.glide.Glide;

import java.util.List;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotosHolder> {

    private List<Response> responseItemList;
    private Context context;

    public PhotosAdapter(List<Response> responseItemList, Context context) {
        this.responseItemList = responseItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public PhotosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.photos_view_item,parent,false);
        return new PhotosHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotosHolder holder, int position) {
        Response responseItem=responseItemList.get(position);
        Glide.with(context).load(responseItem.getUrls().getRegular()).into(holder.image);
       // holder.description.setText((CharSequence) responseItem.getDescription());
        holder.username.setText(responseItem.getUser().getUsername());
        Glide.with(context).load(responseItem.getUser().getProfileImage().getLarge()).into(holder.dp);

        holder.item.setOnClickListener(view -> {
            Intent intent=new Intent(context, PageTwo.class);
            intent.putExtra("IMAGE",responseItem.getUrls().getFull());
            intent.putExtra("DES","Description");
            context.startActivity(intent);
        });
        holder.username.setOnClickListener(view -> startP3(
                responseItem.getUser().getProfileImage().getLarge(),
                responseItem.getUser().getUsername(),
                responseItem.getUser().getBio(),
                responseItem.getUser().getLocation()
        ));
        holder.dp.setOnClickListener(view -> startP3(
                responseItem.getUser().getProfileImage().getLarge(),
                responseItem.getUser().getUsername(),
                responseItem.getUser().getBio(),
                responseItem.getUser().getLocation()
        ));


    }

    private void startP3(String dp, String un, String bio, String loc){
        Intent intent=new Intent(context, PageThree.class);
        intent.putExtra("DP",dp);
        intent.putExtra("UN",un);
        intent.putExtra("BIO",bio);
        intent.putExtra("LOC",loc);
        context.startActivity(intent);

    }

    @Override
    public int getItemCount() {
        return responseItemList.size();
    }

    static class PhotosHolder extends RecyclerView.ViewHolder{
        ImageView image,dp;
        TextView description,username;
        ConstraintLayout item;



        public PhotosHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.imageView);
            dp=itemView.findViewById(R.id.dp);
            description=itemView.findViewById(R.id.textView2);
            username=itemView.findViewById(R.id.textView3);
            item=itemView.findViewById(R.id.item);

        }
    }
}
