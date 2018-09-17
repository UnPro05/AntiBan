package ru.udreams.fixrulet;

import android.app.*;
import android.content.*;
import android.net.*;
import android.os.*;
import android.preference.*;
import android.text.*;
import android.view.*;
import android.widget.*;
import java.io.*;
import java.lang.Process;

public class MainActivity extends Activity 
{
	TextView etText;
	SharedPreferences sPref;
	final String PATH = "path";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        setTheme(R.style.AppTheme);
		ActionBar actionBar = getActionBar();
		Window window = getWindow();
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setCustomView(R.layout.mbar);
		//actionBar.setTitle(Html.fromHtml("<font color=\"#498AF4\">" + "Антибан" + "</font>"));
		//actionBar.setSubtitle(Html.fromHtml("<font color=\"#498AF4\">" + "для чат-рулетки" + "</font>"));
		actionBar.setBackgroundDrawable(getResources().getDrawable(R.color.colorPrimary)); 
		window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
		actionBar.show();
		//dialog = new Dialog(MainActivity.this);
		//dialog.setTitle((Html.fromHtml("<font color=\"#498AF4\">" + "О приложении" + "</font>")));
		//dialog.setContentView(R.layout.about);
		setContentView(R.layout.main);
		super.onCreate(savedInstanceState);
		return;
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
			case R.id.abouuut:
				Intent intent = new Intent(); 
				intent.setClass(this, About.class); 
				startActivity(intent); 
				return true;
            default:
                return true;
        }
    }
	
	public void aaa(View v){
		TextView mb = findViewById(R.id.mb);
		mb.setText("Нет, это всё :)");
		return;
	}

	public static void shell(String...strings) {
		try{
			Process su = Runtime.getRuntime().exec("sh");
			DataOutputStream outputStream = new DataOutputStream(su.getOutputStream());

			for (String s : strings) {
				outputStream.writeBytes(s+"\n");
				outputStream.flush();
			}

			outputStream.writeBytes("exit\n");
			outputStream.flush();
			try {
				su.waitFor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			outputStream.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return;
	}

	public void run(View v) throws Exception{
		TextView tv = findViewById(R.id.tv);
		shell("find /storage/emulated/0/ -iname data -size +190 -size -260 -delete");
		tv.setTextColor(getResources().getColor(R.color.colorAccent));
		tv.setText("СТАТУС: РАЗБЛОКИРОВАН [1]");
		return;
	}
	public void rune(View v) throws Exception{
		TextView tv = findViewById(R.id.tv);
		shell("find /storage/emulated/0/ -iname data -size -260 -delete");
		tv.setTextColor(getResources().getColor(R.color.colorAccent));
		tv.setText("СТАТУС: РАЗБЛОКИРОВАН [2]");
		return;
	}
	public void runer(View v) throws Exception{
		loadText();
		TextView tv = findViewById(R.id.tv);
		tv.setTextColor(getResources().getColor(R.color.colorAccent));
		tv.setText("СТАТУС: РАЗБЛОКИРОВАН [3]");
		return;
	}
	public void done(View v){
		String one = "https://play.google.com/store/apps/details?id=com.chat.ruletka";
		Intent doo = new Intent(Intent.ACTION_VIEW);
		doo.setData(Uri.parse(one));
		startActivity(doo);
		return;
	}
	public void dtwo(View v){
		String one = "https://play.google.com/store/apps/details?id=com.chatroullete.alternative";
		Intent doo = new Intent(Intent.ACTION_VIEW);
		doo.setData(Uri.parse(one));
		startActivity(doo);
		return;
	}
	public void dthree(View v){
		String one = "https://play.google.com/store/apps/details?id=omegle.tv";
		Intent doo = new Intent(Intent.ACTION_VIEW);
		doo.setData(Uri.parse(one));
		startActivity(doo);
		return;
	}

	@Override
	protected void onStart()
	{
		etText = findViewById(R.id.path);
		sPref = getSharedPreferences("Path", MODE_PRIVATE);
		String path = sPref.getString(PATH, "");
		etText.setText(path);
		super.onStart();
	}
	@Override
	public void onResume() {
		etText = findViewById(R.id.path);
		sPref = getSharedPreferences("Path", MODE_PRIVATE);
		String path = sPref.getString(PATH, "");
		etText.setText(path);
		super.onResume();
	}
		
	void loadText() {
		sPref = getSharedPreferences("Path", MODE_PRIVATE);
		String path = sPref.getString(PATH, "");
		shell("find " + path + " -iname data -size -260 -delete");
	}
}
