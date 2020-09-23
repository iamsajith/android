package com.insanis.hscap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.widget.LinearLayout;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdListener;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.view.View;

public class MainActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private DrawerLayout _drawer;
	private String a = "";
	private String b = "";
	private String package_name = "";
	private HashMap<String, Object> map = new HashMap<>();
	private String your_version = "";
	private String latest_version = "";
	
	private ArrayList<HashMap<String, Object>> map1 = new ArrayList<>();
	
	private LinearLayout linear3;
	private LinearLayout linear1;
	private LinearLayout linear4;
	private ImageView imageview1;
	private ImageView imageview2;
	private ImageView imageview3;
	private ImageView imageview4;
	private ImageView imageview5;
	private ImageView imageview6;
	private LinearLayout _drawer_linear3;
	private LinearLayout _drawer_linear4;
	private TextView _drawer_textview1;
	private TextView _drawer_textview2;
	private TextView _drawer_textview3;
	private TextView _drawer_textview4;
	private TextView _drawer_textview5;
	private TextView _drawer_textview6;
	private TextView _drawer_textview7;
	private ImageView _drawer_imageview10;
	
	private Intent s1 = new Intent();
	private InterstitialAd ads;
	private AdListener _ads_ad_listener;
	private AlertDialog.Builder dialog;
	private Intent email = new Intent();
	private Intent rate = new Intent();
	private Intent update = new Intent();
	private AlertDialog.Builder disclaimer;
	private AlertDialog.Builder privacy;
	private AlertDialog.Builder d;
	private Intent fbnoti = new Intent();
	private DatabaseReference Ver = _firebase.getReference("version");
	private ChildEventListener _Ver_child_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		_toolbar = (Toolbar) findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		_drawer = (DrawerLayout) findViewById(R.id._drawer);ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(MainActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = (LinearLayout) findViewById(R.id._nav_view);
		
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		imageview6 = (ImageView) findViewById(R.id.imageview6);
		_drawer_linear3 = (LinearLayout) _nav_view.findViewById(R.id.linear3);
		_drawer_linear4 = (LinearLayout) _nav_view.findViewById(R.id.linear4);
		_drawer_textview1 = (TextView) _nav_view.findViewById(R.id.textview1);
		_drawer_textview2 = (TextView) _nav_view.findViewById(R.id.textview2);
		_drawer_textview3 = (TextView) _nav_view.findViewById(R.id.textview3);
		_drawer_textview4 = (TextView) _nav_view.findViewById(R.id.textview4);
		_drawer_textview5 = (TextView) _nav_view.findViewById(R.id.textview5);
		_drawer_textview6 = (TextView) _nav_view.findViewById(R.id.textview6);
		_drawer_textview7 = (TextView) _nav_view.findViewById(R.id.textview7);
		_drawer_imageview10 = (ImageView) _nav_view.findViewById(R.id.imageview10);
		dialog = new AlertDialog.Builder(this);
		disclaimer = new AlertDialog.Builder(this);
		privacy = new AlertDialog.Builder(this);
		d = new AlertDialog.Builder(this);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				s1.setClass(getApplicationContext(), AnnounceActivity.class);
				startActivity(s1);
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ads.show();
				s1.setClass(getApplicationContext(), Screen3Activity.class);
				startActivity(s1);
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				s1.setClass(getApplicationContext(), Screen4Activity.class);
				startActivity(s1);
			}
		});
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				s1.setClass(getApplicationContext(), SyllabusActivity.class);
				startActivity(s1);
			}
		});
		
		imageview5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				s1.setClass(getApplicationContext(), CarrierActivity.class);
				startActivity(s1);
			}
		});
		
		imageview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				s1.setClass(getApplicationContext(), FaqActivity.class);
				startActivity(s1);
			}
		});
		
		_Ver_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				_UpdateNotifiChildAdd();
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		Ver.addChildEventListener(_Ver_child_listener);
		
		_drawer_linear3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		_drawer_textview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Send(email, "peakstudiosindia@gmail.com", "Queries", "Hello Developer,");
			}
		});
		
		_drawer_textview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Send(email, "peakstudiosindia@gmail.com", "Suggestions", "Hello Developer,");
			}
		});
		
		_drawer_textview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				update.setAction(Intent.ACTION_VIEW);
				update.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.insanis.hscap"));
				startActivity(update);
			}
		});
		
		_drawer_textview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Rate();
			}
		});
		
		_drawer_textview5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_shareButton();
			}
		});
		
		_drawer_textview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				privacy.setTitle("Privacy Policy");
				privacy.setMessage("Peakstudio Apps built the HssAlert app as a Free app. This SERVICE is provided by Peakstudio Apps at no cost and is intended for use as is.\n\nThis page is used to inform visitors regarding our policies with the collection, use, and disclosure of Personal Information if anyone decided to use our Service.\n\nIf you choose to use our Service, then you agree to the collection and use of information in relation to this policy. The Personal Information that we collect is used for providing and improving the Service. We will not use or share your information with anyone except as described in this Privacy Policy.\n\nThe terms used in this Privacy Policy have the same meanings as in our Terms and Conditions, which is accessible at HssAlert unless otherwise defined in this Privacy Policy.\n\nInformation Collection and Use\n\nFor a better experience, while using our Service, we may require you to provide us with certain personally identifiable information, but now we don't collect or store any personal information. The information that we request will be retained by us and used as described in this privacy policy.\n\nThe app does use third party services that may collect information used to identify you.\n\nLink to privacy policy of third party service providers used by the app\n\nGoogle Play Services\n\nAdMob\n\nGoogle Analytics for Firebase\n\nLog Data\n\nWe want to inform you that whenever you use our Service, in a case of an error in the app we collect data and information (through third party products) on your phone called Log Data. This Log Data may include information such as your device Internet Protocol (“IP”) address, device name, operating system version, the configuration of the app when utilizing our Service, the time and date of your use of the Service, and other statistics.\n\nCookies\n\nCookies are files with a small amount of data that are commonly used as anonymous unique identifiers. These are sent to your browser from the websites that you visit and are stored on your device's internal memory.\n\nThis Service does not use these “cookies” explicitly. However, the app may use third party code and libraries that use “cookies” to collect information and improve their services. You have the option to either accept or refuse these cookies and know when a cookie is being sent to your device. If you choose to refuse our cookies, you may not be able to use some portions of this Service.\n\nService Providers\n\nWe may employ third-party companies and individuals due to the following reasons:\n\nTo facilitate our Service;\n\nTo provide the Service on our behalf;\n\nTo perform Service-related services; or\n\nTo assist us in analyzing how our Service is used.\n\nWe want to inform users of this Service that these third parties have access to your Personal Information. The reason is to perform the tasks assigned to them on our behalf. However, they are obligated not to disclose or use the information for any other purpose.\n\nSecurity\n\nWe value your trust in providing us your Personal Information, thus we are striving to use commercially acceptable means of protecting it. But remember that no method of transmission over the internet, or method of electronic storage is 100% secure and reliable, and we cannot guarantee its absolute security.\n\nLinks to Other Sites\n\nThis Service may contain links to other sites. If you click on a third-party link, you will be directed to that site. Note that these external sites are not operated by us. Therefore, we strongly advise you to review the Privacy Policy of these websites. We have no control over and assume no responsibility for the content, privacy policies, or practices of any third-party sites or services.\n\nChildren’s Privacy\n\nThese Services do not address anyone under the age of 13. We do not knowingly collect personally identifiable information from children under 13. In the case we discover that a child under 13 has provided us with personal information, we immediately delete this from our servers. If you are a parent or guardian and you are aware that your child has provided us with personal information, please contact us.\n\nChanges to This Privacy Policy\n\nWe may update our Privacy Policy from time to time. Thus, you are advised to review this page periodically for any changes. We will notify you of any changes by posting the new Privacy Policy on this page.\n\nThis policy is effective as of 02/08/2020\n\nContact Us\n\nIf you have any questions or suggestions about our Privacy Policy, do not hesitate to contact us at peakstudiosindia@gmail.com.");
				privacy.create().show();
			}
		});
		
		_drawer_textview7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				disclaimer.setTitle("Disclaimer");
				disclaimer.setMessage("This is not an official app or does not represent any board, only meant to help students. The information provided/presented in app does not imply any affiliation or endorsement by any board or entity.\n\nInformation provided in this app though is compiled with utmost care, the app cannot guarantee that this information is and stays 100% accurate. We therefore reserve all rights of app and accept no liability for any kind of damage directly or indirectly that can come from the use or not able to use the information and functionality provided by HssAlert app.\n\n");
				disclaimer.create().show();
			}
		});
		
		_ads_ad_listener = new AdListener() {
			@Override
			public void onAdLoaded() {
				
			}
			
			@Override
			public void onAdFailedToLoad(int _param1) {
				final int _errorCode = _param1;
				
			}
			
			@Override
			public void onAdOpened() {
				
			}
			
			@Override
			public void onAdClosed() {
				
			}
		};
	}
	private void initializeLogic() {
		_BlackIcons_StatusBar();
		ads = new InterstitialAd(getApplicationContext());
		ads.setAdListener(_ads_ad_listener);
		ads.setAdUnitId("ca-app-pub-9884940613813961/8572859164");
		ads.loadAd(new AdRequest.Builder().addTestDevice("F4C1E09E07A0ACF0D09EEFB90DEF5A64")
		.build());
		_UpdateNotifiOncreate();
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		ads.show();
		finish();
	}
	private void _BlackIcons_StatusBar () {
		{getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); }
	}
	
	
	private void _ShareApp (final String _name) {
		
	}
	
	
	private void _shareButton () {
		a = "HssAlert";
		b = "Check out HssAlert app on Playstore, which provides information like results,curriculum,etc for higher secondary students. https://play.google.com/store/apps/details?id=com.insanis.hscap";
		Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_SUBJECT, a); i.putExtra(android.content.Intent.EXTRA_TEXT, b); startActivity(Intent.createChooser(i,"Share using"));
		
	}
	
	
	private void _Rate () {
		dialog.setMessage("Rate our app 😁");
		dialog.setPositiveButton("Rate", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				rate.setAction(Intent.ACTION_VIEW);
				rate.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.insanis.hscap"));
				startActivity(rate);
			}
		});
		dialog.setNegativeButton("Later", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				
			}
		});
		dialog.create().show();
	}
	
	
	private void _Send (final Intent _IntentName, final String _to, final String _subject, final String _text) {
		_IntentName.setAction(Intent.ACTION_VIEW);
		_IntentName.setData(Uri.parse("mailto:".concat(_to)));
		_IntentName.putExtra("android.intent.extra.SUBJECT", _subject);
		_IntentName.putExtra("android.intent.extra.TEXT", _text);
		startActivity(_IntentName);
	}
	
	
	private void _UpdateNotifiOncreate () {
		package_name = "com.insanis.hscap";
		try {
			android.content.pm.PackageInfo pinfo = getPackageManager().getPackageInfo( package_name,android.content.pm.PackageManager.GET_ACTIVITIES);
			your_version = pinfo.versionName; }
		catch (Exception e){ showMessage(e.toString()); }
		DatabaseReference rootRef = _firebase.getReference();
		
		rootRef.child("version").addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot snapshot) {
				if (snapshot.exists()) { } else {
					map = new HashMap<>();
					map.put("v", your_version);
					Ver.child("app").updateChildren(map);
					map.clear();
				} }
			@Override
			public void onCancelled(DatabaseError _error) { } });
	}
	
	
	private void _UpdateNotifiChildAdd () {
		Ver.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot _dataSnapshot) {
				map1 = new ArrayList<>();
				try {
					GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
					for (DataSnapshot _data : _dataSnapshot.getChildren()) {
						HashMap<String, Object> _map = _data.getValue(_ind);
						map1.add(_map);
					}
				}
				catch (Exception _e) {
					_e.printStackTrace();
				}
				latest_version = map1.get((int)0).get("v").toString();
				if (Double.parseDouble(your_version) < Double.parseDouble(latest_version)) {
					d.setTitle("Information!!");
					d.setMessage("Update is available ..");
					d.setPositiveButton("Update", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							fbnoti.setAction(Intent.ACTION_VIEW);
							fbnoti.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.insanis.hscap"));
							startActivity(fbnoti);
						}
					});
					d.setCancelable(false);
					d.create().show();
				}
				else {
					if (Double.parseDouble(your_version) > Double.parseDouble(latest_version)) {
						Ver.child("app").child("v").setValue(your_version);
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "You are using the latest version of this app");
					}
				}
			}
			@Override
			public void onCancelled(DatabaseError _databaseError) {
			}
		});
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
