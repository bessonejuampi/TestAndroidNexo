package com.nexo.tanexo.viewmodels

import androidx.lifecycle.ViewModel
import com.nexo.tanexo.models.Event

class EventViewModel : ViewModel() {
    val event1 = Event("Puertas Abiertas", "Jornada educativa", "UTN FR San Francisco")
    val event2 = Event("La Cerveza", "Jornada informativo", "Creveza Medalla")
    var listEvent : List<Event> = listOf(event1, event2)

}