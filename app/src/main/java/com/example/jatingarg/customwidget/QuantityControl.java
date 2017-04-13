package com.example.jatingarg.customwidget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by jatingarg on 13/04/17.
 */

public class QuantityControl extends LinearLayout {

    private TextView mTextView;
    private Button mPlustn;
    private Button mMinusBtn;
    private int quantity = 1;

    public QuantityControl(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public QuantityControl(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        inflate(getContext(),R.layout.quantity_control_layout,this);
        this.mMinusBtn = (Button) findViewById(R.id.subBtn);
        this.mPlustn = (Button) findViewById(R.id.addBtn);
        this.mTextView = (TextView) findViewById(R.id.textView);

        mTextView.setText(Integer.toString(quantity));
        mPlustn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementQuantity();
            }
        });

        mMinusBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementQuantity();
            }
        });
    }

    private void incrementQuantity(){
        quantity += 1;
        mTextView.setText(Integer.toString(quantity));

    }

    private void decrementQuantity(){
        if(quantity == 1){
            //do nothing
            return;
        }
        quantity -= 1;
        mTextView.setText(Integer.toString(quantity));
    }

    public int getQuantity(){
        return quantity;
    }
}
