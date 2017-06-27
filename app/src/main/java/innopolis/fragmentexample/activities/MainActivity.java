package innopolis.fragmentexample.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import innopolis.fragmentexample.R;
import innopolis.fragmentexample.fragments.MyFragment;

public class MainActivity extends AppCompatActivity {
    Fragment fragment;
    Fragment fragment2;

    public void addFragment(View view){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (fragment2 != null){
            fragment2 = new MyFragment();
            fragmentTransaction.replace(R.id.frameLayout, fragment2);
        } else {
            fragment2 = new MyFragment();
            fragmentTransaction.add(R.id.frameLayout, fragment2, "myfragment");
        }
        fragmentTransaction.commit();
    }

    public void removeFragment(View view){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(fragment2);
        fragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment = getFragmentManager().findFragmentById(R.id.fragment);
//        Bundle bundle = new Bundle();
//        bundle.putString("key", "value");
//        fragment.setArguments(bundle);
    }
}
