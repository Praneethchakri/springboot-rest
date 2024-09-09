package springBoot.annotations.springAnnotations_project.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class BusinessUser {
	
	private int userId;
	private String userName;
	private String userDesignation;
	
		

}
