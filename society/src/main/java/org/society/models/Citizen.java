package org.society.models;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * this class define an Citizen (model) with its proprieties
 * @author Ayoub benHaimoud
 * @since 10/3/2020
 */

@Entity
//@Table(name = "citizens")
@Data @ToString
@AllArgsConstructor @NoArgsConstructor
public class Citizen {

   // @ApiModelProperty(name="id", value="The id of the citizen", example="1")
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    //@ApiModelProperty(name="FirstName", value="The FirstName of the citizen", example="Ayoub")

    private String FirstName;
    //@ApiModelProperty(name="lastName", value="The lastName of the citizen", example="Ben")
    //@NonNull
    //@Column(nullable = false , name = "lastName")
    private String lastName;
    //@ApiModelProperty(name="CNI", value="The CNI of the citizen", example="JH8978")
    //@NonNull
    //@Column(nullable = false , name = "CNI")
    private String CNI;
    //@ApiModelProperty(name="age", value="The age of the citizen", example="45")
    //@NonNull
    //@Column(nullable = false , name = "age")
    private int age;
    //@ApiModelProperty(name="phone", value="The phone of the citizen", example="0687987878")
    //@NonNull
    //@Column(nullable = false , name = "phone")
    private String phone;
    //@ApiModelProperty(name="email", value="The email of the citizen", example="ben@gmail.com")
    //@NonNull
   // @Column(nullable = false , name = "email")
    private String email;
    //@ApiModelProperty(name="code", value="The code of the citizen counter ", example="Ayoub")
    //@NonNull
    //@Column(nullable = false , name = "code")
    private String code;

}