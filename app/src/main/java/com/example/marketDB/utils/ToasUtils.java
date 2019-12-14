package com.example.marketDB.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marketDB.MyApp;
import com.example.marketDB.R;

public class ToasUtils {

    private static final String DEFAUTL_SUCCESS = "success !";
    private static final String DEFAUTL_DEFAULT = "defaults...";
    private static final String DEFAUTL_WARNING = "warning !";
    private static final String DEFAUTL_ERROR = "error ! :(";
    private static final String DEFAUTL_INFO = "info !";

    private static final int DEFAULTS_ID = 1;
    private static final int SUCCESS_ID = 2;
    private static final int WARNING_ID = 3;
    private static final int ERROR_ID = 4;
    private static final int INFO_ID = 5;

    public static void success() {
        success(MyApp.getContext(), DEFAUTL_SUCCESS);
    }

    public static void success(String text) {
        success(MyApp.getContext(), text);
    }

    public static void success(Context context) {
        success(context, DEFAUTL_SUCCESS);
    }

    public static void success(Context context, String txt) {
        showToast(context, txt, SUCCESS_ID);
    }


    public static void error() {
        error(MyApp.getContext(), DEFAUTL_ERROR);
    }

    public static void error(String text) {
        error(MyApp.getContext(), text);
    }

    public static void error(Context context) {
        error(context, DEFAUTL_ERROR);
    }

    public static void error(Context context, String txt) {
        showToast(context, txt, ERROR_ID);
    }


    public static void defaults() {
        defaults(MyApp.getContext(), DEFAUTL_DEFAULT);
    }

    public static void defaults(String text) {
        defaults(MyApp.getContext(), text);
    }

    public static void defaults(Context context) {
        defaults(context, DEFAUTL_DEFAULT);
    }

    public static void defaults(Context context, String txt) {
        showToast(context, txt, DEFAULTS_ID);
    }

    public static void warning() {
        warning(MyApp.getContext(), DEFAUTL_WARNING);
    }

    public static void warning(String text) {
        warning(MyApp.getContext(), text);
    }

    public static void warning(Context context) {
        warning(context, DEFAUTL_WARNING);
    }

    public static void warning(Context context, String txt) {
        showToast(context, txt, WARNING_ID);
    }


    public static void info() {
        info(MyApp.getContext(), DEFAUTL_INFO);
    }

    public static void info(String text) {
        info(MyApp.getContext(), text);
    }

    public static void info(Context context) {
        info(context, DEFAUTL_INFO);
    }

    public static void info(Context context, String txt) {
        showToast(context, txt, INFO_ID);
    }


    private static void showToast(Context context, String string, int color) {
        Toast toast = new Toast(context);
        TextView textview = new TextView(context);

        textview.setText(string);
        textview.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textview.setTextColor(Color.WHITE);
        textview.setPadding(20, 20, 20, 20);
        switch (color) {
            case 1:
                textview.setBackground(MyApp.getContext().getResources().getDrawable(R.drawable.img_toast_background_defaults));
                break;
            case 2:
                textview.setBackground(MyApp.getContext().getResources().getDrawable(R.drawable.img_toast_background_success));
                break;
            case 3:
                textview.setBackground(MyApp.getContext().getResources().getDrawable(R.drawable.img_toast_background_warning));
                break;
            case 4:
                textview.setBackground(MyApp.getContext().getResources().getDrawable(R.drawable.img_toast_background_error));
                break;
            case 5:
                textview.setBackground(MyApp.getContext().getResources().getDrawable(R.drawable.img_toast_background_info));
                break;
        }
        toast.setView(textview);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 40);
        toast.show();
        toast.show();
    }
}
