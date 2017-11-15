package com.example.predator.shunting_yard;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.predator.shunting_yard.R.*;

public class MainActivity extends AppCompatActivity
{


    private ShYard sh;
    private TextView outputTV;
    public EditText inputET;
    LinkedList Ls= new LinkedList();
    Node N= new Node(null);
    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

            this.inputET = (EditText) this.findViewById(R.id.inputET);
            this.outputTV = (TextView) this.findViewById(R.id.outputTV);

        }


        public void processButtonPressed(View v) {

            ShYard sy = new ShYard(this.inputET.getText().toString());
            sy.convert();
            sy.process();

            String s1 = "";
            N=sy.getOutput().getHead();

            while (N.nextNode != null)
            {
                s1 += N.nextNode.getPayload();
                N.nextNode = N.nextNode.getNextNode();

            }

            this.outputTV.setText(s1);
            this.inputET.setText("");
        }




    }

