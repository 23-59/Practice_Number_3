package com.example.practice_number_3.Domain.util

sealed class AddScreenEvents {
    data class EnteredTitle(val title:String):AddScreenEvents()
    data class EnteredDescription(val description:String):AddScreenEvents()
    data object  Save:AddScreenEvents()
}