package com.example.kex1.repository

import com.example.kex1.entity.Address
import com.example.kex1.entity.Card
import com.example.kex1.entity.Person
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository {

    fun getCardByCpf(cpf: String): List<Card>?
    fun getAddressByCpf(cpf: String): List<Address?>
    fun getPersonByCpf(cpf: String): Person
    fun save(person: Person)
    fun findAll(): List<Person>?
}