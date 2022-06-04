package com.nexo.tanexo.models

import com.google.gson.annotations.SerializedName

class ResponseCourse(
    @SerializedName("cursos") var listCourses : List<Course>
) {
}