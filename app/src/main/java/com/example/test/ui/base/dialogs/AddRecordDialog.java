package com.example.test.ui.base.dialogs;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.example.test.R;

import java.util.Objects;

public class AddRecordDialog extends DialogFragment {

    private static final String HEAD = "head";
    private static final String BODY = "body";
    private static final String POSITIVE = "positive";
    private static final String NEGATIVE = "negative";
    private String head;
    private String body;
    private String positive;
    private String negative;

    private Button btn_confirm;
    private Button btn_cancel;
    private EditText et_dialog_name;
    private EditText et_dialog_stock_id;
    private Event event;

    public static AddRecordDialog newInstance() {
        return new AddRecordDialog();
    }

    public static AddRecordDialog newInstance(String body) {
        AddRecordDialog fragment = new AddRecordDialog();
        Bundle bundle = new Bundle();
        bundle.putString(BODY, body);
        fragment.setArguments(bundle);
        return fragment;
    }

    public static AddRecordDialog newInstance(String head, String body) {
        AddRecordDialog fragment = new AddRecordDialog();
        Bundle bundle = new Bundle();
        bundle.putString(HEAD, head);
        bundle.putString(BODY, body);
        fragment.setArguments(bundle);
        return fragment;
    }

    public static AddRecordDialog newInstance(String head, String body, String positive, String negative) {
        AddRecordDialog fragment = new AddRecordDialog();
        Bundle bundle = new Bundle();
        bundle.putString(HEAD, head);
        bundle.putString(BODY, body);
        bundle.putString(POSITIVE, positive);
        bundle.putString(NEGATIVE, negative);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        head = getResources().getString(R.string.dialog_default_head_string);
//        body = getResources().getString(R.string.dialog_default_body_string);
//        positive = getResources().getString(R.string.dialog_default_positive_string);
//        negative = getResources().getString(R.string.dialog_default_negative_string);

        if (getArguments() != null) {
            head = getArguments().getString(HEAD, head);
            body = getArguments().getString(BODY, body);
            positive = getArguments().getString(POSITIVE, positive);
            negative = getArguments().getString(NEGATIVE, negative);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Objects.requireNonNull(getDialog().getWindow()).setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        if (event != null)
            event.isDismis();
        super.onDismiss(dialog);
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
    }

    @Override
    public void onActivityCreated(Bundle arg0) {
        super.onActivityCreated(arg0);
        Objects.requireNonNull(getDialog().getWindow()).getAttributes().windowAnimations = R.style.DialogShowAnimation;
    }


    public void registerEvent(Event event) {
        this.event = event;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(false);
        Objects.requireNonNull(getDialog().getWindow()).setBackgroundDrawableResource(R.color.colorTransparentBlack);
        View v = inflater.inflate(R.layout.dialog_change_record, container, false);

        et_dialog_name = v.findViewById(R.id.et_market_name);
        btn_confirm = v.findViewById(R.id.btn_confirm);
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (event != null) {
                    if (et_dialog_name.getText() != null) {
                        event.confirm();
                    } else {
//                        ToasUtils.warning("wrong password");
                        event.failed();
                    }
                }
                dismiss();
            }
        });
        btn_confirm.setText(positive);

        btn_cancel = v.findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        btn_cancel.setText(negative);

        return v;
    }

    public interface Event {

        void confirm();

        void failed();

        void isDismis();
    }
}