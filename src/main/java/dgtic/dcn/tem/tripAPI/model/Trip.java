package dgtic.dcn.tem.tripAPI.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@Getter 
@Setter
@ToString
@EqualsAndHashCode(of = "idTrip")
@Document(collection="trips")
public class Trip {
	
	@Id
	private String idTrip;
	
	private String nameTrip;
	
	private String description;
	
	private String destination;
	
	private LocalDate startDate;
	
	private LocalDate endDate; 
	
	private String otherDetails; 
	
}
