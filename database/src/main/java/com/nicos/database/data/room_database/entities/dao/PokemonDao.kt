package com.nicos.database.data.room_database.entities.dao

import androidx.room3.Dao
import androidx.room3.Query
import androidx.room3.Transaction
import com.nicos.database.data.room_database.entities.PokemonEntity
import com.nicos.database.data.room_database.init_database.BaseDao

@Dao
interface PokemonDao : BaseDao<PokemonEntity, MutableList<PokemonEntity>> {

    @Transaction
    @Query("SELECT * FROM pokemonentity ORDER BY `order` ASC")
    suspend fun getAllPokemon(): MutableList<PokemonEntity>

    @Transaction
    @Query("SELECT * FROM pokemonentity WHERE name=:name")
    suspend fun getPokemonByName(name: String): PokemonEntity?
}