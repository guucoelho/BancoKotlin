package com.example.registro

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, factory:SQLiteDatabase.CursorFactory?):
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION){

    override fun onCreate(db:SQLiteDatabase){
    val query = ("CREATE TABLE aluno("
            + ID_COL + " INTEGER PRIMARY KEY," +
            NAME_COl + " TEXT," +
            CPF + " TEXT," +
            EMAIL + " TEXT,"+
            CELULAR + " TEXT)")
    db.execSQL(query)
}
    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun addName(name : String, cpf : String, email: String, celular:String ){


        val values = ContentValues()
        values.put(NAME_COl, name)
        values.put(CPF, cpf)
        values.put(EMAIL,email)
        values.put(CELULAR, celular)

        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }


    fun getName(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null)
    }

    companion object{
        private val DATABASE_NAME = "CadastroAlunos"
        private val DATABASE_VERSION = 1
        val TABLE_NAME = "aluno"
        val ID_COL = "id"
        val NAME_COl = "name"
        val CPF = "cpf"
        val EMAIL = "email"
        val CELULAR = "celular"
    }
}