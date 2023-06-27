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
    lateinit var unsubscribed : MutableList<Unsubscribed>

    @OneToMany(mappedBy = "insurance")
    lateinit var ownerAccident: MutableList<OwnerAccident>

    @OneToMany(mappedBy = "insurance")
    lateinit var opponentAccident: MutableList<OpponentAccident>

    @OneToMany(mappedBy = "insurance")
    lateinit var changeOwner : MutableList<ChangeOwner>

    @OneToMany(mappedBy = "insurance")
    lateinit var changeNumber : MutableList<ChangeNumber>

    @OneToOne(mappedBy = "insurance")
    lateinit var usedCar : UsedCar
}
