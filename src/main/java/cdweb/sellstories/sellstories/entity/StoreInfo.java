package cdweb.sellstories.sellstories.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "store_info")
public class StoreInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false)
    private Long id;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "hotline_support")
    private String hotlineSupport;

    @Column(name = "branch_name")
    private String branchName;

    @Column(name = "phone_contact")
    private String phoneContact;


}
