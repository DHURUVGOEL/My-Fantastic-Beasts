package com.example.myfantasticbeasts


import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

import com.example.myfantasticbeasts.databinding.ActivityLoginBinding

import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.FirebaseUser
//import com.google.firebase.firestore.ktx.firestore
//import com.google.firebase.ktx.Firebase


class LoginActivity : AppCompatActivity() {
//    private lateinit var editUsername: EditText
//    private lateinit var editemailid:EditText
//    private lateinit var editPassword:EditText
//    private lateinit var btnlogin:Button
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
//    private lateinit var firebaseUser: FirebaseUser
//    private val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        editUsername = findViewById(R.id.editUsername)
//        editemailid = findViewById(R.id.editemailid)
//        editPassword = findViewById(R.id.editPassword)
//        btnlogin = findViewById(R.id.btnlogin)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.backButton.setOnClickListener {
            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
        }
        binding.donthaveanaccount.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnlogin.setOnClickListener {
            val email = binding.editemailid.text.toString()
            val pass = binding.editPassword.text.toString()
            val username = binding.editUsername.text.toString()


//            val userMap = hashMapOf(
//                "Name" to username,
//                "EmailId" to email,
//                "Password" to pass,
//            )
//
//            val userId = FirebaseAuth.getInstance().currentUser!!.uid
//             db.collection("user").document(userId).set(userMap)
//                 .addOnSuccessListener {
//                     Toast.makeText(this,"Successfull Login!",Toast.LENGTH_SHORT).show()
////                     editUsername.text.clear()
////                     editemailid.text.clear()
////                     editPassword.text.clear()
//                 }
//                 .addOnFailureListener{
//                     Toast.makeText(this,"Failed!",Toast.LENGTH_SHORT).show()
//
//                 }

            if (username.isNotEmpty() && email.isNotEmpty() && pass.isNotEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }
        }
        binding.ForgetPassword.setOnClickListener {
//            val builder = AlertDialog.Builder(this)
//            val view = layoutInflater.inflate(R.layout.dialog_forget, null)
            val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this)
            val dialogView: View = LayoutInflater.from(this).inflate(R.layout.dialog_forget, null)
            val userEmail = dialogView.findViewById<EditText>(R.id.edit_email)


            alertDialog.setView(dialogView)
            val dialog = alertDialog.create()

            dialogView.findViewById<Button>(R.id.btnreset).setOnClickListener {
                compareEmail(userEmail)
                dialog.dismiss()
            }
            dialogView.findViewById<Button>(R.id.btnCancel).setOnClickListener {
                dialog.dismiss()
            }
            if (dialog.window != null) {
                dialog.window!!.setBackgroundDrawable(ColorDrawable(0))
            }
            dialog.show()
        }
    }

    private fun compareEmail(email: EditText) {
        if (email.text.toString().isEmpty()) {
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()) {
            return
        }

        firebaseAuth.sendPasswordResetEmail(email.text.toString()).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "Check your Email", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}