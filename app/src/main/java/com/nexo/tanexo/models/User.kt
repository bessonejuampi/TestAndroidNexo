package com.nexo.tanexo.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "user_table")
@Parcelize
class User (

    @ColumnInfo(name = "name") var name : String,
    @ColumnInfo(name = "lastname") var lastName : String,
    @ColumnInfo(name = "email") var email : String,
    @ColumnInfo(name = "pass") var pass : String
) : Parcelable{
    @PrimaryKey(autoGenerate = true) var id : Int=0
}