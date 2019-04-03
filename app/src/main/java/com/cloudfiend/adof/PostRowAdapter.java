package com.cloudfiend.adof;

import android.content.Context;
import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PostRowAdapter extends RecyclerView.Adapter<PostRowAdapter.ViewHolder>  {

    private final int mBackground;

    private List<Post> original_items = new ArrayList<>();
    private List<Post> filtered_items = new ArrayList<>();

    private final TypedValue mTypedValue = new TypedValue();

    private Context ctx;

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        public ImageButton ivMenu;

        public ViewHolder(View v) {
            super(v);
            ivMenu =  v.findViewById(R.id.ivMenu);

        }

    }



    // Provide a suitable constructor (depends on the kind of dataset)
    public PostRowAdapter(Context ctx, List<Post> items) {
        this.ctx = ctx;
        original_items = items;
        filtered_items = items;
        ctx.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
        mBackground = mTypedValue.resourceId;
    }

    @Override
    public PostRowAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_post, parent, false);
        v.setBackgroundResource(mBackground);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //creating a popup menu
                PopupMenu popup = new PopupMenu(ctx, holder.ivMenu);
                //inflating menu from xml resource
                popup.inflate(R.menu.options_menu);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            default:
                                return false;
                        }
                    }
                });
                //displaying the popup
                popup.show();

            }
        });
//        final Post c = filtered_items.get(position);
//        holder.title.setText(c.getFriend().getName());
//
//        holder.time.setText(c.getDate());
//        holder.content.setText(c.getSnippet());
//        Picasso.with(ctx).load(c.getFriend().getPhoto())
//                .resize(100, 100)
//                .transform(new CircleTransform())
//                .into(holder.image);
//        // view detail message conversation
//        holder.lyt_parent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ctx, ActivityChatDetails.class);
//                intent.putExtra(ActivityChatDetails.KEY_FRIEND, c.getFriend());
//                intent.putExtra(ActivityChatDetails.KEY_SNIPPEST, c.getSnippet());
//                ctx.startActivity(intent);
//            }
//        });
//
//        holder.lyt_parent.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                dialogDeleteMessageConfirm(view, c, position);
//                return false;
//            }
//        });
    }


    private void dialogDeleteMessageConfirm(final View view, final Post c, final int position) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
//        builder.setTitle("Delete Confirmation");
//        builder.setMessage("All chat from : " + c.getFriend().getName()+ " will be deleted?");
//        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                filtered_items.remove(position);
//                notifyDataSetChanged();
//                Snackbar.make(view, "Delete success", Snackbar.LENGTH_SHORT).show();
//            }
//        });
//        builder.setNegativeButton("Cancel", null);
//        builder.show();
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return 20;
    }

//    @Override
//    public long getItemId(int position) {
//        return filtered_items.get(position).getId();
//    }
}


