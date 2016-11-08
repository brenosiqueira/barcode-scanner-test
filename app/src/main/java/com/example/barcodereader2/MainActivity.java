package com.example.barcodereader2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class MainActivity extends AppCompatActivity {

    TextView barcodeValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barcodeValue = (TextView) findViewById(R.id.barcode_value);
    }


    public void scanBarcode(View view){
        Intent intent = new Intent(this,ScanBarcodeActivity.class);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 0){
            if(CommonStatusCodes.SUCCESS == resultCode){
                if (data != null){
                    Barcode barcode = data.getParcelableExtra("barcode");
                    barcodeValue.setText(barcode.displayValue);
                }
            }

        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
