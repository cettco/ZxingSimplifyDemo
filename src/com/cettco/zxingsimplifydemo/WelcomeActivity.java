package com.cettco.zxingsimplifydemo;

import com.cettco.zxingsimplifydemo.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends Activity {

	private Button btnScan;
	private TextView textViewScan;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		textViewScan = (TextView)findViewById(R.id.textViewScan);
		btnScan = (Button)findViewById(R.id.btnScan);
		btnScan.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub  
                Intent intent = new Intent();
                intent.setClass(WelcomeActivity.this, CaptureActivity.class);
                //intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intent, 0);
            }
        });
		
	}
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
           if (resultCode == RESULT_OK) {
               
              String contents = intent.getStringExtra("qrcode");
              String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
              textViewScan.setText(contents);
              
           
              // Handle successful scan
                                        
           } else if (resultCode == RESULT_CANCELED) {
              // Handle cancel
              Log.i("App","Scan unsuccessful");
           }
      }
   }
	
}
