package com.nicos.database.data.room_database.init_database

import android.content.Context
import androidx.room3.ColumnTypeConverters
import androidx.room3.Database
import androidx.room3.Room
import androidx.room3.RoomDatabase
import com.nicos.database.data.room_database.entities.PokemonDetailsEntity
import com.nicos.database.data.room_database.entities.PokemonEntity
import com.nicos.database.data.room_database.entities.StatsEntity
import com.nicos.database.data.room_database.entities.dao.PokemonDao
import com.nicos.database.data.room_database.entities.dao.PokemonDetailsDao
import com.nicos.database.data.room_database.entities.dao.StatsDao
import com.nicos.database.data.room_database.type_converters.ConverterStats

@Database(
    entities = [PokemonEntity::class, PokemonDetailsEntity::class, StatsEntity::class/*, StatEntity::class*/],
    version = 1,
    exportSchema = false
)
@ColumnTypeConverters(ConverterStats::class/*, ConverterStat::class*/)
abstract class MyRoomDatabase : RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao

    abstract fun pokemonDetailDao(): PokemonDetailsDao

    abstract fun statsDao(): StatsDao

    companion object {
        private const val DB_NAME = "pokemon"
        fun initDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                MyRoomDatabase::class.java,
                DB_NAME
            ).build()
    }
}