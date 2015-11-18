package com.androidbootcamp.medicalcalculator;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	/**called when the activity is first  created**/
	double conversionRate=2.2;
	double weightEntered;
	double convertedWeight;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final EditText weight=(EditText)findViewById(R.id.txtWeight);
		final RadioButton LbToKilo=(RadioButton)findViewById(R.id.radLbToKilo);
		final RadioButton KiloToLb=(RadioButton)findViewById(R.id.radKiloToLb);
		
		final TextView result=(TextView)findViewById(R.id.txtResult);
		
		Button convert=(Button)findViewById(R.id.btnConvert);
		
	    convert.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				weightEntered=Double.parseDouble(weight.getText().toString());//converts weight into double type data
				DecimalFormat tenth=new DecimalFormat("#.#");
				
				if(LbToKilo.isChecked()){
					if (weightEntered<=500){
						convertedWeight=weightEntered/conversionRate;
						result.setText(tenth.format(convertedWeight)+"kilograms");
								
												
					}
					else{
						Toast.makeText(MainActivity.this,"pounds must be less than 500",Toast.LENGTH_LONG).show();
					}
				}
				
				if(KiloToLb.isChecked()){
					if (weightEntered<=225){
						convertedWeight=weightEntered*conversionRate;
						result.setText(tenth.format(convertedWeight)+"pounds");
								
												
					}
					else{
						Toast.makeText(MainActivity.this,"kilos must be less than 225",Toast.LENGTH_LONG).show();
					}
				}
			}
		});
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
