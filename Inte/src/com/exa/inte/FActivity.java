package com.exa.inte;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FActivity  extends Activity{
	private Button bu;
	private Context mContext;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fa);
		mContext = this;
		bu =(Button)findViewById(R.id.button);
		
		bu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent= new Intent(mContext,SActivity.class);
				startActivity(intent);
				
			}
		});
	}

}
