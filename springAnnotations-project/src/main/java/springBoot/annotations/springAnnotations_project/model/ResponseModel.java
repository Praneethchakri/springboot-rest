package springBoot.annotations.springAnnotations_project.model;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ResponseModel {
	
	private HttpStatus statusCode;
	private String response;

}
