package com.nexo.tanexo.models

import com.google.gson.annotations.SerializedName

class ResponseMyCourse(
    @SerializedName("error") var error : Boolean,
    @SerializedName("mensaje") var message : String,
    @SerializedName("cursos") var courses_id : List<CourseId>
)

class CourseId(
    @SerializedName("Cursos_id") var course_id : String
)

