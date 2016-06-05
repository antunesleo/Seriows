package seriows.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.leonardo.teste.R;
import com.vstechlab.easyfonts.EasyFonts;

public class LoginActivity extends AppCompatActivity {
    Button mButtonLogin;
    TextView mTextViewLogin;
    TextView mTextViewAppName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mButtonLogin = (Button) findViewById(R.id.button_login);
        mButtonLogin.setOnClickListener(onClickListener);
        mButtonLogin.setTypeface(EasyFonts.robotoLight(this));
        mTextViewLogin = (TextView) findViewById(R.id.textview_login);
        mTextViewLogin.setTypeface(EasyFonts.robotoThin(this));
        mTextViewAppName = (TextView) findViewById(R.id.textview_appname);
        mTextViewAppName.setTypeface(EasyFonts.robotoThin(this));

    }
    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(it);
        }
    };
}
