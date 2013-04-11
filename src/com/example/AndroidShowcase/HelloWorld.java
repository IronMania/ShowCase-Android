package com.example.AndroidShowcase;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HelloWorld extends Fragment  {

	
	private EditText input;
	private TextView outPut ;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//View view = inflater.inflate(R.layout.activity_hello_world_fragment,
				//container, false);

		//Button nextButton = (Button) view.findViewById(R.id.container);
		//nextButton.setOnClickListener(this);
		View view = inflater.inflate(R.layout.activity_hello_world_fragment, container, false);
		Button button = (Button) view.findViewById(R.id.button1);
		input = (EditText) view.findViewById(R.id.helloWorldInput);
		outPut = (TextView) view.findViewById(R.id.helloWorldOutput);
		
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//input = (EditText) v.findViewById(R.id.helloWorldInput);
				//outPut = (TextView) v.findViewById(R.id.helloWorldOutput);
				outPut.setText("Hello " + input.getText() + "!");

			}});
		
		
		//return view;
		return view;
	}

}
