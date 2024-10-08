package com.nicos.database.data.room_database.entities.daos

import androidx.room.Dao
import androidx.room.Query
import com.nicos.database.data.room_database.entities.StatsEntity
import com.nicos.database.data.room_database.init_database.BaseDao

@Dao
interface StatsDao : BaseDao<StatsEntity, MutableList<StatsEntity>> {

    @Query("SELECT * FROM statsentity WHERE pokemonName=:name")
    suspend fun getPokemonStatsByName(name: String): StatsEntity?

    @Query("DELETE FROM statsentity")
    suspend fun deleteAll()
}