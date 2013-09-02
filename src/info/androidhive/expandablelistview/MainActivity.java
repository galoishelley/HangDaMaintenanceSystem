package info.androidhive.expandablelistview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.ImageView;
import android.widget.Toast;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.app.ProgressDialog;
import android.widget.TextView;

public class MainActivity extends Activity {

	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;
	ImageView imgView;
	private WebView webView;
    private static final String TAG = "Main";
    private ProgressDialog progressBar;
    private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// get the listview
		expListView = (ExpandableListView) findViewById(R.id.lvExp);
		textView= (TextView)findViewById(R.id.textView1);

		// preparing list data
		prepareListData();
		
		
		imgView = (ImageView) findViewById(R.id.top);
		imgView.setImageResource(R.drawable.top);
		
//		this.webview = (WebView)findViewById(R.id.webView1);
//
//        WebSettings settings = webview.getSettings();
//        settings.setJavaScriptEnabled(true);
//        webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
//
//        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
//
//        progressBar = ProgressDialog.show(MainActivity.this, "WebView Example", "Loading...");
//
//        webview.setWebViewClient(new WebViewClient() {
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                Log.i(TAG, "Processing webview url click...");
//                view.loadUrl(url);
//                return true;
//            }
//
//            public void onPageFinished(WebView view, String url) {
//                Log.i(TAG, "Finished loading URL: " +url);
//                if (progressBar.isShowing()) {
//                    progressBar.dismiss();
//                }
//            }
//
//            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
//                Log.e(TAG, "Error: " + description);
//                Toast.makeText(activity, "Oh no! " + description, Toast.LENGTH_SHORT).show();
//                alertDialog.setTitle("Error");
//                alertDialog.setMessage(description);
//                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        return;
//                    }
//                });
//                alertDialog.show();
//            }
//        });
//        webview.loadUrl("http://www.baidu.com");
        webView = (WebView) findViewById(R.id.webView1);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setPluginState(WebSettings.PluginState.ON);
		webView.loadUrl("file:///android_asset/welcome.html");


		listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

		// setting list adapter
		expListView.setAdapter(listAdapter);

		// Listview Group click listener
		expListView.setOnGroupClickListener(new OnGroupClickListener() {

			@Override
			public boolean onGroupClick(ExpandableListView parent, View v,
					int groupPosition, long id) {
//				 Toast.makeText(getApplicationContext(),
//				 "Group Clicked " + listDataHeader.get(groupPosition),
//				 Toast.LENGTH_SHORT).show();
				return false;
			}
		});

		// Listview Group expanded listener
		expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

			@Override
			public void onGroupExpand(int groupPosition) {
//				Toast.makeText(getApplicationContext(),
//						listDataHeader.get(groupPosition) + " Expanded",
//						Toast.LENGTH_SHORT).show();
			}
		});

		// Listview Group collasped listener
		expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

			@Override
			public void onGroupCollapse(int groupPosition) {
//				Toast.makeText(getApplicationContext(),
//						listDataHeader.get(groupPosition) + " Collapsed",
//						Toast.LENGTH_SHORT).show();

			}
		});

		// Listview on child click listener
		expListView.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				// TODO Auto-generated method stub
//				Toast.makeText(
//						getApplicationContext(),
//						listDataHeader.get(groupPosition)
//								+ " : "
//								+ listDataChild.get(
//										listDataHeader.get(groupPosition)).get(
//										childPosition), Toast.LENGTH_SHORT)
//						.show();
				
				textView.setText(listDataHeader.get(groupPosition)
						+ " > "
						+ listDataChild.get(
								listDataHeader.get(groupPosition)).get(
								childPosition));
		
					switch(childPosition)

					{

					case 0:
						webView.loadUrl("file:///android_asset/p1.html");
						
						break;

					case 1:
						webView.loadUrl("file:///android_asset/p1.html");
						break;

					case 2: 
						webView.loadUrl("file:///android_asset/p1.html");
						break;

					}
				
				
				return false;
			}
		});
	}

	/*
	 * Preparing the list data
	 */
	private void prepareListData() {
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();

		// Adding child data
		listDataHeader.add("油泵车");
		listDataHeader.add("空调车");
		listDataHeader.add("电源车");
		listDataHeader.add("制氧车");
		listDataHeader.add("制氮车");
		listDataHeader.add("冷气车");

		// Adding child data
		List<String> car1 = new ArrayList<String>();
		car1.add("DYC-1A");
		car1.add("DYC-5A");
		car1.add("DYC-6A");


		List<String> car2 = new ArrayList<String>();
		car2.add("DYC-1A");
		car2.add("DYC-5A");
		car2.add("DYC-6A");

		List<String> car3 = new ArrayList<String>();
		car3.add("DYC-1A");
		car3.add("DYC-5A");
		car3.add("DYC-6A");
		
		List<String> car4 = new ArrayList<String>();
		car4.add("DYC-1A");
		car4.add("DYC-5A");
		car4.add("DYC-6A");
		
		List<String> car5 = new ArrayList<String>();
		car5.add("DYC-1A");
		car5.add("DYC-5A");
		car5.add("DYC-6A");
		
		List<String> car6 = new ArrayList<String>();
		car6.add("DYC-1A");
		car6.add("DYC-5A");
		car6.add("DYC-6A");

		listDataChild.put(listDataHeader.get(0), car1); // Header, Child data
		listDataChild.put(listDataHeader.get(1), car2);
		listDataChild.put(listDataHeader.get(2), car3);
		listDataChild.put(listDataHeader.get(3), car4); // Header, Child data
		listDataChild.put(listDataHeader.get(4), car5);
		listDataChild.put(listDataHeader.get(5), car6);
	}
}

