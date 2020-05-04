package com.svanberggroup.pfago.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Trace;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;


import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.svanberggroup.pfago.Fragments.*;
import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.Models.ControlRow;
import com.svanberggroup.pfago.Models.ImageData;
import com.svanberggroup.pfago.Models.Vehicle;
import com.svanberggroup.pfago.R;
import com.svanberggroup.pfago.Repository.ControlRepository;
import com.svanberggroup.pfago.Utils.PictureUtils;
import com.svanberggroup.pfago.Utils.ViewPagerAdapter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class AddControlActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private Control control;

    private String currentPhotoPath;
    private File photoFile;
    private List<ControlRow> controlRowList;
    private boolean breakingTheLaw;
    private boolean breakingTheLawIsEnabled = false;
    private boolean imagesIsEnabled = false;

    private static final int REQUEST_IMAGE_CAPTURE = 115;
    private static final int REQUEST_CONTROL_APPROVAL = 5;

    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_control);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tabs);
        control = new Control();
        adapter = createCardAdapter();
        viewPager.setAdapter(adapter);
        addFragments();

        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                        tab.setText(adapter.getTitle(position));
                    }
                }).attach();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_control_menu, menu);
        return true;
    }

    private ViewPagerAdapter createCardAdapter() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(this, control);
        return adapter;
    }

    private void addFragments() {
        adapter.addFragment(FragmentOne.newInstance(control), "Fordon", 0);
        adapter.addFragment(FragmentTwo.newInstance(control), "Förare", 1);
        adapter.addFragment(FragmentThree.newInstance(control), "Platser", 2);
        adapter.addFragment(FragmentFour.newInstance(control), "Gods", 3);
        adapter.addFragment(FragmentFive.newInstance(control), "Handlingar", 4);
        adapter.addFragment(FragmentSeven.newInstance(control), "Transport", 5);
        adapter.addFragment(FragmentSix.newInstance(control), "Utrustning", 6);
        adapter.addFragment(FragmentEight.newInstance(control), "Övrigt", 7);
        //adapter.addFragment(ImagesFragment.newInstance(control), "Bilder", 8);

    }
    public void addImagesFragment() {
        Fragment fragment = ImagesFragment.newInstance(control);
        adapter.addFragment(fragment, "Bilder", adapter.getItemCount());
        adapter.notifyDataSetChanged();
    }
    public void addBreakingTheLawFragment() {
        if(!breakingTheLawIsEnabled) {
            breakingTheLawIsEnabled = true;
            Fragment fragment = BreakingTheLawFragment.newInstance(control);
            adapter.addFragment(fragment, "Rapport", adapter.getItemCount());
            adapter.notifyDataSetChanged();
        }

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.doneControl:
                Log.i("TESTTEST", "going to viewControl");
                intent = new Intent(this, ViewControlActivity.class);
                intent.putExtra("control", control);
                intent.putExtra("approvalMode", true);
                Log.i("TESTTEST", "about to startForResult" + intent);
                startActivityForResult(intent, REQUEST_CONTROL_APPROVAL);
                break;
            case R.id.cameraControl:
                dispatchTakePictureIntent();
                break;
            case R.id.ribControl:
                intent = new Intent(this,RIBActivity.class);
                intent.putExtra("searchActivity", true);
                startActivity(intent);
                break;
            case R.id.mainControl:
                intent = new Intent(this,MainActivity.class);
                intent.putExtra("searchActivity", true);
                startActivity(intent);
                break;
            default: return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Är du säker på att du vill avsluta utan att spara?");
        builder.setPositiveButton("Ja", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("Nej", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            if(!imagesIsEnabled){
                imagesIsEnabled = true;
                addImagesFragment();
            }
            Toast.makeText(this, "Bild sparad i fliken bilder", Toast.LENGTH_LONG).show();
            control.addImage(new ImageData(currentPhotoPath));
        } else if (requestCode == REQUEST_CONTROL_APPROVAL) {
            if(data != null){
                Boolean approved = data.getBooleanExtra("approved", false);
                if(approved){
                    Toast.makeText(this,"Kontrollen sparad", Toast.LENGTH_LONG).show();
                    control.setEndDate(new Date());
                    ControlRepository.get().addControl(control);
                    showOptionsAlert();
                }
            }
        }
    }
    private void showOptionsAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setCancelable(false);
        builder.setMessage("Vill du skicka rapporten i ett mail?");
        builder.setPositiveButton("Ja", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_SUBJECT, "FAGO Kontroll");
                if(control.getTruck()!=null){
                    intent.putExtra(Intent.EXTRA_TEXT, "Se bifogat PDF av FAGO kontroll för " + control.getTruck().getRegNr());
                }
                intent.setType("message/rfc822");
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("Nej", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                finish();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
    // CAMERA ----------STUFF

    public void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                Log.i("CAMERA_RESULT", "Error: "+ ex.getMessage());
                ex.printStackTrace();
                // Error occurred while creating the File

            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.svanberggroup.pfago.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                Log.i("CAMERA_RESULT", "requestCode:" + REQUEST_IMAGE_CAPTURE + " photofile path: " + photoFile.getAbsolutePath());
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }

    }




    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

}
