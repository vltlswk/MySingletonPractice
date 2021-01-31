package com.example.mysingletonpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // 싱글톤이 아닌경우 인스턴스가 다르기 때문에 메모리에 다르게 올라감 즉 다른값
        val myNormalClass1 = MyNormalClass()
        val myNormalClass2 = MyNormalClass()

        Log.d(TAG, "myNormalClass1 : " + myNormalClass1)
        Log.d(TAG, "myNormalClass2 : " + myNormalClass2)

        // object로 생성한 싱글톤 클래스를 사용
        // 1과 2의 주소가 같음 즉 같은 얘를 가르키고있다.
        val mySingletonClass1 = MySingletonClass
        val mySingletonClass2 = MySingletonClass

        Log.d(TAG, "mySingletonClass1 : " + mySingletonClass1)
        Log.d(TAG, "mySingletonClass2 : " + mySingletonClass2)

        // 위의 경우들은 매개변수가 없을때기 때문에 간단히 구현이 가능하다.


        // 이런 경우는 하나만 생성해서 만드는게 메모리에서 이득이기때문에 싱글톤으로 구현해야한다.
        val mySQLOpenHelper_1 = MySQLOpenHelper(this)
        val mySQLOpenHelper_2 = MySQLOpenHelper(this)
        Log.d(TAG, "mySqlOpenHelp_1 : " + mySQLOpenHelper_1)
        Log.d(TAG, "mySqlOpenHelp_2 : " + mySQLOpenHelper_2)


        //싱글톤으로 구현한 mySQLOpenHelperSingleton
        val mySQLOpenHelperSingleton_1 = MySQLOpenHelperSingleton.getInstance(this)
        val mySQLOpenHelperSingleton_2 = MySQLOpenHelperSingleton.getInstance(this)
        Log.d(TAG, "mySQLOpenHelperSingleton_1 : " + mySQLOpenHelperSingleton_1)
        Log.d(TAG, "mySQLOpenHelperSingleton_2 : " + mySQLOpenHelperSingleton_2)
    }
}