package sundaystudy.kr.usedcar.module.usedcar.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "insurance")
class Insurance(
    @Column(name = "is_loss")
    val isLoss: Boolean,

    @Column(name = "is_steal")
    val isSteal: Boolean,

    @Column(name = "is_water")
    val isWater: Boolean,

    @Column(name = "is_rent")
    val isRent: Boolean,

    @Column(name = "is_sales")
    val isSales: Boolean,

    @Column(name = "is_public")
    val isPublic: Boolean,

    @OneToMany(mappedBy = "insurance", cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    var unsubscribed: MutableList<Unsubscribed> = mutableListOf(),

    @OneToMany(mappedBy = "insurance", cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    var ownerAccident: MutableList<OwnerAccident> = mutableListOf(),

    @OneToMany(mappedBy = "insurance", cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    var opponentAccident: MutableList<OpponentAccident> = mutableListOf(),

    @OneToMany(mappedBy = "insurance", cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    var changeOwner: MutableList<ChangeOwner> = mutableListOf(),

    @OneToMany(mappedBy = "insurance", cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    var changeNumber: MutableList<ChangeNumber> = mutableListOf(),

    @OneToOne(mappedBy = "insurance")
    var usedCar: UsedCar
) {

    fun addOwnerAccident(extraOwnerAccident: OwnerAccident) {
        this.ownerAccident.add(extraOwnerAccident)
    }

    fun addOpponentAccident(extraOpponentAccident: OpponentAccident) {
        this.opponentAccident.add(extraOpponentAccident)
    }

    fun addUnsubscribed(extraUnsubscribed: Unsubscribed) {
        this.unsubscribed.add(extraUnsubscribed)
    }

    @Id
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()

    init {
        unsubscribed.map { it.insurance = this }
        ownerAccident.map { it.insurance = this }
        opponentAccident.map { it.insurance = this }
        changeNumber.map { it.insurance = this }
        changeOwner.map { it.insurance = this }
        usedCar.organizeInsurance(this)
    }
}
