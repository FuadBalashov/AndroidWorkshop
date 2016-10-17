package fbalashov.imagealigator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import okhttp3.OkHttpClient;

public class MemeActivity extends AppCompatActivity implements MemeClient.MemeHandler {

    private EditText mEditText;
    private ImageView mImageView;
    private Button mButton;
    private MemeClient mMemeClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meme);

        mEditText = (EditText) findViewById(R.id.editText);
        mImageView = (ImageView) findViewById(R.id.imageView);
        mButton = (Button) findViewById(R.id.button);
        mMemeClient = new MemeClient(new OkHttpClient(), this.getApplication(), this);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String imageId = mEditText.getText().toString();
                try {
                    mMemeClient.getMeme(imageId);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void returnMeme(final String link) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Picasso.with(MemeActivity.this).load(link).into(mImageView);
            }
        });
    }
}
