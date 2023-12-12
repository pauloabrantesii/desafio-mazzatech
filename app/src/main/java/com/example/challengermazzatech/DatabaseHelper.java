package com.example.challengermazzatech;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "app_database";


    private static final int DATABASE_VERSION = 1;


    private static final String TABLE_USER = "User";


    private static final String COL_ID = "id";
    private static final String COL_NOME = "nome";
    private static final String COL_USERNAME = "username";
    private static final String COL_EMAIL = "email";
    private static final String COL_PASSWORD = "password";
    private static final String COL_FOTO = "foto";
    private static final String COL_ENDERECO = "endereco";
    private static final String COL_DATA_NASCIMENTO = "data_nascimento";
    private static final String COL_SEXO = "sexo";
    private static final String COL_TIPO = "tipo";
    private static final String COL_CPF = "cpf";


    private static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_NOME + " TEXT,"
            + COL_USERNAME + " TEXT,"
            + COL_EMAIL + " TEXT,"
            + COL_PASSWORD + " TEXT,"
            + COL_FOTO + " TEXT,"
            + COL_ENDERECO + " TEXT,"
            + COL_DATA_NASCIMENTO + " TEXT,"
            + COL_SEXO + " TEXT,"
            + COL_TIPO + " TEXT,"
            + COL_CPF + " TEXT"
            + ")";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean checkUserLogged(String email, String passoword) {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {COL_PASSWORD};

//        String selection = COL_EMAIL + "=? AND " + COL_PASSWORD + " IS NOT NULL";

        String query = "SELECT * FROM " + TABLE_USER + " WHERE " + COL_EMAIL + " = ? AND " + COL_PASSWORD + " = ?";
        String[] selectionArgs = {email, passoword};
        Cursor cursor = db.rawQuery(query, new String[]{email});
//        Cursor cursor = db.query(
//                TABLE_USER,
//                columns,
//                selection,
//                selectionArgs,
//                null,
//                null,
//                null
//        );

        boolean isLogged = cursor != null && cursor.getCount() == 0;

//        if (cursor != null) {
//            cursor.close();
//        }
//        db.close();

        return isLogged;
    }

    public long inserirUsuario(Context context, User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM " + TABLE_USER + " WHERE " + COL_USERNAME + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{user.getUsername()});

        if (cursor.getCount() > 0) {
            Toast.makeText(context, "email já cadastrado", Toast.LENGTH_SHORT).show();
            cursor.close();
            return -1;
        } else {
            ContentValues values = new ContentValues();
            values.put(COL_NOME, user.getName());
            values.put(COL_USERNAME, user.getUsername());
            values.put(COL_EMAIL, user.getEmail());
            values.put(COL_ENDERECO, user.getAddress());
            values.put(COL_DATA_NASCIMENTO, user.getAge());
            values.put(COL_SEXO, user.getSex());
            values.put(COL_TIPO, user.getType());
            values.put(COL_CPF, user.getCpf());

            long id = db.insert(TABLE_USER, null, values);
            db.close();

            return id;
        }
    }
}