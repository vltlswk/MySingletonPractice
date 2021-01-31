package com.example.mysingletonpractice

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MySQLOpenHelperSingleton private constructor(context: Context) : SQLiteOpenHelper(context, "MyDB",null,1) {

    val TAG: String = "로그"

    companion object{
        // 자기 자신 변수선언
        // Volatile를 사용하면 cpu의 캐시를 거치지 않고 항상 메인 메모리에 가서 항상 최신값을 사용할 수 있다.
        @Volatile private var instance : MySQLOpenHelperSingleton?=null

        //자기 자신 가져오기
        // MySQLOpenHelper가 비어있다면 가져오게한다.
        // DCLP이 적용이 된거다.
        // 이때 쓰레드 A와 B가 있으면 A가 먼저 들어가서 널체크를 한 뒤
        // 락을 획득하고 다시 널체크를 하고 인스턴스를 할당한다.
        // 그 후 B가 들어가서 작업을 하는데 이때 @Volateile를 써서 메모리에 적재되지 않아서 오류가 나는 상황을 막는다.

        fun getInstance(context: Context):MySQLOpenHelperSingleton=
            instance?: synchronized(this){
                instance?: MySQLOpenHelperSingleton(context).also {
                    instance=it
                }
            }
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        TODO("Not yet implemented")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}