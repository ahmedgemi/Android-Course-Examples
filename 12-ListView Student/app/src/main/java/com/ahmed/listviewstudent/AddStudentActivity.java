package com.ahmed.listviewstudent;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddStudentActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    Button button;
    EditText editText,editText2;

    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);

        imageView = findViewById(R.id.imageView2);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.imageView2:
                checkPermission();
                break;

            case R.id.button:
                addStudent();
                break;
        }
    }

    private void checkPermission(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

            if (
                    ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                            ==
                            PackageManager.PERMISSION_GRANTED){

                pickImage();
            }
            else{
                String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                ActivityCompat.requestPermissions(this,permissions,400);
            }
        }
        else {
            pickImage();
        }
    }

    private void pickImage(){

        Intent intent = new Intent(Intent.ACTION_PICK); //android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        intent.setType("image/*");

        startActivityForResult(intent,100);
    }

    private void addStudent(){

        String name = editText.getText().toString();
        String grade = editText2.getText().toString();

        if(name.isEmpty()){
            Toast.makeText(this,"Please Enter Name",Toast.LENGTH_SHORT).show();
            return;
        }

        if(grade.isEmpty()){
            Toast.makeText(this,"Please Enter Grade",Toast.LENGTH_SHORT).show();
            return;
        }

        Student student;
        if (imageUri==null)
            student = new Student(name,grade);
        else
            student = new Student(name,grade,imageUri.toString());

        Bundle bundle = new Bundle();
        bundle.putSerializable("data",student);

        Intent intent = new Intent();
        intent.putExtras(bundle);

        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==100 && resultCode == RESULT_OK){

            imageUri = data.getData();

            imageView.setImageURI(imageUri);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode==400 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            pickImage();
        }
        else {
            Toast.makeText(this,"App Need this permission",Toast.LENGTH_SHORT).show();
        }
    }
}
