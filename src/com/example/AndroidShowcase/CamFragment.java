package com.example.AndroidShowcase;

import java.util.List;

import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CamFragment extends Fragment {
	private static final int CAMERA_REQUEST = 1888; 
	private ImageView imageView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_cam_fragment);
		View view = inflater.inflate(R.layout.activity_cam_fragment, container, false);
	
		Button button = (Button) view.findViewById(R.id.takePictureButton);
		imageView = (ImageView) view.findViewById(R.id.imageView1);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent camera_intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
	            startActivityForResult(camera_intent, CAMERA_REQUEST);

			}});
		//return view;
		return view;
	}
	
//	public static boolean isIntentAvailable(Context context, String action) {
//	    final PackageManager packageManager = context.getPackageManager();
//	    final Intent intent = new Intent(action);
//	    List<ResolveInfo> list =
//	            packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
//	    return list.size() > 0;
//	}

	//private void dispatchTakePictureIntent(int actionCode) {
	//    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	//    startActivityForResult(takePictureIntent, actionCode);
	//}
	
    public void onActivityResult(int requestCode, int resultCode, Intent data) {  
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {  
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }  
    } 
	
}
