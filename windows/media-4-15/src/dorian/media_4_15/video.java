package dorian.media_4_15;

import android.app.Activity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class video extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.video);
		
		VideoView vv = (VideoView) findViewById(R.id.videoView1);
		vv.setVideoPath("/sdcard/vid.mp4");
		vv.setMediaController(new MediaController(this));
		vv.start();
		vv.requestFocus();
	}
}