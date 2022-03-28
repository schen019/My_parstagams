package com.suyi.my_parstagams;

import android.os.Bundle;

import android.view.MenuItem;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.suyi.my_parstagams.fragments.ComposeFragment;
import com.suyi.my_parstagams.fragments.PostsFragment;
import com.suyi.my_parstagams.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    final FragmentManager fragmentManager = getSupportFragmentManager();
    private BottomNavigationView btnNavigationView;
    public static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNavigationView = findViewById(R.id.btnNavigationView);
        btnNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.action_home:
                        Toast.makeText(MainActivity.this, "Home!", Toast.LENGTH_SHORT).show();
                        // do something here
                        fragment = new PostsFragment();
                        break;
                    case R.id.action_compose:
                        Toast.makeText(MainActivity.this, "Compose!", Toast.LENGTH_SHORT).show();
                        // do something here
                        fragment = new ComposeFragment();
                        break;
                    case R.id.action_profile:
                        Toast.makeText(MainActivity.this, "Profile!", Toast.LENGTH_SHORT).show();
                        // do something here
                        fragment = new ProfileFragment();
                        break;

                    default:
                        throw new IllegalStateException("Unexpected value: " + menuItem.getItemId());
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });
        btnNavigationView.setSelectedItemId(R.id.action_home);
    }

}