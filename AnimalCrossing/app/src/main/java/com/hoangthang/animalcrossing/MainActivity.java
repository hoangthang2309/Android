package com.hoangthang.animalcrossing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageButton play;
    SeekBar sBar1,sBar2,sBar3;
    CheckBox cBox1, cBox2, cBox3;
    TextView myScore;
    int score = 100;

    private void enableCheckBox(){
        cBox1.setEnabled(true);
        cBox2.setEnabled(true);
        cBox3.setEnabled(true);
    }
    private void disableCheckBox(){
        cBox1.setEnabled(false);
        cBox2.setEnabled(false);
        cBox3.setEnabled(false);
    }
    private void disableSeekBar(){
        sBar1.setEnabled(false);
        sBar2.setEnabled(false);
        sBar3.setEnabled(false);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        create();
        disableSeekBar();
        myScore.setText("score: "+score);

        final CountDownTimer count = new CountDownTimer(60000,100) {
            @Override
            public void onTick(long l) {
                int number = 4;
                Random rd = new Random();
                int sb1 = rd.nextInt(number);
                int sb2 = rd.nextInt(number);
                int sb3 = rd.nextInt(number);
                if(sBar1.getProgress() >= sBar1.getMax()){
                    if(cBox1.isChecked()){
                        score += 10;
                    }else {
                        score -= 10;
                    }
                    myScore.setText("score: "+score);
                    play.setVisibility(View.VISIBLE);
                    this.cancel();
                    enableCheckBox();
                    Toast.makeText(MainActivity.this, "Dog Win", Toast.LENGTH_LONG).show();
                }
                if(sBar2.getProgress() >= sBar2.getMax()){
                    if(cBox2.isChecked()){
                        score += 10;
                    }else {
                        score -= 10;
                    }
                    myScore.setText("score: "+score);
                    play.setVisibility(View.VISIBLE);
                    this.cancel();
                    enableCheckBox();
                    Toast.makeText(MainActivity.this, "Bird win", Toast.LENGTH_LONG).show();
                }
                if(sBar3.getProgress() >= sBar3.getMax()){
                    if(cBox3.isChecked()){
                        score += 10;
                    }else {
                        score -= 10;
                    }
                    myScore.setText("score: "+score);
                    play.setVisibility(View.VISIBLE);
                    this.cancel();
                    enableCheckBox();
                    Toast.makeText(MainActivity.this, "Turtle win", Toast.LENGTH_LONG).show();
                }
                sBar1.setProgress(sBar1.getProgress()+sb1);
                sBar2.setProgress(sBar2.getProgress()+sb2);
                sBar3.setProgress(sBar3.getProgress()+sb3);
            }

            @Override
            public void onFinish() {

            }
        };

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cBox1.isChecked() || cBox2.isChecked() || cBox3.isChecked()){
                    sBar1.setProgress(0);
                    sBar2.setProgress(0);
                    sBar3.setProgress(0);
                    play.setVisibility(View.INVISIBLE);
                    count.start();
                    disableCheckBox();
                }else{
                    Toast.makeText(MainActivity.this, "bạn chưa đặt cược", Toast.LENGTH_LONG).show();
                }
            }
        });
        cBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cBox2.setChecked(false);
                    cBox3.setChecked(false);
                }
            }
        });
        cBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cBox1.setChecked(false);
                    cBox3.setChecked(false);
                }
            }
        });
        cBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cBox1.setChecked(false);
                    cBox2.setChecked(false);
                }
            }
        });
    }
    public void create(){
        play = (ImageButton) findViewById(R.id.imageButtonPlay);
        cBox1 = (CheckBox) findViewById(R.id.checkBox1);
        cBox2 = (CheckBox) findViewById(R.id.checkBox2);
        cBox3 = (CheckBox) findViewById(R.id.checkBox3);
        sBar1 = (SeekBar) findViewById(R.id.seekBar1);
        sBar2 = (SeekBar) findViewById(R.id.seekBar2);
        sBar3 = (SeekBar) findViewById(R.id.seekBar3);
        myScore = (TextView) findViewById(R.id.textViewScore);
    }
}
