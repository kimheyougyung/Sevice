package com.example.vibateex;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rGroup1;
    RadioButton rdo1, rdo2;
    Button btnOk;
    TextView tvResult;

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rGroup1 =(RadioGroup)findViewById(R.id.rGroup1); // 라디오그룹
        rdo1 = (RadioButton)findViewById(R.id.rdo1); // 1등 라디오 버튼
        rdo2 = (RadioButton)findViewById(R.id.rdo2); // 2등 라디오버튼
        btnOk = (Button)findViewById(R.id.btnOk); // 결과확인 버튼
        tvResult =(TextView)findViewById(R.id.tvResult); // 결과 텍스트
        mp=MediaPlayer.create(this,R.raw.mpmp);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (rGroup1.getCheckedRadioButtonId()){
                    case R.id.rdo1:
                        // 진동
                        Vibrator vib = (Vibrator)getSystemService(VIBRATOR_SERVICE);
                        // 0.5초동안 쉬고, 1초 진동, 0.4초 쉬고, 2초 진동 울림
                        vib.vibrate(new long[] {500, 1000, 400, 2000},-1); // 100 - 0.1초단위
                        // vib.vibrate(1000);
                        // repeat를 0으로 설정하면 무한 반복
                        // vib.cancel(); // 진동 멈춤
                        tvResult.setText("틀렸습니다. \n 이유는 별들에게 물어봐!");
                        break;
// test 12/5

                    case R.id.rdo2:
                        // 폰에서 가지고 있는 알람 소리를 출력한다.
//                        Uri noti = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//                        Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(), noti);
//                        ringtone.play();
                        mp.start();
                        tvResult.setText("정답입니다. \n 이유는 별들에게 물어봐!");
                        break;

                    default:
                        Toast.makeText(getApplicationContext(), "선택해줘", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
