package com.android.settings;
import java.util.List;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class ColorPickerPreference extends Activity implements SeekBar.OnSeekBarChangeListener {
	SeekBar mRSeekBar = null;
	public ColorPickerPreference() {
		// TODO Auto-generated constructor stub
	}


	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.layout_color_picker);
		mRSeekBar = (SeekBar)findViewById(R.id.rseekbar);
		mRSeekBar.setOnSeekBarChangeListener(this);
		TextView tvHeader = (TextView)findViewById(R.id.idtextheader);
		TextView tvExp = (TextView)findViewById(R.id.idtextexp);
		tvHeader.setText("Color Picker");
		tvExp.setText("Drag the seekbar along until you can see the letter in image above");

	}


	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		if(progress >= 0 && progress <= 7){
			DisasterModeNative.updateDMProperty("dm.colorscheme", String.valueOf(progress));
		}else{
			DisasterModeNative.updateDMProperty("dm.colorscheme", "0");
		}

	}


	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}


	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}




}
