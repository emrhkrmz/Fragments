package com.kirmizitech.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    lateinit var replace: Button
    lateinit var backSpace: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replace = findViewById(R.id.buttonReplace)
        backSpace = findViewById(R.id.backSpace)

        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        val firstFragment = FirstFragment()

        fragmentTransaction.add(R.id.frame, firstFragment)

        fragmentTransaction.commit()

        replace.setOnClickListener {

            val secondFragmentManager: FragmentManager = supportFragmentManager
            val secondFragmentTransaction: FragmentTransaction = secondFragmentManager.beginTransaction()

            val secondFragment = SecondFragment()

            secondFragmentTransaction.replace(R.id.frame,secondFragment)

            secondFragmentTransaction.addToBackStack(null)
            //bu yöntem yığını boş çalıştırır
            //yığına eklemez
            //ilk parça kapanmayacak ve eklenecek
            //yeni bir parça açarken eski parçayı yığında tutmak için işlem yapmam gerektiği anlamına gelir
            //MySecondFragment'ta iken geri tuşuna bastığımızda MyFirstFragment yığına eklenir ve MyFirstFragment açılır.
            //MyfirstFragment'ta iken geri tuşuna bastığımız da ise uygulama kapanır.

            secondFragmentTransaction.commit()

        }

        backSpace.setOnClickListener {

            val firstFragmentManager: FragmentManager = supportFragmentManager
            val firstFragmentTransaction: FragmentTransaction = firstFragmentManager.beginTransaction()

            val firstFragment = FirstFragment()

            firstFragmentTransaction.replace(R.id.frame,firstFragment)

            firstFragmentTransaction.commit()

            firstFragmentTransaction.addToBackStack(null)
            /* Kendi tanımlamış olduğumuz Back Space tuşuyla,
            SecondFrafment'tan MyFirstFragment'a geçiş yaptığımızda ise;
            Telefonumuzun geri tuşuna bastığımızda yığına MySecondFragment'ı yüklediği için,
            MySecondFragment sayfasını açacaktır.
            */

        }

    }
}