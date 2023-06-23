package sundaystudy.kr.usedcar.module.Insurance.Entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
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
    @Column(nullable = false)
    val id: String = UUID.randomUUID().toString()


    @OneToMany(mappedBy = "insurance")
    lateinit var unsubscribed : MutableList<Unsubscribed>
}
