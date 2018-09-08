package com.example.asus.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.security.PrivateKey;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editID;
    private EditText editName;

    private RadioGroup radGroup;

    private Button btnNhap;

    private ListView lvNV;

    ArrayList<Employee> arrEmployee=new ArrayList<Employee>();
    ArrayAdapter<Employee> arrAdapter=null;

    Employee employee=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        initWidget();
        setEventClickViews();

        arrAdapter=new ArrayAdapter<Employee>(this,android.R.layout.simple_list_item_1,arrEmployee);
        lvNV.setAdapter(arrAdapter);
    }

    public void initWidget(){
        editID=(EditText)findViewById(R.id.edtMaNV);
        editName=(EditText)findViewById(R.id.edtTenNV);
        btnNhap=(Button)findViewById(R.id.btnNhap);
        radGroup=(RadioGroup)findViewById(R.id.radiogroup);
        lvNV=(ListView)findViewById(R.id.lvNV);
    }

    public void setEventClickViews(){
        btnNhap.setOnClickListener(this);
    }

    public void nhap()
    {
        int radID=radGroup.getCheckedRadioButtonId();
        String id=editID.getText()+"";
        String name=editName.getText()+"";
        if(radID==R.id.radChinhThuc)
        {
            employee=new EmployeeFullTime();
        }
        else
        {
            employee =new EmpoyeePartTime();
        }
        employee.setId(id);
        employee.setName(name);

        arrEmployee.add(employee);
        arrAdapter.notifyDataSetChanged();


    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnNhap:
                nhap();

                break;
                default:
                    break;
        }
    }

}
