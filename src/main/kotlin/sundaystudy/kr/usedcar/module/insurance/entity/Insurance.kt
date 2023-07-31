package sundaystudy.kr.usedcar.module.insurance.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import sundaystudy.kr.usedcar.module.post.entity.UsedCar
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


    @OneToMany(mappedBy = "insurance")
    var unsubscribed : MutableList<Unsubscribed> = mutableListOf()

    @OneToMany(mappedBy = "insurance")
    var ownerAccident: MutableList<OwnerAccident> = mutableListOf()

    @OneToMany(mappedBy = "insurance")
    var opponentAccident: MutableList<OpponentAccident> = mutableListOf()

    @OneToMany(mappedBy = "insurance")
    var changeOwner : MutableList<ChangeOwner> = mutableListOf()

    @OneToMany(mappedBy = "insurance")
    var changeNumber : MutableList<ChangeNumber> = mutableListOf()

    @OneToOne(mappedBy = "insurance")
    var usedCar : UsedCar? = null
}
