package com.nexo.tanexo.viewmodels.database.dao

import androidx.room.*
import com.nexo.tanexo.models.User
import io.reactivex.Observable

@Dao
interface UserDao {
    @Query("SELECT * FROM user_table WHERE email = (:email) AND pass=(:pass) ")
    fun loginUser(email:String, pass:String):User

    @Insert
    fun insertUser(user: User?)

    @Update
    fun updateUser(user: User?)

    @Delete
    fun deleteUser(user: User?)
}