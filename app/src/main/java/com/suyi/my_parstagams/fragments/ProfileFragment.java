package com.suyi.my_parstagams.fragments;

import android.util.Log;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.suyi.my_parstagams.Post;

import java.util.List;

public class ProfileFragment extends PostsFragment{


    @Override
    protected void queryPosts() {
        super.queryPosts();
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.include(Post.KEY_USER);
        query.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser());
        query.setLimit(20);
        query.addDescendingOrder(Post.KEY_CREATED_AT);
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Issue with getting posts",e);
                    return;
                }
                for (Post post : posts) {
                    Log.i(TAG, "Post:" + post.getDescription() + " User:" +post.getUser().getUsername());
                }
                allPosts.addAll(posts);
                adapter.notifyDataSetChanged();
            }

        });  }
}
