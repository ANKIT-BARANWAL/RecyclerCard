package com.example.recyclercard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements Personadapter.Itemclicked {
    TextView name,number;
    Button button;
    EditText etname,etnumber;
    listfrag listfragment;
    FragmentManager managerfrag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        number=findViewById(R.id.number);
        button=findViewById(R.id.button);
        etname=findViewById(R.id.etname);
        etnumber=findViewById(R.id.etnumber);
        managerfrag = this.getSupportFragmentManager();
        listfragment = (listfrag) managerfrag.findFragmentById(R.id.listFrag);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etname.getText().toString().isEmpty() || etnumber.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    ApplicationClass.people.add( new Person(etname.getText().toString().trim(),etnumber.getText().toString().trim()));
                    Toast.makeText(MainActivity.this, "Person added successfully!", Toast.LENGTH_SHORT).show();
                    etname.setText(null);
                    etnumber.setText(null);
                    listfragment.notifyDataChanged();
                }
            }
        });
        onitemclicked(0);
    }

    @Override
    public void onitemclicked(int index) {
        name.setText(ApplicationClass.people.get(index).getName());
        number.setText(ApplicationClass.people.get(index).getNumber());
    }
}