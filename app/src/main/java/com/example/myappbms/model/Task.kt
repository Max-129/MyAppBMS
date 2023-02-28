package com.example.myappbms.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var title: String? = null,
    var descritpion: String? = null
) : Serializable