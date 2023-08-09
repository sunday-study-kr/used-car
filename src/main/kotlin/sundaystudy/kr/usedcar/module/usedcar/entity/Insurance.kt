package sundaystudy.kr.usedcar.module.usedcar.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "insurance")
class Insurance(
    @Column(name = "is_loss")
    val isLoss: Boolean,
    @Column(name ="is_steal")
    val isSteal: Boolean,

    @Column(name = "is_water")
    val isWater: Boolean,

    @Column(name = "is_rent")
    val isRent: Boolean,

    @Column(name = "is_sales")
    val isSales: Boolean,

    @Column(name = "is_public")
    val isPublic: Boolean
) {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()


    @OneToMany(mappedBy = "insurance", cascade = [CascadeType.PERSIST])
    var unsubscribed : MutableList<Unsubscribed> = mutableListOf()

    @OneToMany(mappedBy = "insurance", cascade = [CascadeType.PERSIST])
    var ownerAccident: MutableList<OwnerAccident> = mutableListOf()

    @OneToMany(mappedBy = "insurance", cascade = [CascadeType.PERSIST])
    var opponentAccident: MutableList<OpponentAccident> = mutableListOf()

    @OneToMany(mappedBy = "insurance", cascade = [CascadeType.PERSIST])
    var changeOwner : MutableList<ChangeOwner> = mutableListOf()

    @OneToMany(mappedBy = "insurance", cascade = [CascadeType.PERSIST])
    var changeNumber : MutableList<ChangeNumber> = mutableListOf()

    @OneToOne(mappedBy = "insurance" , cascade = [CascadeType.PERSIST])
    var usedCar : UsedCar? = null

    fun addUnsubscribed(unsubscribed: Unsubscribed){
        this.unsubscribed.add(unsubscribed)
        unsubscribed.insurance = this
    }

    fun addOwnerAccident(ownerAccident: OwnerAccident){
        this.ownerAccident.add(ownerAccident)
        ownerAccident.insurance = this
    }

    fun addOpponentAccident(opponentAccident: OpponentAccident){
        this.opponentAccident.add(opponentAccident)
        opponentAccident.insurance = this
    }

    fun addChangeNumber(changeNumber: ChangeNumber){
        this.changeNumber.add(changeNumber)
        changeNumber.insurance = this
    }

    fun addChangeOwner(changeOwner: ChangeOwner){
        this.changeOwner.add(changeOwner)
        changeOwner.insurance = this
    }
}
