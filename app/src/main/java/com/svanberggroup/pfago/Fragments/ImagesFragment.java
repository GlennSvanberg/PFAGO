package com.svanberggroup.pfago.Fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ImagesFragment extends Fragment {


    private static final String NEW_CONTROL = "new_control";
    private Control control;
    private LinearLayout  cardsLinearLayout;

    public ImagesFragment() {
        // Required empty public constructor
    }

    public static ImagesFragment newInstance(Control control) {
        ImagesFragment fragment = new ImagesFragment();
        Bundle args = new Bundle();
        args.putSerializable(NEW_CONTROL, (Serializable) control);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            control = (Control) getArguments().getSerializable(NEW_CONTROL);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_images, container, false);
        cardsLinearLayout = view.findViewById(R.id.linear_layout);


        List<View> views = new ArrayList<>();

        for(String path : control.getPhotoPathList()) {
            Log.i("IMAGE_PATH", path);
            View v = inflater.inflate(R.layout.image_card, cardsLinearLayout, false);
            views.add(v);
            ImageView imageView = v.findViewById(R.id.image_view);
            Bitmap bitmap = getScaledBitmap(path, 400,400);
            imageView.setImageBitmap(bitmap);
        }
        displayViews(cardsLinearLayout, views);
        return view;
    }

    private void displayViews(LinearLayout layout, List<View> views) {
        for(View v : views) {
            layout.addView(v);
        }
    }


    public static Bitmap getScaledBitmap(String path, int destWidth, int destHeight) {
        // Read in the dimensions of the image on disk
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        float srcWidth = options.outWidth;
        float srcHeight = options.outHeight;

        // Figure out how much to scale down by
        int inSampleSize = 1;
        if (srcHeight > destHeight || srcWidth > destWidth) {
            float heightScale = srcHeight / destHeight;
            float widthScale = srcWidth / destWidth;

            inSampleSize = Math.round(heightScale > widthScale ? heightScale :
                    widthScale);
        }

        options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;

        // Read in and create final bitmap
        return BitmapFactory.decodeFile(path, options);
    }
}
