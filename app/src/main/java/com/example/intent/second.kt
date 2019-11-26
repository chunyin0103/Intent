package com.example.intent

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class second : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
        val number = intent.getIntExtra(MainActivity.EXTRA_LUCKY,0)

        textViewMessage.text = String.format("%s %s", getString(R.string.message),message)
        textViewLuckyNum.text = String.format("%s %d",getString(R.string.lucky_number),number)

        buttonDone.setOnClickListener {
            val intent = getIntent()
            if(!editTextReply.text.isEmpty()){
                val reply = editTextReply.text.toString()

                intent.putExtra(MainActivity.EXTRA_REPLY,reply)
                setResult(Activity.RESULT_OK,intent)
            }else{
                setResult(Activity.RESULT_CANCELED)
            }

            //to determinate the Activity
            finish()
        }
    }


}
