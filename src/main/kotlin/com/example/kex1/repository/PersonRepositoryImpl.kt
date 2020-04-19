package com.example.kex1.repository

import com.example.kex1.entity.Address
import com.example.kex1.entity.Card
import com.example.kex1.entity.Person
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import kotlin.text.StringBuilder

@Repository
class PersonRepositoryImpl : PersonRepository {

    @PersistenceContext
    lateinit var em:EntityManager;

    override fun getCardByCpf(cpf: String): List<Card>? {

        val query = em.createNativeQuery(""" SELECT AA.id, aa.number, aa.type, aa.person_id
                                                        FROM CARD AA
                                                        INNER JOIN PERSON BB ON AA.PERSON_ID = BB.ID
                                                        WHERE BB.CPF = ? """ , Card::class.java)
                .setParameter(1, cpf)

        return query.resultList as List<Card>?
    }

    override fun getAddressByCpf(cpf: String): List<Address?> {
        return emptyList();
    }

    override fun getPersonByCpf(cpf: String): Person {
        TODO()
    }

    override fun save(person: Person) {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Person>? {
        var builder:StringBuilder = StringBuilder("SELECT AA.* FROM PERSON AA ")
        val query = em.createNativeQuery(builder.toString())
        return query.resultList as List<Person>?
    }


}