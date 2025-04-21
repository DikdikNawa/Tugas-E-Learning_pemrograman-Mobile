package com.example.elearningpm

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var phoneInput: EditText
    private lateinit var btnDate: Button
    private lateinit var btnTime: Button
    private lateinit var btnAlert: Button
    private lateinit var btnToast: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        phoneInput = findViewById(R.id.phoneInput)
        btnDate = findViewById(R.id.btnDate)
        btnTime = findViewById(R.id.btnTime)
        btnAlert = findViewById(R.id.btnAlert)
        btnToast = findViewById(R.id.btnToast)

        btnDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val datePicker = DatePickerDialog(
                this,
                { _, year, month, day ->
                    val selectedDate = "$day/${month + 1}/$year"
                    Toast.makeText(this, "Tanggal: $selectedDate", Toast.LENGTH_SHORT).show()
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.show()
        }

        btnTime.setOnClickListener {
            val calendar = Calendar.getInstance()
            val timePicker = TimePickerDialog(
                this,
                { _, hour, minute ->
                    val selectedTime = String.format("%02d:%02d", hour, minute)
                    Toast.makeText(this, "Waktu: $selectedTime", Toast.LENGTH_SHORT).show()
                },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true
            )
            timePicker.show()
        }

        btnAlert.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah kamu yakin ingin melanjutkan?")
                .setPositiveButton("Ya") { _, _ ->
                    Toast.makeText(this, "Kamu memilih YA", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

        btnToast.setOnClickListener {
            val phone = phoneInput.text.toString()
            if (phone.isNotBlank()) {
                Toast.makeText(this, "Nomor HP: $phone", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Isi dulu nomor HP-nya bro!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
