package fbalashov.memeworkshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
  public static final String IMAGE_ID_EXTRA = "IMAGE_ID";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_details);
    String imageId = getIntent().getExtras().get(IMAGE_ID_EXTRA).toString();
    TextView textView = (TextView)findViewById(R.id.post_id);
    textView.setText(imageId);

    ImageView imageView = (ImageView) findViewById(R.id.imageView);
    MemeClient memeClient = new MemeClient();
    memeClient.displayMeme(imageId, this, imageView);
  }
}
