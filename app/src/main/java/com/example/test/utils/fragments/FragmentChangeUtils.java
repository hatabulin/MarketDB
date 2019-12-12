package com.example.test.utils.fragments;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.test.R;

public class FragmentChangeUtils {

    public static void setFragment(FragmentManager fragmentManager, Fragment fragment, int layoutResIs) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(layoutResIs, fragment, fragment.getClass().getSimpleName()).commit();
    }

    public static void changeFragment(FragmentManager fragmentManager, Fragment fragment, int layoutResIs) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(layoutResIs, fragment, fragment.getClass().getSimpleName()).commit();
    }

    public static void changeFragmentWithAnimation(FragmentManager fragmentManager, Fragment fragment, int layoutResIs, FragmentsAnimationId fragmentsAnimationId) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (fragmentsAnimationId) {
            case LEFT_TO_RIGHT:
                fragmentTransaction.setCustomAnimations(R.anim.slide_left_to_right_new_frag, R.anim.slide_left_to_right_old_frag);
                break;
            case RIGHT_TO_LEFT:
                fragmentTransaction.setCustomAnimations(R.anim.slide_right_to_left_new_frag, R.anim.slide_right_to_left_old_frag);
                break;
            case ALPHA:
                fragmentTransaction.setCustomAnimations(R.anim.alpfa_show_content, R.anim.alpfa_hide_content);
                break;
        }
        fragmentTransaction.replace(layoutResIs, fragment, fragment.getClass().getSimpleName()).commit();
    }
}
