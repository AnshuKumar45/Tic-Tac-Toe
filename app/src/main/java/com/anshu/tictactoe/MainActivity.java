package com.anshu.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnrst;
    TextView txtTurn,txtXwins,txtOwins,txtDraw;
    LinearLayout llMain;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    int flag=0,count=0,r=0,x=0,d=0,o=0,fd=0,fh=0,t=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        llMain.setBackgroundColor(getResources().getColor(R.color.initial));
        btnrst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restart(t);
            }
        });
    }
    private void init(){
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btnrst=findViewById(R.id.btnrst);
        llMain=findViewById(R.id.llMain);
        txtTurn=findViewById(R.id.txtTurn);
        txtDraw=findViewById(R.id.txtDraw);
        txtOwins=findViewById(R.id.txtOwins);
        txtXwins=findViewById(R.id.txtXwins);
    }
    public void click(View v) throws InterruptedException {
        Button btncur=(Button) v;
        fh=0;fd=0;
        if(btncur.getText().toString().equals("")) {
            count++;
            if (flag == 0&&r==0&&t==0) {

                btncur.setText("X");
                txtTurn.setText("O turn");
                btncur.setTextColor(getResources().getColor(R.color.X_color));
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.txt_animation);
                btncur.setAnimation(animation);
                flag = 1;
                t=1;
            } else if(r==0&&t==1){
                btncur.setText("O");
                txtTurn.setText("X turn");
                btncur.setTextColor(getResources().getColor(R.color.O_color));
                Animation animation1 = AnimationUtils.loadAnimation(MainActivity.this,R.anim.txt_animation);
                btncur.setAnimation(animation1);
                flag = 0;
                t=0;
            }
            if (count > 4) {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();
                Toast toast = new Toast(MainActivity.this);
                View view = getLayoutInflater().inflate(R.layout.result, (ViewGroup) findViewById(R.id.viewContent));
                toast.setView(view);
                TextView txtResult = view.findViewById(R.id.txtResult);
                TextView txtmsg = view.findViewById(R.id.txtMsg);
                LinearLayout viewContent=view.findViewById(R.id.viewContent);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 80);

                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.toast_animation);
                txtmsg.setAnimation(animation);

                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                    if(r==0){
                    txtResult.setText("Winner is " + b1);
                    if(b1=="X"){
                        x++;
                        txtXwins.setText("X: "+ x);
                    }else if(b1=="O"){
                        o++;
                        txtOwins.setText("O: "+ o);
                    }
                    viewContent.setBackgroundColor(getResources().getColor(R.color.toast_result));
                    toast.show();}
                    r = 1;
                    btn1.setBackgroundColor(getResources().getColor(R.color.result));
                    btn2.setBackgroundColor(getResources().getColor(R.color.result));
                    btn3.setBackgroundColor(getResources().getColor(R.color.result));
                    llMain.setBackgroundColor(getResources().getColor(R.color.Winner));

                }  if (b4.equals(b5) && b5.equals(b6) && !b5.equals("")) {
                    if(r==0){
                    txtResult.setText("Winner is " + b5);
                        viewContent.setBackgroundColor(getResources().getColor(R.color.toast_result));
                    toast.show();}
                    if(b5=="X") {
                        x++;
                        txtXwins.setText("X: " + x);
                    }else if(b5=="O"){
                        o++;
                        txtOwins.setText("O: "+ o);
                    }
                    fh=1;
                    btn4.setBackgroundColor(getResources().getColor(R.color.result));
                    btn5.setBackgroundColor(getResources().getColor(R.color.result));
                    btn6.setBackgroundColor(getResources().getColor(R.color.result));
                    r = 1;
                    llMain.setBackgroundColor(getResources().getColor(R.color.Winner));

                }  if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    if(r==0){
                    txtResult.setText("Winner is " + b7);
                        viewContent.setBackgroundColor(getResources().getColor(R.color.toast_result));
                    toast.show();}
                    if(b7=="X"){
                        x++;
                        txtXwins.setText("X: "+ x);
                    }
                    else if(b7=="O"){
                        o++;
                        txtOwins.setText("O: "+ o);
                    }
                    r = 1;
                    btn7.setBackgroundColor(getResources().getColor(R.color.result));
                    btn8.setBackgroundColor(getResources().getColor(R.color.result));
                    btn9.setBackgroundColor(getResources().getColor(R.color.result));
                    llMain.setBackgroundColor(getResources().getColor(R.color.Winner));

                }  if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    if(r==0){
                    txtResult.setText("Winner is " + b1);
                        viewContent.setBackgroundColor(getResources().getColor(R.color.toast_result));
                    toast.show();}
                    if(b1=="X"){
                        x++;
                        txtXwins.setText("X: "+ x);
                    }
                    else if(b1=="O"){
                        o++;
                        txtOwins.setText("O: "+ o);
                    }
                    r = 1;
                    btn1.setBackgroundColor(getResources().getColor(R.color.result));
                    btn4.setBackgroundColor(getResources().getColor(R.color.result));
                    btn7.setBackgroundColor(getResources().getColor(R.color.result));
                    llMain.setBackgroundColor(getResources().getColor(R.color.Winner));

                }  if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    if(r==0){
                    txtResult.setText("Winner is " + b2);
                        viewContent.setBackgroundColor(getResources().getColor(R.color.toast_result));
                    toast.show();}
                    if(b2=="X"&&fh==0){
                        x++;
                        txtXwins.setText("X: "+ x);
                    }
                    else if(b2=="O"&&fh==0){
                        o++;
                        txtOwins.setText("O: "+ o);
                    }
                    r = 1;
                    btn2.setBackgroundColor(getResources().getColor(R.color.result));
                    btn5.setBackgroundColor(getResources().getColor(R.color.result));
                    btn8.setBackgroundColor(getResources().getColor(R.color.result));
                    llMain.setBackgroundColor(getResources().getColor(R.color.Winner));
                }  if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    if(r==0){
                    txtResult.setText("Winner is " + b3);
                        viewContent.setBackgroundColor(getResources().getColor(R.color.toast_result));
                    toast.show();}
                    if(b3=="X"){
                        x++;
                        txtXwins.setText("X: "+ x);
                    }
                    else if(b3=="O"){
                        o++;
                        txtOwins.setText("O: "+ o);
                    }
                    r = 1;
                    btn3.setBackgroundColor(getResources().getColor(R.color.result));
                    btn9.setBackgroundColor(getResources().getColor(R.color.result));
                    btn6.setBackgroundColor(getResources().getColor(R.color.result));
                    llMain.setBackgroundColor(getResources().getColor(R.color.Winner));

                }  if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    if(r==0){
                    txtResult.setText("Winner is " + b1);
                        viewContent.setBackgroundColor(getResources().getColor(R.color.toast_result));

                    toast.show();}
                    if(b1=="X"){
                        x++;
                        txtXwins.setText("X: "+ x);
                    }
                    else if(b1=="O"){
                        o++;
                        txtOwins.setText("O: "+ o);
                    }
                    fd=1;
                    r = 1;
                    btn1.setBackgroundColor(getResources().getColor(R.color.result));
                    btn5.setBackgroundColor(getResources().getColor(R.color.result));
                    btn9.setBackgroundColor(getResources().getColor(R.color.result));
                    llMain.setBackgroundColor(getResources().getColor(R.color.Winner));
                }  if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    if(r==0){
                    txtResult.setText("Winner is " + b3);
                        viewContent.setBackgroundColor(getResources().getColor(R.color.toast_result));
                    toast.show();}
                    if(b3=="X"&&fd==0){
                        x++;
                        txtXwins.setText("X: "+ x);
                    }
                    else if(b3=="O"&&fd==0){
                        o++;
                        txtOwins.setText("O: "+ o);
                    }
                    r = 1;
                    btn3.setBackgroundColor(getResources().getColor(R.color.result));
                    btn5.setBackgroundColor(getResources().getColor(R.color.result));
                    btn7.setBackgroundColor(getResources().getColor(R.color.result));
                    llMain.setBackgroundColor(getResources().getColor(R.color.Winner));
                }  if (count == 9&&r==0) {
                    txtResult.setText("Game is Drawn");
                    txtmsg.setText("Please restart the game");
                    txtDraw.setText("D: "+ ++d);
                    toast.show();
                    llMain.setBackgroundColor(getResources().getColor(R.color.Draw));
                }
            }
        }
    }
    public void newGame(){
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        flag=0;
        count=0;
    }
    public void restart(int t){
        if(t==0){
            t=1;
        }else{
            t=0;
        }
        r=0;
        txtTurn.setText("");
        llMain.setBackgroundColor(getResources().getColor(R.color.initial));
        btn1.setBackground(getResources().getDrawable(R.drawable.button_shape));
        btn2.setBackground(getResources().getDrawable(R.drawable.button_shape));
        btn3.setBackground(getResources().getDrawable(R.drawable.button_shape));
        btn4.setBackground(getResources().getDrawable(R.drawable.button_shape));
        btn5.setBackground(getResources().getDrawable(R.drawable.button_shape));
        btn6.setBackground(getResources().getDrawable(R.drawable.button_shape));
        btn7.setBackground(getResources().getDrawable(R.drawable.button_shape));
        btn8.setBackground(getResources().getDrawable(R.drawable.button_shape));
        btn9.setBackground(getResources().getDrawable(R.drawable.button_shape));
        fh=0;
        fd=0;
        newGame();
    }
}