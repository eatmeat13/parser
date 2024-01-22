package com.example.parser.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import org.hibernate.Hibernate
import java.util.UUID

@Entity
data class Car(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID,
    val name: String,
    val price: Int,
    val year: Int,
) {

    constructor() : this(UUID.randomUUID(), "", 0, 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Car
        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    override fun toString(): String =
        this::class.simpleName + "(id = $id , name = $name , price = $price , year = $year )"

    companion object {
        operator fun invoke(
            id: UUID = UUID.randomUUID(),
            name: String,
            price: Int,
            year: Int,
        ): Car =
            Car(
                id = id,
                name = name,
                price = price,
                year = year,
            )

    }
}
