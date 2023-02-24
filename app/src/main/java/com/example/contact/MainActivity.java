package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private String[] city={"Hà Nội","Thành phố Hồ Chí Minh","Hải Phòng","Cần thơ"};
    private EditText txtusername,txtphonenumber;
    private RadioButton rdbnam,rdbnu;
    private Button btnadd;
    private ArrayList<String> list;
    private  ListView lvid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spino=findViewById(R.id.spinner);
        spino.setOnItemSelectedListener(this);

        ArrayAdapter ad= new ArrayAdapter(this, android.R.layout.simple_spinner_item,city);
        ad.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );
        spino.setAdapter(ad);
        txtusername=findViewById(R.id.txtusername);
        txtphonenumber=findViewById(R.id.txtphonenumber);
        rdbnam=findViewById(R.id.rdbnam);
        rdbnu=findViewById(R.id.rdbnu);
        btnadd=findViewById(R.id.btnadd);
        lvid=findViewById(R.id.lvid);
        list= new ArrayList<String>();
        ArrayAdapter<String> adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
        lvid.setAdapter(adapter);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item=txtusername.getText().toString();
                item+="-"+txtphonenumber.getText().toString();
                if (rdbnam.isChecked())
                    item+="-"+rdbnam.getText().toString();
                if (rdbnu.isChecked())
                    item+="-"+rdbnu.getText().toString();
                item+="-"+spino.getSelectedItem().toString();
                list.add(item);
                adapter.notifyDataSetChanged();
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(),city[i] , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Auto-generated method stub
    }
}