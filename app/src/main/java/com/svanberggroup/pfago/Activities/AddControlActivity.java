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
import com.svanberggroup.pfago.Fragments.FragmentOne;
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

    private static final int REQUEST_IMAGE_CAPTURE = 115;
    private static final int REQUEST_CONTROL_APPROVAL = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_control);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tabs);
        control = new Control();
        viewPager.setAdapter(createCardAdapter());

        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position) {
                            case 0:
                                tab.setText("Fordon");
                                break;
                            case 1:
                                tab.setText("Förare");
                                break;
                            case 2:
                                tab.setText("Platser");
                                break;
                            case 3:
                                tab.setText("Gods");
                                break;
                            case 4:
                                tab.setText("Handlingar");
                                break;
                            case 5:
                                tab.setText("Handlingar1");
                                break;
                            case 6:
                                tab.setText("Transport");
                                break;
                            case 7:
                                tab.setText("Övrigt");
                                break;
                            case 8:
                                tab.setText("Bilder");
                                break;
                        }
                    }
                }).attach();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_control_menu, menu);
        return true;
    }

    private void getControlRows() {
        ControlRow controlRow1 = control.getTdRows().getApprovalRow();
        ControlRow controlRow2 = control.getTdRows().getApprovalCertificateRow();
        ControlRow controlRow3 = control.getTdRows().getDriverCertificationRow();
        ControlRow controlRow4 = control.getTdRows().getGoodsDeclarationRow();
        ControlRow controlRow5 = control.getTdRows().getWrittenInstructionsRow();
        ControlRow controlRow6 = control.getTdRows().getOtherADRTrainingRow();

        ControlRow controlRow7 = control.getTRows().getRow18();
        ControlRow controlRow8 = control.getTRows().getRow19();
        ControlRow controlRow9 = control.getTRows().getRow20();
        ControlRow controlRow10 = control.getTRows().getRow21();
        ControlRow controlRow11 = control.getTRows().getRow22_1();
        ControlRow controlRow12 = control.getTRows().getRow22_2();
        ControlRow controlRow13 = control.getTRows().getRow22_3();
        ControlRow controlRow14 = control.getTRows().getRow23_1();
        ControlRow controlRow15 = control.getTRows().getRow23_2();
        ControlRow controlRow16 = control.getTRows().getRow24();
        ControlRow controlRow17 = control.getTRows().getRow25_1();
        ControlRow controlRow18 = control.getTRows().getRow25_2();
        ControlRow controlRow19 = control.getTRows().getRow26();
        ControlRow controlRow20 = control.getTRows().getRow27();
        ControlRow controlRow21 = control.getTRows().getRow28_1();
        ControlRow controlRow22 = control.getTRows().getRow28_2();
        ControlRow controlRow23 = control.getTRows().getRow28_3();
        ControlRow controlRow24 = control.getTRows().getRow28_4();
        ControlRow controlRow25 = control.getTRows().getRow29();
        ControlRow controlRow26 = control.getTRows().getRow31();
        List<ControlRow> controlRows = control.getTRows().getRows40();

        controlRowList = new ArrayList<>();
        controlRowList.add(controlRow1);
        controlRowList.add(controlRow2);
        controlRowList.add(controlRow3);
        controlRowList.add(controlRow4);
        controlRowList.add(controlRow5);
        controlRowList.add(controlRow6);
        controlRowList.add(controlRow7);
        controlRowList.add(controlRow8);
        controlRowList.add(controlRow9);
        controlRowList.add(controlRow10);
        controlRowList.add(controlRow11);
        controlRowList.add(controlRow12);
        controlRowList.add(controlRow13);
        controlRowList.add(controlRow14);
        controlRowList.add(controlRow15);
        controlRowList.add(controlRow16);
        controlRowList.add(controlRow17);
        controlRowList.add(controlRow18);
        controlRowList.add(controlRow19);
        controlRowList.add(controlRow20);
        controlRowList.add(controlRow21);
        controlRowList.add(controlRow22);
        controlRowList.add(controlRow23);
        controlRowList.add(controlRow24);
        controlRowList.add(controlRow25);
        controlRowList.add(controlRow26);
        for (ControlRow row: controlRows) {
            controlRowList.add(row);
        }
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.doneControl:
//                getControlRows();
//                for (ControlRow row: controlRowList) {
//                    if (row.getField() == ControlRow.Field.BreakingTheLaw) {
//                        breakingTheLaw = true;
//                    } else {
//                        breakingTheLaw = false;
//                    }
//                }
                breakingTheLaw = true;
                if (!breakingTheLaw) {
                    intent = new Intent(this, ViewControlActivity.class);
                    intent.putExtra("control", control);
                    intent.putExtra("approvalMode", true);
                    startActivityForResult(intent, REQUEST_CONTROL_APPROVAL);
                    break;
                } else {
                    intent = new Intent(this, BreakingTheLawActivity.class);
                    intent.putExtra("control", control);
                    startActivity(intent);
                    break;
                }
            case R.id.cameraControl:
                dispatchTakePictureIntent();
                break;
            case R.id.ribControl:
                intent = new Intent(this,RIBActivity.class);
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

    private ViewPagerAdapter createCardAdapter() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(this, control);
        return adapter;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("CAMERA_RESULT", "onActivityResult");
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
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
            Log.i("CAMERA_RESULT", "requestCode:" + requestCode + " RESULT: " + resultCode);
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
