package com.example.myfantasticbeasts

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "animal_table")
class Animals(@ColumnInfo(name="Animal_name")
              val name: String,
              @PrimaryKey(autoGenerate = true)
              val id: Int
              )
