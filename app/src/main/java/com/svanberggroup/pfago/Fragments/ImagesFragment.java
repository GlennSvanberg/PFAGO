package com.svanberggroup.pfago.Fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.svanberggroup.pfago.Activities.AddControlActivity;
import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.Models.ImageData;
import com.svanberggroup.pfago.R;
import com.svanberggroup.pfago.Utils.PictureUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ImagesFragment extends Fragment {


    private static final String NEW_CONTROL = "new_control";
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private Control control;
    private LinearLayout  cardsLinearLayout;
    private Button addImageButton;

    private List<View> views;


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
        views = new ArrayList<>();
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
        addImageButton = view.findViewById(R.id.add_image_button);

        updateUI(inflater);
        addImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AddControlActivity)getActivity()).dispatchTakePictureIntent();
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService((Context.LAYOUT_INFLATER_SERVICE));
        updateUI(inflater);


    }
    private void updateUI(LayoutInflater inflater){
        if(views.size() != control.getImages().size()){
            cardsLinearLayout.removeAllViews();

            views = new ArrayList<>();
            List<ImageData> images = control.getImages();
            for(int i = 0; i < images.size(); i++) {
                View v = inflater.inflate(R.layout.image_card, cardsLinearLayout, false);
                views.add(v);
                final ImageData image = images.get(i);
                ImageView imageView = v.findViewById(R.id.image_view);
                Bitmap bitmap = getScaledBitmap(image.getPath(), 1400,800);
                imageView.setImageBitmap(bitmap);

                TextView textView = v.findViewById(R.id.card_title);
                textView.setText("Bild " + (i + 1));

                ImageButton deleteButton = v.findViewById(R.id.delete_button);
                deleteButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        images.remove(image);
                        updateUI(inflater);
                    }
                });

                EditText editText = v.findViewById(R.id.edit_image_text);
                if(image.getText() != ""){
                    editText.setText(image.getText());
                }
                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if(s.length() > 0) {
                            control.setLocation(s.toString());
                            image.setText(s.toString());
                        } else {
                            image.setText("");
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
            }
            displayViews(cardsLinearLayout, views);
        }

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
        Bitmap bitmap = BitmapFactory.decodeFile(path, options);
        // Read in and create final bitmap
        ExifInterface ei = null;
        try {
            ei = new ExifInterface(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION,
                ExifInterface.ORIENTATION_UNDEFINED);

        Bitmap rotatedBitmap = null;
        switch(orientation) {

            case ExifInterface.ORIENTATION_ROTATE_90:
                rotatedBitmap = rotateImage(bitmap, 90);
                break;

            case ExifInterface.ORIENTATION_ROTATE_180:
                rotatedBitmap = rotateImage(bitmap, 180);
                break;

            case ExifInterface.ORIENTATION_ROTATE_270:
                rotatedBitmap = rotateImage(bitmap, 270);
                break;

            case ExifInterface.ORIENTATION_NORMAL:
            default:
                rotatedBitmap = bitmap;
        }

        return rotatedBitmap;
    }
    public static Bitmap rotateImage(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(),
                matrix, true);
    }
}
