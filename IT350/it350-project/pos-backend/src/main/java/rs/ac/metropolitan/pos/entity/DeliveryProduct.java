package rs.ac.metropolitan.pos.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "delivery_product")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class DeliveryProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "delivery_product_id")
    private Integer id;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne
    private Product product;
    @JoinColumn(name = "delivery_id", referencedColumnName = "delivery_id")
    @ManyToOne
    private Delivery delivery;
    @Column(name = "products_number")
    private Integer productsNumber;
}
