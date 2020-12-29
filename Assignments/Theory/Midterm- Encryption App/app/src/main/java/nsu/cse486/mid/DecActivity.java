package nsu.cse486.mid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DecActivity extends AppCompatActivity {

    TextView encrypt_display;
    TextView output_display;
    EditText cypher_hint;
    Button dec_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt);
        encrypt_display = findViewById(R.id.tv_encryption);
        output_display = findViewById(R.id.tv_output);
        cypher_hint = findViewById(R.id.ency_msg_text);
        dec_button = findViewById(R.id.decrypt_button);

        dec_button.setOnClickListener(v -> {
            String cyperstrtext = cypher_hint.getText().toString();

            if(!cyperstrtext.isEmpty()) {

                Cypher cypher = new Cypher();
                String message = cypher.decode(cyperstrtext);

                output_display.setText(message);
            } else {
                cypher_hint.setError("Empty");
            }
        });
    }
}