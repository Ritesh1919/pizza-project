package com.React.Entity;




import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.OneToMany;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
    
  @Column(length =20,nullable= false)
  private String name;
  
  @Column(length =40,nullable = false ,unique = true)
  private String email;
  
  @Column(length =20,nullable= false)
  private String password;
  
  @Column(length =100,nullable= false)
  private String address;
  
  @OneToMany
  private List<Order> order;
  
}
