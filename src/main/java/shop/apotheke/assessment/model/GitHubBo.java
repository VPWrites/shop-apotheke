package shop.apotheke.assessment.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GitHubBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4283244083609257126L;

	private Long totalCount;
	private boolean incompleteResults;
	private List<ItemBo> items;
}
