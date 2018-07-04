package com.persi.fragmenttester;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.*;
import android.widget.ImageView;

import com.persi.fragmenttester.view.MainActivity;

/**
 * Created by Persi on 13-03-2018.
 */

public class navigation_fragment extends Fragment {
    private ImageView mHome;
    private ImageView mMenu;
    private ImageView mProfile;
    private Intent mIntent;
    /*private FragmentListner mFragmentListner;
    public interface FragmentListner{
         // doNothing();
    }*/
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.naviation_fragment,container,false);
        mHome=v.findViewById(R.id.home);
        mMenu=v.findViewById(R.id.menu);
        mProfile=v.findViewById(R.id.profile);
        mMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeActivity(R.id.menu);
            }
        });
        mHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeActivity(R.id.home);
            }
        });
        mProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeActivity(R.id.profile);
            }
        });
        return v;

    }

    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mFragmentListner=(FragmentListner)context;
        }catch (ClassCastException e){
            Log.d("App",e.toString());
        }
    }*/

    private void changeActivity(int id){
        //getActivity can return Null if fragment is not added to
        if(isAdded()) {
            switch (id) {
                case R.id.menu:
                    mIntent = new Intent(getActivity(), Menu.class);
                    getActivity().finish();
                    startActivity(mIntent);
                    break;
                case R.id.home:
                    mIntent = new Intent(getActivity(), MainActivity.class);
                    getActivity().finish();
                    startActivity(mIntent);
                    break;
                case R.id.profile:
                    mIntent = new Intent(getActivity(), Profile.class);
                    getActivity().finish();
                    startActivity(mIntent);
                    break;
            }
        }
    }

}
