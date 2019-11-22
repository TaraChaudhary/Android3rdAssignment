package com.example.a3rdassignment.ui.Student;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.a3rdassignment.Model.Student;
import com.example.a3rdassignment.R;
import com.example.a3rdassignment.ui.home.HomeFragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentFragment extends Fragment implements RadioGroup.OnCheckedChangeListener,View.OnClickListener {

    private StudentViewModel studentViewModel;
    EditText editname, editage,editaddress;
    RadioGroup radioGroup;
    String name,gender, age, address;
    int image;
    Button save;

    public static List<Student> studentlist = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       studentViewModel =
                ViewModelProviders.of(this).get(StudentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_addstudent, container, false);

      editname    =root.findViewById(R.id.name);
        editage   = root.findViewById(R.id.age);

        editaddress    = root.findViewById(R.id.address);
        radioGroup      = root.findViewById(R.id.gender_radio_group);

        save        = root.findViewById(R.id.save);
        radioGroup.setOnCheckedChangeListener(this);

        save.setOnClickListener(this);
        return root;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId == R.id.male){
            gender = "Male";
            image=R.drawable.blankimg;
        }

        if(checkedId == R.id.female){
            gender = "Female";
            image=R.drawable.female;
        }

        if(checkedId == R.id.other){
            gender = "Other";
        }
    }

    @Override
    public void onClick(View v) {
        name = editname.getText().toString();
        age = editage.getText().toString();

        address = editaddress.getText().toString();



        if (v.getId() == R.id.save) {

            if (validate()) {


                studentlist.add(new Student(name, age, gender, address,image));
                Toast.makeText(getActivity(),"Student Added", Toast.LENGTH_SHORT).show();


            }

        }
    }
        private boolean validate(){
            if (TextUtils.isEmpty(name)) {
                editname.setError("Please Enter Full Name");
                editname.requestFocus();
                return false;

            }
            if (TextUtils.isEmpty(age)) {
                editage.setError("Please Enter Age");
                editage.requestFocus();
                return false;
            }

            if(TextUtils.isEmpty(gender)){
                Toast.makeText(getContext(), "Select Gender", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (TextUtils.isEmpty(address)) {
                editaddress.setError("Please Enter Address");
                editaddress.requestFocus();
                return false;
            }

            return true;
        }


    }
