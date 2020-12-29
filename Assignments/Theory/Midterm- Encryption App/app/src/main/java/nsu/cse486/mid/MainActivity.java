package nsu.cse486.mid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText phonetext;
    EditText sectext;
    EditText msgtext;
    Button dec_button;

    Button enc_button;

    Cypher cypher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dec_button = findViewById(R.id.decrypt_button);
        enc_button = findViewById(R.id.encrypt_button);

        phonetext = findViewById(R.id.recipient_phone);
        sectext = findViewById(R.id.encryp_code_3);
        msgtext = findViewById(R.id.ency_msg_text);

        cypher = new Cypher();

        dec_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DecActivity.class);
                startActivity(intent);
            }
        });

        enc_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = phonetext.getText().toString();
                String message = msgtext.getText().toString();
                String secret = sectext.getText().toString();

                String cypherText = cypher.encode(message, secret.hashCode() % 26);

                try {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    // This ensures only SMS apps respond
                    intent.setData(Uri.parse("recipient:"+phoneNumber));
                    intent.putExtra("themessage", secret+" "+cypherText);
                    startActivity(intent);
                } catch (Exception e) {
                }

            }
        });
    }
}