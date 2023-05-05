package com.example.preguntados

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class MyBDOpenHelper(contex: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(contex, DATABASE_NAME, factory, DATABASE_VERSION) {

    val TAG = "SQLite"

    companion object {
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "Quizz"
        val TABLA_PREGUNTAS = "pregunta"
        val PREGUNTA_ID_ = "id"
        val PREGUNTA_TEXTO = "texto"
        val RESPUESTA1 = "respuesta1"
        val RESPUESTA2 = "respuesta2"
        val RESPUESTA3 = "respuesta3"
        val RESPUESTA4 = "respuesta4"
    }

    //para recrear las base de datos es necesarios borrar los ficheros sobre /data/data/Preguntados.aplicacion/databases
    override fun onCreate(db: SQLiteDatabase?) {

        //Crear tabla
        try {
            var crearTablaPreguntas = "CREATE TABLE $TABLA_PREGUNTAS " +
                    "($PREGUNTA_ID_ INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$PREGUNTA_TEXTO TEXT," +
                    "$RESPUESTA1 TEXT," +
                    "$RESPUESTA2 TEXT," +
                    "$RESPUESTA3 TEXT," +
                    "$RESPUESTA4 TEXT)"

            var insertarPregunta =
                "INSERT INTO $TABLA_PREGUNTAS ( $PREGUNTA_TEXTO, $RESPUESTA1, $RESPUESTA2, $RESPUESTA3, $RESPUESTA4) " +
                        "VALUES ( '¿Cómo se llama el planeta más cercano al sol?', 'Tierra', 'Marte', 'Mercurio', 'Urano');"


            db!!.execSQL(crearTablaPreguntas)
            db!!.execSQL(insertarPregunta)

        } catch (e: SQLiteException) {
            Log.e("$TAG (onCreate)", e.message.toString())
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        try {
            val dropTablaPreguntas = "DROP TABLE IF EXISTS $TABLA_PREGUNTAS"
            db!!.execSQL(dropTablaPreguntas)
            onCreate(db)
        } catch (e: SQLiteException) {
            Log.e("$TAG (onUpgrade)", e.message.toString())
        }
    }

    override fun onOpen(db: SQLiteDatabase?) {
        super.onOpen(db)
        Log.e("$TAG (onOpen)", "Base de datos abierta")

    }

    fun Pregunta(
        texto: String,
        respuesta1: String,
        respuesta2: String,
        respuesta3: String,
        respuesta4: String, ) {

        val db = this.writableDatabase

        val data = ContentValues()
        data.put(PREGUNTA_TEXTO, texto)
        data.put(RESPUESTA1, respuesta1)
        data.put(RESPUESTA2, respuesta2)
        data.put(RESPUESTA3, respuesta3)
        data.put(RESPUESTA4, respuesta4)

        db.insert(TABLA_PREGUNTAS, null, data)
        db.close()


    }

    fun obtenerPregunta(): Cursor {
        val db = this.readableDatabase
        var cursor = db.rawQuery(
            "SELECT" +
                    " pregunta.${MyBDOpenHelper.PREGUNTA_ID_} ," +
                    " pregunta.${MyBDOpenHelper.PREGUNTA_TEXTO} ," +
                    " pregunta.${MyBDOpenHelper.RESPUESTA1} ," +
                    " pregunta.${MyBDOpenHelper.RESPUESTA2} ," +
                    " pregunta.${MyBDOpenHelper.RESPUESTA3} ," +
                    " pregunta.${MyBDOpenHelper.RESPUESTA4} " +
                    " FROM ${MyBDOpenHelper.TABLA_PREGUNTAS}",
            null
        )
        return cursor
    }
}