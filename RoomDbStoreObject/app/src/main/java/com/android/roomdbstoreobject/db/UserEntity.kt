package com.android.roomdbstoreobject.db

import androidx.room.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "userinfo")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "phone") val phone: String?,
    @ColumnInfo(name = "hobbies") val hobbies: List<Hobbies>
)

data class Hobbies(val hobby: String)


class HobbiesTypeConverter {

    @TypeConverter
    fun listToJson(value: List<Hobbies>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<Hobbies>::class.java).toList()
}

/*
class HobbiesTypeConverter {
    @TypeConverter
    fun fromString(value: String?): ArrayList<String> {

        val listType =object :TypeToken<ArrayList<String>>(){}.type
       return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun frmArrayList(list: ArrayList<String?>): String {
            return Gson().toJson(list)
    }

}*/


