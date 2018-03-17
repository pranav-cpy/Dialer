package com.team.pranav.dialer;

//import com.team.pranav.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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




    final String URL="http://192.168.43.127:8080/";
    String group,location,volume;
    long mainoption, tempvalue=0;


    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,change,enterbtn;
    ImageView back;
    TextView number;
    String str="",string;
    ImageButton imgbtn;
    int result;long no;
    public static final String prefs = "myprefsfile";
    String[] name1={"Mom","Anjali","Sidhin","Hadeeb","Bineeth","Arathy"};

    int startzero;





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
        enterbtn=(Button)findViewById(R.id.enterbtn);

        SharedPreferences settings = getSharedPreferences(MainActivity.prefs, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("phonenumber","8606851382");
        editor.apply();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no=no/10;
                tempvalue=no;
                if(no==0)
                    startzero=1;
                number.setText(""+no);
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no=no*10;
                tempvalue=no;
                if(startzero==1)
                number.setText(0+""+no);
                else
                    number.setText(""+no);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no=no*10+1;
                tempvalue=no;
                if(startzero==1)
                    number.setText(0+""+no);
                else
                    number.setText(""+no);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no=no*10+2;
                tempvalue=no;
                if(startzero==1)
                    number.setText(0+""+no);
                else
                    number.setText(""+no);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no=no*10+3;
                tempvalue=no;
                    number.setText(""+no);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no=no*10+4;
                tempvalue=no;

                    number.setText(""+no);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no=no*10+5;
                tempvalue=no;

                    number.setText(""+no);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no=no*10+6;
                tempvalue=no;

                    number.setText(""+no);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no=no*10+7;
                tempvalue=no;

                    number.setText(""+no);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no=no*10+8;
                tempvalue=no;

                    number.setText(""+no);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no=no*10+9;
                tempvalue=no;

                    number.setText(""+no);
            }
        });
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Call.class));

            }


        });
        change.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                 string = number.getText().toString();
                SharedPreferences settings = getSharedPreferences(MainActivity.prefs, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("phonenumber",string);
                editor.apply();
                Toast.makeText(getApplicationContext(),"number updated",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
         enterbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 number.setText("");

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
            return  name1.length;
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

            textView_name.setText(name1[i]);

            return view;

        }
    }



}
