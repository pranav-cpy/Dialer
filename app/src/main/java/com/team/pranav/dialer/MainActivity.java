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
import org.json.JSONObject;

import java.util.Locale;

import static android.R.attr.author;
import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class MainActivity extends AppCompatActivity {



    HttpClient
    String


    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,change;
    ImageView back;
    TextView number;
    String str="",string;
    ImageButton imgbtn;
    TextToSpeech tts;
    int result,no=0;
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        change=(Button)findViewById(R.id.change);
        back=(ImageView)findViewById(R.id.back);

        SharedPreferences settings = getSharedPreferences(MainActivity.prefs, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("number","8606851382");
        editor.apply();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no=no/10;
                number.setText(no);
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no=0;
                number.setText(no);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no=no*10+1;
                number.setText(no);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no=no*10+2;
                number.setText(no);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no=no*10+3;
                number.setText(no);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no=no*10+4;
                number.setText(no);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no=no*10+5;
                number.setText(no);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no=no*10+6;
                number.setText(no);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no=no*10+7;
                number.setText(no);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no=no*10+8;
                number.setText(no);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no=no*10+9;
                number.setText(no);
            }
        });
        imgbtn.setOnClickListener(new View.OnClickListener() {
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

        tts = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    result = tts.setLanguage(Locale.UK);
                } else {
                    Toast.makeText(getApplicationContext(), "Feature not supported in your device", Toast.LENGTH_SHORT).show();
                }

            }
        });


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
        if(result==TextToSpeech.LANG_NOT_SUPPORTED||result==TextToSpeech.LANG_MISSING_DATA) {
            Toast.makeText(getApplicationContext(),"Feature not supported in your device",Toast.LENGTH_SHORT).show();
        }else {
            tts.speak("Welcome to blood donor finder. Press one for request, presss two for blood donation, press 3 for giving feedback followed by #", TextToSpeech.QUEUE_FLUSH,null);
            input(mainoption);
            if(mainoption==1){
                tts.speak("Press 1 for A positive, press 2 for A negative, press 3 for b positive, press 4 for b negative, press 5 for o positive, press 6 for o negative followed by #", TextToSpeech.QUEUE_FLUSH,null);
                input(group);
                tts.speak("press 1 for trivandrum, press 2 for kollam , press 3 for pathanamthitta, press 4 for alappuzha, press 5 for kottayam, press 6 idukki, press 7 for ernamkulam, press 8 for thrissur, press 9 for palakkad, press 10 for malappuram, press 11 for kozhikkod, press 12 for wayanad, press 13 for kannur, press 14 for kasargod followed by # ", TextToSpeech.QUEUE_FLUSH,null);
                input(location);
                tts.speak("Press 1 for low volume, press 2 for high volume followed by #", TextToSpeech.QUEUE_FLUSH,null);
                input(volume);
                JSONObject json=new JSONObject();
                try {
                    json.put("label","request");
                    json.put("group",group);
                    json.put("location",location);
                    json.put("volume",volume);
                    JSONObject j = HttpClient.SendHttpPost(URL,json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            else if(mainoption==2){
                tts.speak(" followed by #", TextToSpeech.QUEUE_FLUSH,null);
            }

        }


    }
}
