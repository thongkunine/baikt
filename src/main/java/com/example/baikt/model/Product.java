package com.example.baikt.model;
import jakarta.persistence.*;
        import lombok.*;

        import java.math.BigInteger;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NHANVIEN")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String Phai;
    private  String  Ma_NV;
    private String Ten_NV;
    private double Luong;
    private String Noi_Sing;
    private String ImageUrl ;

    private BigInteger quantity;
    @ManyToOne
    @JoinColumn(name = "Category_id", nullable = false)
    private Category category;
}
