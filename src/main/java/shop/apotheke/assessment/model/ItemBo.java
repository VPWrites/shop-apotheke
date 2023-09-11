package shop.apotheke.assessment.model;

import java.io.Serializable;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ItemBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1363420020813257382L;

	private Long id;
	private String nodeId;
	private String name;
	private String fullName;
	private OwnerBo owner;
	private String htmlUrl;
	private String description;
	private boolean fork;
	private String url;
	private long size;
	private int stargazersCount;
	private int watchersCount;
	private String language;
	private int forksCount;
	private String visibility;
	private int forks;
	private int openIssues;
	private int watchers;
	private float score;

}
