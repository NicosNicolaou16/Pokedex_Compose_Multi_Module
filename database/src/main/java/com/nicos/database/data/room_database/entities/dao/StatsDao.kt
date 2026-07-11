package com.nicos.database.data.room_database.entities.dao

import androidx.room3.Dao
import androidx.room3.Query
import androidx.room3.Transaction
import com.nicos.database.data.room_database.entities.StatsEntity
import com.nicos.database.data.room_database.init_database.BaseDao

@Dao
interface StatsDao : BaseDao<StatsEntity, MutableList<StatsEntity>> {

    @Transaction
    @Query("SELECT * FROM statsentity WHERE pokemonName=:name")
    suspend fun getPokemonStatsByName(name: String): MutableList<StatsEntity>

    @Transaction
    @Query("DELETE FROM statsentity WHERE pokemonName=:name")
    suspend fun deleteByPokemonName(name: String)

    @Transaction
    @Query("DELETE FROM statsentity")
    suspend fun deleteAll()
}