package com.example.demo1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.widget.AbsSpinner

//upload image
class MainActivity2 : AppCompatActivity() {
    // One Button

    // One Preview Image
    var IVPreviewImage: ImageView? = null
    var imageImage = false

    // constant to compare
    // the activity result code
    var SELECT_PICTURE = 200
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // register the UI widgets with their appropriate IDs
        val BSelectImage : Button = findViewById(R.id.BSelectImage)
        val image : ImageView = findViewById(R.id.IVPreviewImage)
        val button : Button = findViewById(R.id.button2)
        val home : Button = findViewById(R.id.button)
        IVPreviewImage = findViewById(R.id.IVPreviewImage)

        image.setImageResource(R.drawable.upload)

        // handle the Choose Image button to trigger
        // the image chooser function
        BSelectImage.setOnClickListener(View.OnClickListener { imageChooser() })
        button.setOnClickListener {
            if (imageImage) {
                Toast.makeText(this,"Uploaded image", Toast.LENGTH_SHORT).show()
                imageImage = false
                image.setImageResource(R.drawable.upload)
            } else {
                Toast.makeText(this,"No image selected", Toast.LENGTH_SHORT).show()
            }

        }
        home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }


    // this function is triggered when
    // the Select Image Button is clicked
    fun imageChooser() {

        // create an instance of the
        // intent of the type image
        val i = Intent()
        i.setType("image/*")
        i.setAction(Intent.ACTION_GET_CONTENT)

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE)
    }

    // this function is triggered when user
    // selects the image from the imageChooser
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                val selectedImageUri = data!!.data
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    IVPreviewImage!!.setImageURI(selectedImageUri)
                    imageImage = true
                }
            }
        }
    }
}

