package com.example.parsingfilm.IgorBogdanovskij.presentation.fragments.mainFragment

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.parsingfilm.R

class MyDialog(context: Context):DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val dialog = AlertDialog.Builder(requireContext())
            .setTitle("My First Dialog")
            .setView(R.layout.dialog_main)
            .setPositiveButton("Yes"
            ) { dialog, which -> Toast.makeText(context, "Yes", Toast.LENGTH_SHORT).show() }
            .setNegativeButton("No"){
                dialog, which -> Toast.makeText(context, "No", Toast.LENGTH_SHORT).show()
            }
            .create()


            return dialog
    }
}