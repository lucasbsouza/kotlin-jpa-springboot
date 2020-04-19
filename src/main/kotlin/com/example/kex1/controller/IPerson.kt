package com.example.kex1.controller

import com.example.kex1.entity.Address
import com.example.kex1.entity.Card
import com.example.kex1.entity.Person
import org.springframework.stereotype.Component
import java.util.*
import kotlin.collections.ArrayList

@Component
interface IPerson {

    fun findByDocument(document: String): Optional<Person>
    fun getCard(document: String): Optional<ArrayList<Card>>
    fun getAddress(document: String): Optional<ArrayList<Address>>
    fun updatePerson(person:Person)
    fun deletePerson(document: String)
    fun deleteCard(document: String)
}