package ru.udreams.fixrulet;

import android.app.*;
import android.content.*;
import android.content.SharedPreferences.*;
import android.net.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import ru.udreams.fixrulet.*;

public class About extends Activity {
	EditText etText;
	SharedPreferences sPref;
	final String PATH = "path";
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		ActionBar actionBar = getActionBar();
		Window window = getWindow();
		setContentView(R.layout.about);
		//addPreferencesFromResource(R.xml.pref);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setCustomView(R.layout.abar);
		actionBar.setBackgroundDrawable(getResources().getDrawable(R.color.colorPrimary)); 
		window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
		actionBar.show();
		etText = findViewById(R.id.EditText);
		return;
	}
	public void a(View v){
		String site = "http://4pda.ru/forum/index.php?showtopic=738626";
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(site));
		startActivity(intent);}
		
	public void b(View v){
		String site = "http://4pda.ru/forum/index.php?showuser=4916296";
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(site));
		startActivity(intent);}
	
	public void set(View v){
		saveText();
		return;
	}
	
	void saveText() {
		sPref = getSharedPreferences("Path", MODE_PRIVATE);
		Editor ed = sPref.edit();
		ed.putString(PATH, etText.getText().toString());
		ed.commit();
		Toast.makeText(this, "Путь сохранён", Toast.LENGTH_SHORT).show();
	}
}
