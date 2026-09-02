package jp.ac.meijou.android.s251205044;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import jp.ac.meijou.android.s251205044.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 明示的
        binding.buttonA.setOnClickListener(view -> {
            var Intent = new Intent(this, MainActivity3.class);
            startActivity(Intent);
        });

        // 暗示的
        binding.buttonB.setOnClickListener(view -> {
            var Intent = new Intent();
            Intent.setAction(Intent.ACTION_VIEW);
            Intent.setData(Uri.parse("https://www.yahoo.co.jp"));
            startActivity(Intent);
        });

        binding.intentButton.setOnClickListener(view -> {
            String sentText = binding.editText.getText().toString();

            var intent = new Intent (this, MainActivity3.class);
            intent.putExtra("editText", sentText);
            startActivity(intent);
        });

    }
}