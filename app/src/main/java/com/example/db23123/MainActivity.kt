package com.example.db23123

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPrefFile = "kotlinsharedpreferences"

    val inputId = findViewById<EditText>(R.id.editTextText2)
    val inputName = findViewById<EditText>(R.id.editTextText3)
    val inpshow = findViewById<TextView>(R.id.textView7)
    val inpshow2 = findViewById<TextView>(R.id.textView8)

    val savers = findViewById<Button>(R.id.savebtn)
    val viewers = findViewById<Button>(R.id.viewbtn)
    val clearers = findViewById<Button>(R.id.clearbtn)

    val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)

    savers.setOnClickListener{
        val id: Int= Integer.parseInt(inputId.text.toString())
        val name: String = inputName.text.toString()
        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        editor.putInt("id_key", id)
        editor.putString("name_key", name)
        editor.apply()
        editor.commit()


        viewers.setOnClickListener{
            val sharedIdValue = sharedPreferences.getInt("id_key", 0)
            val sharedNameValue = sharedPreferences.getString("name_key", "default")
            if(sharedIdValue.equals(0) && sharedNameValue.equals("default")){
                inpshow.setText("default id: ${sharedIdValue}").toString()
                inpshow2.setText("default name: ${sharedNameValue}".toString())
            }
            else
            {
                inpshow.setText(sharedIdValue).toString()
                inpshow2.setText(sharedNameValue).toString()
            }

            clearers.setOnClickListener{
                val editor = sharedPreferences.edit()
                editor.clear()
                editor.apply()
                inpshow.setText("").toString()
                inpshow2.setText("".toString())
            }
        }
    }

    }
}
