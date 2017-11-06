package com.materialdesignstudy.textinput;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;

import com.materialdesignstudy.R;

/**
 * TextInputLayout Study
 * create by heliquan at 2017年11月2日
 */
public class TextInputActivity extends AppCompatActivity {

    private TextInputLayout mTextInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input);
        initView();
    }

    private void initView() {
        mTextInputLayout = (TextInputLayout) findViewById(R.id.id_text_input);
        mTextInputLayout.setErrorEnabled(true);
        // 开启计数
        mTextInputLayout.setCounterEnabled(true);
        mTextInputLayout.setCounterMaxLength(6);
        mTextInputLayout.getEditText().addTextChangedListener(new MinLengthTextWatcher(mTextInputLayout, "密码只能6位数"));
    }

    class MinLengthTextWatcher implements TextWatcher {

        private String mErrorMsg;
        private TextInputLayout mTextInputLayout;

        public MinLengthTextWatcher(TextInputLayout textInputLayout, String errorMsg) {
            this.mTextInputLayout = textInputLayout;
            this.mErrorMsg = errorMsg;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (mTextInputLayout.getEditText().getText().toString().length() <= 6) {
                mTextInputLayout.setErrorEnabled(false);
            } else {
                mTextInputLayout.setErrorEnabled(true);
                mTextInputLayout.setError(mErrorMsg);
            }
        }
    }

}
