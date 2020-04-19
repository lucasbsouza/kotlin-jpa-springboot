package com.example.kex1.entity

import com.example.kex1.enums.CardType
import com.fasterxml.jackson.annotation.JsonBackReference
import java.io.Serializable
import javax.persistence.*
import kotlin.jvm.Transient

@Entity
data class Card(
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            val id:Long,

            @Column
            var number:String,

            @Enumerated(EnumType.STRING)
            var type:CardType,

            @JsonBackReference
            @JoinColumn
            @ManyToOne(fetch = FetchType.LAZY)
            val person:Person,

            @Transient
            val person_id:Long
) : Serializable
