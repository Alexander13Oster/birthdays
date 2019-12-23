package com.magnox.birthdays.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PersonDao {
    @Query("SELECT * FROM personentity")
    fun getAll(): LiveData<List<PersonEntity>>

//    @Query("SELECT * FROM userentity WHERE first IN (:firstNames)")
//    fun loadAllByName(firstNames: Array<String>): LiveData<List<UserEntity>>

    @Query("SELECT * FROM personentity WHERE uid IN (:ids)")
    fun loadAllById(ids: Array<Int>): LiveData<List<PersonEntity>>

    @Query("SELECT * FROM personentity WHERE firstName LIKE :firstName AND lastName LIKE :lastName LIMIT 1")
    fun findByName(firstName: String, lastName: String): PersonEntity

    @Insert
    fun insert(person: PersonEntity)

    @Insert
    fun insertAll(persons: List<PersonEntity>)

    @Update
    fun update(person: PersonEntity)

    @Delete
    fun delete(person: PersonEntity)
}