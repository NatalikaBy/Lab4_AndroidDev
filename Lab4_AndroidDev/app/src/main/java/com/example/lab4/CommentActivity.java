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

public class CommentActivity extends AppCompatActivity {

    public EditText comment;
    public Button save;
    public Button cancel;
    CancelDialog cancelDialog = new CancelDialog();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        this.comment = (EditText) this.findViewById(R.id.editTextComment);
        this.save = (Button) this.findViewById(R.id.saveComment);
        this.cancel = (Button) this.findViewById(R.id.cancelComment);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("keyType", FieldType.FIELD_COMMENT);
                intent.putExtra("keyString", comment.getText().toString());
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