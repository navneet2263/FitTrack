package com.example.fittrack.Domain

import java.io.Serializable

class Workout(
    var title: String,
    var description: String,
    var picPath: String,
    var kcal: Int,
    var durationAll: String,
    var lessions: ArrayList<Lession>
) : Serializable
