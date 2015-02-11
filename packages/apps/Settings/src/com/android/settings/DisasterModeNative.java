package com.android.settings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


import android.util.Log;


public class DisasterModeNative {
	
	static 
	{
		try
		{
			Log.v("DMN","Begin loading library");			
			System.loadLibrary("DisasterModeN");
			Log.v("DMN","End loading library");
		}

		catch (UnsatisfiedLinkError e) 
		{
			System.err.println("public native code library failed to load.\n" + e);
			Log.e("Tag",e.getMessage());

		}
		try {
			Set<String> libs = new HashSet<String>();
			String mapsFile = "/proc/" + android.os.Process.myPid() + "/maps";
			BufferedReader reader = new BufferedReader(new FileReader(mapsFile));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.endsWith(".so")) {
					int n = line.lastIndexOf(" ");
					libs.add(line.substring(n + 1));
				}
			}
			reader.close();
			Log.d("Ldd", libs.size() + " libraries:");
			for (String lib : libs) {
				Log.d("Ldd", lib);
			}
			
			
			
		} catch (FileNotFoundException e) {
			// Do some error handling...
		} catch (IOException err) {
			// Do some error handling...
		}

	}
	

	public static native int updateColorScheme(int colorID);
	public static native int updateVSync(int rate);
	public static native int updateDMProperty(String key, String value);


	

}
