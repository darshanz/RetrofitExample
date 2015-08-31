package me.games.retrofitexample.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.games.retrofitexample.R;
import me.games.retrofitexample.models.User;


/**
 * Created by darshanz on 7/17/15.
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.CategoryViewHolder> {
    ArrayList<User> mUserList;


    public UserAdapter(ArrayList<User> categoryArrayList) {
        mUserList = categoryArrayList;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.layout_user_list_item, null);
        CategoryViewHolder viewHolder = new CategoryViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder categoryViewHolder, int i) {

        User user = mUserList.get(i);

        categoryViewHolder.firstName.setText(user.getFirstName());
        categoryViewHolder.lastName.setText(user.getLastName());
        categoryViewHolder.address.setText(user.getAddress());
        categoryViewHolder.country.setText(user.getCountry());
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }



    class CategoryViewHolder extends  RecyclerView.ViewHolder{
        @Bind(R.id.firstName)
        TextView firstName;
        @Bind(R.id.lastName)
        TextView lastName;
        @Bind(R.id.address)
        TextView address;
        @Bind(R.id.country)
        TextView country;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
