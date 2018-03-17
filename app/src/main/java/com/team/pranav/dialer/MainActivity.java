package com.team.pranav.dialer;

//import com.team.pranav.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import static android.R.attr.author;
import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class MainActivity extends AppCompatActivity {
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,call,change;
    TextView number;
    String str="",string;
    ImageButton imgbtn;
    TextToSpeech tts;
    int result;
    public static final String prefs = "myprefsfile";
    String[] name1={"Mom","Anjali","Sidhin","Hadeeb","Bineeth","Arathy"};
    String[] provider1={"jio","idea","idea","jio","jio","idea"};

    public void voice(String str) {
        if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA) {
            Toast.makeText(getApplicationContext(), "Feature not supported in your device", Toast.LENGTH_SHORT).show();
        } else {
            tts.speak(str, TextToSpeech.QUEUE_FLUSH, null);

        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        b0=(Button)findViewById(R.id.no0);
        b1=(Button)findViewById(R.id.no1);
        b2=(Button)findViewById(R.id.no2);
        b3=(Button)findViewById(R.id.no3);
        b4=(Button)findViewById(R.id.no4);
        b5=(Button)findViewById(R.id.no5);
        b6=(Button)findViewById(R.id.no6);
        b7=(Button)findViewById(R.id.no7);
        b8=(Button)findViewById(R.id.no8);
        b9=(Button)findViewById(R.id.no9);
        imgbtn=(ImageButton)findViewById(R.id.call);
        number=(TextView)findViewById(R.id.number_display);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences(MainActivity.prefs, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("number","8606851382");
        editor.apply();

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str+="0";
                number.setText(str);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str+="1";
                number.setText(str);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str+="2";
                number.setText(str);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str+="3";
                number.setText(str);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str+="4";
                number.setText(str);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str+="5";
                number.setText(str);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str+="6";
                number.setText(str);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str+="7";
                number.setText(str);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str+="8";
                number.setText(str);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str+="9";
                number.setText(str);
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voiceoutput();
            }


        });
        change.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                 string = number.getText().toString();
                SharedPreferences settings = getSharedPreferences(MainActivity.prefs, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("number",string);
                editor.apply();
                return false;
            }
        });

        ListView listview = (ListView) findViewById(R.id.listview1);
        CustomAdapter customadapter = new CustomAdapter(this);
        listview.setAdapter(customadapter);


    }

    class CustomAdapter extends BaseAdapter {
        Context context;
        CustomAdapter(Context context){this.context=context;}

        @Override
        public int getCount() {
            return  6;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int i, View view, ViewGroup parent) {
            view = getLayoutInflater().inflate(R.layout.custom_call, null);
            TextView textView_name = (TextView) view.findViewById(R.id.textView_name);
            TextView textView_provider = (TextView) view.findViewById(R.id.textView_provider);
            textView_name.setText(name1[i]);
            textView_provider.setText(provider1[i]);
            return view;

        }
    }


    public void voiceoutput(){


    }
}
