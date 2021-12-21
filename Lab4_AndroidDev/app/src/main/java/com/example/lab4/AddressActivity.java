package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddressActivity extends AppCompatActivity {

    public EditText country;
    public EditText city;
    public EditText address;
    public Button save;
    public Button cancel;
    CancelDialog cancelDialog = new CancelDialog();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        this.country = (EditText) this.findViewById(R.id.editTextCountry);
        this.city = (EditText) this.findViewById(R.id.editTextCity);
        this.address = (EditText) this.findViewById(R.id.editTextAddress);
        this.save = (Button) this.findViewById(R.id.saveAddress);
        this.cancel = (Button) this.findViewById(R.id.cancelAddress);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("keyType", FieldType.FIELD_ADDRESS);
                intent.putExtra("keyString", country.getText().toString()+", "+ city.getText().toString()+", "+ address.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelDialog.show(getSupportFragmentManager(), "tag");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cancel, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.cancelMenu){
            cancelDialog.show(getSupportFragmentManager(), "tag");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}