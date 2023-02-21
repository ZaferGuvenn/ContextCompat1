package com.lafimsize.contextcompat

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.lafimsize.contextcompat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val permission=ContextCompat.checkSelfPermission(this@MainActivity,android.Manifest.permission.CAMERA)


        if (permission== PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this,"İzin verilmiştir!",Toast.LENGTH_SHORT).show()

        }else{
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA),1)
        }


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        println("***********")
        println(requestCode)
        println(permissions)
        println(grantResults)
        println("***********")
        val permission=ContextCompat.checkSelfPermission(this@MainActivity,android.Manifest.permission.CAMERA)

        if (permission==PackageManager.PERMISSION_DENIED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,android.Manifest.permission.CAMERA)){
                Toast.makeText(this,"Kamera izni reddedildi!",Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(this,"Kamera iznini artık ayarlardan açmalısın! Bir daha sorulmayacak.",Toast.LENGTH_SHORT).show()
            }

            return//else yazmamak için yapılabilir
        }

        Toast.makeText(this,"İzin verildi!",Toast.LENGTH_SHORT).show()



    }


}