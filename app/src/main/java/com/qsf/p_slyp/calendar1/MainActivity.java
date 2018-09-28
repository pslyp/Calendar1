package com.qsf.p_slyp.calendar1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    static final int DATE_DIALOG_ID = 999;

    Calendar c = Calendar.getInstance();

    ImageView calendar;
    TextView calendarText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = findViewById(R.id.calendar_imageview);
        calendarText = findViewById(R.id.calendar_textview);

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DATE_DIALOG_ID);
            }
        });
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID :
                return new DatePickerDialog(this, dateSetListener, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
        }

        return super.onCreateDialog(id);
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int selectYear, int selectMonth, int selectDay) {
            calendarText.setText(selectDay + "/" + selectMonth + "/" + selectYear);
        }
    };
}
